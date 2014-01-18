/*
 * Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? Find all unique triplets in the array which gives the sum of zero
 *
 * - Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * - The solution set must not contain duplicate triplets
 *
 * given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length<3)   return results;
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            if(i!=0 && num[i]==num[i-1])    continue;
            if(num[i]>0)    break;
            for(int j=i+1;j<num.length-1;j++){
                if(j!=i+1 && num[j]==num[j-1])  continue;
                int add = num[i]+num[j];
                if(add>0)   break;
                int target = searchInt(num, j+1, num.length-1, 0-add);
                if(target>=0){
                    ArrayList<Integer> array = new ArrayList<Integer>();
                    array.add(num[i]);
                    array.add(num[j]);
                    array.add(target);
                    results.add(array);
                }
            }
        }
        return results;
    }
    private static int searchInt(int[] num, int start, int end, int target){
        if(start>end)   return -1;
        int mid = (start+end)/2;
        if(num[mid]==target)   return target;
        if(num[mid]<target)    return searchInt(num, mid+1, end, target);
        else                   return searchInt(num, start, mid-1, target);
    }   
} 