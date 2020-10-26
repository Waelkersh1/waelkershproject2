package kersh.wael.waelkershproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText etEmail,etPhone,etFirstName,etLastName,etPassword,etPassword2;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail=findViewById(R.id.etEmail);
       etPhone=findViewById(R.id.etPhone);
        etPassword=findViewById(R.id.etPassword);
        etPassword2=findViewById(R.id.etPassword2);
        etFirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);
        btnsave=findViewById(R.id.btnSave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//class without name


            }
        });
    }

    /**
     *המתודה בודקת תקינות טופם ההרשמה ואם תקין מבצעת הרשמה\The method checks the correctness of the registration top and whether it is correct performs the registration
     */
    private void checkForm()
    {
        String PhoneNumber=etPhone.getText().toString();
        String Email =etEmail.getText().toString();
        String password=etPassword.getText().toString();
        String Password=etPassword2.getText().toString();
        String FirstName=etFirstName.getText().toString();
        String LastName=etLastName.getText().toString();

        boolean isOk= true;


        if(FirstName.length()< 2)
        {
            isOk=false;
            etFirstName.setError("at least two letters");
        }
        if(LastName.length()< 2)
        {
            isOk=false;
            etLastName.setError("at least two letters");
        }
        if(etEmail.length()<5 || etEmail.indexof('@')==0 || etEmail.indexof('@')>=etEmail.length()-2 ||
                etEmail.indexof('.')==0 || etEmail.indexof('.')>=etEmail.length()-1 || etEmail.lastIndexOf('.')<etEmail.indexof('@'))
        {
            isOk=false;
            etEmail.setError("wrong Gmail syntax");
        }
        if(password.equals(etPassword)==false){
            isOk=false;
            etPassword.setError("Password must ne the same");
        }
        else
        {
            MyValidation myValidations=new MyValidations();
            if (myValidations.validatePasword(etPassword)==false){
                isOk= false;
                etPassword.setError("Invalid Password");
            }
        }
        if(isOk)// isOk = true
        {
            // todo: create account and return to sign in screen/ close this screen
            createNewAccount(etEmail,FirstName,LastName,password,PhoneNumber);
        }

    }

    /**
     *
     * @param gmail
     * @param firstName
     * @param lastName
     * @param et
     * @param phone
     */

    private void createNewAccount(String gmail, String firstName, String lastName, String password, String phone)
    {
        FirebaseAuth auth=FirebaseAuth.getInstance(); // אחראית על רישום וכניסת משתמשים
    }


}
    }
}


