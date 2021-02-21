import java.util.*;
import java.util.stream.Collectors;

public class QuantityOfCuts {

    /**
     * Есть лист объектов "Отрезок":
     * class Cut{
     * int left;
     * int right;
     * }
     * и есть лист Integer чисел - List<Integer> numbers.
     * Вернуть Map<Integer, Integer> ключами которого являются числа из листа (Integer),
     * а значения - это кол-во отрезков покрывающих это число.
     * <p>
     * Map<Integer, Integer> solve (List<Cut> cuts, List<Integer> numbers)cuts
     */

    public Map<Integer, Integer> quantityOfCuts(List<Cut> cuts, List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        Map<Integer, Integer> resMap = new HashMap<>();
        Deque<Cut> cutDeque = new ArrayDeque<>(cuts);

        while (cutDeque.size() != 0) {
            for (Integer number : sortedNumbers) {
                if (cutDeque.getFirst().getLeft() <= number && cutDeque.getFirst().getRight() >= number) {
                    resMap.merge(number, 1, (oldVal, newVal) -> oldVal + 1);
                } else if (cutDeque.getFirst().getRight() < number) {
                    break;
                }
            }
            cutDeque.removeFirst();
        }
        return resMap;
    }
}