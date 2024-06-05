package unirider.platform.carpooling.application.internal.commandservices;

import unirider.platform.carpooling.application.internal.outboundservices.acl.ExternalProfileService;
import unirider.platform.carpooling.domain.model.aggregates.Student;
import unirider.platform.carpooling.domain.model.commands.CreateStudentCommand;
import unirider.platform.carpooling.domain.model.commands.UpdateStudentMetricsOnRideOfferedCommand;
import unirider.platform.carpooling.domain.model.valueobjects.UniRiderStudentRecordId;
import unirider.platform.carpooling.domain.services.StudentCommandService;
import unirider.platform.carpooling.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentCommandServiceImpl implements StudentCommandService {
    private final StudentRepository studentRepository;
    private final ExternalProfileService externalProfileService;

    public StudentCommandServiceImpl(StudentRepository studentRepository, ExternalProfileService externalProfileService) {
        this.studentRepository = studentRepository;
        this.externalProfileService = externalProfileService;
    }

    @Override
    public UniRiderStudentRecordId handle(CreateStudentCommand command) {
        var profileId = externalProfileService.fetchProfileIdByEmail(command.email());
        if (profileId.isEmpty()) {
            profileId = externalProfileService.createProfile(command.firstName(), command.lastName(), command.email(), command.street(), command.number(), command.city(), command.postalCode(), command.country());
        } else {
            studentRepository.findByProfileId(profileId.get()).ifPresent(student -> {
                throw new IllegalArgumentException("student already exists");
            });
        }
        if (profileId.isEmpty()) throw new IllegalArgumentException("Unable to create profile");
        var student = new Student(profileId.get());
        studentRepository.save(student);
        return student.getUniRiderStudentRecordId();
    }

    @Override
    public UniRiderStudentRecordId handle (UpdateStudentMetricsOnRideOfferedCommand command) {
        studentRepository.findByUniRiderStudentRecordId(command.studentRecordId()).map(student ->{
            student.updateMetricsOnRideOffered();
            studentRepository.save(student);
            return student.getUniRiderStudentRecordId();
        }).orElseThrow(() -> new IllegalArgumentException("Student not found"));
        return null;

    }
}
