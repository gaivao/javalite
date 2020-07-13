package org.javalite.activejdbc.validation;

import java.util.Locale;

/**
 * Subclass this class to create custom validators.
 *
 * @author Igor Polevoy
 */
public abstract class ValidatorAdapter implements Validator {
    private String message;
    private boolean pinMessage = false;

    @Override
    public final void setMessage(String message) {
        if(!pinMessage){
            this.message = message;
        }
    }

    /**
     * Provides default implementation, will look for a property in resource bundle, using set message as key.
     * If property in resource bundle not found, treats message verbatim.
     *
     * @param locale locale to use, or null for default locale.
     * @param params parameters in case a message is parametrized.
     * @return formatted message.
     */
    @Override
    public String formatMessage(Locale locale, Object ... params) {
        return Messages.message(message, locale, params);
    }

    public final String getMessage() {
        return message;
    }

    @Override
    public void pinMessage() {
        this.pinMessage = true;
    }
}