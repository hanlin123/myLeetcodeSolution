/* 
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999
 */

 public class Solution {
    public String intToRoman(int num) {
        StringBuffer strb = new StringBuffer();
        String[] unit = {I, X, C, M};
        String[] half = {V, L, D};
        for(int i=3;i>0;i--){
        	int quantity = num/(10*i);
        	if(quantity==0)	continue;
        	if(quantity>0 && quantity<4){
        		for(int j=0;j<quantity;j++)	
        			strb.append(unit[i]);
        	}
        	else if(quantity==9){
        		strb.append(unit[i]+unit[i+1]);
        	}
        	else{
        		int sub = quantity-5;
        		if(sub<0)	strb.append(unit[i]+half[i]);
        		if(sub==0)	strb.append(half[i]);
        		if(sub>0){
        			strb.append(half[i]);
        			for(int j=0;j<sub;j++)	strb.append(unit[i]);
        		}
        	}
        }
        return strb.toString();
    }
}