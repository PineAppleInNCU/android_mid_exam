package com.example.tommy522588.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Context context;

    private TextView text_number;
    private Button btn_add;
    private List<Member> memberList;

    @Override
    protected  void onResume(){
        super.onResume();
        text_number.setText("共有"+memberList.size()+"筆資料");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化該陣列
        myMemList.initialize();
        //initialize context
        context=this;

        text_number=(TextView)findViewById(R.id.textView2);

        btn_add=(Button)findViewById(R.id.button);
        btn_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context,new_data.class);
                startActivity(intent);
            }
        });

        ListView lvMember = (ListView) findViewById(R.id.ListView);
        lvMember.setAdapter(new MemberAdapter(this));
        lvMember.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Member member = (Member) parent.getItemAtPosition(position);
                Member new_member=new Member();
                new_member.setName(member.getName());
                new_member.setAge(member.getAge());
                new_member.setGender(member.getGender());
                new_member.setMaster(member.getMaster());

                Log.i("position",""+position);

                Intent intent = new Intent(context,detail_data.class);
                Bundle extras = new Bundle();
                extras.putSerializable("member",new_member);
                extras.putInt("position",position+1);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

    }

    private class MemberAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;


        public MemberAdapter(Context context) {
            layoutInflater = LayoutInflater.from(context);
            memberList = myMemList.getMemberList();//因為是直接呼叫static 方法，所以不會呼叫建構子
            //這裡會有個問題，就是每當我跳離這個頁面，再回來，就會多增加上面三項
        }

        @Override
        public int getCount() {
            return memberList.size();
        }

        @Override
        public Object getItem(int position) {
            return memberList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return memberList.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            /*convertView 是一格一格的那個嗎？*/
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.listview_item, parent, false);
                if (position % 2 == 1)
                    convertView.setBackgroundColor(Color.BLUE);
                if (position % 2 == 0)
                    convertView.setBackgroundColor(Color.YELLOW);
            }

            Member member = memberList.get(position);
            TextView text_name = (TextView)convertView.findViewById(R.id.textView14);
            text_name.setText(member.getName());
            TextView text_age = (TextView)convertView.findViewById(R.id.textView16);
            text_age.setText(String.valueOf(member.getAge()));

            TextView text_gender = (TextView)convertView.findViewById(R.id.textView15);
            text_gender.setText(member.getGender());

            TextView text_master = (TextView)convertView.findViewById(R.id.textView8);
            text_master.setText(member.getMaster());

            return convertView;
        }
    }

    /*
    *  這樣new一個class，用來放置static method。跟直接宣告一個全域的static MemberList有什麼差別？
    *
    *
    * */

}
