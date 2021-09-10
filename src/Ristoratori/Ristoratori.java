/**
 * LABORATORIO INTERDISCIPLINARE A - Como AA19-20
 *
 * @author CASALNOVO Giacomo | 740003
 * @author DUBINI Emanuele   | 740954
 *
 */

package Ristoratori;

import Common.EatAdvisorException;
import Common.ProgUtili;
import Common.UtentiException;
import java.io.IOException;

/**
 * Classe <strong>Ristoratori</strong> contenente il metodo <code>main</code>
 */
public class Ristoratori  {
        public static void main(String[] args) throws IOException, EatAdvisorException, UtentiException {
                ProgUtili.clearScreen();

                ProgUtili.checkEatAdvisor();
                ProgUtili.checkUtenti();

                RistoratoreMainMenu ristoratoreGui = new RistoratoreMainMenu();
                ristoratoreGui.setVisible(true);
        }
}



