package top.isopen.commons.logging;

/**
 * @author TimeChaser
 * @since 28/7/2022 下午5:30
 */
public abstract class BaseLog implements Log {

    @Override
    public void debug(String message, Object... args) {
        FormattedTuple format = MessageFormatter.format(message, args);
        debug(format.getMessage(), format.getThrowable());
    }

    @Override
    public void error(String message, Object... args) {
        FormattedTuple format = MessageFormatter.format(message, args);
        error(format.getMessage(), format.getThrowable());
    }

    @Override
    public void info(String message, Object... args) {
        FormattedTuple format = MessageFormatter.format(message, args);
        info(format.getMessage(), format.getThrowable());
    }

    @Override
    public void trace(String message, Object... args) {
        FormattedTuple format = MessageFormatter.format(message, args);
        trace(format.getMessage(), format.getThrowable());
    }

    @Override
    public void warn(String message, Object... args) {
        FormattedTuple format = MessageFormatter.format(message, args);
        warn(format.getMessage(), format.getThrowable());
    }

}
