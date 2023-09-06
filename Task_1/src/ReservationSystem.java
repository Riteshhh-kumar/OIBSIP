import java.util.HashMap;

public class ReservationSystem {
    HashMap<Integer,Ticket> list = new HashMap<>();

    int count =123;
    HashMap<Integer, String> trains = new HashMap<>();
    ReservationSystem(){
        trains.put(count,"HELLO");
        count++;
    }


    static class Ticket{
        private String name;
        private String to;
        private String trainName;
        private int trainNumber;
        private String from;
        private String date;
        private int age;
        private String gender;
    }
    public void  buyTicket(String name, int age, String gender, String from, String to, String date, String trainName, int trainNumber, String classType){
        Ticket t = new Ticket();


    }

    public void  cancelTicket(int pnr){
        if(list.containsKey(pnr)){
            list.remove(pnr);
        }


    }

    public void addTrain(int number,String name){
        ReservationSystem r = new ReservationSystem();
        r.trains.put(number,name);
    }

}
