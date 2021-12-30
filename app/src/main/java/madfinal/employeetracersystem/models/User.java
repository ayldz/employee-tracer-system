package madfinal.employeetracersystem.models;

import java.util.Random;
import java.util.UUID;

public class User {
    public UUID id;
    public String name;
    public String surname;
    public int SSN;
    public String telephoneNumber;
    public String email;
    public String address;
    public PositionName position;
    public float salary;

    //employees methods
    public void request(Request request, RequestType type){
        request.employyeeSSN = SSN;
        request.type = type;

        Requests.addRequest(request);
    }

    public void checkInOut(){

    }

    public float calculateSalary(){
        float newSalary = salary;
        for (Request request : Requests.findRequestByEmployee(SSN)){
            if (request.type == RequestType.ADVANCE_PAYMENT){
                newSalary -= request.amount;
            }
        }
        return newSalary;
    }

    //employers methods
    public void addUser(User user){
        if (this.position == PositionName.Employee){
            Users.addUser(user);
        }
    }

    public void approveRequest(int requestID){
        Requests.getRequest(requestID).isApproved = true;
    }
}
