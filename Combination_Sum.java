/* 
* Given a set of candidate numbers (C) and a target number (T), 
* find all unique combinations in C where the candidate numbers sums to T.
* The same repeated number may be chosen from C unlimited number of times.
*
* Note:
*	- All numbers (including target) will be positive integers.
*	- Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
*	- The solution set must not contain duplicate combinations.
*
* For example, given candidate set 2,3,6,7 and target 7, 
* A solution set is: 
* [7]
*	[2,2,3]
*/

public class Solution {
		public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(candidates==null || candidates.length==0)	return results;

        ArrayList<Integer> array = new ArrayList<Integer>();
        Arrays.sort(candidates);
        recursiveCheck(candidates, target, 0,array, results);
        return results;
    }
    private static void recursiveCheck(int[] candidates, int target, int pos, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> results){
    	for(int i=pos;i<candidates.length;i++){
    		int sub = target - candidates[i];
    		if(sub==0){
    			ArrayList<Integer> copy = arrayCopy(array);
    			copy.add(candidates[i]);
    			copy = sortArray(copy);
    			if(!results.contains(copy))
    				results.add(copy);
    		}else if(sub<0){
    			break;
    		}else{
    			ArrayList<Integer> copy = arrayCopy(array);
    			copy.add(candidates[i]);
    			recursiveCheck(candidates, sub, i,copy, results);
    		}
    	}
    }
    private static ArrayList<Integer> arrayCopy(ArrayList<Integer> src){
    	ArrayList<Integer> copy = new ArrayList<Integer>();
    	for(int i : src)	copy.add(i);
    	return copy;
    }
    private static ArrayList<Integer> sortArray(ArrayList<Integer> src){
    	Integer[] array = src.toArray(new Integer[src.size()]);
    	Arrays.sort(array);
    	ArrayList<Integer> newArray = new ArrayList<Integer>();
    	for(int i : array)	newArray.add(i);
    	return newArray;
    }
}