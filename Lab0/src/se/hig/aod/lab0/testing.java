package se.hig.aod.lab0;

public class testing {
    
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        
        System.out.println(list.isEmpty());
        
    }

}
