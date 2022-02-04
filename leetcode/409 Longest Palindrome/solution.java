class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        Map<Character, Integer> hashRecord = new HashMap<>(); // ��Ͱ��������ٶȻ���죡����
        
        for (int i=0; i<n; i++) {
            char letter = s.charAt(i);
            hashRecord.put(letter, hashRecord.getOrDefault(letter, 0) + 1);
        }

        int pairs = 0;
        int single = 0;
        for (char key : hashRecord.keySet()) { // ����ɶԵĶ���������
            int currentpair = hashRecord.get(key) / 2;
            pairs += currentpair;
        }
        
        if (2*pairs < n) { // ����ɶ�������2С��ԭ�����ȣ���˵�����䵥���ַ�������
            single = 1;
        }

        int result = 2*pairs + single;
        return result;
    }
}