class Solution {
    public List<Integer> grayCode(int n) { // �����빫ʽ������
        List<Integer> result = new ArrayList<>();
        for (int i=0; i < (1<<n); i++) {
            result.add((i>>1) ^ i); // ��ʽ:��g(i)=b(i+1)��b(i)����b(i)Ϊ��ǰ���������ĵ�i+1λ������
        }
        return result;
    }
}