class RandomizedSet {
    List<Integer> nums; // 列表存储 <num> ！！！
    Map<Integer, Integer> indexRecord; // 哈希表存储 <num, index> ！！！
    Random random;

    public RandomizedSet() { // 构造方法！！！
        this.nums = new ArrayList<>();
        this.indexRecord = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) { // 插入方法！！！
        if (indexRecord.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indexRecord.put(val, index);
        return true;
    }

    public boolean remove(int val) { // 删除方法！！！
        if (!indexRecord.containsKey(val)) {
            return false;
        }
        int index = indexRecord.get(val); // 「细节」：列表待删元素与最后一个元素交换存储位置，然后删除列表末尾！！！
        int lastElement = nums.get(nums.size()-1);
        nums.set(index, lastElement);
        indexRecord.put(lastElement, index);
        nums.remove(nums.size()-1);
        indexRecord.remove(val);
        return true;
    }

    public int getRandom() { // 取随机元素！！！
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */