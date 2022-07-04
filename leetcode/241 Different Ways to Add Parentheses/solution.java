class Solution {
    char[] s;

    public List<Integer> diffWaysToCompute(String expression) {
        this.s = expression.toCharArray();
        return dfs(0, expression.length()-1);
    }

    public List<Integer> dfs(int left, int right) { // �ݹ���㡸����������������ֵ����ϣ�����
        List<Integer> result = new ArrayList<>();
        for (int i=left; i<=right; i++) {
            if (Character.isDigit(s[i])) continue; //�����֡���Ҫ������������
            List<Integer> values1 = dfs(left, i-1);
            List<Integer> values2 = dfs(i+1, right);
            for (int val1 : values1) { // �ݹ顸���������������ߵ�ֵ�������㣡����
                for (int val2 : values2) {
                    int current = 0;
                    switch (s[i]) {
                        case '+':
                            current = val1 + val2;
                            break;
                        case '-':
                            current = val1 - val2;
                            break;
                        default:
                            current = val1 * val2;
                            break;
                    }
                    result.add(current);
                }
            }
        }
        if (result.isEmpty()) { // result��Ϊ����Ϊ�����֣�ͳ�����ּ��뼴�ɣ�����
            int num = 0;
            for (int i=left; i<=right; i++) {
                num = num * 10 + (s[i]-'0');
            }
            result.add(num);
        }
        return result;
    }
}