package hu.novin.probafeladat.invoice_management_system.exceptions;

public class ErrorObject {

    private Integer statusCode;

    private String message;

    public ErrorObject() {
    }

    public ErrorObject(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
