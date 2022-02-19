class Solution {
    public int minMoves2(int[] nums) { // ����һ���������ѧ���⣬�������������е�ÿ������Ϊx����xΪ���N��������λ��ʱ������ʹ�þ�����С������
        Arrays.sort(nums); // ��NΪ��������x����Ϊ��N�����е�Ψһ��λ��������
        int n = nums.length; // ��NΪż�����м��������Ϊp��q����λ��Ϊ(p+q)/2����ʱxֻҪ������[p,q]�е�����һ�������ɣ�����
        int median = nums[n/2]; // ȷ����λ����λ�û�����ʹ�ÿ��������ٶȻ���죡����
        int result = 0;
        for (int num : nums) {
            result += Math.abs(num- median);
        }
        return result;
    }
}