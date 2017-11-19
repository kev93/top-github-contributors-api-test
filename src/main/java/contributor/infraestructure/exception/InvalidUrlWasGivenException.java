package contributor.infraestructure.exception;

public class InvalidUrlWasGivenException extends RuntimeException {

    private static final String PREFIX = "ERROR:";

    public InvalidUrlWasGivenException(String message){
        super(PREFIX + message);
    }
}
