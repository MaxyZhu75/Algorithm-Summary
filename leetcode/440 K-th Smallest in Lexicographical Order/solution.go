func findKthNumber(n int, k int) int {
    root := 1 // ������Ŀ���ص���[1, n]���ֵ����kС�����֣�����ȴ�����ڵ�Ϊ 1 ���ֵ���������
    k--
    for k > 0 {
        count := countNodes(root, n) 
        if count <= k { // case1�����ֵ����µĽڵ���Ҫȫ����������ʱ�ֵ���root��ͬ��ڵ��У���1��9���Һ����ƶ�������
            k -= count
            root++
        } else { // case2�����ֵ����°�������ĵ�kС�ڵ㣻��ʱ�ֵ���root��[1, 9]�е�ĳһ����Ϊ��㣬ͨ����10���������ƶ�������
            k--
            root *= 10
        }
    }
    return root
}

func countNodes(root int, n int) int { // ���㵱ǰ�ֵ����½ڵ�������ע����ͳ�Ƹ�����������root��������
    count := 0
    firstChild, lastChild := root, root
    for firstChild <= n { // �����·�ʽչ����������С��n�������ǵ�ǰ�ֵ����µĽڵ㣡����
        count += (min(lastChild, n) - firstChild + 1) // ʹ��min()����ֹͳ�Ƴ���n�Ľڵ㣡����
        firstChild, lastChild = firstChild*10, lastChild*10 + 9 // չ����һ���ӽڵ㣨��10����������
    }
    return count
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}