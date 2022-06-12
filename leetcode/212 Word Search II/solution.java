class Trie { // �ֵ������Σ���Ҫ���word�ֶα��浱ǰ·������ĵ��ʣ�����
    Trie[] children;
    boolean isEnd;
	String word;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
		word = "";
    }
}

class Solution { // ���� + �ֵ��� ������
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	char[][] board;
	Set<String> result;
	Trie trie;
	
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
		this.result = new HashSet<String>(); // ע���ȶ���ΪSetʹ���ȥ�أ�����ʱ��תΪList������
        this.trie = new Trie();
        for (String word : words) { // ���ֵ����������е��ʣ�����
            insert(word);
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                dfsBackTracking(i, j, trie); // ��ÿ����Ϊ������DFS���ݣ�����
            }
        }

        return new ArrayList<String>(result);
    }
	
	public void insert(String word) { // �ֵ������룡����
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
		if (index < 0 || node.children[index] == null) { // indexС��0����Ϊ����ѷ��ʵ�#�ţ����ֵ����ɴ�·��û�е�ǰ��ĸ����ֱ��return������
            return;
        }

        char original = board[i][j];
        node = node.children[index]; // ���ֵ���·���ߵ���ǰ�ڵ㣡����
        if (node.isEnd) {
            result.add(node.word); // ���ǵ���ĩβ����ǰDFS�ܹ���������һ�����ʣ���������Set������
        }

        board[i][j] = '#'; // ��Ϊ�ѷ��ʵı�ǣ�����
        for (int[] direction : directions) {
            int nextRow = i + direction[0];
			int nextColum = j + direction[1];
            if (nextRow >= 0 && nextRow < board.length && nextColum >= 0 && nextColum < board[0].length) {
                dfsBackTracking(nextRow, nextColum, node);
            }
        }
        board[i][j] = original; // ���ݣ�����
    }
}