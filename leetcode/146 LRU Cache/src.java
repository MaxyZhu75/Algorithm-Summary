public class LRUCache { // ����������ϣ��+˫��������д��LinkedHashMap�ײ�ʵ�֣�����
    
	private Map<Integer, DoubleLinkedNode> hashRecord = new HashMap<>(); // �洢�ײ����ֶ�����HashMapʵ�֣�ͨ���������ݵļ�ӳ�䵽����˫�������е�λ�ã�����
    private int size;
    private int capacity;
    private DoubleLinkedNode head, tail;
	class DoubleLinkedNode { // ˫�������ձ�ʹ�õ�˳��洢����Щ��ֵ�ԣ�����ͷ���ļ�ֵ�������ʹ�õģ�������β���ļ�ֵ�������δʹ�õģ�����
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

    public LRUCache(int capacity) { // ���췽�����������ʼ��������
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleLinkedNode(); // �ڵ���޲ι��췽������ dummy head �� dummy tail ������
        tail = new DoubleLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DoubleLinkedNode node = hashRecord.get(key); // ���key���ڣ���ͨ����ϣ��λ������
        if (node == null) return -1;
        moveToHead(node); // �ƶ���˫������ͷ��������ͷ���ļ�ֵ�������ʹ�õģ�����
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = hashRecord.get(key); // ���key���ڣ���ͨ����ϣ��λ������
        if (node == null) {
            DoubleLinkedNode newNode = new DoubleLinkedNode(key, value); // ���key�����ڣ�����һ���µĽڵ㣡����
            hashRecord.put(key, newNode); // ��ӽ���ϣ������
            addToHead(newNode); // ��ӵ�˫�������ͷ��������ͷ���ļ�ֵ�������ʹ�õģ�����
            if (++size > capacity) {
                DoubleLinkedNode tail = removeTail(); // ��������������Ƴ�˫�������β���ڵ㣡����
                hashRecord.remove(tail.key); // ���ݸýڵ��keyɾ����ϣ���ж�Ӧ�������
                size--;
            }
        } else {
            node.value = value; // �����޸�value�����ƶ���˫������ͷ��������
            moveToHead(node);
        }
    }

    private void addToHead(DoubleLinkedNode node) { // ��ӵ�˫�������ͷ��������
        node.prev = head; // �Ƚ�node��ָ�����Ӻã�����
        node.next = head.next;
        head.next.prev = node; // �ٽ�ǰ���ָ��ָ��node������
        head.next = node;
    }

    private void removeNode(DoubleLinkedNode node) { // �Ƴ�˫�������е�ĳһ�ڵ㣡����
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DoubleLinkedNode node) { // �ƶ���˫������ͷ�������Ƴ��ýڵ��������˫������ͷ��������
        removeNode(node);
        addToHead(node);
    }

    private DoubleLinkedNode removeTail() { // �Ƴ� dummy tail ��ǰһ���ڵ㣬�����ظýڵ㣡����
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