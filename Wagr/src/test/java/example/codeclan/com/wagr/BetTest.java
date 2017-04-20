package example.codeclan.com.wagr;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class BetTest {

    Bet bet;

    @Before
    public void before(){

        bet = new Bet("Football", "Arsenal to win league", new Date(117,9,10), new Date(), 25);

    }

    @Test
    public void hasCategory(){
        assertEquals("Football", bet.getCategory());
    }

    @Test
    public void hasDetails(){
        assertEquals("Arsenal to win league", bet.getDetails());
    }

    @Test
    public void hasResolvedOn(){
        assertEquals("10/10/2017", bet.getNiceDateFormat());
    }

    @Test
    public void hasBetPlacedOn(){
        assertEquals(new Date(), bet.getBetPlacedOn());
    }

    @Test
    public void hasStake(){
        assertEquals(25, (int)bet.getStake());
    }


}
