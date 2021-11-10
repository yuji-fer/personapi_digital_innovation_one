package one.digitalinnovation.vehiclebrandapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleBrandDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    private String birthDate;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String country;

    @Valid
    @NotEmpty
    private List<VehicleModelDTO> vehicleModels;
}
