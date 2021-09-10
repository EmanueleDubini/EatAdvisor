package Ristoratori;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Le sue istanze rappresentano listener dedicati alla MenuBar della classeclasse: Ristoratori
 */

public class RistoratoreMenuListener implements ActionListener {

    /**
     * Nome
     */
    private RistoratoreMainMenu nome;

    /**
     * Implementa un Listener per tutte le JMenuBar presenti nelle finestre dell'applicazione <strong>Clienti</strong>.
     */
    public RistoratoreMenuListener(){
        //nome = n;
    }

    /**
     * {@inheritDoc}
     * Implementa le varie funzioni legate ai vari JMenuItem presenti nelle JMenuBar delle finestre del package <code>Clienti</code>.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String scelta = ((JMenuItem) e.getSource()).getText();

        if (scelta.equals("Chiudi"))
            System.exit(-1);

        if (scelta.equals("Nuovo inserimento"))
            RistoratoreMainMenu.nuovoInserimento();

        if (scelta.equals("Cancella tutto"))
            RistoratoreMainMenu.resetInserimento();


        if (scelta.equals("Info")) {

            ImageIcon icon = new ImageIcon("Common" + File.separatorChar + "rs.jpg");

            JOptionPane.showMessageDialog(null,
                    "    EatAdvisor 1.0\n" +
                    "----------------\n\n" +
                    "Casalnovo Giacomo\n" +
                    "Dubini Emanuele\n\n" +
                    "@UnInsubria COMO\n" +
                    "LAB A - 2019/2020\n","Informazioni",JOptionPane.INFORMATION_MESSAGE, icon);

        }

        if (scelta.equals("Guida")) {
                JFrame newWindow1 = new JFrame("Guida molto rapida");
                newWindow1.setVisible(true);
                newWindow1.setSize(520,650);
                newWindow1.setResizable(false);
                newWindow1.setLocation(1600, 300);

                JTextArea newArea1 = new JTextArea(
                        "\n EatAdvisor è uno dei migliori programmi\n" +
                        " in circolazione per dare giudizi\n" +
                        " ai ristoranti.\n\n" +
                        " -----------------------------------------\n\n" +
                        " Questa è la sezione 'Ristoratori' in cui \n" +
                        " ogni ristorante si può registrare.\n\n" +
                        " E' molto semplice: per farlo basta\n" +
                        " compilare i campi e premere il bottone\n\n" +
                        "        'Premi QUI per registrare!'\n\n\n\n" +
                        " NOTA: puoi inserire anche il sito web ma\n" +
                        " non potrai ancora scoprire la risposta\n" +
                        " alla domanda fondamentale sulla vita,\n" +
                        " l'universo e tutto quanto.\n" +
                        " (forse lo farà l'app 'Clienti'....)\n");
                newArea1.setFont(new Font("Courier", Font.BOLD, 20));
                newArea1.setEditable(false);
                newWindow1.getContentPane().add(newArea1, BorderLayout.NORTH);

        }
    }
}