package homework1.src.it.uniroma3.diadia;

import homework1.src.it.uniroma3.diadia.ambienti.Stanza;
import homework1.src.it.uniroma3.diadia.attrezzi.Attrezzo;
import homework1.src.it.uniroma3.diadia.giocatore.Borsa;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto","prendi" ,"posa","fine"};

	private Partita partita;
	private IOConsole io;
	
	public DiaDia(IOConsole console) {
		this.io=console;
		this.partita=new Partita();
	}

	public void gioca() {
		String istruzione; 
		io.mostraMessaggio(MESSAGGIO_BENVENUTO);

		do	{	
			istruzione = io.leggiRiga();
		}while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()==null) {
			io.mostraMessaggio("Non hai inserito alcun comando!");
			return false;
		}
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} 

		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}
	
	
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo!=null) {
			Attrezzo a= this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);	
			this.partita.getGiocatore().getBorsa().addAttrezzo(a);
			this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("ho preso l'attrezzo:  "+ a);
			io.mostraMessaggio("Inserisci un altro commando \n");
		}
	}




	private void posa(String nomeAttrezzo) {
		Borsa borsaGiacotore=this.partita.getGiocatore().getBorsa();

		if(borsaGiacotore.isEmpty()) {
			io.mostraMessaggio("La borsa è vuota\n");
		}


		else {
			Stanza stanzaCorrente = this.partita.getLabirinto().getStanzaCorrente();
			if(borsaGiacotore.hasAttrezzo(nomeAttrezzo)) {		// è piena 
				Attrezzo a =borsaGiacotore.getAttrezzo(nomeAttrezzo); // presp 
				if(stanzaCorrente.addAttrezzo(a)) {
					borsaGiacotore.removeAttrezzo(nomeAttrezzo);
					io.mostraMessaggio("Attrezzo posato nella stanza!");
					io.mostraMessaggio(" presente "+ nomeAttrezzo+ " nella stanza\n");
				}
				else {
					borsaGiacotore.addAttrezzo(a);
					io.mostraMessaggio("la stanza è piena");
				}

			}

			
		}
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
	
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {	
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);;
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio("Stanza corrente:");
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Borsa:");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
	io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console =new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}