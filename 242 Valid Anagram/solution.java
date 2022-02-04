class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> hashRecord = new HashMap<>();

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (char letter : sChar) {
            hashRecord.put(letter, hashRecord.getOrDefault(letter, 0) + 1); // 加操作！！！
        }
        for (char letter : tChar) {
            hashRecord.put(letter, hashRecord.getOrDefault(letter, 0) - 1); // 减操作！！！
        }

        for (char letter : sChar) { // 仅当字符数量完全相同时，HashMap中所有值为零！！！
            if (hashRecord.get(letter) != 0) {
                return false;
            }
        }
		
        return true;
    }
}