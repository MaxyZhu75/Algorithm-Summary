class Solution {
    public int[] sortArray(int[] nums) { // 调用「堆排序」！！！
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        int size = nums.length;
        buildHeap(nums, size); // 手撕大顶堆！！！
        for (int i = nums.length-1; i >= 1; i--) { // 通过n-1次循环，将原大顶堆中第n个元素移至堆顶！！！
            swap(nums, 0, i); // 每次与当前堆顶最大值交换！！！
            size--;
            heapify(nums, 0, size); // 忽略末尾元素（被交换下来的最大值），用heapify重新构建更小的堆！！！
        }
    }

    public void buildHeap(int[] a, int size) {
        for (int i = size/2; i>=0; i--) { // 要点1：以i=size/2传入heapify即由最后一个internal node（非叶子节点或父节点）开始，bottom-up由下往上构建！！！
            heapify(a, i, size);
        } 
    }

    public void heapify(int[] a, int i, int size) { 
        int left = 2*i + 1; // 要点2：父节点的左结点和右结点索引要记住！！！
        int right = 2*i + 2;
        int largest = i;
        if (left<size && a[left]>a[largest]) { // 要点3：构建大顶堆时，比较后与较大的子节点交换；构建小顶堆时，比较后与较小的子节点交换！！！
            largest = left;
        } 
        if (right<size && a[right]>a[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(a, i, largest);
            heapify(a, largest, size); // 要点4：若进行了上述交换操作，则要对该父节点为根的子树再次heapify来维持堆的性质！！！
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}