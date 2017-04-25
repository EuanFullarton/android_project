package example.codeclan.com.wagr;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class BetTest {

    Bet bet;

    @Before
    public void before(){
        bet = new Bet(1, "Euan", "Greig", "Arsenal to win league", new Date(117,9,10), new Date(), 25);
    }

    @Test
    public void hasUser1(){
        assertEquals("Euan", bet.getUser1());
    }

    @Test
    public void hasUser2(){
        assertEquals("Greig", bet.getUser2());
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

    @Test
    public void hasId(){
        assertEquals(1, bet.getId());
    }

    @Test
    public void testSetId(){
        bet.setId(2);
        assertEquals(2, bet.getId());
    }

    @Test
    public void testSetUser1(){
        bet.setUser1("Percy");
        assertEquals("Percy", bet.getUser1());
    }

    @Test
    public void testSetUser2(){
        bet.setUser2("Jim");
        assertEquals("Jim", bet.getUser2());
    }

    @Test
    public void testSetDetails(){
        bet.setDetails("Sunderland to be relegated");
        assertEquals("Sunderland to be relegated", bet.getDetails());
    }

    @Test
    public void testSetStake(){
        bet.setStake(50);
        assertEquals(50, (int)bet.getStake());
    }


}
