package com.example.myapplication1010;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //백버튼이 눌린 마지막 시간을 저장함.
    private long backKeyPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //현재 시간이 마지막으로 백버튼을 누른 시간에서 2초 지났으면 마지막으로 백버튼이 눌린 시간으로 현재 시간을 생긴한다.
    public void onBackPressed(){
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();
            return;//백버튼이 한 번 눌리면 종료 안내 메시지가 뜬다.
        }

        /* 마지막으로 백버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후,
         마지막으로 백버튼을 눌렀던 시간이 2초가 지나지 않았으면 앱을 종료시킴.
         (메시지가 유지되는 2초동안 백버튼을 한 번 더 누르면 앱 종료)*/
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000){
            finish();

        }
    }
}
