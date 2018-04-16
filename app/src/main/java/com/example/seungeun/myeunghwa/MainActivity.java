package com.example.seungeun.myeunghwa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 투표 앱");

        final int voteCount[] = new int[9];
        for (int i=0; i<9; i++)
            voteCount[i] = 0;

        final ImageView image[] = new ImageView[9];
        Integer imageid[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9};
        final String imageName[] = {"이미지1", "이미지2","이미지3", "이미지4", "이미지5", "이미지6", "이미지7", "이미지8", "이미지9"};

        for(int i=0; i<imageid.length; i++){
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageid[index]);
            image[index] .setOnClickListener(new View.OnClickListener() {   //new View 치면 저절로 나타남.
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(), imageName[index] + ": 총" + voteCount[index] + "표", Toast.LENGTH_SHORT).show();

                }
            });
        }
        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),  result.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("imageName", imageName);
                startActivity(intent);
            }
        });
    }
}
