
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JouluTiraTest {
    
    
    public JouluTiraTest() {
    }
        
    @Before
    public void setUp() {
    }
    
    @Test
    public void testaaTulostus(){
        char[][] s = new char[][] {{'0'}};
        
        assertEquals(s[0][0], '0');
    }
    @After
    public void tearDown() {
    }
    
    @Test
    public void testaaPaikka(){
        
        Paikka p = new Paikka(1, 1);
        
        assertEquals(1, p.getY());
    }
}
