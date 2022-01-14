package madfinal.employeetracersystem.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.nio.channels.CancelledKeyException;

import madfinal.employeetracersystem.Logged;
import madfinal.employeetracersystem.R;
import madfinal.employeetracersystem.models.Check;
import madfinal.employeetracersystem.models.Checks;

public class HomeEmployerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_employer, container, false);


        TextView welcomeTxt = view.getRootView().findViewById(R.id.welcomeTextEmployer);
        if (Checks.getCheck(180709029) != null)
            welcomeTxt.setText("Welcome " + Logged.user.name + " " + Logged.user.surname + "\nEmployer" );
        return view;
    }
}
