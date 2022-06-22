class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> current = new ArrayList<String>();
	
	public List<List<String>> partition(String s) { // dfs���� + �жϻ��Ĵ�������
        dfs(0, s);
        return result;
    }

    public void dfs(int start, String s) {
        if (start == s.length()) { // ���ڣ�start����ĩβ��˵����ǰ�з־��ǻ��ģ�����
			result.add(new ArrayList<>(current));
		}
        for (int end = start; end < s.length(); end++) { // �ɵ�ǰstart���������ͬend������
            if (isPalindrome(s, start, end)) { // forѭ���ڻ��ݣ�����
                current.add(s.substring(start, end+1));
                dfs(end+1, s);
                current.remove(current.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high) { // �жϻ��Ĵ�д��������
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
				return false;	
			}
        }
        return true;
    }
}