package kersh.wael.waelkershproject;
////sign up

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class waelProject {
    public class MainActivity extends AppCompatActivity {
        EditText etEmail, etPhone, etFirstName, etLastName, etPassword, etPassword2;
        Button btnsave;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            etEmail = findViewById(R.id.etEmail);
            etPhone = findViewById(R.id.etPhone);
            etPassword = findViewById(R.id.etPassword);
            etPassword2 = findViewById(R.id.etPassword2);
            etFirstName = findViewById(R.id.etFirstName);
            etLastName = findViewById(R.id.etLastName);
            btnsave = findViewById(R.id.btnSave);
            btnsave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {//class without name
                    checkForm();

                }
            });
        }

        /**
         * המתודה בודקת תקינות טופם ההרשמה ואם תקין מבצעת הרשמה\The method checks the correctness of the registration top and whether it is correct performs the registration
         */
        private void checkForm() {
            String PhoneNumber = etPhone.getText().toString();
            String Email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String password2 = etPassword2.getText().toString();
            String FirstName = etFirstName.getText().toString();
            String LastName = etLastName.getText().toString();

            boolean isOk = true;


            if (FirstName.length() < 2) {
                isOk = false;
                etFirstName.setError("at least two letters");
            }
            if (LastName.length() < 2) {
                isOk = false;
                etLastName.setError("at least two letters");
            }
            if (Email.length() < 5 || Email.indexOf('@') == 0 || Email.indexOf('@') >= Email.length() - 2 ||
                    Email.indexOf('.') == 0 || Email.indexOf('.') >= Email.length() - 1 || Email.lastIndexOf('.') < Email.indexOf('@')) {
                isOk = false;
                etEmail.setError("wrong Email syntax");
            }
            if (password.equals(password2) == false) {
                isOk = false;
                etPassword.setError("Password must ne the same");
            } else {
                //MyValidation myValidations=new MyValidations();
                if (password.length() < 8 || password.indexOf(' ') >= 0) {
                    isOk = false;
                    etPassword.setError("Invalid Password");
                }
            }
            if (isOk)// isOk = true
            {
                // todo: create account and return to sign in screen/ close this screen
                createNewAccount(Email, FirstName, LastName, password, PhoneNumber);
            }

        }

        /**
         * @param gmail
         * @param firstName
         * @param lastName
         * @param password
         * @param phone
         */

        private void createNewAccount(String gmail, String firstName, String lastName, String password, String phone) {
            FirebaseAuth auth = FirebaseAuth.getInstance(); // אחראית על רישום וכניסת משתמשים
        }


    }

}
