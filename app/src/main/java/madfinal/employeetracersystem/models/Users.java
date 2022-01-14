package madfinal.employeetracersystem.models;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public  class Users {
    private static ArrayList<User> users = new ArrayList<>();

    private static boolean isInit = false;

    public static void init()    {

        //TODO: firebase integration
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        User user = new User();
                        user.SSN = (Long) documentSnapshot.getData().get("ssn");
                        user.name = (String) documentSnapshot.getData().get("name");
                        user.surname = (String) documentSnapshot.getData().get("surname");
                        user.telephoneNumber = (String) documentSnapshot.getData().get("telephoneNumber");
                        user.email = (String) documentSnapshot.getData().get("email");
                        user.address = (String) documentSnapshot.getData().get("address");
                        user.position =PositionName.valueOf((String) documentSnapshot.getData().get("position"));
                        user.salary = (Long) documentSnapshot.getData().get("salary");
                        users.add(user);
                    }
                }
            }
        });

        /*User user = new User();
        user.SSN = 180709019;
        user.position = PositionName.Employer;
        user.telephoneNumber = "5315924501";
        user.address = "mentese/ mugla";
        user.salary = 3000;
        user.name = "Alperen";
        user.surname = "Ayyıldız";

        users.add(user);

        User user2 = new User();
        user2.SSN = 180709029;
        user2.position = PositionName.Employee;
        user2.telephoneNumber = "5315924501";
        user2.address = "mentese/ mugla";
        user2.salary = 3000;
        user2.name = "Zehra";
        user2.surname = "Rıdvanoğulları";

        users.add(user2);*/

        isInit = true;
    }

    public static void addUser(User user){
        if (!isInit) init();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> data = new HashMap<>();
        data.put("ssn", user.SSN);
        data.put("name", user.name);
        data.put("surname", user.surname);
        data.put("telephoneNumber", user.telephoneNumber);
        data.put("email", user.email);
        data.put("address", user.address);
        data.put("position",  user.position);
        data.put("salary", user.salary);

        db.collection("users").add(data);
        users.add(user);
    }

    public static User getUser(long SSN){
        if (!isInit) init();

        for (User item : users){
            if (item.SSN == SSN) return item;
        }
        return null;
    }

    public static ArrayList<User> getAllUsers(){
        return users;
    }
}
