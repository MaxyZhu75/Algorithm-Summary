class Solution {
    public boolean hasAlternatingBits(int n) {
        int r = n>>1; // 1����������>>���൱�ڳ���2n����λ�ɷ���λ��� 2���޷�������>>>����λ��0
        int oneNum = ((n^r)+1); // ����01�����n��������������õ�ȫΪ1�������ټ�1���λ��oneNum����һ��1!!!
        return (oneNum&(oneNum-1))==0; // �ж�oneNum�����Ʊ�ʾ�Ƿ��������һ��1!!!
    }
}