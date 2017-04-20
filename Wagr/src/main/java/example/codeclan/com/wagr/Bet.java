package example.codeclan.com.wagr;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 20/04/2017.
 */

public class Bet {

    private String category;
    private String details;
    private String resolvedOn;
    private int stake;

    public Bet (String category, String details, String resolvedOn, Integer stake){
        this.category = category;
        this.details = details;
        this.resolvedOn = resolvedOn;
        this.stake = stake;
    }

    public String getCategory(){
        return category;
    }

    public String getDetails(){
        return details;
    }

    public String getResolvedOn(){
        return resolvedOn;
    }

    public Integer getStake(){
        return stake;
    }



}
