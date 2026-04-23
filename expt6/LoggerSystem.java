

final class Logger {
    private String loggerName;
    private int    logCount;

     Logger(String loggerName) {
        this.loggerName = loggerName;
        this.logCount   = 0;
    }

    public String getLoggerName()              { return loggerName; }
    public int    getLogCount()                { return logCount; }
    public void setLoggerName(String loggerName) { this.loggerName = loggerName; }

    public void logMessage(String level, String message) {
        logCount++;
            System.out.println("[" + loggerName + "] [" + level + "] Log #" + logCount + ": " + message);  }

    

    @Override
    public String toString() {
        return "Logger Name : " + loggerName +
               "\nTotal Logs  : " + logCount;
    }
}



public class LoggerSystem {
    public static void main(String[] args) {
        Logger logger = new Logger("AppLogger");

        logger.logMessage("INFO", "App started");
        logger.logMessage("WARNING", "High memory usage");
        logger.logMessage("ERROR", "Database connection failed");

        System.out.println("\n" + logger);

    }
}
// This will cause a compile-time error because Logger is final.
class AdvancedLogger extends Logger {
    AdvancedLogger(String loggerName) {
        super(loggerName);
    }

    public void logDebug(String message) {
        logMessage("DEBUG", message);
    }
}