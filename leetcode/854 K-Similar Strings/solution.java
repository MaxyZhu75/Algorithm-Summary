class Solution {
    public int kSimilarity(String A, String B) { // 非常规BFS，构造逻辑拓扑！！！
        Deque<String> bfsQueue = new LinkedList<>();
        bfsQueue.addLast(A);
        Set<String> visited = new HashSet<>();
        visited.add(A);
		int level = -1;
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            level++;
            while (size-- > 0) {
                String currentNode = bfsQueue.pollFirst();
                if (currentNode.equals(B)) {
                    return level;
                }
                for (String neighbour : getNeighbours(currentNode, B)) {
                    if (!visited.contains(neighbour)) {
                        bfsQueue.addLast(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
        }
        return -1;
    }
    
    private List<String> getNeighbours(String A, String B) { //「邻居」相当于在拓扑中，通过交换一个字符后能到达的结点！！！
        List<String> result = new ArrayList<>();
        char[] letters = A.toCharArray(); 
        
        int i = 0;
        while (i < letters.length) { // 每次找到「最左侧」满足 A[i]!=B[i] 的「i」！！！
            if (letters[i] != B.charAt(i)) {
                break;
            }
			i++;
        }
                
        for (int j=i+1; j<letters.length; j++) { // 并搜索满足 j>i 且 A[j]==B[i] 的「j」！！！
            if (letters[j] == B.charAt(i)) {
                swap(letters, i, j);
                result.add(new String(letters));
                swap(letters, i, j); // 需要复原方便找其他邻居！！！
            }
        }     
        
        return result; // 返回所有邻居！！！
    }
    
    private void swap(char[] letters, int i, int j) {
        
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
    }
}