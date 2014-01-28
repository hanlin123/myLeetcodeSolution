public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(n==0 || k==0 || n<k){
            return results;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        combineHelper(n, k, 1, path, results);
        return results;
    }
    private void combineHelper(int n, int k, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> results){
        for(int i=start;i<=n-k+1;i++){
            path.add(i);
            if(k==1){
                results.add(new ArrayList<Integer>(path));
            }else{
                combineHelper(n, k-1, i+1, path, results);
            }
            path.remove(path.size()-1);
        }
        return;
    }
}