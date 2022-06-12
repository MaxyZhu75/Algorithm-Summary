class Solution {
    public int maximizeSweetness(int[] sweetness, int k) { // 「二分查找」判断问题；与LeetCode第1011，875题类似！！！
        int min = Integer.MAX_VALUE, sum = 0;
		for (int sweet : sweetness) {
			sum += sweet;
			min = Math.min(min, sweet);
		}
		
		int low = min, high = sum/(k+1), result = 0; // 自己将吃掉甜度最小的一份；因此自己至少能分到甜度最小的一块，至多能分到平均值！！！
        while (low <= high) {
            int mid = (high-low)/2 + low;
            int currentSweetness = 0;
            int people = 0; // 以mid为甜度下限，people表示分享人数，currentSweetness记录当前朋友分到的甜度！！！
            for (int sweet : sweetness) {
                currentSweetness += sweet;
                if (currentSweetness >= mid) {
                    people++;
                    currentSweetness = 0;
                }
            }
            if (people >= k+1) { // 该问题找的是最大甜度下限！！！
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}