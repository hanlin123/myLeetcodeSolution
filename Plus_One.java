public class Solution {
    public int[] plusOne(int[] digits) {
        int add = recursiveAdding(digits, 0);
        if(add==0)   return digits;
        
        int[] result = new int[digits.length+1];
        result[0] = 1;
        System.arraycopy(digits,0,result,1,digits.length);
        return result;
    }
    private static int recursiveAdding(int[] digits, int pos){
        int add = 0;
        if(pos<digits.length-1){
            add = recursiveAdding(digits, pos+1);
        }
        else{
            // the last digit
            add = 1;
        }
        
        digits[pos] += add;
        if(digits[pos]>9){
            digits[pos] = 0;
            return 1;
        }else{
            return 0;
        }
    }
}