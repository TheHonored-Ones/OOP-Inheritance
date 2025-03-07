package org.example;

import java.util.Objects;
import java.util.Scanner;

class Employee{
    String name;
    int id;

    Employee(String name,int id){
        this.name = name;
        this.id = id;
    }
    int randomnum = (int) (Math.random() * 5001);

    void generateID(){
        System.out.println("Title: " + name);
        System.out.println("Title-" + randomnum );
    }
}

class Doctor extends Employee{
    String specialization;

    String[] diagnoses = {"Flu", "Migraines", "Diabetes", "Food Poisoning", "Common Cold", "a baby","Gout","High blood pressure"};
    int index = (int) (Math.random() * diagnoses.length);

    Doctor(String name, int id, String specialization){
        super(name,id);
        this.specialization = specialization;
    }

    @Override
    void generateID(){
        System.out.println("Dr: " + name);
        System.out.println("Dr-" + id );
    }
    void diagnose(){
        System.out.println("Diagnosis: The patient has " + diagnoses[index]);
    }
}

class Nurse extends Employee{
    String rank;

    String[] help = {"IV drip","Blood work","Pregnancy test","Prevention procedure","Bathe"};
    int index = (int) (Math.random() * help.length);

    Nurse(String name, int id, String rank){
        super(name,id);
        this.rank = rank;

    }

    @Override
    void generateID(){
        System.out.println(rank + ": " + name);
        System.out.println(rank + ": " + id );
    }
    void administer_help(){
        System.out.println("The patient needs: " + help[index]);
    }
}

class Receptionist extends Employee{
    String[] admin = {"Filing","Registering a new patient","Discharging a patient","Handling medical aid", "Check-in"};
    int index = (int) (Math.random() * admin.length);

//    Super can only be called in Consructor body
    Receptionist(String name, int id){
        super(name,id);
    }

    @Override
    void generateID(){
        System.out.println("Miss/Mrs: " + name);
        System.out.println("ID: " + id);
    }
    String admin(){
        if(admin[index] == "Check-in"){
            System.out.println("You may see the nurse");
        }else{
            System.out.println("The receptionist on duty is " + admin[index]);
        }

        return admin[index];
    }
}

public class HospitalSystem {

    public static void main(String[] args){

        int id = (int) (Math.random() * 5001);
        String[] names = {"Macele","Thobile","Emily","Angelina","Pertunia","William"};
        int index = (int) (Math.random() * names.length);



        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Please start at the receptionist.");
        Receptionist receptionist = new Receptionist(names[index],id);
        receptionist.generateID();
        receptionist.admin();

        String[] nurseRanks = {"Registered Nurse (RN)", "Enrolled Nurse (EN)", "Enrolled Nursing Auxiliary (ENA)"};
        int index_ = (int) (Math.random() * nurseRanks.length);

        String[] prescriptions = {
                "Painkillers (e.g., Paracetamol, Ibuprofen)",
                "Antibiotics (e.g., Amoxicillin, Azithromycin)",
                "Antidepressants (e.g., Sertraline, Fluoxetine)",
                "Allergy medication (e.g., Antihistamines, EpiPen)",
                "Blood pressure medication (e.g., Amlodipine, Lisinopril)",
                "Diabetes medication (e.g., Metformin, Insulin)",
                "Asthma inhalers (e.g., Salbutamol, Budesonide)",
                "Cough syrup (e.g., Dextromethorphan, Codeine-based syrups)"
        };

        int index_prescriptions = (int) (Math.random() * prescriptions.length);
        if(Objects.equals(receptionist.admin(), "Check-in")){
            Nurse nurse = new Nurse(names[index],id,nurseRanks[index_]);
            nurse.generateID();
            nurse.administer_help();
            Doctor doctor = new Doctor(names[index],id,prescriptions[index_prescriptions]);
            doctor.generateID();
            doctor.diagnose();
        }
    }

}
