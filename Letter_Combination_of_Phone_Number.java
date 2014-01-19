/*
 * Given a digit string, 
 * return all possible letter combinations that the number could represent.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        result.add("");
        int index = 0;
        while(index<digits.length()){
        	if(digits.charAt(index)=='2')				appendString(result, new String[]{"a","b","c"});
        	else if(digits.charAt(index)=='3')	appendString(result, new String[]{"d","e","f"});
        	else if(digits.charAt(index)=='4')	appendString(result, new String[]{"g","h","i"});
        	else if(digits.charAt(index)=='5')	appendString(result, new String[]{"j","k","l"});
        	else if(digits.charAt(index)=='6')	appendString(result, new String[]{"m","n","o"});
        	else if(digits.charAt(index)=='7')	appendString(result, new String[]{"p","q","r","s"});
        	else if(digits.charAt(index)=='8')	appendString(result, new String[]{"t","u","v"});
        	else if(digits.charAt(index)=='9')	appendString(result, new String[]{"w","x","y","z"});
        	else	continue;
        	index++;
        }
        return result;
    }

    private static void appendString(ArrayList<String> array, String[] strs){
    		int oldSize = array.size();
    		for(int i=0;i<oldSize;i++){
    			String oldStr = array.get(i);
    			for(int j=1;j<strs.length;j++){
    				array.add(oldStr+strs[j]);
    			}
    			array.set(i, oldStr+strs[0]);
    		}
    		
    }
}