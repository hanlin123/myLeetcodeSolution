public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num==null || num.length==0){
        	return results;
        }
        
        Arrays.sort(num);
        ArrayList<Integer> path = new ArrayList<Integer>();
        results.add(path);
        subsetsHelper(num, 0, path, results);
        return results;
    }
    private void subsetsHelper(int[] num, int index, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> results){
    	if(index==num.length){
    		return;
    	}
    	for(int i=index; i<num.length; i++){
            if(i!=0 && i!=index && num[i]==num[i-1]){
                continue;
            }
    		path.add(num[i]);
    		results.add(new ArrayList<Integer>(path));
    		subsetsHelper(num, i+1, path, results);
    		path.remove(path.size()-1);
    	}
    	return;
    }
}