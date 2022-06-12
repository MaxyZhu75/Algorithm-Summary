class Solution {
    public List<String> removeInvalidParentheses(String s) { // BFS������ʵ�֣�����
        List<String> result = new ArrayList<>();
        Set<String> currentLevel = new HashSet<>(); // ��¼BFS��ǰlevel��������ַ�����ʹ��Setȥ�����Ч�ʣ�����
        currentLevel.add(s);

        while (true) {
            for (String str : currentLevel) {
                if (isValid(str)) {
                    result.add(str);
                }
            }
            if (result.size() > 0) { // ������Ŀ����С���Ĵ�����BFS������Ч����ֱ��return������
                return result;
            }
            Set<String> nextLevel = new HashSet<>(); // ��¼BFS��һlevel��������ַ�����ʹ��Setȥ�����Ч�ʣ�����
            for (String str : currentLevel) {
                for (int i=0; i<str.length(); i++) {
                    if (i>0 && str.charAt(i) == str.charAt(i-1)) {
                        continue; // ��֦������������ͬ������ֻ��Ҫ����һ�μ��ɣ��統ǰ�������ַ���Ϊ"(((())"��ȥ��ǰ�ĸ��������е�����һ�������ɵ��ַ�����ͬ������
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') { // ���ַ�Ϊ���ţ����Ƴ��ַ�str[i]�������һ��BFS����������
                        nextLevel.add(str.substring(0, i) + str.substring(i+1));
                    }
                }
            }
            currentLevel = nextLevel;
        }
    }

    public boolean isValid(String str) { // һ�α�������ַ����������Ƿ���Ч������
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