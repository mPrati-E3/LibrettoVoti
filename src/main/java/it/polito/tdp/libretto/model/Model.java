package it.polito.tdp.libretto.model;

import java.util.Date;
import java.util.List;

public class Model {
	
	public class Voto {
		private String NomeCorso;
		private Date Data;
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
		
		public Date getData() {
			return Data;
		}
		public void setData(Date data) {
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
	
	private List<Voto> Libretto;

	public List<Voto> getLibretto() {
		return Libretto;
	}

	public void setLibretto(List<Voto> libretto) {
		Libretto = libretto;
	}

	public List<Voto> CercaVoto(String text) {
		
		return this.Libretto;
	}

	public List<Voto> StampaEsame() {
		// TODO Auto-generated method stub
		return this.Libretto;
	}

	public List<Voto> StampaVoto() {
		// TODO Auto-generated method stub
		return this.Libretto;
	}

	public List<Voto> CercaCorso(String text) {
		// TODO Auto-generated method stub
		return this.Libretto;
	}

	public List<Voto> Cancella() {
		// TODO Auto-generated method stub
		return this.Libretto;
	}

}
