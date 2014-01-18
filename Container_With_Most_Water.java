/*
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 */

public class Solution {
    public static class Line implements Comparable<Line>{
        int index;
        int val;
        public Line(int _index, int _val){
            index = _index;
            val = _val;
        }
        @Override
        public int compareTo(Line l){
            return this.val - l.val;
        }
    }
    public int maxArea(int[] height) {
        Line[] elems = new Line[height.length];
        for(int i=0;i<height.length;i++)    
            elems[i] = new Line(i,height[i]);
        Arrays.sort(elems);
        
        int max=0;
        int size=elems.length;
        int minBound = 0;
        int maxBound = size-1;
            
        for(int i=0;i<size;i++){
            if(i>0 && elems[i-1].index==minBound)
                while(height[minBound]<0)   minBound++;
            if(i>0 && elems[i-1].index==maxBound)
                while(height[maxBound]<0)   maxBound--;
            int area = Math.max(elems[i].index-minBound, maxBound-elems[i].index)*elems[i].val;
            if(area>max)    max=area;
            height[elems[i].index] = -1;
        }
        return max;
    }
}