package madfinal.employeetracersystem.models;

import android.util.Log;

import java.sql.Timestamp;
import java.util.Date;
import java.util.EventListener;
import java.util.UUID;

import madfinal.employeetracersystem.Logged;

public class User {

    public long SSN;
    public String name;
    public String surname;
    public String telephoneNumber;
    public String email;
    public String address;
    public PositionName position;
    public long salary;

    //employees methods
    public void request(Request request, RequestType type){
        request.employyeeSSN = SSN;
        request.type = type;

        Requests.addRequest(request);
    }

   /* public void checkInOut(boolean isIN){
        if (isIN) {
            Check check = Checks.getCheck(SSN);
            check.checkoutTime = new Timestamp(new Date().getTime());
        }
        else {
            Check check = new Check();
            check.userSSN = SSN;
            check.checkinTime = new Timestamp(new Date().getTime());
        }

    }*/

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
