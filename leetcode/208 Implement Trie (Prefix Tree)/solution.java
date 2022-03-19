class Trie { // Trie�ֵ����ٷ����ṹ������
    private Trie[] children;
    private boolean isEnd;

    public Trie() { // Trie���캯��������
        children = new Trie[26]; // �����ӽڵ�����Ϊ26��Сд��ĸ������
        isEnd = false; // ��ʾ�Ƿ�Ϊ�ַ����Ľ�β������
    }
    
    public void insert(String word) { // ����һ�������ַ���������
        Trie node = this;
        for (int i=0; i<word.length(); i++) {
            char letter = word.charAt(i);
            int index = letter - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie(); // ��Ϊ�գ���û�и�·���������½ڵ㣡���� 
            }
            node = node.children[index]; // ��Ȼ������Ǳ������
        }
        node.isEnd = true; // ������������isEndΪtrue������
    }
    
    private Trie searchPrefix(String prefix) { // ������������ǰ׺������
        Trie node = this;
        for (int i=0; i<prefix.length(); i++) {
            char letter = prefix.charAt(i);
            int index = letter - 'a';
            if (node.children[index] == null) { // case1����Ϊ�գ���û�и�·����ֱ�ӷ���null������
                return null;
            } else {
                node = node.children[index]; // case2��·�����ڣ�������Ǳ������
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