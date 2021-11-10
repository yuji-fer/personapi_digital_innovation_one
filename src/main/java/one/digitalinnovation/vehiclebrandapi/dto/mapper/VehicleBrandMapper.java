package one.digitalinnovation.vehiclebrandapi.dto.mapper;

import one.digitalinnovation.vehiclebrandapi.dto.request.VehicleBrandDTO;
import one.digitalinnovation.vehiclebrandapi.entities.VehicleBrand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleBrandMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    VehicleBrand toModel(VehicleBrandDTO dto);

    VehicleBrandDTO toDTO(VehicleBrand dto);
}
