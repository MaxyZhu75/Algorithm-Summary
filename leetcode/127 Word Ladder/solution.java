public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) { // BFS最短路径问题；优化版双向BFS见官方解答！！！
        Set<String> hashRecord = new HashSet<>(wordList); // 将wordList放到哈希列表中！！！
        if (!hashRecord.contains(endWord)) return 0;
        hashRecord.remove(beginWord); // 从哈希表中移除beginWord！！！
        
        Deque<String> bfsQueue = new LinkedList<>(); // 创建常规BFS所需的队列及访问数组！！！
        bfsQueue.addLast(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 0;
        while (!bfsQueue.isEmpty()) { // BFS循环！！！
            step++;
			int currentSize = bfsQueue.size();
            while (currentSize-- > 0) {
                String currentWord = bfsQueue.pollFirst();
                if (isFinalStep(currentWord, endWord, bfsQueue, visited, hashRecord)) {
                    return step+1; // 如果currentWord能够通过修改1个字符与endWord相同，则为BFS最后一步，返回step+1即可！！！
                }
            }
        }
        return 0;
    }

    private boolean isFinalStep(String word, String target, Deque<String> bfsQueue, Set<String> visited, Set<String> hashRecord) {
        char[] letters = word.toCharArray();
        char original = letters[0]; // 用于保存原字符，以便于修改后恢复！！！
		for (int i=0; i<target.length(); i++) {
            original = letters[i];
            for (char modified = 'a'; modified <= 'z'; modified++) { // 尝试修改该字符（25种可能）！！！
                if (modified == original) continue;
                letters[i] = modified;
                String modifiedWord = String.valueOf(letters);
                if (hashRecord.contains(modifiedWord)) {
                    if (modifiedWord.equals(target)) { // case1：modifiedWord等于endWord，BFS到达终点！！！
                        return true;
                    } else if (!visited.contains(modifiedWord)) { // case2：modifiedWord不等于endWord，则将该单词加入队列以便于BFS的下一层访问，并且立即标记已访问！！！
                        bfsQueue.addLast(modifiedWord);
                        visited.add(modifiedWord);
                    }
                }
            }
            letters[i] = original; // 恢复原单词！！！
        }
        return false;
    }
}