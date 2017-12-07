package com.yixin.design;

/**
 * Created by zw
 * Creates on 16/4/14.
 * 责任链模式
 * 顾名思义，责任链模式（Chain of Responsibility Pattern）为请求创建了一个接收者对象的链。这种模式给予请求的类型，对请求的发送者和接收者进行解耦。这种类型的设计模式属于行为型模式。
 * 在这种模式中，通常每个接收者都包含对另一个接收者的引用。如果一个对象不能处理该请求，那么它会把相同的请求传给下一个接收者，依此类推。
 */
public class myChain {
    private static AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ErrorLogger( AbstractLogger.ERROR );
        AbstractLogger fileLogger = new FileLogger( AbstractLogger.DEBUG );
        AbstractLogger consoleLogger = new ConsoleLogger( AbstractLogger.INFO );
        errorLogger.setNextLogger( fileLogger );
        fileLogger.setNextLogger( consoleLogger );
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage( AbstractLogger.INFO, "This is an information." );
        loggerChain.logMessage( AbstractLogger.DEBUG, "This is an debug level information." );
        loggerChain.logMessage( AbstractLogger.ERROR, "This is an error information." );
    }
}

/**
 * 创建抽象的记录器类。
 */
abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;
    protected int level; //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write( message );
        }
        if (nextLogger != null) {
            nextLogger.logMessage( level, message );
        }
    }

    abstract protected void write(String message);
}

/**
 * 创建扩展了该记录器类的实体类。
 */
class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println( "Standard Console::Logger: " + message );
    }
}

class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println( "Error Console::Logger: " + message );
    }
}

class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println( "File::Logger: " + message );
    }
}