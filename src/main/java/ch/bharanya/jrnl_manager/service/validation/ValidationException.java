package ch.bharanya.jrnl_manager.service.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XMBomb on 21.01.2017.
 */
public class ValidationException extends Exception {
    private List<ValidationError> errorMessages = new ArrayList<>();

    public ValidationException(String message, List<ValidationError> errorMessages) {
        super(message);
        this.errorMessages = errorMessages;
    }

    public ValidationException(String message, List<ValidationError> errorMessages, Exception e) {
        super(message, e);
        this.errorMessages = errorMessages;
    }

    public List<ValidationError> getErrorMessages() {
        return errorMessages;
    }
}
