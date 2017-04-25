package example.codeclan.com.wagr;

import java.util.ArrayList;

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

    public ArrayList<Bet> addNewBet(int id, String new_user_name){
        User new_user = new User(id, new_user_name);
        list.add(new_user);
        return new ArrayList<User>(list);
    }

}
