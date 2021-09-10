package Clienti;

import Common.ProgUtili;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

/**
 * Le sue istanze rappresentano la finestra LoginWindow dell'applicazione <strong>Clienti</strong> tramite la quale si puo' effettuare il login nell'applicazione.
 */
public class C04LoginWindow extends JFrame {
    /**
     * Definisce un pulsante per poter effettuare il login nell'applicazione.
     */
    JButton login = new JButton("Login");
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
    static JPasswordField textFieldPassword = new JPasswordField(15);


    /**
     * Costruisce un nuovo oggetto che rappresenta la finestra utilizzata per effettuare il login nell'applicazione <code>Clienti</code>.
     */
    public C04LoginWindow() {
        super(".: EatAdvisor :. - CLIENTI (Login)");
        setSize(800, 600);
        setLocation(1200, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        // MENU (MENUBAR - MENU - MENUITEMS)
        JMenuBar myBar = new JMenuBar();
        this.setJMenuBar(myBar);
        this.creaMenu(myBar);


        // JPANEL  //
        JPanel loginPanel = new JPanel(null);


        // JLABEL LOGIN  //
        JLabel labelBenvenuto = new JLabel(" Area LOGIN (Accesso riservato)");
        labelBenvenuto.setHorizontalAlignment(JLabel.CENTER);
        labelBenvenuto.setForeground(Color.BLUE);
        labelBenvenuto.setBackground(Color.WHITE);
        labelBenvenuto.setBounds(0, 0, 800, 60);
        loginPanel.add(labelBenvenuto);


        //  JLABEL NICKNAME  //
        JLabel labelNickname = new JLabel("Nickname: ");
        labelNickname.setHorizontalAlignment(JLabel.LEFT);
        labelNickname.setForeground(Color.BLACK);
        labelNickname.setBounds(315, 155, 170, 30);
        loginPanel.add(labelNickname);


        //  JTEXTFIELD NICKNAME //
        textFieldNickname.setBounds(315, 185, 170, 30);
        textFieldNickname.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        loginPanel.add(textFieldNickname);


        //  JLABEL PASSWORD  //
        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setHorizontalAlignment(JLabel.LEFT);
        labelPassword.setForeground(Color.BLACK);
        labelPassword.setBounds(315, 215, 170, 30);
        loginPanel.add(labelPassword);


        //  JTEXTFIELD PASSWORD  //
        textFieldPassword.setBounds(315, 245, 170, 30);
        textFieldPassword.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        loginPanel.add(textFieldPassword);


        //  JBUTTON LOGIN  //
        login.setBounds(315, 300, 170, 30);
        loginPanel.add(login);
        login.setFocusable(true);
        login.requestFocus(true);
        login.setToolTipText("Premi per entrare");



        // JBUTTON REGISTRAZIONE //
        JButton registrazione = new JButton("Non sei registrato? Registrati qui");
        registrazione.setBounds(520, 500, 250, 30);
        registrazione.setFocusable(true);
        registrazione.requestFocus(true);
        registrazione.setToolTipText("Premi per registrati");
        registrazione.addActionListener(new ActionListener() {   //al JButton viene aggiunto un ActionListener che permetterà l'apertura della nuova finestra per la registrazione di un nuovo cliente
            @Override
            //tramite la sovrascrizione del metodo actionPerformed appartenente all'interfaccia ActionListener
            public void actionPerformed(ActionEvent e) {
                C04LoginWindow.super.setVisible(false);
                C02InserimentoClienteWindow inserimentoCliente = new C02InserimentoClienteWindow(true);
                inserimentoCliente.setVisible(true);

            }
        });

        loginPanel.add(registrazione);



        getContentPane().add(loginPanel).setBackground(Color.WHITE);
        actionLogin();

        setVisible(true);
    }

    //METODI
    /**
     * Genera la MenuBar e tutti i sotto-menu
     *
     * @param b Menubar
     */
    private void creaMenu(JMenuBar b){
        InserimentoClienteMenuListener mL = new InserimentoClienteMenuListener(this);
        //JMenu f = new JMenu("File");
        //JMenuItem f1 = new JMenuItem("Nuovo inserimento");
        //JMenuItem f2 = new JMenuItem("Cancella tutto");
        //JMenuItem f5 = new JMenuItem("Chiudi");
        //f1.addActionListener(mL);
        //f2.addActionListener(mL);
        //f5.addActionListener(mL);
        //f.add(f1);
        //f.add(f2);
        //f.add(f5);
        //b.add(f);

        JMenu s = new JMenu("Passa a...");
        JMenuItem e1 = new JMenuItem("Menu Principale");
        JMenuItem e2 = new JMenuItem("Inserimento Cliente");
        JMenuItem e3 = new JMenuItem("Ricerca Ristorante");
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
        textFieldNickname.setText("");
        textFieldPassword.setText("");
    }

    /**
     * Setta tutti gli attributi della classe con i valori predefiniti.
     */
    public static void nuovoInserimento(){
        textFieldNickname.setText("<Nickname>");
        textFieldPassword.setText("<Password>");
    }

    /**
     * Metodo che effettua il login
     */
    public void actionLogin() {
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean login = false;
                //ProgUtili.leggiUtenti();
                //Login.verificaCampi(textFieldNickname.getText(), textFieldPassword.getText());
                try {
                    if(ProgUtili.verificaLogin(textFieldNickname.getText(), textFieldPassword.getText()))
                        login = true;
                    C04LoginWindow.super.setVisible(false);
                    C03RicercaRistoranteWindow ricercaRistorante = new C03RicercaRistoranteWindow(textFieldNickname.getText(), login);
                    ricercaRistorante.setVisible(true);
//                    C05InserimentoGiudizioWindow inserimentoGiudizio = new C05InserimentoGiudizioWindow(textFieldNickname.getText());
//                    inserimentoGiudizio.setVisible(true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }


            }
        });
    }
}
