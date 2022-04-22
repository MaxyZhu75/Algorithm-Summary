class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> hashRecord = new HashMap<>();
        for (char letter : s.toCharArray()) {
            hashRecord.put(letter, hashRecord.getOrDefault(letter, 0) + 1); // ��¼s��ÿ���ַ����ִ���������
        }

        StringBuilder sb = new StringBuilder();
        for(char letter : order.toCharArray()) { // ����order����HashMap�еĴ������ν����ֵ��ַ������sb������
            if (hashRecord.containsKey(letter)) {
                int count = hashRecord.get(letter);
                while (count-- > 0) {
                    sb.append(letter);
                }
                hashRecord.put(letter, 0); // ��ӽ����������0������
            }
        }

        for (char letter : hashRecord.keySet()) { // ��ʣ���ַ�ƴ�ӵ�sbĩβ�������Ҫ�󷵻��������ʵĵ��������У�������
            int count = hashRecord.get(letter);
            while (count-- > 0) {
                sb.append(letter);
            }
        }

        return sb.toString();
    }
}