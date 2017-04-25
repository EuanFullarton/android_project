package example.codeclan.com.wagr;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user on 25/04/2017.
 */

public class BetList {

    private ArrayList<Bet> list;

    public BetList(){

        list = new ArrayList<Bet>();

    }

    public ArrayList<Bet> getBetList(){
        return new ArrayList<Bet>(list);
    }

    public ArrayList<Bet> addNewBet(int id, String new_user1, String new_user2, String new_details, Date new_resolvedOn, Date new_betPlacedOn, int new_stake ){
        Bet new_bet = new Bet(id, new_user1, new_user2, new_details, new_resolvedOn, new_betPlacedOn, new_stake);
        list.add(new_bet);
        return new ArrayList<Bet>(list);
    }
}
