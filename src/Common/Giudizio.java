package Common;

import Ristoratori.Ristoratore;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Le sue istanze rappresentano i <strong>Giudizi</strong>
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
public class Giudizio extends Ristoratore implements Serializable{

    //CAMPI
    /**
     * Fornisce il nome del <code>Ristoratore</code> a cui è riferito l'oggetto <code>Giudizio</code>.
     *
     * <p>
     * &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String nome;
    /**
     * Fornisce il nickname del <code>Cliente</code> che ha rilasciato il <code>Giudizio</code>.
     *
     * <p>
     * &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String nickname;
    /**
     * Fornisce il numero di stelle che contiene l'oggetto <code>Giudizio</code> riferito ad un <code>Ristoratore</code> specifico.
     *
     * <p>
     * &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private Integer stelle;
    /**
     * Fornisce la recensione che contiene l'oggetto <code>Giudizio</code> riferito ad un <code>Ristoratore</code> specifico.
     *
     * <p>
     * &Egrave; dichiarato <strong>private</strong> per non poter essere visibile al di fuori della classe.
     * </p>
     */
    private String recensione;

    //COSTRUTTORI

    /**
     * Costruisce un nuovo oggetto che rappresenta un Giudizio in cui sono presenti le informazioni specificate dall'argomento.
     *
     * @param nome       Nome ristoratore
     * @param nickname   Nickname cliente
     * @param stelle     Stelle giudizio
     * @param recensione Testo recensione
     */
    public Giudizio(String nome, String nickname, Integer stelle, String recensione){
        this.nome = nome;
        this.nickname = nickname;
        this.stelle = stelle;
        this.recensione = recensione;
    }
    //METODI

    /*
     * Inserisce il giudizio in formato stelle
     *
     *
    public static Giudizio inserisciGiudizioS() {
        Scanner Ristoratore = new Scanner(System.in);
        String regex;
        System.out.print("Giudizio in gStelle [max 5]: ");
        String gStelle = Ristoratore.nextLine();
        regex = "[*]{1,5}";
        while (!(Pattern.matches(regex, gStelle))) {
            System.out.print("Inserimento non valido: ");
            gStelle = Ristoratore.nextLine();
        }
        Integer stelle = gStelle.length();
        Giudizio g = new Giudizio(stelle);
        return  g;

        //File f = new File("data" + File.separatorChar + "EatAdvisor.dati");
        //ObjectOutputStream eatAdvisor = new ObjectOutputStream(new FileOutputStream(f, true));
        //eatAdvisor.writeObject(gStelle);
        // eatAdvisor.close();
    } */

    /*
     * Inserisce il giudizio in formato testo
     *

    public static Giudizio inserisciGiudizioT() {
        Scanner Ristoratore = new Scanner(System.in);
        String regex;
        System.out.print("Giudizio in testo [max 255 char](la REGEX non funziona ancora bene, usare 00000: ");
        String gTesto = Ristoratore.nextLine();
        regex = "[0-9]+[a-zA-Z]{0,255}";
        while (!(Pattern.matches(regex, gTesto))) {
            System.out.print("Inserimento non valido: ");
            gTesto = Ristoratore.nextLine();
        }
        Giudizio g = new Giudizio(gTesto);
        return g;
        //File f = new File("data" + File.separatorChar + "EatAdvisor.dati");
        //ObjectOutputStream eatAdvisor = new ObjectOutputStream(new FileOutputStream(f, true));
        //eatAdvisor.writeObject(gTesto);
        //eatAdvisor.close();
    } */

    /*/**
     * Inserisce il giudizio fornito per argomento nel nell'ArrayList contenuo nel file EatAdvisor.dati.
     *
     * @param ristoratoreList Arralylist contenente Ristoratori.
     * @return ArrayList
     */
   /*public static ArrayList inserisciGiudizio(ArrayList ristoratoreList) {
        Scanner Ristoratore = new Scanner(System.in);
        String regex;
        System.out.print("Giudizio in Stelle [Inserisci un numero da 1 a 5]: ");
        String gStelle = Ristoratore.nextLine();
        regex = "[1-5]";
        while (!(Pattern.matches(regex, gStelle))) {
            System.err.print("Devi inserire un NUMERO da 1 a 5: ");
            gStelle = Ristoratore.nextLine();
        }

        System.out.print("Giudizio in testo [max 255 char]: ");
        String gTesto = Ristoratore.nextLine();
        regex = "[a-z A-Z 0-9àèìòù+*#@§°ç|!\"£$%&/()=?^]{0,255}";
        while (!(Pattern.matches(regex, gTesto))) {
            System.err.print("Inserimento non valido: ");
            gTesto = Ristoratore.nextLine();
        }

        // PARTE POI DA CANELLARE
        System.out.print("NOME RIST CHE CIà Cè: ");
        String nome = Ristoratore.nextLine();

        System.out.print("Nickname CHE CIà Cè: ");
        String nickname = Ristoratore.nextLine();
        // FINE PARTE DA CANCELLATE

        Integer stelle = gStelle.length();
        Giudizio g = new Giudizio(nome, nickname, stelle, gTesto);
        ristoratoreList.add(g);

        return ristoratoreList;
    }*/

    /**
     * Registra il giudizio fornito per argomento nel file EatAdvisor.dati.
     *
     * @param g Arralylist contenente Ristoratori.
     * @throws IOException .
     */
    public static void registraGiudizio(ArrayList g) throws IOException {
        File f = new File(ProgUtili.getEatadvisorPathName());
        ObjectOutputStream eatAdvisor = new ObjectOutputStream(new FileOutputStream(f));
        eatAdvisor.writeObject(g);
        eatAdvisor.close();

    }

    /**
     * Restituisce una stringa che descrive il <code>Giudizio</code> rappresentato dall'oggetto che esegue il metodo.
     * @return String
     */
    public String toString(){
        return  "L'utente '" + nickname.toUpperCase() + "' ha inserito per " + nome + ": " +
                "\nGIUDIZIO: " + stelle + " stelle" +
                "\nRECENSIONE: " + recensione +
                "\n---------------------------------------------------------------------------------------------------";
    }

    /**
     * Ristituisce il nome del ristorante a cui è associato il Giudizio.
     *
     * @return string
     */
    public String getNome(){ return  nome; }

    /**
     * Ristituisce il nickname del cliente che ha rilasciato il Giudizio.
     *
     * @return string
     */
    public String getNickname(){ return  nickname; }

    /**
     * Ristituisce la recensione in stelle.
     *
     * @return integer
     */
    public Integer getStelle(){ return stelle; }

    /**
     * Ristituisce la recensione in testo.
     *
     * @return string
     */
    public String getRecensione(){ return  recensione; }

}
