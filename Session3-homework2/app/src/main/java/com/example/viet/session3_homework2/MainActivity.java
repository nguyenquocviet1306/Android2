package com.example.viet.session3_homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    public final static String[] NOTE_LIST = new String[] {
            "Tools for learning Android", "Activity", "Fragment", "View"
    };
    public static final String[] NOTE_LIST_DETAIL = new String[]{
            "- PC or MAC with at least 4GB RAM\n" +
                    "- Android Studio\n" +
                    "- Genymotion or other simulation tools"," - activity1"," - fragment1","-view1"
    };

    public static ArrayList<String> noteArrayList = new ArrayList<>(Arrays.asList(NOTE_LIST));
    public static ArrayList<String> noteArrayListDeatl = new ArrayList<>(Arrays.asList(NOTE_LIST_DETAIL));
    public ArrayAdapter<String> noteListAdapter;

    private ListView lvNoteList;
    private Button btAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1
        setContentView(R.layout.activity_main);
        //2
        getRefererces();
        //3
        setupUIProperties();
        //4
        addListerers();
    }

    private void getRefererces() {
      lvNoteList = (ListView) findViewById(R.id.lv_notelist);
        btAdd = (Button) findViewById(R.id.bt_add);

    }

    private void setupUIProperties() {
        //1
        this.noteListAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                noteArrayList
        );
        //2
        lvNoteList.setAdapter(noteListAdapter);
    }

    private void addListerers() {
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,NoteDetail.class);
                startActivity(intent1);
            }
        });
        lvNoteList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(
                    AdapterView<?> parent,
                    View view,
                    int position,
                    long id) {
                Log.d(TAG,String.format("onItemLongClick: %d", position));
                noteArrayList.remove(position);
                noteArrayListDeatl.remove(position);
                noteListAdapter.notifyDataSetChanged();
                return true;
            }
        });
        lvNoteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> parent,
                    View view,
                    int position,
                    long id) {
                Log.d(TAG,String.format("onItemClick: %d", position));
                //1
                Intent intent = new Intent(MainActivity.this,NoteDetail.class);
                //2
                intent.putExtra("SendText", String.format("%s\n%s", noteArrayList.get(position), noteArrayListDeatl.get(position)));
                intent.putExtra("Pos", position);
                startActivity(intent);
            }
        });
    }


}
