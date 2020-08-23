package ch.owt.boat.handler;

import ch.owt.boat.entity.BoatAppErrorResponse;
import ch.owt.boat.exception.BoatAppNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BoatRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<BoatAppErrorResponse> handleException(BoatAppNotFoundException ex) {

        // create a BoatErrorResponse
        BoatAppErrorResponse error = new BoatAppErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<BoatAppErrorResponse> handleException(Exception ex) {

        // create a BoatErrorResponse
        BoatAppErrorResponse error = new BoatAppErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
