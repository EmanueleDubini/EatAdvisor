package Clienti;


import Common.Giudizio;
import Ristoratori.Ristoratore;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;

/**
 * Le sue istanze rappresentano la finestra VisualizzaGiudiziWindow dell'applicazione <strong>Clienti</strong> tramite la quale si possono visualizzare e/o scrivere i giudizi relativi al ristorante a cui si è aperta la finestra.
 */
public class C07VisualizzaRistoranteWindow extends JFrame {

    /**
     * Costruisce un nuovo oggetto che rappresenta la finestra utilizzata per visualizzare i risultati della ricerca di un ristorante.
     *
     * @param visualizzaRistoratore contiene il ristorante che di cui si desidera visualizzare la descrizione e le recensioni associate all'interno della finestr.
     */
    public C07VisualizzaRistoranteWindow(ArrayList<Ristoratore> visualizzaRistoratore, String nickname, boolean login) throws IOException {                                  //come parametro va fornito un arraylist che contiene la descrizione del ristorante,
        super(".: EatAdvisor :. - CLIENTI (Visualizzazione Giudizi)");                                               //quindi l'oggetto Ristoratore che rappresenta il ristorante da visualizzare e poi tutte le recensioni di quel ristorante
        setSize(800, 800);
        setLocation(1200, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());   // LayoutManager del JFrame radice. Qui è il default: BorderLayout

        // MENU (MENUBAR - MENU - MENUITEMS)
        JMenuBar myBar = new JMenuBar();
        this.setJMenuBar(myBar);
        this.creaMenu(myBar);

        // JLABEL VISUALIZZAZIONE //
        JLabel labelVisualizzazione = new JLabel();
        labelVisualizzazione.setText("<HTML> <center><b>Informazioni e Giudizi Ristorante</b></center><br></HTML>");
        labelVisualizzazione.setHorizontalAlignment(JLabel.CENTER);
        labelVisualizzazione.setForeground(Color.BLUE);
        labelVisualizzazione.setBackground(Color.WHITE);
        getContentPane().add(labelVisualizzazione, BorderLayout.NORTH);

        // JLABEL INFORMAZIONI //
        JLabel informazioni = new JLabel();

        informazioni.setPreferredSize(new Dimension(400,50));

        informazioni.setOpaque(true);                  //se non si setta l'etichetta opaca non fa impostare il colore
        informazioni.setBackground(new Color(40, 110, 114)); //colore di sfondo di ogni singolo ristorante in RGB (lo stesso del logo EatAdvisor)
        informazioni.setForeground(new Color(255, 253, 208)); // colore del testo (crema che si abbina al verde scuro di Eatadvisor)

        informazioni.setHorizontalAlignment(JLabel.LEFT); //allineamento e testo dell'etichetta orizzontale
        informazioni.setVerticalAlignment(JLabel.TOP); //allineamento e testo dell'etichetta verticale


        Ristoratore t = visualizzaRistoratore.get(0);      //so che l'oggetto ristoratore che contiene le informazioni che devo stampare sulla pagina è il primo dell'arraylist, dopo del primo oggetto sono presenti tutte le recensioni del ristorante
        //è così perchè nell'arraylist "visualizzaRistoratore" che viene passato alla creazione di questa finestra prima di essere passato si inserisce prima il ristoratore e poi le recensioni, riga 84,88 C06

        informazioni.setText("<HTML><br>&nbsp;&nbsp;" + "<b>" + t.getNome() + "</b>" + "<br><br>" + "&nbsp;&nbsp;" +
                t.getIndQualificatore() + " " + t.getIndNomeVia() + ", " + t.getIndCivico() + " - " + t.getIndComune() + " (" + t.getIndProvincia().toUpperCase() + ") " + t.getIndCap() + "&nbsp;&nbsp;<br>" +
                "&nbsp;&nbsp;Telefono: " + t.getTelefono() + "&nbsp;&nbsp<br>" +
                "&nbsp;&nbsp;Sito web: " + t.getUrl() + "&nbsp;&nbsp<br>" +
                "&nbsp;&nbsp;Tipologia: " + t.getTipologia() + "&nbsp;&nbsp;</HTML>");

        //informazioni.setToolTipText("Informazioni Ristorante");  //suggerimento pop-up che appare se ci si sofferma su una jlabel di un ristorante

        getContentPane().add(informazioni, BorderLayout.WEST);

        // JLABEL PROSPETTO RIASSUNTIVO //
        JLabel prospetto = new JLabel();

        prospetto.setPreferredSize(new Dimension(400,50));

        prospetto.setOpaque(true);                  //se non si setta l'etichetta opaca non fa impostare il colore
        prospetto.setBackground(new Color(40, 110, 114)); //colore di sfondo di ogni singolo ristorante in RGB (lo stesso del logo EatAdvisor)
        prospetto.setForeground(new Color(255, 253, 208)); // colore del testo (crema che si abbina al verde scuro di Eatadvisor)

        prospetto.setHorizontalAlignment(JLabel.RIGHT);   //allineamento e testo dell'etichetta
        prospetto.setVerticalAlignment(JLabel.TOP); //allineamento e testo dell'etichetta orizzontale

        // CALCOLO MEDIA RECENSIONI //
        int[] count = new int[5];
        for (Ristoratore r : visualizzaRistoratore) {
            if (r instanceof Giudizio) {
                count[((Giudizio) r).getStelle() - 1]++;
            }
        }
        int tmp = 0;
        Float media = 0f;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                tmp++;
        }

        for (Float i = 0f; i < count.length; i++) {
            media += count[Math.round(i)] * (i + 1);
        }
        media = media / tmp;
        // fine calcolo media recensioni //

        prospetto.setText("<HTML><br>&nbsp;&nbsp;<b>PROSPETTO RIASSUNTIVO GIUDIZI</b> " + "&nbsp;&nbsp;<br><br>" +
                "&nbsp;&nbsp;Media quotazione: " + media + " Stelle" + "&nbsp;&nbsp;<br>" +
                "&nbsp;&nbsp;*****: " + count[4] + " valutazioni" + "&nbsp;&nbsp;<br>" +
                "&nbsp;&nbsp;&nbsp;****: " + count[3] + " valutazioni" + "&nbsp;&nbsp;<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;***: " + count[2] + " valutazioni" + "&nbsp;&nbsp;<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**: " + count[1] + " valutazioni" + "&nbsp;&nbsp;<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*: " + count[0] + " valutazioni" + "&nbsp;&nbsp;</HTML>");

        //prospetto.setToolTipText("Prospetto Riassuntivo Giudizi");  //suggerimento pop-up che appare se ci si sofferma su una jlabel di un ristorante

        getContentPane().add(prospetto, BorderLayout.EAST);

        // JPANEL GRIGLIA //
        JPanel ausiliare = new JPanel(new BorderLayout());                                                         //due JPanel perchè il layout manager generakle della pagina è un BorderLayout, nella regione nord c'è la JLabel VISUALIZZAZIONE
        JPanel griglia = new JPanel((new GridLayout(visualizzaRistoratore.size() , 1, 10, 10)));    //nella regione ovest c'è la JLabel INFORMAZIONI, nella regione est c'è la Jlabel PROSPETTO RIASSUNTIVO e infine nella regione sud
        for (Ristoratore d : visualizzaRistoratore) {                                                               // c'è inserito un secondo jpanel con layout manager di tipo BorderLayout al cui interno nella regione centrale è inserito il JPanle GRIGLIA
            if ((d instanceof Giudizio)) {                                                                          //che contiene tutte le recensioni all'interno del gridLayout per rendere a livello grafico leggermente migliore la finestra (faceva schifo altrimenti)
                JLabel recensione = new JLabel();

                recensione.setOpaque(true);                  //se non si setta l'etichetta opaca non fa impostare il colore
                recensione.setBackground(new Color(61, 31, 31)); //colore di sfondo di ogni singolo ristorante in RGB (lo stesso del logo EatAdvisor)
                recensione.setForeground(new Color(255, 253, 208)); // colore del testo (crema che si abbina al verde scuro di Eatadvisor)


                recensione.setHorizontalAlignment(JLabel.LEFT);//allineamento e testo dell'etichetta
                recensione.setVerticalAlignment(JLabel.CENTER);
                recensione.setText("<HTML><br>&nbsp;&nbsp;L'utente <font color=\"orange\"> " + ((Giudizio)d).getNickname().toUpperCase() + "</font> ha inserito:" + "&nbsp;&nbsp;<br>" +
                                "&nbsp;&nbsp;Giudizio: " + ((Giudizio)d).getStelle() + " stelle" + "&nbsp;&nbsp;<br>" +
                                "&nbsp;&nbsp;Recensione: " + ((Giudizio)d).getRecensione() + "<br><br></HTML>");

                //recensione.setToolTipText("Testo del Giudizio");  //suggerimento pop-up che appare se ci si sofferma su una jlabel Giudizio di un ristorante
                griglia.add(recensione);
            }
        }
        ausiliare.add(griglia, BorderLayout.CENTER);
        getContentPane().add(ausiliare, BorderLayout.SOUTH);

        /*
        // AGGIUNTA DEL LOGO EAT-ADVISOR in BIN/Common e in SRC)
        if (new File("Common" + File.separatorChar + "eatadvisor.jpg").exists()){
            BufferedImage icon1 = ImageIO.read(new File("Common" + File.separatorChar + "eatadvisor.jpg"));
            JLabel picLabel1 = new JLabel(new ImageIcon(icon1));
            ausiliare.add(picLabel1, BorderLayout.NORTH);
        }


        else if (new File("src" + File.separatorChar + "Common" + File.separatorChar + "eatadvisor.jpg").exists()) {
            BufferedImage icon = ImageIO.read(new File("src" + File.separatorChar + "Common" + File.separatorChar + "eatadvisor.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(icon));
            ausiliare.add(picLabel, BorderLayout.NORTH);
        }

         */

        // JBUTTON INSERIMENTO GIUDIZIO //
        if(login) {
            JButton insGiudizio = new JButton("Inserimento Giudizio");
            insGiudizio.setFont(new Font("Geneva", Font.PLAIN, 20));
            insGiudizio.setForeground(Color.BLACK); // Questo è il colore del testo del bottone
            insGiudizio.setHorizontalAlignment(JLabel.CENTER);
//        insGiudizio.setSize(20, 20); non funziona

            insGiudizio.addActionListener(new ActionListener() {   //al JButton viene aggiunto un ActionListener che permetterà l'apertura della nuova finestra per l'inserimento dei giudizi relativi a ciascun ristorante
                @Override
                //tramite la sovrascrizione del metodo actionPerformed appartenente all'interfaccia ActionListener
                public void actionPerformed(ActionEvent e) {
                        C07VisualizzaRistoranteWindow.super.setVisible(false);
                        C05InserimentoGiudizioWindow inserimentoGiudizi = new C05InserimentoGiudizioWindow(nickname , t.getNome());
                        inserimentoGiudizi.setVisible(true);
                }
            });


            ausiliare.add(insGiudizio, BorderLayout.EAST); //manu: versione precedente: inserimentoPanel.add(registraRistorante, BorderLayout.CENTER);
            this.getContentPane().add(ausiliare, BorderLayout.SOUTH); // se lo elimini in bottonePanel scompare il rosso
        }
    }

            //METODI

            /**
             * Genera la MenuBar e tutti i sotto-menu
             *
             * @param b Menubar
             */
            private void creaMenu (JMenuBar b ){
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

