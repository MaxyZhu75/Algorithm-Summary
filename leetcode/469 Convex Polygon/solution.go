func isConvex(points [][]int) bool { // 纯数学几何题！！！
    n := len(points)
    x1, x2, y1, y2 := 0, 0, 0, 0 // 设向量A(x1, y1)与向量B(x2, y2)！！！
    previous, current := 0, 0

    for i:=0; i<n; i++ { // 用取余号防止索引大于n时溢出！！！
        x1 = points[(i+1)%n][0] - points[i][0]
        y1 = points[(i+1)%n][1] - points[i][1]
        x2 = points[(i+2)%n][0] - points[(i+1)%n][0]
        y2 = points[(i+2)%n][1] - points[(i+1)%n][1]
        current = x1 * y2 - x2 * y1 // 叉积公式；结果大于0时往逆时针方向，小于0时往顺时针方向！！！

        if current != 0 {
            if current * previous < 0 { // 小于0说明与前一次法向量不在同一方向！！！
                return false
            }
            previous = current
        }
    }

    return true
}