package one.digitalinnovation.vehiclebrandapi.services;

import lombok.AllArgsConstructor;
import one.digitalinnovation.vehiclebrandapi.dto.mapper.VehicleBrandMapper;
import one.digitalinnovation.vehiclebrandapi.dto.request.VehicleBrandDTO;
import one.digitalinnovation.vehiclebrandapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.vehiclebrandapi.entities.VehicleBrand;
import one.digitalinnovation.vehiclebrandapi.exception.VehicleBrandNotFoundException;
import one.digitalinnovation.vehiclebrandapi.repositories.VehicleBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleBrandService {

    private final VehicleBrandRepository vehicleBrandRepository;

    private final VehicleBrandMapper vehicleBrandMapper;

    public MessageResponseDTO create(VehicleBrandDTO vehicleBrandDTO) {
        VehicleBrand vehicleBrand = vehicleBrandMapper.toModel(vehicleBrandDTO);
        VehicleBrand savedVehicleBrand = vehicleBrandRepository.save(vehicleBrand);

        MessageResponseDTO messageResponse = createMessageResponse("Vehicle Brand successfully created with ID ", savedVehicleBrand.getId());

        return messageResponse;
    }

    public VehicleBrandDTO findById(Long id) throws VehicleBrandNotFoundException {
        VehicleBrand vehicleBrand = getVehicleBrandByIdIfExists(id);

        return vehicleBrandMapper.toDTO(vehicleBrand);
    }

    public List<VehicleBrandDTO> listAll() {
        List<VehicleBrand> vehicleBrand = vehicleBrandRepository.findAll();
        return vehicleBrand.stream()
                .map(vehicleBrandMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, VehicleBrandDTO vehicleBrandDTO) throws VehicleBrandNotFoundException {
        getVehicleBrandByIdIfExists(id);

        VehicleBrand updatedVehicleBrand = vehicleBrandMapper.toModel(vehicleBrandDTO);
        VehicleBrand savedVehicleBrand = vehicleBrandRepository.save(updatedVehicleBrand);

        MessageResponseDTO messageResponse = createMessageResponse("Vehicle Brand successfully updated with ID ", savedVehicleBrand.getId());

        return messageResponse;
    }

    public void delete(Long id) throws VehicleBrandNotFoundException {
        getVehicleBrandByIdIfExists(id);
        vehicleBrandRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id) {
        return MessageResponseDTO.builder()
                .message(s + id)
                .build();
    }

    private VehicleBrand getVehicleBrandByIdIfExists(Long id) throws VehicleBrandNotFoundException {
        return vehicleBrandRepository.findById(id)
                .orElseThrow(() -> new VehicleBrandNotFoundException(id));
    }
}
