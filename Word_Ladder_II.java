public class Solution {

		private static int minD;
		private static HashMap<String, Boolean> map;
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
 			ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
 			if(start==null || end==null || dict==null){
 				return results;
 			}       
 			dict.add(start);
 			dict.add(end);
 			map = new HashMap<String, Boolean>();
 			for(String s : dict){
 				map.put(s, false);
 			}

 			minD = Integer.MAX_VALUE;
 			int distance = 1;
 			LinkedList<String> queue = new LinkedList<String>();
 			ArrayList<String> path = new ArrayList<String>();
 			path.add(start);
 			queue.offer(start);
 			map.set(start) = true;

 			laddersHelper(distance, end, queue, path, results);
 			return results;
    }
    private void laddersHelper(int dis, String end, LinkedList<String> queue, 
    	ArrayList<String> path, ArrayList<ArrayList<String>> results){
    	if(dis>minD || queue.size()==0){
    		return;
    	}
    	while(queue.size()!=0){
    		LinkedList<String> newQueue = new LinkedList<String>();
    		String str = queue.poll();
    		path.add(str);

    		if(str.equals(end)){
    			if(dis<minD){
    				minD = dis;
    				results.clear();
    			}
    			results.add(path);

    			path.remove(path.size()-1);
    			return;
    		}

    		char[] charArray = str.toCharArray();
    		for(int i=0;i<str.length();i++){
    			char oldChar = charArray[i];
    			for(char c='a';c<='z';c++){
    				if(c==oldChar){
    					continue;
    				}
    				charArray[i] = c;
    				String newString = String.valueOf(charArray);
    				if(map.containsKey(newString) && !map.get(newString)){
    					newQueue.offer(newString)
    				}
    			}
    			charArray[i] = oldChar;
    		}
    		if(newQueue.size()!=0){
    			map.set(str) = true;
    			laddersHelper(dis+1, end, newQueue, path, results);
    			map.set(str) = false;
    		}

    		path.remove(path.size()-1);
    	}
    }
}