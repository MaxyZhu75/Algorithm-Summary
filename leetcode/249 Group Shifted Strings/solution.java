class Solution {
    public List<List<String>> groupStrings(String[] strings) { // 哈希表存储字母之间的差值！！！
        Map<String, List<String>> hashRecord = new HashMap<>(); // 存储形式：{由字母表示的差值，差值相同的组合}；hashRecord["cd"] = ["acf", "gil", "xzc"]！！！
        
        for (String s : strings) {
            String hashKey = getHash(s); // 重写哈希值计算！！！
            if (hashRecord.get(hashKey) == null) {
                hashRecord.put(hashKey, new ArrayList<>());
            } 
            hashRecord.get(hashKey).add(s);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : hashRecord.values()) { // 字母间差值相同的已经分到同一组，将每组加入答案！！！
            result.add(group);
        }
        
        return result;
    }

    public String getHash(String s) { // 计算字符串每个字符之间的差值后表示为字符串；如["acf", "gil", "xzc"]都相差[2,3]，转换成英文字母表示则为[c,d]！！！
        char[] letters = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < letters.length; i++) {
            sb.append((char)((letters[i]-letters[i-1]+26) % 26 + 'a')); // 计算差值要考虑字母表循环，需要手动 +26 再 %26 ！！！
        }
        
        return sb.toString();
    }
}