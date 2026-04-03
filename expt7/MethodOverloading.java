// Q1. Method Overloading – Logger Utility

class Logger {
    private String loggerName;
    private int    totalLogs;

    public Logger(String loggerName) {
        this.loggerName = loggerName;
        this.totalLogs  = 0;
    }

    // Getters & Setters
    public String getLoggerName()               { return loggerName; }
    public int    getTotalLogs()                { return totalLogs; }
    public void   setLoggerName(String name)    { this.loggerName = name; }

    // Overloaded method 1 – only message
    public void log(String message) {
        totalLogs++;
        System.out.println("[" + loggerName + "] LOG: " + message);
    }

    // Overloaded method 2 – message + severity level
    public void log(String message, int level) {
        totalLogs++;
        String severity;
        switch (level) {
            case 1:  severity = "INFO";    break;
            case 2:  severity = "WARNING"; break;
            case 3:  severity = "ERROR";   break;
            default: severity = "DEBUG";
        }
        System.out.println("[" + loggerName + "] [" + severity + "] " + message);
    }

    // Overloaded method 3 – message + custom timestamp
    public void log(String message, String timestamp) {
        totalLogs++;
        System.out.println("[" + loggerName + "] [" + timestamp + "] " + message);
    }

    @Override
    public String toString() {
        return "Logger     : " + loggerName +
               "\nTotal Logs : " + totalLogs;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Logger logger = new Logger("AppLogger");

        System.out.println("=== Overloaded log() calls ===\n");

        // Calls log(String)
        logger.log("Application started.");

        // Calls log(String, int)
        logger.log("Memory usage high.", 2);
        logger.log("Null pointer in PaymentService.", 3);
        logger.log("Config loaded successfully.", 1);

        // Calls log(String, String)
        logger.log("User login detected.", "2025-04-01 10:30:00");
        logger.log("Scheduled backup triggered.", "2025-04-01 11:00:00");

        System.out.println("\n=== Logger Summary ===");
        System.out.println(logger);

        // Setter demo
        logger.setLoggerName("SystemLogger");
        System.out.println("\nRenamed logger: " + logger.getLoggerName());
    }
}