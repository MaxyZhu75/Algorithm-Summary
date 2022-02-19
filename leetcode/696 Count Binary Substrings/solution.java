class Solution { // �ռ��Ż��汾���Go���Դ𰸣�����
    public int countBinarySubstrings(String s) { // Ҫ��һ�����ַ�����ͳ�ƣ�����
        int n = s.length();
        List<Integer> record = new ArrayList<>();
        char group = s.charAt(0); // ��ǰ�����ַ�������
        int count = 1;
        for (int i=1; i<n; i++) {
            if (s.charAt(i) == group) {
                count++;
            } else {
                record.add(count);
                group = s.charAt(i);
                count = 1;
            }
        }

        record.add(count); // Ҫ�����ѭ��δ�����һ���¼�����ڴ˴����ϣ�����

        int result = 0;
        for (int i=0; i<record.size()-1; i++) { // Ҫ������record�����ڵ������ͬ�ַ�������resultʱ��������ĿҪ����Ӵ�����Ӧ�õ����������н϶̵ĵ���һ��ĳ��ȣ����������⣩������
            result += Math.min(record.get(i), record.get(i+1));
        }

        return result;
    }
}