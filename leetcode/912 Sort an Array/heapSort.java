class Solution {
    public int[] sortArray(int[] nums) { // ���á������򡹣�����
        heapSort(nums);
        return nums;
    }

    public void heapSort(int[] nums) {
        int size = nums.length;
        buildHeap(nums, size); // ��˺�󶥶ѣ�����
        for (int i = nums.length-1; i >= 1; i--) { // ͨ��n-1��ѭ������ԭ�󶥶��е�n��Ԫ�������Ѷ�������
            swap(nums, 0, i); // ÿ���뵱ǰ�Ѷ����ֵ����������
            size--;
            heapify(nums, 0, size); // ����ĩβԪ�أ����������������ֵ������heapify���¹�����С�Ķѣ�����
        }
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