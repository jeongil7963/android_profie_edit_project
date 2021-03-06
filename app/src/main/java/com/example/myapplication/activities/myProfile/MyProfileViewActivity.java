package com.example.myapplication.activities.myProfile;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.utils.Utils;

public class MyProfileViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_view);

        //intent 전달된 값을 꺼내옴
        String test = getIntent().getStringExtra("test");
        int testInt = getIntent().getIntExtra("testInt",0);

        Utils.toast(this, test+"/"+testInt);
    }

    public void onClickBack(View v){
        onBackPressed();
    }

    public void onClickMyProfileEdit(View v){

        TextView tvName = findViewById(R.id.name);
        TextView tvAge = findViewById(R.id.age);

        String name = tvName.getText().toString();
        String age = tvAge.getText().toString();

        Intent intent = new Intent(this, MyProfileEditActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("age", age);

        startActivityForResult(intent, 1000);
    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        TextView tvName = findViewById(R.id.name);
        TextView tvAge = findViewById(R.id.age);

        if(requestCode == 1000 && resultCode == 100){
            String name = data.getStringExtra("name");
            String age = data.getStringExtra("age");

            tvName.setText(name);
            tvAge.setText(age);
        }
    }
}
