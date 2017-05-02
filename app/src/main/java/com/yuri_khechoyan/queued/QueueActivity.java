package com.yuri_khechoyan.queued;

import android.content.Intent;
import android.widget.Button;

/**
 * Created by Yuri Khechoyan on 5/1/2017.
 */

public class QueueActivity extends MainActivity{

    //Creates Back Button - Go from activity_list to MainActivity
    Button btn_BackToMain;

    //Method to go from ViewQueue to Main Menu
    protected void btn_Back(){
        //Assigns Register Button to xml element
        btn_BackToMain = (Button) findViewById(R.id.btn_Back_Main);

        //Create Intent to launch the Registration Page (RegActivity)
        Intent View = new Intent ("com.yuri_khechoyan.queued.MainActivity");
        startActivity(View);
    }
}
