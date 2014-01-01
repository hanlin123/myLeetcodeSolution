public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
	        if(len<2)	return len;
	        
	        int runner = 1;
	        int slow = 0;
	        while(runner<len){
	        	if(A[runner]==A[slow]){
	        		len = shiftArray(A,len,runner+1,1);	
	        	}else{
	        		runner++;
	        		slow++;
	        	}	
	        }
	        return len;
    }
    
    private static int shiftArray(int[] A, int len, int pos, int step){
	    	if(pos>len) return -1;
	    	if(pos==len) return len-1;
	    	
	    	while(pos<len){
	    		A[pos-step] = A[pos];
	    		pos++;
	    	}
	    	len -= step;
	    	return len;
	    }
}