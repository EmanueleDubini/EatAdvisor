package Common;

/**
 * Eccezioni della classe <code>Ristoratori</code>
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
public class EatAdvisorException extends Exception {

    public EatAdvisorException(String exception) {
        System.err.println(exception);
        System.exit(-1);    // stoppa il programma ed esce
    }
}