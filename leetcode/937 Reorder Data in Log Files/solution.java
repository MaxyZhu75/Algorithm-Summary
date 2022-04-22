class Solution {
    public String[] reorderLogFiles(String[] logs) { // 重写数组排序方法！！！
        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String[] log1 = o1.split(" ", 2); // 以（首个）空格为分隔符，仅分为两部分！！！
                String[] log2 = o2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(log1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(log2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int cmp = log1[1].compareTo(log2[1]); // 按字典顺序比较两个字符串；小于等于大于分别对应返回-1, 0, 1！！！
                    if (cmp != 0) {
                        return cmp;
                    } else {
                        return log1[0].compareTo(log2[0]);
                    }
                } else {
                    return isDigit1 ? (isDigit2 ? 0 : 1) : -1; // 在Java重写排序中，返回-1表示不交换顺序，0表示相同时不交换，1表示交换！！！
                }
            }
        });
        return logs;
    }
}