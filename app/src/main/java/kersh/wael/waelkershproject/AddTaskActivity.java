package kersh.wael.waelkershproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }
    private EditText etitTitle, etSubject;
    private SeekBar skbrImportant, skbrNeccesary;
    private Button btnSave;
    private ImageButton imgBtn1;
    private Button btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //3. find view by id
        setContentView(R.layout.activity_add_task);
        etitTitle = findViewById(R.id.etTittle);
        etSubject = findViewById(R.id.etSubject);
        //etDueDate=findViewById(R.id.etDueDate);
        skbrImportant = findViewById(R.id.skrbrImportant);
        //skbrNeccesary=findViewById(R.id.skbrNeccesry);
        btnSave = findViewById(R.id.btnSave);
        imgBtn1 = findViewById(R.id.imgBtn);
        btnUpload = findViewById(R.id.btnUpload);
        //4. listeners
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    //5
    public void validateForm() {
        String title = etitTitle.getText().toString();
        String subject = etSubject.getText().toString();
        int imp = skbrImportant.getProgress();
        int nec = skbrNeccesary.getProgress();
        boolean isOk = true;
        if (title.length() == 0) {
            isOk = false;
            etitTitle.setError("at least one char");
        }
        if (isOk) {
            //6. save on firebase
            //6.1 build your data object
            MyTask myTask = new MyTask();
            myTask.setTitle(title);
            myTask.setSub(subject);
            myTask.setNecessary(nec);
            myTask.setImportant(imp);
            //6.2
            saveTask(myTask);
        }
    }
    //6.3 request to save my task (firebase database)
    private void saveTask(MyTask myTask){
        //1.
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        //2.
        DatabaseReference reference= database.getReference();
        //3.User id
        FirebaseAuth auth=FirebaseAuth.getInstance();
        String uid=auth.getCurrentUser().getUid();
        //4. My Object key
        String key=reference.child("All Task").push().getKey();
        //5.
        myTask.setOwner(uid);
        myTask.setKey(key);

    }
}