import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class QuantityOfCutsTest {
    QuantityOfCuts quantity = new QuantityOfCuts();

    List<Integer> numbers = Arrays.asList(7, 13, 1, 10, 3);


    @Test
    void testQuantityOfCuts_1() {
        List<Cut> cuts = Collections.singletonList(new Cut(4, 6));

        Map<Integer, Integer> exp = new HashMap<>();

        Map<Integer, Integer> akt = quantity.quantityOfCuts(cuts, numbers);

        assertEquals(exp, akt);
    }

    @Test
    void testQuantityOfCuts_2() {
        List<Cut> cuts = Collections.singletonList(new Cut(1, 1));

        Map<Integer, Integer> exp = new HashMap<>();
        exp.put(1, 1);

        Map<Integer, Integer> akt = quantity.quantityOfCuts(cuts, numbers);

        assertEquals(exp, akt);
    }

    @Test
    void testQuantityOfCuts_3() {
        List<Cut> cuts = Collections.singletonList(new Cut(1, 2));

        Map<Integer, Integer> exp = new HashMap<>();
        exp.put(1, 1);

        Map<Integer, Integer> akt = quantity.quantityOfCuts(cuts, numbers);

        assertEquals(exp, akt);
    }

    @Test
    void testQuantityOfCuts_4() {
        List<Cut> cuts = Collections.singletonList(new Cut(6, 8));

        Map<Integer, Integer> exp = new HashMap<>();
        exp.put(7, 1);

        Map<Integer, Integer> akt = quantity.quantityOfCuts(cuts, numbers);

        assertEquals(exp, akt);
    }

    @Test
    void testQuantityOfCuts_5() {
        List<Cut> cuts = Collections.singletonList(new Cut(11, 13));

        Map<Integer, Integer> exp = new HashMap<>();
        exp.put(13, 1);

        Map<Integer, Integer> akt = quantity.quantityOfCuts(cuts, numbers);

        assertEquals(exp, akt);
    }

    @Test
    void testQuantityOfCuts_6() {
        List<Cut> cuts = Arrays.asList(new Cut(1, 2),
                new Cut(4, 5),
                new Cut(8, 9));

        Map<Integer, Integer> exp = new HashMap<>();
        exp.put(1, 1);

        Map<Integer, Integer> akt = quantity.quantityOfCuts(cuts, numbers);

        assertEquals(exp, akt);
    }

    @Test
    void testQuantityOfCuts_7() {
        List<Cut> cuts = Arrays.asList(new Cut(1, 2),
                new Cut(6, 8),
                new Cut(11, 13));

        Map<Integer, Integer> exp = new HashMap<>();
        exp.put(1, 1);
        exp.put(7, 1);
        exp.put(13, 1);

        Map<Integer, Integer> akt = quantity.quantityOfCuts(cuts, numbers);

        assertEquals(exp, akt);
    }

    @Test
    void testQuantityOfCuts_8() {
        List<Cut> cuts = Arrays.asList(new Cut(1, 2),
                new Cut(1, 7),
                new Cut(1, 13));

        Map<Integer, Integer> exp = new HashMap<>();
        exp.put(1, 3);
        exp.put(3, 2);
        exp.put(7, 2);
        exp.put(10, 1);
        exp.put(13, 1);

        Map<Integer, Integer> akt = quantity.quantityOfCuts(cuts, numbers);

        assertEquals(exp, akt);
    }

    @Test
    void testQuantityOfCuts_9() {
        List<Cut> cuts = Arrays.asList(new Cut(1, 3),
                new Cut(2, 11),
                new Cut(3, 6));

        Map<Integer, Integer> exp = new HashMap<>();
        exp.put(1, 1);
        exp.put(3, 3);
        exp.put(7, 1);
        exp.put(10, 1);

        Map<Integer, Integer> akt = quantity.quantityOfCuts(cuts, numbers);

        assertEquals(exp, akt);
    }
}
