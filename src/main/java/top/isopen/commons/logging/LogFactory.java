package top.isopen.commons.logging;

import top.isopen.commons.logging.jdk14.Jdk14LoggingImpl;
import top.isopen.commons.logging.log4j2.Log4j2Impl;
import top.isopen.commons.logging.slf4j.Slf4jImpl;
import top.isopen.commons.logging.commons.JakartaCommonsLoggingImpl;
import top.isopen.commons.logging.nologging.NoLoggingImpl;
import top.isopen.commons.logging.stdout.StdOutImpl;

import java.lang.reflect.Constructor;

/**
 * @author TimeChaser
 * @since 28/7/2022 上午9:40
 */
public class LogFactory {

    public static final String MARKER = "MYBATIS";

    private static Constructor<? extends Log> logConstructor;

    static {
        tryImplementation(LogFactory::useSlf4jLogging);
        tryImplementation(LogFactory::useCommonsLogging);
        tryImplementation(LogFactory::useLog4J2Logging);
        tryImplementation(LogFactory::useJdkLogging);
        tryImplementation(LogFactory::useStdOutLogging);
        tryImplementation(LogFactory::useNoLogging);
    }

    private LogFactory() {
    }

    public static Log getLog(Class<?> clazz) {
        return getLog(clazz.getName());
    }

    public static Log getLog(String logger) {
        try {
            return logConstructor.newInstance(logger);
        } catch (Throwable t) {
            throw new LogException("Error creating logger for logger " + logger + ".  Cause: " + t);
        }
    }

    public static void tryImplementation(Runnable runnable) {
        if (logConstructor == null) {
            try {
                runnable.run();
            } catch (Throwable ignored) {
            }
        }
    }

    public static synchronized void useCommonsLogging() {
        setImplementation(JakartaCommonsLoggingImpl.class);
    }

    public static synchronized void useCustomLogging(Class<? extends BaseLog> clazz) {
        setImplementation(clazz);
    }

    public static synchronized void useJdkLogging() {
        setImplementation(Jdk14LoggingImpl.class);
    }

    public static synchronized void useLog4J2Logging() {
        setImplementation(Log4j2Impl.class);
    }

    public static synchronized void useNoLogging() {
        setImplementation(NoLoggingImpl.class);
    }

    public static synchronized void useSlf4jLogging() {
        setImplementation(Slf4jImpl.class);
    }

    public static synchronized void useStdOutLogging() {
        setImplementation(StdOutImpl.class);
    }

    private static void setImplementation(Class<? extends Log> implementation) {
        try {
            Constructor<? extends Log> candidate = implementation.getConstructor(String.class);
            Log log = candidate.newInstance(LogFactory.class.getName());
            if (log.isDebugEnabled()) {
                log.debug("Logging initialized using '" + implementation + "' adapter.");
            }
            logConstructor = candidate;
        } catch (Throwable t) {
            throw new LogException("Error setting Log implementation.  Cause: " + t, t);
        }
    }

}
