package com.yuri_khechoyan.queued;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


//*********TO-DO LIST********************

// Error - NullPointerException: at com.yuri_khechoyan.queued.MainActivity.<init>(MainActivity.java:36)


public class MainActivity extends AppCompatActivity {

    //Creates Register Button - MainActivity
    Button btn_Register;

    //Creates View Queue Button - MainActivity
    Button btn_ViewQueue;
    
    //Button btn_Clear_Cancel;

    //These boolean values will be used to help identify if application
    //can confirm Registration=
    boolean FNE_confirm_submission;
    boolean LNE_confirm_submission;
    boolean PHE_confirm_submission;

    //Initialize EditText Variables
    EditText FirstName = (EditText) findViewById(R.id.et_FName);
    EditText LastName = (EditText) findViewById(R.id.et_LName);
    EditText PhoneNumber = (EditText) findViewById(R.id.et_PhNumber);

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

        //New Customer Registration Method Call
        customerReg();
        //View Queue Method Call
        ViewQueue();

        //Retrieve btn_Back Method Call from QueueActivity Class - Call method in onCreate
        QueueActivity VQ= new QueueActivity();
        VQ.btn_Back();

        //Retrieve learCancel Method Call from RegActivity Class - Call method in onCreate
        RegActivity CC = new RegActivity();
        CC.ClearCancel();

        //Retrieve customer_ConfirmReg Method Call from RegActivity Class - Call method in onCreate
        RegActivity CR = new RegActivity();
        CR.customer_ConfirmReg();



        //btn_Clear_Cancel = (Button) findViewById(R.id.btn_ClearFields);
    }

    //Method called when "Register' Button is pressed
    protected void customerReg(){
        //Assigns Register Button to xml element
        btn_Register = (Button) findViewById(R.id.btn_register) ;

        //Create Intent to launch the Registration Page (RegActivity)
        Intent Register = new Intent ("com.yuri_khechoyan.queued.RegActivity");
        startActivity(Register);
    }


    //Method called when the 'View Queue' Button is pressed
    protected void ViewQueue(){
        //Assigns Register Button to xml element
        btn_ViewQueue = (Button) findViewById(R.id.btn_View);

        //Create Intent to launch the Registration Page (RegActivity)
        Intent View = new Intent ("com.yuri_khechoyan.queued.QueueActivity");
        startActivity(View);
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

        //Have adapter update with newly made changes
        adapter.notifyDataSetChanged();

        //***ADD TWILIO CODE***


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