import java.util.*;

class Kiwi {
    public static void main(String[] args) {
        String name = "   Vincent Massey  ";

        String[] words = name.split(" ");

        System.out.println(Arrays.toString(words));
        System.out.println(name.contains("Mass"));
        System.out.println(name.indexOf('M'));

        System.out.println(name.replace("e","oo"));
        System.out.println(name.replaceAll("e","oo")); // uses regex

        System.out.println(name.trim());
        
    }
}