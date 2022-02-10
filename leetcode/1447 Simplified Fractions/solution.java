class Solution {
    public List<String> simplifiedFractions(int n) { // ����ؼ������ж��Ƿ�Ϊ�����������ܿ���¼�ѳ��ֵ�i/j����Ϊ��/������������������������
        List<String> result = new ArrayList<>();
    
        for (int i=2; i<=n; i++) {
            for (int j=1; j<i; j++) {
                StringBuilder sb = new StringBuilder();
                if (gcd(j, i) == 1) { // ��ȷ�жϷ��������ӷ�ĸ���Լ��Ϊ1����÷���Ϊ��������Ȼ���С�������������ɣ�����
                    sb.append(j);
                    sb.append("/");
                    sb.append(i);
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }

    public int gcd(int a, int b) { // Greatest Common Divisor�ݹ�д��������
        return b == 0 ? a : gcd(b, a%b);
    }
}