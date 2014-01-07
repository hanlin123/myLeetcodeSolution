public class Solution {
    public String addBinary(String a, String b) {
        if(a==null || b==null)	return null;
        
        int carry = 0;
        int indexA = a.length()-1;
        int indexB = b.length()-1;
        StringBuilder builder = new StringBuilder();
       
        while(indexA>-1 && indexB>-1){
        	int result = a.charAt(indexA) - 48 + b.charAt(indexB) - 48 + carry;
        	if(result>1){
        		carry = 1;
        		result -= 2;
        	}else
        		carry = 0;
        	builder.insert(0, result);
        	indexA--;
        	indexB--;
        }
        while(indexA>-1){
        	int result = a.charAt(indexA) - 48 + carry;
        	if(result>1){
        		carry = 1;
        		result -= 2;
        	}else
        		carry = 0;
        	builder.insert(0, result);
        	indexA--;
        }
        while(indexB>-1){
        	int result = b.charAt(indexB) - 48 + carry;
        	if(result>1){
        		carry = 1;
        		result -= 2;
        	}else
        		carry = 0;
        	builder.insert(0, result);
        	indexB--;
        }
        if(indexA<0 && indexB<0 && carry>0){
        	builder.insert(0, 1);
        }
        return builder.toString();
    }
}