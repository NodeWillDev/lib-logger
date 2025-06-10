import br.log.*;

public class Main {
    public static void main(String[] args) {
        
        Logger consoleLogger = LoggerFactory.onConsole();
        Logger fileLogger = LoggerFactory.onFile();

        logMessages(consoleLogger);        
        logMessages(fileLogger);
    }

    private static void logMessages(Logger logger) {
        logger.log(Level.DEBUG, "Mensagem de debug");
        logger.log(Level.WARNING, "Aviso");
        logger.log(Level.ERROR, "Erro");
    }
}
