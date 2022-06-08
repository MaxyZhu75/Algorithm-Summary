class Solution {
    public int[] topKFrequent(int[] nums, int k) { // 桶排序的经典实现！！！
        Map<Integer, Integer> hashRecord = new HashMap<>(); // 要点1：java.util.HashMap；统计每个元素的出现次数，形式即(元素，频率)！！！
        for (int num : nums) {
            hashRecord.put(num, hashRecord.getOrDefault(num, 0) + 1); // getOrDefault(key, default)+1；统计某个值出现的次数的固定写法！！！
        }
        
        List<Integer>[] buckets = new ArrayList[nums.length+1]; // 要点2：注意此处创建的是数组形式，然后每个位置拉出列表存储多个值（也就是所说的桶），将频率相同的元素放在一个桶内，形式即（频率，元素列表）！！！
        for (int num: hashRecord.keySet()) {
            int frequency = hashRecord.get(num);
            if (buckets[frequency] == null) { 
                List<Integer> listRecord = new ArrayList<>(); // 若为空则为该频率拉一个列表结构存储多个元素！！！
                buckets[frequency] = listRecord;
            }      
            buckets[frequency].add(num); // 此处buckets[frequency]为列表，列表添加元素要用List.add()！！！
        }

        List<Integer> topK = new ArrayList<>(); // 要点3：java.util.ArrayList；此处是利用List的几种方法来接收频率最高的k个元素，最后再传入数组返回结果！！！
        for (int i = buckets.length-1; i>=0 && topK.size()<k; i--) { // 由于buckets的索引表示频率，故此处使用倒叙遍历来找最大频率的k个元素！！！
            int remain = k-topK.size(); // topK只需要k个元素，用remain记录topK还需要添加多少个元素！！！
            if (buckets[i] == null) {
                continue;
            } else if (buckets[i].size() <= remain) {
                topK.addAll(buckets[i]); // case1：ArrayList.addAll()；添加集合中的所有元素到topK中！！！
            } else {
                topK.addAll(buckets[i].subList(0, remain-1)); // case2：ArrayList.subList()；只添加remain个元素，使topK大小刚好为k个元素！！！
            }
        }

        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            result[i] = topK.get(i);
        }
        return result;
    }
}