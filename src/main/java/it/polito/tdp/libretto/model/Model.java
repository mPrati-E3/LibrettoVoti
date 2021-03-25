package it.polito.tdp.libretto.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Model {
	
	//definisco la classe voto con tutti i relativi getter e setter
	public class Voto {
		private String NomeCorso;
		private LocalDate Data;
		private int VotoOttenuto;
		private int Punteggio;
		
		public Voto() {
			this.NomeCorso="";
			this.Data=null;
			this.VotoOttenuto=0;
		}
		
		public String getNomeCorso() {
			return NomeCorso;
		}
		public void setNomeCorso(String nomeCorso) {
			NomeCorso = nomeCorso;
		}
		
		public LocalDate getData() {
			return Data;
		}
		public void setData(LocalDate localDate) {
			Data = localDate;
		}
		
		public int getVotoOttenuto() {
			return VotoOttenuto;
		}
		public void setVotoOttenuto(int votoOttenuto) {
			VotoOttenuto = votoOttenuto;
		}

		public int getPunteggio() {
			return Punteggio;
		}

		public void setPunteggio(int punteggio) {
			Punteggio = punteggio;
		}
		
		
	}
	
	//------------ Libretto principale === Lista di oggetti voto ---------------
	private List<Voto> Libretto = new ArrayList<Voto>();

	public List<Voto> getLibretto() {
		return Libretto;
	}

	public void setLibretto(List<Voto> libretto) {
		Libretto = libretto;
	}
	
	//---------------------------------------------------------------------------
	
	//filtra i voti per quello che ha inserito l'utente
	public List<Voto> CercaVoto(int text) {
		List<Voto> ListaCercaVoto = new ArrayList<Voto>();
		for (int i=0; i<this.Libretto.size(); i++) {
			if (this.Libretto.get(i).getVotoOttenuto()==text) {
				ListaCercaVoto.add(this.Libretto.get(i));
			}
		}
		return ListaCercaVoto;
	}
	
	//inserisco un nuovo oggetto nella lista
	public void InserisciNuovo (String NC, LocalDate localDate, int V) {
		Voto VotBox = new Voto();
		VotBox.setData(localDate);
		VotBox.setNomeCorso(NC);
		VotBox.setVotoOttenuto(V);
		
		//---------Attribuzione del punteggio come da traccia------
		if (V<18) {
			VotBox.setPunteggio(0);
		} else if (V<24) {
			VotBox.setPunteggio(1);
		} else if (V>=30) {
			VotBox.setPunteggio(3);
		} else {
			VotBox.setPunteggio(2);
		}
		//---------------------------------------------------------
		
		
		this.Libretto.add(VotBox);
	}

	//sorting della lista per il nome del corso (utilizzo di Comparator.comparing in Java 8)
	public List<Voto> StampaEsame() {
		Libretto.sort(Comparator.comparing(Voto::getNomeCorso));
		return this.Libretto;
	}

	//sorting della lista per il voto in reverse (utilizzo di Comparator.comparing in Java 8)
	public List<Voto> StampaVoto() {
		Libretto.sort(Comparator.comparing(Voto::getVotoOttenuto).reversed());
		return this.Libretto;
	}

	//filtra i corsi per quello che ha inserito l'utente
	public List<Voto> CercaCorso(String text) {
		List<Voto> ListaCercaCorso = new ArrayList<Voto>();
		for (int i=0; i<this.Libretto.size(); i++) {
			if (this.Libretto.get(i).getNomeCorso().equals(text)) {
				ListaCercaCorso.add(this.Libretto.get(i));
			}
		}
		return ListaCercaCorso;
	}

	//cancella tutti i voti sotto a 24
	public List<Voto> Cancella() {
		for (int i=0; i<this.Libretto.size(); i++) {
			if (this.Libretto.get(i).getVotoOttenuto()<24) {
				this.Libretto.remove(i);
				i--;
			}
		}
		return this.Libretto;
	}

}
