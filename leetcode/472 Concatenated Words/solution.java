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

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        this.trie = new Trie();
		List<String> result = new ArrayList<>();
        
		Arrays.sort(words, new Comparator<String>() { // ��words���ַ����ĳ��ȵ������򣬴Ӷ�ȷ�������������ⵥ��ʱ���ȸõ��ʶ̵ĵ���һ�����Ѿ�������������
			@Override
			public int compare(String s1, String s2) {
				return s1.length()-s2.length();
			}
		});
        
		for (int i=0; i<words.length; i++) {
            if (words[i].length() == 0) continue;
            boolean[] visited = new boolean[words[i].length()];
            if (dfs(words[i], 0, visited)) {
                result.add(words[i]); // case1�������Ӵʣ����������������Ҫ�����ֵ���������
            } else {
                insert(words[i]); // case2���������Ӵʣ������ֵ���������
            }
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

    public boolean dfs(String word, int start, boolean[] visited) { // ͨ��dfs��ѯ�ж��Ƿ������Ӵʣ�����
        if (word.length() == start) { // ���ҵ��ڶ����϶̵��ʵĳ��ڣ�ע��ԭ�����е��ʲ��ظ�������
            return true;
        }
        if (visited[start]) { // ֻ����δ���ʹ����±����Ҫ�������������±��ѷ��ʹ��������ֱ�ӷ���false���������Ӵ����ڴ�֮ǰ�ͻ᷵��true�˳����ң�������
            return false;
        }
        
		visited[start] = true;
        
		Trie node = trie; // �ֵ�������ǰ׺��׼д��������
		for (int i=start; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            
			if (node.children[index] == null) {
                return false;
            } else {
                node = node.children[index];
            }
            
			if (node.isEnd) { // ���ҵ���һ���϶̵��ʣ������ܲ��ҵ��ڶ����϶̵��ʣ���ֱ�ӷ���true������
                if (dfs(word, i+1, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}