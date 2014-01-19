/*
 * Given an array S of n integers, are there elements a, b, c, and d in S 
 * such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */

/* 
 *	1. cannot use tree to search, because it'll miss the sulution across two brenches
 * 	2. fix two nums and walk through other two --> O(n^3)
 * 	3. during the iteration, avoid repeatation but be sure the index is not out of boundaries 
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	if(num==null || num.length==0)  return results;
    	
    	Arrays.sort(num);
    	for(int i=0;i<num.length-3;i++){
    	    if(i>0 && num[i-1]==num[i])     continue;
    	    if(num[i]>0 && num[i]>target)   break;
    	    for(int j=i+1;j<num.length-2;j++){
    	        if(j>i+1 && num[j-1]==num[j])   continue;
    	        if(num[j]>0 && (num[i]+num[j])>target)  break;
    	        
    	        int start = j+1; 
    	        int end = num.length-1;
    	        while(start<end){
    	            while(start>(j+1) && start<num.length && num[start]==num[start-1])  start++;
    	            while(end<num.length-1 && end>=0 && num[end]==num[end+1]) end--;
    	            if(start>=end)	break;
    	            int tmp = num[i]+num[j]+num[start]+num[end];
    	            if(tmp==target){
    	                ArrayList<Integer> array = new ArrayList<Integer>();
    	                array.add(num[i]);
    	                array.add(num[j]);
    	                array.add(num[start]);
    	                array.add(num[end]);
    	                results.add(array);
    	                start++;
    	                end--;
    	            }
    	            else if(tmp>target)     end--;
    	            else                    start++;
    	        }
    	    }
    	}
    	return results;
    }
}