package assignment1;

public class A1 {
    public static double calculateSalary(int wage, int extraWage, int extraHours, int numOfDeals) {

        if (numOfDeals <= 4){
            return wage + extraWage * extraHours;
        }
        if (numOfDeals <= 7){
            if (extraHours < 10){
                return wage + wage * 0.05 + extraWage * extraHours;
            }
            else {
                return wage + wage * 0.1 + extraWage * extraHours;
            }
        }
        else {
            if (extraHours < 5){
                return wage + wage * numOfDeals * 0.02 + extraWage * extraHours;
            }
            else {
                return wage + wage * numOfDeals * 0.03 + extraWage * extraHours;
            }
        }
    }

    public static int oddNumber(int num) {
        int new_num = 0;
        int count = 1;
        int rest = num;
        while (num != 0){
            rest = num%10;
            num /= 10;
            if (rest % 2 == 1){
                new_num += rest * count;
                count *= 10;
            }
        }
        return new_num;
    }

    public static int sumOfDigits(int num) {
        if (num < 0) {
            return -1;
        }
        if (num == 0) {
            return 0;
        }
        int value =  num % 10 + sumOfDigits(num /= 10);
        if (value >= 10){
            int v = value % 10;
            value /= 10;
            return v + value;
        }
        return value;
    }

    public static int contains(int[] arr1, int[] arr2){
        if (arr2 == null){
            return 0;
        }
        if (arr1 == null){
            return -1;
        }
        if (arr2.length == 0){
            return 0;
        }
        if (arr1.length == 0){
            return -1;
        }
        if (arr2.length > arr1.length){
            return -1;
        }
        int index = 0;
        while (index <= arr1.length - 1){
            if (arr2[0] == arr1[index]){
                if (arr2.length > arr1.length - index){
                    return -1;
                }
                if (arr2.length == 1){
                    return index;
                }
               int count = 1;
               int num_1 = index;
               while (count <= arr2.length - 1){
                   index ++;
                   if (count == arr2.length - 1){
                       if (arr2[count] == arr1[index]){
                           return num_1;
                       }
                   }
                   if (arr2[count] == arr1[index]) {
                       count++;
                   } else {
                       index--;
                       break;
                   }
               }
            }
            index ++;
        }
        return -1;
    }

    public static int[][] flipMatrix(int[][] arr, int option) {
        if (arr == null){
            return null;
        }
        if (option == 1){
            int rows = arr.length;
            int cols = arr[0].length;
            int[][] rotated = new int[cols][rows];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    rotated[j][rows - i - 1] = arr[i][j];
                }
            }
            arr = rotated;
        }
        if (option == 2){
            int row = arr.length;
            int col = arr[0].length;
            int[][] rotated = new int[col][row];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    rotated [col - j - 1][i] = arr[i][j];
                }
            }
            arr = rotated;
        }
        if (option == 3){
            int finish = arr.length - 1;
            int start = 0;

            while (finish > start){
                int [] row = arr[start];
                arr[start] = arr[finish];
                arr[finish] = row;
                start ++;
                finish --;
            }
        }
        if (option == 4){
            int rows = arr.length;
            int cols = arr[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols / 2; j++) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[i][cols - j - 1];
                    arr[i][cols - j - 1] = temp;
                }
            }
        }
        return arr;
    }
}
