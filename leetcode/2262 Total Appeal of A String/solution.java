class Solution {
    public long appealSum(String s) { // �൱��LeetCode��828��ͳ�Ʒ����У�ǰһ�γ��ֵ�λ���ڱ����о�Ϊ-1������
        int d[] = new int[26];
        long result = 0;
        for (int i=0; i<s.length(); i++) {
            int charIndex = s.charAt(i)-'a';
			d[charIndex] = i+1;
            for (int j=0; j<26; j++) {
				result += d[j];
			}
        }
        return result;
    }
}