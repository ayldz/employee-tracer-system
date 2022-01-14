package madfinal.employeetracersystem.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.Timestamp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import madfinal.employeetracersystem.R;
import madfinal.employeetracersystem.models.Check;
import madfinal.employeetracersystem.models.Users;

public class CheckListAdapter extends ArrayAdapter<Check> {

    private Context context;
    private int resource;
    private ArrayList<Check> checks;

    public CheckListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Check> objects){
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.checks = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String nameSurname = Users.getUser(checks.get(position).userSSN).name + " " + Users.getUser(checks.get(position).userSSN).surname;
        Date date = new Date();

        String checkinTime = checks.get(position).checkinTime.toString();

        String checkoutTime = checks.get(position).checkoutTime.toString();

        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(this.resource, parent, false);

        if ( convertView!= null){

            TextView txtNameSurname = convertView.findViewById(R.id.txtCheckListNameSurname);
            TextView txtCheckInTime = convertView.findViewById(R.id.txtCheckInTime);
            TextView txtCheckOutTime = convertView.findViewById(R.id.txtCheckOutTime);

            txtNameSurname.setText(nameSurname);
            txtCheckInTime.setText(checkinTime);
            txtCheckOutTime.setText(checkoutTime);
        }


        return convertView;
    }
}
