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
    
    private void Stampante (List<Voto> L) {
    	txtStampa.clear();
    	txtStampa.appendText("Nome Corso \t");
		txtStampa.appendText("Data \t");
		txtStampa.appendText("Voto \t");
		txtStampa.appendText("Punteggio \n");
    	for (int i=0; i<L.size(); i++) {
    		txtStampa.appendText(L.get(i).getNomeCorso()+" \t");
    		txtStampa.appendText(L.get(i).getData()+" \t");
    		txtStampa.appendText(L.get(i).getVotoOttenuto()+" \t");
    		txtStampa.appendText(L.get(i).getPunteggio()+" \n");
    	}
    }

    @FXML
    void doCancella(ActionEvent event) {
    	this.Stampante(model.Cancella());
    }

    @FXML
    void doCercaCorso(ActionEvent event) {
    	this.Stampante(model.CercaCorso(txtCercaCorso.getText()));
    }

    @FXML
    void doCercaVoto(ActionEvent event) {
    	this.Stampante(model.CercaVoto(txtCercaVoto.getText()));

    }

    @FXML
    void doInserisciNuovo(ActionEvent event) {
    	
    	this.model.InserisciNuovo(txtNomeCorso.getText(),dataData.getAccessibleText(),Integer.parseInt(txtVotoOttenuto.getText()));
    	
    	this.Stampante(model.getLibretto());
    	

    }

    @FXML
    void doStampaEsame(ActionEvent event) {
    	this.Stampante(model.StampaEsame());
    }

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
