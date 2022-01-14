package madfinal.employeetracersystem.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import madfinal.employeetracersystem.R;
import madfinal.employeetracersystem.adapters.ApprovementListAdapter;
import madfinal.employeetracersystem.models.Requests;

public class AprovementFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_approvement, container, false);

        ListView listView = view.getRootView().findViewById(R.id.listViewApp);

        ApprovementListAdapter approvementListAdapter = new ApprovementListAdapter(getContext(), R.layout.adapter_approvementlist_layout, Requests.getAllRequests());
        listView.setAdapter(approvementListAdapter);

       return view;
    }
}
