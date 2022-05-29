class Solution { // ���ף����Ѱ�ҹ��̻��ظ���Σ���ÿ��Ѱ�ҵĵ��ʲ�ͬ�������ά��һ����ϣ���¼ÿ�����ʵ��±��б�Ȼ��˫ָ����������������ʵ��±���������
    public int findClosest(String[] words, String word1, String word2) { // �����ռ�һ�α���������
        int n = words.length;
        int result = n;
        int previous1 = -1, previous2 = -1; // ��¼�Ѿ������ĵ����У����һ�γ��ֵ�word1��word2���±꣡����
        for (int i=0; i<n; i++) {
            if (words[i].equals(word1)) { // case1������word1������previous1��ֵ������
                previous1 = i;
            } else if (words[i].equals(word2)) { // case2������word2������previous2��ֵ������
                previous2 = i;
            }
            if (previous1 >= 0 && previous2 >= 0) { // ÿ��ѭ������Ҫ����result������
                result = Math.min(result, Math.abs(previous1 - previous2));
            }
        }
        return result;
    }
}