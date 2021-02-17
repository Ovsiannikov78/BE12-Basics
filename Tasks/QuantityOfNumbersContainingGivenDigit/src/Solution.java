import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Есть диапазон чисел от a до b включительно.
     * Найти количество чисел, содержащих цифру 1.
     */

    public int quantityOfNumbersContainingDigitN(int a, int b) {
        List<Integer> num = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            num.add(i);
        }
        return (int) num.stream()
                .map(Object::toString)
                .filter(str -> str.contains("1"))
                .count();
    }
}
