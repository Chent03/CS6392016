package chent03.cs639firebase;

/**
 * Created by Tony on 7/11/16.
 */
public class User {
    private String idnumber;
    private String name;


    public User(){}

    public User(String idnumber, String name){
        this.idnumber = idnumber;
        this.name = name;
    }

    public  String getId(){
        return idnumber;
    }

    public String getName(){
        return name;
    }


}
