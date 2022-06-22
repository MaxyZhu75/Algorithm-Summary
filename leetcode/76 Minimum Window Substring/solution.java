class Solution {
    public String minWindow(String s, String t) { // 「优化版滑动窗口」处理最小子串长度问题！！！
        Map<Character, Integer> hashRecordT = new HashMap<>();
        for (int i=0; i<t.length(); i++) { //「hashRecordT」统计t中目标字母的个数！！！
            hashRecordT.put(t.charAt(i), hashRecordT.getOrDefault(t.charAt(i), 0)+1);
        }

        List<Pair<Integer, Character>> filteredS = new ArrayList<>(); // 列表「filteredS」仅存储t中出现的字母在s中的索引！！！
        for (int i=0; i<s.length(); i++) {
            char letter = s.charAt(i);
            if (hashRecordT.containsKey(letter)) {
                filteredS.add(new Pair<Integer, Character>(i, letter));
            }
        }

        int left = 0, right = 0, formed = 0; // filteredS中滑动窗口的左右边界（不是在原字符串s中滑动）；formed表示当前窗口已达标的字母个数！！！
        Map<Character, Integer> window = new HashMap<>(); //「window」存储当前窗口各字母的个数！！！
        int[] result = {-1, 0, 0}; // result[0]符合条件的存储最小子串长度，初始化为-1；result[1]和result[2]存储左右边界在原字符串s中的位置！！！

        while (right < filteredS.size()) { // 在filteredS中滑动！！！
            char letter = filteredS.get(right).getValue(); // 右边新来的字母！！！
            int count = window.getOrDefault(letter, 0) + 1;
            window.put(letter, count);
            if (window.get(letter).intValue() == hashRecordT.get(letter).intValue()) { // 统计新来的字母在窗口中的个数，检查该字母是否达标！！！
                formed++;
            }

            while (left <= right && formed == hashRecordT.size()) { // 当且仅当全部字母达标才进入该循环！！！
                letter = filteredS.get(left).getValue(); // 左边待处理的字母！！！
                int endS = filteredS.get(right).getKey();
                int startS = filteredS.get(left).getKey();
                if (result[0] == -1 || endS-startS+1 < result[0]) { // 判断是否需要更新结果！！！
                    result[0] = endS-startS+1;
                    result[1] = startS;
                    result[2] = endS;
                }
				
                window.put(letter, window.get(letter)-1); // 尝试「收缩左边界」！！！
                if (window.get(letter).intValue() < hashRecordT.get(letter).intValue()) {
                    formed--;
                }
                left++;
            }
			
            right++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2]+1); // 注意substring()对右边界的定义（需要+1操作）！！！
    }
}