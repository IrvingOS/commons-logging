package top.isopen.commons.logging.log4j2;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import top.isopen.commons.logging.BaseLog;
import top.isopen.commons.logging.LogFactory;

/**
 * @author TimeChaser
 * @since 28/7/2022 上午11:00
 */
public class Log4j2LoggerImpl extends BaseLog {

    private static final Marker MARKER = MarkerManager.getMarker(LogFactory.MARKER);
    private final Logger logger;

    public Log4j2LoggerImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void debug(String message) {
        logger.debug(MARKER, message);
    }

    @Override
    public void debug(String message, Throwable throwable) {
        logger.debug(MARKER, message, throwable);
    }

    @Override
    public void error(String message) {
        logger.error(MARKER, message);
    }

    @Override
    public void error(String message, Throwable throwable) {
        logger.error(MARKER, message, throwable);
    }

    @Override
    public void info(String message) {
        logger.info(MARKER, message);
    }

    @Override
    public void info(String message, Throwable throwable) {
        logger.info(MARKER, message, throwable);
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
        logger.trace(MARKER, message);
    }

    @Override
    public void trace(String message, Throwable throwable) {
        logger.trace(MARKER, message, throwable);
    }

    @Override
    public void warn(String message) {
        logger.warn(MARKER, message);
    }

    @Override
    public void warn(String message, Throwable throwable) {
        logger.warn(MARKER, message, throwable);
    }

}
