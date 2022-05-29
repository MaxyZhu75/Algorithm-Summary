class Solution {
    List<String> result = new ArrayList<>();
    int[] segments = new int[4];

    public List<String> restoreIpAddresses(String s) {
        dfsBacktracking(s, 0, 0);
        return result;
    }

    public void dfsBacktracking(String s, int segCount, int segStart) {
        if (segCount == 4) { // ���ڣ���Ҫ����4��IP��ַ���Ҹպñ������ַ���������
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<4; i++) {
                    sb.append(segments[i]);
                    if (i != 3) sb.append('.');
                }
                result.add(sb.toString());
            }
            return;
        }

        if (segStart == s.length()) return; // ��û���ҵ�4��IP��ַ���Ѿ��������ַ�������ֱ��return������

        if (s.charAt(segStart) == '0') { // �����ǰ����Ϊ0����ô��һ��IP��ַֻ��Ϊ0�����ܺ���ǰ���㣩������
            segments[segCount] = 0;
            dfsBacktracking(s, segCount+1, segStart+1); // �ݹ鴫��segCount+1��segStart+1�������Ǳ�������+1������
        }

        int num = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) { // һ���������num����(0, 255]����ö��ÿһ�ֿ����Բ��ݹ飡����
            num = 10*num + (s.charAt(segEnd) - '0');
            if (num > 0 && num <= 255) {
                segments[segCount] = num; // forѭ���ڲ�ͬ��segEnd��ʹ�µ�segments[segCount]���ǵ�ԭ������ֵ������
                dfsBacktracking(s, segCount+1, segEnd+1);
            } else {
                break;
            }
        }
    }
}