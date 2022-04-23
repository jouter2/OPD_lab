package lesson1.task1;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Getter
@Setter
public class Matrix {

    private final int[][] array;

    public Matrix(final int[][] array) {
        this.array = array;
    }

    public void sortByMin() {
        sort(this::getMin);
    }

    public void sortByMax() {
        sort(this::getMax);
    }

    public void sortByLine() {
        sort(this::getSumLen);
    }

    private Integer getMin(int[] ints) {
        int min = Integer.MAX_VALUE;
        for (int anInt : ints) {
            if (anInt < min) {
                min = anInt;
            }
        }
        return min;
    }

    private Integer getMax(int[] ints) {
        int max = Integer.MIN_VALUE;
        for (int j : ints) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    private int getSumLen(int[] array) {
        int count = 0;
        for (int j : array) {
            count += j;
        }
        return count;
    }

    private void sort(Function<? super int[], ? extends Integer> mappingFunction) {
        Map<int[], Integer> map = new HashMap<>();
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (map.computeIfAbsent(array[i], mappingFunction) > map.computeIfAbsent(array[i + 1], mappingFunction)) {
                    sw(i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    private void sw(int i, int i1) {
        int[] temp = array[i];
        array[i] = array[i1];
        array[i1] = temp;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(array);
    }
}
