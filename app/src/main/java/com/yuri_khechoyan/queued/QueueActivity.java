package com.yuri_khechoyan.queued;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Yuri Khechoyan on 5/1/2017.
 */

public class QueueActivity extends MainActivity{

    //Creates Back Button - Go from QueueActivity to MainActivity
    Button btn_Back;

    //Initialize ArrayList Object
    ArrayList<String> CustomerList;

    //Initialize ArrayAdapter Object
    ArrayAdapter<String> adapter;

    //Create ListView Object
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Assigns Register Button to xml element
        btn_Back = (Button) findViewById(R.id.btn_BackToMainMenu);

        //Connect ListView object to a layout element
        lv = (ListView) findViewById(R.id.listView);
    }


    protected void Back(View v5){
        //Create Intent to launch from MainActivity to RegActivity
        Intent BackIntent = new Intent(QueueActivity.this,MainActivity.class);
        startActivity(BackIntent);
    }


    protected void UpdateList(){
        //Have adapter update with newly made changes
        adapter.notifyDataSetChanged();

        //Assigns ListView to adapter Class
        lv.setAdapter(adapter);
    }

    /*

    //Creates Back Button - Go from activity_list to MainActivity
    Button btn_BackToMain;

    //Method to go from ViewQueue to Main Menu
    protected void Back(){
        //Assigns Register Button to xml element
        btn_BackToMain = (Button) findViewById(R.id.btn_BackToMainMenu);

        //Create Intent to launch the ListView Activity (QueueActivity)
        Intent BackToMain = new Intent ("com.yuri_khechoyan.queued.MainActivity");
        startActivity(BackToMain);
    }

    */


    //Method for Deleting person in '0' position; Everyone moves up 1 spot in ListView
    protected void Delete(){

    }
}