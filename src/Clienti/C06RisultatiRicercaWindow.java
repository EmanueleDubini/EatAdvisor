package Clienti;

import Common.Giudizio;
import Ristoratori.Ristoratore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Le sue istanze rappresentano la finestra RisultatiRicercaWindow dell'applicazione <strong>Clienti</strong> tramite la quale si possono visualizzare i risultati della ricerca di un ristorante.
 */
public class C06RisultatiRicercaWindow extends JFrame {

    /**
     * Costruisce un nuovo oggetto che rappresenta la finestra utilizzata per visualizzare i risultati della ricerca di un ristorante.
     *
     * @param risultatiRicerca contiene tutti i ristoranti che sono frutto della ricerca e quindi vanno visualizzati all'interno della finestra, tramite il gridlayout.
     */
    public C06RisultatiRicercaWindow(ArrayList<Ristoratore> risultatiRicerca, String nickname, Boolean login) {  //l'ArrayList passato per paramentro contiene tutti i ristoranti, con i relativi giudizi, che sono frutto della ricerca
        super(".: EatAdvisor :. - CLIENTI (Risultati Ricerca)");                        //e quindi vanno visualizzati all'interno della finestra, tramite il gridlayout
        setSize(800, 600);
        setLocation(1200, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());   // LayoutManager del JFrame radice. Qui è il default: BorderLayout

        // MENU (MENUBAR - MENU - MENUITEMS)
        JMenuBar myBar = new JMenuBar();
        this.setJMenuBar(myBar);
        this.creaMenu(myBar);


        // JLABEL RICERCA //
        JLabel labelRicerca = new JLabel();
        labelRicerca.setText("<HTML> <center><b>Risultati Ricerca Ristorante</b></center><br></HTML>");
        labelRicerca.setHorizontalAlignment(JLabel.CENTER);
        labelRicerca.setForeground(Color.BLUE);
        labelRicerca.setBackground(Color.WHITE);
        getContentPane().add(labelRicerca, BorderLayout.NORTH);

        // JPANEL GRIGLIA //

        //all'interno dell'arraylist "risultatiRicerca" sono presenti i ristoratori che corrispondono alla ricerca effettuata, quelli che quindi andranno fatti visualizzare nella finestra,
        // e in più sono presenti tutti giudizi dei ristoranti registrati nell'applicazione, non solo quelli dei ristoranti selezionati dalla ricerca
        //scorrendo tutto l'arraylist contiamo quanti sono i ristoranti da visualizzare per dimensionare la tabella presente nella pagina
        int numRistoratori = 0;
        for(Ristoratore r: risultatiRicerca){
            if(!(r instanceof Giudizio))
                numRistoratori = numRistoratori++;
        }
        JPanel griglia = new JPanel((new GridLayout(numRistoratori / 2, 2, 10, 10)));
        for (Ristoratore s : risultatiRicerca) {
            if (!(s instanceof Giudizio)) {
                JLabel etichetta = new JLabel();

                etichetta.setOpaque(true);                  //se non si setta l'etichetta opaca non fa impostare il colore
                etichetta.setBackground(new Color(40, 110, 114)); //colore di sfondo di ogni singolo ristorante in RGB (lo stesso del logo EatAdvisor)
                etichetta.setForeground(new Color(255, 253, 208)); // colore del testo (crema che si abbina al verde scuro di Eatadvisor)

                //etichetta.setMinimumSize(new Dimension(100, 25));          //con o senza il set delle dimensioni pare non cambiare nulla
                //etichetta.setMaximumSize(new Dimension(200, 25));
                //etichetta.setPreferredSize(new Dimension(140, 25));

                Cursor cursor = new Cursor(Cursor.HAND_CURSOR); //Cambiamo la forma al puntatore del mouse per fare capire che l'etichettaa è clikkabile
                etichetta.setCursor(cursor);

                etichetta.setHorizontalAlignment(JLabel.CENTER); //allineamento e testo dell'etichetta
                etichetta.setText(s.getNome());

                etichetta.setToolTipText("Fare click sul ristorante per visualizzarne i dettagli");  //suggerimento pop-up che appare se ci si sofferma su una jlabel di un ristorante

                etichetta.addMouseListener(new MouseAdapter() {    //ad ogni jlabel creata viene aggiunto un mouseListener che permetterà l'apertura della nuova finestra per la visualizzazione dei giudizi relativi a ciascun ristorante
                    @Override
                    //tramite la sovrascrizione del metodo mouseClicked appartenente all'interfaccia MouseListener
                    public void mouseClicked(MouseEvent e) {
                        ArrayList<Ristoratore> visualizzaRistorante = new ArrayList<>();
                        String sorgente = ((JLabel) e.getSource()).getText();

                        for (Ristoratore f : risultatiRicerca) {                                    //l'arraylist "risultatiRicerca" contiene i ristorantori che corrispondono alla ricerca effettuata, quelli che quindi andranno fatti visualizzare nella finestra,
                                                                                                    //e in più sono presenti tutti giudizi dei ristoranti registrati nell'applicazione, non solo quelli dei ristoranti selezionati dalla ricerca
                            if (!(f instanceof Giudizio) && (f.getNome().equals(sorgente)))         //con il ciclo for-each,con il primo if, visitiamo l'arraylist e aggiungiamo all'interno dell'Arraylist "visualizzaRistorante" quello selezionato dall'utente tramite la finestra C06RisultatiRicercaWindows
                                visualizzaRistorante.add(f);                                        //in modo tale che rimane solo il ristorantore selezionato al suo interno separandolo dall'arraylist precedente in cui erano presenti tutti i ristoratori risultanti dalla ricerca.
                                                                                                    //Successivamente, nel ciclo for-each, tramite il secondo if si effettua la visita dell'arraylist aggiungendo al secondo Arraylist tutti i giudizi che sono inerenti al ristoratore scelto dall'utente tramite la finestra
                                                                                                    //così da ottenere l'arraylist da passare alla nuova finestra C07VisualizzaRistoranteWindow
                            if (f instanceof Giudizio && f.getNome().equals(sorgente))              //ho provato a togliere gli elementi dall'arraylist già presente senza doverne creare uno di supporto ma non toglieva tutti i ristoranti, lo ho lasciato nel commento sotto
                                visualizzaRistorante.add(f);
                        }

                        /*for(int i=0; i<risultatiRicerca.size(); i++){
                            if(!(risultatiRicerca.get(i) instanceof Giudizio) && !((risultatiRicerca.get(i).getNome()).equals(sorgente)))
                                risultatiRicerca.remove(i);

                            if((risultatiRicerca.get(i) instanceof Giudizio) && !(risultatiRicerca.get(i).getNome()).equals(sorgente))
                                risultatiRicerca.remove(i);

                        // scorrendo con il ciclo for.each e modificando l'arraylist da eccezione, --> https://stackoverflow.com/questions/17067626/java-arraylist-and-exception-in-thread-awt-eventqueue-0-java-util-concurrentm
                        }*/
                            /*for (Ristoratore f : risultatiRicerca) {

                            if (!(f instanceof Giudizio) && (!f.getNome().equals(sorgente)))
                                risultatiRicerca.remove(f);

                            if (f instanceof Giudizio && !f.getNome().equals(sorgente))
                                risultatiRicerca.remove(f);
                        }*/

                        C06RisultatiRicercaWindow.super.setVisible(false);
                        C07VisualizzaRistoranteWindow visualizzaGiudizi = null;
                        try {
                            visualizzaGiudizi = new C07VisualizzaRistoranteWindow(visualizzaRistorante, nickname, login);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        visualizzaGiudizi.setVisible(true);
                    }
                });
                griglia.add(etichetta);
            }
        }


        getContentPane().add(griglia, BorderLayout.CENTER);


        setVisible(true);
    }

    //METODI

    /**
     * Genera la MenuBar e tutti i sotto-menu
     *
     * @param b Menubar
     */
    private void creaMenu(JMenuBar b) {
        InserimentoClienteMenuListener mL = new InserimentoClienteMenuListener(this);

        JMenu s = new JMenu("Passa a...");
        JMenuItem e1 = new JMenuItem("Menu Principale");
        JMenuItem e2 = new JMenuItem("Inserimento Cliente");
        JMenuItem e3 = new JMenuItem("Ricerca Ristorante");
        JMenuItem e4 = new JMenuItem("Login");
        e1.addActionListener(mL);
        e2.addActionListener(mL);
        e3.addActionListener(mL);
        e4.addActionListener(mL);
        s.add(e1);
        s.add(e2);
        s.add(e3);
        s.add(e4);
        b.add(s);

        JMenu h = new JMenu("?");
        JMenuItem h1 = new JMenuItem("Guida");
        JMenuItem h5 = new JMenuItem("Info");
        h1.addActionListener(mL);
        h5.addActionListener(mL);
        h.add(h1);
        h.add(h5);
        b.add(h);
    }
}


