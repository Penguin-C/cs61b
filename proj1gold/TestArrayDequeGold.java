import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestArrayDequeGold {
    @Test
    public void test1() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(100);
            ads.addLast(random);
            sad.addLast(random);
            System.out.println("addLast(" + random + ")");
        }
        for (int i = 0; i < 10; i++) {
            int actual = ads.get(i);
            int expected = sad.get(i);
            assertEquals("addLast(): " + actual,
                    expected, actual);
        }

        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(100);
            ads.addFirst(random);
            sad.addFirst(random);
            System.out.println("addFirst(" + random + ")");
        }
        for (int i = 0; i < 10; i++) {
            int actual = ads.get(i);
            int expected = sad.get(i);
            assertEquals("addFirst(): " + actual,
                    expected, actual);
        }

        List<Integer> actualList = new ArrayList<>();
        List<Integer> expectedList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            actualList.add(ads.removeFirst());
            expectedList.add(sad.removeFirst());
        }
        for (int i = 0; i < 10; i++) {
            int actual = ads.get(i);
            int expected = sad.get(i);
            assertEquals("removeFirst(): " + actual,
                    expected, actual);
        }
        for (int i = 0; i < 10; i++) {
            int actual = actualList.get(i);
            int expected = expectedList.get(i);
            assertEquals("removeFirst(): " + actual,
                    expected, actual);
            System.out.println("removeFirst()");
        }

        actualList.clear();
        expectedList.clear();
        for (int i = 0; i < 10; i++) {
            actualList.add(ads.removeLast());
            expectedList.add(sad.removeLast());
        }
        for (int i = 0; i < 10; i++) {
            assertEquals("removeLast(): " + actualList.get(i),
                    expectedList.get(i), actualList.get(i));
            System.out.println("removeLast()");
        }
    }
}
