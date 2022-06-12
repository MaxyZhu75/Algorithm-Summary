class Trie { // 字典树变形，需要多加word字段保存当前路径代表的单词！！！
    Trie[] children;
    boolean isEnd;
	String word;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
		word = "";
    }
}

class Solution { // 回溯 + 字典树 ！！！
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	char[][] board;
	Set<String> result;
	Trie trie;
	
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
		this.result = new HashSet<String>(); // 注意先定义为Set使结果去重，返回时再转为List！！！
        this.trie = new Trie();
        for (String word : words) { // 向字典树插入所有单词！！！
            insert(word);
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                dfsBackTracking(i, j, trie); // 以每个点为起点进行DFS回溯！！！
            }
        }

        return new ArrayList<String>(result);
    }
	
	public void insert(String word) { // 字典树插入！！！
        Trie node = trie;
        for (int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
		node.word = word;
    }

    public void dfsBackTracking(int i, int j, Trie node) {
        int index = (board[i][j] - 'a');
		if (index < 0 || node.children[index] == null) { // index小于0（即为标记已访问的#号）或字典树可达路径没有当前字母，则直接return！！！
            return;
        }

        char original = board[i][j];
        node = node.children[index]; // 沿字典树路径走到当前节点！！！
        if (node.isEnd) {
            result.add(node.word); // 若是单词末尾，则当前DFS能够完整遍历一个单词，添加至结果Set！！！
        }

        board[i][j] = '#'; // 作为已访问的标记！！！
        for (int[] direction : directions) {
            int nextRow = i + direction[0];
			int nextColum = j + direction[1];
            if (nextRow >= 0 && nextRow < board.length && nextColum >= 0 && nextColum < board[0].length) {
                dfsBackTracking(nextRow, nextColum, node);
            }
        }
        board[i][j] = original; // 回溯！！！
    }
}