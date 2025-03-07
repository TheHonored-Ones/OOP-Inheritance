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
        System.out.println("Driver " + driver_name + "has completed the ride");
    }

    void payment_type(String type){
//        .equals better string comparison than ==
        if (type.equalsIgnoreCase("cash")){
            System.out.println("Exact change not guaranteed. Please have correct fare ready.");
        }else{
            System.out.println("Please enter banking details");
        }
    }

    void calc_fare(double distance){
        double fare = distance * 3.50;
        System.out.println("Your fare is R" + fare);
    }

}

class Taxi extends Trip{
    String quality;

    Taxi(String driver_name,String license_plate,boolean is_available, String quality){
        super(driver_name,license_plate,is_available);
        this.quality = quality;
    }

//    Getting current time
    LocalTime currentTime = LocalTime.now();
    LocalTime eightThirtyPM = LocalTime.of(20, 30);
    LocalTime fourThirtyAM = LocalTime.of(4, 30);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    String formattedTime = currentTime.format(formatter);

    String[] excuses = {"Complex route","Traffic","F","None"};
    int excuse = (int)(Math.random() * excuses.length);

    @Override
    void assigndriver(){
        if (currentTime.isAfter(eightThirtyPM) || currentTime.isBefore(fourThirtyAM)){
            System.out.println("No taxis available. Try an uber");
        }else{
            if(is_available){
                System.out.println("Driver " + driver_name + " is picking you up  in a Taxi with plate number: " + license_plate);
                is_available = false;
            } else if (!is_available) {
                System.out.println(driver_name + " is currently busy. Try another driver...");
            }

        }
    }

    @Override
    void calc_fare(double distance) {
        double fare = 0;
        if (excuses[excuse].equals("None")){
            fare = distance * 2.25;
        } else if (excuses[excuse].equals("Complex Route")) {
            super.calc_fare(distance);
        } else if (excuses[excuse].equals("Traffic")) {
            super.calc_fare(distance);
        } else if (quality.equals('F')){
            fare = distance;
        }

        System.out.println("Fare: " + fare);
    }
}
public class Rideshare {

    public static void main(String[] args){
//        Client side so client focused
        ArrayList<Taxi> taxis = new ArrayList<>();
        taxis.add(new Taxi("Bheki","ML 88 VJ GP",true,"C"));
        taxis.add(new Taxi("Lwazi","TZ 34 ED GP",true,"F"));
        taxis.add(new Taxi("Cameron","FB 19 GG GP",false,"B"));
        taxis.add(new Taxi("Jabulani","MM 20 FW GP",true,"A"));
        taxis.add(new Taxi("GodKnows","KJ 32 LH GP",false,"B"));

        Scanner input = new Scanner(System.in);
        System.out.println("Choose Ride Type:\n1.Taxi\n2.Uber\n3.Luxury");
        int index = (int) (Math.random() * taxis.size());

        if(input.nextInt() == 1){
            System.out.println("Enter distance: ");
            double distance = input.nextDouble();
            taxis.get(index).assigndriver();
            taxis.get(index).calc_fare(distance);
        }

    }

}
