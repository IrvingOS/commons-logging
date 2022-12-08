package top.isopen.commons.logging.jdk14;

import top.isopen.commons.logging.BaseLog;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 在日志中始终输出日志请求类名为 org.apache.ibatis.logging.jdk14.Jdk14LoggingImpl
 *
 * @author TimeChaser
 * @since 28/7/2022 上午11:03
 */
public class Jdk14LoggingImpl extends BaseLog {

    private final Logger logger;

    public Jdk14LoggingImpl(String clazz) {
        logger = Logger.getLogger(clazz);
    }

    @Override
    public void debug(String message) {
        logger.log(Level.FINE, message);
    }

    @Override
    public void debug(String message, Throwable throwable) {
        logger.log(Level.FINE, message, throwable);
    }

    @Override
    public void error(String message) {
        logger.log(Level.SEVERE, message);
    }

    @Override
    public void error(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }

    @Override
    public void info(String message) {
        logger.log(Level.INFO, message);
    }

    @Override
    public void info(String message, Throwable throwable) {
        logger.log(Level.INFO, message, throwable);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isLoggable(Level.FINE);
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isLoggable(Level.SEVERE);
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isLoggable(Level.INFO);
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isLoggable(Level.FINER);
    }

    @Override
    public void trace(String message) {
        logger.log(Level.FINER, message);
    }

    @Override
    public void trace(String message, Throwable throwable) {
        logger.log(Level.FINER, message, throwable);
    }

    @Override
    public void warn(String message) {
        logger.log(Level.WARNING, message);
    }

    @Override
    public void warn(String message, Throwable throwable) {
        logger.log(Level.WARNING, message, throwable);
    }

}
