package digitalnomads;

public class Test {


    public static String formattedString(String text){
        String result="";
        for (int i=0; i< text.length(); i++){
            if (text.charAt(i)==':'){
                result = text.substring(i+1);
            }
        }
        return result;
    }


    public static int getNumberOfOccurencies(String word, char letter){

        char[]letters = word.toCharArray();
        int count=0;

        for (char c : letters) {
            if (letter == c ) {
                count++;
            }
        }
        return count;
    }
}
