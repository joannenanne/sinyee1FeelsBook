package com.example.sinyee1_feelsbook0;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    int[] counts = new int[6];
    String filename ="sampleDB8.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, " game initialized!", Toast.LENGTH_SHORT).show();

        TextView countAnger = (TextView)findViewById(R.id.count_anger);
        TextView countLove = (TextView)findViewById(R.id.count_love);
        TextView countSurprise = (TextView)findViewById(R.id.count_surprise);
        TextView countSadness = (TextView)findViewById(R.id.count_sadness);
        TextView countFear = (TextView)findViewById(R.id.count_fear);
        TextView countJoy = (TextView) findViewById(R.id.count_joy);
        counts[0] = 0;
        counts[1] = 0;
        counts[2] = 0;
        counts[3] = 0;
        counts[4] = 0;
        counts[5] = 0;


//        try {
//            FileInputStream fis = openFileInput(filename);
//            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
//            String line = in.readLine();
//            while (line!= null) {
//                line = in.readLine();
//                Log.i("mainactivity", "from line " + line);
//                    Matcher matcher0 = Pattern.compile("(|love|)").matcher(line);
//                    Matcher matcher1 = Pattern.compile("(|joy|)").matcher(line);
//                    Matcher matcher2 = Pattern.compile("(|surprise|)").matcher(line);
//                    Matcher matcher3 = Pattern.compile("(|anger|)").matcher(line);
//                    Matcher matcher4 = Pattern.compile("(|sadness|)").matcher(line);
//                    Matcher matcher5 = Pattern.compile("(|fear|)").matcher(line);
//
//                if (matcher0.lookingAt()){
//                    counts[0]++;
//                } else if (matcher1.lookingAt()){
//                    counts[1]++;
//                }else if (matcher2.lookingAt()){
//                    counts[2]++;
//                } else if (matcher3.lookingAt()){
//                    counts[3]++;
//                } else if (matcher4.lookingAt()){
//                    counts[4]++;
//                } else if (matcher5.lookingAt()){
//                    counts[5]++;
//                }
//            }
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        countLove.setText(counts[0]+"");
        countJoy.setText(counts[1]+"");
        countSurprise.setText(counts[2]+"");
        countAnger.setText(counts[3]+"");
        countSadness.setText(counts[4]+"");
        countFear.setText(counts[5]+"");
    }


    public void onClickEmotion(View view) {

        //get the string on button pressed
        Button b = (Button)view;
        String emotion = b.getText().toString();

        Log.i("mainactivity", "from emotions " + emotion);

        // Do something in response to emotion
        Intent intent = new Intent(this, AddCommentActivity.class);
        intent.putExtra("EMOTION", emotion);
        startActivity(intent);
    }

    public void onClickHistory(View view) {
        Intent intent = new Intent(this, ShowHistoryActivity.class);
        startActivity(intent);
    }
}
