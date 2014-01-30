// DP -- O(n)
// count[i] = count[i-1] if s[i] is a valid char
// count[i] = count[i-1]+count[i-2] if s[i-1]+s[i] is still valid
// when s[i] == '0', check the validation of s[i-1]+s[i]
// and count[i] = count[i-1]-1 if s[i-2]+s[i-1] is valid

public class Solution {
     public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0'){
            return 0;
        }
        if(s.length()==1){
        	return 1;
        }
        
        int result = 0;
        int result_1 = 0;
        int result_2 = 1;
        
        if(validSingleChar(s.charAt(1))){
        	result_1 += 1;
        }
        if(validDoubleChars(s.charAt(0), s.charAt(1))){
        	result_1 += 1;
        }
        result = result_1;
        
        for(int i=2; i<s.length(); i++){
        	char c = s.charAt(i);
        	if(validSingleChar(c)){
        		if(validDoubleChars(s.charAt(i-1), c)){
        			result = result_1 + result_2;
        		}else{
        			result = result_1;
        		}
        	}else{
        	    if(!validDoubleChars(s.charAt(i-1), c)){
        	        return 0;
        	    }
        		if(validDoubleChars(s.charAt(i-2), s.charAt(i-1))){
        			result = result_1 - 1;
        		}else{
        			result = result_1;
        		}
        	}
        	
        	result_2 = result_1;
        	result_1 = result;
        }
        return result;
        
    }
    private boolean validSingleChar(char c){
    	return c!='0';
    }
    private boolean validDoubleChars(char c1, char c2){
    	return (c1=='1' || (c1=='2' && c2<'7'));
    }
}