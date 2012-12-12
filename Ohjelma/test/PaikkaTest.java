
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PaikkaTest {
    
    Sokkelo s;
    
    public PaikkaTest() {
    }
        
    @Before
    public void setUp() {
        s = new Sokkelo();
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
