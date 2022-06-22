class RandomizedSet {
    List<Integer> nums; // �б�洢 <num> ������
    Map<Integer, Integer> indexRecord; // ��ϣ��洢 <num, index> ������
    Random random;

    public RandomizedSet() { // ���췽��������
        this.nums = new ArrayList<>();
        this.indexRecord = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) { // ���뷽��������
        if (indexRecord.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indexRecord.put(val, index);
        return true;
    }

    public boolean remove(int val) { // ɾ������������
        if (!indexRecord.containsKey(val)) {
            return false;
        }
        int index = indexRecord.get(val); // ��ϸ�ڡ����б��ɾԪ�������һ��Ԫ�ؽ����洢λ�ã�Ȼ��ɾ���б�ĩβ������
        int lastElement = nums.get(nums.size()-1);
        nums.set(index, lastElement);
        indexRecord.put(lastElement, index);
        nums.remove(nums.size()-1);
        indexRecord.remove(val);
        return true;
    }

    public int getRandom() { // ȡ���Ԫ�أ�����
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