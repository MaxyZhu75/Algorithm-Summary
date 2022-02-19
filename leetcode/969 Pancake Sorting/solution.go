func pancakeSort(arr []int) []int { // ����������⣬�ҵ���̽ⷨ��NP-Hard���⣡����
    n := len(arr)
    var result []int = []int{}

    for i:=n-1; i>0; i-- { // ��β����ǰ����ÿ��ѭ��������������������������ţ�i��ʾ��ǰ�����������ĩβ������

        currentMax := 0 // �ҳ���ǰ���Ĵ�������������������
        for j:=1; j<=i; j++ {
            if arr[j] >= arr[currentMax] {
                currentMax = j
            }
        }

        if currentMax == i { // case1�������Ĵ��������Ѿ��ڴ���������ĩβ������Ҫ��ת������
            continue
        }

        reverse(arr, currentMax) // case2�������Ĵ����������ڴ���������ĩβ����ͨ�����η�ת����������ĩβ������
        reverse(arr, i)
        result = append(result, currentMax+1)
        result = append(result, i+1)
    }

    return result
}

func reverse(arr []int, end int) {
    p1, p2 := 0, end
    for (p1 < p2) {
        arr[p1], arr[p2] = arr[p2], arr[p1]
        p1++
        p2--
    }
}