import static org.junit.Assert.*;

import org.junit.Test;


public class FlikTest {
    @Test
    public void isSameNumber() {
        int a = 128;
        int b = 128;
        int c = 0;
        int d = 0;
        int e= 500;
        int f = 500;
        assertEquals(true, Flik.isSameNumber(a, b));
        assertEquals(true, Flik.isSameNumber(c, d));
        assertEquals(true, Flik.isSameNumber(e, f));
    }
}
