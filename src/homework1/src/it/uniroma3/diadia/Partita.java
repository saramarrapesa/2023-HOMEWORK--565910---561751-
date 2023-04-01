package homework1.src.it.uniroma3.diadia;

import homework1.src.it.uniroma3.diadia.ambienti.Labirinto;
import homework1.src.it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	
    private Labirinto labirinto;
    private Giocatore giocatore;

    private boolean finita;

 
    
public Partita() {
	this.labirinto=new Labirinto();
	this.giocatore =new Giocatore();
	labirinto.creaStanze();
	this.finita = false;

	
}	
public Labirinto getLabirinto() {
	return labirinto;
}

public void setLabirinto(Labirinto labirinto) {
	this.labirinto = labirinto;
}
public Giocatore getGiocatore() {
				return giocatore;
			}

public void setGiocatore(Giocatore giocatore) {
	this.giocatore=giocatore;
}
			
			/**
			 * Restituisce vero se e solo se la partita e' stata vinta
			 * @return vero se partita vinta
			 */
public boolean vinta() {
	return this.getLabirinto().getStanzaCorrente()==this.getLabirinto().getStanzaVincente();
}
public boolean isFinita() {
		return finita || vinta() ||this.getGiocatore().getCfu()==0;
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}


		
}
