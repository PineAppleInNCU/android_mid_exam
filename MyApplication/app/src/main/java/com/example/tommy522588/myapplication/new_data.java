package com.example.tommy522588.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

/**
 * Created by tommy522588 on 2017/4/11.
 */

public class new_data extends AppCompatActivity {

    //像這樣宣告一大堆全域變數的寫法，是不是不太妥當？

    private EditText edit_name;
    private EditText edit_age;
    private EditText edit_gender;
    private EditText edit_master;
    private Button btn_add;
    private List<Member> memberList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_data);

        edit_name=(EditText)findViewById(R.id.editText);
        edit_age=(EditText)findViewById(R.id.editText2);
        edit_gender=(EditText)findViewById(R.id.editText3);
        edit_master=(EditText)findViewById(R.id.editText4);
        btn_add=(Button)findViewById(R.id.button2);

        btn_add.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                memberList=myMemList.getMemberList();

                String name=edit_name.getText().toString();
                int age=Integer.valueOf(edit_age.getText().toString());
                String gender=edit_gender.getText().toString();
                String master=edit_master.getText().toString();

                memberList.add(new Member(name,age,gender,master));

                finish();
            }
        });
    }

}