package Ristoratori;

import Common.ProgUtili;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Le sue istanze rappresentano la finestra principale dell'applicazione <strong>Ristoratori</strong> tramite la quale si puo' interagire con l'applicazione.
 */
public class RistoratoreMainMenu extends JFrame {
    //CAMPI
    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldNome di tipo JTextField.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldNome = new JTextField("<Nome-Ristorante>");

    /**
     * Definisce le stringhe visualizzate sull'oggetto textFieldQualificatore di tipo JComboBox.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     *
     * <p>
     *  &Egrave; dichiarato <strong>final</strong> rendendo impossibile la modifica delle stringhe contenute nell'array.
     * </p>
     */
    private static final String[] qualificatore = {"Via", "Viale", "Corso", "Piazza", "Piazzale"};

    /**
     * Definisce le stringhe visualizzate sull'oggetto textFieldQualificatore di tipo JComboBox.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JComboBox textFieldQualificatore = new JComboBox(qualificatore);

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldNomeVia di tipo JTextField.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldNomeVia = new JTextField("<Indirizzo>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldCivico di tipo JTextField.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldCivico = new JTextField("<Numero-Civico>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldComune di tipo JTextField.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldComune = new JTextField("<Comune>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldProvincia di tipo JTextField.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldProvincia = new JTextField("<Provincia>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldCap di tipo JTextField.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldCap = new JTextField("<Codice-Avviamento-Postale>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldtelefono di tipo JTextField.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldtelefono = new JTextField("<Fisso-Cellulare>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldUrl di tipo JTextField.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldUrl = new JTextField("<www.mioristorante.it>");

    /**
     * Definisce le stringhe visualizzate sull'oggetto textFieldTipologia di tipo JComboBox.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     *
     * <p>
     * &Egrave; dichiarato <strong>final</strong> rendendo impossibile la modifica delle stringhe contenute nell'array.
     * </p>
     */
    static private final String[] tipologia = {"Italiano", "Fusion", "Etnico"};

    /**
     * Definisce le possibilita' di selezione sull'oggetto textFieldTipologia di tipo JComboBox.
     *
     * <p>
     *  &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JComboBox textFieldTipologia = new JComboBox(tipologia);


    //COSTRUTTORI

    /**
     * Costruisce un nuovo oggetto che rappresenta la finestra visualizzata all'avvio dell'applicazione <code>Ristoratori</code>.
     */
    public RistoratoreMainMenu(){
        super(".: EatAdvisor :. - RISTORATORI - [Casalnovo / Dubini @ UnInsubria]" + "        " + ProgUtili.stampaData() + "  |  " + ProgUtili.getOsName());
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLocation(1200, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());  // LayoutManager del JFrame radice. Qui è il default: BorderLayout


        // MENU (MENUBAR - MENU - MENUITEMS)
        JMenuBar myBar = new JMenuBar();
        this.setJMenuBar(myBar);
        this.creaMenu(myBar);


        // JPANEL 1 //
        JPanel benvenutoPanel = new JPanel(new BorderLayout());
        benvenutoPanel.setBackground(Color.BLUE);
        JLabel labelBenvenuto = this.creaEtichetta("Benvenuto nuovo Ristoratore.   REGISTRATI!", Color.WHITE, benvenutoPanel, JLabel.CENTER);
        benvenutoPanel.add(labelBenvenuto, BorderLayout.CENTER);
        this.getContentPane().add(benvenutoPanel, BorderLayout.NORTH);

                                                                                                                            //il metodo CreaEtichetta restituisce un tipo Jlabel che poi può essere inserito in un layer specificando l'orientamento
        // JPANEL 2 //                                                                                                      // ES: come nel caso dell'inserimento di un JLabel in un Layout Manager di tipo BorderLayout "this.getContentPane().add(benvenutoPanel, BorderLayout.NORTH);"
        JPanel inserimentoPanel = new JPanel(new GridLayout( 10, 2));                                             // viene specificato che la JLabel va inserita nell'area nord


        this.aggiungiEtichetta("Nome: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
                                                                                      // non richiedono di specificare una posizione avendo un inserimento di tipo sequenziale tipo FlowLayout o GridLayout

        //JTextField textFieldNome = new JTextField("<Nome-Ristorante>");                                                                   SPOSTATO SOPRA COME CAMPO
        textFieldNome.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldNome.setText("");
            }
        });
        textFieldNome.setFont(new Font("Courier", Font.PLAIN, 24)); //Font.BOLD--> testo in grassetto, Font.PLAIN--> testo normale
        textFieldNome.setEditable(true);
        inserimentoPanel.add(textFieldNome);

        this.aggiungiEtichetta("Qualif. via: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        /*JLabel labelQualificatore = new JLabel("Qualif. via: ");
        labelQualificatore.setFont(new Font("Courier", Font.PLAIN, 24));
        labelQualificatore.setHorizontalAlignment(JLabel.CENTER);
        inserimentoPanel.add(labelQualificatore);*/

        //JComboBox textFieldQualificatore;
        //String[] qualificatore = {"Via...", "Viale...", "Corso...", "Piazza...", "Piazzale..."};                                           SPOSTATO SOPRA COME CAMPO
        //JComboBox textFieldQualificatore = new JComboBox(qualificatore);
        textFieldQualificatore.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldQualificatore.setEditable(false);
        inserimentoPanel.add(textFieldQualificatore);

        this.aggiungiEtichetta("Nome strada: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        /*JLabel labelNomeVia = new JLabel("Nome strada: ");
        labelNomeVia.setFont(new Font("Courier", Font.PLAIN, 24));
        labelNomeVia.setHorizontalAlignment(JLabel.CENTER);
        inserimentoPanel.add(labelNomeVia);*/

        //JTextField textFieldNomeVia = new JTextField("<Indirizzo>");                                                      SPOSTATO SOPRA COME CAMPO
        textFieldNomeVia.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldNomeVia.setText("");
            }
        });
        textFieldNomeVia.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldNomeVia.setEditable(true);
        inserimentoPanel.add(textFieldNomeVia);

        this.aggiungiEtichetta("Nr: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        /*JLabel labelCivico = new JLabel("Nr: ");
        labelCivico.setFont(new Font("Courier", Font.PLAIN, 24));
        labelCivico.setHorizontalAlignment(JLabel.CENTER);
        inserimentoPanel.add(labelCivico);*/

        //JTextField textFieldCivico = new JTextField("<Numero-Civico>");                                               SPOSTATO SOPRA COME CAMPO
        textFieldCivico.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldCivico.setText("");
            }
        });
        textFieldCivico.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldCivico.setEditable(true);
        inserimentoPanel.add(textFieldCivico);

        this.aggiungiEtichetta("Comune: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        /*JLabel labelComune = new JLabel("Comune: ");
        labelComune.setFont(new Font("Courier", Font.PLAIN, 24));
        labelComune.setHorizontalAlignment(JLabel.CENTER);
        inserimentoPanel.add(labelComune);*/

        //JTextField textFieldComune = new JTextField("<Comune>");                              SPOSTATO SOPRA COME CAMPO
        textFieldComune.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldComune.setText("");
            }
        });
        textFieldComune.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldComune.setEditable(true);
        inserimentoPanel.add(textFieldComune);

        this.aggiungiEtichetta("Provincia: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        /*JLabel labelProvincia = new JLabel("Provincia: ");
        labelProvincia.setFont(new Font("Courier", Font.PLAIN, 24));
        labelProvincia.setHorizontalAlignment(JLabel.CENTER);
        inserimentoPanel.add(labelProvincia);*/

        //JTextField textFieldProvincia = new JTextField("<Provincia>");                            SPOSTATO SOPRA COME CAMPO
        textFieldProvincia.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldProvincia.setText("");
            }
        });
        textFieldProvincia.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldProvincia.setEditable(true);
        inserimentoPanel.add(textFieldProvincia);

        this.aggiungiEtichetta("Cap: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        /*JLabel labelCap = new JLabel("Cap: ");
        labelCap.setFont(new Font("Courier", Font.PLAIN, 24));
        labelCap.setHorizontalAlignment(JLabel.CENTER);
        inserimentoPanel.add(labelCap);*/

        //JTextField textFieldCap = new JTextField("<Codice-Avviamento-Postale>");              SPOSTATO SOPRA COME CAMPO
        textFieldCap.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldCap.setText("");
            }
        });
        textFieldCap.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldCap.setEditable(true);
        inserimentoPanel.add(textFieldCap);

        this.aggiungiEtichetta("Telefono: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        /*JLabel labelTelefono = new JLabel("Telefono: ");
        labelTelefono.setFont(new Font("Courier", Font.PLAIN, 24));
        labelTelefono.setHorizontalAlignment(JLabel.CENTER);
        inserimentoPanel.add(labelTelefono);*/

        //JTextField textFieldtelefono = new JTextField("<Fisso-Cellulare>");                           SPOSTATO SOPRA COME CAMPO
        textFieldtelefono.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldtelefono.setText("");
            }
        });
        textFieldtelefono.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldtelefono.setEditable(true);
        inserimentoPanel.add(textFieldtelefono);

        this.aggiungiEtichetta("Sito web: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        /*JLabel labelUrl = new JLabel("Sito web: ");
        labelUrl.setFont(new Font("Courier", Font.PLAIN, 24));
        labelUrl.setHorizontalAlignment(JLabel.CENTER);
        inserimentoPanel.add(labelUrl);*/

        //JTextField textFieldUrl = new JTextField("<www.mioristorante.it>");               SPOSTATO SOPRA COME CAMPO
        textFieldUrl.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldUrl.setText("");
            }
        });
        textFieldUrl.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldUrl.setEditable(true);
        inserimentoPanel.add(textFieldUrl);

        this.aggiungiEtichetta("Tipologia: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        /*JLabel labelTipologia = new JLabel("Tipologia: ");
        labelTipologia.setFont(new Font("Courier", Font.PLAIN, 24));
        labelTipologia.setHorizontalAlignment(JLabel.CENTER);
        inserimentoPanel.add(labelTipologia);*/

        //JComboBox textFieldTipologia;
        //String[] tipologia = {"Italiano", "Fusion", "Etnico"};                        SPOSTATO SOPRA COME CAMPO
        //JComboBox textFieldTipologia = new JComboBox(tipologia);
        textFieldTipologia.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldTipologia.setEditable(false);
        inserimentoPanel.add(textFieldTipologia);


        this.getContentPane().add(inserimentoPanel, BorderLayout.CENTER);


        /*
        JPanel inserimentoPanel = new JPanel(new BorderLayout());
        inserimentoPanel.setBackground(Color.CYAN);

        JLabel labelNome = new JLabel("Nome:");
        inserimentoPanel.add(labelNome, BorderLayout.WEST);

        JLabel labelIndirizzo = new JLabel("Indirizzo:");
        inserimentoPanel.add(labelIndirizzo, BorderLayout.CENTER);

        JTextField textFieldNome = new JTextField("Inserisci Nome qui");
        textFieldNome.setFont(new Font("Courier", Font.PLAIN, 24)); //Font.BOLD--> testo in grassetto, Font.PLAIN--> testo normale
        textFieldNome.setEditable(true);
        textFieldNome.setVisible(true);
        inserimentoPanel.add(textFieldNome, BorderLayout.EAST);  //manu: versione precedente: inserimentoPanel.add(textFieldNome, BorderLayout.CENTER);
        this.getContentPane().add(inserimentoPanel, BorderLayout.CENTER);
        */

        // JPANE 3 //
        JPanel bottonePanel = new JPanel();
        bottonePanel.setBackground(Color.BLUE);

        JButton registraRistorante = new JButton("Premi QUI per registrare!");
        registraRistorante.setFont(new Font("Geneva", Font.PLAIN, 20));
        registraRistorante.setBackground(Color.RED); // Questo è il colore dello sfondo del bottone NON FUNZIONA
        registraRistorante.setForeground(Color.BLACK); // Questo è il colore del testo del bottone
        registraRistorante.setSize(20, 20); // NON FUNZIONA
        registraRistorante.setHorizontalAlignment(JLabel.CENTER);
        bottonePanel.add(registraRistorante); //manu: versione precedente: inserimentoPanel.add(registraRistorante, BorderLayout.CENTER);
        this.getContentPane().add(bottonePanel, BorderLayout.SOUTH); // se lo elimini in bottonePanel scompare il rosso


        RistoratoreListener l = new RistoratoreListener();
        registraRistorante.addActionListener(l);
        //registra();

    }

    //METODI

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del nome all'interno della finestra.
     *
     * @return String.
     */
    public static String getNome() {
        return textFieldNome.getText();
    }

    /**
     * Restituisce una stringa che descrive il contenuto della JComboBox dedicata alla selezione del qualificatore all'interno della finestra.
     *
     * @return String.
     */
    public static String getQualificatore() {
        return textFieldQualificatore.getSelectedItem().toString();
    }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del nome della via all'interno della finestra.
     *
     * @return String.
     */
    public static String getNomeVia() {
        return textFieldNomeVia.getText();
    }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del numero civico all'interno della finestra.
     *
     * @return String.
     */
    public static String getCivico() {
        return textFieldCivico.getText();
    }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del comune all'interno della finestra.
     *
     * @return String.
     */
    public static String getComune() {
        return textFieldComune.getText();
    }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura della provincia all'interno della finestra.
     *
     * @return String.
     */
    public static String getProvincia() {
        return textFieldProvincia.getText();
    }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del CAP all'interno della finestra.
     *
     * @return String.
     */
    public static String getCap() {
        return textFieldCap.getText();
    }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del numero di telefono all'interno della finestra.
     *
     * @return String.
     */
    public static String getTelefono() {
        return textFieldtelefono.getText();
    }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura dell'URL all'interno della finestra.
     *
     * @return String.
     */
    public static String getUrl() {
        return textFieldUrl.getText();
    }

    /**
     * Restituisce una stringa che descrive il contenuto della JComboBox dedicata alla selezione della tipologia all'interno della finestra.
     *
     * @return String.
     */
    public static String getTipologia() {
        return textFieldTipologia.getSelectedItem().toString();
    }

    /*public void registra(){
        registraRistorante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = textFieldNome.getText();
                String indQualificatore = textFieldQualificatore.getSelectedItem().toString() ;
                String indNomeVia = textFieldNomeVia.getText();
                String indCivico = textFieldCivico.getText();
                String indComune = textFieldComune.getText();
                String indProvincia = textFieldProvincia.getText();
                String indCap = textFieldCap.getText();
                String telefono = textFieldtelefono.getText();
                String url = textFieldUrl.getText();
                String tipologia = textFieldTipologia.getSelectedItem().toString();
                String id = ProgUtili.createId();

                Ristoratore r = new Ristoratore(id, nome, indQualificatore, indNomeVia, indCivico, indComune, indProvincia, indCap,
                        telefono, url, tipologia);

                ArrayList<Ristoratore> ristoratoreList = ProgUtili.leggiEatAdvisor();
                ristoratoreList.add(r);
                try {
                    Ristoratore.registraRistoratore(ristoratoreList);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });*/
    //}

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
        RistoratoreMenuListener mL = new RistoratoreMenuListener();
        JMenu f = new JMenu("File");
        JMenuItem f1 = new JMenuItem("Nuovo inserimento");
        JMenuItem f5 = new JMenuItem("Chiudi");
        f1.addActionListener(mL);
        f5.addActionListener(mL);
        f.add(f1);
        f.add(f5);
        b.add(f);

        JMenu s = new JMenu("Strumenti");
        JMenuItem e1 = new JMenuItem("Cancella tutto");
        e1.addActionListener(mL);
        s.add(e1);
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
        textFieldNome.setText("");
        textFieldQualificatore.setSelectedItem("Via");
        textFieldNomeVia.setText("");
        textFieldCivico.setText("");
        textFieldComune.setText("");
        textFieldProvincia.setText("");
        textFieldCap.setText("");
        textFieldtelefono.setText("");
        textFieldUrl.setText("");
        textFieldTipologia.setSelectedItem("Italiano");
    }

    /**
     * Setta tutti gli attributi della classe con i valori predefiniti.
     */
    public static void nuovoInserimento(){
        textFieldNome.setText("<Nome-Ristorante>");
        textFieldQualificatore.setSelectedItem("Via");
        textFieldNomeVia.setText("<Indirizzo>");
        textFieldCivico.setText("<Numero-Civico>");
        textFieldComune.setText("<Comune>");
        textFieldProvincia.setText("<Provincia>");
        textFieldCap.setText("<Codice-Avviamento-Postale>");
        textFieldtelefono.setText("<Fisso-Cellulare>");
        textFieldUrl.setText("<www.mioristorante.it>");
        textFieldTipologia.setSelectedItem("Italiano");
    }
}
