package one.digitalinnovation.vehiclebrandapi.dto.mapper;

import one.digitalinnovation.vehiclebrandapi.dto.request.VehicleBrandDTO;
import one.digitalinnovation.vehiclebrandapi.dto.request.VehicleModelDTO;
import one.digitalinnovation.vehiclebrandapi.entities.VehicleBrand;
import one.digitalinnovation.vehiclebrandapi.entities.VehicleModel;
import one.digitalinnovation.vehiclebrandapi.utils.VehicleBrandUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VehicleBrandMapperTest {

    @Autowired
    private VehicleBrandMapper vehicleBrandMapper;

    @Test
    void testGivenVehicleBrandDTOThenReturnVehicleBrandEntity() {
        VehicleBrandDTO vehicleBrandDTO = VehicleBrandUtils.createFakeDTO();
        VehicleBrand vehicleBrand = vehicleBrandMapper.toModel(vehicleBrandDTO);

        assertEquals(vehicleBrandDTO.getName(), vehicleBrand.getName());
        assertEquals(vehicleBrandDTO.getCountry(), vehicleBrand.getCountry());

        VehicleModel vehicleModel = vehicleBrand.getVehicleModels().get(0);
        VehicleModelDTO vehicleModelDTO = vehicleBrandDTO.getVehicleModels().get(0);

        assertEquals(vehicleModelDTO.getType(), vehicleModel.getType());
        assertEquals(vehicleModelDTO.getName(), vehicleModel.getName());
    }

    @Test
    void testGivenVehicleBrandEntityThenReturnVehicleBrandDTO() {
        VehicleBrand vehicleBrand = VehicleBrandUtils.createFakeEntity();
        VehicleBrandDTO vehicleBrandDTO = vehicleBrandMapper.toDTO(vehicleBrand);

        assertEquals(vehicleBrand.getName(), vehicleBrandDTO.getName());
        assertEquals(vehicleBrand.getCountry(), vehicleBrandDTO.getCountry());

        VehicleModel vehicleModel = vehicleBrand.getVehicleModels().get(0);
        VehicleModelDTO vehicleModelDTO = vehicleBrandDTO.getVehicleModels().get(0);

        assertEquals(vehicleModel.getType(), vehicleModelDTO.getType());
        assertEquals(vehicleModel.getName(), vehicleModelDTO.getName());
    }
}
