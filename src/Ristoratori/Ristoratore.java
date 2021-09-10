package Ristoratori;

import Common.ProgUtili;

import java.io.*;
import java.util.ArrayList;

/**
 * Le sue istanze rappresentano <strong>Ristoratori</strong>.
 * @see Ristoratori
 */
public class Ristoratore implements Serializable {

    //CAMPI
    /**
     * Fornisce l'id dell'oggetto <code>Ristoratore</code>.
     *
     * <p>
     *  &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String id;

    /**
     * Fornisce il nome dell'oggetto <code>Ristoratore</code>.
     *
     * <p>
     *  &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String nome;

    /**
     * Fornisce il qualificatore relativo all'oggetto <code>Ristoratore</code>.
     *
     * <p>
     *  &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String indQualificatore;

    /**
     * Fornisce il nome della via dell'oggetto <code>Ristoratore</code>.
     *
     * <p>
     *  &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String indNomeVia;

    /**
     * Fornisce il numero civico della via dell'oggetto <code>Ristoratore</code>.
     *
     * <p>
     *  &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String indCivico;

    /**
     * Fornisce il nome relativo al comune dell'oggetto <code>Ristoratore</code>.
     *
     * <p>
     *  &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String indComune;

    /**
     * Fornisce la sigla della provincia dell'oggetto <code>Ristoratore</code>.
     *
     * <p>
     *  &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String indProvincia;

    /**
     * Fornisce il CAP relativo al comune dell'oggetto <code>Ristoratore</code>.
     *
     * <p>
     *  &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String indCap;

    /**
     * Fornisce il numero di telefono dell'oggetto <code>Ristoratore</code>.
     *
     * <p>
     *  &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String telefono;

    /**
     * Fornisce l'URL dell'oggetto <code>Ristoratore</code>.
     *
     * <p>
     *  &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String url;

    /**
     * Fornisce la tipologia dell'oggetto <code>Ristoratore</code>.
     *
     * <p>
     *  &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String tipologia;

    //COSTRUTTORI
    /**
     * Costruisce un nuovo oggetto che rappresenta un <code>Ristoratore</code>.
     */
    public Ristoratore() { }

    /**
     * Costruisce un nuovo oggetto che rappresenta un ristorante in cui sono presenti le informazioni specificate dall'argomento.
     *
     * @param id               Identificatore univoco ristorante
     * @param nome             [string] Nome
     * @param indQualificatore qualif. indirizzo
     * @param indNomeVia       Nome via
     * @param indCivico        the N. civico
     * @param indComune        Comune
     * @param indProvincia     Provincia
     * @param indCap           CAP
     * @param telefono         Telefono
     * @param url              Website
     * @param tipologia        Tipologia
     */
    public Ristoratore(String id, String nome, String indQualificatore, String indNomeVia, String indCivico, String
            indComune, String indProvincia, String indCap, String telefono, String url, String tipologia /*,int idRistoratori*/) {
        this.id = id;
        this.nome = nome;
        this.indQualificatore = indQualificatore;
        this.indNomeVia = indNomeVia;
        this.indCivico = indCivico;
        this.indComune = indComune;
        this.indProvincia = indProvincia;
        this.indCap = indCap;
        this.telefono = telefono;
        this.url = url;
        this.tipologia = tipologia;
    }

    //METODI
    /*/**
     * Chiede l'inserimento dei dati del ristorante da inserire :)
     *
     * @param ristoratoreList E' l'ArrayList che carica i dati presenti nel file EatAdvisor.dati
     * @return r = il ristorante che verrà scritto nel file
     */
    /*public static ArrayList inserisciRistoratore(ArrayList ristoratoreList) {
        Scanner Ristoratore = new Scanner(System.in);
        String regex;   // Dichiariamo qui il tipo come stringa vuota e poi a ogni inserimento la verifichiamo

        System.out.println("\nInserire i dati necessari per la registrazione del ristorante. BUON INSERIMENTO");
        System.out.println("Dopo la digitazione del campo richiesto premere INVIO");


        System.out.print("Nome: ");
        String nome = Ristoratore.nextLine();


        System.out.print("Qualificatore [via, viale, corso, piazza, piazzale]: ");
        String indQualificatore = Ristoratore.nextLine().toLowerCase();

        List<String> scelta = new ArrayList<String>(5);
        scelta.add("via");
        scelta.add("viale");
        scelta.add("corso");
        scelta.add("piazza");
        scelta.add("piazzale");
        while (!(scelta.contains(indQualificatore))) {
            System.out.println("Inserimento non valido, si prega di digitare il qualificatore correttamente: ");
            indQualificatore = Ristoratore.nextLine().toLowerCase();
        }


        System.out.print("Indirizzo: ");
        String indNomeVia = Ristoratore.nextLine();
        //"[a-zAA-Zàèìòù]+";
        //regex = "[0-9]+";
        regex = "[a-zA-Zàèìòù.\\s]+[0-9]{0}";              // controllo che la stringa immessa dall'utente contenga solamente lettere da 'a' a 'z' (anche maiuscole) che si possono ripetere una o più volte
        while (!(Pattern.matches(regex, indNomeVia))) {
            System.out.print("Inserimento non valido, si prega di digitare l'indirizzo con caratteri alfabetici: ");
            //indNomeVia = Ristoratore.nextLine();
        }


        System.out.print("Numero civico: ");
        String indCivico = Ristoratore.nextLine();
        regex = "[0-9]+[a-zA-Z]{0,1}";               //controllo che la stringa immessa dall'utente contenga solamente numeri da 0 a 9 che si possono ripetere una o più volte
        while (!(Pattern.matches(regex, indCivico))) {
            System.out.print("Inserimento non valido, si prega di digitare il numero civico con caratteri numerici: ");
            indCivico = Ristoratore.nextLine();
        }


        System.out.print("Comune: ");
        String indComune = Ristoratore.nextLine().toLowerCase();
        //controllo che la stringa immessa dall'utente contenga solamente lettere che si possono ripetere una o più volte
        regex = "[a-zA-Zùèéòàì ]{0,34}";  // max 34 caratteri in basa al comune più lungo d'Italia: San Valentino in Abruzzo Citeriore
        while (!(Pattern.matches(regex, indComune))) {
            System.err.print("Inserimento non valido, si prega di digitare il comune con caratteri alfabetici: ");
            indComune = Ristoratore.nextLine();
        }


        System.out.print("Provincia [Sigla]: ");    // Controllo che sia solo di due caratteri e che sia una delle provincie italiane
        String indProvincia = Ristoratore.nextLine();
        regex = "[a-zA-Z]{2}";
        while (!(Pattern.matches(regex, indProvincia))) {
            System.err.println("Inserimento non valido, si prega di digitare la provincia con caratteri alfabetici: ");
            indProvincia = Ristoratore.nextLine();
        }


        System.out.print("CAP [5 numeri]: "); //controllare che sia inserito un numero
        String indCap = Ristoratore.nextLine();
        regex = "[0-9]{5}";
        while (!(Pattern.matches(regex, indCap))) {
            System.out.print("Inserimento non valido, si prega di digitare il CAP con caratteri numerici: ");
            indCap = Ristoratore.nextLine();
        }


        System.out.print("Telefono [fisso o cellulare]: ");  //controllare che sia lunga 10 numeri
        String telefono = Ristoratore.nextLine();
        regex = "[0-9+]{9,14}";    // SE NON CI SONO 10(cellulre) o 9(fisso) ESATTI NON FUNZIONA
        while (!(Pattern.matches(regex, telefono))) {
            System.err.print("Inserimento non valido, si prega di digitare il numero giusto: ");
            telefono = Ristoratore.nextLine();
        }


        System.out.print("URL sito web: ");
        String url = Ristoratore.nextLine();
        // MANU: regex = "https://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(/\\S*)?";
        // G: regex = "http://[a-zA-Z0-9]+.[a-zA-Z]{2,3}+.[a-zA-Z]{2,3}?";
        //regex = "^(http:\\/\\/|https:\\/\\/)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";
        //while(!(Pattern.matches(regex, url))) {
        // System.out.print("Inserimento non valido, si prega di immettere l'URL del sito web correttamente: ");
        //url = Ristoratore.nextLine();
        //}


        System.out.print("Tipologia [Italiano, Etnico, Fusion]: "); //controllo che quanto sia digitato dall'utente sia ammesso tra le opzioni di scelta
        String tipologia = Ristoratore.nextLine().toLowerCase();
        scelta = new ArrayList<String>(3);
        scelta.add("italiano");
        scelta.add("etnico");
        scelta.add("fusion");
        while (!(scelta.contains(tipologia))) {
            System.out.print("Inserimento non valido, si prega di digitare correttamente la tipologia del ristorante: ");
            tipologia = Ristoratore.nextLine().toLowerCase();
        }

        // GENERATORE DELL'ID CASUALE PER IDENTIFICARE I RISTORANTI
        String id = ProgUtili.createId();

        Ristoratore r = new Ristoratore(id, nome, indQualificatore, indNomeVia, indCivico, indComune, indProvincia, indCap,
                telefono, url, tipologia);


        //MANU:
        //aggiungo la creazione dell' ArrayList che viene dato come risultato della chiamata del metodo "inserisciRistoratore", poi il metodo "registraRistoratore" provvede e stampare tutto
        //l'arreyList sul file eliminando i record precedenti

        ristoratoreList.add(r);

        return ristoratoreList;
    }*/

    /**
     * Registra il ristoratore fornito per argomento nel file EatAdvisor.dati.
     *
     * @param r Arralylist contenente Ristoratori.
     * @throws IOException .
     */
    public static void registraRistoratore(ArrayList r) throws IOException {
        File f = new File(ProgUtili.getEatadvisorPathName());
        ObjectOutputStream eatAdvisor = new ObjectOutputStream(new FileOutputStream(f));
        eatAdvisor.writeObject(r);
        eatAdvisor.close();
    }


    /**
     * Restituisce true se e solo se il ristoratore rappresentato dall'oggetto che esegue il metodo &egrave; uguale a quello specificato tramite l'argomento.
     *
     * @param r Oggetto passato come parametro al metodo
     * @return boolean
     */
    public boolean equals(Ristoratore r) { return this.toString().equals(r.toString()); }

    /**
     * Restituisce una stringa che descrive il <code>Ristoratore</code> rappresentato dall'oggetto che esegue il metodo.
     * @return String
     */
    public String toString() {
        return  /* "ID: " + id + "\n" + */
                "NOME: " + nome + "\n" +
                indQualificatore + " " + indNomeVia + ", " + indCivico + " - " + indComune + " " + "(" + indProvincia + ") " + indCap +
                "\nTELEFONO: " + telefono +
                "\nWEB: " + url +
                "\nTIPOLOGIA: " + tipologia +
                "\n-----------------------------------------------";
    }


    /**
     * Restituisce una stringa che descrive il nome rappresentato dall'oggetto che esegue il metodo.
     *
     * @return String
     */
    public String getNome() { return nome; }

    /**
     * Restituisce una stringa che descrive il qualificatore rappresentato dall'oggetto che esegue il metodo.
     *
     * @return String
     */
    public String getIndQualificatore() { return indQualificatore; }

    /**
     * Restituisce una stringa che descrive il nome della via rappresentato dall'oggetto che esegue il metodo.
     *
     * @return String
     */
    public String getIndNomeVia() { return indNomeVia; }

    /**
     * Restituisce una stringa che descrive il numero civico rappresentato dall'oggetto che esegue il metodo.
     *
     * @return String
     */
    public String getIndCivico() { return indCivico; }

    /**
     * Restituisce una stringa che descrive il comune rappresentato dall'oggetto che esegue il metodo.
     *
     * @return String
     */
    public String getIndComune() { return indComune; }

    /**
     * Restituisce una stringa che descrive la provincia rappresentata dall'oggetto che esegue il metodo.
     *
     * @return String
     */
    public String getIndProvincia() { return indProvincia; }

    /**
     * Restituisce una stringa che descrive il CAP rappresentato dall'oggetto che esegue il metodo.
     *
     * @return String
     */
    public String getIndCap() { return indCap; }

    /**
     * Restituisce una stringa che descrive il numero di telefono rappresentato dall'oggetto che esegue il metodo.
     *
     * @return String
     */
    public String getTelefono() { return telefono; }

    /**
     * Restituisce una stringa che descrive l'URL rappresentato dall'oggetto che esegue il metodo.
     *
     * @return String
     */
    public String getUrl() { return url; }

    /**
     * Restituisce una stringa che descrive la tipologia rappresentata dall'oggetto che esegue il metodo.
     *
     * @return String
     */
    public String getTipologia() { return tipologia; }

    // public String getId(){ return id;}


    /**
     * Definisce il nome del ristoratore che esegue il metodo.
     *
     * @param nome Nome da modificare
     */
    public void setNome(String nome) { this.nome = nome; }

    /**
     * Definisce il qualificatore del ristoratore che esegue il metodo.
     *
     * @param indQualificatore Qualificatore da modificare
     */
    public void setIndQualificatore(String indQualificatore) { this.indQualificatore = indQualificatore; }

    /**
     * Definisce il nome della via del ristoratore che esegue il metodo.
     *
     * @param indNomeVia Nome della via da modificare
     */
    public void setIndNomeVia(String indNomeVia){
        this.indNomeVia = indNomeVia;
    }

    /**
     * Definisce il numero civico del ristoratore che esegue il metodo.
     *
     * @param indCivico Numero civico da modificare
     */
    public void setIndCivico(String indCivico) { this.indCivico = indCivico; }

    /**
     * Definisce il comune del ristoratore che esegue il metodo.
     *
     * @param indComune  Comune da modificare
     */
    public void setIndComune(String indComune) { this.indComune = indComune; }

    /**
     * Definisce la provincia del ristoratore che esegue il metodo.
     *
     * @param indProvincia Provincia da modificare
     */
    public void setIndProvincia(String indProvincia){ this.indProvincia = indProvincia; }

    /**
     * Definisce il CAP del ristoratore che esegue il metodo.
     *
     * @param indCap CAP da modificare
     */
    public void setIndCap(String indCap){ this.indCap = indCap; }

    /**
     * Definisce il numero di telefono del ristoratore che esegue il metodo.
     *
     * @param telefono Telefono da modificare
     */
    public void setTelefono(String telefono) { this.telefono = telefono; }

    /**
     * Definisce l'URL del ristoratore che esegue il metodo.
     *
     * @param url URL da modificare
     */
    public void setUrl(String url) { this.url = url; }

    /**
     * Definisce la tipologia del ristoratore che esegue il metodo.
     *
     * @param tipologia Tipologia da modificare
     */
    public void setTipologia(String tipologia){ this.tipologia = tipologia; }

}