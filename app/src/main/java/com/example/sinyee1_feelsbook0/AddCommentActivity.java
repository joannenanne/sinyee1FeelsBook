package com.example.sinyee1_feelsbook0;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class AddCommentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);
    }

    public void onSubmitComment111(View view) {
        //get the comment string
        EditText comment0 = (EditText)findViewById(R.id.commentfield);  //note: comment field can be multiline.
        String comment = comment0.getText().toString();

        //get current date
        String datenow = ((Attribute) this.getApplication()).getCurrentDate();
        //get emotion
        String emotion = getIntent().getStringExtra("EMOTION");


        Log.i("commentactivity", "from emotions " + emotion);
        Log.i("commentactivity", "from date " + datenow);
        Log.i("commentactivity", "from comment " + comment);

        //save to file------------------
        String filename ="sampleDB8.txt";

        String fileContents = datenow + ";" + emotion + ";" + comment + ";" + "\n";
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ShowHistoryActivity.class);
        startActivity(intent);
    }
}