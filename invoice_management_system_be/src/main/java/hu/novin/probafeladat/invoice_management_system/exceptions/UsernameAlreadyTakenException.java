package hu.novin.probafeladat.invoice_management_system.exceptions;

public class UsernameAlreadyTakenException extends RuntimeException {

    public UsernameAlreadyTakenException(String message) {
        super(message);
    }
}
