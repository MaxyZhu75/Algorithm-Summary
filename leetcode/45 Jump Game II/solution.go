func jump(nums []int) int { // �ӽ�̰��˼�룡����
    n := len(nums)
    actualBoundary, currentFurthest, hop := 0, 0, 0 // actualBoundaryΪÿһ���������ʵ�ʱ߽磻currentFurthest���㵱ǰ��������Զ���룬Ϊ��һ��׼������������
    for i:=0; i<n-1; i++ { // ��������Ҫ����λ�ã�n-1���ѵ����յ㣬���ñ���������
        currentFurthest = max(currentFurthest, i+nums[i])
        if i == actualBoundary { // Ҫ�㣺����������ʵ�ʱ߽�ʱ������һ��������
            actualBoundary = currentFurthest
            hop++
        }
    }
    return hop
}

func max(a int, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}