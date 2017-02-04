package com.example.joane14.cardviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private ArrayList name, age, bDate;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        registerForContextMenu(recyclerView);

    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layout);
        name = new ArrayList<>();
        age = new ArrayList<>();
        bDate = new ArrayList<>();

        name.add("Joane Therese F. Artiaga");
        name.add("Charlyn Pepito");
        name.add("Jeon Jung Kook");
        name.add("Seo Joo Hyun");
        age.add("19");
        age.add("19");
        age.add("20");
        age.add("27");
        bDate.add("June 14, 1997");
        bDate.add("February 27, 1997");
        bDate.add("September 1, 1997");
        bDate.add("June 28, 1991");

        RecyclerView.Adapter adapter = new DataAdapter(name, age, bDate);
        recyclerView.setAdapter(adapter);


        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener(){

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    super.onLongPress(e);
                    Log.d("Long Pressed", " is real~");
                }
            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child!=null && gestureDetector.onTouchEvent(e)){
                    int position = rv.getChildAdapterPosition(child);
                    Toast.makeText(getApplicationContext(), name.get(position)+", "+age.get(position)+" "+bDate.get(position), Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        for(int init=0; init<name.size(); init++){
            Log.d("Name List: ", (String) name.get(init));
            Log.d("Age List: ", (String) age.get(init));
            Log.d("Birth Date List: ", (String) bDate.get(init));
        }
    }

}
