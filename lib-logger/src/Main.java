import log.Level;
import log.Logger;
import log.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger consoleLogger = LoggerFactory.onConsole();
        Logger fileLogger = LoggerFactory.onFile();

        logAllLevels(consoleLogger, "no console");
        logAllLevels(fileLogger, "no arquivo");
    }

    private static void logAllLevels(Logger logger, String context) {
        logger.log(Level.DEBUG, "Mensagem de debug " + context);
        logger.log(Level.WARNING, "Aviso " + context);
        logger.log(Level.ERROR, "Erro " + context);
    }
}