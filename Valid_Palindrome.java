// 1. two pointer from start and end to check char
// 2. check the validation and skip invalid ones
// 3. check the index to avoid nullPointerException

public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null)  
            return false;
        if(s.length()<2)    return true;
        
        s = s.toLowerCase();
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            while(!validChar(s.charAt(start))){
                start++;
                if(start==s.length())   break;
            }
            while(!validChar(s.charAt(end))){
                end--;
                if(end<0)   break;
            }
            if(start>end)   break;
            
            if(s.charAt(start)!=s.charAt(end))  return false;
            start++;
            end--;
        }
        return true;
    }
    private static boolean validChar(char c){
        if((c>='a'&&c<='z')||(c>='0'&&c<='9'))   return true;
        return false;
    }
}