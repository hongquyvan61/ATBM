/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class luythuanhanh {
    public long modexp(long a, long x, long n){
        long r=1;
            while (x>0){
                    if (x%2==1) 
                    {
                        r=(r*a)%n;
                    }
                    a=(a*a)%n;
                    x/=2;
            }
        return r;
    }
}
