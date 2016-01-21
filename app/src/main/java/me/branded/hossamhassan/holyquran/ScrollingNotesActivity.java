package me.branded.hossamhassan.holyquran;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import me.branded.hossamhassan.holyquran.Utils.HossDBManager;
import me.branded.hossamhassan.holyquran.Utils.Notes;

public class ScrollingNotesActivity extends AppCompatActivity {
    String TAG=HolyQuranConstants.TAG;
    //ListView listNotes;
    ListViewCompat listNotes;
    ListAdapter ad;
    List<String>current,others;
    String [] currentNotes,otherNotes;
    HossDBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.notes);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbManager=new HossDBManager(this,null,null,1);
        listNotes =(ListViewCompat)findViewById(R.id.list_notes);
        List<Notes> notes=dbManager.getNotesAsList();
        Log.d(TAG, "onCreate: notes"+notes.toString());
        others=new ArrayList<>();
        for (Notes note:notes)
        {
            String x=note.getTitle();
            Log.d(TAG, "onCreate: string x "+x);
            others.add(x);
        }

        //otherNotes=new String[others.size()];
        //otherNotes= (String[]) others.toArray();
        Log.d(TAG, "onCreate: otherNotes : "+others.toString());
        ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,others);
        listNotes.setAdapter(ad);
        listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
