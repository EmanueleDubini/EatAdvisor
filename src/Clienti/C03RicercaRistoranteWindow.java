package Clienti;

import Ristoratori.Ristoratore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Le sue istanze rappresentano la finestra RicercaRistoranteWindow dell'applicazione <strong>Clienti</strong> tramite la quale si puo' ricercare un ristorante nell'applicazione.
 */
public class C03RicercaRistoranteWindow extends JFrame implements ItemListener {
    /**
     * Definisce la stringa visualizzata sull'oggetto FieldComune di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField FieldComune = new JTextField("<Comune>");
    /**
     * Definisce la stringa visualizzata sull'oggetto FieldTipologia di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField FieldTipologia = new JTextField("<Tipologia>");
    /**
     * Definisce la stringa visualizzata sull'oggetto FieldNome di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField FieldNome = new JTextField("<Nome>");
    /**
     * Definisce la stringa visualizzata sull'oggetto FieldComuneT di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField FieldComuneT = new JTextField("<Comune>");
    /**
     * Definisce la stringa visualizzata sull'oggetto FieldCTipologia di tipo JTextField.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     */
    static JTextField FieldCTipologia = new JTextField("<Tipologia>");
    /**
     * Definisce un pulsante per poter avviare la ricerca di un ristorante.
     */
    JButton ricerca = new JButton("Avvia Ricerca");

    /**
     * Jpanel cards per permettere l'implementazione del layout manager di tipo cardLayout utilizzato per implementare la finestra.
     */
    JPanel cards;
    /**
     * Definisce una stringa possibile da visualizzare sull'oggetto selezioneRicerca di tipo JComboBox.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     *
     * <p>
     * &Egrave; dichiarato <strong>final</strong> rendendo impossibile la modifica delle stringhe contenute nell'array.
     * </p>
     */
    final static String ricercaComune = "Comune";
    /**
     * Definisce una stringa possibile da visualizzare sull'oggetto selezioneRicerca di tipo JComboBox.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     *
     * <p>
     * &Egrave; dichiarato <strong>final</strong> rendendo impossibile la modifica delle stringhe contenute nell'array.
     * </p>
     */
    final static String ricercaTipologia = "Tipologia [Italiano-Fusion-Etnico]";
    /**
     * Definisce una stringa possibile da visualizzare sull'oggetto selezioneRicerca di tipo JComboBox.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     *
     * <p>
     * &Egrave; dichiarato <strong>final</strong> rendendo impossibile la modifica delle stringhe contenute nell'array.
     * </p>
     */
    final static String ricercaNome = "Nome";
    /**
     * Definisce una stringa possibile da visualizzare sull'oggetto selezioneRicerca di tipo JComboBox.
     *
     * <p>
     * &Egrave; dichiarato <strong>static</strong> definendo una sola variabile per tutta la classe che memorizzera' valori costanti usati al di fuori della classe.
     * </p>
     *
     * <p>
     * &Egrave; dichiarato <strong>final</strong> rendendo impossibile la modifica delle stringhe contenute nell'array.
     * </p>
     */
    final static String ricercaComuneETipologia = "Comune e Tipologia";


    /**
     * Costruisce un nuovo oggetto che rappresenta la finestra utilizzata per ricercare un <code>Ristoratore</code>.
     */

    public C03RicercaRistoranteWindow(String nickname, boolean login) {
        super(".: EatAdvisor :. - CLIENTI (Ricerca Ristorante)");
        setSize(800, 600);
        setLocation(1200, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // MENU (MENUBAR - MENU - MENUITEMS)
        JMenuBar myBar = new JMenuBar();
        this.setJMenuBar(myBar);
        this.creaMenu(myBar);

        //Create and set up the content pane.
        JPanel comboBoxPane = new JPanel(new GridLayout(2,1));

        // JLABEL RICERCA RISTORANTE //
        JLabel labelBenvenuto = new JLabel("Area Ricerca Ristorante");
        labelBenvenuto.setHorizontalAlignment(JLabel.CENTER);
        labelBenvenuto.setFont(new Font("Courier", Font.PLAIN, 14));
        labelBenvenuto.setForeground(Color.BLUE);
        labelBenvenuto.setBackground(Color.WHITE);
        comboBoxPane.add(labelBenvenuto);


        //  JCOMBOBOX SELEZIONE RICERCA //
        String comboBoxItems[] = {ricercaComune, ricercaTipologia, ricercaNome, ricercaComuneETipologia};
        JComboBox selezioneRicerca = new JComboBox(comboBoxItems);
        selezioneRicerca.setEditable(false);
        //selezioneRicerca.setBounds(450, 49, 100, 25);
        selezioneRicerca.addItemListener(this);
        comboBoxPane.add(selezioneRicerca);

        //////////////////////////////////////////////////////////////////////////

        // CARD COMUNE  //
        JPanel Comune = new JPanel(null);

        //  JLABEL COMUNE  //
        JLabel labelComune = new JLabel("Ricerca per Comune:");
        labelComune.setHorizontalAlignment(JLabel.CENTER);
        labelComune.setForeground(Color.BLACK);
        labelComune.setBounds(300, 130, 200, 30);   //LA METà PRECISA DELLA X è 315
        Comune.add(labelComune);

        //  JTEXTFIELD COMUNE //
        FieldComune.setBounds(250, 165, 300, 30);
        FieldComune.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*FieldComune.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FieldComune.setText("");
            }
        });*/
        Comune.add(FieldComune);

        ///////////////////////////////////////////////////////////////////////////////////

        //  CARD TIPOLOGIA //
        JPanel Tipologia = new JPanel(null);

        //  JLABEL TIPOLOGIA  //
        JLabel labelTipologia = new JLabel("Ricerca per Tipologia:");
        labelTipologia.setHorizontalAlignment(JLabel.CENTER);
        labelTipologia.setForeground(Color.BLACK);
        labelTipologia.setBounds(300, 130, 200, 30);
        Tipologia.add(labelTipologia);

        //  JTEXTFIELD TIPOLOGIA  //
        FieldTipologia.setBounds(250, 165, 300, 30);
        FieldTipologia.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*FieldTipologia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FieldTipologia.setText("");
            }
        });*/
        Tipologia.add(FieldTipologia);

        ///////////////////////////////////////////////////////////////////////////////////////

        //  CARD NOME  //
        JPanel Nome = new JPanel(null);

        //  JLABEL NOME  //
        JLabel labelNome = new JLabel("Ricerca per Nome:");
        labelNome.setHorizontalAlignment(JLabel.CENTER);
        labelNome.setForeground(Color.BLACK);
        labelNome.setBounds(300, 130, 200, 30);               //LA METà PRECISA DELLA X è 315
        Nome.add(labelNome);


        //  JTEXTFIELD NOME //
        FieldNome.setBounds(250, 165, 300, 30);
        FieldNome.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*FieldNome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FieldNome.setText("");
            }
        });*/
        Nome.add(FieldNome);

        /////////////////////////////////////////////////////////////////////////////////////

        // CARD COMUNE E TIPOLOGIA  //
        JPanel ComuneETipologia = new JPanel(null);

        //  JLABEL COMUNE E TIPOLOGIA  //
        JLabel labelComuneTipologia = new JLabel("Ricerca per Comune e Tipologia");
        labelComuneTipologia.setHorizontalAlignment(JLabel.CENTER);
        labelComuneTipologia.setForeground(Color.BLACK);
        labelComuneTipologia.setBounds(300, 130, 200, 30);               //LA METà PRECISA DELLA X è 315
        ComuneETipologia.add(labelComuneTipologia);


        //  JTEXTFIELD COMUNE E TIPOLOGIA 1 //
        FieldComuneT.setBounds(68, 165, 300, 30);
        FieldComuneT.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*FieldComuneT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FieldComuneT.setText("");
            }
        });*/
        ComuneETipologia.add(FieldComuneT);


        //  JTEXTFIELD COMUNE E TIPOLOGIA 2 //
        FieldCTipologia.setBounds(413, 165, 300, 30);
        FieldComuneT.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField)e.getComponent();
                source.setText("");
                source.removeFocusListener(this);
            }
        });
        /*FieldCTipologia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FieldCTipologia.setText("");
            }
        });*/
        ComuneETipologia.add(FieldCTipologia);

        //////////////////////////////////////////////////////////////////////////

        //CREAZIONE DEL PANNELLO CHE CONTIENE LE "CARDS"
        cards = new JPanel(new CardLayout());
        cards.add(Comune, ricercaComune);
        cards.add(Tipologia, ricercaTipologia);
        cards.add(Nome, ricercaNome);
        cards.add(ComuneETipologia, ricercaComuneETipologia);

        this.getContentPane().add(comboBoxPane, BorderLayout.PAGE_START);
        this.getContentPane().add(cards, BorderLayout.CENTER);



        //  JBUTTON RICERCA  //
        JPanel ricercaPanel = new JPanel();
        //ricerca.setBounds(550, 450, 170, 30);
        ricerca.setToolTipText("Avvia Ricerca");
        ricercaPanel.add(ricerca);
        this.getContentPane().add(ricercaPanel, BorderLayout.PAGE_END);

        ricerca(selezioneRicerca, nickname, login);

        //Display the window.
        this.setVisible(true);
    }

    /**
     * Intercetta i cambi di stato legati al JComboBox presente nella finestra permettendo di visualizzare il JPanel corrispondente.
     *
     * @param event evento passato per parametro al metodo.
     */
    public void itemStateChanged(ItemEvent event) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)event.getItem());
    }


    /**
     * Metodo che effettua le ricerche
     *
     * @param selezioneRicerca la ricerca che voglio effettuare
     */
    public void ricerca(JComboBox selezioneRicerca, String nickname,  Boolean login){
        ricerca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selezione = (String)selezioneRicerca.getSelectedItem();

                if(selezione.equals(ricercaComune)){
                    if((getComuneRicerca().equals(FieldComune) || getComuneRicerca().equals(""))){
                        JOptionPane.showMessageDialog(null, "Ricerca per Comune : nessun criterio di ricerca inserito", " ERRORE RICERCA ", JOptionPane.INFORMATION_MESSAGE  );
                    }
                    else {
                        boolean verificaPresenza = false;
                        try {
                            //verificaPresenza = Cliente.ricercaPerComune(getComuneRicerca().toLowerCase());                 //stampa dei ristoratori e delle recensioni associate presenti nel file EatAdvisor.dati secondo i criteri di ricerca per comune
                            ArrayList<Ristoratore> presenza = Cliente.ricercaPerComune(getComuneRicerca().toLowerCase());
                            if(!(presenza.isEmpty()))
                                verificaPresenza = true;
                            if(verificaPresenza) {                                                                           //se sono presenti dei ristoranti che rispettano ivriteri di ricerca per comune apri la finestra con i risultati
                                C03RicercaRistoranteWindow.super.setVisible(false);
                                C06RisultatiRicercaWindow risultatiRicerca = new C06RisultatiRicercaWindow(presenza, nickname, login);        // all'interno dell'arrayList "presenza" sono contenuti tutti i
                                risultatiRicerca.setVisible(true);                                                           //ristoranti trovati secondo i criteri di per comune e tutte le recensioni associate a tutti i ristoratori (quindi è un arraylist di tipo Ristoratore), viene passato come parametro cosi' quando si costruisce
                                                                                                                             //la classe per visualizzare i risultati "C06RisultatiRicercaWindow" si hanno tutti gli elementi da fare visualizzare e se ne può dedurre la dimensione per contenerli nel gridLayout
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        }
                        if(!verificaPresenza)
                            JOptionPane.showMessageDialog(null, "Ricerca per Comune: nessun ristorante registrato in quel comune", " NESSUN RISTORANTE TROVATO ", JOptionPane.INFORMATION_MESSAGE  );

                    }

                }

                else if(selezione.equals(ricercaTipologia)){
                    if((getTipologiaRicerca().equals(FieldTipologia) || getTipologiaRicerca().equals(""))){
                        JOptionPane.showMessageDialog(null, "Ricerca per Tipologia : nessun criterio di ricerca inserito", " ERRORE RICERCA ", JOptionPane.INFORMATION_MESSAGE  );
                    }
                    else {
                        boolean verificaPresenza = false;
                        try {
                            ArrayList<Ristoratore> presenza = Cliente.ricercaPerTipologia(getTipologiaRicerca().toLowerCase());  //stampa dei ristoratori e delle recensioni associate presenti nel file EatAdvisor.dati secondo i criteri di ricerca per tipologia
                            if(!(presenza.isEmpty())){
                                verificaPresenza = true;                                                                         //se sono presenti dei ristoranti che rispettano ivriteri di ricerca per tipologia apri la finestra con i risultati
                                C03RicercaRistoranteWindow.super.setVisible(false);
                                C06RisultatiRicercaWindow risultatiRicerca = new C06RisultatiRicercaWindow(presenza, nickname, login);            // all'interno dell'arrayList "presenza" sono contenuti tutti i
                                risultatiRicerca.setVisible(true);                                                               //ristoranti trovati secondo i criteri di per comune e tutte le recensioni associate a tutti i ristoratori (quindi è un arraylist di tipo Ristoratore), viene passato come parametro cosi' quando si costruisce
                                                                                                                                 //la classe per visualizzare i risultati "C06RisultatiRicercaWindow" si hanno tutti gli elementi da fare visualizzare e se ne può dedurre la dimensione per contenerli nel gridLayout
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        }
                        if(!verificaPresenza)
                            JOptionPane.showMessageDialog(null, "Ricerca per Tipologia: nessun ristorante registrato appartenente a quella tipologia", " NESSUN RISTORANTE TROVATO ", JOptionPane.INFORMATION_MESSAGE  );
                    }
                }

                else if(selezione.equals(ricercaNome)){
                    if((getNomeRicerca().equals(FieldNome) || getNomeRicerca().equals(""))){
                        JOptionPane.showMessageDialog(null, "Ricerca per Nome : nessun criterio di ricerca inserito", " ERRORE RICERCA ", JOptionPane.INFORMATION_MESSAGE  );
                    }
                    else {
                        boolean verificaPresenza = false;
                        try {
                            ArrayList<Ristoratore> presenza = Cliente.ricercaPerNome(getNomeRicerca().toLowerCase());             //stampa dei ristoratori e delle recensioni associate presenti nel file EatAdvisor.dati secondo i criteri di ricerca per nome
                            if(!(presenza.isEmpty())){
                                verificaPresenza = true;
                                C03RicercaRistoranteWindow.super.setVisible(false);                                               //se sono presenti dei ristoranti che rispettano i criteri di ricerca per nome apri la finestra con i risultati
                                C06RisultatiRicercaWindow risultatiRicerca = new C06RisultatiRicercaWindow(presenza, nickname, login);             // all'interno dell'arrayList "presenza" sono contenuti tutti i
                                risultatiRicerca.setVisible(true);                                                                //ristoranti trovati secondo i criteri di per comune e tutte le recensioni associate a tutti i ristoratori (quindi è un arraylist di tipo Ristoratore), viene passato come parametro cosi' quando si costruisce
                                                                                                                                  //la classe per visualizzare i risultati "C06RisultatiRicercaWindow" si hanno tutti gli elementi da fare visualizzare e se ne può dedurre la dimensione per contenerli nel gridLayout
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        }
                        if(!verificaPresenza)
                            JOptionPane.showMessageDialog(null, "Ricerca per Nome: nessun ristorante registrato avente il nome specificato", " NESSUN RISTORANTE TROVATO ", JOptionPane.INFORMATION_MESSAGE  );
                    }
                }


                else if(selezione.equals(ricercaComuneETipologia)){
                    if((getComuneTRicerca().equals(FieldComuneT) || getComuneTRicerca().equals("")) && (getCTipologiaRicerca().equals(FieldCTipologia) || getCTipologiaRicerca().equals(""))){
                        JOptionPane.showMessageDialog(null, "Ricerca per Comune e Tipologia : nessun criterio di ricerca inserito", " ERRORE RICERCA ", JOptionPane.INFORMATION_MESSAGE  );
                    }
                    else {
                        boolean verificaPresenza = false;
                        try {
                            ArrayList<Ristoratore> presenza = Cliente.ricercaPerComuneTipologia(getComuneTRicerca().toLowerCase(),getCTipologiaRicerca().toLowerCase() ); //stampa dei ristoratori e delle recensioni associate presenti nel file EatAdvisor.dati secondo i criteri di ricerca per comune e tipologia
                            if(!(presenza.isEmpty())){
                                verificaPresenza = true;
                                C03RicercaRistoranteWindow.super.setVisible(false);                                               //se sono presenti dei ristoranti che rispettano ivriteri di ricerca per nome apri la finestra con i risultati
                                C06RisultatiRicercaWindow risultatiRicerca = new C06RisultatiRicercaWindow(presenza, nickname, login);             // all'interno dell'arrayList "presenza" sono contenuti tutti i
                                risultatiRicerca.setVisible(true);                                                                //ristoranti trovati secondo i criteri di per comune e tipologia e tutte le recensioni associate a tutti i ristoratori (quindi è un arraylist di tipo Ristoratore), viene passato come parametro cosi' quando si costruisce
                                                                                                                                  //la classe per visualizzare i risultati "C06RisultatiRicercaWindow" si hanno tutti gli elementi da fare visualizzare e se ne può dedurre la dimensione per contenerli nel gridLayout
                            }
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        }
                        if(!verificaPresenza)
                            JOptionPane.showMessageDialog(null, "Ricerca per Comune e Tipologia: nessun ristorante registrato in quel comune e tipoogia", " NESSUN RISTORANTE TROVATO ", JOptionPane.INFORMATION_MESSAGE  );
                    }
                }

                else JOptionPane.showMessageDialog(null, "Compilare il campo ricerca per poterne effettuare una", " NESSUN RISTORANTE TROVATO ", JOptionPane.INFORMATION_MESSAGE  );

            }
        });
    }


    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del comune all'interno della finestra.
     *
     * @return String.
     */
    public static String getComuneRicerca() { return FieldComune.getText(); }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura della tipologia all'interno della finestra.
     *
     * @return String.
     */
    public static String getTipologiaRicerca() { return FieldTipologia.getText(); }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del nome all'interno della finestra.
     *
     * @return String.
     */
    public static String getNomeRicerca() { return FieldNome.getText(); }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura del comune all'interno della finestra.
     *
     * @return String.
     */
    public static String getComuneTRicerca() { return FieldComuneT.getText(); }

    /**
     * Restituisce una stringa che descrive il contenuto della JTextField dedicata alla scrittura della tipologia all'interno della finestra.
     *
     * @return String.
     */
    public static String getCTipologiaRicerca() { return FieldCTipologia.getText(); }


    /**
     * Genera la MenuBar e tutti i sotto-menu
     *
     * @param b Menubar
     */
    private void creaMenu(JMenuBar b){
        InserimentoClienteMenuListener mL = new InserimentoClienteMenuListener(this);
        JMenu f = new JMenu("File");
        JMenuItem f1 = new JMenuItem("Nuova Ricerca");
        JMenuItem f2 = new JMenuItem("Cancella Ricerca");
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
        JMenuItem e2 = new JMenuItem("Inserimento Cliente");
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
    public static void resetRicerca(){
        FieldComune.setText("");
        FieldTipologia.setText("");
        FieldNome.setText("");
        FieldComuneT.setText("");
        FieldCTipologia.setText("");
    }

    /**
     * Setta tutti gli attributi della classe con i valori predefiniti.
     */
    public static void nuovaRicerca(){
        FieldComune.setText("<Comune>");
        FieldTipologia.setText("<Tipologia>");
        FieldNome.setText("<Nome>");
        FieldComuneT.setText("<Comune>");
        FieldCTipologia.setText("<Tipologia>");

    }

}
