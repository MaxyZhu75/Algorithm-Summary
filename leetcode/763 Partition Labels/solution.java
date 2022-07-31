class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26]; // �洢����ĸ���һ�γ��ֵ��±꣡����
        for (int i=0; i<s.length(); i++) {
            last[s.charAt(i)-'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0; // ��̬���µ�ǰ�εĿ�ʼ�ͽ����и�λ�ã�����
        for (int i=0; i<s.length(); i++) {
            end = Math.max(end, last[s.charAt(i)-'a']); // ÿ�μ����и��Ҫ��Ҫ���ƣ�����
            if (i == end) { // �и����������
                partition.add(end-start+1);
                start = end+1;
            }
        }
        return partition;
    }
}