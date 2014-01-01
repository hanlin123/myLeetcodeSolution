public class Solution {
    public int removeElement(int[] A, int elem) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int a : A){
            if(a!=elem) array.add(a);
        }
        int i=0;
        for(int a : array){
            A[i]=a;
            i++;
        }
        return i;
    }
}