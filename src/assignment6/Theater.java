// insert header here
package assignment6;

import java.util.*;

public class Theater {
    private final Object lock = new Object();
    private int rows;
    private int seatsPerRow;
    private String showName;
    private boolean seats[][];
    private ArrayList<Ticket> log;
    public Theater(int numRows, int seatsPerRow, String show) {
        this.rows = numRows;
        this.seatsPerRow = seatsPerRow;
        this.showName = show;
        synchronized (lock) {
            this.seats = new boolean[numRows][seatsPerRow];
            this.log = new ArrayList<>();
        }
    }

    /*
     * Calculates the best seat not yet reserved
     *
      * @return the best seat or null if theater is full
   */
    public Seat bestAvailableSeat() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                if (!seats[i][j]) {
                    seats[i][j] = true;
                    Seat seat = new Seat(i + 1, j + 1);
                    return seat;
                }
            }
        }
        return null;
    }

    /*
     * Prints a ticket for the client after they reserve a seat
   * Also prints the ticket to the console
     *
   * @param seat a particular seat in the theater
   * @return a ticket or null if a box office failed to reserve the seat
   */
    public Ticket printTicket(String boxOfficeId, Seat seat, int client) {
        if (seat != null) {
            Ticket newTicket = new Ticket(showName, boxOfficeId, seat, client);
            System.out.println(newTicket.toString());
            return newTicket;
        } else {
            return null;
        }
    }

    /*
     * Lists all tickets sold for this theater in order of purchase
     *
   * @return list of tickets sold
   */
    public List<Ticket> getTransactionLog() {
        return log;
    }

    /*
     * Represents a seat in the theater
     * A1, A2, A3, ... B1, B2, B3 ...
     */
    static class Seat {
        private int rowNum;
        private int seatNum;

        public Seat(int rowNum, int seatNum) {
            this.rowNum = rowNum;
            this.seatNum = seatNum;
        }

        public static String getAlpha(int num) {

            String result = "";
            while (num > 0) {
                num--;
                int remainder = num % 26;
                char digit = (char) (remainder + 65);
                result = digit + result;
                num = (num - remainder) / 26;
            }

            return result;
        }

        public int getSeatNum() {
            return seatNum;
        }

        public int getRowNum() {
            return rowNum;
        }

        @Override
        public String toString() {
            String row = getAlpha(rowNum);
            return (row + seatNum);
        }
    }

    /*
       * Represents a ticket purchased by a client
       */
    static class Ticket {
        private String show;
        private String boxOfficeId;
        private Seat seat;
        private int client;

        public Ticket(String show, String boxOfficeId, Seat seat, int client) {
            this.show = show;
            this.boxOfficeId = boxOfficeId;
            this.seat = seat;
            this.client = client;
        }

        public Seat getSeat() {
            return seat;
        }

        public String getShow() {
            return show;
        }

        public String getBoxOfficeId() {
            return boxOfficeId;
        }

        public int getClient() {
            return client;
        }

        @Override
        public String toString() {
            String hor = "-------------------------------";
            int numOfChar = hor.length();

            String l1 = "| Show: " + show;
            while (l1.length() < numOfChar - 1) {
                l1 += " ";
            }
            l1 += "|";

            String l2 = "| Box Office ID: " + boxOfficeId;
            while (l2.length() < numOfChar - 1) {
                l2 += " ";
            }
            l2 += "|";

            String l3 = "| Seat: " + seat.toString();
            while (l3.length() < numOfChar - 1) {
                l3 += " ";
            }
            l3 += "|";

            String l4 = "| Client: " + client;
            while (l4.length() < numOfChar - 1) {
                l4 += " ";
            }
            l4 += "|";

            return hor + "\n" +
                    l1 + "\n" +
                    l2 + "\n" +
                    l3 + "\n" +
                    l4 + "\n" +
                    hor;
        }
    }
}
