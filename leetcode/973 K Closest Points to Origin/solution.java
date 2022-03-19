class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>(){
            @ Override
            public int compare(int[] o1, int[] o2) {
                int distance1 = o1[0]*o1[0]+o1[1]*o1[1];
                int distance2 = o2[0]*o2[0]+o2[1]*o2[1];
                return distance1 - distance2; // 距离由小到大，升序排列；三元运算符写法请见LeetCode435题！！！
            }
        });
        return Arrays.copyOfRange(points, 0, k); // java.util.Arrays.copyOfRange()此处即选取索引范围[0,k)，将points前k个元素复制到新数组中！！！
    }
}