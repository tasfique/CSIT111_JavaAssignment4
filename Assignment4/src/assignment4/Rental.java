//Student's Full name: Tasfique Enam
//Student's ID: 5886429
//Modification Date: 24/06/17
//Purpose of this file: rental class
package assignment4;

public class Rental {
    private String name;
    private String identity;
    private String CarReg;
    private String StartDate;
    private int Days;
    
    public Rental(){ //default constructor 
        name = "";
        identity = "";
        CarReg = "";
        StartDate = "";
        Days = 0;
    }
    
    public Rental(String name, String identity, String CarReg, String StartDate, int Days){ //non default
        this.name= name;
        this.identity = identity;
        this.StartDate = StartDate;
        this.Days = Days;
        this.CarReg = CarReg;
    }
    String getName(){ //get method.
        return name;
    }
    
    String getIdentity(){
        return identity;
    }
    
    String getCarReg(){
        return CarReg;
    }
    
    String getStartDate(){
        return StartDate;
    }
    
    int getDays(){
        return Days;
    }
    
    public static String method()
    {
        return "no param";
    }
    public static String method(String n)
    {
        return "with param";
    }
    

   
}
