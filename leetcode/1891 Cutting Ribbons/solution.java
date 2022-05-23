class Solution {
    public int maxLength(int[] ribbons, int k) { // 二分查找！！！
        int low = 1, high = 1;
        int result = 0;
        for (int ribbon : ribbons) {
            high = Math.max(ribbon, high);
        }
        while (low <= high){ // 在循环内查找元素，用result记录当前符合条件的结果！！！
            int mid = (high-low)/2 + low;
            if (check(ribbons, k, mid)){
                result = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return result;
    }

    private boolean check(int[] ribbons, int k, int length){ // 判断是否能够切出k个或以上长度为length的绳子！！！
        int count = 0;
        for (int ribbon : ribbons) {
            count += ribbon/length;
        }
        return count >= k;
    }
}