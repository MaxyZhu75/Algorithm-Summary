class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> (o1[0] == o2[0]) ? o2[1]-o1[1] : o1[0]-o2[0]); //��w����h���򡹣�����
        List<Integer> d = new ArrayList<>(); // ϸ�ڣ�����DP��ʹ���б�ʵ�֣�����
        d.add(envelopes[0][1]);
        for (int i=1; i<envelopes.length; i++) {
            if (envelopes[i][1] > d.get(d.size()-1)) {
                d.add(envelopes[i][1]); // case1�����Խ���d�е����ֵ֮���γ�һ�����ȸ������ϸ���������У�����
            } else {
                int index = binarySearch(d, envelopes[i][1]);
                d.set(index, envelopes[i][1]); // case2���ҳ�d���׸���С��Ԫ�أ����Խ��ڸ�Ԫ��֮�󣡣���
            }
        }
        return d.size(); // �б���չ�������size������
    }
	
    public int binarySearch(List<Integer> d, int target) { // �ҳ�d���׸���target��С��Ԫ������λ�ã�����
        int low = 0, high = d.size()-1;
        while (low < high) {
            int mid = (high-low)/2 + low;
            if (d.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}