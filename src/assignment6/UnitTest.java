package assignment6;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class UnitTest {
    @Test
    public void SeatToStringTest(){
        assertEquals("A1", new Theater.Seat(1,1).toString());
        assertEquals("E109", new Theater.Seat(5,109).toString());
    }

    @Test
    public void TicketToStringTest(){
        assertEquals(   "-------------------------------\n" +
                        "| Show: Bobosaa               |\n" +
                        "| Box Office ID: BX2          |\n" +
                        "| Seat: A1                    |\n" +
                        "| Client: 7                   |\n" +
                        "-------------------------------",
                new Theater.Ticket("Bobosaa", "BX2", new Theater.Seat(1,1), 7).toString());
        assertEquals(   "-------------------------------\n" +
                        "| Show: In The Wind           |\n" +
                        "| Box Office ID: BX33         |\n" +
                        "| Seat: AA13                  |\n" +
                        "| Client: 79                  |\n" +
                        "-------------------------------",
                new Theater.Ticket("In The Wind", "BX33", new Theater.Seat(27,13), 79).toString());
        assertEquals(   "-------------------------------\n" +
                        "| Show: Ouija                 |\n" +
                        "| Box Office ID: BX1          |\n" +
                        "| Seat: D104                  |\n" +
                        "| Client: 4                   |\n" +
                        "-------------------------------",
                new Theater.Ticket("Ouija", "BX1", new Theater.Seat(4,104), 4).toString());
    }

    @Test
    public void TestSimulate(){
        // create a Theater: {3 rows, 5 seats per row, show: “Ouija"}
        Theater theater = new Theater(100, 100, "Ouija");

        // create BookingClient: {BX1=3, BX3=3, BX2=4, BX5=3, BX4=3}
        HashMap<String,Integer> office = new HashMap<String,Integer>();
        office.put("BX1", 2500);
        office.put("BX3", 2499);
        office.put("BX2", 2501);
        office.put("BX5", 3333);
        office.put("BX4", 344);
        BookingClient bc = new BookingClient(office, theater);

        // begin simulation
        List<Thread> threadList = bc.simulate();
        assertEquals(5, threadList.size());
    }
}
