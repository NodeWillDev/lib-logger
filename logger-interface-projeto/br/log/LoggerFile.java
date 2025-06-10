package br.log;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LoggerFile implements Logger {

    private static final String FILENAME = "log.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void log(Level level, String message) {
        String formattedMessage = formatLogMessage(level, message);
        writeToFile(formattedMessage);
    }

    private String formatLogMessage(Level level, String message) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        return "[" + timestamp + "] " + level + ": " + message + System.lineSeparator();
    }

    private void writeToFile(String message) {
        try (FileWriter writer = new FileWriter(FILENAME, true)) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
