package com.example.tommy522588.myapplication;

import android.content.res.ObbInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tommy522588 on 2017/4/11.
 */

public class detail_data extends AppCompatActivity {

    private Button finish;
    private TextView text_name;
    private TextView text_age;
    private TextView text_gender;
    private TextView text_master;
    private TextView text_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_data);

        Object old_member=null; // 這裡很重要
        old_member=getIntent().getSerializableExtra("member");

        Member member=(Member)old_member;

        String name=member.getName();
        int age=member.getAge();
        String gender=member.getGender();
        String master=member.getMaster();
        int position=getIntent().getIntExtra("position",-1);
        List<Member> memberList=myMemList.getMemberList();
        int length=memberList.size();


        finish=(Button)findViewById(R.id.button3);

        text_number=(TextView)findViewById(R.id.textView9);
        text_name=(TextView)findViewById(R.id.textView17);
        text_age=(TextView)findViewById(R.id.textView18);
        text_gender=(TextView)findViewById(R.id.textView19);
        text_master=(TextView)findViewById(R.id.textView20);
        finish.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                finish();
            }

        });
        text_name.setText(name);
        text_age.setText(String.valueOf(age));
        text_gender.setText(gender);
        text_master.setText(master);
        text_number.setText(position+"/"+length);
    }
}
