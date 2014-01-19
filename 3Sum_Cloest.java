/*
 * Given an array S of n integers, find three integers in S such that the 
 * sum is closest to a given number, target. Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution
 */

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        Integer result = null;
        
        for(int i=0; i<num.length-2;i++){
        	if(i!=0 && num[i-1]==num[i])	continue;
        	for(int j=i+1;j<num.length-1;j++){
        		if(j!=i+1 && num[j-1]==num[j])	continue;
        		int tmp = searchInt(num, j+1, num.length-1, target-num[i]-num[j])+ num[i]+num[j];
        		if(result==null)	result = tmp;
        		else				result = Math.abs(target-result)>Math.abs(target-tmp) ? tmp : result;
        		}
        	}
        return result;
     }
        

    private static int searchInt(int[] num, int start, int end, int target){
    	if(start>end){
    		//return Math.abs(num[start]-target)>Math.abs(num[end]-target) ? num[end] : num[start];
    		if(start<num.length)	return num[start];
    		else					return num[end];
    	}
    	int mid = (start+end)/2;
    	if(num[mid]==target)	return target;
    	if(num[mid]>target)		return searchInt(num, start, mid-1, target);
    	else					return searchInt(num, mid+1, end, target);
    }
}