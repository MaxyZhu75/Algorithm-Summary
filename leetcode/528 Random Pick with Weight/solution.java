class Solution { // ǰ׺�� + ���ֲ��� ������

    int[] prefixSum;

    public Solution(int[] w) {
        int n = w.length;
        prefixSum = new int[n];
        prefixSum[0] = w[0];
        for (int i=1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + w[i]; // ��дdp��ķ�ʽ��ǰ׺����д����������
        }
    }
    
    public int pickIndex() { // �����ѽ�����[1, weightSum]����n�����֣����˴����ѡ������Ϊi��Ԫ�أ��������Ҫ��������[prefixSum[i]-w[i]+1, prefixSum[i]]������
        int weightSum = prefixSum[prefixSum.length-1]; // ��ȡȨ��֮�ͣ�����[1, weightSum]��ȡ�����������
        int randomNum = (int) (Math.random() * weightSum) + 1; // java.lang.Math.random()���� [0.0, 1.0) �������������
        return partition(randomNum);
    }

    public int partition(int randomNum) { // ���ֲ��ң�����
        int low = 0;
        int high = prefixSum.length-1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (prefixSum[mid] >= randomNum) { // case1���������ں͵���������������ų�mid�±꣡����
                high = mid;
            } else {
                low = mid + 1; // case2��С��ʱ��mid�±�Ҳ���ų�������
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */