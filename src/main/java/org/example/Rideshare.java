package org.example;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

//Exclusive ride share app whereby you choose driver + car you want to driven in

class Trip{
    String driver_name;
    String license_plate;
    boolean is_available;


    Trip(String driver_name,String license_plate,boolean is_available){
        this.license_plate = license_plate;
        this.driver_name = driver_name;
        this.is_available = is_available;
    }

    void assigndriver(){
        if(is_available){
            System.out.println("Driver " + driver_name + "is picking you up");
            is_available = false;
        }else{
            System.out.println(driver_name + " is currently busy. Try another driver...");
        }
    }

    void complete_ride(){
        System.out.println("Driver " + driver_name + " has completed the ride");
    }

    void payment_type(String type){
//        .equals better string comparison than ==
        if (type.equalsIgnoreCase("cash")){
            System.out.println("Exact change not guaranteed. Please have correct fare ready.");
        }else{
            System.out.println("Please enter banking details");
        }
    }

    double calc_fare(double distance){
        double fare = Math.round(distance * 3.50);
        return fare;
    }

}

class Uber extends Trip{
    String quality;

    Uber(String driver_name,String license_plate,boolean is_available, String quality){
        super(driver_name,license_plate,is_available);
        this.quality = quality;
    }

//    Getting current time
    LocalTime currentTime = LocalTime.now();
    LocalTime TenPM = LocalTime.of(22, 00);
    LocalTime fourThirtyAM = LocalTime.of(4, 30);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    String formattedTime = currentTime.format(formatter);

    String[] excuses = {"Rain","Traffic","None","Complex Route"};
    int excuse = (int)(Math.random() * excuses.length);


    @Override
    void assigndriver(){
        if (currentTime.isAfter(TenPM) || currentTime.isBefore(fourThirtyAM)){
            System.out.println("Ubers take longer around this time...Please be patient.");
        }else{
            if(is_available){
                System.out.println("Driver " + driver_name + " is picking you up  in a Uber with plate number: " + license_plate);
                is_available = false;
            } else if (!is_available) {
                System.out.println(driver_name + " is currently busy. Try another driver...");
            }

        }
    }

    @Override
    void complete_ride() {
        super.complete_ride();
    }

    void payment_type(){

    }

    @Override
    double calc_fare(double distance) {
        double fare = 0;
        System.out.println(excuses[excuse]);
        if (excuses[excuse].equals("None")){
            fare = distance * 2.00;
            System.out.println("Fare: R" + fare);

        } else if (excuses[excuse].equals("Rain")) {
            System.out.println("Fare: R" + super.calc_fare(distance));
        } else if (excuses[excuse].equals("Traffic")) {
            System.out.println("Fare: R" + super.calc_fare(distance));

        } else if (quality.equals("F")){
            System.out.println("Grade F Vehicle. Fare siginificantly reduced :)");
            fare = distance;
            System.out.println("Fare: R" + fare);

        }
        else if (excuses[excuse].equals("Complex Route")) {
            System.out.println("Fare: R" + super.calc_fare(distance));
        }
        return fare;

    }
}

class Taxi extends Trip{
//    Metered fares, Taxi Fullness, Fullness would be dynamically entered by druver side logic
//    Suggest Taxi Ranks near location,dumbed down google maps
    int fullness;

    Taxi(String driver_name,String license_plate,boolean is_available,int fullness){
        super(driver_name,license_plate,is_available);
        this.fullness = fullness;
    }

    LocalTime currentTime = LocalTime.now();
    LocalTime eightThirtyPM = LocalTime.of(20, 30);
    LocalTime fourThirtyAM = LocalTime.of(4, 30);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    String formattedTime = currentTime.format(formatter);


    @Override
    void assigndriver(){
//        If fullness is at full capacity, throw suggestions of drivers with less fullness
        if (currentTime.isAfter(eightThirtyPM) || currentTime.isBefore(fourThirtyAM)){
            System.out.println("No taxis available. Try an uber");
        }else{
            if(is_available){
                System.out.println("Driver " + driver_name + " is picking you up  in a Uber with plate number: " + license_plate);
                is_available = false;
            } else if (!is_available) {
                System.out.println(driver_name + " is currently busy. Try another driver...");
            }

        }
    }

//    @Override
    void calc_fare(){
//        Must be less than uber

    }

    void rank(){
//        Even more random generation?
//        Better = Real-time location system
//        Advanced = Integrating google maps API

    }


}

class Luxury{

}
public class Rideshare {

    public static void main(String[] args){
//        Client side so client focused
        ArrayList<Uber> ubers = new ArrayList<>();
        ubers.add(new Uber("Bheki","ML 88 VJ GP",true,"C"));
        ubers.add(new Uber("Lwazi","TZ 34 ED GP",true,"F"));
        ubers.add(new Uber("Cameron","FB 19 GG GP",false,"B"));
        ubers.add(new Uber("Jabulani","MM 20 FW GP",true,"A"));
        ubers.add(new Uber("GodKnows","KJ 32 LH GP",false,"B"));

        ArrayList<Taxi> taxis = new ArrayList<>();
       taxis.add(new Taxi("Solomon","JH 23 HG GP",true,4));
       taxis.add(new Taxi("Gideon","LY 87 WS GP",true,12));
       taxis.add(new Taxi("Mohammed","BH 10 JD GP",false,9));
       taxis.add(new Taxi("Victor","IP 87 WS GP",true,2));
       taxis.add(new Taxi("Overcome","EK 49 EH GP",false,7));
        Scanner input = new Scanner(System.in);
        System.out.println("Choose Ride Type:\n1.Uber\n2.Taxi\n3.Luxury");
        int index = (int) (Math.random() * ubers.size());

        if(input.nextInt() == 1){
            System.out.println("Enter distance: ");
            double distance = input.nextDouble();
            if (ubers.get(index).is_available){
                ubers.get(index).assigndriver();
                ubers.get(index).calc_fare(distance);
                ubers.get(index).complete_ride();
                ubers.get(index).is_available = true;
            }else{
                ubers.get(index).assigndriver();
            }

        }

    }

}
