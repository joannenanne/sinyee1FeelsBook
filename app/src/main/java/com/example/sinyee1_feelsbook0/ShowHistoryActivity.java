package com.example.sinyee1_feelsbook0;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ShowHistoryActivity extends AppCompatActivity {
    private ListView oldEmotionList;
    ArrayList datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_history);
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
           super.onStart();
        oldEmotionList = (ListView) findViewById(R.id.oldEmotionList);
        ArrayList data = loadFromFile();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, data);
       oldEmotionList.setAdapter(adapter);

        oldEmotionList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String selectedItem = (String) parent.getItemAtPosition(position);

//                //Dialog dialog = new Dialog();
//                Intent intent = new Intent(this,ShowDialog.class);
//                intent.putExtra("item_selected", selectedItem);
//                startActivity(intent);
            }

        });
    }

    private ArrayList<String> loadFromFile() {
        String filename ="sampleDB8.txt";
        datas = new ArrayList<String>();
        try {
            FileInputStream fis = openFileInput(filename);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String line = in.readLine();
            while (line != null) {
                datas.add(line);
                line = in.readLine();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return datas;
    }
}
