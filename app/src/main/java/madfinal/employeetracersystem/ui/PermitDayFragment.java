package madfinal.employeetracersystem.ui;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.google.firebase.Timestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import madfinal.employeetracersystem.Logged;
import madfinal.employeetracersystem.MainActivity;
import madfinal.employeetracersystem.R;
import madfinal.employeetracersystem.models.Request;
import madfinal.employeetracersystem.models.RequestType;
import madfinal.employeetracersystem.models.Requests;

public class PermitDayFragment extends Fragment {

    EditText txtExcuse;
    EditText dateStart;
    EditText dateEnd;

    Button btnCancelPermit;
    Button btnOkayPermit;

    String startDate;
    String endDate;

    final String[] months= {"", "january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_permit, container, false);

        txtExcuse = view.getRootView().findViewById(R.id.txtExcusePermit);
        dateStart = view.getRootView().findViewById(R.id.dateStart);
        dateEnd = view.getRootView().findViewById(R.id.dateEnd);

        btnCancelPermit = view.getRootView().findViewById(R.id.btnCancelPermit);
        btnCancelPermit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_employee, new HomeEmployeeFragment()).commit();
            }
        });

        btnOkayPermit = view.getRootView().findViewById(R.id.btnOkayPermit);

        btnOkayPermit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Request request = new Request();
                request.employyeeSSN = Logged.user.SSN;

                request.type = RequestType.PERMIT_DAY;
                request.excuse = txtExcuse.getText().toString();

                request.startDate = Timestamp.now();

                request.endDate = Timestamp.now();


                request.isApproved = false;

                Requests.addRequest(request);
                AddedRecord();
            }
        });

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);



        dateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String date = day+ " "+ months[month] + " " + year;
                        startDate = day + "/" + month +"/" + year;
                        dateStart.setText(date);
                    }
                }, year, month, day );
                datePickerDialog.show();
            }
        });

        dateEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String date = day+ " "+ months[month] + " " + year;
                        endDate = day + "/" + month +"/" + year;
                        dateEnd.setText(date);
                    }
                }, year, month, day );
                datePickerDialog.show();
            }
        });

        return view;
    }

    private void AddedRecord() {
        Toast.makeText(getContext(), "Added Request Successfully", Toast.LENGTH_LONG).show();
        txtExcuse.setText("");
        dateStart.setText("");
        dateEnd.setText("");
    }
}
