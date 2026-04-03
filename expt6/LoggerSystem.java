// Q5. Final Class – Logger System

/*
 * WHY is Logger declared final?
 * -----------------------------------------------------------------------
 * A logger is a critical infrastructure component. If it were extendable,
 * a subclass could override logMessage() and silently suppress, alter, or
 * redirect log entries — breaking audit trails, hiding errors, or creating
 * security vulnerabilities. Making it final guarantees that every call to
 * logMessage() always executes the same trusted, unmodified implementation,
 * regardless of where in the codebase it is used.
 * -----------------------------------------------------------------------
 */

final class Logger {
    private String loggerName;
    private int    logCount;

    public Logger(String loggerName) {
        this.loggerName = loggerName;
        this.logCount   = 0;
    }

    // Getters & Setters
    public String getLoggerName()              { return loggerName; }
    public int    getLogCount()                { return logCount; }
    public void setLoggerName(String loggerName) { this.loggerName = loggerName; }

    // Core logging method
    public void logMessage(String level, String message) {
        logCount++;
        System.out.printf("[%s] [%s] Log #%d: %s%n", loggerName, level, logCount, message);
    }

    // Convenience methods
    public void info(String message)    { logMessage("INFO",    message); }
    public void warning(String message) { logMessage("WARNING", message); }
    public void error(String message)   { logMessage("ERROR",   message); }

    @Override
    public String toString() {
        return "Logger Name : " + loggerName +
               "\nTotal Logs  : " + logCount;
    }
}

/*
 * Attempting to extend Logger will cause a COMPILE-TIME ERROR:
 *
 *   class ExtendedLogger extends Logger { }
 *   // ERROR: cannot inherit from final class Logger
 *
 * This is intentional — see explanation above.
 */

public class LoggerSystem {
    public static void main(String[] args) {
        Logger logger = new Logger("AppLogger");

        logger.info("App started");
        logger.warning("High memory usage");
        logger.error("Database connection failed");

        System.out.println("\n" + logger);

        logger.setLoggerName("SystemLogger");
        System.out.println("Renamed logger: " + logger.getLoggerName());
    }
}
