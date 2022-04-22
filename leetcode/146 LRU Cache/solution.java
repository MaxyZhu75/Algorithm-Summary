class LRUCache extends LinkedHashMap<Integer, Integer>{ // 方法一：使用Java封装的LinkedHashMap实现；具体参考官方解答与源码分析帖子！！！
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true); // LinkedHashMap源码构造方法 public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) ！！！
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1); // super可以用于两种途径，一是调用父类的构造方法super(参数)，二是调用父类的方法super.方法名(参数)！！！
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) { // 见afterNodeInsertion方法的源码；通过复写removeEldestEntry方法可实现不同策略的缓存，源码中默认返回false！！！
        return size() > capacity; 
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */