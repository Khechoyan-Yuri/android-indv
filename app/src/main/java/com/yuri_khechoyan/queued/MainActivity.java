package com.yuri_khechoyan.queued;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    //These boolean values will be used to help identify if application
    //can confirm Registration
    boolean FNE_confirm_submission;
    boolean LNE_confirm_submission;
    boolean PHE_confirm_submission;

    //Initialize EditText Variables
    EditText FirstName;
    EditText LastName;
    EditText PhoneNumber;

    //Initialize ListView object
    ListView lv;

    //Initialize ArrayList Object
    ArrayList<String> CustomerList;

    //Initialize ArrayAdapter Object
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method called when "Register' Button is pressed
    protected void customerReg(View r){
        setContentView(R.layout.activity_reg);
    }

    //Method called when 'Confirm Registration' Button is pressed
    protected void customer_ConfirmReg() {

        //Connect ListView object to a layout element
        lv = (ListView) findViewById(R.id.listView);

        //Calls ArrayList Class
        CustomerList = new ArrayList<String>();

        //Calls ArrayAdapter Class
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,
                CustomerList);

        //Assigns ListView to adapter Class
        lv.setAdapter(adapter);

 //--------------------------------------------------------------------------

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
            addInfo();
            //
        }
    }

    protected void addInfo(){
        //Convert EditText Variables to String
        String str_FN = FirstName.getText().toString();
        String str_LN = LastName.getText().toString();
        String str_PHN = PhoneNumber.getText().toString();

        //Complete submission code
        //Adds info (FN & LN to ListView
        CustomerList.add(str_FN+" "+str_LN);

        //Have adapter update with newly made changes
        adapter.notifyDataSetChanged();
    }

    protected void ClearFields(){
        //Delete Text Fields to null
        //when Clear button is pressed
        FirstName = (EditText) findViewById(R.id.et_FName);
        LastName = (EditText) findViewById(R.id.et_LName);
        PhoneNumber = (EditText) findViewById(R.id.et_PhNumber);

        //Setting Values back to null - Removing previous entries
        FirstName.setText("");
        LastName.setText("");
        PhoneNumber.setText("");

    }

    //Method to go from ViewQueue to Main Menu
    protected void btn_Back(){
        setContentView(R.layout.activity_main);
    }
}

/*

Installation failed with message Invalid File: D:\CIS\CIS 472 - Android Dev\HWs\HW-Individual\Queued
\app\build\intermediates\split-apk\debug\slices\slice_3.apk.

        It is possible that this issue is resolved by uninstalling an existing version of the apk
        if it is present, and then re-installing.
        WARNING: Uninstalling will remove the application data!
        Do you want to uninstall the existing application?

*/