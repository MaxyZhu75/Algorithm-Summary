class LRUCache extends LinkedHashMap<Integer, Integer>{ // ����һ��ʹ��Java��װ��LinkedHashMapʵ�֣�����ο��ٷ������Դ��������ӣ�����
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true); // LinkedHashMapԴ�빹�췽�� public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) ������
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1); // super������������;����һ�ǵ��ø���Ĺ��췽��super(����)�����ǵ��ø���ķ���super.������(����)������
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) { // ��afterNodeInsertion������Դ�룻ͨ����дremoveEldestEntry������ʵ�ֲ�ͬ���ԵĻ��棬Դ����Ĭ�Ϸ���false������
        return size() > capacity; 
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */