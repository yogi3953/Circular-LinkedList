package QueueByCircularLinkedList;
import java.util.Scanner;
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
class QueueUsingCircularLinkedList
{
    Node tail=null;
    public void insertionAtFront(int data)
    {
        Node newNode=new Node(data);
        if(tail==null)
        {
            tail=newNode;
            newNode.next=tail;
        }
        else{
        newNode.next=tail.next;
        tail.next=newNode;
        // System.out.println(data);
        }
    }
    public void insertionAtEnd(int data)
    {
        Node newNode=new Node(data);
        if(tail==null)
        {
            tail=newNode;
            newNode.next=tail;
        }
        else{
            newNode.next=tail.next;
            tail.next=newNode;
            tail=newNode;
        }
    }
    public Node deletionAtFront(Node tail)
    {
        if (tail == null) {
            System.out.println("No data to delete :(");
        }
        Node current=tail.next;
        System.out.println("The Element which will be deleted is:"+current.data);
        tail.next=current.next; //you can skip this line by replacing with next line. 
        //tail.next = current ;

       return tail; 
    }
    public Node deletionAtEnd(Node tail)
    {
        if (tail == null) {
            System.out.println("No data to delete :(");
            return tail;
        }
        else{
            Node current=tail.next;
            System.out.println(current.data);
            while(current.next!=tail)
            {
                current=current.next;
            }
            System.out.println(current.data);
            current.next=tail.next;
            tail=current;
            // tail.next=current.next;
        }
        
       return tail; 
    }
    public void tailNode()
    {
        if(tail==null)
        {
            System.out.println("No data to peek :(");
        }
        else
        System.out.println("Tail is "+tail.data);

    }
    public void display()
    {
        if(tail==null)
        {
            System.out.println("No data");
            return ;
        }
        Node current=tail.next;
        do
        {
            System.out.print(current.data+" >> ");
            current=current.next;
        }while(current!=tail.next);
        System.out.println();
    }
}
class Main
{
    public static void main(String[]args)
    {
        QueueUsingCircularLinkedList qcl=new QueueUsingCircularLinkedList();
        Scanner sc=new Scanner(System.in);
        boolean CHOOSE=true;
        while(CHOOSE)
        {   
                       
            
                        System.out.println("What Operations Do you want to perform on Queue?");
                        System.out.println("1.Insertion at Front :)");
                        System.out.println("2.Insertion at End :)");
                        System.out.println("3.Deletion at Front :(");
                        System.out.println("4.Deletion at End :(");
                        System.out.println("5.Find out TAIL :)");
                        System.out.println("6.Display List :)");
                        System.out.println("7.EXIT :)");

                        int queueOP=sc.nextInt();
                        int data;
                    switch(queueOP)
                        {
                            case 1:
                                    System.out.print("Enter the data to Insert :");
                                    data=sc.nextInt();
                                    qcl.insertionAtFront(data);
                                    break;
                            case 2:
                                    System.out.print("Enter the data to Insert:");
                                    data=sc.nextInt();
                                    qcl.insertionAtEnd(data);
                                    break;
                            case 3:
                                    qcl.tail=qcl.deletionAtFront(qcl.tail);
                                    break;
                            case 4:
                                    System.out.println("The Element which will be deleted is:"+qcl.tail.data);
                                    qcl.tail=qcl.deletionAtEnd(qcl.tail);
                                    break;
                            case 5:
                                    qcl.tailNode();
                                    break;
                            case 6:
                                    System.out.print("The Present List is as:");
                                    qcl.display();
                                    break;
                            case 7:
                                    System.out.print("Exiting...");
                                    sc.close();
                                    CHOOSE=false;
                                    break;
                            default:
                                    
                                    System.out.println("Invalid Options....Try Again!!");
                                    sc.close();
                                    
                        }
            }
            }            
        }