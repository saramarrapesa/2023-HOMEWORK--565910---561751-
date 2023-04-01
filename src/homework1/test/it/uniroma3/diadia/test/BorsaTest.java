package homework1.test.it.uniroma3.diadia.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import homework1.src.it.uniroma3.diadia.attrezzi.Attrezzo;
import homework1.src.it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
// get Attrezzo , get peso, add Attrezzo , delete Attrezzo
	
	private Borsa b=new Borsa();
	private Attrezzo test1;
	private Attrezzo test2;
	private Attrezzo test3;
	

	
	@Before
	public void setup(){
		
		test1=new Attrezzo("test1",1);
		test2=new Attrezzo("test2",2);
		test3= new Attrezzo("test3", 9);
	}
	
	@Test
	public void testGetAttrezzoNULL() {
		assertNull(this.b.getAttrezzo("pala"));
	
}
	
	@Test
	public void testGetAttrezzo() {
		b.addAttrezzo(test1);
		b.addAttrezzo(test2);
		assertEquals("test1",this.b.getAttrezzo("test1").getNome());
		assertEquals("test2",this.b.getAttrezzo("test2").getNome());
		
		assertNull(this.b.getAttrezzo(""));
		
	}
	
	@Test
	public void testPesoBorsa() {
		b.addAttrezzo(test1);
		b.addAttrezzo(test2);
		assertEquals(3, this.b.getPeso());
	}
	
	@Test
	public void testPesoBorsaEMax() {
		b.addAttrezzo(test3);
		b.addAttrezzo(test1);
		assertEquals(b.getPesoMax(), this.b.getPeso());
	}
	
	
}