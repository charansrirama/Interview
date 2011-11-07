package th.String;

import javax.swing.JOptionPane;  

public class ReverseString {  
      
    public static void main (String args[]){  
        String originalString;  
        String resultString = "";     
          
        originalString = JOptionPane.showInputDialog("Please input a String: ");  
          
        char[] charArray = originalString.toCharArray();  
      
        for (int i=0, j = charArray.length-1; i<j; i++, j--){  
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }  
        JOptionPane.showMessageDialog(null, new String(charArray), "Reverse String", JOptionPane.INFORMATION_MESSAGE);  
    }  
}  