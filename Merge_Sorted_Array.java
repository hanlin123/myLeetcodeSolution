public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int index = A.length-1;
        int indexA = m -1;
        int indexB = n-1;
        
        while(indexB>-1 && indexA>-1){
            if(A[indexA]>B[indexB]){
                A[index] = A[indexA--];
            }else{
                A[index] = B[indexB--];
            }
            index--;
        }
        while(indexA>-1)	A[index--] = A[indexA--];
        while(indexB>-1)	A[index--] = B[indexB--];
        
        if(index>-1){
            System.arraycopy(A, index+1, A, 0, m+n);
        }
    }
}