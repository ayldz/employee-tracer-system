package madfinal.employeetracersystem.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import madfinal.employeetracersystem.Logged;
import madfinal.employeetracersystem.R;
import madfinal.employeetracersystem.models.Request;
import madfinal.employeetracersystem.models.RequestType;
import madfinal.employeetracersystem.models.Requests;

public class AdvanceFragment extends Fragment {

    EditText txtExcuse;
    EditText txtAmount;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_advance, container, false);

        txtExcuse = view.getRootView().findViewById(R.id.txtExcuse);
        txtAmount = view.getRootView().findViewById(R.id.txtAmount);

        Button btnCancel = view.getRootView().findViewById(R.id.btnCancelAdvance);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_employee, new HomeEmployeeFragment()).commit();
            }
        });

        Button btnOkay = view.getRootView().findViewById(R.id.btnOkayAdvance);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Request request = new Request();
                request.type = RequestType.ADVANCE_PAYMENT;
                request.employyeeSSN = Logged.user.SSN;
                request.excuse = txtExcuse.getText().toString();
                request.amount = Long.parseLong( txtAmount.getText().toString()) ;
                request.isApproved = false;

                Requests.addRequest(request);
                AddedRecord();
            }
        });

        return view;
    }

    private void AddedRecord() {
        Toast.makeText(getContext(), "Added Request Successfully", Toast.LENGTH_LONG).show();
        txtAmount.setText("");
        txtExcuse.setText("");
    }
}
