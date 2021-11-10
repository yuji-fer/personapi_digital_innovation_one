package one.digitalinnovation.vehiclebrandapi.controllers;

import lombok.AllArgsConstructor;
import one.digitalinnovation.vehiclebrandapi.dto.request.VehicleBrandDTO;
import one.digitalinnovation.vehiclebrandapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.vehiclebrandapi.exception.VehicleBrandNotFoundException;
import one.digitalinnovation.vehiclebrandapi.services.VehicleBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicleBrand")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleBrandController {

    private final VehicleBrandService vehicleBrandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid VehicleBrandDTO vehicleBrandDTO) {
        return vehicleBrandService.create(vehicleBrandDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VehicleBrandDTO findById(@PathVariable Long id) throws VehicleBrandNotFoundException {
        return vehicleBrandService.findById(id);
    }

    @GetMapping
    public List<VehicleBrandDTO> listAll() {
        return vehicleBrandService.listAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid VehicleBrandDTO vehicleBrandDTO) throws VehicleBrandNotFoundException {
        return vehicleBrandService.update(id, vehicleBrandDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws VehicleBrandNotFoundException {
        vehicleBrandService.delete(id);
    }
}
