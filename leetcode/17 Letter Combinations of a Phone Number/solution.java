class Solution { // ���ݾ�����Ŀ����������DFS���⣬��Ҫͳ��������ϵĸ������ʱ���û��ݽ��������
    List<String> result = new ArrayList<>(); 
    StringBuilder sb = new StringBuilder(); // Ҫ��һ���ɽ������������ǰ����������
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        dfsBackTrack(digits);
        return result;
    }

    public void dfsBackTrack(String digits) { // �޷���ֵ��ֱ�ӶԶ���Ľ����������������
        if (sb.length() == digits.length()) { // �ݹ����ҳ��ڣ�����
            result.add(sb.toString());
            return;
        }
        
        int position = sb.length(); // ���ɾ��ĩβ��ĸʱ������position��������ʾsb.length()����Ϊ�ݹ��ı��������Ѿ���һ������һ��ҪС�ģ�����
        int currentDigit = digits.charAt(position) - '0';
        String currentLetters = letters[currentDigit];
        for (char letter : currentLetters.toCharArray()) { // Ҫ�����DFS�ƶ������а���������Ҫ�����裬�ұ��밴˳��ִ�У�����
            sb.append(letter); // ����һ������ѷ��ʣ�������Ҫ��sb.length()���ƣ������ĸ��sb���ȸı䣬�൱�ڱ�Ƿ��ʣ�����
            dfsBackTrack(digits); // �������dfs���µݹ飡����
            sb.deleteCharAt(sb.length()-1); // �����������δ���ʣ�������Ҫ��sb.length()���ƣ�ɾ�����һ����ĸ��sb���ȸı䣬�൱�ڱ��δ���ʣ�����
        }
    }
}