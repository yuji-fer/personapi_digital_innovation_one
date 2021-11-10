package one.digitalinnovation.vehiclebrandapi.services;

import one.digitalinnovation.vehiclebrandapi.dto.mapper.VehicleBrandMapper;
import one.digitalinnovation.vehiclebrandapi.dto.request.VehicleBrandDTO;
import one.digitalinnovation.vehiclebrandapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.vehiclebrandapi.entities.VehicleBrand;
import one.digitalinnovation.vehiclebrandapi.repositories.VehicleBrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.vehiclebrandapi.utils.VehicleBrandUtils.createFakeDTO;
import static one.digitalinnovation.vehiclebrandapi.utils.VehicleBrandUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleBrandServiceTest {

    @Mock
    private VehicleBrandRepository vehicleBrandRepository;

    @Mock
    private VehicleBrandMapper vehicleBrandMapper;

    @InjectMocks
    private VehicleBrandService vehicleBrandService;

    @Test
    void testGivenVehicleBrandDTOThenReturnSuccessSavedMessage() {
        VehicleBrandDTO vehicleBrandDTO = createFakeDTO();
        VehicleBrand expectedSavedVehicleBrand = createFakeEntity();

        when(vehicleBrandMapper.toModel(vehicleBrandDTO)).thenReturn(expectedSavedVehicleBrand);
        when(vehicleBrandRepository.save(any(VehicleBrand.class))).thenReturn(expectedSavedVehicleBrand);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedVehicleBrand.getId());
        MessageResponseDTO successMessage = vehicleBrandService.create(vehicleBrandDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedVehicleId) {
        return MessageResponseDTO.builder()
                .message("Vehicle Brand successfully created with ID " + savedVehicleId)
                .build();
    }

}
