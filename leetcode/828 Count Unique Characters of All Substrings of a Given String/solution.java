class Solution {
    public int uniqueLetterString(String s) { // ��Ŀ������Ψһ�ַ����Ӵ�������Ҳ������Ψһ�ַ����Ӵ����ȣ������������Ӵ��У�ÿһ���Ӵ���Ψһ�ַ��ĸ����ܺͣ�����
        if (s.length() == 0) {
            return 0;
        }

        int[][] d = new int[26][2]; // 26����ĸ��d[char][0]��ʾ����ĸǰһ�γ��ֵ�����λ�ã�d[char][1]��ʾ����ĸ��ǰ������ֵ�����λ�ã�����
        
        for (int i=0; i<26; i++) {
            Arrays.fill(d[i], -1);  // �ֶ���ʼ�����-1������
        }

        int result = 0;
        for (int i=0; i<s.length(); i++) { // �����ַ�����ÿ����ĸ��עǰһ�γ��ֵ�����λ�ã�����
            int charIndex = s.charAt(i) - 'A';
            d[charIndex][0] = d[charIndex][1]; // ���µ�ǰĩβ��ĸdp��������ĸΨһ�Բ��䣡����
            d[charIndex][1] = i;

            int count = 0;
            for (int j=0; j<26; j++) {               
                count += (d[j][1] - d[j][0]); // ����������ȷ��֤�����ٷ���𣡣���
            }
            result += count;         
        }
        return result % 1000000007;
    }    
}
