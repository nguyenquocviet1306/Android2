package com.example.viet.session3_homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteDetail extends AppCompatActivity {
    private static final String TAG = NoteDetail.class.toString();
    public static final String SELECTED_NOTELIST_IDX = "SelectionNoteListIndex";
    private EditText editText;
    private Button btSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        getReferences();
        addListener();
        editText.setText(getIntent2());
    }
    protected String getIntent2(){
        Intent intent = getIntent();
        return intent.getStringExtra("SendText");
    }

    protected int getPosIntent(){
        Intent intent = getIntent();
        return intent.getIntExtra("Pos", -1);
    }
    private void getReferences() {
        editText = (EditText) findViewById(R.id.editText);
        btSave = (Button) findViewById(R.id.bt_save);
    }
    private void addListener() {
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteDetail.this,MainActivity.class);
                String tmp = editText.getText().toString();
                String s1 = tmp.substring(0,tmp.indexOf("\n"));
                String s2 = tmp.substring(tmp.indexOf("\n"));
                if(getPosIntent() != -1){
                    MainActivity.noteArrayList.set(getPosIntent(), s1);
                    MainActivity.noteArrayListDeatl.set(getPosIntent(), s2);
                } else {
                    MainActivity.noteArrayList.add(s1);
                    MainActivity.noteArrayListDeatl.add(s2);
                }
                startActivity(intent);


            }
        });
    }


}
