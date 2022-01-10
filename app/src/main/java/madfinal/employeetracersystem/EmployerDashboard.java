package madfinal.employeetracersystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import madfinal.employeetracersystem.ui.AddUserFragment;
import madfinal.employeetracersystem.ui.AdvanceFragment;
import madfinal.employeetracersystem.ui.AprovementFragment;
import madfinal.employeetracersystem.ui.CheckEmployeeFragment;
import madfinal.employeetracersystem.ui.CheckEmployerFragment;
import madfinal.employeetracersystem.ui.HomeEmployeeFragment;
import madfinal.employeetracersystem.ui.HomeEmployerFragment;
import madfinal.employeetracersystem.ui.PermitDayFragment;

public class EmployerDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_dashboard);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_employer);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_employer, new HomeEmployerFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_home_employer:
                    selectedFragment = new HomeEmployerFragment();
                    break;
                case R.id.nav_check_employer:
                    selectedFragment = new CheckEmployerFragment();
                    break;
                case R.id.nav_approvement:
                    selectedFragment = new AprovementFragment();
                    break;
                case R.id.nav_adduser:
                    selectedFragment = new AddUserFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_employer, selectedFragment).commit();
            return true;
        }
    };
}