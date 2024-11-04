package hu.novin.probafeladat.invoice_management_system.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameAlreadyTakenException.class)
    public ResponseEntity<ErrorObject> handleUsernameAlreadyTakenException(UsernameAlreadyTakenException exception,
                                                                           WebRequest request) {

        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.CONFLICT.value());
        errorObject.setMessage(exception.getMessage());

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorObject> handleUserNotFoundException(UserNotFoundException exception, WebRequest request) {

        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(exception.getMessage());

        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
    }

}
