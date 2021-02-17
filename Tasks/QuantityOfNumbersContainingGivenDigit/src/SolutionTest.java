import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void quantityOfNumbersContainingDigitN_1() {
        int exp = 0;
        int akt = solution.quantityOfNumbersContainingDigitN(2, 9);

        assertEquals(exp, akt);
    }

    @Test
    void quantityOfNumbersContainingDigitN_2() {
        int exp = 1;
        int akt = solution.quantityOfNumbersContainingDigitN(1, 1);

        assertEquals(exp, akt);
    }

    @Test
    void quantityOfNumbersContainingDigitN_3() {
        int exp = 1;
        int akt = solution.quantityOfNumbersContainingDigitN(1, 9);

        assertEquals(exp, akt);
    }

    @Test
    void quantityOfNumbersContainingDigitN_4() {
        int exp = 2;
        int akt = solution.quantityOfNumbersContainingDigitN(1, 10);

        assertEquals(exp, akt);
    }

    @Test
    void quantityOfNumbersContainingDigitN_5() {
        int exp = 11;
        int akt = solution.quantityOfNumbersContainingDigitN(1, 20);

        assertEquals(exp, akt);
    }
}
