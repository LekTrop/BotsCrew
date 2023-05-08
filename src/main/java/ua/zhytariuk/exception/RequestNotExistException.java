package ua.zhytariuk.exception;

/**
 * @author (ozhytary)
 */
public class RequestNotExistException extends RuntimeException{
    public RequestNotExistException() {
    }

    public RequestNotExistException(String message) {
        super(message);
    }

    public RequestNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
