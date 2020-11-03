package kersh.wael.waelkershproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {

    private EditText etemail, etpassword;
    private Button btnlog, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //3
        setContentView(R.layout.activity_log_in);
        etemail = findViewById(R.id.etEmail);
        etpassword = findViewById(R.id.etPassword);
        btnlog = findViewById(R.id.btnlog);
        btnSignup = findViewById(R.id.btnsign);
        //4
        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //5
                validateForm();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //5
    private void validateForm() {

    }

}