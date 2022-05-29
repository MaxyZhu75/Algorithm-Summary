class Solution {
    List<String> result = new ArrayList<>();
    int[] segments = new int[4];

    public List<String> restoreIpAddresses(String s) {
        dfsBacktracking(s, 0, 0);
        return result;
    }

    public void dfsBacktracking(String s, int segCount, int segStart) {
        if (segCount == 4) { // 出口；需要填满4段IP地址并且刚好遍历完字符串！！！
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<4; i++) {
                    sb.append(segments[i]);
                    if (i != 3) sb.append('.');
                }
                result.add(sb.toString());
            }
            return;
        }

        if (segStart == s.length()) return; // 还没有找到4段IP地址就已经遍历完字符串，则直接return！！！

        if (s.charAt(segStart) == '0') { // 如果当前数字为0，那么这一段IP地址只能为0（不能含有前导零）！！！
            segments[segCount] = 0;
            dfsBacktracking(s, segCount+1, segStart+1); // 递归传入segCount+1与segStart+1，而不是变量本身+1！！！
        }

        int num = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) { // 一般情况，若num介于(0, 255]，则枚举每一种可能性并递归！！！
            num = 10*num + (s.charAt(segEnd) - '0');
            if (num > 0 && num <= 255) {
                segments[segCount] = num; // for循环内不同的segEnd会使新的segments[segCount]覆盖掉原来的数值！！！
                dfsBacktracking(s, segCount+1, segEnd+1);
            } else {
                break;
            }
        }
    }
}