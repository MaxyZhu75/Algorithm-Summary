class Solution {
    public List<List<String>> groupAnagrams(String[] strs) { // 哈希表+排序！！！
        Map<String, List<String>> hashRecord = new HashMap<>(); // 存储方式为(排序后的str，原str列表)！！！
        for (String str : strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String key = new String(letters);
            if (!hashRecord.containsKey(key)) {
                hashRecord.put(key, new ArrayList<String>());
            }
            hashRecord.get(key).add(str);
        }
        return new ArrayList<List<String>>(hashRecord.values());
    }
}