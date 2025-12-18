class Mango {
    public static void main(String[] args) {
        String name = "Vincent Massey";

        // System.out.println(name.substring(6)); // from that index and after

        String sub = name.substring(8);
        char ch = name.charAt(0);

        // System.out.println(ch + 1); // adds 1 to the binary value of the character I think
        // System.out.println(sub + 1); // concatenates i think

        System.out.println(ch == 'V'); // shallow equals
        System.out.println(sub == "Massey");
        System.out.println(sub.equals("Massey")); // deep equals
        System.out.println(name == "Vincent Massey"); // shallow

        // for (int i = 0; i < name.length(); i++) {
        //     System.out.println(name.charAt(i));
        // }

        // for (char c : name.toCharArray()) {
        //     System.out.println(c);
        // }
        
        // System.out.println(name.toUpperCase());
        // System.out.println(name.toLowerCase());
    }
}