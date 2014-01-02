public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Element[] array = new Element[numbers.length];
        int ii=0;
        for(int n : numbers){
            array[ii] = new Element(ii+1,n);
            ii++;
        }
        Arrays.sort(array);
        
        int[] result = null;
        for(int i=0;i<array.length;i++){
            if(array[i].val>target)    break;
            for(int j=i+1;j<array.length;j++){
                int sum = array[i].val+array[j].val;
                if(sum==target){
                    result = new int[2];
                    result[0] = array[i].index < array[j].index ? array[i].index : array[j].index;
                    result[1] = result[0] == array[i].index ? array[j].index : array[i].index;
                }
                if(sum>target) break;
            }
        }
        return result;
    }
    
    public class Element implements Comparable{
        int index;
        int val;
        public Element(int _index, int _val){
            index = _index;
            val = _val;
        }
        
        public int compareTo(Object o){
            return this.val - ((Element)o).val;
        }
    }
}