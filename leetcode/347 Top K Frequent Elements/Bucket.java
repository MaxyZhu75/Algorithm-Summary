class Solution {
    public int[] topKFrequent(int[] nums, int k) { // Ͱ����ľ���ʵ�֣�����
        Map<Integer, Integer> hashRecord = new HashMap<>(); // Ҫ��1��java.util.HashMap��ͳ��ÿ��Ԫ�صĳ��ִ�������ʽ��(Ԫ�أ�Ƶ��)������
        for (int num : nums) {
            hashRecord.put(num, hashRecord.getOrDefault(num, 0) + 1); // getOrDefault(key, default)+1��ͳ��ĳ��ֵ���ֵĴ����Ĺ̶�д��������
        }
        
        List<Integer>[] buckets = new ArrayList[nums.length+1]; // Ҫ��2��ע��˴���������������ʽ��Ȼ��ÿ��λ�������б�洢���ֵ��Ҳ������˵��Ͱ������Ƶ����ͬ��Ԫ�ط���һ��Ͱ�ڣ���ʽ����Ƶ�ʣ�Ԫ���б�������
        for (int num: hashRecord.keySet()) {
            int frequency = hashRecord.get(num);
            if (buckets[frequency] == null) { 
                List<Integer> listRecord = new ArrayList<>(); // ��Ϊ����Ϊ��Ƶ����һ���б�ṹ�洢���Ԫ�أ�����
                buckets[frequency] = listRecord;
            }      
            buckets[frequency].add(num); // �˴�buckets[frequency]Ϊ�б��б����Ԫ��Ҫ��List.add()������
        }

        List<Integer> topK = new ArrayList<>(); // Ҫ��3��java.util.ArrayList���˴�������List�ļ��ַ���������Ƶ����ߵ�k��Ԫ�أ�����ٴ������鷵�ؽ��������
        for (int i = buckets.length-1; i>=0 && topK.size()<k; i--) { // ����buckets��������ʾƵ�ʣ��ʴ˴�ʹ�õ�������������Ƶ�ʵ�k��Ԫ�أ�����
            int remain = k-topK.size(); // topKֻ��Ҫk��Ԫ�أ���remain��¼topK����Ҫ��Ӷ��ٸ�Ԫ�أ�����
            if (buckets[i] == null) {
                continue;
            } else if (buckets[i].size() <= remain) {
                topK.addAll(buckets[i]); // case1��ArrayList.addAll()����Ӽ����е�����Ԫ�ص�topK�У�����
            } else {
                topK.addAll(buckets[i].subList(0, remain-1)); // case2��ArrayList.subList()��ֻ���remain��Ԫ�أ�ʹtopK��С�պ�Ϊk��Ԫ�أ�����
            }
        }

        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            result[i] = topK.get(i);
        }
        return result;
    }
}