package top.isopen.commons.logging.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.AbstractLogger;
import top.isopen.commons.logging.BaseLog;
import top.isopen.commons.logging.Log;

/**
 * 默认的日志输出级别为 ERROR
 *
 * @author TimeChaser
 * @since 28/7/2022 上午10:51
 */
public class Log4j2Impl extends BaseLog {

    private final Log log;

    public Log4j2Impl(String clazz) {
        Logger logger = LogManager.getLogger(clazz);

        if (logger instanceof AbstractLogger) {
            log = new Log4j2AbstractLoggerImpl((AbstractLogger) logger);
        } else {
            log = new Log4j2LoggerImpl(logger);
        }
    }

    @Override
    public void debug(String message) {
        log.debug(message);
    }

    @Override
    public void debug(String message, Throwable throwable) {
        log.debug(message, throwable);
    }

    @Override
    public void error(String message) {
        log.error(message);
    }

    @Override
    public void error(String message, Throwable throwable) {
        log.error(message, throwable);
    }

    @Override
    public void info(String message) {
        log.info(message);
    }

    @Override
    public void info(String message, Throwable throwable) {
        log.info(message, throwable);
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return log.isTraceEnabled();
    }

    @Override
    public void trace(String message) {
        log.trace(message);
    }

    @Override
    public void trace(String message, Throwable throwable) {
        log.trace(message, throwable);
    }

    @Override
    public void warn(String message) {
        log.warn(message);
    }

    @Override
    public void warn(String message, Throwable throwable) {
        log.warn(message, throwable);
    }

}
