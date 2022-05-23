class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null) { // case1：空链表；注意为了保持循环链表的性质需要指向自己！！！
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
		
        Node current = head;
        do {
            if(current.val <= insertVal) {
                if(current.next.val > insertVal) break; // case2：当前节点小于等于插入值，下个节点大于插入值！！！
                if(current.next.val < current.val)  break; // case3：插入值大于链表中的最大值！！！
            } else {
                if(current.next.val < current.val && insertVal < current.next.val) break; // case4：插入值小于链表中的最小值！！！
            }
            current = current.next;
        } while (current != head); // 此处用do-while先执行循环体使分类更合适！！！

        Node newNode = new Node(insertVal); // 插入新节点操作，插入到current之后！！！
        newNode.next = current.next; // case5：若循环无break正常退出，说明链表中所有值一样大！！！
        current.next = newNode;
        return head;
    }
}