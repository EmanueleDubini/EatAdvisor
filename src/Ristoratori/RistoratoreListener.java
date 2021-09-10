package Ristoratori;

import Common.EatAdvisorException;
import Common.ProgUtili;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.*;

/**
 *Le sue istanze rappresentano listener dedicati alla classe RistoratoriMainMenu in risposta ai click degli oggetti JButton
 */
public class RistoratoreListener implements ActionListener {

    /**
     * {@inheritDoc}
     * Registra un nuovo ristoratore nel file EatAdvisor.dati se gli attributi inseriti nella classe <code>RistoratoreMainMenu</code> rispettano i criteri definiti dall'applicazione
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        try {                                                               //controllo che il file EatAdvisor.dati siano presenti nella cartella data, che siano legtgibili e scrivibili
            ProgUtili.checkEatAdvisor();
            ProgUtili.checkEatAdvisor();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (EatAdvisorException eatAdvisorException) {
            eatAdvisorException.printStackTrace();
        }


            String nome = RistoratoreMainMenu.getNome();
            String indQualificatore = RistoratoreMainMenu.getQualificatore();
            String indNomeVia = RistoratoreMainMenu.getNomeVia();
            String indCivico = RistoratoreMainMenu.getCivico();
            String indComune = RistoratoreMainMenu.getComune();
            String indProvincia = RistoratoreMainMenu.getProvincia();
            String indCap = RistoratoreMainMenu.getCap();
            String telefono = RistoratoreMainMenu.getTelefono();
            String url = RistoratoreMainMenu.getUrl();
            String tipologia = RistoratoreMainMenu.getTipologia();

            //CONTROLLI INSERIMENTO
            if              ((nome.equals("<Nome-Ristorante>") || nome.equals("")) ||
                            ((indNomeVia.equals("<Indirizzo>") || indNomeVia.equals("")) ||
                            (indCivico.equals("<Numero-Civico>") || indCivico.equals("")) ||
                            (indComune.equals("<Comune>") || indComune.equals("")) ||
                            (indProvincia.equals("<Provincia>") || indProvincia.equals("")) ||
                            (indCap.equals("<Codice-Avviamento-Postale>") || indCap.equals("")) ||
                            (telefono.equals("<Fisso-Cellulare>") || telefono.equals("")) ||
                            (url.equals("<www.mioristorante.it>") || url.equals(""))))

                erroreInserimento("Uno o più campi sono uguali alla descrizione o vuoti!!");

            else if(nome.length() > 40){
                RistoratoreMainMenu.textFieldNome.setText("");
                erroreInserimento("Nome Ristorante non valido");
            }

            else if(!(Pattern.matches("[a-zA-Zàèìòù.\\s]{0,30}[0-9]{0}", indNomeVia))){
                RistoratoreMainMenu.textFieldNomeVia.setText("");
                erroreInserimento("Nome della Via non valido");
            }

            else if(!(Pattern.matches("[0-9]{0,5}[a-zA-Z ]{0,2}",indCivico))) {
                RistoratoreMainMenu.textFieldNome.setText("");
                erroreInserimento("Numero civico non valido");
            }

            else if(!(Pattern.matches("[a-zA-Zùèéòàì ]{0,34}", indComune))){
                RistoratoreMainMenu.textFieldComune.setText("");
                erroreInserimento("Comune non valido");
            }

            else if(!(Pattern.matches("[a-zA-Z]{2}", indProvincia))){
                RistoratoreMainMenu.textFieldProvincia.setText("");
                erroreInserimento("Provincia non valida");
            }

            else if(!(Pattern.matches("[0-9]{5}", indCap))){
                RistoratoreMainMenu.textFieldCap.setText("");
                erroreInserimento("CAP non valido");
            }

            else if(!(Pattern.matches("[0-9+]{9,14}", telefono))){
                RistoratoreMainMenu.textFieldtelefono.setText("");
                erroreInserimento("Telefono non valido");
            }

            //INSERIMENTO RISTORATORE NEL FILE EatAdvisor.dati
            else{
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
                RistoratoreMainMenu.resetInserimento();     // pulisce i campi dopo un inserimento eseguito correttamente
                JOptionPane.showMessageDialog(null, "Registrazione ristoratore avvenuta con successo", "CONFERMA registrazione",JOptionPane.INFORMATION_MESSAGE);
            }
        }

    /**
     * Genera un JOptionPane per segnalare eventuali errori
     *
     * @param message messaggio visualizzato nel JOptionPane
     */
    public static void erroreInserimento(String message){
        JOptionPane.showMessageDialog(null, message, "ERRORE di inserimento",JOptionPane.INFORMATION_MESSAGE);

    }
}