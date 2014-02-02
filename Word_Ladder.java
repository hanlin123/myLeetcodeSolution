// BFS is better than the DFS, since BFS only visit each word once at most
// the graph can be simulated --> not all the distances needed to be calculated
// don't use diff to find the one distance -> O(N^2)
// instead, change letters of each position and check dict.contains() --> 26*L*N

public class Solution {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		if(dict==null || start==null || end==null){
			return 0;
		}
		if(start.equals(end)){
			return 0;
		}
		
    dict.add(start);
		dict.add(end);
	    // BFS
	    LinkedList<String> queue = new LinkedList<String>();
	    queue.offer(start);
		int distance = 1;
	    while(queue.size()!=0){
	    	LinkedList<String> nextQueue = new LinkedList<String>();
	    	while(queue.size()!=0){
	    		String str = queue.poll();
	    		if(!dict.contains(str)){
	    		    continue;
	    		}
	    		dict.remove(str);
	    		if(str.equals(end)){
	    			return distance;
	    		}
	    		char[] strchar = str.toCharArray();
	    		for(int i=0;i<strchar.length;i++){
	    		    char oldchar = strchar[i];
	    		    for(char c='a';c<='z';c++){
	    		        if(c==oldchar){
	    		            continue;
	    		        }
	    		        strchar[i] = c;
	    		        String newStr = String.valueOf(strchar);
	    		        if(dict.contains(newStr)){
	    		            nextQueue.offer(newStr);
	    		        }
	    		    }
	    		    strchar[i] = oldchar;
	    		}
	    	}
	    	distance += 1;
	    	queue = nextQueue;
	  	}
	  	// cannot find the target
	  	return 0;
	}
	
}