public class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null || s.equals(""))
    		return 0;
        String[] words = s.split("\\s+");
        if(words.length==0)
        	return 0;
        String lastWord = words[words.length-1];
        char[] characters = lastWord.toCharArray();
        return characters.length;
    }
}