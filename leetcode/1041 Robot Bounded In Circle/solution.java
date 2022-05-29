class Solution {
    public boolean isRobotBounded(String instructions) { // 仅执行一遍指令即可判断，若没回到原点并且面向北方则必然无法回到原点，否则必然能回到原点！！！
        int[][] directionsR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] directionsL = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int offset = 0, x = 0, y = 0;
        for (int i=0; i<instructions.length(); i++) {
            if (instructions.charAt(i) == 'R') { // case1：朝右转向！！！
                offset++;
            } else if (instructions.charAt(i) == 'L') { // case2：朝左转向！！！
                offset--;
            } else { // case3：前进！！！
                if (offset >= 0) {
                    x += directionsR[offset%4][0];
                    y += directionsR[offset%4][1];
                } else {
                    int temp = -1 * offset; // 这里不能改变原offset变量，会影响后续计算！！！
                    x += directionsL[temp%4][0];
                    y += directionsL[temp%4][1];                 
                }
            }
        }
        return (x == 0 && y == 0) || (offset % 4 != 0);
    }
}