package ua.zhytariuk.exception;

/**
 * @author (ozhytary)
 */
public class DepartmentNotExistException extends RuntimeException{
    public DepartmentNotExistException() {
    }

    public DepartmentNotExistException(String message) {
        super(message);
    }

    public DepartmentNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
