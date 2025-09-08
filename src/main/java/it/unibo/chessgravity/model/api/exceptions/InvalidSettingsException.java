package it.unibo.chessgravity.model.api.exceptions;

/**
 * Cheked exception that handles invalid configuration settings
 */
public class InvalidSettingsException extends Exception {
    
    public InvalidSettingsException() {
        super("Settaggi inseriti non validi");
    }
    
    public InvalidSettingsException(final String message) {
        super(message);
    }
}
