package it.polito.tdp.regine.model;

import java.util.LinkedList;
import java.util.List;

public class Regine {
	
	private int N;
	
	private void setN(int n) {
		N=n;
	}
	
	public List<Integer> risolvi(int n){
		
		if(n<4) {
			return null;
		}
		
		this.setN(n);
		List<Casella> risultato = new LinkedList<Casella>();
		cerca(risultato, 0);
		List<Integer> lista = new LinkedList<Integer>();
		
		for(Casella c : risultato) {
			lista.add(c.getColonna());
		}
		
		return lista;
	}

	// N è il numero di righe e colonne della scacchiera
	//   (righe e colonne numerate da 0 a N-1)
	// ad ogni livello posizioniamo una regina in una nuova riga
	
	// soluzione parziale: lista delle colonne in cui mettere le regine (prime righe)
	// 		List<Integer>
	// livello = quante righe sono già piene
	// livello = 0 => nessuna riga piena (devo mettere la regina nella riga 0)
	// livello = 3 => 3 righe piene (0, 1, 2), devo mettere la regina nella riga 3
	// [0]
	//     [0, 2]
	//            [0, 2, 1]
	
	
	private void cerca(List<Casella> parziale, int livello) {
		if(livello==N) {
			//caso terminale
			return;
		} else {
			for(int colonna=0;colonna<N;colonna++) {
				
				//if la mossa nella casella [livello][colonna] è valida
				//se sì, aggiungi a parziale e fai ricorsione
				
				boolean valida = true;

				for(Casella c : parziale) {
					if(c.getColonna()==colonna || Math.abs(c.getColonna()-colonna) == Math.abs(c.getLivello()-livello)) {
						//mossa non valida
						valida = false;
						break;
					} 
				}
								
				if(valida) {
					//fai ricorsione
					parziale.add(new Casella(livello, colonna));
					cerca(parziale, livello+1);
				}
			}
			
			if(parziale.size()!=N) {
				parziale.remove(parziale.size()-1);
			}
		}
			

	}
	
	
	
}
