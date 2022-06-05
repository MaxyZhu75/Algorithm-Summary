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

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        this.trie = new Trie();
		List<List<String>> result = new ArrayList<>();
        for (String product : products) { // 先将产品单词加入字典树！！！
            insert(product);
        }

        String prefix = new String();
        for (char letter : searchWord.toCharArray()) { // 按题目要求由查找词依次产生不同prefix调用推荐算法！！！
            prefix += letter;
            result.add(suggest(prefix));
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

    public List<String> suggest(String prefix) { // 按前缀路径在字典树中下潜，然后调用DFS递归添加结果！！！
        Trie node = trie;
        List<String> result = new ArrayList<>();
        for (int i=0; i<prefix.length(); i++) { // 字典树查找前缀标准写法！！！
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return result;
            } else {
                node = node.children[index];
            }
        }
        dfsPrefix(node, prefix, result); // 调用DFS递归！！！
        return result;
    }

    public void dfsPrefix(Trie node, String word, List<String> result) { // 按字典序DFS递归添加结果！！！
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