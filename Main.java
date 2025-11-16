public class Main {
    public static void main(String[] args) {

        // ===== Testing countOccurrences =====
        int[] arr1 = {1, 2, 3, 2, 4, 2};
        System.out.println("Occurrences of 3: " + countOccurrences(arr1, 3)); // expect 3


        // ===== Testing reverseArray =====
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] reversed = reverseArray(arr2);

        System.out.print("Reversed array: ");
        for (int n : reversed) {
            System.out.print(n + " ");
        }
        System.out.println(); // newline



        // ===== Testing sumGrid =====
        double[][] grid = {
            {1.5, 2.0, 3.5},
            {4.0, 1.0, 0.5},
            {2.2, 3.3, 1.1}
        };

        System.out.println("Sum of grid: " + sumGrid(grid));  // expect 18.1



        // ===== Testing fib =====
        System.out.println("fib(0): " + fib(0));  // expect 0
        System.out.println("fib(1): " + fib(1));  // expect 1
        System.out.println("fib(6): " + fib(6));  // expect 8
        System.out.println("fib(10): " + fib(10)); // expect 55
    }



    // ===== Function 1: countOccurrences =====
    public static int countOccurrences(int[] arr, int n) {
        int count = 0;

        for (int value : arr) {
            if (value == n) {
                count++;
            }
        }

        return count;
    }



    // ===== Function 2: reverseArray =====
    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }

        return reversed;
    }



    // ===== Function 3: sumGrid =====
    public static double sumGrid(double[][] grid) {
        double sum = 0.0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                sum += grid[row][col];
            }
        }

        return sum;
    }



    // ===== Function 4: fib =====
    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0; // fib(0)
        int b = 1; // fib(1)

        for (int i = 2; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }

        return b;
    }
}
