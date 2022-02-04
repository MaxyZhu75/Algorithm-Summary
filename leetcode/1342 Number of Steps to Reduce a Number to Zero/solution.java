class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if (num == 1) { // 1要先特殊处理！！！
                count++;
                break;
            }
            if(num % 2 == 0) {
                num /= 2;
                count++;
            } else {
                num--;
                count++;
            }
        }
        return count;
    }
}