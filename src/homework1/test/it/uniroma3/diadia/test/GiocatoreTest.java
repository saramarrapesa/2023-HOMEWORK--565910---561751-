package homework1.test.it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


import homework1.src.it.uniroma3.diadia.giocatore.Borsa;
import homework1.src.it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {

	Giocatore g= new Giocatore();
	Borsa b;
	
	@Before
	public void setUp() {
	b= new Borsa();
	}
	
	
	@Test 
	public void  testGetCfuDefault() {
	assertEquals(20,g.getCfu());
	}
	@Test
	public void testSetCfu() {
		g.setCfu(3);
		assertEquals(3, g.getCfu());
	}
	@Test 
	public void testGetBorsaDefault() {
	g.setBorsa(b);
	assertEquals(this.b,g.getBorsa());
	}
	
	
}
