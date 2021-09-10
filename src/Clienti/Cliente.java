package Clienti;

import Common.Giudizio;
import Common.ProgUtili;
import Ristoratori.Ristoratore;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Le sue istanze rappresentano <strong>Clienti</strong>
 */
public class Cliente implements Serializable {

    /**
     * Fornisce il nome dell'oggetto <code>Cliente</code>.
     *
     * <p>
     * &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String nome;
    /**
     * Fornisce il cognome dell'oggetto <code>Cliente</code>.
     *
     * <p>
     * &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String cognome;
    /**
     * Fornisce il comune dell'oggetto <code>Cliente</code>.
     *
     * <p>
     * &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String comune;
    /**
     * Fornisce la provincia dell'oggetto <code>Cliente</code>.
     *
     * <p>
     * &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String provincia;
    /**
     * Fornisce l'e-mail dell'oggetto <code>Cliente</code>.
     *
     * <p>
     * &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String email;
    /**
     * Fornisce il nickname dell'oggetto <code>Cliente</code>.
     *
     * <p>
     * &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String nickname;
    /**
     * Fornisce la password dell'oggetto <code>Cliente</code>.
     *
     * <p>
     * &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String password;

    //COSTRUTTORI
    /**
     * Costruisce un nuovo oggetto che rappresenta un <code>Cliente</code>.
     */
    public Cliente() { }

    /**
     * Costruisce un nuovo oggetto che rappresenta un ristorante in cui sono presenti le informazioni specificate dall'argomento.
     *
     * @param nome      Nome
     * @param cognome   Cognome
     * @param comune    Comune
     * @param provincia Provincia
     * @param email     E-mail
     * @param nickname  Nickname
     * @param password  Password
     */

    public Cliente(String nome, String cognome, String comune, String provincia, String email, String nickname, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.comune = comune;
        this.provincia = provincia;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }


    /*/**
     * Inserisci cliente array list.
     *
     * @param ref the ref
     * @return the array list
     */

    /*public static ArrayList inserisciCliente(ArrayList ref) {
        Scanner cliente = new Scanner(System.in);
        String regex;
        System.out.println("Inserire i dati necessari per la registrazione nuovo cliente. BUON INSERIMENTO");

        System.out.print("Nickname: ");          //metodo per verificare che il nickname inserito dall'utente non sia già utilizzato
        String nickname = cliente.nextLine();    //per essere utilizzato deve essere già presente nel file Utenti.data
        String line;
        int i;
        Scanner reader = new Scanner("bin" + File.separatorChar + "data" + File.separatorChar + "Utenti.dati");
        while (reader.hasNextLine()) {
            line = reader.nextLine();
            i = line.indexOf(nickname);
            if (i != 0) {
                System.err.print("Nickname già utilizzato: ");
                nickname = cliente.nextLine();
            }
        }
        reader.close();

        System.out.print("Password: ");
        String password = cliente.nextLine();

        System.out.print("Nome: ");
        String nome = cliente.nextLine();
        regex = "[a-zA-Zàèìòù]+[0-9]{0}"; //controllo che la stringa immessa dall'utente contenga solamente lettere da 'a' a 'z' (anche maiuscole) che si possono ripetere una o più volte
        while (!(Pattern.matches(regex, nome))) {
            System.out.print("Inserimento non valido, si prega di digitare il nome cliente con caratteri alfabetici: ");
            nome = cliente.nextLine();
        }

        System.out.print("Cognome: ");
        String cognome = cliente.nextLine();
        regex = "[a-zA-Zàèìòù]+[0-9]{0}";             //controllo che la stringa immessa dall'utente contenga solamente lettere da 'a' a 'z' (anche maiuscole) che si possono ripetere una o più volte
        while (!(Pattern.matches(regex, cognome))) {
            System.err.print("Inserimento non valido, si prega di digitare il cognome cliente con caratteri alfabetici: ");
            cognome = cliente.nextLine();
        }

        System.out.print("Comune: ");
        String comune = cliente.nextLine();
        regex = "[a-zA-Zàèìòù]+[0-9]{0}";             //controllo che la stringa immessa dall'utente contenga solamente lettere da 'a' a 'z' (anche maiuscole) che si possono ripetere una o più volte
        while (!(Pattern.matches(regex, comune))) {
            System.err.print("Inserimento non valido, si prega di digitare il comune di residenza con caratteri alfabetici: ");
            comune = cliente.nextLine();
        }

        System.out.print("Provincia [Sigla]: ");    // Controllo che sia solo di due caratteri
        String provincia = cliente.nextLine();
        regex = "[a-zA-Z]{2}";
        while (!(Pattern.matches(regex, provincia))) {
            System.err.println("Inserimento non valido, si prega di digitare la provincia con caratteri alfabetici: ");
            provincia = cliente.nextLine();
        }

        System.out.print("Email: ");
        String email = cliente.nextLine();
        regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        while (!(Pattern.matches(regex, email))) {
            System.err.print("Email non valida, non rispetta lo standard RFC 5322: ");
            email = cliente.nextLine();
        }


        Cliente c = new Cliente(nome, cognome, comune, provincia, email, nickname, password);

        ref.add(c);
        return ref;
    }*/

    /**
     * Registra il cliente fornito per argomento nel file Utenti.dati.
     *
     * @param c ArrayList contente Clienti.
     * @throws IOException .
     */
    public static void registraCliente(ArrayList c) throws IOException {
        File f = new File(ProgUtili.getUtentiPathName());
        ObjectOutputStream eatAdvisor = new ObjectOutputStream(new FileOutputStream(f));
        eatAdvisor.writeObject(c);
        eatAdvisor.close();
        System.out.println("Arraylist Cliente  aggiunto correttamente al file 'Utenti.dati'.");
    }

    /**
     * Restituisce true se e solo se il cliente rappresentato dall'oggetto che esegue il metodo &egrave; uguale a quello specificato tramite l'argomento.
     *
     * @param c Oggetto passato come parametro al metodo
     * @return boolean
     */
    public boolean equals(Cliente c) {
        return this.toString().equals(c.toString());
    }

    /**
     * Restituisce una stringa che descrive il <code>Cliente</code> rappresentato dall'oggetto che esegue il metodo.
     * @return String
     */
    public String toString() {
        return    "NOME: " + nome +
                "\nCOGNOME: " + cognome +
                "\nCOMUNE: " + comune +
                "\nPROVINCIA: " + provincia +
                "\nE-MAIL: " + email +
                "\nNICKNAME: " + nickname +
                "\nPASSWORD: " + password +
                "\n----------------------------------";
    }

    /**
     * Effettua una ticerca per comune tra i vari ristoratori presenti nel file EatAdvisor.dati.
     *
     * @param Comune comune
     * @return ArrayList
     * @throws IOException            .
     * @throws ClassNotFoundException .
     */
    public static ArrayList ricercaPerComune(String Comune) throws IOException, ClassNotFoundException {        //metodo che prende come parametro una stringa corrispondente al comune per il quale si vuole effettuare la ricerca
        FileInputStream fis = new FileInputStream(ProgUtili.getEatadvisorPathName());                           //tramite un ObjectInputStream realizzato tramite un FileInputStream si effettua la lettura degli oggetti serializzati
        ObjectInputStream in = new ObjectInputStream(fis);                                                      //sul file EatAdvisor.Dati, verrà letto un arraylist di Ristoratori, percui all'interno del metodo ricercaPerComune si effettuerà
                                                                                                                //la visita di ogni elememto dell'arraylist. Per ogni ristoratore visitato si verifica che non sia un giudizio (l'oggetto Giudizio è sottoclasse di Ristorantore)
        //try {                                                                                                 // e si verifica che il comune con cui è registrato il ristoratore sia uguale rispetto al criterio di ricerca, se queste due condizioni sono verificate
            //while (true) { //controlla se lo stream di file è arrivato alla fine                              //(il ristoratore viene stampato  consolle) e aggiunto all'interno dell'arrayylist restituito al termine della chiamat del metodo ricercaPerComune


        ArrayList<Ristoratore> risultati = new ArrayList<Ristoratore>();  //boolean verificaPresenza = false;
        ArrayList<Ristoratore> ref = (ArrayList<Ristoratore>) in.readObject();
            for (Ristoratore r : ref){
                if(!(r instanceof Giudizio) && (r.getIndComune().toLowerCase().equals(Comune))) {
                    //System.out.println("\n" + r.toString());
                    risultati.add(r);
                }
                if(r instanceof Giudizio) risultati.add(r);
            }

        in.close();
        fis.close();
        return risultati;

    }

    /**
     * Effettua una ticerca per tipologia tra i vari ristoratori presenti nel file EatAdvisor.dati.
     *
     * @param Tipologia tipologia
     * @return ArrayList
     * @throws IOException            .
     * @throws ClassNotFoundException .
     */
    public static ArrayList ricercaPerTipologia(String Tipologia) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(ProgUtili.getEatadvisorPathName());
        ObjectInputStream in = new ObjectInputStream(fis);

        ArrayList<Ristoratore> risultati = new ArrayList<Ristoratore>();
        ArrayList<Ristoratore> ref = (ArrayList<Ristoratore>) in.readObject();
                for (Ristoratore r : ref) {
                    if (!(r instanceof Giudizio) && (r.getTipologia().toLowerCase().equals(Tipologia))) {
                        //System.out.println("\n" + r.toString());
                        risultati.add(r);
                    }
                    if(r instanceof Giudizio) risultati.add(r);
                }

        in.close();
        fis.close();
        return risultati;
    }

    /**
     * Effettua una ticerca per nome tra i vari ristoratori presenti nel file EatAdvisor.dati.
     *
     * @param Nome nome
     * @return ArrayList
     * @throws IOException            .
     * @throws ClassNotFoundException .
     */
    public static ArrayList ricercaPerNome(String Nome) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(ProgUtili.getEatadvisorPathName());
        ObjectInputStream in = new ObjectInputStream(fis);

        ArrayList<Ristoratore> risultati = new ArrayList<Ristoratore>();
        ArrayList<Ristoratore> ref = (ArrayList<Ristoratore>) in.readObject();
                for (Ristoratore r : ref) {
                    if(!(r instanceof Giudizio) && (r.getNome().toLowerCase().contains(Nome))) {
                        risultati.add(r);
                    }
                    if(r instanceof Giudizio) risultati.add(r);
            }

        in.close();
        fis.close();
        return risultati;
    }

    /**
     * Effettua una ticerca per comune e tipologia tra i vari ristoratori presenti nel file EatAdvisor.dati.
     *
     * @param Comune    comune
     * @param Tipologia tipologia
     * @return ArrayList
     * @throws IOException            .
     * @throws ClassNotFoundException .
     */
    public static ArrayList ricercaPerComuneTipologia(String Comune, String Tipologia) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(ProgUtili.getEatadvisorPathName());
        ObjectInputStream in = new ObjectInputStream(fis);

        ArrayList<Ristoratore> risultati = new ArrayList<Ristoratore>();
                ArrayList<Ristoratore> ref = (ArrayList<Ristoratore>) in.readObject();
                for (Ristoratore r : ref) {
                    if(!(r instanceof Giudizio) && (r.getIndComune().toLowerCase().equals(Comune) && r.getTipologia().toLowerCase().equals(Tipologia))) {
                        //System.out.println("\n" + r.toString());
                        risultati.add(r);
                    }
                    if(r instanceof Giudizio) risultati.add(r);
            }
        in.close();
        fis.close();
        return risultati;
    }

    /**
     * Restituisce una stringa che descrive il nickname rappresentato dall'oggetto che esegue il metodo.
     *
     * @return nickname
     */
    public String getNickname() { return nickname; }

    /**
     * Restituisce una stringa che descrive la password rappresentata dall'oggetto che esegue il metodo.
     *
     * @return password
     */
    public String getPassword() { return password; }
}