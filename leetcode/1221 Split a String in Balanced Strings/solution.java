class Solution {
    public int balancedStringSplit(String s) { // ̰�ģ���ȷ��֤�����ٷ���⣡����
        int count = 0, balance = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'L') { // L��balance++������
                balance++;
            } else {
                balance--; // R��balance--������
            }
            if (balance == 0) { // ̰�ĵ����ÿ��ƽ��״̬����ʱʣ�ಿ�ֱ�Ȼ����ƽ���ַ���������
                count++;
            }
        }
        return count;
    }
}