package com.example.blink.quickchat;

import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import butterknife.Bind;
import butterknife.BindString;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    // just use for the global variable
    @Bind(R.id.send_button)
    Button sendButton;
    @Bind(R.id.text_edit)
    EditText text_edit;
    @Bind(R.id.login)
    Button logonButton;
    @Bind(android.R.id.list)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("DATACHANGED", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("DATA CHANGED", "Failed to read value.", error.toException());
            }
        });
       sendButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String text = text_edit.getText().toString();
               Map<String, Object> values= new HashMap<>();
               values.put("name","AndroidUser");
               values.put("text",text);
               myRef.setValue(values);
               text_edit.setText("");
           }
       });

    }

    @Override
    protected void onStart(){

    }

}
