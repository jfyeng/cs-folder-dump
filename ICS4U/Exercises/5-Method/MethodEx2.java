class MethodEx2 {
    public static void main(String[] owo) {
        String sentence = "Hi I am James and I am very cool.";
        System.out.println(novowel(sentence));
    }

    static String novowel(String str) {
        String result = "";
        for (char c : str.toCharArray()) {
            if (!"AEIOUaeiou".contains(""+c)) {
                result += c;
            }
        }
        return result;
    }
}