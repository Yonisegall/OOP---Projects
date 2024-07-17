import assignment1.*;
import java.util.Arrays;


public class MainRunCalculate {

    private static void q1() {
        System.out.println("Question 1");
        System.out.println(A1.calculateSalary(3000, 40, 7, 2));
        System.out.println(A1.calculateSalary(41, 40, 6, 6));
        System.out.println(A1.calculateSalary(5000, 40, 12, 6));
        System.out.println(A1.calculateSalary(5000, 40, 3, 10));
        System.out.println("---------------------");

    }

    private static void q2() {
        System.out.println("Question 2");
        System.out.println(A1.oddNumber(12345) + " Need to be 135");
        System.out.println(A1.oddNumber(78864) + " Need to be 7");
        System.out.println(A1.oddNumber(88) + " Need to be 0");
        System.out.println();
        System.out.println("More tests");
        System.out.println(A1.oddNumber(11035) + " Need to be 1135");
        System.out.println(A1.oddNumber(996589) + " Need to be 9959");
        System.out.println(A1.oddNumber(65131479) + " Need to be 513179");
        System.out.println(A1.oddNumber(13555) + " Need to be 13555");
        System.out.println(A1.oddNumber(123545) + " Need to be 1355");
        System.out.println(A1.oddNumber(9965) + " Need to be 995");
        System.out.println(A1.oddNumber(13) + " Need to be 13");
        System.out.println(A1.oddNumber(1548956) + " Need to be 1595");
        System.out.println(A1.oddNumber(6884556) + " Need to be 55");
        System.out.println(A1.oddNumber(8888888) + " Need to be 0");
        System.out.println("---------------------");

    }

    private static void q3() {
        System.out.println("Question 3");
        System.out.println(A1.sumOfDigits(123) + " Need to be 6");
        System.out.println(A1.sumOfDigits(897) + " Need to be 6");
        System.out.println(A1.sumOfDigits(-5) + " Need to be -1");
        System.out.println("More tests");
        System.out.println(A1.sumOfDigits(99) + " Need to be 9");
        System.out.println(A1.sumOfDigits(635) + " Need to be 5");
        System.out.println(A1.sumOfDigits(7845) + " Need to be 6");
        System.out.println(A1.sumOfDigits(123456) + " Need to be 3");
        System.out.println("---------------------");

    }

    private static void q4() {
        System.out.println("Question 4");
        System.out.println(A1.contains(new int[]{2, 2, 6, 5, 1, 2, 3}, new int[]{6, 5, 1}));
        System.out.println(A1.contains(new int[]{7, 2, 1, 6, 2, 3}, new int[]{2, 1, 2}));
        System.out.println(A1.contains(new int[]{6, 9, 3, 1}, new int[]{6, 9, 3}));
        System.out.println();
        System.out.println("More tests");
        System.out.println(A1.contains(new int[]{7, 2, 1, 6, 2, 3, 2, 1, 2}, new int[]{2, 1, 2}) + "  Need to be 6");
        System.out.println(A1.contains(new int[]{7}, new int[]{6, 5, 1}) + "  Need to be -1");
        System.out.println(A1.contains(new int[]{}, new int[]{6, 5, 1}) + "  Need to be -1");
        System.out.println(A1.contains(new int[]{7, 2, 1, 6, 2, 3}, new int[]{}) + "  Need to be 0");
        System.out.println(A1.contains(new int[]{7, 2, 1, 6, 2, 3}, new int[]{5}) + "  Need to be -1");
        System.out.println(A1.contains(new int[]{7, 2, 1, 6, 2, 3}, new int[]{2}) + "  Need to be 1");
        System.out.println(A1.contains(new int[]{7, 2, 2, 1, 6, 2, 3}, new int[]{2, 1, 6}) + "  Need to be 2");
        System.out.println(A1.contains(new int[]{7, 2, 1, 6, 2, 3}, new int[]{6, 2}) + "  Need to be 3");
        System.out.println(A1.contains(new int[]{1, 1}, new int[]{1, 1}) + "  Need to be 0");
        System.out.println(A1.contains(new int[]{1, 1, 2}, new int[]{1, 4, 5, 6}) + "  Need to be -1");
        System.out.println(A1.contains(new int[]{7, 2, 1, 6, 2, 3}, new int[]{7, 2, 1, 6, 2, 3}) + "  Need to be 0");
        System.out.println(A1.contains(new int[]{7, 2, 1}, new int[]{2, 1}) + "  Need to be 1");
        System.out.println(A1.contains(new int[]{1, 6, 2, 3}, new int[]{3}) + "  Need to be 3");
        System.out.println(A1.contains(new int[]{2, 2, 2, 2}, new int[]{2, 2, 2, 2}) + "  Need to be 0");
        System.out.println(A1.contains(new int[]{1, 2, 2, 2}, new int[]{2, 2, 2, 2}) + "  Need to be -1");
        System.out.println(A1.contains(new int[]{1, 2, 2, 2}, new int[]{2, 2, 2}) + "  Need to be 1");
        System.out.println("---------------------");

    }

    private static void q5() {
        System.out.println("Question 5");
        System.out.println();
        int[][] startMatrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println("option 1");
        System.out.println(Arrays.deepToString(A1.flipMatrix(startMatrix, 1)));
        System.out.println();
        System.out.println("option 2");
        int[][] r = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.deepToString(A1.flipMatrix(r, 2)));
        System.out.println();
        System.out.println("option 3");
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.deepToString(A1.flipMatrix(a, 3)));
        System.out.println();
        System.out.println("option 4");
        int[][] g = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.deepToString(A1.flipMatrix(g, 4)));

    }

    public static void main(String[] args) {
        q1();
        q2();
        q3();
        q4();
        q5();
    }
}