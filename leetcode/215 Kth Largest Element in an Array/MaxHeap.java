class Solution {
    public int findKthLargest(int[] nums, int k) {
        int size = nums.length;
        buildHeap(nums, size); // ��˺�󶥶ѣ�����
        for (int i = nums.length-1; i >= nums.length-(k-1); i--) { // ͨ�����������ɾ��k-1�����ֵ��ȡ�Ѷ���õ���k���ֵ������
            swap(nums, 0, i); // ÿ��ѭ�����Ƚ����Ѷ����ֵ��ѵ���Сֵ������
            size--; // ÿ��ѭ����heapify�Ե�ǰnums���¹�����С�ĶѴﵽɾ����Ŀ�ģ�����
            heapify(nums, 0, size);
        }
        return nums[0];
    }

    public void buildHeap(int[] a, int size) {
        for (int i = size/2; i>=0; i--) { // Ҫ��1����i=size/2����heapify�������һ��internal node����Ҷ�ӽڵ�򸸽ڵ㣩��ʼ��bottom-up�������Ϲ���������
            heapify(a, i, size);
        } 
    }

    public void heapify(int[] a, int i, int size) { 
        int left = 2*i + 1; // Ҫ��2�����ڵ��������ҽ������Ҫ��ס������
        int right = 2*i + 2;
        int largest = i;
        if (left<size && a[left]>a[largest]) { // Ҫ��3�������󶥶�ʱ���ȽϺ���ϴ���ӽڵ㽻��������С����ʱ���ȽϺ����С���ӽڵ㽻��������
            largest = left;
        } 
        if (right<size && a[right]>a[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(a, i, largest);
            heapify(a, largest, size); // Ҫ��4��������������������������Ҫ�Ըø��ڵ�Ϊ���������ٴ�heapify��ά�ֶѵ����ʣ�����
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}