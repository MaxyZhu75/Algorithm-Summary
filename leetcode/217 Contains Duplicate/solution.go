func containsDuplicate(nums []int) bool {
    hashRecord := make(map[int]int)
    for _, num := range nums {
        _, ok := hashRecord[num]
        if ok {
            return true
        } else {
            hashRecord[num] = 1  // ���üƾ�����ִ�����ֻ���ڵ�һ�γ���ʱ��Ǵ��ڼ��ɣ��ڶ��γ��ֻ�ֱ�ӷ���true������
        }
    }
    return false
}