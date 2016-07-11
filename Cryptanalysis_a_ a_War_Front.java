import java.io.*;
import java.util.*;
import java.lang.*;
import static java.lang.Math.toIntExact;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.next();
                
        int fromBase = findBase(inputString);
        int toBase = 10;
        String number = new String();
        
        Map<Character, Character> charMap = new HashMap<Character, Character>();
        
        // add all distinct chars to a map
        for (int i = 0; i < inputString.length(); i++) {
            if (!charMap.containsKey(String.valueOf(inputString.charAt(i)))) {
                charMap.put(inputString.charAt(i), '_');
            }
        }
        
        int replaceInt = 0;
        for(int i = 0, n = inputString.length() ; i < n ; i++) { 
            if(i == 0) {
                charMap.put(inputString.charAt(i), '1');
            } else {
                if(charMap.get(inputString.charAt(i)).equals('_')) {
                    charMap.put(inputString.charAt(i), Integer.toString(replaceInt).charAt(0));
                    if (replaceInt == 0) {
                        replaceInt = 2;
                    } else {
                        replaceInt++;
                    }
                }
            }
        }
        
        for(int i = 0; i < inputString.length(); i++) {
            number += charMap.get(inputString.charAt(i)).toString().charAt(0);
        }
        
        System.out.println(Integer.toString(Integer.parseInt(number, fromBase), toBase));
    }
    
    // guess the least possible base
    public static int findBase(String inputString) {
        // count the no. of different chars in the string
        int base = toIntExact(inputString.chars().distinct().count());
        if (base >= 2) return toIntExact(inputString.chars().distinct().count());
        return 2;
    }
}
