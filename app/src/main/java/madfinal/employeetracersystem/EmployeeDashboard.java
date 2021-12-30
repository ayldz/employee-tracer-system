package madfinal.employeetracersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmployeeDashboard extends AppCompatActivity {

    private Button btnAdvance;
    private Button btnPermit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dashboard);

        btnAdvance = (Button) findViewById(R.id.button4);

        btnAdvance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmployeeDashboard.this, AdvanceMoney.class);
                startActivity(intent);
            }
        });

        btnPermit = (Button) findViewById(R.id.button3);
        btnPermit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmployeeDashboard.this, PermitDay.class);
                startActivity(intent);
            }
        });
    }
}