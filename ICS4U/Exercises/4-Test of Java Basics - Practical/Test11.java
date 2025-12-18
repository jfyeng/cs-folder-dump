class Test11 {
    public static void main(String[] owo) {
        double bal = 1000000;
        int year_counter = 0;
        while (bal > 0) {
            bal *= 1.03;
            bal -= 80000;
            ++year_counter;
        }
        System.out.println(year_counter);
    }
}