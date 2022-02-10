class Solution { // 回溯经典题目，回溯属于DFS问题，需要统计排列组合的各种情况时可用回溯解决！！！
    List<String> result = new ArrayList<>(); 
    StringBuilder sb = new StringBuilder(); // 要点一：可将结果变量等提前声明！！！
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        dfsBackTrack(digits);
        return result;
    }

    public void dfsBackTrack(String digits) { // 无返回值，直接对定义的结果变量操作！！！
        if (sb.length() == digits.length()) { // 递归左右出口！！！
            result.add(sb.toString());
            return;
        }
        
        int position = sb.length(); // 最后删除末尾字母时不能用position变量来表示sb.length()，因为递归后的变量含义已经不一样，这一点要小心！！！
        int currentDigit = digits.charAt(position) - '0';
        String currentLetters = letters[currentDigit];
        for (char letter : currentLetters.toCharArray()) { // 要点二：DFS移动过程中包括三个重要处理步骤，且必须按顺序执行！！！
            sb.append(letter); // 处理一：标记已访问；本题主要由sb.length()控制，添加字母后sb长度改变，相当于标记访问！！！
            dfsBackTrack(digits); // 处理二：dfs往下递归！！！
            sb.deleteCharAt(sb.length()-1); // 处理三：标记未访问；本题主要由sb.length()控制，删除最后一个字母后sb长度改变，相当于标记未访问！！！
        }
    }
}