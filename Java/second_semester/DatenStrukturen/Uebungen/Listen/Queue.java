package second_semester.DatenStrukturen.Uebungen.Listen;

public class Queue<E> extends FIFO_Queue<String> {

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.add("Test1");

        System.out.println(q);

    }

}
