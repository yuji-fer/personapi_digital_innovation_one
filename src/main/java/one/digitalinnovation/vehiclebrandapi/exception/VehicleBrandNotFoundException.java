package one.digitalinnovation.vehiclebrandapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleBrandNotFoundException extends Exception {

    public VehicleBrandNotFoundException(Long id) {
        super(String.format("Vehicle Brand with ID %s not found!", id));
    }
}
