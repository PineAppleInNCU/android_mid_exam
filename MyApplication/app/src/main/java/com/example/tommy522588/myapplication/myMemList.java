package com.example.tommy522588.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy522588 on 2017/4/11.
 */

public class myMemList {




    public static List<Member> MemberList=new ArrayList<>();
    public static int initialFlag=0;

    public static void initialize(){

        if(initialFlag!=1) {
            MemberList.add(new Member("建興", 10, "男", "資工"));
            MemberList.add(new Member("建興", 22, "男", "資工"));
            MemberList.add(new Member("建興", 11, "男", "機械"));
            initialFlag = 1;
        }

    }


    public static List<Member> getMemberList(){
        return MemberList;
    }
    /*
        public static 當兩個程式同時向同一個來源要求資料的時候，會出現問題。
        這裡是因為使用者只有一人，而且步驟是一步一步的來，所以不會有同時要求資料的問題。（concept: thread）

        所有的method都是static 嗎？
     */

}
