
// notice the Integer.MIN_VALUE will cause overflow

public class Solution {
    public double pow(double x, int n) {
        if(n==0)    return 1.0;
        if(n==Integer.MIN_VALUE)
        	return 1.0/(pow(x, -(n+1))*x);
        if(n<0)     return 1.0/pow(x, -n);
        
        double result = 1.0;
        while(n>0){
            if((n&1)>0)   result *= x;
            x *= x;
            n >>= 1;
        }
        return result;
    }
}