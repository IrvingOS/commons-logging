package top.isopen.commons.logging;

/**
 * @author TimeChaser
 * @since 28/7/2022 上午9:44
 */
public class LogException extends RuntimeException {

    private static final long serialVersionUID = -320688659546340315L;

    public LogException() {
        super();
    }

    public LogException(String message) {
        super(message);
    }

    public LogException(String message, Throwable cause) {
        super(message, cause);
    }

    public LogException(Throwable cause) {
        super(cause);
    }

}
