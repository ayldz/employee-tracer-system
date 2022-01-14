package madfinal.employeetracersystem.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import madfinal.employeetracersystem.R;
import madfinal.employeetracersystem.models.PositionName;
import madfinal.employeetracersystem.models.User;
import madfinal.employeetracersystem.models.Users;

public class AddUserFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        EditText txtSSN = view.getRootView().findViewById(R.id.txtSSN);
        EditText txtName = view.getRootView().findViewById(R.id.txtName);
        EditText txtSurname = view.getRootView().findViewById(R.id.txtSurname);
        EditText txtTelephoneNumber = view.getRootView().findViewById(R.id.txtTelephoneNumber);
        EditText txtEmail = view.getRootView().findViewById(R.id.txtEmail);
        EditText txtAddress = view.getRootView().findViewById(R.id.txtAddress);
        EditText txtPosition = view.getRootView().findViewById(R.id.txtPosition);
        EditText txtSalary = view.getRootView().findViewById(R.id.txtSalary);

        Button btnAdd = view.getRootView().findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();

                user.SSN = Integer.parseInt( txtSSN.getText().toString() ) ;
                user.name = txtName.getText().toString();
                user.surname = txtSurname.getText().toString();
                user.telephoneNumber = txtTelephoneNumber.getText().toString();
                user.email = txtEmail.getText().toString();
                user.address = txtAddress.getText().toString();
                user.position =  PositionName.valueOf(txtPosition.getText().toString());
                user.salary = Long.parseLong(txtSalary.getText().toString());

                Users.addUser(user);
            }
        });

        Button btnCancel = view.getRootView().findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_employer, new HomeEmployerFragment()).commit();
            }
        });

        return view;
    }
}
