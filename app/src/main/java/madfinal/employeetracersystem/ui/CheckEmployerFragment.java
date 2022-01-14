package madfinal.employeetracersystem.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import madfinal.employeetracersystem.R;
import madfinal.employeetracersystem.adapters.CheckListAdapter;
import madfinal.employeetracersystem.models.Checks;

public class CheckEmployerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_employer, container, false);

        ListView listView = view.getRootView().findViewById(R.id.listViewChecks);

        CheckListAdapter checkListAdapter = new CheckListAdapter(getContext(),R.layout.adapter_checklist_layout, Checks.getAllChecks());
        listView.setAdapter(checkListAdapter);

        return view;
    }
}
