import static org.junit.Assert.*;

import org.junit.Test;

public class TestOffByN {
    static CharacterComparator offbyn = new OffByN(4);

    @Test
    public void testEqualChars() {
        assertTrue(offbyn.equalChars('a', 'e'));
        assertFalse(offbyn.equalChars('a', 'b'));
    }
}
