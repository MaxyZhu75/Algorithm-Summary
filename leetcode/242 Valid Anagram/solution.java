class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> hashRecord = new HashMap<>();

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        for (char letter : sChar) {
            hashRecord.put(letter, hashRecord.getOrDefault(letter, 0) + 1); // �Ӳ���������
        }
        for (char letter : tChar) {
            hashRecord.put(letter, hashRecord.getOrDefault(letter, 0) - 1); // ������������
        }

        for (char letter : sChar) { // �����ַ�������ȫ��ͬʱ��HashMap������ֵΪ�㣡����
            if (hashRecord.get(letter) != 0) {
                return false;
            }
        }
		
        return true;
    }
}