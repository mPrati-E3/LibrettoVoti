package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Model;
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

    @FXML
    void doCancella(ActionEvent event) {

    }

    @FXML
    void doCercaCorso(ActionEvent event) {

    }

    @FXML
    void doCercaVoto(ActionEvent event) {

    }

    @FXML
    void doInserisciNuovo(ActionEvent event) {

    }

    @FXML
    void doStampaEsame(ActionEvent event) {

    }

    @FXML
    void doStampaVoto(ActionEvent event) {

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
