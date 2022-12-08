package top.isopen.commons.logging;

import java.util.Arrays;

/**
 * Holds the results of formatting done by MessageFormatter
 *
 * @author TimeChaser
 * @since 28/7/2022 下午6:05
 */
public class FormattedTuple {

    private final Object[] args;
    private final String message;
    private final Throwable throwable;

    public FormattedTuple(String message) {
        this(message, null, null);
    }

    public FormattedTuple(String message, Object[] args, Throwable throwable) {
        this.message = message;
        this.args = args;
        this.throwable = throwable;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    @Override
    public String toString() {
        return "FormattedTuple{" + "message='" + message + '\'' + ", args=" + Arrays.toString(args) + ", throwable=" +
               throwable + '}';
    }

}
