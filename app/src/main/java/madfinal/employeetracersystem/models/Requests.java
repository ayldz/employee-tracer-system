package madfinal.employeetracersystem.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Requests {
    private static List<Request> requests = new ArrayList<>();

    private static boolean isInit = false;

    public static void init()    {
        //TODO: firebase integration
        isInit = true;
    }

    public static void addRequest(Request request){
        if (!isInit) init();

        requests.add(request);
    }

    public static Request getRequest(int requestID){
        return requests.get(requestID);
    }

    public static List<Request> findRequestByEmployee(int employeeSSN) {
        List<Request> requestsByEmployee = new ArrayList<>();
        for (Request request : requests){
            if (request.employyeeSSN == employeeSSN) requestsByEmployee.add(request);
        }
        return requestsByEmployee;
    }

    public static List<Request> showRequests(RequestType type){
        if (!isInit) init();

        List<Request> showReq = new ArrayList<>();
        for (Request item : requests) {
            if (item.type == type){
                showReq.add(item);
            }
        }
        return showReq;
    }
}