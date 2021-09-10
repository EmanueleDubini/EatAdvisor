package Clienti;

import Common.EatAdvisorException;
import Common.Giudizio;
import Common.ProgUtili;
import Common.UtentiException;
import Ristoratori.Ristoratore;
import Ristoratori.RistoratoreMainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Le sue istanze rappresentano la finestra InserimentoGiudizioWindow dell'applicazione <strong>Clienti</strong> tramite la quale si puo' registrare un Giudizio nell'applicazione.
 */
public class C05InserimentoGiudizioWindow extends JFrame {

    //CAMPI

   /* /**
     * Definisce la stringa visualizzata sull'oggetto textFieldNome di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    //static JTextField textFieldNome = new JTextField("<Nome-Ristorante>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldGiudizioStelle di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldGiudizioStelle = new JTextField("<Giudizio-Stelle>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldGiudizioTesto di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldGiudizioTesto = new JTextField("");

    /**
     * Definisce un pulsante per poter registrare un Giudizio.
     */
    JButton registraGiudizio = new JButton("Premi QUI per inserire un giudizio!");


    /**
     * Costruisce un nuovo oggetto che rappresenta la finestra utilizzata per registrare di un nuovo Giudizio nell'applicazione <code>Clienti</code>.
     *
     * @param nickname nickname dell'utente che inserisce la recensione nell'applicazione <code>Clienti</code>.
     */
    public C05InserimentoGiudizioWindow(String nickname, String nomeRistorante) { //viene passato dalla finestra precedente C04LoginWindows il nickname dell'utente che ha fatto l'accesso in modo tale da poterlo riportare all'interno della recensione
        super(".: EatAdvisor :. - CLIENTI (Inserimento Giudizio)");
        this.setSize(800, 600);
        //this.setResizable(false);
        this.setLocation(1200, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());  // LayoutManager del JFrame radice. Qui è il default: BorderLayout



        // MENU (MENUBAR - MENU - MENUITEMS)
        JMenuBar myBar = new JMenuBar();
        this.setJMenuBar(myBar);
        this.creaMenu(myBar);


        // JPANEL BENVENUTO //
        JPanel benvenutoPanel = new JPanel(new BorderLayout());
        benvenutoPanel.setBackground(Color.GRAY);
        JLabel labelBenvenuto = this.creaEtichetta("INSERIMENTO GIUDIZIO", Color.WHITE, benvenutoPanel, JLabel.CENTER);
        benvenutoPanel.add(labelBenvenuto, BorderLayout.CENTER);
        this.getContentPane().add(benvenutoPanel, BorderLayout.NORTH);


        // JPANEL INSERIMENTO //
        JPanel inserimentoPanel = new JPanel(new GridLayout( 10, 2));


        //this.aggiungiEtichetta("Nome Ristorante", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        //textFieldNome.addMouseListener(new MouseAdapter(){
           // @Override
            //public void mouseClicked(MouseEvent e){
               // textFieldNome.setText("");
            //}
       // });
        //textFieldNome.setFont(new Font("Courier", Font.PLAIN, 24)); //Font.BOLD--> testo in grassetto, Font.PLAIN--> testo normale
        //textFieldNome.setEditable(true);
        //inserimentoPanel.add(textFieldNome);


        this.aggiungiEtichetta("Giudizio in Stelle [Inserisci un numero da 1 a 5]", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        textFieldGiudizioStelle.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldGiudizioStelle.setText("");
            }
        });
        textFieldGiudizioStelle.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldGiudizioStelle.setEditable(true);
        inserimentoPanel.add(textFieldGiudizioStelle);


        this.aggiungiEtichetta("Giudizio in Testo [max 256 caratteri]:", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        //textFieldGiudizioTesto.addMouseListener(new MouseAdapter(){
            //@Override
           // public void mouseClicked(MouseEvent e){
                //textFieldGiudizioTesto.setText("");
            //}
        //});
        textFieldGiudizioTesto.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldGiudizioTesto.setEditable(true);
        inserimentoPanel.add(textFieldGiudizioTesto);


        this.getContentPane().add(inserimentoPanel, BorderLayout.CENTER);


        // JPANE BOTTONE //
        JPanel bottonePanel = new JPanel();
        bottonePanel.setBackground(Color.BLUE);

        registraGiudizio.setFont(new Font("Geneva", Font.PLAIN, 20));
        registraGiudizio.setBackground(Color.RED); // Questo è il colore dello sfondo del bottone NON FUNZIONA
        registraGiudizio.setForeground(Color.BLACK); // Questo è il colore del testo del bottone
        registraGiudizio.setSize(20, 20); // NON FUNZIONA
        registraGiudizio.setHorizontalAlignment(JLabel.CENTER);
        bottonePanel.add(registraGiudizio); //manu: versione precedente: inserimentoPanel.add(registraRistorante, BorderLayout.CENTER);
        this.getContentPane().add(bottonePanel, BorderLayout.SOUTH); // se lo elimini in bottonePanel scompare il rosso

        inserimento(nickname, nomeRistorante);


        setVisible(true);

    }

    /*/**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del nome del ristorante all'interno della finestra.
     *
     * @return String.
     */
    /*public static String getNomeRistorante() {
        return textFieldNome.getText();
    }*/

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura delle stelle relative al giudizio all'interno della finestra.
     *
     * @return String.
     */
    public static Integer getGiudizioStelle() { return Integer.parseInt(textFieldGiudizioStelle.getText()); }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del testo relativo al giudizio all'interno della finestra.
     *
     * @return String.
     */
    public static String getGiudizioTesto() { return textFieldGiudizioTesto.getText(); }


    /**
     * Crea un etichetta, che verra' restituita alla chiamata del metodo, specificandone: testo, colore, destinazione di inserimento e allineamento.
     *
     * @param text         Esprime il testo dell'estichetta.
     * @param color        Esprime il colore del testo contenuto nell'etichetta.
     * @param panel        Esprime l'oggetto in cui si desidera inserire l'etichetta.
     * @param allineamento Consente di definire l'allineamneto dell'etichetta.
     * @return JLabel
     */
    private JLabel creaEtichetta(String text, Color color, JPanel panel, int allineamento ){
        JLabel labelBenvenuto = new JLabel(text);
        labelBenvenuto.setForeground(color);
        labelBenvenuto.setFont(new Font("Courier", Font.BOLD, 24));
        labelBenvenuto.setHorizontalAlignment(allineamento);
        return labelBenvenuto;

    }

    /**
     * Crea e aggiunge un etichetta specificandone: testo, colore, destinazione e allineamento.
     *
     * @param text         Esprime il testo dell'estichetta.
     * @param color        Esprime il colore del testo contenuto nell'etichetta.
     * @param panel        Esprime l'oggetto in cui si desidera inserire l'etichetta.
     * @param allineamento Consente di definire l'allineamneto dell'etichetta.
     */
    private void aggiungiEtichetta(String text, Color color, JPanel panel, int allineamento ){
        JLabel labelBenvenuto = new JLabel(text);
        labelBenvenuto.setForeground(color);
        labelBenvenuto.setFont(new Font("Courier", Font.BOLD, 24));
        labelBenvenuto.setHorizontalAlignment(allineamento);
        panel.add(labelBenvenuto);
    }

    /**
     * Genera la MenuBar e tutti i sotto-menu
     *
     * @param b Menubar
     */
    private void creaMenu(JMenuBar b){
        InserimentoClienteMenuListener mL = new InserimentoClienteMenuListener(this);
        JMenu f = new JMenu("File");
        JMenuItem f1 = new JMenuItem("Nuovo Cliente");
        JMenuItem f2 = new JMenuItem("Cancella Cliente");
        //JMenuItem f5 = new JMenuItem("Chiudi");
        f1.addActionListener(mL);
        f2.addActionListener(mL);
        //f5.addActionListener(mL);
        f.add(f1);
        f.add(f2);
        //f.add(f5);
        b.add(f);

        JMenu s = new JMenu("Passa a...");
        JMenuItem e1 = new JMenuItem("Menu Principale");
        JMenuItem e2 = new JMenuItem("Ricerca Ristorante");
        JMenuItem e3 = new JMenuItem("Login");
        e1.addActionListener(mL);
        e2.addActionListener(mL);
        e3.addActionListener(mL);
        s.add(e1);
        s.add(e2);
        s.add(e3);
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

    /**
     * Setta tutti gli attributi della classe con una stringa vuota.
     */
    public static void resetInserimento(){
        //textFieldNome.setText("");
        textFieldGiudizioStelle.setText("");
        textFieldGiudizioTesto.setText("");
    }

    /**
     * Setta tutti gli attributi della classe con i valori predefiniti.
     */
    public static void nuovoInserimento(){
        //textFieldNome.setText("<Nome-Ristorante>");
        textFieldGiudizioStelle.setText("<Giudizio-Stelle>");
        textFieldGiudizioTesto.setText("<Giudizio-Commento>");
    }

    /**
     * Implementa un Listener per l'inserimento dei nuovi Giudizi.
     *
     * @param nickname nickname dell'utente che inserisce la recensione nell'applicazione <code>Clienti</code>.
     */
    public  void inserimento(String nickname, String NomeRistorante) {
        registraGiudizio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //controllo che entrambi i file siano presenti nella cartella data, che siano legtgibili e scrivibili
                try {
                    ProgUtili.checkEatAdvisor();
                    ProgUtili.checkUtenti();
                } catch (EatAdvisorException eatAdvisorException) {
                    eatAdvisorException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (UtentiException utentiException) {
                    utentiException.printStackTrace();
                }


                // Come suggerito dal uo collega: (l'arraylist viene letto una volta e ristampato una sola volta)
                ArrayList<Ristoratore> ristoratoreList = ProgUtili.leggiEatAdvisor();   //l'arrayList viene letto inizialmente appena cliccato il bottone in modo tale da fare la lettura una sola volta
                //se si deve accedere al contenuto dell'arraylist poi si farà come nel metodo "public boolean checkNickname(ArrayList<Ristoratore> ristoratoreList)"
                //ovvero passando per parametro al metodo l'arraylist precedentemnte leto, che contiene tutti gli utenti

                String nomeRistorante = NomeRistorante;
                Integer giudizioStelle = getGiudizioStelle();
                String giudizioTesto = getGiudizioTesto();
                String gen = "";

                //CONTROLLI INSERIMENTO
                if ((nomeRistorante.equals("<Nome-Ristorante>") || nomeRistorante.equals("")) ||
                        (giudizioStelle.equals("<Giudizio-Stelle>") || giudizioStelle.equals("")) ||
                        (giudizioTesto.equals("<Giudizio-Commento>") || giudizioTesto.equals("")))

                    erroreInserimento(gen, "ERRORE: uno o più campi sono uguali alla <descrizione> o vuoti!");

                //else if (nomeRistorante.length() > 40) {
                    //textFieldNome.setText("");
                   // erroreInserimento("Nome Ristorante non valido", "Il nome del ristorante inserito non è presente nell'applicazione");}
                 else if (!(Pattern.matches("[12345]", giudizioStelle.toString()))) {
                    textFieldGiudizioStelle.setText("");
                    erroreInserimento("Stelle recensione non valide", "Le stelle della recensione non sono state inserite secondo un criterio valido");
                } else if (giudizioTesto.length() > 256) {
                    textFieldGiudizioTesto.setText("");
                    erroreInserimento("Testo recensione non valido", "Il testo della recensione non è stato inserito secondo criteri validi");
                }
                //INSERIMENTO GIUDIZIO NEL FILE EatAdvisor.dati
                else {

                    Giudizio g = new Giudizio(nomeRistorante, nickname, giudizioStelle, giudizioTesto);

                    ristoratoreList.add(g);
                    try {
                       Giudizio.registraGiudizio(ristoratoreList);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                   }
                    resetInserimento();
                    JOptionPane.showMessageDialog(null, "Registrazione Giudizio avvenuta con successo", "CONFERMA inserimento Giudizio",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * Messaggio personalizzato in base al tipo di errore.
     *
     * @param var    Tipo di errore
     * @param message Messaggio di errore.
     */
    public void erroreInserimento (String var, String message){
        JOptionPane.showMessageDialog(null, message, " ERRORE: " + var, JOptionPane.INFORMATION_MESSAGE);

    }
}


