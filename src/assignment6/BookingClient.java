// Insert header here
package assignment6;

import java.util.*;
import java.lang.Thread;

import assignment6.Theater.Seat;
import assignment6.Theater.Ticket;

public class BookingClient {
    public int printDelay = 800;

    private static int clientIdCounter;
    private HashMap<String, Integer> office;
    private Theater theater;
    private boolean soldOut;
    private final Object lock = new Object();
    private final Object printLock = new Object();

    /*
    * @param office maps box office id to number of customers in line
    * @param theater the theater where the show is playing
    */
    public BookingClient(Map<String, Integer> office, Theater theater) {
        clientIdCounter = 1;
        soldOut = false;
        this.office = (HashMap<String, Integer>) office;
        this.theater = theater;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> offices = new HashMap<>();
        offices.put("BX1", 3);
        offices.put("BX3", 3);
        offices.put("BX2", 4);
        offices.put("BX5", 3);
        offices.put("BX4", 3);
        Theater theater = new Theater(3, 5, "Ouija");
        BookingClient client = new BookingClient(offices, theater);
        client.simulate();
    }

    /*
     * Starts the box office simulation by creating (and starting) threads
     * for each box office to sell tickets for the given theater
     *
     * @return list of threads used in the simulation,
     *         should have as many threads as there are box offices
     */
    public List<Thread> simulate() {
        List<Thread> threadList = new ArrayList();

        Iterator<Map.Entry<String, Integer>> itr = office.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<String, Integer> entry = itr.next();
            Thread thread = new Thread(() -> {
                Integer value = entry.getValue();
                String entryKey = entry.getKey();
                int i = 0;
                while (i < value) {
                    synchronized (printLock) {
                        if (soldOut) {
                            return;
                        }
                        try {
                            Thread.sleep(printDelay);
                        } catch (Exception e) { }
                    }

                    Ticket newTicket;
                    synchronized (lock) {
                        Seat newSeat;
                        newSeat = theater.bestAvailableSeat();
                        newTicket = theater.printTicket(entryKey, newSeat, clientIdCounter);
                        clientIdCounter++;
                    }
                    synchronized (printLock) {
                        if (newTicket == null) {
                            if (!soldOut) {
                                System.out.println("Sorry, we are sold out.");
                                soldOut = true;
                            }
                            return;
                        }
                    }

                    i++;
                }
            });
            threadList.add(thread);
            thread.start();
        }
        return threadList;
    }

}
