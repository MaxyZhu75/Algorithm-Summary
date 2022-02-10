class Solution {
    public List<List<Integer>> threeSum(int[] nums) { // Java����Go�𰸵ı���������������Ϊ����һ��ʱLeetCode�ϻᷢ����һ�����ڴ��ʱ��������⣻�����ֽⷨ����������+˫ָ�룡����
        int n = nums.length; // Ҫ��һ��left������߽�ָ�룬����һ����ͬ������ָ������ߣ�mid��rightΪ�м�ָ����ұ߽�ָ�룡����
        List<List<Integer>> result = new ArrayList<>(); // left��mid��rightָ���ֵ������ͬ���������ظ���result����Ѵ��ڵĴ���ϣ�����

        Arrays.sort(nums);

        for (int left=0; left<n-2; left++) {
            if (nums[left] > 0) { // Ҫ�������߽��ұ�Ԫ�ض���С����߽�Ԫ��ֵ��ֱ���˳�������
                break;
            }
           
            if (left > 0 && nums[left] == nums[left-1]) { // Ҫ�������ֱ�ȷ��left��mid��rightλ�ã�����һ����ͬ����left��ָ������ߣ�������
                continue;
            }
            int mid = left+1;
            int right = n-1;
            
            while (mid < right) { // Ҫ���ģ���ǰleft�̶���left�����ѭ���ƣ�����mid��rightдwhileѭ����˫ָ�룡����
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[left], nums[mid], nums[right])); // Arrays.asList(a, b, c)������
                    while (mid < right && nums[mid] == nums[++mid]);
                    while (mid < right && nums[right] == nums[--right]); // Ҫ���壺ע����ƶ�ָ���д����Go�����֣�����
                } else if (sum < 0) {
                    while (mid < right && nums[mid] == nums[++mid]); // �˴�ѭ����Ϊ��ʹ��һ���𰸲��ظ�������
                } else {
                    while (mid < right && nums[right] == nums[--right]);
                }
            }
        }

        return result;
    }
}