package top.isopen.commons.logging.nologging;

import top.isopen.commons.logging.BaseLog;

/**
 * @author TimeChaser
 * @since 28/7/2022 上午11:08
 */
public class NoLoggingImpl extends BaseLog {

    public NoLoggingImpl(String clazz) {
        // Do Nothing
    }

    @Override
    public void debug(String message) {
    }

    @Override
    public void debug(String message, Throwable throwable) {
    }

    @Override
    public void error(String message) {
    }

    @Override
    public void error(String message, Throwable throwable) {
    }

    @Override
    public void info(String message) {
    }

    @Override
    public void info(String message, Throwable throwable) {
    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void trace(String message) {
    }

    @Override
    public void trace(String message, Throwable throwable) {
    }

    @Override
    public void warn(String message) {
    }

    @Override
    public void warn(String message, Throwable throwable) {
    }

}
