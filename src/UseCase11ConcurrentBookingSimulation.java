import java.util.*;

class BookingQueue {
    private Queue<String> queue = new LinkedList<>();

    public synchronized void addRequest(String req) {
        queue.add(req);
    }

    public synchronized String getRequest() {
        return queue.poll();
    }
}

class ConcurrentBookingProcessor implements Runnable {
    private BookingQueue queue;

    public ConcurrentBookingProcessor(BookingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        String request;
        while ((request = queue.getRequest()) != null) {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " processed " + request);
            }
        }
    }
}

public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) {
        BookingQueue queue = new BookingQueue();

        queue.addRequest("Booking1");
        queue.addRequest("Booking2");

        Thread t1 = new Thread(new ConcurrentBookingProcessor(queue));
        Thread t2 = new Thread(new ConcurrentBookingProcessor(queue));

        t1.start();
        t2.start();
    }
}