package unirider.platform.carpooling.infrastructure.persistence.jpa.repositories;


import unirider.platform.carpooling.domain.model.aggregates.Student;
import unirider.platform.carpooling.domain.model.valueobjects.ProfileId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unirider.platform.carpooling.domain.model.valueobjects.UniRiderStudentRecordId;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByProfileId(ProfileId profileId);
    Optional<Student> findByUniRiderStudentRecordId(UniRiderStudentRecordId studentRecordId);
}
