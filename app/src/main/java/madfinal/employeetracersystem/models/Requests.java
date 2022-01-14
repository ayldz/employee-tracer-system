package madfinal.employeetracersystem.models;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Requests {
    private static ArrayList<Request> requests = new ArrayList<>();

    private static boolean isInit = false;

    public static void init()    {
        //TODO: firebase integration

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("requests").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        Request request = new Request();
                        request.employyeeSSN = (long) documentSnapshot.getData().get("employeeSSN");
                        request.type = RequestType.valueOf((String) documentSnapshot.getData().get("type"));
                        request.isApproved = (Boolean) documentSnapshot.getData().get("isApproved");
                        request.amount = (long) documentSnapshot.getData().get("amount");
                        request.excuse = (String) documentSnapshot.getData().get("excuse");
                        request.startDate = (Timestamp) documentSnapshot.getData().get("startDate");
                        request.endDate = (Timestamp) documentSnapshot.getData().get("endDate");

                        requests.add(request);
                    }
                }
            }
        });


//        Request request = new Request();
//        request.isApproved = false;
//        request.type = RequestType.ADVANCE_PAYMENT;
//        request.excuse = "asdasd";
//        request.amount = 480f;
//        request.employyeeSSN = 180709029;
//
//        requests.add(request);
//
//        Request request2 = new Request();
//        request2.isApproved = false;
//        request2.type = RequestType.ADVANCE_PAYMENT;
//        request2.excuse = "asdasd";
//        request2.amount = 546f;
//        request2.employyeeSSN = 180709029;
//
//        requests.add(request2);
//
//        Request request3 = new Request();
//        request3.isApproved = false;
//        request3.type = RequestType.ADVANCE_PAYMENT;
//        request3.excuse = "asdasd";
//        request3.amount = 586f;
//        request3.employyeeSSN = 180709029;
//
//        requests.add(request3);
//
//        Request request4 = new Request();
//        request4.isApproved = false;
//        request4.type = RequestType.PERMIT_DAY;
//        request4.excuse = "asdasd";
//        request4.startDate = new Timestamp( new Date().getTime());
//        request4.endDate = new Timestamp(new Date().getTime());
//
//        request4.employyeeSSN = 180709029;
//
//        requests.add(request4);

        isInit = true;
    }

    public static void addRequest(Request request){
        if (!isInit) init();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> data = new HashMap<>();
        data.put("employeeSSN", request.employyeeSSN);
        data.put("type", request.type);
        data.put("isApproved", request.isApproved);
        data.put("amount", request.amount);
        data.put("excuse", request.excuse);
        data.put("startDate", request.startDate);
        data.put("endDate", request.endDate);

        db.collection("requests").add(data);

        requests.add(request);
    }

    public static Request getRequest(int requestID){
        return requests.get(requestID);
    }

    public static List<Request> findRequestByEmployee(long employeeSSN) {
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

    public static ArrayList<Request> getAllRequests(){
        return requests;
    }
}