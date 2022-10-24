public class Ejercicio3_15<E> {
    private static class Node<E> {
        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        public E getElement( ) { return element; }
        public Node<E> getNext( ) { return next; }
        public void setNext(Node<E> n) { next = n; }
    }
    // instance variables of the CircularlyLinkedList
    private Node<E> tail = null; // we store tail (but not head)
    private int size = 0; // number of nodes in the list
    public Ejercicio3_15( ) { } // constructs an initially empty list
    public boolean equals(Ejercicio3_15<E> listb){
        Node<E> temp1 = tail.getNext();
        Node<E> temp2 = listb.tail.getNext();
        int count =0;
        if(size != listb.size()){
            return false;
        }
        else{
            while(count < size){
                if(temp1.element != temp2.element)
                return false;
            }
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }
        return true;
    }
    // access methods
    public int size( ) { 
        int result = 0;
        if(tail != null){
            Node<E> temp = new Node<>(null, tail.getNext());
            while(temp != tail){
                result++;
                temp = temp.getNext();
            }
        }
        return result; 
    }
    public boolean isEmpty( ) { return size == 0; }
    public E first( ) { // returns (but does not remove) the first element
        if (isEmpty( )) return null;
        return tail.getNext( ).getElement( ); // the head is *after* the tail
    }
    public E last( ) { // returns (but does not remove) the last element
        if (isEmpty( )) return null;
        return tail.getElement( );
    }
    // update methods
    public void rotate( ) { // rotate the first element to the back of the list
        if (tail != null) // if empty, do nothing
        tail = tail.getNext( ); // the old head becomes the new tail
    }
    public void addFirst(E e) { // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // link to itself circularly
        } else {
            tail.setNext(new Node<>(e, tail.getNext()));
        }
        size++;
    }
    public void addLast(E e) { // adds element e to the end of the list
        addFirst(e); // insert new element at front of list
        tail = tail.getNext( ); // now new element becomes the tail
    }
    public E removeFirst( ) { // removes and returns the first element
        if (isEmpty( )) return null; // nothing to remove
        Node<E> head = tail.getNext( );
        if (head == tail) tail = null; // must be the only node left
        else tail.setNext(head.getNext( )); // removes ”head” from the list
        size--;
        return head.getElement( );
    }
}