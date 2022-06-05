class Trie { // �ֵ�����׼д����LeetCode208�⣡����
    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}

class Solution {
	
    Trie trie;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        this.trie = new Trie();
		List<List<String>> result = new ArrayList<>();
        for (String product : products) { // �Ƚ���Ʒ���ʼ����ֵ���������
            insert(product);
        }

        String prefix = new String();
        for (char letter : searchWord.toCharArray()) { // ����ĿҪ���ɲ��Ҵ����β�����ͬprefix�����Ƽ��㷨������
            prefix += letter;
            result.add(suggest(prefix));
        }
        return result;
    }

    public void insert(String word) { // �ֵ��������׼д��������
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

    public List<String> suggest(String prefix) { // ��ǰ׺·�����ֵ�������Ǳ��Ȼ�����DFS�ݹ���ӽ��������
        Trie node = trie;
        List<String> result = new ArrayList<>();
        for (int i=0; i<prefix.length(); i++) { // �ֵ�������ǰ׺��׼д��������
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return result;
            } else {
                node = node.children[index];
            }
        }
        dfsPrefix(node, prefix, result); // ����DFS�ݹ飡����
        return result;
    }

    public void dfsPrefix(Trie node, String word, List<String> result) { // ���ֵ���DFS�ݹ���ӽ��������
        if (result.size() == 3) return;
        if (node.isEnd == true) {
            result.add(word);
        }
        for (char letter = 'a'; letter <= 'z'; letter++) {
            if (node.children[letter-'a'] != null) {
                dfsPrefix(node.children[letter-'a'], word+letter, result);
            }
        }
    }
}