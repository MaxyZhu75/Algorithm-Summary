public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i=31; i>=0; i--){
            int mask = n & 1; // ����ÿ��ѭ��ĩβ�Ὣn�޷�������һλ����˴�ÿ��ѭ����maskȡ���λ��1bit���ɣ�����
            int oneBit = mask << i; // �������ƽ���bit�ƶ�����Ӧλ�ã�����
            result |= oneBit; // ��ӵ�����û����㣡����
            n >>>= 1;
        }
        return result;
    }
}