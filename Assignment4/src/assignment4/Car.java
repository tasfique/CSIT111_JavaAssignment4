//Student's Full name: Tasfique Enam
//Student's ID: 5886429
//Modification Date: 24/06/17
//Purpose of this file: Car class
package assignment4;

public class Car { //attributes.
    private String regnum;
    private String model;
    private String make;
    private int rate;
    private boolean status;
    
  
     public Car(String regnum, String model, String make, int rate, boolean status){
        this.regnum= regnum;
        this.model = model;
        this.make = make;
        this.rate = rate;
        this.status = status;
    }
    String getRegnum(){
        return regnum;
    }
    
    String getModel(){
        return model;
    }
    
    String getMake(){
        return make;
    }
    
    int getRate(){
        return rate;
    }
    
    boolean getStatus(){
        return status;
    }
    
    public void ChangeStatus(){
        if (status == false){
            status = true;
        }
        else if (status == true){
            status = false;
        }
    }
}
