/**
 * LABORATORIO INTERDISCIPLINARE A - Como AA19-20
 *
 * @author CASALNOVO Giacomo | 740003
 * @author DUBINI Emanuele   | 740954
 *
 */

package Clienti;

import Common.EatAdvisorException;
import Common.ProgUtili;
import Common.UtentiException;
import java.io.IOException;

/**
 * Classe <strong>Clienti</strong> contenente il metodo <code>main</code>
 */
public class Clienti {
        public static void main(String[] args) throws IOException, EatAdvisorException, UtentiException {
            ProgUtili.clearScreen();

            ProgUtili.checkEatAdvisor();
            ProgUtili.checkUtenti();

            C01MainWindow clienteGui = new C01MainWindow();
            clienteGui.setVisible(true);
        }
}
