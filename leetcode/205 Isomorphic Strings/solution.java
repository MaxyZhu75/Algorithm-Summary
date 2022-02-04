class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(); // ��֪�����ַ���������ȣ�����
        int[] record1 = new int[256]; // ��¼ÿ���ַ��ϴγ��ֵ�����������
        int[] record2 = new int[256]; // ��֪�ַ���������ASCII�ַ���ɣ���С��Ϊ128ʱ�����������

        for (int i=0; i<n; i++) {
            char letter1 = s.charAt(i);
            char letter2 = t.charAt(i);
            if (record1[letter1] != record2[letter2]) { // ���������ַ���ʱ�������Ե�ǰ��ĸ�ϴγ��ֵ�������ͬ��ͬ��������
                return false;
            }
            record1[letter1] = i+1; // ����Ԫ�س�ʼֵΪ0�����ǰ�0��������ĸδ���֣�����ڼ�¼���ֹ�����ĸ����ʱҪ+1�������֣���ֹ�ѵ�һ�����ֵ���ĸ����Ҳ��¼Ϊ0������������
            record2[letter2] = i+1;
        }

        return true;
    }
}