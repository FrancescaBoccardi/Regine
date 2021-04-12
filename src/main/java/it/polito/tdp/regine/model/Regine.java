package it.polito.tdp.regine.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {

	private int N;
	private List<Integer> soluzione;
	
	public List<Integer> risolvi(int N){
		this.N = N;
		List<Integer> parziale = new ArrayList<Integer>();
		this.soluzione = null;
		cerca(parziale, 0);
		return this.soluzione;
	}
	
	// N è il numero di righe e colonne della scacchiera (righe e colonne numerate da 0 a N-1)
	// ad ogni livello posizioniamo una regina in una nuova riga
	
	// soluzione parziale: lista delle colonne in cui mettere le regine (prime righe)
	// livello = quante righe sono già piene
	// livello 0 => nessuna riga piena (devo mettere la regina nella riga 0)
	// livello = 3 => 3 righe piene (0, 1, 2), devo mettere la regina nella riga 3
	
	private boolean cerca(List<Integer> parziale, int livello) {
		if(livello==N) {
			//caso terminale
		//	System.out.println(parziale);
		//	this.soluzione = parziale; //non funziona perché dentro soluzione c'è solo un riferimento a parziale, che a fin metodo sarà di nuovo vuota
			this.soluzione = new ArrayList<Integer>(parziale);
			return true;
		} else {
			for(int colonna=0;colonna<N;colonna++) {
				
				if(posValida(parziale, colonna)) {
					parziale.add(colonna);
					boolean trovato = cerca(parziale,livello+1);
					if(trovato) {
						return true;
					}
					parziale.remove(parziale.size()-1); //backtracking
					
				}
			}
			
			return false;
		}
	}
	
	private boolean posValida(List<Integer> parziale, int colonna) {
		int livello = parziale.size();
		if(parziale.contains(colonna)) {
			return false;
		}
		
		for(int r=0; r<livello; r++) {
			int c = parziale.get(r);
			
			if(r+c == livello+colonna || r-c == livello-colonna) {
				return false;
			}
		}
		
		return true;
	}
}


