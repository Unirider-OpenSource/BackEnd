package unirider.platform.profiles.domain.model.queries;

import unirider.platform.profiles.domain.model.valueobjects.DriverName;

public record GetDriverByNameQuery(DriverName driverName) {
}
