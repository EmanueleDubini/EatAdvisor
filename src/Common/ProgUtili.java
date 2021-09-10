package Common;

import Clienti.Cliente;
import Ristoratori.Ristoratore;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe che contiene metodi utili di servizio comuni a antrembe le applicazioni
 *
 * <p>
 * @version 1.0
 * </p>
 *
 * <p>
 * @author CASALNOVO Giacomo | 740003
 * @author DUBINI Emanuele   | 740954
 * </p>
 */
public class ProgUtili {


    /**
     * Effettua la pulizia dello schermo a console.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * E' richiesto che venga creata / modificata nella sottocartella "data" se non esiste
     */
    public static void createDataFolder() {
        File dirData = new File("data");
        if (dirData.exists())
            System.out.println("\nLa sottocartella 'data' esiste! Nessuna modifica viene fatta.");
        else {
            System.out.println("\nLa sottocartella 'data' NON esiste!");
            System.out.println("Creazione....");
            String dir = "data";
            new File(dir).mkdir();
        }
    }

    /**
     * Create eatadvisor file.
     *
     * @throws IOException the io exception
     */
    public static void createEatadvisorFile() throws IOException {
        String dirData = "data";
        // String fileName = "EatAdvisor.dati";

        // System.out.println("DEBUG: path: " + dirData + File.separatorChar);
        // System.out.println("DEBUG: File.separatorChar: " + File.separatorChar);
        PrintWriter eatAdvisor = new PrintWriter(new FileWriter(dirData + File.separatorChar + "EatAdvisor.dati", true));

        eatAdvisor.println("Prova per vedere se ci sscrive dentro");
        eatAdvisor.println("qui scrive ancora senza cancellare uello vecchio che commento");
        eatAdvisor.close();

    }

    /**
     * Create utenti file.
     *
     * @throws IOException the io exception
     */
    public static void createUtentiFile() throws IOException {
        String dirData = "data";
        // String fileName = "Utenti.dati";

        // System.out.println("DEBUG: path: " + dirData + File.separatorChar);
        // System.out.println("DEBUG: File.separatorChar: " + File.separatorChar);
        PrintWriter eatAdvisor = new PrintWriter(new FileWriter(dirData + File.separatorChar + "Utenti.dati", true));

        eatAdvisor.println("Prova per vedere se ci sscrive dentro");
        eatAdvisor.println("qui scrive ancora senza cancellare uello vecchio che commento");
        eatAdvisor.close();

    }

    /**
     * Crea un codice numerico univoco casuale da associare a ogni ristorante.
     *
     * @return String composta dall'id a due cifre.
     */
    public static String createId() {
        DecimalFormat df = new DecimalFormat("00");
        return df.format(((Math.random() * 100) + 100) % 100);
    }

    /**
     * Visualizza informazioni.
     *
     * @throws IOException .
     */
    public static void visualizzaInformazioni() throws IOException {
        File utenti = new File("data" + File.separatorChar + "Utenti.dati");
        BufferedReader reader = new BufferedReader(new FileReader(utenti));

        // 2 prova STAMPA TUTTE LINEE DEL FILE UTENTI.DATI
        System.out.println("DEBUG: Prova con Arraylist\n");
        ArrayList<String> ristorantiList = new ArrayList<>();
        String s = reader.readLine();
        while (s != null) {
            ristorantiList.add(s);
            s = reader.readLine();
        }

        for (int i = 0; i < ristorantiList.size(); i++) {
            System.out.println(ristorantiList.get(i));
        }

        reader.close();
    }

    /**
     * Verifica che il file EatAdvisor.dati esiste.
     *
     * @throws IOException         .
     * @throws EatAdvisorException .
     */
    public static void checkEatAdvisor() throws IOException, EatAdvisorException {
        File EatAdvisor = new File(getEatadvisorPathName());

        if (EatAdvisor.createNewFile()) {
            System.err.println("EatAdvisor.dati non esiste");
            EatAdvisor.renameTo(EatAdvisor);    //l'estensione .dati la prende dal percorso
            System.out.println("Creazione file EatAdvisor.dati...");
            System.out.println("Il file EatAdvisor.dati è stato creato");
            //throw new EatAdvisorException();
        } else if (!EatAdvisor.canRead()) {
            throw new EatAdvisorException("EatAdvisor.dati non può essere letto");
        } else if (!EatAdvisor.canWrite()) {
            throw new EatAdvisorException("EatAdvisor.dati non può essere scritto");
        }

    }

    /**
     * Verifica che il file Utenti.dati esiste.
     *
     * @throws UtentiException .
     * @throws IOException     .
     */
    public static void checkUtenti() throws UtentiException, IOException {
        File Utenti = new File(getUtentiPathName());

        if (Utenti.createNewFile()) {
            System.err.println("Utenti.dati non esiste");
            Utenti.renameTo(Utenti);    //l'estensione .dati la prende dal percorso
            System.out.println("Creazione file Utenti.dati...");
            System.out.println("Il file Utenti.dati è stato creato");

        } else if (!Utenti.canRead()) {
            throw new UtentiException("Utenti.dati non può essere letto");

        } else if (!Utenti.canWrite()) {
            throw new UtentiException("Utenti.dati non può essere letto");
        }
    }

    /**
     * Stampa la data odierna.
     *
     * @return La data in formato gg-mm-aaaa.
     */
    public static String stampaData() {
        Date oggi = new Date(); // Data di oggi
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return sdf.format(oggi);
    }

    /**
     * Stampa il file EatAdvisor.dati e le recensioni dei ristoranti
     *
     * @throws IOException .
     */
    public static void stampaEatAdvisor() throws IOException {
        FileInputStream in = new FileInputStream(getEatadvisorPathName());
        ObjectInputStream s = new ObjectInputStream(in);

        System.out.println("Stampa di tutti i ristoratori presenti nel file EatAdvisor.dati: \n");
        try {
            while (true) { //controlla se lo stream di file è arrivato alla fine
                ArrayList<Ristoratore> ref = (ArrayList<Ristoratore>) s.readObject();
                for (Ristoratore r : ref) {
                    if (!(r instanceof Giudizio)) {
                        System.out.println(r.toString());
                    }
                }
            }
        } catch (EOFException | ClassNotFoundException e) {
        } finally {
            in.close();
            s.close();
        }

        in = new FileInputStream(getEatadvisorPathName());
        s = new ObjectInputStream(in);

        System.out.println("Stampa di tutte le recensioni presenti nel file EatAdvisor.dati: \n");
        try {
            while (true) { //controlla se lo stream di file è arrivato alla fine
                ArrayList<Ristoratore> ref = (ArrayList<Ristoratore>) s.readObject();
                for (Ristoratore r : ref) {
                    if (r instanceof Giudizio)
                        System.out.println(r.toString());
                }
            }
        } catch (EOFException | ClassNotFoundException e) {
        } finally {
            in.close();
            s.close();
        }
    }

    /**
     * Leggi EatAdvisor ArrayList.
     *
     * @return ArrayList.
     */
    public static ArrayList leggiEatAdvisor() {
        ArrayList<Ristoratore> ristoratoreList = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream(getEatadvisorPathName());
            ObjectInputStream in = new ObjectInputStream(fis);

            while (true) { //controlla se lo stream di file è arrivato alla fine
                ArrayList<Ristoratore> ref = (ArrayList<Ristoratore>) in.readObject();
                for (Ristoratore r :  ref) {
                    ristoratoreList.add(r);
                }
            }
        } catch (EOFException | FileNotFoundException e) {
            System.out.println("leggiEatAdvisor() eseguito!");  //messo puramente per controllo
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ristoratoreList;
    }

    /**
     * Leggi Utenti ArrayList.
     *
     * @return ArrayList.
     */
    public static ArrayList leggiUtenti() {
        ArrayList<Cliente> clienteList = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream(getUtentiPathName());
            ObjectInputStream in = new ObjectInputStream(fis);

            while (true) { //controlla se lo stream di file è arrivato alla fine
                ArrayList<Cliente> ref = (ArrayList<Cliente>) in.readObject();
                for (Cliente c : ref) {
                    clienteList.add(c);
                }
            }
        } catch (EOFException | FileNotFoundException e) {
            System.out.println("leggiUtenti() eseguito!");  //messo puramente per controllo
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            e.printStackTrace();
        }
        return clienteList;
    }

    /**
     * Stampa utenti presenti nel file Utenti.dati.
     *
     * @throws IOException            .
     * @throws ClassNotFoundException .
     */
    public static void stampaUtenti() throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(getUtentiPathName());
        ObjectInputStream s = new ObjectInputStream(in);

        System.out.println("Stampa di tutti i clienti presenti nel file Utenti.dati: \n");
        try {
            while (true) { //controlla se lo stream di file è arrivato alla fine
                ArrayList<Cliente> ref = (ArrayList<Cliente>) s.readObject();
                for ( Cliente c : ref) {
                    System.out.println(c.toString());
                }
            }
        } catch (EOFException e) {
        } finally {
            in.close();
            s.close();
        }

    }

    /**
     * Restituisce il Sistema Operativo.
     *
     * @return Sistema Operativo.
     */
    public static String getOsName(){
        return System.getProperty("os.name");
    }


    /**
     * Verifica login boolean.
     *
     * @param nickname Nickname <code>Cliente</code>
     * @param password Password <code>Cliente</code>
     * @return Boolean
     * @throws IOException            .
     * @throws ClassNotFoundException .
     */
    public static boolean verificaLogin(String nickname, String password) throws IOException, ClassNotFoundException {
        //ArrayList<Cliente> loginList = new ArrayList();

            FileInputStream fis = new FileInputStream(getUtentiPathName());
            ObjectInputStream in = new ObjectInputStream(fis);

            //while (true) { //controlla se lo stream di file è arrivato alla fine
                ArrayList<Cliente> ref = (ArrayList<Cliente>) in.readObject();
                for (Cliente c : ref) {
                    //loginList.add(c);
                    if ((c.getNickname().equals(nickname)) && c.getPassword().equals(password))
                        return true;
                }
        return false;
            //}

    }

    /**
     * Restituisce il path del file EatAdvisor.
     *
     * @return Stringa contenente il Path del file EatAdvisor.
     */
    public static String getEatadvisorPathName() {
        String eatAdvisorDir = System.getProperty("user.dir"); // ritorna la cartella di lavoro corrente, in questo caso è la "bin"
        String bin = "bin";
        String x = null;
        String newEatAdvisorPath;


        String path = ProgUtili.class.getResource("ProgUtili.class").toString();
        if(path.startsWith("jar")){
            x = eatAdvisorDir.substring(0, eatAdvisorDir.length() - bin.length());
            newEatAdvisorPath = x + "data" + File.separator + "EatAdvisor.dati";
        }
        else {
            newEatAdvisorPath = eatAdvisorDir + File.separator + "data" + File.separator + "EatAdvisor.dati";
        }

        System.err.println("DEBUG: Costruiamo i percorsi del files dei dati (cartella /data) che sta fuori dalla /bin\n");
        System.err.println("  * Percorso di EatAdvisor (eatAdvisorDir) x Ristoratori: " + eatAdvisorDir);
        //System.err.println("x: " + x); // questa è solo una variabile temporanea per costruire il nuovo percorso se EatAdvisor è fatto eseguire dal Jar
        System.err.println("  * Percorso che punta al file dati corretto (newEatAdvisorPath): " + newEatAdvisorPath + "\n");

        return newEatAdvisorPath;
    }

    /**
     * Restituisce il path del file Utenti.
     *
     * @return Stringa contenente il Path del file Utenti.
     */
    public static String getUtentiPathName() {
        String UtentiDir = System.getProperty("user.dir");
        String bin = "bin";
        String x = null;
        String newUtentiPath;


        String path = ProgUtili.class.getResource("ProgUtili.class").toString();
        if(path.startsWith("jar")){
            x = UtentiDir.substring(0, UtentiDir.length() - bin.length());
            newUtentiPath = x + "data" + File.separator + "Utenti.dati";
        }
        else {

            newUtentiPath = UtentiDir + File.separator + "data" + File.separator + "Utenti.dati";
        }

        System.err.println("  * Percorso di EatAdvisor (UtentiDir) x Clienti: " + UtentiDir);
        //System.err.println("x: " + x); // questa è solo una variabile temporanea per costruire il nuovo percorso se EatAdvisor è fatto eseguire dal Jar
        System.err.println("  * Percorso che punta al file dati corretto (newUtentiPath): " + newUtentiPath);

        return newUtentiPath;
    }
}
