package Clienti;

import Common.EatAdvisorException;
import Common.ProgUtili;
import Common.UtentiException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Le sue istanze rappresentano la finestra InserimentoClienteWindow dell'applicazione <strong>Clienti</strong> tramite la quale si puo' registrare un cliente nell'applicazione.
 */
public class C02InserimentoClienteWindow extends JFrame {
    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldNome di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
     static JTextField textFieldNome = new JTextField("<Nome>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldCognome di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldCognome = new JTextField("<Cognome>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldComune di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldComune = new JTextField("<Comune>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldProvincia di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldProvincia = new JTextField("<Provincia>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldEmail di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldEmail = new JTextField("<E-m@il>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldNickname di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldNickname = new JTextField("<Nickname>");

    /**
     * Definisce la stringa visualizzata sull'oggetto textFieldPassword di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField textFieldPassword = new JTextField("<Password>");

    /**
     * Definisce un pulsante per poter registrare un Cliente.
     */
    JButton registraCliente = new JButton("Premi QUI per registrare!");


    /**
     * Costruisce un nuovo oggetto che rappresenta la finestra utilizzata per registrare di un nuovo Cliente nell'applicazione <code>Clienti</code>.
     */
    public C02InserimentoClienteWindow(boolean nuovaRegistrazione) {

        // JFrame radice
        // JFrame frameRoot = new JFrame("Eatadvisor PROVA");
        super(".: EatAdvisor :. - CLIENTI (Registra Cliente)");
        setSize(800, 600);
        //this.setResizable(false);
        setLocation(1200, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());  // LayoutManager del JFrame radice. Qui è il default: BorderLayout



        // MENU (MENUBAR - MENU - MENUITEMS)
        JMenuBar myBar = new JMenuBar();
        this.setJMenuBar(myBar);
        this.creaMenu(myBar);


        // JPANEL 1 //
        JPanel benvenutoPanel = new JPanel(new BorderLayout());
        benvenutoPanel.setBackground(Color.BLUE);
        JLabel labelBenvenuto = this.creaEtichetta("Benvenuto nuovo Cliente.   REGISTRATI!", Color.WHITE, benvenutoPanel, JLabel.CENTER);
        benvenutoPanel.add(labelBenvenuto, BorderLayout.CENTER);
        this.getContentPane().add(benvenutoPanel, BorderLayout.NORTH);


        // JPANEL 2 //
        JPanel inserimentoPanel = new JPanel(new GridLayout( 10, 2));


        this.aggiungiEtichetta("Nome: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        textFieldNome.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*textFieldNome.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldNome.setText("");
            }
        });*/
        textFieldNome.setFont(new Font("Courier", Font.PLAIN, 24)); //Font.BOLD--> testo in grassetto, Font.PLAIN--> testo normale
        textFieldNome.setEditable(true);
        inserimentoPanel.add(textFieldNome);


        this.aggiungiEtichetta("Cognome: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        textFieldCognome.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*textFieldCognome.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldCognome.setText("");
            }
        });*/
        textFieldCognome.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldCognome.setEditable(true);
        inserimentoPanel.add(textFieldCognome);


        this.aggiungiEtichetta("Comune: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        textFieldComune.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*textFieldComune.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldComune.setText("");
            }
        });*/
        textFieldComune.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldComune.setEditable(true);
        inserimentoPanel.add(textFieldComune);


        this.aggiungiEtichetta("Provincia: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        textFieldProvincia.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*textFieldProvincia.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldProvincia.setText("");
            }
        });*/
        textFieldProvincia.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldProvincia.setEditable(true);
        inserimentoPanel.add(textFieldProvincia);

        this.aggiungiEtichetta("Email: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        textFieldEmail.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*textFieldEmail.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldEmail.setText("");
            }
        });*/
        textFieldEmail.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldEmail.setEditable(true);
        inserimentoPanel.add(textFieldEmail);


        this.aggiungiEtichetta("Nickname: ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        textFieldNickname.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*textFieldNickname.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldNickname.setText("");
            }
        });*/
        textFieldNickname.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldNickname.setEditable(true);
        inserimentoPanel.add(textFieldNickname);


        this.aggiungiEtichetta("Password (max 10 chars): ", Color.BLACK, inserimentoPanel ,JLabel.CENTER);
        textFieldPassword.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*textFieldPassword.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                textFieldPassword.setText("");
            }
        });*/
        textFieldPassword.setFont(new Font("Courier", Font.PLAIN, 24));
        textFieldPassword.setEditable(true);
        inserimentoPanel.add(textFieldPassword);


        this.getContentPane().add(inserimentoPanel, BorderLayout.CENTER);



        // JPANE 3 //
        JPanel bottonePanel = new JPanel();
        bottonePanel.setBackground(Color.BLUE);

        registraCliente.setFont(new Font("Geneva", Font.PLAIN, 20));
        registraCliente.setBackground(Color.RED); // Questo è il colore dello sfondo del bottone NON FUNZIONA
        registraCliente.setForeground(Color.BLACK); // Questo è il colore del testo del bottone
        registraCliente.setSize(20, 20); // NON FUNZIONA
        registraCliente.setHorizontalAlignment(JLabel.CENTER);
        bottonePanel.add(registraCliente); //manu: versione precedente: inserimentoPanel.add(registraRistorante, BorderLayout.CENTER);
        this.getContentPane().add(bottonePanel, BorderLayout.SOUTH); // se lo elimini in bottonePanel scompare il rosso

        inserimento(nuovaRegistrazione);

        setVisible(true);
    }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del nome all'interno della finestra.
     *
     * @return String.
     */
//METODI
    public String getNome() { return textFieldNome.getText(); }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del cognome all'interno della finestra.
     *
     * @return String.
     */
    public String getCognome() { return textFieldCognome.getText(); }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del comune all'interno della finestra.
     *
     * @return String.
     */
    public String getComune() { return textFieldComune.getText(); }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura della provincia all'interno della finestra.
     *
     * @return String.
     */
    public String getProvincia() { return textFieldProvincia.getText(); }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura dell'e-mail all'interno della finestra.
     *
     * @return String.
     */
    public String getEmail() { return textFieldEmail.getText(); }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del nickname all'interno della finestra.
     *
     * @return String.
     */
    public String getNickname() { return textFieldNickname.getText(); }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura della password all'interno della finestra.
     *
     * @return String.
     */
    public String getPassword() { return textFieldPassword.getText(); }


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
        textFieldNome.setText("");
        textFieldCognome.setText("");
        textFieldComune.setText("");
        textFieldProvincia.setText("");
        textFieldEmail.setText("");
        textFieldNickname.setText("");
        textFieldPassword.setText("");
    }

    /**
     * Setta tutti gli attributi della classe con i valori predefiniti.
     */
    public static void nuovoInserimento(){
        textFieldNome.setText("<Nome>");
        textFieldCognome.setText("<Cognome>");
        textFieldComune.setText("<Comune>");
        textFieldProvincia.setText("<Provincia>");
        textFieldEmail.setText("<E-m@il>");
        textFieldNickname.setText("<Nickname>");
        textFieldPassword.setText("<Password>");
    }

    /**
     * Implementa un Listener per l'inserimento dei nuovi Clienti.
     */
    public  void inserimento(boolean nuovaRegistrazione) {
        registraCliente.addActionListener(new ActionListener() {

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
                ArrayList<Cliente> clienteList = ProgUtili.leggiUtenti();   //l'arrayList viene letto inizialmente appena cliccato il bottone in modo tale da fare la lettura una sola volta
                //se si deve accedere al contenuto dell'arraylist poi si farà come nel metodo "public boolean checkNickname(ArrayList<Cliente> clienteList)"
                //ovvero passando per parametro al metodo l'arraylist precedentemnte leto, che contiene tutti gli utenti

                String nome = getNome();
                String cognome = getCognome();
                String comune = getComune();
                String provincia = getProvincia();
                String email = getEmail();
                String nickname = getNickname();
                String password = getPassword();
                String gen = "";

                //CONTROLLI INSERIMENTO
                if ((nome.equals("<Nome>") || nome.equals("")) ||
                        ((cognome.equals("<Cognome>") || cognome.equals("")) ||
                                (comune.equals("<Comune>") || comune.equals("")) ||
                                (provincia.equals("<Provincia>") || provincia.equals("")) ||
                                (email.equals("<E-m@il>") || email.equals("")) ||
                                (nickname.equals("<Nickname>") || nickname.equals("")) ||
                                (password.equals("<Password>") || password.equals(""))))

                    erroreInserimento(gen, "ERRORE: uno o più campi sono uguali alla <descrizione> o vuoti!");

                else if (checkNickname(clienteList)) {
                    textFieldNickname.setText("");
                    erroreInserimento(nickname, "Nickname già in uso");
                } else if (password.length() > 10) {
                    textFieldPassword.setText("");
                    erroreInserimento(password, "Password troppo lunga");
                } else if (!(Pattern.matches("[a-zA-Zàèìòù ]{0,41}[0-9]{0}", nome))) {     // Nome piu lungo: Uvuvwevwevwe Onyetenyevwe Ugwemuhwem Osas (https://www.youtube.com/watch?v=Jh8mY0s_yQc) ahahahhahaah
                    textFieldNome.setText("");
                    erroreInserimento(nome, "Nome non valido");
                } else if (!(Pattern.matches("[a-zA-Zàèìòù]{0,18}[0-9]{0}", cognome))) {   //  Il cognome italiano piu' lungo? E' ''Quondamangelomaria'' di 18 lettere
                    textFieldCognome.setText("");
                    erroreInserimento(cognome, "Cognome non valido");
                } else if (!(Pattern.matches("[a-zA-Zàèìòù]{0,34}[0-9]{0}", comune))) {   //  Il comune piu' lungo:San Valentino in Abruzzo Citeriore 34 lettere
                    textFieldComune.setText("");
                    erroreInserimento(comune, "Comune non valido");
                } else if (!(Pattern.matches("[a-zA-Z]{2,4}", provincia))) {   //  puo essere a due o a 4(Roma)
                    textFieldProvincia.setText("");
                    erroreInserimento(provincia, "Provincia non valida");
                } else if (!(Pattern.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", email))) {
                    textFieldEmail.setText("");
                    erroreInserimento(email, "E-mail non valida");
                }
                //INSERIMENTO CLIENTE NEL FILE Utenti.dai
                else {

                    Cliente r = new Cliente(nome, cognome, comune, provincia, email, nickname, password);

                    clienteList.add(r);
                    try {
                        Cliente.registraCliente(clienteList);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    resetInserimento();
                    JOptionPane.showMessageDialog(null, "Registrazione cliente avvenuta con successo", "CONFERMA registrazione",JOptionPane.INFORMATION_MESSAGE);

                    if(nuovaRegistrazione){
                        C02InserimentoClienteWindow.super.setVisible(false);
                        C04LoginWindow login = new C04LoginWindow();
                        login.setVisible(true);
                    }
                    else {
                        C02InserimentoClienteWindow.super.setVisible(false);
                        try {
                            C01MainWindow mainWindow = new C01MainWindow();
                            mainWindow.setVisible(true);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    /**
     * Verifica che un nickname non sia già presente nel file degli utenti.
     *
     * @param clienteList Arraylist clienti.
     * @return boolean.
     */
    public boolean checkNickname(ArrayList<Cliente> clienteList) {
            for (Cliente r : clienteList){
                if( r.getNickname().equals(getNickname().toLowerCase()))
                    return true;
            }
            return false;
        }

    /**
     * Messaggio personalizzato in base al tipo di errore.
     *
     * @param var     Tipo di errore
     * @param message Messaggio di errore.
     */
    public void erroreInserimento(String var, String message){
            JOptionPane.showMessageDialog(null, message, " ERRORE: " + var, JOptionPane.INFORMATION_MESSAGE);

        }
    }

