import java.util.HashMap;

class Ticket{


     String name;
     String to;
     String trainName;
     int trainNumber;
     String from;
     String date;
     int age;
     String gender;
     String classType;
}
public class ReservationSystem {
     public static HashMap<Integer,Ticket> list = new HashMap<>();
    int Pnr = 234567891;

    int count =123;
    HashMap<Integer, String> trains = new HashMap<>();
    ReservationSystem(){
        trains.put( 10001, "Train1" );
        trains.put( 10002, "Train2" );
        trains.put( 10003, "Train3" );
        trains.put( 10004, "Train4" );
        trains.put( 10005, "Train5" );
        trains.put( 10006, "Train6" );
        trains.put( 10007, "Train7" );
        trains.put( 10008, "Train8" );
        trains.put( 10009, "Train9" );
        trains.put( 10010, "Train10" );
    }



    public int  buyTicket(String name, int age, String gender, String from, String to, String date, String trainName, int trainNumber, String classType){
        Ticket t = new Ticket();
        t.name = name;
        t.gender = gender;
        t.age = age;
        t.date = date;
        t.to = to;
        t.from = from;
        t.trainName = trainName;
        t.trainNumber = trainNumber;
        t.classType = classType;
        this.Pnr+=1;
        this.list.putIfAbsent(this.Pnr,t);



        return this.Pnr;



    }

    public static void  cancelTicket(int pnr){
        if(list.containsKey(pnr)){
            list.remove(pnr);
        }


    }



}

class Users{
    public static HashMap<String,String> userList = new HashMap<>();
    Users(){
        this.userList.put("User1","Password1");
        this.userList.put("User2","Password2");
        this.userList.put("User3","Password3");
        this.userList.put("User4","Password4");
    }


}
