package log;

import java.io.FileWriter;
import java.io.IOException;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class LoggerFile implements Logger {

    private static final String FILENAME = "log.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void log(Level level, String message) {
        String formattedMessage = formatMessage(level, message);
        writeToFile(formattedMessage);
    }

    private String formatMessage(Level level, String message) {
        return "[" + ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z")) + "] " + level + ": " + message + System.lineSeparator();
    }


    private void writeToFile(String message) {
        try (FileWriter writer = new FileWriter(FILENAME, true)) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}