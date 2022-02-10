class Solution { // ����һ������������÷����ռ临�Ӷ�ΪO(n)��Go����д�ķ������ռ临�Ӷ�ΪO(1)������
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] record = new int[n+1];
        int[] result = new int[2];
        for (int num : nums) {
            record[num]++;
        }

        for (int i=1; i<n+1; i++) {
            if (record[i] == 2) {
                result[0] = i;
            }

            if (record[i] == 0) {
                result[1] = i;
            }
        }

        return result;
    }
}