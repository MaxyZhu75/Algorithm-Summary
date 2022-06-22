class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> current = new ArrayList<String>();
	
	public List<List<String>> partition(String s) { // dfs回溯 + 判断回文串！！！
        dfs(0, s);
        return result;
    }

    public void dfs(int start, String s) {
        if (start == s.length()) { // 出口：start到达末尾，说明此前切分均是回文！！！
			result.add(new ArrayList<>(current));
		}
        for (int end = start; end < s.length(); end++) { // 由当前start往后遍历不同end！！！
            if (isPalindrome(s, start, end)) { // for循环内回溯！！！
                current.add(s.substring(start, end+1));
                dfs(end+1, s);
                current.remove(current.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high) { // 判断回文串写法！！！
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
				return false;	
			}
        }
        return true;
    }
}