package unirider.platform.carpooling.interfaces.rest.transform;

import unirider.platform.carpooling.domain.model.aggregates.Student;
import unirider.platform.carpooling.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student student) {
        return new StudentResource(
                student.getStudentRecordId(),
                student.getProfileId()
        );
    }
}
