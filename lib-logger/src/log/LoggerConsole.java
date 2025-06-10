package log;

class LoggerConsole implements Logger {

    @Override
    public void log(Level level, String message) {
        String coloredMessage = formatWithColor(level, message);
        System.out.println(coloredMessage);
    }

    private String formatWithColor(Level level, String message) {
        String colorCode = getColorCode(level);
        String resetCode = "\u001B[0m";
        return colorCode + "[" + level + "] " + message + resetCode;
    }

    private String getColorCode(Level level) {
        return switch (level) {
            case DEBUG -> "\u001B[32m";   // Verde
            case WARNING -> "\u001B[33m"; // Amarelo
            case ERROR -> "\u001B[31m";   // Vermelho
            default -> "\u001B[0m";       // Reset
        };
    }
}
