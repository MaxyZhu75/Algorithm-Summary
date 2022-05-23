func checkSubarraySum(nums []int, k int) bool { // ͬ�ඨ�� + ǰ׺�� + ��ϣ������
    n := len(nums)
    if n < 2 {
        return false
    }
    hashRecord := make(map[int]int) // �洢ÿ��������һ�γ��ֵ��±꣡����
    hashRecord[0] = -1
    remainder := 0
    for i:=0; i<n; i++ { // ͬ�ඨ������������� m �� n ���� n-m �ܱ� k ��������ô n �� m �� k ͬ�࣡����
        remainder = (remainder + nums[i]) % k // �˴�������ǰ׺�͵�˼�룬���˴�����ֻ���ĵ�ǰǰ׺�Ͷ�k������������
        preIndex, ok := hashRecord[remainder]
        if ok {
            if (i - preIndex) >= 2 {
                return true
            }
        } else {
            hashRecord[remainder] = i
        }
    }
    return false
}