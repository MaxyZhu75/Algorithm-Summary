class Trie { // 字典树标准写法见LeetCode208题！！！
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}

class Solution {
    
	Trie trie;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        this.trie = new Trie();
		List<String> result = new ArrayList<>();
        
		Arrays.sort(words, new Comparator<String>() { // 将words按字符串的长度递增排序，从而确保当遍历到任意单词时，比该单词短的单词一定都已经遍历过！！！
			@Override
			public int compare(String s1, String s2) {
				return s1.length()-s2.length();
			}
		});
        
		for (int i=0; i<words.length; i++) {
            if (words[i].length() == 0) continue;
            boolean[] visited = new boolean[words[i].length()];
            if (dfs(words[i], 0, visited)) {
                result.add(words[i]); // case1：是连接词，则加入结果，但不需要加入字典树！！！
            } else {
                insert(words[i]); // case2：不是连接词，加入字典树！！！
            }
        }
        return result;
    }

    public void insert(String word) { // 字典树插入标准写法！！！
        Trie node = trie;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean dfs(String word, int start, boolean[] visited) { // 通过dfs查询判断是否是连接词！！！
        if (word.length() == start) { // 查找到第二个较短单词的出口；注意原数组中单词不重复！！！
            return true;
        }
        if (visited[start]) { // 只有尚未访问过的下标才需要进行搜索；若下标已访问过，则可以直接返回false（若是连接词则在此之前就会返回true退出查找）！！！
            return false;
        }
        
		visited[start] = true;
        
		Trie node = trie; // 字典树查找前缀标准写法！！！
		for (int i=start; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            
			if (node.children[index] == null) {
                return false;
            } else {
                node = node.children[index];
            }
            
			if (node.isEnd) { // 已找到第一个较短单词，若还能查找到第二个较短单词，则直接返回true！！！
                if (dfs(word, i+1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}