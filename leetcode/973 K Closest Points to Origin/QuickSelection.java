class Solution {
    public int[][] kClosest(int[][] points, int k) { // 同Leetcode215题！！！
        int left = 0;
        int right = points.length-1;
        while (true) {
            int index = partition(points, left, right); // 返回值为当前循环所选pivot经过partition()后所在的索引位置index，其含义相当于数组内含有index个比pivot值小的元素，且已经被放置到pivot的左边！！！
            if (index < k-1) { // case1：比当前循环所选pivot小的元素少于k-1个，调整左边界！！！
                left = index + 1;
            } else if (index > k-1) { // case2：比当前循环所选pivot小的元素多于k-1个，调整左边界！！！
                right = index - 1;
            } else { // case3：比当前循环所选pivot小的元素等于k-1个（且已经被放置到pivot的左边）！！！
                return Arrays.copyOfRange(points, 0, k); // java.util.Arrays.copyOfRange()此处即选取索引范围[0,k)，将points前k个元素复制到新数组中！！！
            }
        }
    }

    private static Random random = new Random(System.currentTimeMillis()); // java.util.Random 以及 java.util.Date导包；帮助生成随机pivot减少运行时间！！！

    private int partition(int[][] points, int left, int right) {
        if (right > left) {
            int randomIndex = left + 1 + random.nextInt(right-left); // random.nextInt(right-left)即生成介于[0, right-left)随机整数！！！
            swap(points, left, randomIndex); // 将随机选取的pivot移动到最前面！！！
        }
        int pivot = points[left][0] * points[left][0] + points[left][1] * points[left][1];
        int j = left; // 记录pivot的合理索引位置，但在循环内并未真正交换pivot！！！
        for (int i = left+1; i<=right; i++) {
            int currentDistance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (currentDistance < pivot) {
                j++; // 记录pivot的合理索引位置，即统计当前比pivot小的元素个数！！！
                swap(points, j, i);
            }
        }
        swap(points, left, j); // 循环结束后，此处再将pivot交换至正确位置！！！
        return j;
    }

    private void swap(int[][] a, int i, int j) {
        int[] temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}