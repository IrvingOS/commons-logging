package top.isopen.commons.logging;

/**
 * @author TimeChaser
 * @see Log#isDebugEnabled() 这类方法存在的意义是，避免在进行了参数拼接之后再去验证是否可以输出，在日志命中率不高的情况下提高了效率
 * @since 1/8/2022 下午4:45
 */
public interface Log {

    void debug(String message);

    void debug(String message, Throwable throwable);

    void debug(String message, Object... args);

    void error(String message, Object... args);

    void error(String message);

    void error(String message, Throwable throwable);

    void info(String message, Object... args);

    void info(String message);

    void info(String message, Throwable throwable);

    boolean isDebugEnabled();

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    void trace(String message, Object... args);

    void trace(String message);

    void trace(String message, Throwable throwable);

    void warn(String message, Object... args);

    void warn(String message);

    void warn(String message, Throwable throwable);

}
