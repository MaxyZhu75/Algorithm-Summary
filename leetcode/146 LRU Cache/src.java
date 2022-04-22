public class LRUCache { // 方法二：哈希表+双向链表；手写简单LinkedHashMap底层实现！！！
    
	private Map<Integer, DoubleLinkedNode> hashRecord = new HashMap<>(); // 存储底层由手动创建HashMap实现；通过缓存数据的键映射到其在双向链表中的位置！！！
    private int size;
    private int capacity;
    private DoubleLinkedNode head, tail;
	class DoubleLinkedNode { // 双向链表按照被使用的顺序存储了这些键值对，靠近头部的键值对是最近使用的，而靠近尾部的键值对是最久未使用的！！！
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        public DoubleLinkedNode() {}
        public DoubleLinkedNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
    }

    public LRUCache(int capacity) { // 构造方法将类变量初始化！！！
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedNode(); // 节点的无参构造方法创建 dummy head 和 dummy tail ！！！
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = hashRecord.get(key); // 如果key存在，先通过哈希表定位！！！
        if (node == null) return -1;
        moveToHead(node); // 移动到双向链表头部；靠近头部的键值对是最近使用的！！！
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = hashRecord.get(key); // 如果key存在，先通过哈希表定位！！！
        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value); // 如果key不存在，创建一个新的节点！！！
            hashRecord.put(key, newNode); // 添加进哈希表！！！
            addToHead(newNode); // 添加到双向链表的头部；靠近头部的键值对是最近使用的！！！
            if (++size > capacity) {
                DoubleLinkedNode tail = removeTail(); // 如果超出容量，移除双向链表的尾部节点！！！
                hashRecord.remove(tail.key); // 根据该节点的key删除哈希表中对应的项！！！
                size--;
            }
        } else {
            node.value = value; // 仅需修改value，并移动到双向链表头部！！！
            moveToHead(node);
        }
    }

    private void addToHead(DoubleLinkedNode node) { // 添加到双向链表的头部！！！
        node.prev = head; // 先将node的指针连接好！！！
        node.next = head.next;
        head.next.prev = node; // 再将前后的指针指向node！！！
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) { // 移除双向链表中的某一节点！！！
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DoubleLinkedNode node) { // 移动到双向链表头部；先移除该节点再添加至双向链表头部！！！
        removeNode(node);
        addToHead(node);
    }

    private DoubleLinkedNode removeTail() { // 移除 dummy tail 的前一个节点，并返回该节点！！！
        DoubleLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */