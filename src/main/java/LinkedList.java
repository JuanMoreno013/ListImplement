
public class LinkedList<E> implements List<E> {

    class Node {
       public E data;
       public Node nextNode;
       public Node(E data, Node nextNode) { this.data = data; this.nextNode = nextNode;}
        public Node(E data){this.data = data; this.nextNode = null;}

        public Node() {}
    }


    private Node headNode = null; //head node of the linked list
    private Node tail = null;
   // private Node last;
    public int size;      //size of the list
    private int tailP;

    public LinkedList (){
        headNode = null;
//        size = 0;
    }


    void nNode(E data){

        Node new_node = new Node(data);
//        new_node = headNode;
        headNode= new_node;
    }


    @Override
    public void add(E data) {
        Node new_node = new Node(data);
//        new_node = headNode;

        if(headNode==null)               //If list is empty, both head and tail will point to new node
        {
            tail = new_node;
            headNode= new_node;
        }
        else {
           tail.nextNode = new_node; //newNode will be added after tail such that tail's next will point to newNode
            tail= new_node;               //newNode will become new tail of the list
        }

        tailP++;   //increase "index" tail
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        checkSize(index,size);

        int i = 0;
        Node temp = headNode;
        while (i < index) {
            temp = temp.nextNode;
            i++;
        }
        return temp.data;
    }

    @Override
    public boolean contains(Object item) {

        boolean cont=false;
        Node temp = headNode;
//
        if (!(item ==null))
        {
            while (temp != null) {
                if(item.equals(temp.data))
                {
                    cont= true;
                    break;
                }
                temp=temp.nextNode;
            }
        }
        else
            throw new NullPointerException();
        return cont;
    }

    @Override
    public void checkSize(int index, int size) {

        if (size < index || index < 0)
            throw new IndexOutOfBoundsException();
    }

    @Override
    public void remove(int index) {
        checkSize(index,size);

        if (index == 0) {
            headNode = headNode.nextNode;
//            headNode = temp.nextNode; // Changed head
            tailP--;
            size--;
            return;
        }

        int i = 0;
        Node temp = headNode;
        while (i < index - 1) {  //Search 'index' for delete and keep it, the prev node going to change to temp
            temp = temp.nextNode;
            i++;
        }
        temp.nextNode = temp.nextNode.nextNode;
        size--;   //decrease the size
        tailP--;
    }


    private void print(){
        Node tnode = headNode;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.nextNode;
        }
        System.out.println(" \n ");
    }

    @Override
    public void remove(E item) {

        Node temp = headNode, prev = tail;

        int i= 0;
        if ( item!= null )
        {
            for (; i < size; i++) {
//                if (item.equals(headNode.nextNode))
                if (item.equals(temp.data))
                    break;
                temp = temp.nextNode;
            }
        } else {
            throw new NullPointerException(" The item are null ");
        }
        remove(i);
    }

    @Override
    public void clear() {

        for (int i = 0; i<size; i++){
            headNode= null;
            tail=null;
        }
        size = 0;
        tailP =0;
    }



    public static void main(String[] args) {
        LinkedList<String> arr = new LinkedList<>();

        String b2 = new String("pop");
        String b1 = new String("look");


        arr.add(b1);
        arr.add("1");
//        arr.add(b1);
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.add("5");
//        arr.add(b1);
//        arr.add("6");
//        arr.add("7");
//        arr.add("8");
//        arr.add("9");
//        arr.add("10");
//        arr.add("11");
//        arr.add("12");
        arr.add(b2);

        System.out.println( arr.contains("30") );
//
        arr.print();
        arr.remove(3);
        arr.print();

        System.out.println(arr.get(0));
        arr.remove(b2);
        arr.print();

        arr.remove(b1);
        arr.print();

        arr.clear();
        System.out.println("--------");
        arr.print();

    }

}
