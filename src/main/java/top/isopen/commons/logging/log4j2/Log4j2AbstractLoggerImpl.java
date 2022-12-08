package top.isopen.commons.logging.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.logging.log4j.spi.AbstractLogger;
import org.apache.logging.log4j.spi.ExtendedLoggerWrapper;
import top.isopen.commons.logging.BaseLog;
import top.isopen.commons.logging.LogFactory;

/**
 * @author TimeChaser
 * @since 28/7/2022 上午11:09
 */
public class Log4j2AbstractLoggerImpl extends BaseLog {

    private static final String FQCN = Log4j2Impl.class.getName();
    private static final Marker MARKER = MarkerManager.getMarker(LogFactory.MARKER);
    private final ExtendedLoggerWrapper logger;

    public Log4j2AbstractLoggerImpl(AbstractLogger logger) {
        this.logger = new ExtendedLoggerWrapper(logger, logger.getName(), logger.getMessageFactory());
    }

    @Override
    public void debug(String message) {
        logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, (Message) new SimpleMessage(message), null);
    }

    @Override
    public void debug(String message, Throwable throwable) {
        logger.logIfEnabled(FQCN, Level.DEBUG, MARKER, (Message) new SimpleMessage(message), throwable);
    }

    @Override
    public void error(String message) {
        logger.logIfEnabled(FQCN, Level.ERROR, MARKER, (Message) new SimpleMessage(message), null);
    }

    @Override
    public void error(String message, Throwable throwable) {
        logger.logIfEnabled(FQCN, Level.ERROR, MARKER, (Message) new SimpleMessage(message), throwable);
    }

    @Override
    public void info(String message) {
        logger.logIfEnabled(FQCN, Level.INFO, MARKER, (Message) new SimpleMessage(message), null);
    }

    @Override
    public void info(String message, Throwable throwable) {
        logger.logIfEnabled(FQCN, Level.INFO, MARKER, (Message) new SimpleMessage(message), throwable);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public void trace(String message) {
        logger.logIfEnabled(FQCN, Level.TRACE, MARKER, (Message) new SimpleMessage(message), null);
    }

    @Override
    public void trace(String message, Throwable throwable) {
        logger.logIfEnabled(FQCN, Level.TRACE, MARKER, (Message) new SimpleMessage(message), throwable);
    }

    @Override
    public void warn(String message) {
        logger.logIfEnabled(FQCN, Level.WARN, MARKER, (Message) new SimpleMessage(message), null);
    }

    @Override
    public void warn(String message, Throwable throwable) {
        logger.logIfEnabled(FQCN, Level.WARN, MARKER, (Message) new SimpleMessage(message), throwable);
    }

}
