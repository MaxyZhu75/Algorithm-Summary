class Solution {
    public List<Integer> pancakeSort(int[] arr) { // ����������⣬�ҵ���̽ⷨ��NP-Hard���⣡����
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        for (int i=n-1; i>0; i--) { // ��β����ǰ����ÿ��ѭ��������������������������ţ�i��ʾ��ǰ�����������ĩβ������

            int currentMax = 0; // �ҳ���ǰ���Ĵ�������������������
            for (int j=1; j<=i; j++) {
                currentMax = (arr[j] >= arr[currentMax]) ? j : currentMax;
            }

            if (currentMax == i) { // case1�������Ĵ��������Ѿ��ڴ���������ĩβ������Ҫ��ת������
                continue;
            }

            reverse(arr, currentMax); // case2�������Ĵ����������ڴ���������ĩβ����ͨ�����η�ת����������ĩβ������
            reverse(arr, i);
            result.add(currentMax+1);
            result.add(i+1);
        }

        return result;
    }

    public void reverse(int[] arr, int end) {
        for (int i=0, j=end; i<j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}