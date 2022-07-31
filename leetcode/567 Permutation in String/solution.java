class Solution {
    public boolean checkInclusion(String s1, String s2) { // ��ȡ��˼·������
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        int[] count = new int[26];
        for (int i=0; i<n; i++) {
            count[s1.charAt(i)-'a']--;
        }
        int left = 0, right = 0;
        while (right < m) {
            count[s2.charAt(right)-'a']++;
            while (count[s2.charAt(right)-'a'] > 0) { // ����������ʱ�����ڴ�С�������ţ�����
                count[s2.charAt(left)-'a']--;
                left++;
            }
            if (right-left+1 == n) { // �����ڴ�С���ŵ�Ԥ�ڣ���˵��������ĸ�Ѿ��ܸ����ˣ�����
                return true;
            }
            right++;
        }
        return false;
    }
}