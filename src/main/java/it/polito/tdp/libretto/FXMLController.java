package it.polito.tdp.libretto;

import java.util.List;

import it.polito.tdp.libretto.model.Model;
import it.polito.tdp.libretto.model.Model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private Button btnInserisciNuovo;

    @FXML
    private TextField txtNomeCorso;

    @FXML
    private DatePicker dataData;

    @FXML
    private TextField txtVotoOttenuto;

    @FXML
    private TextArea txtStampa;

    @FXML
    private TextField txtCercaVoto;

    @FXML
    private Button btnCercaVoto;

    @FXML
    private TextField txtCercaCorso;

    @FXML
    private Button btnCercaCorso;

    @FXML
    private Button btnStampaEsame;

    @FXML
    private Button btnStampaVoto;

    @FXML
    private Button btnCancella;
    
    //metodo che stampa nella casella dei messaggi
    //TODO: convertire a tabella in modo che i dati si impilino correttamente
    private void Stampante (List<Voto> L) {
    	txtStampa.clear();
    	txtStampa.appendText("Nome Corso \t\t");
		txtStampa.appendText("Data \t\t");
		txtStampa.appendText("Voto \t");
		txtStampa.appendText("Punteggio \n");
    	for (int i=0; i<L.size(); i++) {
    		txtStampa.appendText(L.get(i).getNomeCorso()+" \t\t\t");
    		txtStampa.appendText(L.get(i).getData()+" \t");
    		txtStampa.appendText(L.get(i).getVotoOttenuto()+" \t\t\t");
    		txtStampa.appendText(L.get(i).getPunteggio()+" \n");
    	}
    }

    //richiama il metodo di cancellazione del model e poi stampa
    @FXML
    void doCancella(ActionEvent event) {
    	this.Stampante(model.Cancella());
    }

    //controllo dell'input, richiama il metodo di ricerca corso del model e poi stampa
    @FXML
    void doCercaCorso(ActionEvent event) {
    	
    	if (txtCercaCorso.getText()=="") {
    		txtStampa.clear();
    		txtStampa.appendText("Il nome del corso non può essere vuoto! \n");
    		return;
    	}
    	
    	this.Stampante(model.CercaCorso(txtCercaCorso.getText()));
    	txtCercaCorso.clear();
    }

    //controllo dell'input, richiama il metodo di ricerca voto del model e poi stampa
    @FXML
    void doCercaVoto(ActionEvent event) {
    	int CV=-1; 
    	try {
    		CV = Integer.parseInt(txtCercaVoto.getText());
    	} catch (NumberFormatException e) {
    		txtStampa.clear();
    		txtStampa.appendText("Il voto deve essere numerico! \n");
    		return;
    	}
    	if (CV<0) {
    		txtStampa.clear();
    		txtStampa.appendText("Il voto deve essere positivo! \n");
    		return;
    	}
    	if (CV>31) {
    		txtStampa.clear();
    		txtStampa.appendText("Più di 30 e lode! \n");
    		return;
    	}
    	this.Stampante(model.CercaVoto(CV));
    	txtCercaVoto.clear();
    }

    //controllo dell'input, richiama il metodo di ricerca inserimento del model e poi stampa
    @FXML
    void doInserisciNuovo(ActionEvent event) {
    	
    	if (txtNomeCorso.getText()=="") {
    		txtStampa.clear();
    		txtStampa.appendText("Il nome del corso non può essere vuoto! \n");
    		return;
    	}
    	if (dataData.getValue()==null) {
    		txtStampa.clear();
    		txtStampa.appendText("Scegli una data! \n");
    		return;
    	}
    	
    	int CV=-1; 
    	try {
    		CV = Integer.parseInt(txtVotoOttenuto.getText());
    	} catch (NumberFormatException e) {
    		txtStampa.clear();
    		txtStampa.appendText("Il voto deve essere numerico! \n");
    		return;
    	}
    	if (CV<0) {
    		txtStampa.clear();
    		txtStampa.appendText("Il voto deve essere positivo! \n");
    		return;
    	}
    	if (CV>31) {
    		txtStampa.clear();
    		txtStampa.appendText("Più di 30 e lode! \n");
    		return;
    	}
    	
    	this.model.InserisciNuovo(txtNomeCorso.getText(),dataData.getValue(),Integer.parseInt(txtVotoOttenuto.getText()));
    	
    	this.Stampante(model.getLibretto());
    	
    	txtNomeCorso.clear();
    	dataData.setValue(null);
    	txtVotoOttenuto.clear();
    	

    }

    //richiama il metodo di stampa esame del model e poi stampa
    @FXML
    void doStampaEsame(ActionEvent event) {
    	this.Stampante(model.StampaEsame());
    }

    //richiama il metodo di stampa voto del model e poi stampa
    @FXML
    void doStampaVoto(ActionEvent event) {
    	this.Stampante(model.StampaVoto());
    }
    
    @FXML
    void initialize() {
        assert btnInserisciNuovo != null : "fx:id=\"btnInserisciNuovo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNomeCorso != null : "fx:id=\"txtNomeCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert dataData != null : "fx:id=\"dataData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVotoOttenuto != null : "fx:id=\"txtVotoOttenuto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStampa != null : "fx:id=\"txtStampa\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCercaVoto != null : "fx:id=\"txtCercaVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaVoto != null : "fx:id=\"btnCercaVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCercaCorso != null : "fx:id=\"txtCercaCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorso != null : "fx:id=\"btnCercaCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStampaEsame != null : "fx:id=\"btnStampaEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStampaVoto != null : "fx:id=\"btnStampaVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model m) {
    	this.model=m;
    }
}
