package madfinal.employeetracersystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import madfinal.employeetracersystem.ui.AdvanceFragment;
import madfinal.employeetracersystem.ui.CheckEmployeeFragment;
import madfinal.employeetracersystem.ui.HomeEmployeeFragment;
import madfinal.employeetracersystem.ui.PermitDayFragment;

public class EmployeeDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dashboard);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation_employee);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_employee, new HomeEmployeeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_home_employee:
                    selectedFragment = new HomeEmployeeFragment();
                    break;
                case R.id.nav_check_employee:
                    selectedFragment = new CheckEmployeeFragment();
                    break;
                case R.id.nav_advance:
                    selectedFragment = new AdvanceFragment();
                    break;
                case R.id.nav_permit:
                    selectedFragment = new PermitDayFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_employee, selectedFragment).commit();
            return true;
        }
    };
}