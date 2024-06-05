package unirider.platform.carpooling.domain.services;

import unirider.platform.carpooling.domain.model.valueobjects.UniRiderStudentRecordId;
import unirider.platform.carpooling.domain.model.commands.CreateStudentCommand;
import unirider.platform.carpooling.domain.model.commands.UpdateStudentMetricsOnRideOfferedCommand;

public interface StudentCommandService {
    UniRiderStudentRecordId handle(CreateStudentCommand command);
    UniRiderStudentRecordId handle(UpdateStudentMetricsOnRideOfferedCommand command);
}
