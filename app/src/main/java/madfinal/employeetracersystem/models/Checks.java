package madfinal.employeetracersystem.models;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import madfinal.employeetracersystem.Logged;

public class Checks {
    private static ArrayList<Check> checks = new ArrayList<>();
    public static void addCheck(Check check){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> data = new HashMap<>();
        data.put("userSSN", Logged.user.SSN);
        data.put("checkinTime",check.checkinTime);
        data.put("checkoutTime", check.checkoutTime);

        db.collection("checks").add(data);
        checks.add(check);
    }

    public static void init(){

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("checks").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        Check check = new Check();
                        check.userSSN = (long) documentSnapshot.getData().get("userSSN");
                        check.checkinTime = (Timestamp) documentSnapshot.getData().get("checkinTime");
                        check.checkoutTime = (Timestamp) documentSnapshot.getData().get("checkoutTime");

                        checks.add(check);
                    }
                }
            }
        });


    }

    public static Check getCheck(long userSSN){
        for (Check check : checks){
            if (check.userSSN == userSSN) return check;
        }
        return null;
    }

   public static ArrayList<Check> getAllChecks(){
        return checks;
    }
}
