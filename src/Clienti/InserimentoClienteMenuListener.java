package Clienti;

import Common.EatAdvisorException;
import Common.ProgUtili;
import Common.UtentiException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;

/**
 * Implementa un Listener per la menubar dell'applicazione Clienti.
 */
public class InserimentoClienteMenuListener implements ActionListener {


    /**
     * Currentw.
     */
    private JFrame currentw;

    //public InserimentoClienteMenuListener(){ }

    public InserimentoClienteMenuListener(JFrame currentWindows ){ currentw = currentWindows;}



        @Override
    public void actionPerformed(ActionEvent e) {
        String scelta = ((JMenuItem) e.getSource()).getText();

        if (scelta.equals("Chiudi"))
            System.exit(-1);

        if (scelta.equals("Nuovo Cliente"))
            C02InserimentoClienteWindow.nuovoInserimento();

        if (scelta.equals("Cancella Cliente"))
            C02InserimentoClienteWindow.resetInserimento();

        if (scelta.equals("Cancella Ricerca"))
            C03RicercaRistoranteWindow.resetRicerca();

        if (scelta.equals("Nuova Ricerca"))
            C03RicercaRistoranteWindow.nuovaRicerca();

        if (scelta.equals("Mostra tutti Ristoranti")) {
            try {
                ProgUtili.clearScreen();
                ProgUtili.stampaEatAdvisor();
            } catch (IOException ioException) {
                //ioException.printStackTrace();
                System.err.println("il file EatAdvisor.dati risulta vuoto o danneggiato");
                                                                                            //se si esegue il file con il file EatAdvisor.dati vuoto stampa lo stack trace dell'eccezione, sarebbe meglio inserire una stampa con
                                                                                            // "il file EatAdvisor.dati risulta vuoto o danneggiato"
            }
        }

        if (scelta.equals("Mostra tutti Clienti")) {
            try {
                ProgUtili.clearScreen();
                ProgUtili.stampaUtenti();
            } catch (IOException | ClassNotFoundException ioException) {
                //ioException.printStackTrace();
                System.err.println("il file Utenti.dati risulta vuoto o danneggiato");
            }                                                                               //se si esegue il file con il file clienti.dati vuoto stampa lo stack trace dell'eccezione, sarebbe meglio inserire una stampa con
        }                                                                                   // "il file Utenti.dati risulta vuoto o danneggiato"

        if (scelta.equals("Menu Principale")) {
            try {
                Clienti.main(null);
                currentw.setVisible(false);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (UtentiException utentiException) {
                utentiException.printStackTrace();
            } catch (EatAdvisorException eatAdvisorException) {
                eatAdvisorException.printStackTrace();
            }
        }

        if (scelta.equals("Ricerca Ristorante")) {
            JMenuItem prova = ((JMenuItem) e.getSource());
            System.err.println(prova);
            currentw.setVisible(false);
            new C03RicercaRistoranteWindow(null,false);
        }

        if (scelta.equals("Login")){
            currentw.setVisible(false);
            new C04LoginWindow();
        }

        if (scelta.equals("Inserimento Cliente")) {
            currentw.setVisible(false);
            new C02InserimentoClienteWindow(false);
        }

        if (scelta.equals("Info")) {

            //ImageIcon icon = new ImageIcon("src" + File.separatorChar + "Common" + File.separatorChar + "rs.jpg");
            ImageIcon icon = new ImageIcon("Common/rs.jpg");

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
                        " Questa è la sezione 'Clienti' in cui ogni\n" +
                        " cliente si può registrare e fare login.\n\n" +
                        " E' molto semplice: basta premere il\n" +
                        " pulsante con la funzione desiderata:\n\n" +
                                "   - Registra Cliente\n" +
                                "   - Ricerca Ristorante\n" +
                                "   - Login (entra nell'area riservata)\n\n\n\n" +
                        " NOTA: puoi anche lasciare dei giudizi ma\n" +
                        " la risposta alla domanda fondamentale\n" +
                        " sulla vita, l'universo e tutto quanto \n" +
                        " sarà solo di persona all'esame...;-)\n");
                newArea1.setFont(new Font("Courier", Font.BOLD, 20));
                newArea1.setEditable(false);
                newWindow1.getContentPane().add(newArea1, BorderLayout.NORTH);

        }
    }
}