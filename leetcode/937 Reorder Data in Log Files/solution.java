class Solution {
    public String[] reorderLogFiles(String[] logs) { // ��д�������򷽷�������
        Arrays.sort(logs, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String[] log1 = o1.split(" ", 2); // �ԣ��׸����ո�Ϊ�ָ���������Ϊ�����֣�����
                String[] log2 = o2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(log1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(log2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    int cmp = log1[1].compareTo(log2[1]); // ���ֵ�˳��Ƚ������ַ�����С�ڵ��ڴ��ڷֱ��Ӧ����-1, 0, 1������
                    if (cmp != 0) {
                        return cmp;
                    } else {
                        return log1[0].compareTo(log2[0]);
                    }
                } else {
                    return isDigit1 ? (isDigit2 ? 0 : 1) : -1; // ��Java��д�����У�����-1��ʾ������˳��0��ʾ��ͬʱ��������1��ʾ����������
                }
            }
        });
        return logs;
    }
}