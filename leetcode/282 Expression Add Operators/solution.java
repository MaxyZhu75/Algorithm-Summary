class Solution {
    int n;
    String digits;
    int target;
    List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) { // ���ݣ�����
        this.n = num.length();
        this.digits = num;
        this.target = target;
        StringBuilder sb = new StringBuilder();
        backtrack(sb, 0, 0, 0);
        return result;
    }

    public void backtrack(StringBuilder sb, int start, long curVal, long mulVal) {
        if (start == n) {
            if (curVal == target) {
                result.add(sb.toString());
            }
            return;
        }
        int signIndex = sb.length(); // ϸ�ڣ���¼���ݹ�ƴ�ӡ��������ݡ���λ�ã�����
        if (start > 0) {
            sb.append('#'); // ϸ�ڣ�ռλ�����������ţ�����
        }
        long num = 0; // ����Ĳ�����Ҳ��Ҫö�٣���ע�����ֿ����ǵ���0��������ǰ���㣡����
        for (int i=start; i<n && (i==start || digits.charAt(start)!='0'); i++) {
            num = num * 10 + digits.charAt(i)-'0';
            sb.append(digits.charAt(i));
            if (start == 0) { // ���ʽ��ͷ������ӷ��ţ�����
                backtrack(sb, i+1, num, num);
            } else { // ö�ٲ�����������
                sb.setCharAt(signIndex, '+');
                backtrack(sb, i+1, curVal+num, num);
                sb.setCharAt(signIndex, '-');
                backtrack(sb, i+1, curVal-num, -num);
                sb.setCharAt(signIndex, '*');
                backtrack(sb, i+1, curVal-mulVal+mulVal*num, mulVal*num); // ϸ�ڣ�mulValΪ���ʽ���һ�����˴��ļ�����������
            }
        }
        sb.setLength(signIndex); // ����ɾ��ĩβ���֣�����
    }
}