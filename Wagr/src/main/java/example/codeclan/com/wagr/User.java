package example.codeclan.com.wagr;

/**
 * Created by user on 20/04/2017.
 */

public class User {

    private int id;
    private String name;

    public User(){

    }

    public User( String name) {
        this.name = name;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
