package it.polito.tdp.regine.model;

public class Casella {
	
	private int livello;
	private int colonna;
	
	public Casella(int livello, int colonna) {
		this.livello = livello;
		this.colonna = colonna;
	}

	public int getLivello() {
		return livello;
	}

	public int getColonna() {
		return colonna;
	}

	@Override
	public String toString() {
		return "Casella [livello=" + livello + ", colonna=" + colonna + "]";
	}
	
	
	
	
	

}
