package Clienti;

import Common.ProgUtili;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Finestra principale dell'applicazione <strong>Clienti</strong>
 * @see Clienti
 */
public class C01MainWindow extends JFrame {

    /**
     * Definisce un pulsante per poter registrare un Cliente
     */
    JButton click01 = new JButton("Registra Cliente");
    /**
     * Definisce un pulsante per poter ricercare un ristoratore
     */
    JButton click02 = new JButton("Ricerca Ristorante");
    /**
     * Definisce un pulsante per poter effettuare il login
     *
     */
    JButton click03 = new JButton("Login (Area Riservata)");
    /**
     * Pulsante Easter Egg ;-)
     */
    JButton click04 = new JButton("R");

    /**
     * Costruisce un nuovo oggetto che rappresenta la finestra visualizzata all'avvio dell'applicazione <code>Clienti</code>.
     *
     * @throws IOException .
     */
//COSTRUTTORI
    public C01MainWindow() throws IOException {
        super(".: EatAdvisor :. - CLIENTI - [Casalnovo / Dubini @ UnInsubria]" + "              " + ProgUtili.stampaData() + "   |   " + ProgUtili.getOsName());
        setSize(800, 600);
        setLocation(1200, 300);
        //setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // MENU (MENUBAR - MENU - MENUITEMS)
        JMenuBar myBar = new JMenuBar();
        setJMenuBar(myBar);
        creaMenu(myBar);

        JPanel panel00 = new JPanel(null);  // FINESTRA PRINCIPALE

        //  JPANEL  //
        JLabel labelBenvenuto = new JLabel("Benvenuto Cliente !");
        labelBenvenuto.setHorizontalAlignment(JLabel.CENTER);
        labelBenvenuto.setForeground(Color.BLUE);
        labelBenvenuto.setBounds(0, 0, 800, 60);
        panel00.add(labelBenvenuto);

        /*
        // AGGIUNTA DEL LOGO EAT-ADVISOR in SRC
        BufferedImage icon = ImageIO.read(new File("src" + File.separatorChar + "Common" + File.separatorChar + "eatadvisor.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(icon));
        picLabel.setBounds(0,0,800, 260);
        panel00.add(picLabel); */


        // AGGIUNTA DEL LOGO EAT-ADVISOR in BIN/Common e in SRC)
        if (new File("Common" + File.separatorChar + "eatadvisor.jpg").exists()){
            BufferedImage icon1 = ImageIO.read(new File("Common" + File.separatorChar + "eatadvisor.jpg"));
            JLabel picLabel1 = new JLabel(new ImageIcon(icon1));
            picLabel1.setBounds(0,0,800, 260);
            panel00.add(picLabel1);
        }

        else if (new File("src" + File.separatorChar + "Common" + File.separatorChar + "eatadvisor.jpg").exists()) {
            BufferedImage icon = ImageIO.read(new File("src" + File.separatorChar + "Common" + File.separatorChar + "eatadvisor.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(icon));
            picLabel.setBounds(0, 0, 800, 260);
            panel00.add(picLabel);
        }

        // AGGIUNTA DEI PULSANTI
        click01.setBounds(325, 330, 170, 25);
        click02.setBounds(325, 365, 170, 25);
        click03.setBounds(325, 400, 170, 25);
        click04.setBounds(770,530,25,25);
        click04.setForeground(Color.WHITE);
        panel00.add(click01);
        click01.setToolTipText("Registra Cliente");
        panel00.add(click02);
        click02.setToolTipText("Ricerca Ristorante");
        panel00.add(click03);
        click03.setToolTipText("Area Riservata");
        panel00.add(click04);
        click04.setToolTipText("Ecco la risposta che cercavi...");

        // SCRITTA COPYRIGHT
        JLabel labelFondo = new JLabel(" (C) Tutti i diritti di questo fantastico software sono momentanemante liberi, ma se lo copiate almeno una birra.... Grazie.");
        labelFondo.setHorizontalAlignment(JLabel.LEFT);
        labelFondo.setForeground(Color.BLACK);
        labelFondo.setBounds(0, 0, 800, 1090);
        panel00.add(labelFondo);


        getContentPane().add(panel00).setBackground(Color.WHITE);
        actionRegistraCliente();

        setVisible(true);
    }


    /**
     * Genera la MenuBar e tutti i sotto-menu.
     *
     * @param b  Menubar
     */
    private void creaMenu(JMenuBar b) {
        InserimentoClienteMenuListener mL = new InserimentoClienteMenuListener(this);
        JMenu f = new JMenu("File");
        //JMenuItem f1 = new JMenuItem("Nuovo inserimento");
        JMenuItem f5 = new JMenuItem("Chiudi");
        //f1.addActionListener(mL);
        f5.addActionListener(mL);
        //f.add(f1);
        f.add(f5);
        b.add(f);

        JMenu v = new JMenu("DEBUG");
        JMenuItem v1 = new JMenuItem("Mostra tutti Ristoranti");
        JMenuItem v2 = new JMenuItem("Mostra tutti Clienti");
        v1.addActionListener(mL);
        v2.addActionListener(mL);
        v.add(v1);
        v.add(v2);
        b.add(v);

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
     * Implementa un Listener per l'apertura di nuove finestre all'interno dell'applicazione.
     */
    public void actionRegistraCliente() {
        click01.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                C01MainWindow.super.setVisible(false);
                C02InserimentoClienteWindow registraCliente = new C02InserimentoClienteWindow(false);
                registraCliente.setVisible(true);
            }
        });

        click02.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                C01MainWindow.super.setVisible(false);
                C03RicercaRistoranteWindow ricercaRistorante = new C03RicercaRistoranteWindow(null, false);
                ricercaRistorante.setVisible(true);
            }
        });

        click03.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                C01MainWindow.super.setVisible(false);
                C04LoginWindow login = new C04LoginWindow();
                login.setVisible(true);
            }
        });

        click04.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon("src" + File.separatorChar + "Common" + File.separatorChar + "qd.jpg");

                JOptionPane.showMessageDialog(null, "... dopo 7,5 milioni di\n anni di elaborazione....  42.",
                        "La risposta alla domanda è...",JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });
    }

}

