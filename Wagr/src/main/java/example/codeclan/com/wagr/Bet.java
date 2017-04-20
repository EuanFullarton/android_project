package example.codeclan.com.wagr;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 20/04/2017.
 */

public class Bet {

    private String category;
    private String details;
    private Date resolvedOn;
    private int stake;

    public Bet (String category, String details, Date resolvedOn, Integer stake){
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

    public Date getResolvedOn(){
        return resolvedOn;
    }

    public String getNiceDateFormat() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(resolvedOn);
    }

    public Integer getStake(){
        return stake;
    }



}
