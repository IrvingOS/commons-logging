package top.isopen.commons.logging.stdout;

import top.isopen.commons.logging.BaseLog;

/**
 * @author TimeChaser
 * @since 12/8/2022 上午9:00
 */
public class StdOutImpl extends BaseLog {

    public StdOutImpl(String clazz) {
    }

    @Override
    public void debug(String message) {
        System.out.println(message);
    }

    @Override
    public void debug(String message, Throwable throwable) {
        System.out.println(message);
        throwable.printStackTrace(System.out);
    }

    @Override
    public void error(String message) {
        System.err.println(message);
    }

    @Override
    public void error(String message, Throwable throwable) {
        System.err.println(message);
        throwable.printStackTrace(System.err);
    }

    @Override
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public void info(String message, Throwable throwable) {
        System.out.println(message);
        throwable.printStackTrace(System.out);
    }

    @Override
    public boolean isDebugEnabled() {
        return true;
    }

    @Override
    public boolean isErrorEnabled() {
        return true;
    }

    @Override
    public boolean isInfoEnabled() {
        return true;
    }

    @Override
    public boolean isTraceEnabled() {
        return true;
    }

    @Override
    public void trace(String message) {
        System.out.println(message);
    }

    @Override
    public void trace(String message, Throwable throwable) {
        System.out.println(message);
        throwable.printStackTrace(System.out);
    }

    @Override
    public void warn(String message) {
        System.out.println(message);
    }

    @Override
    public void warn(String message, Throwable throwable) {
        System.out.println(message);
        throwable.printStackTrace(System.out);
    }

}
