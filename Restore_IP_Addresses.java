public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> results = new ArrayList<String>();
        if(s==null){
            return results;
        }
        restoreHelper(s, 0, "", 1, results);
        return results;
    }
    private void restoreHelper(String s, int i, String path, int num, ArrayList<String> results){
        if(num==5){
            if(i==s.length()){
                results.add(path);
                return;
            }else{
                return;
            }
        }
        if(i>=s.length()){
        	return;
        }
        if(num>1){
        	path += ".";
        }
        
        restoreHelper(s, i+1, path+s.substring(i,i+1), num+1, results);
        if(validNumber(s.charAt(i))){
        	if(i<s.length()-1){
	            restoreHelper(s, i+2, path+s.substring(i,i+2), num+1, results);
	        }
	        if(i<s.length()-2 && validNumber(s.substring(i,i+3))){
	            restoreHelper(s, i+3, path+s.substring(i,i+3), num+1, results);
	        }
        }
        return;
    }
    private boolean validNumber(char c){
        return c!='0';
    }
    private boolean validNumber(String s){
        return Integer.parseInt(s)<256;
    }
}