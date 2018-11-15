package com.szp.xiaosungege.activity.welcom;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.szp.sdb.DBMainActivity;
import com.szp.xiaosungege.R;

public class WelcomeActivity extends AppCompatActivity {

  Button btn_start;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcom);
    btn_start = (Button) findViewById(R.id.btn_start);
    btn_start.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(WelcomeActivity.this, DBMainActivity.class);
        startActivity(intent);
      }
    });
  }
}
