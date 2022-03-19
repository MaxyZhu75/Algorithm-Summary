class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>(){
            @ Override
            public int compare(int[] o1, int[] o2) {
                int distance1 = o1[0]*o1[0]+o1[1]*o1[1];
                int distance2 = o2[0]*o2[0]+o2[1]*o2[1];
                return distance1 - distance2; // ������С�����������У���Ԫ�����д�����LeetCode435�⣡����
            }
        });
        return Arrays.copyOfRange(points, 0, k); // java.util.Arrays.copyOfRange()�˴���ѡȡ������Χ[0,k)����pointsǰk��Ԫ�ظ��Ƶ��������У�����
    }
}