class Solution {
    List<String> result = new ArrayList<>(); 
    StringBuilder sb = new StringBuilder();
    String[] dictionary = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; // 字典映射！！！
	String digits;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        if (digits.length() == 0) return result;
        dfsBackTrack(0);
        return result;
    }

    public void dfsBackTrack(int start) { // 求的是组合！！！
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i=start; i<digits.length(); i++) {
            String letters = dictionary[digits.charAt(i)-'0'];
            for (char letter : letters.toCharArray()) {
                sb.append(letter);
                dfsBackTrack(i+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
