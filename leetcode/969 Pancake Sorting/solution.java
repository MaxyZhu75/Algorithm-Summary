class Solution {
    public List<Integer> pancakeSort(int[] arr) { // 煎饼排序问题，找到最短解法是NP-Hard问题！！！
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        for (int i=n-1; i>0; i--) { // 从尾部向前整理，每次循环将待排序数组中最大的数往后放；i表示当前待排序数组的末尾！！！

            int currentMax = 0; // 找出当前最大的待排序数的索引！！！
            for (int j=1; j<=i; j++) {
                currentMax = (arr[j] >= arr[currentMax]) ? j : currentMax;
            }

            if (currentMax == i) { // case1：若最大的待排序数已经在待排序数组末尾，则不需要反转！！！
                continue;
            }

            reverse(arr, currentMax); // case2：若最大的待排序数不在待排序数组末尾，则通过两次反转将该数放在末尾！！！
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