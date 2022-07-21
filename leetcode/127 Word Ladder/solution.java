public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) { // BFS！！！
        Set<String> hashRecord = new HashSet<>(wordList);
        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.offer(beginWord);
        int step = 1;
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            while (size-- > 0) {
                String current = bfsQueue.poll();
                for (int i=0; i<endWord.length(); i++) {
                    for (char letter='a'; letter<='z'; letter++) {
                        StringBuilder sb = new StringBuilder(current);
                        sb.setCharAt(i, letter); // 每个位置尝试替换不同单词！！！
                        if (hashRecord.contains(sb.toString())) {
                            if (sb.toString().equals(endWord)) {
				return step+1;	
	  	            }
                            hashRecord.remove(sb.toString()); // 从HashSet中移除当前newWord！！！
                            bfsQueue.offer(sb.toString()); // bfs队列入队当前newWord！！！
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
