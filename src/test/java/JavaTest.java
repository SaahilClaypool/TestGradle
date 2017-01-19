import junit.framework.*; 
import org.junit.Test; 
import org.junit.Ignore; 
import static org.junit.Assert.assertEquals; 


public class JavaTest extends TestCase {
    protected int value1, value2; 

    // run every test
    protected void setUp() {
        value1 = 1; 
        value2 = 1; 
    }

    @Test
    public void testAdd() {
        double res = value1 + value2; 
        assertTrue(res == 2); 
    }
    @Test
    public void testIfThisWorks() {
        assertTrue(true);
    }
    @Test
    public void testFail () {
        assertTrue( true);
    }
}


