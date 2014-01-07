public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
	    if(len<2)	return len;
	        
	    int runner = 1;
	    int slow = 0;
	    int count = 1;
	    while(runner<len){
	        if(A[runner]==A[slow]){
	            count++;
	            runner++;
	        }else{
	            if(count>2){
	                len = shiftArray(A,len,runner,runner-slow-2);	
	                count = 2;
	            }
	        	slow += count;
	        	runner = slow + 1;
	        	count = 1;
	        }	
	    }
	    if(count>2){
	        len -= runner-slow-2; 
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