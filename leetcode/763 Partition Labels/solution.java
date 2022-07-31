class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26]; // 存储各自母最后一次出现的下标！！！
        for (int i=0; i<s.length(); i++) {
            last[s.charAt(i)-'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0; // 动态更新当前段的开始和结束切割位置！！！
        for (int i=0; i<s.length(); i++) {
            end = Math.max(end, last[s.charAt(i)-'a']); // 每次检验切割点要不要后移！！！
            if (i == end) { // 切割操作！！！
                partition.add(end-start+1);
                start = end+1;
            }
        }
        return partition;
    }
}