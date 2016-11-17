// Insert header here
package assignment6;

import java.util.*;
import java.lang.Thread;

import assignment6.Theater.Seat;
import assignment6.Theater.Ticket;

public class BookingClient {

    private static int idCounter = 1;
    private final Object lock = new Object();
    private final Object printLock = new Object();
    private HashMap<String, Integer> office;
    private Theater theater;
    private boolean soldOut = false;

    /*
    * @param office maps box office id to number of customers in line
    * @param theater the theater where the show is playing
    */
    public BookingClient(Map<String, Integer> office, Theater theater) {
        this.office = (HashMap<String, Integer>) office;
        this.theater = theater;
    }

    public static void main(String[] args) {
        Theater theater = new Theater(3, 5, "Ouija");

        HashMap<String, Integer> office = new HashMap<>();
        office.put("BX1", 3);
        office.put("BX3", 3);
        office.put("BX2", 4);
        office.put("BX5", 3);
        office.put("BX4", 3);
        BookingClient bc = new BookingClient(office, theater);
        bc.simulate();
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
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Integer value = entry.getValue();
                    String entryKey = entry.getKey();
                    int i = 0;
                    while (i < value) {
                        synchronized (printLock) {
                            if (soldOut) {
                                return;
                            }
                        }

                        Ticket newTicket;
                        synchronized (lock) {
                            Seat newSeat;
                            newSeat = theater.bestAvailableSeat();
                            newTicket = theater.printTicket(entryKey, newSeat, idCounter);


                            idCounter++;
                        }
                        synchronized (printLock) {
                            if (newTicket != null) {
                                theater.getTransactionLog().add(newTicket);
                            } else {
                                if (!soldOut) {
                                    System.out.println("Sorry, we are sold out.");
                                    soldOut = true;
                                }
                                return;
                            }
                            try {
                                Thread.sleep(300);
                            } catch (Exception e) {
                            }
                        }


                        i++;
                    }
                }
            });
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        return threadList;
    }

}
