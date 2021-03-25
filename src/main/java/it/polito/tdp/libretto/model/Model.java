package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Model {
	
	public class Voto {
		private String NomeCorso;
		private String Data;
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
		
		public String getData() {
			return Data;
		}
		public void setData(String data) {
			Data = data;
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
	
	private List<Voto> Libretto = new ArrayList<Voto>();

	public List<Voto> getLibretto() {
		return Libretto;
	}

	public void setLibretto(List<Voto> libretto) {
		Libretto = libretto;
	}

	public List<Voto> CercaVoto(String text) {
		List<Voto> ListaCercaVoto = new ArrayList<Voto>();
		for (int i=0; i<this.Libretto.size(); i++) {
			if (this.Libretto.get(i).getVotoOttenuto()==Integer.parseInt(text)) {
				ListaCercaVoto.add(this.Libretto.get(i));
			}
		}
		return ListaCercaVoto;
	}
	
	public void InserisciNuovo (String NC, String D, int V) {
		Voto VotBox = new Voto();
		VotBox.setData(D);
		VotBox.setNomeCorso(NC);
		VotBox.setVotoOttenuto(V);
		if (V<18) {
			VotBox.setPunteggio(0);
		} else if (V<24) {
			VotBox.setPunteggio(1);
		} else if (V>=30) {
			VotBox.setPunteggio(3);
		} else {
			VotBox.setPunteggio(2);
		}
		this.Libretto.add(VotBox);
	}

	public List<Voto> StampaEsame() {
		Libretto.sort(Comparator.comparing(Voto::getNomeCorso));
		return this.Libretto;
	}

	public List<Voto> StampaVoto() {
		Libretto.sort(Comparator.comparing(Voto::getVotoOttenuto).reversed());
		return this.Libretto;
	}

	public List<Voto> CercaCorso(String text) {
		List<Voto> ListaCercaCorso = new ArrayList<Voto>();
		for (int i=0; i<this.Libretto.size(); i++) {
			if (this.Libretto.get(i).getNomeCorso().equals(text)) {
				ListaCercaCorso.add(this.Libretto.get(i));
			}
		}
		return ListaCercaCorso;
	}

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
