class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null) { // case1��������ע��Ϊ�˱���ѭ�������������Ҫָ���Լ�������
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
		
        Node current = head;
        do {
            if(current.val <= insertVal) {
                if(current.next.val > insertVal) break; // case2����ǰ�ڵ�С�ڵ��ڲ���ֵ���¸��ڵ���ڲ���ֵ������
                if(current.next.val < current.val)  break; // case3������ֵ���������е����ֵ������
            } else {
                if(current.next.val < current.val && insertVal < current.next.val) break; // case4������ֵС�������е���Сֵ������
            }
            current = current.next;
        } while (current != head); // �˴���do-while��ִ��ѭ����ʹ��������ʣ�����

        Node newNode = new Node(insertVal); // �����½ڵ���������뵽current֮�󣡣���
        newNode.next = current.next; // case5����ѭ����break�����˳���˵������������ֵһ���󣡣���
        current.next = newNode;
        return head;
    }
}