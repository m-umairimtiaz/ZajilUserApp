package com.example.zajiluserapp.ui.connectzajil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.zajiluserapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class connectzajil extends AppCompatActivity {
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private EditText addContactName, addContactPhone, addCompanyName, addEmail, addAddress, addCity, addCountry, addSubject, addMessage;
    private Spinner addSolutionCategory;
    private Button addContactBtn;
    private String solution;
    private String contactname, phone, companyname, email, address, city, country, subject, message;
    private ProgressDialog pd;
    private StorageReference storageReference;
    private DatabaseReference reference, dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connectzajil);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Zajil Contact");

        addContactName = findViewById(R.id.addContactName);
        addContactPhone = findViewById(R.id.addContactPhone);
        addCompanyName = findViewById(R.id.addCompanyName);
        addEmail = findViewById(R.id.addEmail);
        addAddress = findViewById(R.id.addAddress);
        addCity = findViewById(R.id.addCity);
        addCountry = findViewById(R.id.addCountry);
        addSubject = findViewById(R.id.addSubject);
        addMessage = findViewById(R.id.addMessage);

        addSolutionCategory = findViewById(R.id.addSolutionCategory);
        addContactBtn = findViewById(R.id.addContactBtn);

        pd = new ProgressDialog(this);

        reference = FirebaseDatabase.getInstance().getReference().child("ZajilContact");
        storageReference = FirebaseStorage.getInstance().getReference();

        String[] solutions = new String[]{"Solution of Interest", "Cloud Services", "Data Communication Services", "Enterprise", "International", "Internet Service", "Fiber Service", "IOT", "IT Security and Cyber Security", "Surveillance", "Wholesale"};
        addSolutionCategory.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, solutions));

        addSolutionCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                solution = addSolutionCategory.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        addContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {checkValidation();}

        });
    }

    private void checkValidation() {
        contactname = addContactName.getText().toString();
        phone = addContactPhone.getText().toString();
        companyname = addCompanyName.getText().toString();
        email = addEmail.getText().toString();
        address = addAddress.getText().toString();
        city = addCity.getText().toString();
        country = addCountry.getText().toString();
        subject = addSubject.getText().toString();
        message = addMessage.getText().toString();
        
        if(contactname.isEmpty()){
            addContactName.setError(("Empty!"));
            addContactName.requestFocus();
        } else if (phone.isEmpty()) {
            addContactPhone.setError(("Empty!"));
            addContactPhone.requestFocus();
        } else if (email.isEmpty()) {
            addEmail.setError(("Empty!"));
            addEmail.requestFocus();
        } else if (solution.equals("Solution of Interest")) {
            Toast.makeText(this, "Please Select Solutions of Interest", Toast.LENGTH_SHORT).show();
        } else {
            insertData();
        }
    }

    private void insertData() {
        dbref = reference.child(solution);
        final String uniquekey = dbref.push().getKey();

        contactData MemberData = new contactData (contactname, phone, companyname, email, address, city, country, subject, message, uniquekey);
        dbref.child(uniquekey).setValue(MemberData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                pd.dismiss();
                Toast.makeText(connectzajil.this, "Details Submitted Succesfully.", Toast.LENGTH_SHORT).show();
                addContactName.setText("");
                addCompanyName.setText("");
                addContactPhone.setText("");
                addEmail.setText("");
                addAddress.setText("");
                addCountry.setText("");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(connectzajil.this, "Something Went wrong.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}