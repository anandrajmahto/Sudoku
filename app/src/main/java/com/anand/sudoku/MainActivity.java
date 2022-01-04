package com.anand.sudoku;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth.AuthStateListener mAuthListener;
    Button login, Play, Upload;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String[] num = new String[90];
    ProgressDialog dialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Data");

        mAuth = FirebaseAuth.getInstance();

        login = findViewById(R.id.login);
        Play = findViewById(R.id.Play);
        Upload = findViewById(R.id.Upload);
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String lvl = String.valueOf(sh.getInt("lvl", 1));
        mAuth.signInAnonymously()
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Log-in failed ", Toast.LENGTH_SHORT).show();
                            login.setVisibility(View.VISIBLE);
                        } else {
                            // start an acitivty here

                            Toast.makeText(MainActivity.this, "Log-in", Toast.LENGTH_SHORT).show();
                            login.setVisibility(View.INVISIBLE);
                        }

                    }
                });
        Play.setText("Play Lvl-" + lvl);
        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Upload.class);
                startActivity(intent);

            }
        });
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = ProgressDialog.show(MainActivity.this, "",
                        "Loading. Please wait...", true);
                SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                String lvl = String.valueOf(sh.getInt("lvl", 1));

                //   Toast.makeText(Play.this, lvl, Toast.LENGTH_SHORT).show();

                getdata(lvl);

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signInAnonymously()
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (!task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Log-in failed ", Toast.LENGTH_SHORT).show();

                                } else {
                                    // start an acitivty here

                                    Toast.makeText(MainActivity.this, "Log-in", Toast.LENGTH_SHORT).show();
                                    login.setVisibility(View.INVISIBLE);
                                }

                            }
                        });
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void getdata(String level) {
        databaseReference.child("Level").child(level).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                    Toast.makeText(MainActivity.this, Objects.requireNonNull(task.getException()).toString(), Toast.LENGTH_LONG).show();


                } else {
                    // Toast.makeText(Play.this, String.valueOf(task.getResult().getValue()), Toast.LENGTH_LONG).show();
                    if (task.getResult().getValue() == null) {

                        Toast.makeText(MainActivity.this, "Finish", Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }else{

// My top posts by number of stars
                        databaseReference.child("Level").child(level).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                int j = 0;
                                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                    // TODO: handle the post
                                    num[j] = String.valueOf(postSnapshot.getValue());
                                    j++;

                                }
                                dialog.dismiss();
                                Intent intent = new Intent(getApplicationContext(), Play.class);
                                intent.putExtra("Data", num);
                                intent.putExtra("lvl", level);
                                startActivity(intent);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                // Getting Post failed, log a message
                                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                                // ...
                            }
                        });
                    }

                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                }
            }
        });



    }
}