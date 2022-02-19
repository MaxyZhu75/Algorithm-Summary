class Solution {
    public int majorityElement(int[] nums) { // Boyer-Moore投票法！！！
        int candidate = nums[0];
        int vote = 0;
        for (int num : nums) {
            candidate = (vote == 0) ? num : candidate; // case1：若候选人不是majority，则majority会和其他非候选人一起反对候选人，而候选人一定会下台且在vote==0时发生换届选举！！！
            vote = (candidate == num) ? vote+1 : vote-1; // case2：若候选人是majority , 则majority会支持自己，而其他非候选人会反对，由于已知majority票数超过一半，所以其一定会成功当选！！！
        }
        return candidate;
    }
}