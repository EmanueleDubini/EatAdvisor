package Common;

/**
 * Eccezioni della classe <code>Clienti</code>
 *
 * <p>
 * @version 1.0
 * </p>
 *
 * <p>
 * @author CASALNOVO Giacomo | 740003
 * @author DUBINI Emanuele   | 740954
 * </p>
 */
public class UtentiException extends Exception {

    public UtentiException(String exception) {
        System.err.println(exception);
        System.exit(-1);    // stoppa il programma ed esce
    }
}