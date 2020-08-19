//Student's Full name: Tasfique Enam
//Student's ID: 5886429
//Modification Date: 24/06/17
//Purpose of this file: Main class
package assignment4;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
     private static ArrayList<Rental> rental = new ArrayList<Rental>(); //creation of arraylist
     private static HashMap <String, Car> car = new HashMap <String, Car> (); //creation of hashmap
     //private static Iterator<Rental> itr = rental.iterator();
     private static String filename; 
     private static Scanner read2 = new Scanner(System.in);
    
     public static void main(String[]args) throws IOException{  
        
         //loading files.
        filename = "data.txt";
        File creating = new File(filename);
        Scanner read = new Scanner (creating);
        
        
       //Car object2 = new Car(null, null, null, 0, false);
      
       //reading the text file and assigning the text to the variables
        while(read.hasNext()){
        String regnum = read.nextLine();
        String model = read.nextLine();
        String make = read.nextLine();
        int rate = Integer.parseInt(read.nextLine());
        boolean status = Boolean.parseBoolean(read.nextLine());
        Car cars = new Car(regnum, model, make, rate, status);
        car.put(regnum, cars);
        }      
       
        int option; 
      
        do{
            System.out.print("*******************\n" + //display menu
                     "1. Rent a Car\n" +
                     "2. Return a Car\n" +
                     "3. Display Information\n"+
                     "4. Quit\n" +
                     "*********************\n" +
                     "Please the enter the number '1' '2' '3' '4' :");
            option = read2.nextInt();
            
            switch(option){
            case 1: RentCar();
            break;
            case 2: ReturnCar();
            break;
            case 3: Display();
            break;
            case 4: option = 0;
            break;
            default:  System.out.println("Invalid Number Entered. ");
        }
                    
        }while (option!=0);
        
        
    }
     //rent a car method
     public static void RentCar(){
         Scanner read2 = new Scanner (System.in);
         String regnum=null;
         
      
         Car ObjRent = null;
         
         do{
             System.out.println("Enter the Registration Number of the car. "); //asking for reg number
             regnum = read2.nextLine();
             ObjRent = car.get(regnum); // creating an object
             
             if (ObjRent == null){ //if an invalid reg num is entered
                 System.out.println("You have entered an invalid Registration Number ");
                 
             } else if(ObjRent.getStatus() == false){ //if car is not available as in being rented.
                 System.out.println("The car is not available. ");
                 
             } else {
             System.out.println("Enter the name of the person "); //if the car is available it will ask for customer's details
             String name = read2.nextLine();
             System.out.println("Enter the Identity of the person ");
             String identity = read2.nextLine();
             System.out.println("Enter the Start Date D/MM/YYYY ");
             String startdate = read2.nextLine();
             System.out.println("Enter the number of days ");
             int days = read2.nextInt();
             rental.add(new Rental(name, identity, regnum, startdate, days));
             }
             
         } while(ObjRent == null || ObjRent.getStatus() == false );
          ObjRent.ChangeStatus();
     }
     
     public static void ReturnCar(){ //return car method
         Scanner read2 = new Scanner (System.in);
         Car ObjReturn = null; // creating an object.
         do{
             System.out.println("Enter car registration number "); //asking for registration number.
             String regnum = read2.next();
             ObjReturn = car.get(regnum);
             Iterator<Rental> itr = rental.iterator();
             while(itr.hasNext()) {
                 Rental returncar = itr.next();
                 if(returncar.getCarReg().equalsIgnoreCase(regnum)){
                     itr.remove();
                 }else{
                     System.out.println("Invalid Car Registration number."); //if invalid reg num is entered.
                 }
             }
         } while(ObjReturn == null);
         ObjReturn.ChangeStatus();
         System.out.println( "Done. ");
     }
    
     public static void Display(){ //display method.
         int choiceentry;
         Scanner read2 = new Scanner(System.in);
         do{
             System.out.println();        //display of menu
             System.out.println("1. All Cars information ");
             System.out.println("2. All rental records ");
             System.out.println("3. Specific rental information ");
             System.out.println("0. To go back ");
             System.out.println();
             System.out.println("Please enter the number from your selection ");
             choiceentry = read2.nextInt();
             switch(choiceentry){
                 case 1: // for option it displays all car info
                    System.out.printf("%-15.15s %-15.15s %-30.30s %-15.15s %-15.15s%n", "Make","Model","Registration Number","Rental Rate ","Avaibility");
                    for (Map.Entry<String,Car> info : car.entrySet()){
                        
                        System.out.printf("%-15.15s %-15.15s %-30.30s %-15.15s %-15.15s%n"
                        ,info.getValue().getMake()
                        ,info.getValue().getModel(),info.getValue().getRegnum()
                        ,info.getValue().getRate()
                        ,info.getValue().getStatus());
                    } 
                    System.out.println();
                    System.out.println();
                    break;
                    
                 case 2: //for case 2 it displays rental records.
                     System.out.printf("%-15.15s %-15.15s %-30.30s %-15.15s %-15.15s%n", "Name","ID","Registration Number","Rental Date ","Duration");
                     for(Rental customers : rental ){
                         System.out.printf("%-15.15s %-15.15s %-30.30s %-15.15s %-15.15s%n"
                        ,customers.getName()
                        ,customers.getIdentity()
                        ,customers.getCarReg()
                        ,customers.getStartDate()
                        ,customers.getDays());
                     }
                    System.out.println();
                    System.out.println();
                    break;
                    
                 case 3: //it shows specific rental info
                     System.out.println("Enter the Registration Number ");
                     String regnum = read2.next();
                     System.out.println("");
                     Iterator<Rental> itr = rental.iterator();
                     boolean status = false;
                     
                     while(itr.hasNext()){
                         Rental customers = itr.next();
                         if(customers.getCarReg().equalsIgnoreCase(regnum)){
                             status = true;
                             System.out.printf("%-15.15s %-15.15s %-30.30s %-15.15s %-15.15s%n", "Name","ID","Registration Number","Rental Date ","Duration");
                             System.out.printf("%-15.15s %-15.15s %-30.30s %-15.15s %-15.15s%n"
                        ,customers.getName()
                        ,customers.getIdentity()
                        ,customers.getCarReg()
                        ,customers.getStartDate()
                        ,customers.getDays());
                         }
                     }
                     if(status == false) {
                    System.out.println("No Record Found!");
                         System.out.println("");
                     }
                     break;
                     default:  System.out.println("Invalid Number Entered. ");
                     
             }
         }while(choiceentry!=0);
     }
}
