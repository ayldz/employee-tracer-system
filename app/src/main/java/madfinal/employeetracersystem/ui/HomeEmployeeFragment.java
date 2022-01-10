package madfinal.employeetracersystem.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import madfinal.employeetracersystem.Logged;
import madfinal.employeetracersystem.R;
import madfinal.employeetracersystem.models.Users;

public class HomeEmployeeFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_employee, container, false);

        TextView welcomeTxt = view.getRootView().findViewById(R.id.welcomeText);
        welcomeTxt.setText("Welcome " + Logged.user.name + " " + Logged.user.surname);
        return view;
    }
}
