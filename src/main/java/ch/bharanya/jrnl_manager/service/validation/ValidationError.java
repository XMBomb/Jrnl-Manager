package ch.bharanya.jrnl_manager.service.validation;

/**
 * Created by XMBomb on 21.01.2017.
 */
public class ValidationError {
    private String fieldName;
    private String errorText;

    public ValidationError(String fieldName, String errorText){
        this.fieldName = fieldName;
        this.errorText = errorText;
    }

    public String getErrorText() {
        return errorText;
    }

    public String getFieldName() {
        return fieldName;
    }
}
