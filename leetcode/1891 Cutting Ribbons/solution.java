class Solution {
    public int maxLength(int[] ribbons, int k) { // ���ֲ��ң�����
        int low = 1, high = 1;
        int result = 0;
        for (int ribbon : ribbons) {
            high = Math.max(ribbon, high);
        }
        while (low <= high){ // ��ѭ���ڲ���Ԫ�أ���result��¼��ǰ���������Ľ��������
            int mid = (high-low)/2 + low;
            if (check(ribbons, k, mid)){
                result = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return result;
    }

    private boolean check(int[] ribbons, int k, int length){ // �ж��Ƿ��ܹ��г�k�������ϳ���Ϊlength�����ӣ�����
        int count = 0;
        for (int ribbon : ribbons) {
            count += ribbon/length;
        }
        return count >= k;
    }
}