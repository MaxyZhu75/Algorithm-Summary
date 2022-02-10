class Solution {
    public String convertToTitle(int columnNumber) { // ��ת��Ϊ26���ƣ�����ͨ����ת��˼·��ͬ�����˴������ܿӣ�����
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            columnNumber--; // �ӵ㣺����A��Z��Ӧ1-26����ÿ��ѭ������ʾ26���Ƶ�ÿһλʱ����Ҫ�ȼ�1������
            char oneBit = (char) ('A' + columnNumber%26); // ǿ��ת��������
            sb.append(oneBit);
            columnNumber /= 26; 
        }
        return sb.reverse().toString();
    }
}