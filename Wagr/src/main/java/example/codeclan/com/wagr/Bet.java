package example.codeclan.com.wagr;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 20/04/2017.
 */

public class Bet {

    private String details;
    private Date resolvedOn;
    private Date betPlacedOn;
    private int stake;

    public Bet (String details, Date resolvedOn, Date betPlacedOn, Integer stake){
        this.details = details;
        this.resolvedOn = resolvedOn;
        this.betPlacedOn = betPlacedOn;
        this.stake = stake;
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

    public Date getBetPlacedOn(){
        return betPlacedOn;
    }

    public Integer getStake(){
        return stake;
    }

}
