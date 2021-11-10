package one.digitalinnovation.vehiclebrandapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VehicleModelType {

    CAR("Car"),
    MOTORCYCLE("Motorcycle"),
    BUS("Bus");

    private final String description;
}
