package madfinal.employeetracersystem.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import madfinal.employeetracersystem.R;
import madfinal.employeetracersystem.models.Request;
import madfinal.employeetracersystem.models.RequestType;

public class ApprovementListAdapter extends ArrayAdapter<Request> {

    private Context context;
    private int resource;
    private ArrayList<Request> requests;


    public ApprovementListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Request> objects){
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.requests = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {



       // getItem(position).get(position).employyeeSSN;

        String userID = "" + requests.get(position).employyeeSSN;;
        String requestType = " ";
        String content = " ";

        if (requests.get(position).type == RequestType.ADVANCE_PAYMENT){
            requestType = "Advance Payment";
            content = "" + requests.get(position).amount;
        }

        if (requests.get(position).type == RequestType.PERMIT_DAY){
            requestType = "Permit Day";

            String startDate = requests.get(position).startDate.toString();
            String endDate = requests.get(position).endDate.toString();
            content = startDate + " - " + endDate;
        }
        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(R.layout.adapter_approvementlist_layout, parent, false);

        if (convertView != null){
            TextView txtUserSSN = convertView.findViewById(R.id.txtUserSSN);
            TextView txtRequestType = convertView.findViewById(R.id.txtRequestType);
            TextView txtContent = convertView.findViewById(R.id.txtContent);

            txtUserSSN.setText(userID);
            txtRequestType.setText(requestType);
            txtContent.setText(content);
            Button btnApprove = convertView.findViewById(R.id.btnApprove);
            btnApprove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    requests.get(position).isApproved = true;
                }
            });
        }

        return convertView;
    }
}
