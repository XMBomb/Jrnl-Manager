package ch.bharanya.jrnl_manager.service.validation;

import ch.bharanya.jrnl_manager.parser.JrnlEntry;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XMBomb on 21.01.2017.
 */
public class JrnlEntryValidator implements IValidator {
    private final JrnlEntry jrnlEntry;
    private List<ValidationError> errorMessages = new ArrayList<>();

    public JrnlEntryValidator(JrnlEntry jrnlEntry) {
        this.jrnlEntry = jrnlEntry;
    }

    @Override
    public boolean isValid() {
        if (jrnlEntry == null) {
            errorMessages.add(new ValidationError("JrnlEntry", "JrnlEntry is null"));
            return false;
        }

        if (StringUtils.isEmpty(jrnlEntry.getTitle())) {
            errorMessages.add(new ValidationError("title", "title is empty"));
            return false;
        }

        if (jrnlEntry.getDate() == null) {
            errorMessages.add(new ValidationError("date", "date is null"));
            return false;
        }

        return true;
    }

    @Override
    public List<ValidationError> getErrorMessages() {
        return errorMessages;
    }
}
