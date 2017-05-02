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

import static com.yuri_khechoyan.queued.R.layout.activity_reg;


//*********TO-DO LIST********************

// ---NEEDS FIXING---

//-Save Info from Registration to QueueActivity
//-Send text out for Registration Confirmation (to users' phone)

    //--Tian's suggestions
    //UseSQLite in combo with adapter to add people to list
    //Have the SQLite DB update every time 'View Queue' Button is pressed


// --- FIXED ---
// Error - NullPointerException: at com.yuri_khechoyan.queued.MainActivity.<init>(MainActivity.java:38)

//(Solution =  move addInfo() method to RegActivity java file & move Initialized vars from MainActivity to RegActivity)

public class MainActivity extends AppCompatActivity {

    //Creates Register Button - MainActivity
    Button btn_Register;

    //Creates View Queue Button - MainActivity
    Button btn_ViewQueue;

    //Button btn_Clear_Cancel;


    //Initialize EditText Variables
   // EditText FirstName = (EditText) findViewById(R.id.et_FName);
   // EditText LastName = (EditText) findViewById(R.id.et_LName);
   // EditText PhoneNumber = (EditText) findViewById(R.id.et_PhNumber);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //New Customer Registration Method Call
        //customerReg();
        //View Queue Method Call
        //ViewQueue();

        /*
        //Retrieve btn_Back Method Call from QueueActivity Class - Call method in onCreate
        QueueActivity back_To_Main = new QueueActivity();
        back_To_Main.Back();
        */

        /*
        //Retrieve ClearCancel Method Call from RegActivity Class - Call method in onCreate
        RegActivity CC = new RegActivity();
        CC.ClearCancel();
        */

        /*
        //Retrieve customer_ConfirmReg Method Call from RegActivity Class - Call method in onCreate
        RegActivity CR = new RegActivity();
        CR.customer_ConfirmReg();
        */



        //btn_Clear_Cancel = (Button) findViewById(R.id.btn_ClearFields);
    }

    //Method called when "Register' Button is pressed
    protected void customerReg(View v1){
        //Assigns Register Button to xml element
        btn_Register = (Button) findViewById(R.id.btn_register) ;

        //Create Intent to launch from MainActivity to RegActivity
        Intent RegIntent = new Intent(MainActivity.this,RegActivity.class);
        startActivity(RegIntent);

        //Create Intent to launch the Registration Page (RegActivity)
        //Intent Register = new Intent ("com.yuri_khechoyan.queued.RegActivity");
        //startActivity(Register);
    }


    //Method called when the 'View Queue' Button is pressed
    protected void ViewQueue(View v2){
        //Assigns Register Button to xml element
        btn_ViewQueue = (Button) findViewById(R.id.btn_View);

        //Create Intent to launch from MainActivity to QueueActivity
        Intent ViewIntent = new Intent(MainActivity.this,QueueActivity.class);
        startActivity(ViewIntent);
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