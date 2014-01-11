// 1. O(N)
// 2. use differentia to get the peaks
// 3. skip same values

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2)
            return 0;
            
        int[] array = new int[prices.length-1];
        System.arraycopy(prices, 1, array, 0, array.length);
        int profit = 0;
        int index = 0;
        int lowest = prices[0];
        int highest = 0;
        for(index=0;index<array.length;index++){
        	int diff = array[index]-prices[index];
        	if(diff==0)	continue;
        	if(diff<0){
        		if(highest!=0){
        			int tmp = highest - lowest;
        			if(tmp>profit)	profit = tmp;
        			highest = 0;
        		}
        		if(lowest>array[index])
        			lowest = array[index];
        	}
        	if(diff>0){
        		highest = array[index];
        	}
        }
        int tmp = highest - lowest;
		if(tmp>profit)	profit = tmp;
        return profit;
    }
}