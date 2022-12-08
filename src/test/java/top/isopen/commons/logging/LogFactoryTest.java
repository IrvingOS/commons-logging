package top.isopen.commons.logging;

import org.junit.Test;
import top.isopen.commons.logging.commons.JakartaCommonsLoggingImpl;
import top.isopen.commons.logging.jdk14.Jdk14LoggingImpl;
import top.isopen.commons.logging.log4j2.Log4j2Impl;
import top.isopen.commons.logging.nologging.NoLoggingImpl;
import top.isopen.commons.logging.slf4j.Slf4jImpl;

public class LogFactoryTest {


    @Test
    public void test_use_CommonsLogging() {
        LogFactory.useCommonsLogging();
        Log log = LogFactory.getLog(LogFactoryTest.class);
        log.error("CommonsLogging");
        assert log instanceof JakartaCommonsLoggingImpl;
    }

    @Test
    public void test_use_JdkLogging() {
        LogFactory.useJdkLogging();
        Log log = LogFactory.getLog(LogFactoryTest.class);
        log.error("JdkLogging");
        assert log instanceof Jdk14LoggingImpl;
    }

    @Test
    public void test_use_Log4j2Logging() {
        LogFactory.useLog4J2Logging();
        Log log = LogFactory.getLog(LogFactoryTest.class);
        log.error("Log4J2Logging");
        assert log instanceof Log4j2Impl;
    }

    @Test
    public void test_use_NoLogging() {
        LogFactory.useNoLogging();
        Log log = LogFactory.getLog(LogFactoryTest.class);
        log.error("NoLogging");
        assert log instanceof NoLoggingImpl;
    }

    @Test
    public void test_use_Slf4jLogging() {
        LogFactory.useSlf4jLogging();
        Log log = LogFactory.getLog(LogFactoryTest.class);
        log.error("Slf4jLogging");
        assert log instanceof Slf4jImpl;
    }

}
