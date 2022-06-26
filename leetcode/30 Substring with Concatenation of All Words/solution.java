class Solution {
    public List<Integer> findSubstring(String s, String[] words) { // 滑动窗口 + 哈希表！！！
        List<Integer> result = new ArrayList<>();
        int m = words.length, n = words[0].length();
        for (int i=0; i<n; i++) { // 细节：由于滑动距离为「n」则最外层循环需要遍历窗口起点「0到n-1」！！！
            if (i+m*n > s.length()) {
                break;
            }
            Map<String, Integer> hashRecord = new HashMap<>();
            for (int j=0; j<m; j++) { // 统计大小为「m*n」的滑动窗口内「s」中长度为n的各单词数量！！！
                String word = s.substring(i+j*n, i+(j+1)*n);
                hashRecord.put(word, hashRecord.getOrDefault(word, 0) + 1);
            }
            for (String word : words) { // 根据「words」统计当前窗口「多哪些少哪些」！！！
                hashRecord.put(word, hashRecord.getOrDefault(word, 0) - 1);
                if (hashRecord.get(word) == 0) {
                    hashRecord.remove(word); // 细节：刚好抵消为0时，键值对需要remove！！！
                }
            }
            for (int start = i; start < s.length()-m*n+1; start += n) { // 滑动大小为「m*n」的窗口，每次滑动的距离为「n」！！！
                if (start != i) {
                    String word = s.substring(start+(m-1)*n, start+m*n); // 右边新来的单词进入窗口！！！
                    hashRecord.put(word, hashRecord.getOrDefault(word, 0) + 1);
                    if (hashRecord.get(word) == 0) {
                        hashRecord.remove(word);
                    }
                    word = s.substring(start-n, start); // 左边单词退出窗口！！！
                    hashRecord.put(word, hashRecord.getOrDefault(word, 0) - 1);
                    if (hashRecord.get(word) == 0) {
                        hashRecord.remove(word);
                    }
                }
                if (hashRecord.isEmpty()) { // 全部单词刚好抵消被remove，哈希表则为空！！！
                    result.add(start);
                }
            }
        }
        return result;
    }
}