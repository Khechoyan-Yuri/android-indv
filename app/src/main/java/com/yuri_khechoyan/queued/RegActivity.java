package com.yuri_khechoyan.queued;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Yuri Khechoyan on 5/1/2017.
 */

public class RegActivity extends MainActivity{

    //These boolean values will be used to help identify if application
    //can confirm Registration=
    boolean FNE_confirm_submission;
    boolean LNE_confirm_submission;
    boolean PHE_confirm_submission;

    //Initialize EditText Variables
    EditText FirstName;
    EditText LastName;
    EditText PhoneNumber;

    //Creates Back Button - Clear EditText fields & go back to MainActivity
    Button btn_Cancel;

    //Creates Confirmation Registration Button - Go from activity_reg to MainActivity
    Button btn_RegConfirm;

    //Create ListView Object
    ListView lv;

    //Initialize ArrayList Object
    ArrayList<String> CustomerList;

    //Initialize ArrayAdapter Object
    ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        FirstName = (EditText) findViewById(R.id.et_FName);
        LastName = (EditText) findViewById(R.id.et_LName);
        PhoneNumber = (EditText) findViewById(R.id.et_PhNumber);

        //Assigns Register Button to xml element
        btn_Cancel = (Button) findViewById(R.id.btn_ClearFields);

        //Assigns Confirm Registration Button to xml element
        btn_RegConfirm = (Button) findViewById(R.id.btn_RegConfirm);

        //Connect ListView object to a layout element
        lv = (ListView) findViewById(R.id.listView);
    }

    //Method for clearing all EditText Fields from activity_reg and go back to the Main Menu screen
    protected void ClearCancel(View v3){

        //Delete Text Fields to null
        //when Clear button is pressed
        if(!FirstName.getText().toString().equals("") || !LastName.getText().toString().equals("")
                || !PhoneNumber.getText().toString().equals("")){
            //Setting Values back to null - Removing any un-removed, previous entries
            FirstName.setText("");
            LastName.setText("");
            PhoneNumber.setText("");
        }

        //Create Intent to launch the go from RegActivity to MainActivity
        Intent CancelIntent = new Intent(RegActivity.this,MainActivity.class);
        startActivity(CancelIntent);
    }

    //Method called when 'Confirm Registration' Button is pressed
    protected void customer_ConfirmReg(View v4) {

        //Calls ArrayList Class
        CustomerList = new ArrayList<String>();

        //Calls ArrayAdapter Class
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
                CustomerList);


        //--------------------------------------------------------------------------


        //Conditions for verifying if registration
        //elements are empty or not
        //when Submit button is pressed
        if (FirstName.equals("")) {
            Toast.makeText(this, "First Name were not Entered", Toast.LENGTH_SHORT).show();
            FNE_confirm_submission = false;
        }
        else {
            FNE_confirm_submission = true;
        }

        if (LastName.equals("")) {
            Toast.makeText(this, "Last Name were not Entered", Toast.LENGTH_SHORT).show();
            LNE_confirm_submission = false;
        }
        else {
            LNE_confirm_submission = true;
        }

        if (PhoneNumber.equals("")) {
            Toast.makeText(this, "Phone were not Entered", Toast.LENGTH_SHORT).show();
            PHE_confirm_submission = false;
        }
        else {
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

            //Create Intent to launch from MainActivity to RegActivity
            Intent RegConfirmIntent = new Intent(RegActivity.this,MainActivity.class);
            startActivity(RegConfirmIntent);

        }
    }

    //Add customer info to the List and [add code] that sends a text to user

    protected void addInfo(){
        //Convert EditText Variables to String
        String str_FN = FirstName.getText().toString();
        String str_LN = LastName.getText().toString();
        String str_PHN = PhoneNumber.getText().toString();


        //Complete submission code
        //Adds info (FN & LN to ListView
        CustomerList.add(str_FN+" "+str_LN);

        Toast.makeText(this, "Registration Complete!", Toast.LENGTH_SHORT).show();

        //***ADD TWILIO CODE***


    }


    //*******USE THIS CODE FOR TWILIO & ADDING NAMES TO LIST********

    //Convert EditText Fields to Strings
    //String str_FN = FirstName.getText().toString();
    //String str_LN = LastName.getText().toString();
    //String str_PHN = PhoneNumber.getText().toString();
}






/*

Installation failed with message Invalid File: D:\CIS\CIS 472 - Android Dev\HWs\HW-Individual\Queued
\app\build\intermediates\split-apk\debug\slices\slice_3.apk.
        It is possible that this issue is resolved by uninstalling an existing version of the apk
        if it is present, and then re-installing.
        WARNING: Uninstalling will remove the application data!
        Do you want to uninstall the existing application?

*/