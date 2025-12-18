// Method2.java
// James
// A method that takes a string and a number, then prints out the string that number of times.

class Method2 {

    public static void main(String[] owo) {
        String a = "mckenzie";
        int b = 9;
        repeat(a, b);
    }

    static void repeat(String str, int times) {
        for (int i = 0; i < times; ++i) {
            System.out.println(str);
        }
    }
}
