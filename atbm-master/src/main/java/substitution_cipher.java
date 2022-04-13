
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author blemb
 */
public class substitution_cipher {
    public static char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' };
    
 
    public String doEncryption(String s, String k)
    {
        char ch[] = k.toCharArray();
        char c[] = new char[(s.length())];
        String cipher = "";
        for (int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != ' '){
            for (int j = 0; j < 26; j++)
            {   
                
                if (p[j] == s.charAt(i))
                {
                    c[i] = ch[j];
                    cipher += c[i];
                    break;
                }
               
            }
             } else cipher += s.charAt(i);
        }
        return (cipher);
    }
 
    public String doDecryption(String s, String k)
    {
        char ch[] = k.toCharArray();
        char p1[] = new char[(s.length())];
        String msg = "";
        for (int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != ' '){
            for (int j = 0; j < 26; j++)
            {
                
                if (ch[j] == s.charAt(i))
                {
                    p1[i] = p[j];
                    msg += p1[i];
                    break;
                }
            }
            } else msg += s.charAt(i);
        }
        return (msg);
    }
 
    public static void main(String args[])
    {
        
    }
}
