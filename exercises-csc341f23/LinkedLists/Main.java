public class Main {

    public static void main(String[] args) {

        Linked list = new Linked();
        
        list.prepend("A");
        list.append("B");
        list.prepend("C");
        list.append("D");

        System.out.println("The linked list (in order) is:");
        System.out.println(list);
    }
}