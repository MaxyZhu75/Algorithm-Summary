class Solution {
    public boolean isConvex(List<List<Integer>> points) { // 纯数学几何题！！！
        int n = points.size();
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0; // 设向量A(x1, y1)与向量B(x2, y2)！！！
        int previous = 0, current = 0;
        
        for (int i=0; i<n; i++) { // 用取余号防止索引大于n时溢出！！！
            x1 = points.get((i+1)%n).get(0) - points.get(i).get(0);
            y1 = points.get((i+1)%n).get(1) - points.get(i).get(1);
            x2 = points.get((i+2)%n).get(0) - points.get((i+1)%n).get(0);
            y2 = points.get((i+2)%n).get(1) - points.get((i+1)%n).get(1);
            current = x1 * y2 - x2 * y1; // 叉积公式；结果大于0时往逆时针方向，小于0时往顺时针方向！！！

            if (current != 0) {
                if ((long) previous*current < 0) return false; // 强制转换为long；小于0说明与前一次法向量不在同一方向！！！
                previous = current;
            }
        }

        return true;
    }
}