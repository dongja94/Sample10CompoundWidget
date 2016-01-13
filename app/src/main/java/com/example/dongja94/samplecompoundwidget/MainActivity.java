package com.example.dongja94.samplecompoundwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageTextView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (ImageTextView)findViewById(R.id.myview);
//        ImageTextData data = new ImageTextData();
//        data.iconId = R.mipmap.ic_launcher;
//        data.title = "CompoundWidget Test";
//        myView.setImageTextData(data);

        myView.setOnImageClickListener(new ImageTextView.OnImageClickListener() {
            @Override
            public void onImageClick(ImageTextView view, ImageTextData data) {
                if (data != null) {
                    Toast.makeText(MainActivity.this, "title : " + data.title , Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btn = (Button)findViewById(R.id.btn_text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myView.setTitle("Title Changed....");
            }
        });
    }
}
