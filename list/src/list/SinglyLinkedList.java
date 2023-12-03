package list;


public class SinglyLinkedList {
    Node first, last; int size;
    public SinglyLinkedList(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }


    public int size(){
        return this.size;
    }


    public void add(Object element){
        Node node = new Node(element);
        if (size() == 0){
            this.first = node;
            this.last = node;
        }else{
            this.last.next = node;
            this.last = node;
        }
        this.size += 1;
    }


    public String toString(){
        StringBuilder builder = new StringBuilder();
        Node value = this.first;
        while(value != null){
            builder.append(value.data.toString());
            value = value.next;
            if (value != null){
                builder.append(", ");
            }
            }  
        return builder.toString();
    }


    public void insert(Object element, int position){
        Node newNode = new Node(element);
        Node oldNode = this.first;
        if (position == 0){
            newNode.next = this.first;  
            this.first = newNode;     
            this.size += 1;
            return;
        }else if((position > size()) || (position < 0)){
            exception();
        }
        for (int i = 0; (i < (position - 1));i++){
            oldNode = oldNode.next;
        }
        newNode.next = oldNode.next;
        oldNode.next = newNode;
        this.size += 1;

    }  

    private static void exception(){
        System.out.println("Index out of bounds");
        System.exit(1);
    }


    public Object get(int index){
        if (index == 0){
            return this.first.data;
        }else if(index > size()){
            return "Out of bounds";
        }
        Node currentData = this.first; 
        for (int i = 0; i < index; i++){
            currentData = currentData.next;
        }
        return currentData.data;
    }


    public void remove(int position){
        Node oldNode = this.first;
        if (position == 0){
            this.first = oldNode.next;
            this.size -= 1;
            return;
        }
        for(int i = 0; i < position -1;i++){
            oldNode = oldNode.next;
        }
        Node newNode = oldNode.next;
        oldNode.next = newNode.next;
        this.size -= 1;
    }


    public void set(Object element, int position){
        Node oldNode = this.first;

        if(position == 0){
            this.first.data  = element;
            return;
        }
        for (int i = 0; i < position; i++){
            oldNode = oldNode.next;
        }
        oldNode.data = element;
    }
}