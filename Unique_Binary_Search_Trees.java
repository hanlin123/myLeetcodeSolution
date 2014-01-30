/*
 * conclude to DP problem.
 * count[i] is the number of trees with i nodes
 * count[0] = 1 --> empty tree
 * count[1] = 1 --> one-node tree
 * count[i] = sigma(count[0->k]*count[k->0]), where 0 <= k < i
 */

public class Solution {
    public int numTrees(int n) {
        if(n==0 || n==1){
            return 1;
        }
        
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        
        for(int i=2;i<=n;i++){
            int tmp = 0;
            for(int j=0; j<i; j++){
                tmp += cache[j]*cache[i-j-1];
            }
            cache[i] = tmp;
        }
        return cache[n];
    }
}