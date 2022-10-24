

public class Ejercicio3_6 {

    // head of the list
    Node head;
    // Class to create an object of Node
    class Node {
        // contains data in the Node
        int data;
        // Contains the pointer to the next element
        Node next;
        Node(int d)
        {
            data = d;
            next =null;
        }
    }
    // Function to get the Second last node of a linked list
    void printSecondFromLast(){
        // Point a temp variable to the head node of linked list for traversal
        // to find the second last node, because if we directly use head
        // Node for traversal, we will lose the reference of head node
        // Ex: Linked list = (head)11->7->2->4->null
        // head = head.next, Linked list = (head)7->2->4->null
        Node temp = head;
        // Check if the Linked list has zero node, i.e. the head node is null
        if(temp ==null)
            // Since there is no node in the linked list, so there will be no
            // second last node, so display "No node in linked list"
            System.out.println("No node in linked list");
            // Check if the Linked list has zero node,
            // The node next to head is null, Ex: Linked_list = (head)11->null
        else if(temp.next ==null)
            // Since there is only 1 node in the linked list, so there will
            // be no 2nd last node, so display "Only one node in linked list"
            System.out.println("Only one node in linked list");
            // If there are more than one node in linked list
            // Ex: Linked_list = (head)11->7->2->4->null
        else{
            // traverse the linked list till the second last node
            // Ex: Linked list = (head)11->7->2->4->null
            // for iteration = 1, temp = 11, temp.next.next = 2 (not null)
            //                    temp = temp.next = 7
            // for iteration = 2, temp = 7, temp.next.next = 4 (not null)
            //                    temp = temp.next = 2
            // for iteration = 3, temp = 2, temp.next.next = null
            //                    second last node
            while(temp.next.next !=null){
                // traverse the linked list as explained above
                temp = temp.next;
            }
                // Display the data on the second last node
                // Ex: Linked list = (head)11->7->2->4->null, Display(2)
                System.out.println(temp.data);
        }
    }
  
    // Inserts a new Node at front of the list
    public void push(int new_data){
        // Allocate a new_node with the given data
        Node new_node =new Node(new_data);
        // Make the next element of the new node as head of the linked list
        // Ex: Linked list = (head)2->4->null
        // new_node = 7, now Linked list = 7->(head)2->4->null
        new_node.next = head;
        // Move the head to point to new Node
        // Ex: Linked list = 7->(head)2->4->null
        // Now, Linked list = (head)7->2->4
        head = new_node;
    }
  
    // Driver program to test above methods 
    public static void main(String [] args){
        // Create an object of class LinkedList
        Ejercicio3_6 llist =new Ejercicio3_6();
        // push 4 in linked list, Linked list = (head)4->null
        llist.push(4);
        // push 2 in linked list, Linked list = (head)2->4->null
        llist.push(2);
        // push 7 in linked list, Linked list = (head)7->2->4->null
        llist.push(7);
        // push 11 in linked list, Linked list = (head)11->7->2->4->null
        llist.push(11);
        // Call the method to print the second last element
        llist.printSecondFromLast();
    }
}