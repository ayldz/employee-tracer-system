package madfinal.employeetracersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import madfinal.employeetracersystem.models.Checks;
import madfinal.employeetracersystem.models.PositionName;
import madfinal.employeetracersystem.models.Requests;
import madfinal.employeetracersystem.models.Users;

public class MainActivity extends AppCompatActivity {

    private EditText txtSSN;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new Thread(){
            @Override
            public void run() {
                Users.init();
                Requests.init();
                Checks.init();
            }
        };

        thread.start();

      //  Users.init();
       // Requests.init();
       // Checks.init();

        txtSSN = (EditText) findViewById(R.id.txtSSN);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int ssn = Integer.parseInt(txtSSN.getText().toString());
                Intent intent;
                if (Users.getUser(ssn) != null) {
                    Logged.user = Users.getUser(ssn);
                    if (Logged.user.position == PositionName.Employer)
                        intent = new Intent(MainActivity.this, EmployerDashboard.class);
                    else
                        intent = new Intent(MainActivity.this, EmployeeDashboard.class);
                    startActivity(intent);
                }
                else Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
            }
        });
    }
}