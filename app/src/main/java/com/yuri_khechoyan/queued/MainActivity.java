package com.yuri_khechoyan.queued;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method called when "Register' Button is pressed
    protected void customerReg(View r){
        setContentView(R.layout.activity_reg);
    }

    //Method called when 'View Queue' Button is pressed
    protected void customer_ConfirmReg(View c) {

        //These boolean values will be used to help identify if application
        //can confirm Registration
        boolean FNE_confirm_submission;
        boolean LNE_confirm_submission;
        boolean PHE_confirm_submission;

        //Create EditText Variables for Verification
        EditText FirstName = (EditText) findViewById(R.id.et_FName);
        EditText LastName = (EditText) findViewById(R.id.et_LName);
        EditText PhoneNumber = (EditText) findViewById(R.id.et_PhNumber);


        //Create ArrayList for Customers
        ArrayList<Customer> CustomerList = new ArrayList<>();


        //Conditions for verifying if registration
        //elements are empty or not
        //when Submit button is pressed
        if (FirstName.equals("")) {
            Toast.makeText(this, "First Name were not Entered", Toast.LENGTH_SHORT).show();
            FNE_confirm_submission = false;
        } else {
            FNE_confirm_submission = true;
        }

        if (LastName.equals("")) {
            Toast.makeText(this, "Last Name were not Entered", Toast.LENGTH_SHORT).show();
            LNE_confirm_submission = false;
        } else {
            LNE_confirm_submission = true;
        }

        if (PhoneNumber.equals("")) {
            Toast.makeText(this, "Phone were not Entered", Toast.LENGTH_SHORT).show();
            PHE_confirm_submission = false;
        } else {
            PHE_confirm_submission = true;
        }

        //Create OVERALL Verification Boolean
        boolean final_confirm_submission = FNE_confirm_submission && LNE_confirm_submission &&
                PHE_confirm_submission;

        //Final Verification boolean to verify
        //if submission is fully completed
        if (final_confirm_submission == false) {
        }
        else {

            //Convert User input to String
            String firstname = FirstName.getText().toString();
            String lastname = LastName.getText().toString();
            String phonenumber = PhoneNumber.getText().toString();

            //Add customer to the ArrayList: CustomerList
            Customer customer = new Customer(firstname, lastname, phonenumber);
            CustomerList.add(customer);
            Toast.makeText(this, "Submission Complete", Toast.LENGTH_SHORT).show();
        }
    }

    protected void ClearFields(){
        //Delete Text Fields to null
        //when Clear button is pressed
        EditText FirstName = (EditText) findViewById(R.id.et_FName);
        EditText LastName = (EditText) findViewById(R.id.et_LName);
        EditText PhoneNumber = (EditText) findViewById(R.id.et_PhNumber);

        //Setting Values back to null - Removing previous entries
        FirstName.setText("");
        LastName.setText("");
        PhoneNumber.setText("");
    }

    protected void customerView(){

    }
}
