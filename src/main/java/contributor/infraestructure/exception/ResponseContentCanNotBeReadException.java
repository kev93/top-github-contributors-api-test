package contributor.infraestructure.exception;

public class ResponseContentCanNotBeReadException extends RuntimeException {

    private static final String PREFIX = "ERROR:";

    public ResponseContentCanNotBeReadException(String message){
        super(PREFIX + message);
    }
}
