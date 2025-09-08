package it.unibo.chessgravity.model.api.exceptions;

/**
 * Cheked exception that handles invalid configuration settings
 */
public class InvalidSettingsException extends Exception {
    
    public InvalidSettingsException() {
        super("Found not valid settings");
    }
    
    public InvalidSettingsException(final String message) {
        super(message);
    }
}
