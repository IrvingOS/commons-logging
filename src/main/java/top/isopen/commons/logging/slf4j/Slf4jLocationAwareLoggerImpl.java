package top.isopen.commons.logging.slf4j;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.spi.LocationAwareLogger;
import top.isopen.commons.logging.BaseLog;
import top.isopen.commons.logging.LogFactory;

/**
 * @author TimeChaser
 * @since 28/7/2022 上午9:39
 */
public class Slf4jLocationAwareLoggerImpl extends BaseLog {

    private static final String FQCN = Slf4jImpl.class.getName();
    private static final Marker MARKER = MarkerFactory.getMarker(LogFactory.MARKER);
    private final LocationAwareLogger logger;

    Slf4jLocationAwareLoggerImpl(LocationAwareLogger logger) {
        this.logger = logger;
    }

    @Override
    public void debug(String message) {
        logger.log(MARKER, FQCN, LocationAwareLogger.DEBUG_INT, message, null, null);
    }

    @Override
    public void debug(String message, Throwable throwable) {
        logger.log(MARKER, FQCN, LocationAwareLogger.DEBUG_INT, message, null, throwable);
    }

    @Override
    public void error(String message) {
        logger.log(MARKER, FQCN, LocationAwareLogger.ERROR_INT, message, null, null);
    }

    @Override
    public void error(String message, Throwable throwable) {
        logger.log(MARKER, FQCN, LocationAwareLogger.ERROR_INT, message, null, throwable);
    }

    @Override
    public void info(String message) {
        logger.log(MARKER, FQCN, LocationAwareLogger.INFO_INT, message, null, null);
    }

    @Override
    public void info(String message, Throwable throwable) {
        logger.log(MARKER, FQCN, LocationAwareLogger.INFO_INT, message, null, throwable);
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
        logger.log(MARKER, FQCN, LocationAwareLogger.TRACE_INT, message, null, null);
    }

    @Override
    public void trace(String message, Throwable throwable) {
        logger.log(MARKER, FQCN, LocationAwareLogger.TRACE_INT, message, null, throwable);
    }

    @Override
    public void warn(String message) {
        logger.log(MARKER, FQCN, LocationAwareLogger.WARN_INT, message, null, null);
    }

    @Override
    public void warn(String message, Throwable throwable) {
        logger.log(MARKER, FQCN, LocationAwareLogger.WARN_INT, message, null, throwable);
    }

}
