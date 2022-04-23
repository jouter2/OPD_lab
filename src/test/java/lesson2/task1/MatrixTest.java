package lesson2.task1;

import lesson1.task1.Matrix;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MatrixTest {

    private Matrix matrix;

    @Before
    public void startUp() {
        final int[][] array = new int[][]{{1, 2, 3}, {3, 3, 6}, {5, 5, 5}};
        matrix = new Matrix(array);
    }

    @Test
    public void sortByMinTest() {
        final int[][] expectedArray = new int[][]{{1, 2, 3}, {3, 3, 6}, {5, 5, 5}};
        matrix.sortByMin();
        assertArrayEquals(expectedArray, matrix.getArray());
    }

    @Test
    public void sortByMaxTest() {
        final int[][] expectedArray = new int[][]{{1, 2, 3}, {5, 5, 5}, {3, 3, 6}};
        matrix.sortByMax();
        assertArrayEquals(expectedArray, matrix.getArray());
    }

    @Test
    public void sortByLineTest() {
        final int[][] expectedArray = new int[][]{{1, 2, 3}, {3, 3, 6}, {5, 5, 5}};
        matrix.sortByLine();
        assertArrayEquals(expectedArray, matrix.getArray());
    }

    @Test
    public void sortByLineTestSecond() {
        final int[][] array = new int[][]{{6, 8, 9}, {3, 1, 6}, {5, 7, 9}};
        matrix = new Matrix(array);
        final int[][] expectedArray = new int[][]{{3, 1, 6}, {5, 7, 9}, {6, 8, 9}};
        matrix.sortByLine();
        assertArrayEquals(expectedArray, matrix.getArray());
    }

    @Test
    public void sortByMinElementTestSecond() {
        final int[][] array = new int[][]{{6, 8, 9}, {3, 1, 6}, {5, 7, 9}};
        matrix = new Matrix(array);
        final int[][] expectedArray = new int[][]{{3, 1, 6}, {5, 7, 9}, {6, 8, 9}};
        matrix.sortByMin();
        assertArrayEquals(expectedArray, matrix.getArray());
    }

    @Test
    public void sortByMaxElementTestSecond() {
        final int[][] array = new int[][]{{6, 8, 9}, {3, 1, 6}, {5, 7, 9}};
        matrix = new Matrix(array);
        final int[][] expectedArray = new int[][]{{3, 1, 6}, {6, 8, 9}, {5, 7, 9}};
        matrix.sortByMax();
        assertArrayEquals(expectedArray, matrix.getArray());
    }
}
