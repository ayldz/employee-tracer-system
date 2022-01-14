package madfinal.employeetracersystem.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import madfinal.employeetracersystem.Logged;
import madfinal.employeetracersystem.R;
import madfinal.employeetracersystem.models.Check;
import madfinal.employeetracersystem.models.Checks;

public class CheckEmployeeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_employee, container, false);

        Button btnCheck = view.getRootView().findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Check check = new Check();
                check.userSSN = Logged.user.SSN;
                check.checkinTime = Timestamp.now();
                check.checkoutTime = Timestamp.now();
                Checks.addCheck(check);
            }
        });

        return view;
    }
}
