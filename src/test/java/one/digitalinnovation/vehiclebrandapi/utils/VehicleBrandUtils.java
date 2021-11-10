package one.digitalinnovation.vehiclebrandapi.utils;

import one.digitalinnovation.vehiclebrandapi.dto.request.VehicleBrandDTO;
import one.digitalinnovation.vehiclebrandapi.entities.VehicleBrand;

import java.time.LocalDate;
import java.util.Collections;

public class VehicleBrandUtils {

    private static final String NAME = "Chevrolet";
    private static final String COUNTRY = "U.S.A";
    private static final long VEHICLE_BRAND_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static VehicleBrandDTO createFakeDTO() {
        return VehicleBrandDTO.builder()
                .name(NAME)
                .country(COUNTRY)
                .birthDate("04-04-2010")
                .vehicleModels(Collections.singletonList(VehicleModelUtils.createFakeDTO()))
                .build();
    }

    public static VehicleBrand createFakeEntity() {
        return VehicleBrand.builder()
                .id(VEHICLE_BRAND_ID)
                .name(NAME)
                .country(COUNTRY)
                .birthDate(BIRTH_DATE)
                .vehicleModels(Collections.singletonList(VehicleModelUtils.createFakeEntity()))
                .build();
    }




}
