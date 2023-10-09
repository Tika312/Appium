package digitalnomads;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        System.out.println(Test.getNumberOfOccurencies("Tilek",'K'));
        String result = Test.formattedString("Name:Tony Montana");
        System.out.println(result);

        Map<String,String> data = new LinkedHashMap<>();
        data.put("name","Ivan");
        data.put(null,"null");
        System.out.println(data.get(null));

    }




}