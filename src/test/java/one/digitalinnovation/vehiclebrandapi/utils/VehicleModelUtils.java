package one.digitalinnovation.vehiclebrandapi.utils;

import one.digitalinnovation.vehiclebrandapi.dto.request.VehicleModelDTO;
import one.digitalinnovation.vehiclebrandapi.entities.VehicleModel;
import one.digitalinnovation.vehiclebrandapi.enums.VehicleModelType;

public class VehicleModelUtils {

    private static final String NAME = "Opala";
    private static final VehicleModelType VEHICLE_MODEL_TYPE = VehicleModelType.CAR;
    private static final long VEHICLE_MODEL_ID = 1L;

    public static VehicleModelDTO createFakeDTO() {
        return VehicleModelDTO.builder()
                .name(NAME)
                .type(VEHICLE_MODEL_TYPE)
                .build();
    }

    public static VehicleModel createFakeEntity() {
        return VehicleModel.builder()
                .id(VEHICLE_MODEL_ID)
                .name(NAME)
                .type(VEHICLE_MODEL_TYPE)
                .build();
    }
}
