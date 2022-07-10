class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == arr.length) return arr; // 本题K可能和数组长度相同，则返回全部元素！！！
        int left = 0, right = arr.length-1;
        while (true) {
            int index = partition(arr, left, right);
            if (index > k) {
                right = index-1;
            } else if (index < k) {
                left = index+1;
            } else {
                int[] result = new int[k];
                result = Arrays.copyOfRange(arr, 0, index);
                return result;
            }
        }
    }

    public int partition(int[] arr, int left, int right) {
        Random random = new Random(System.currentTimeMillis());
        if (left < right) {
            int randomIndex = left + 1 + random.nextInt(right-left);
            swap(arr, left, randomIndex);
        }
        int pivot = arr[left];
        int j = left;
        for (int i = left+1; i<=right; i++) {
            if (arr[i] < pivot) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}