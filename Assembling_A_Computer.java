import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        
        int[] NoOfComponents = new int[6];
        Arrays.fill(NoOfComponents, 0);
        
        // find the no of components available
        for(int i = 0, n = inputString.length() ; i < n ; i++) { 
            char c = inputString.charAt(i); 
            
            if (c == 'A') {
                NoOfComponents[0]++;
            } else if (c == 'D') {
                NoOfComponents[1]++;
            } else if (c == 'X') {
                NoOfComponents[2]++;
            } else if (c == 'Y') {
                NoOfComponents[3]++;
            } else if (c == 'P') {
                NoOfComponents[4]++;
            } else if (c == 'R') {
                NoOfComponents[5]++;
            }
        }
        
        // find the min
        Arrays.sort(NoOfComponents);
        System.out.println(NoOfComponents[0]);
    }
} 
