class PracTest11 {
    public static void main(String[] owo) {
        double balance = 0;
        double deposit = 2000;
        for (int i = 0; i < 20; ++i) {
            balance += deposit;
            deposit *= 1.05;
            balance *= 1.08; // compound interest
        }
        System.out.printf("$%.2f\n", balance);
    }
}