public class Solution {
    public String countAndSay(int n) {
        return recursiveCount("1", n);
    }
    private static String recursiveCount(String str, int n){
        if(n==1)    return str;
        int count = 0;
        int val = 0;
        int lastVal = 0;
        StringBuffer strb = new StringBuffer();
        
        for(int i=0; i<str.length();i++){
            int digit = Integer.parseInt(str.substring(i,i+1));
            if(digit==lastVal){
                count++;
            }else{
                if(count>0){
                    strb.append(Integer.toString(count));
                    strb.append(Integer.toString(lastVal));
                }
                lastVal = digit;
                count = 1;
            }
        }
        strb.append(Integer.toString(count));
        strb.append(Integer.toString(lastVal));
        return recursiveCount(strb.toString(), n-1);
    }
}