class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> hashRecord = new HashMap<>();
        for (char letter : s.toCharArray()) {
            hashRecord.put(letter, hashRecord.getOrDefault(letter, 0) + 1); // 记录s中每个字符出现次数！！！
        }

        StringBuilder sb = new StringBuilder();
        for(char letter : order.toCharArray()) { // 遍历order，按HashMap中的次数依次将出现的字符添加入sb！！！
            if (hashRecord.containsKey(letter)) {
                int count = hashRecord.get(letter);
                while (count-- > 0) {
                    sb.append(letter);
                }
                hashRecord.put(letter, 0); // 添加结束后次数置0！！！
            }
        }

        for (char letter : hashRecord.keySet()) { // 将剩余字符拼接到sb末尾（本题仅要求返回满足性质的的任意排列）！！！
            int count = hashRecord.get(letter);
            while (count-- > 0) {
                sb.append(letter);
            }
        }

        return sb.toString();
    }
}