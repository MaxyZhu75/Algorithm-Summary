class Solution {
    public int[][] kClosest(int[][] points, int k) { // ͬLeetcode215�⣡����
        int left = 0;
        int right = points.length-1;
        while (true) {
            int index = partition(points, left, right); // ����ֵΪ��ǰѭ����ѡpivot����partition()�����ڵ�����λ��index���京���൱�������ں���index����pivotֵС��Ԫ�أ����Ѿ������õ�pivot����ߣ�����
            if (index < k-1) { // case1���ȵ�ǰѭ����ѡpivotС��Ԫ������k-1����������߽磡����
                left = index + 1;
            } else if (index > k-1) { // case2���ȵ�ǰѭ����ѡpivotС��Ԫ�ض���k-1����������߽磡����
                right = index - 1;
            } else { // case3���ȵ�ǰѭ����ѡpivotС��Ԫ�ص���k-1�������Ѿ������õ�pivot����ߣ�������
                return Arrays.copyOfRange(points, 0, k); // java.util.Arrays.copyOfRange()�˴���ѡȡ������Χ[0,k)����pointsǰk��Ԫ�ظ��Ƶ��������У�����
            }
        }
    }

    private static Random random = new Random(System.currentTimeMillis()); // java.util.Random �Լ� java.util.Date�����������������pivot��������ʱ�䣡����

    private int partition(int[][] points, int left, int right) {
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right-left); // random.nextInt(right-left)�����ɽ���[0, right-left)�������������
            swap(points, left, randomIndex); // �����ѡȡ��pivot�ƶ�����ǰ�棡����
        }
        int pivot = points[left][0] * points[left][0] + points[left][1] * points[left][1];
        int j = left; // ��¼pivot�ĺ�������λ�ã�����ѭ���ڲ�δ��������pivot������
        for (int i = left+1; i<=right; i++) {
            int currentDistance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (currentDistance < pivot) {
                j++; // ��¼pivot�ĺ�������λ�ã���ͳ�Ƶ�ǰ��pivotС��Ԫ�ظ���������
                swap(points, j, i);
            }
        }
        swap(points, left, j); // ѭ�������󣬴˴��ٽ�pivot��������ȷλ�ã�����
        return j;
    }

    private void swap(int[][] a, int i, int j) {
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}