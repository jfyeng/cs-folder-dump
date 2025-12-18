
class Grape {
    public static void main(String[] owo) {
        System.out.println(mixer("mckenzie"));
    }

    static String mixer(String word){
        if(word.equals("")){
            return "";
        }
        else{
            return word.charAt(0) + mixer(word.substring(1))
            + mixer(word.substring(0,word.length()-1));
        }
    }
}