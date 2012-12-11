
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JouluTiraTest {
    
    Sokkelo s;
    
    public JouluTiraTest() {
    }
        
    @Before
    public void setUp() {
        s = new Sokkelo();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testaaEttaAnnettuPaikkaOnOikea(){
        
        Paikka p = new Paikka(1, 1);
        assertEquals(1, p.getX());
        assertEquals(1, p.getY());
    }
    
    @Test
    public void testaaEttaGeneroituSokkeloEiTuotaSeiniaAlkuun(){
        int[][] t = s.teeSokkelo(5, 5);
        assertEquals(0, t[0][0]);
    }
    
    @Test
    public void testaaEttaGeneroituSokkeloEiTuotaSeiniaLoppuun(){
        int[][] t = s.teeSokkelo(5, 5);
        assertEquals(0, t[4][4]);
    }
    
    //tee testi joka tarkastaa että sokkelo on mahdollista läpäistä
    @Test
    public void testaaEttaSokkeloOnMahdollistaLapaista(){
        
    }
}
