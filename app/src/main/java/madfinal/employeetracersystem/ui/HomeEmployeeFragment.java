package madfinal.employeetracersystem.ui;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.sql.Timestamp;
import java.util.Date;

import madfinal.employeetracersystem.Logged;
import madfinal.employeetracersystem.R;
import madfinal.employeetracersystem.models.Check;
import madfinal.employeetracersystem.models.Checks;
import madfinal.employeetracersystem.models.User;
import madfinal.employeetracersystem.models.Users;

public class HomeEmployeeFragment extends Fragment {

    public boolean isIN = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_employee, container, false);

        TextView welcomeTxt = view.getRootView().findViewById(R.id.welcomeTextEmployee);
        welcomeTxt.setText("Welcome " + Logged.user.name + " " + Logged.user.surname + "\nEmployee");


        return view;
    }
}
