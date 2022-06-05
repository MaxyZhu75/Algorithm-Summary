class Solution {
    public List<String> removeComments(String[] source) { // 分情况处理！！！
        boolean inBlock = false;
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList();
        for (String line: source) {
            char[] letters = line.toCharArray();
            if (!inBlock) {
				sb = new StringBuilder(); // 读取每行代码时（非注释）要通过new重置sb！！！
			}
            int i = 0;
            while (i < line.length()) {
                if (!inBlock && i+1 < line.length() && letters[i] == '/' && letters[i+1] == '*') {
                    inBlock = true; // case1：不在注释中且遇到/*，则跳过接下来的两个字符，并将状态更改为在注释中！！！
                    i++;
                } else if (inBlock && i+1 < line.length() && letters[i] == '*' && letters[i+1] == '/') {
                    inBlock = false; // case2：在注释中且遇到*/，则跳过接下来的两个字符，并将状态更改为不在注释中！！！
                    i++;
                } else if (!inBlock && i+1 < line.length() && letters[i] == '/' && letters[i+1] == '/') {
                    break; // case3：不在注释中且遇到//，根据优先级则忽略该行的其余部分直接break！！！
                } else if (!inBlock) {
                    sb.append(letters[i]); // case4：有效代码，需要记录！！！
                }
                i++;
            }
            if (!inBlock && sb.length() > 0) { // 该行记录结束，判断是否需要添加到结果！！！
                result.add(new String(sb));
            }
        }
        return result;
    }
}