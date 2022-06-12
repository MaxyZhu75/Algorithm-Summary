class Solution {
    public List<String> removeInvalidParentheses(String s) { // BFS的特殊实现！！！
        List<String> result = new ArrayList<>();
        Set<String> currentLevel = new HashSet<>(); // 记录BFS当前level所需检查的字符串，使用Set去重提高效率！！！
        currentLevel.add(s);

        while (true) {
            for (String str : currentLevel) {
                if (isValid(str)) {
                    result.add(str);
                }
            }
            if (result.size() > 0) { // 由于题目求最小更改次数，BFS遇到有效答案则直接return！！！
                return result;
            }
            Set<String> nextLevel = new HashSet<>(); // 记录BFS下一level所需检查的字符串，使用Set去重提高效率！！！
            for (String str : currentLevel) {
                for (int i=0; i<str.length(); i++) {
                    if (i>0 && str.charAt(i) == str.charAt(i-1)) {
                        continue; // 剪枝：遇到连续相同的括号只需要搜索一次即可；如当前遇到的字符串为"(((())"，去掉前四个左括号中的任意一个，生成的字符串相同！！！
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') { // 若字符为括号，则移除字符str[i]后加入下一层BFS遍历！！！
                        nextLevel.add(str.substring(0, i) + str.substring(i+1));
                    }
                }
            }
            currentLevel = nextLevel;
        }
    }

    public boolean isValid(String str) { // 一次遍历检查字符串内括号是否有效！！！
        char[] letters = str.toCharArray();
        int count = 0;
        for (char letter : letters) {
            if (letter == '(') {
                count++;
            } else if (letter == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}