
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class MahoaHillTestCase {
    @ParameterizedTest
    @CsvSource({"DPLE,HELP", "DPOF, HELP"})
    public void testHillCipher(String expected, String message){
        int keyMatrix[][] = {{3,3}, {2,5}};
        hill_cipher obj = new hill_cipher();
        int m = message.length()/2;
        if((message.length())%2 > 0){
           m++;
        }
        String actual = obj.HillCipher(message, keyMatrix, m);
        Assertions.assertEquals(expected,actual);
    }
    
    @ParameterizedTest
    @CsvSource({"3,9", "3,4", "2,-1","2,5"})
    public void testCheckInv(int input, int expected){
        hill_cipher obj = new hill_cipher();
        Assertions.assertEquals(expected,obj.checkInv(input));
    }
}
