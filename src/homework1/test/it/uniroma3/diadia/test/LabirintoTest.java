package homework1.test.it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import homework1.src.it.uniroma3.diadia.ambienti.Labirinto;
import homework1.src.it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

	Labirinto l;
	Stanza biblioteca;
	Stanza DS1;
	
	

	@Before
	public void setUp() {
		l = new Labirinto();
		l.creaStanze();
		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(DS1);
		assertEquals(DS1, l.getStanzaCorrente());
	}



	
}
