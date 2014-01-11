// 1. if the repeatation happens, update the substring from the char after the repeated char
// 2. check the length after the while loop

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.equals("")) return 0;
        
        int longestLength = 0;
        int index = 0;
        String sub = null;
        while(index<s.length()){
            if(sub==null){
                sub = s.substring(index, index+1);
            }else{
                char c = s.charAt(index);
                int pos = sub.indexOf(c);
                if(pos>=0){
                    if(sub.length()>longestLength)  longestLength = sub.length();
                    sub = s.substring(index-sub.length()+pos+1, index+1);
                }else{
                	sub = s.substring(index-sub.length(), index+1);
                }
            }
            index++;
        }
        if(sub.length()>longestLength)	longestLength = sub.length();
        return longestLength;
    }
}