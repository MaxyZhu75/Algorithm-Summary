class Trie { // Trie字典树官方题解结构！！！
    private Trie[] children;
    private boolean isEnd;

    public Trie() { // Trie构造函数！！！
        children = new Trie[26]; // 本题子节点数组为26个小写字母！！！
        isEnd = false; // 表示是否为字符串的结尾！！！
    }
    
    public void insert(String word) { // 方法一：插入字符串！！！
        Trie node = this;
        for (int i=0; i<word.length(); i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie(); // 若为空，则没有该路径，创建新节点！！！ 
            }
            node = node.children[index]; // 必然继续下潜！！！
        }
        node.isEnd = true; // 遍历结束后，置isEnd为true！！！
    }
    
    private Trie searchPrefix(String prefix) { // 方法二：查找前缀！！！
        Trie node = this;
        for (int i=0; i<prefix.length(); i++) {
            char letter = prefix.charAt(i);
            int index = letter - 'a';
            if (node.children[index] == null) { // case1：若为空，则没有该路径，直接返回null！！！
                return null;
            } else {
                node = node.children[index]; // case2：路径存在，继续下潜！！！
            }
        }
        return node;
    }
	
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */