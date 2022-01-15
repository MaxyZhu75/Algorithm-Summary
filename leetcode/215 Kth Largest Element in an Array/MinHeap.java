class Solution {
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        buildHeap(nums, size); // 手撕小顶堆！！！
        for (int i = nums.length-1; i >= k-1; i--) { // 通过经典堆排序删除到只剩下k个最大值，取堆的末尾则得到第k大的值！！！
            swap(nums, 0, i); // 每次循环首先交换堆顶最小值与堆底最大值！！！
            size--; // 每次循环用heapify对当前nums重新构建更小的堆达到删除的目的！！！
            heapify(nums, 0, size);
        }
        return nums[k-1];
    }

    public void buildHeap(int[] a, int size) {
        for (int i = size/2; i>=0; i--) { // 要点1：以i=size/2传入heapify即由最后一个internal node（非叶子节点或父节点）开始，bottom-up由下往上构建！！！
            heapify(a, i, size);
        } 
    }

    public void heapify(int[] a, int i, int size) {
        int left = 2*i + 1; // 要点2：父节点的左结点和右结点索引要记住！！！
        int right = 2*i + 2;
        int smallest = i;
        if (left<size && a[left]<a[smallest]) { // 要点3：构建大顶堆时，比较后与较大的子节点交换；构建小顶堆时，比较后与较小的子节点交换！！！
            smallest = left;
        } 
        if (right<size && a[right]<a[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(a, i, smallest);
            heapify(a, smallest, size); // 要点4：若进行了上述交换操作，则要对该父节点为根的子树再次heapify来维持堆的性质！！！
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}