package com.yuri_khechoyan.queued;

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

    //Creates Back Button - Clear EditText fields & go back to MainActivity
    Button btn_Cancel;

    //Method for clearing all EditText Fields from activity_reg and go back to the Main Menu screen
    protected void ClearCancel(){
        //Assigns Register Button to xml element
        btn_Cancel = (Button) findViewById(R.id.btn_ClearFields);


        //Delete Text Fields to null
        //when Clear button is pressed
        if(!FirstName.getText().equals("") || !LastName.getText().equals("") || !PhoneNumber.getText().equals("")){
            //Setting Values back to null - Removing any un-removed, previous entries
            FirstName.setText("");
            LastName.setText("");
            PhoneNumber.setText("");
        }

        //Create Intent to launch the Registration Page (RegActivity)
        Intent Cancel = new Intent ("com.yuri_khechoyan.queued.MainActivity");
        startActivity(Cancel);
    }

    //Creates Confirmation Registration Button - Go from activity_reg to MainActivity
    //line 104
    Button btn_RegConfirm;

    //Method called when 'Confirm Registration' Button is pressed
    protected void customer_ConfirmReg() {
        //Connect ListView object to a layout element
        lv = (ListView) findViewById(R.id.listView);

        //Calls ArrayList Class
        CustomerList = new ArrayList<String>();

        //Calls ArrayAdapter Class
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
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

            //Assigns Confirm Registration Button to xml element
            btn_RegConfirm = (Button) findViewById(R.id.btn_RegConfirm) ;

            //Create Intent to launch the Registration Page (RegActivity)
            Intent RegConfirm = new Intent ("com.yuri_khechoyan.queued.MainActivity");
            startActivity(RegConfirm);

        }

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


