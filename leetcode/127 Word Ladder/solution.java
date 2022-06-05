public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) { // BFS���·�����⣻�Ż���˫��BFS���ٷ���𣡣���
        Set<String> hashRecord = new HashSet<>(wordList); // ��wordList�ŵ���ϣ�б��У�����
        if (!hashRecord.contains(endWord)) return 0;
        hashRecord.remove(beginWord); // �ӹ�ϣ�����Ƴ�beginWord������
        
        Deque<String> bfsQueue = new LinkedList<>(); // ��������BFS����Ķ��м��������飡����
        bfsQueue.addLast(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 0;
        while (!bfsQueue.isEmpty()) { // BFSѭ��������
            step++;
			int currentSize = bfsQueue.size();
            while (currentSize-- > 0) {
                String currentWord = bfsQueue.pollFirst();
                if (isFinalStep(currentWord, endWord, bfsQueue, visited, hashRecord)) {
                    return step+1; // ���currentWord�ܹ�ͨ���޸�1���ַ���endWord��ͬ����ΪBFS���һ��������step+1���ɣ�����
                }
            }
        }
        return 0;
    }

    private boolean isFinalStep(String word, String target, Deque<String> bfsQueue, Set<String> visited, Set<String> hashRecord) {
        char[] letters = word.toCharArray();
        char original = letters[0]; // ���ڱ���ԭ�ַ����Ա����޸ĺ�ָ�������
		for (int i=0; i<target.length(); i++) {
            original = letters[i];
            for (char modified = 'a'; modified <= 'z'; modified++) { // �����޸ĸ��ַ���25�ֿ��ܣ�������
                if (modified == original) continue;
                letters[i] = modified;
                String modifiedWord = String.valueOf(letters);
                if (hashRecord.contains(modifiedWord)) {
                    if (modifiedWord.equals(target)) { // case1��modifiedWord����endWord��BFS�����յ㣡����
                        return true;
                    } else if (!visited.contains(modifiedWord)) { // case2��modifiedWord������endWord���򽫸õ��ʼ�������Ա���BFS����һ����ʣ�������������ѷ��ʣ�����
                        bfsQueue.addLast(modifiedWord);
                        visited.add(modifiedWord);
                    }
                }
            }
            letters[i] = original; // �ָ�ԭ���ʣ�����
        }
        return false;
    }
}