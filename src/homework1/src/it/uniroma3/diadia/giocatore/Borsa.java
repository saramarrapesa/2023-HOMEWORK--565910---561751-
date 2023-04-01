package homework1.src.it.uniroma3.diadia.giocatore;

import homework1.src.it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null)
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}
	
	public int getPeso() {
		int peso = 0;
		if(numeroAttrezzi==0)
			return peso;
		else {
		
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if(attrezzi[i]!=null)
			peso += this.attrezzi[i].getPeso();
		}
		return peso;
	}
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;

	// --->  TODO (implementare questo metodo) <---
		if(nomeAttrezzo!=null) {
			int i=0;
	for (Attrezzo att:this.attrezzi) {
		if(att!=null) {
			if(att.getNome().equals(nomeAttrezzo)) {
				a=att;
				this.attrezzi[i]=null;
				this.numeroAttrezzi--;
			}
		}
		i++;
	}
}
return a;
}
public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i=0; i<this.numeroAttrezzi; i++)
				if(attrezzi[i]!=null) 
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

}