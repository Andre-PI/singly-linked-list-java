package list;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.set(7, 2);
        System.out.println(list.get(8));
        System.out.println(list.toString());
    }
}
