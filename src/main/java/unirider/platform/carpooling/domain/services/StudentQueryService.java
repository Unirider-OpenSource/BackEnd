package unirider.platform.carpooling.domain.services;

import unirider.platform.carpooling.domain.model.aggregates.Student;
import unirider.platform.carpooling.domain.model.queries.GetStudentByProfileIdQuery;
import unirider.platform.carpooling.domain.model.queries.GetStudentByUniRiderStudentRecordIdQuery;

import java.util.Optional;

public interface StudentQueryService {
    Optional<Student> handle(GetStudentByProfileIdQuery query);
    Optional<Student> handle(GetStudentByUniRiderStudentRecordIdQuery query);

}
