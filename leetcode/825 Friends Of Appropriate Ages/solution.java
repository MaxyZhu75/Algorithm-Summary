class Solution {
    public int numFriendRequests(int[] ages) { // ���� + ǰ׺�� ������
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        int[] pSum = new int[121];
        for (int i=1; i<=120; i++) {
            pSum[i] = pSum[i-1] + count[i];
        }
        int result = 0; // ���������ϲ�Ϊ��0.5*ages[x]+7 < ages[y] <= ages[x] ������
        for (int i=15; i<=120; i++) { // ��֪15�����µ�x���Ҳ���������ʽ��y�ģ�����
            if (count[i] > 0) {
                int lower = (int)(i * 0.5 + 7); // ϸ�ڣ�����ȡ��������
                result += count[i] * (pSum[i]-pSum[lower]-1); // ϸ�ڣ�pSum�±���ages�±����1��ĩβ��1Ϊ��ȥx��������
            }
        }
        return result;
    }
}