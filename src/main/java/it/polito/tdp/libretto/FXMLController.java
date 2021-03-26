package it.polito.tdp.libretto;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import it.polito.tdp.libretto.model.Model;
import it.polito.tdp.libretto.model.Model.Voto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


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
    private TableView<Voto> tblStampa;

    @FXML
    private TableColumn<Voto, String> colNomeEsame;

    @FXML
    private TableColumn<Voto, LocalDate> colData;

    @FXML
    private TableColumn<Voto, Integer> colVotoOttenuto;

    @FXML
    private TableColumn<Voto, Integer> colPunteggio;
    

    //metodo che stampa nella casella dei messaggi
    private void Stampante (List<Voto> L) {
    	
    	txtStampa.clear();
    	
    	for ( int i = 0; i<tblStampa.getItems().size(); i++) {
    	    tblStampa.getItems().clear();
    	}
    	
        colNomeEsame.setCellValueFactory(new PropertyValueFactory<>("NomeCorso"));
        colData.setCellValueFactory(new PropertyValueFactory<>("Data"));
        colVotoOttenuto.setCellValueFactory(new PropertyValueFactory<>("VotoOttenuto"));
        colPunteggio.setCellValueFactory(new PropertyValueFactory<>("Punteggio"));
        
        for (int i=0; i<L.size(); i++) {
        	tblStampa.getItems().add(L.get(i));
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
    	
    	this.Stampante(model.CercaCorso(txtCercaCorso.getText().toUpperCase()));
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
    	
    	this.model.InserisciNuovo(txtNomeCorso.getText().toUpperCase(),dataData.getValue(),Integer.parseInt(txtVotoOttenuto.getText()));
    	
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
        assert tblStampa != null : "fx:id=\"tblStampa\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colNomeEsame != null : "fx:id=\"colNomeEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colData != null : "fx:id=\"colData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colVotoOttenuto != null : "fx:id=\"colVotoOttenuto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert colPunteggio != null : "fx:id=\"colPunteggio\" was not injected: check your FXML file 'Scene.fxml'.";
       
    }
    
    public void setModel(Model m) {
    	this.model=m;
    }
}
