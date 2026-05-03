public class practice {
    public static int AddingNumbers(int a, int b) {
        int sum = a + b;
        System.out.println("The sum is " + sum);
        return sum;
    }

    public static int MultiplyingNumbers(int a, int b) {
        int product = a * b;
        System.out.println("The product is " + product);
        return product;
    }

    public static int DividingNumbers(int a, int b) {
        int quotient = a / b;
        System.out.println("The quotient is " + quotient);
        return quotient;
    }

    public static int NegativeMachine(int a) {
        int Negative = a * (-1);
        System.out.println("The Negative Machine Deams it as " + Negative);
        return Negative;
    }

    public static void main(String[] args) {
        practice.AddingNumbers(4, 4);
        practice.MultiplyingNumbers(200, 423);
        practice.DividingNumbers(10, 5);
        practice.NegativeMachine(16);
    }

}
