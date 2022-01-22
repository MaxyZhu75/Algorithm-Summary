func containsNearbyDuplicate(nums []int, k int) bool { // ����һ����ͨ��ϣ����������
    var n int = len(nums)
    hashRecord := make (map[int]int)
    for i:=0; i<n; i++ {
        maxIndex, ok := hashRecord[nums[i]] // ��Ϥ�ó���д��������
        if ok {
            abs := i-maxIndex // ��Ȼ��������Ϊ��������ͬԪ�ص���������ֵС��k�����������ǰ�����˳����С������ֵ��ͬ������Ԫ��ÿ��ѭ�����¼��ǰ�������������ܱ�֤nums[maxIndex]����ӽ�nums[i]��ֵ��ͬ������Ԫ�أ�����
            if abs <= k {
                return true
            }
        } 
        hashRecord[nums[i]] = i // ÿ��ѭ������󶼱������ֵΪnums[i]��Ԫ�ص������������Ϊi��������
    }
    return false
}