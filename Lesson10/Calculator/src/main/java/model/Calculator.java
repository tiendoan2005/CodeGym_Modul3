package model;

public class Calculator {
    public static double calculator(double a, double b, String operator) throws Exception {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new Exception("Không thể chia cho 0");
                }
                return a / b;
            default:
                throw new Exception("Toán tử không hợp lệ");
        }
    }
}
