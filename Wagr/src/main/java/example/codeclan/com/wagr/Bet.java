package example.codeclan.com.wagr;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 20/04/2017.
 */

public class Bet {

    private int id;
    private String user1;
    private String user2;
    private String details;
    private Date resolvedOn;
    private Date betPlacedOn;
    private int stake;

    public Bet(){

    }

    public Bet (String user1, String user2, String details, Date resolvedOn, Date betPlacedOn, int stake){
        this.user1 = user1;
        this.user2 = user2;
        this.details = details;
        this.resolvedOn = resolvedOn;
        this.betPlacedOn = betPlacedOn;
        this.stake = stake;
    }

    public Bet (int id, String user1, String user2, String details, Date resolvedOn, Date betPlacedOn, int stake){
        this.id = id;
        this.user1 = user1;
        this.user2 = user2;
        this.details = details;
        this.resolvedOn = resolvedOn;
        this.betPlacedOn = betPlacedOn;
        this.stake = stake;
    }

    public int getId(){
        return id;
    }

    public String getUser1(){
        return user1;
    }

    public String getUser2(){
        return user2;
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

    public String getNiceDateFormat(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(date);
    }

    public Date getBetPlacedOn(){
        return betPlacedOn;
    }

    public Integer getStake(){
        return stake;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setUser1(String user1){
        this.user1 = user1;
    }

    public void setUser2(String user2){
        this.user2 = user2;
    }

    public void setDetails(String details){
        this.details = details;
    }

    public void setResolvedOn(Date resolvedOn){
        this.resolvedOn = resolvedOn;
    }

    public void setBetPlacedOn(Date betPlacedOn){
        this.betPlacedOn = betPlacedOn;
    }

    public void setStake(int stake){
        this.stake = stake;
    }

}
