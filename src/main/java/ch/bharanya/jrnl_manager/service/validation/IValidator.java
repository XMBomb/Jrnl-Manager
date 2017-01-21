package ch.bharanya.jrnl_manager.service.validation;

import java.util.List;

/**
 * Created by XMBomb on 21.01.2017.
 */
public interface IValidator {
    boolean isValid();

    List<ValidationError> getErrorMessages();
}
