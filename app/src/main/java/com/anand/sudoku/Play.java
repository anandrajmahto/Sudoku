package com.anand.sudoku;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Play extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20,
            btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39,
            btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50, btn51, btn52, btn53, btn54, btn55, btn56, btn57, btn58,
            btn59, btn60, btn61, btn62, btn63, btn64, btn65, btn66, btn67, btn68, btn69, btn70, btn71, btn72, btn73, btn74, btn75, btn76, btn77,
            btn78, btn79, btn80, btn81,
            press1, press2, press3, press4, press5, press6, press7, press8, press9;

    TextView CurLvL;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String[] num = new String[90];
    int btnActi, Activated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initialize();
        level();


        Thread one = new Thread() {
            public void run() {

                for (int i = 1; i <= 100; i++) {
                    try {

                        Thread.sleep(20);
                        animation(i);


                    } catch (InterruptedException ex) {
                        //do stuff


                    }
                }
            }
        };

        one.start();
    }

    private void clickListners() {

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (false) {

                } else {

                    if (btn1.getText().toString().equals(" ")) {
                        Log.e("btn1 up", btn1.getText().toString());
                        if (Activated == 0) {
                            Toast.makeText(Play.this, "Select a number", Toast.LENGTH_SHORT).show();
                        } else {
                            btn1.setText(String.valueOf(Activated));
                        }
                    } else {
                        Log.e("btn1", btn1.getText().toString());


                        btn1.setBackgroundColor(getResources().getColor(R.color.red));
                        Thread one = new Thread() {
                            public void run() {


                                try {

                                    Thread.sleep(200);
                                    runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            btn1.setBackgroundColor(getResources().getColor(R.color.trans));

                                            // Stuff that updates the UI

                                        }
                                    });


                                } catch (InterruptedException ex) {
                                    //do stuff


                                }

                            }
                        };

                        one.start();

                        // btn1.setText("Activated");
                    }

                }

            }
        });

        press1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press1.getTag().toString().equals("A")) {
                    press1.setTag(" ");
                    press1.setBackgroundColor(getResources().getColor(R.color.trans));
                    Activated = 0;
                    blinkChk(0);
                } else {
                    press1.setTag("A");
                    press2.setTag(" ");
                    press3.setTag(" ");
                    press4.setTag(" ");
                    press5.setTag(" ");
                    press6.setTag(" ");
                    press7.setTag(" ");
                    press8.setTag(" ");
                    press9.setTag(" ");
                    Activated = 1;
                    press1.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    press2.setBackgroundColor(getResources().getColor(R.color.trans));
                    press3.setBackgroundColor(getResources().getColor(R.color.trans));
                    press4.setBackgroundColor(getResources().getColor(R.color.trans));
                    press5.setBackgroundColor(getResources().getColor(R.color.trans));
                    press6.setBackgroundColor(getResources().getColor(R.color.trans));
                    press7.setBackgroundColor(getResources().getColor(R.color.trans));
                    press8.setBackgroundColor(getResources().getColor(R.color.trans));
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));
                    blinkChk(1);
                }
            }
        });

        press2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press2.getTag().toString().equals("A")) {
                    press2.setTag(" ");
                    press2.setBackgroundColor(getResources().getColor(R.color.trans));
                    Activated = 0;
                } else {
                    press2.setTag("A");
                    press1.setTag(" ");

                    press3.setTag(" ");
                    press4.setTag(" ");
                    press5.setTag(" ");
                    press6.setTag(" ");
                    press7.setTag(" ");
                    press8.setTag(" ");
                    press9.setTag(" ");
                    Activated = 2;
                    press2.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    press1.setBackgroundColor(getResources().getColor(R.color.trans));

                    press3.setBackgroundColor(getResources().getColor(R.color.trans));
                    press4.setBackgroundColor(getResources().getColor(R.color.trans));
                    press5.setBackgroundColor(getResources().getColor(R.color.trans));
                    press6.setBackgroundColor(getResources().getColor(R.color.trans));
                    press7.setBackgroundColor(getResources().getColor(R.color.trans));
                    press8.setBackgroundColor(getResources().getColor(R.color.trans));
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));
                }
            }
        });

        press3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press3.getTag().toString().equals("A")) {
                    press3.setTag(" ");
                    press3.setBackgroundColor(getResources().getColor(R.color.trans));
                    Activated = 0;
                } else {
                    press3.setTag("A");
                    press1.setTag(" ");
                    press2.setTag(" ");

                    press4.setTag(" ");
                    press5.setTag(" ");
                    press6.setTag(" ");
                    press7.setTag(" ");
                    press8.setTag(" ");
                    press9.setTag(" ");
                    Activated = 3;
                    press3.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    press1.setBackgroundColor(getResources().getColor(R.color.trans));
                    press2.setBackgroundColor(getResources().getColor(R.color.trans));
                    press4.setBackgroundColor(getResources().getColor(R.color.trans));
                    press5.setBackgroundColor(getResources().getColor(R.color.trans));
                    press6.setBackgroundColor(getResources().getColor(R.color.trans));
                    press7.setBackgroundColor(getResources().getColor(R.color.trans));
                    press8.setBackgroundColor(getResources().getColor(R.color.trans));
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));
                }
            }
        });

        press4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press4.getTag().toString().equals("A")) {
                    press4.setTag(" ");
                    press4.setBackgroundColor(getResources().getColor(R.color.trans));
                    Activated = 0;
                } else {
                    press4.setTag("A");
                    press1.setTag(" ");
                    press2.setTag(" ");
                    press3.setTag(" ");

                    press5.setTag(" ");
                    press6.setTag(" ");
                    press7.setTag(" ");
                    press8.setTag(" ");
                    press9.setTag(" ");
                    Activated = 4;
                    press4.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    press1.setBackgroundColor(getResources().getColor(R.color.trans));
                    press2.setBackgroundColor(getResources().getColor(R.color.trans));
                    press3.setBackgroundColor(getResources().getColor(R.color.trans));

                    press5.setBackgroundColor(getResources().getColor(R.color.trans));
                    press6.setBackgroundColor(getResources().getColor(R.color.trans));
                    press7.setBackgroundColor(getResources().getColor(R.color.trans));
                    press8.setBackgroundColor(getResources().getColor(R.color.trans));
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));
                }
            }
        });

        press5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press5.getTag().toString().equals("A")) {
                    press5.setTag(" ");
                    press5.setBackgroundColor(getResources().getColor(R.color.trans));
                    Activated = 0;
                } else {
                    press5.setTag("A");
                    press1.setTag(" ");
                    press2.setTag(" ");
                    press3.setTag(" ");
                    press4.setTag(" ");

                    press6.setTag(" ");
                    press7.setTag(" ");
                    press8.setTag(" ");
                    press9.setTag(" ");
                    Activated = 5;
                    press5.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    press1.setBackgroundColor(getResources().getColor(R.color.trans));
                    press2.setBackgroundColor(getResources().getColor(R.color.trans));
                    press3.setBackgroundColor(getResources().getColor(R.color.trans));
                    press4.setBackgroundColor(getResources().getColor(R.color.trans));

                    press6.setBackgroundColor(getResources().getColor(R.color.trans));
                    press7.setBackgroundColor(getResources().getColor(R.color.trans));
                    press8.setBackgroundColor(getResources().getColor(R.color.trans));
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));
                }
            }
        });

        press6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press6.getTag().toString().equals("A")) {
                    press6.setTag(" ");
                    press6.setBackgroundColor(getResources().getColor(R.color.trans));
                    Activated = 0;
                } else {
                    press6.setTag("A");
                    press1.setTag(" ");
                    press2.setTag(" ");
                    press3.setTag(" ");
                    press4.setTag(" ");
                    press5.setTag(" ");

                    press7.setTag(" ");
                    press8.setTag(" ");
                    press9.setTag(" ");
                    Activated = 6;
                    press6.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    press1.setBackgroundColor(getResources().getColor(R.color.trans));
                    press2.setBackgroundColor(getResources().getColor(R.color.trans));
                    press3.setBackgroundColor(getResources().getColor(R.color.trans));
                    press4.setBackgroundColor(getResources().getColor(R.color.trans));
                    press5.setBackgroundColor(getResources().getColor(R.color.trans));
                    press7.setBackgroundColor(getResources().getColor(R.color.trans));
                    press8.setBackgroundColor(getResources().getColor(R.color.trans));
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));
                }
            }
        });

        press7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press7.getTag().toString().equals("A")) {
                    press7.setTag(" ");
                    press7.setBackgroundColor(getResources().getColor(R.color.trans));
                    Activated = 0;
                } else {
                    press7.setTag("A");
                    press1.setTag(" ");
                    press2.setTag(" ");
                    press3.setTag(" ");
                    press4.setTag(" ");
                    press5.setTag(" ");
                    press6.setTag(" ");

                    press8.setTag(" ");
                    press9.setTag(" ");
                    Activated = 7;
                    press7.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    press1.setBackgroundColor(getResources().getColor(R.color.trans));
                    press2.setBackgroundColor(getResources().getColor(R.color.trans));
                    press3.setBackgroundColor(getResources().getColor(R.color.trans));
                    press4.setBackgroundColor(getResources().getColor(R.color.trans));
                    press5.setBackgroundColor(getResources().getColor(R.color.trans));
                    press6.setBackgroundColor(getResources().getColor(R.color.trans));
                    press8.setBackgroundColor(getResources().getColor(R.color.trans));
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));
                }
            }
        });

        press8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press8.getTag().toString().equals("A")) {
                    press8.setTag(" ");
                    press8.setBackgroundColor(getResources().getColor(R.color.trans));
                    Activated = 0;
                } else {
                    press8.setTag("A");
                    press1.setTag(" ");
                    press2.setTag(" ");
                    press3.setTag(" ");
                    press4.setTag(" ");
                    press5.setTag(" ");
                    press6.setTag(" ");
                    press7.setTag(" ");

                    press9.setTag(" ");
                    Activated = 8;
                    press8.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    press1.setBackgroundColor(getResources().getColor(R.color.trans));
                    press2.setBackgroundColor(getResources().getColor(R.color.trans));
                    press3.setBackgroundColor(getResources().getColor(R.color.trans));
                    press4.setBackgroundColor(getResources().getColor(R.color.trans));
                    press5.setBackgroundColor(getResources().getColor(R.color.trans));
                    press6.setBackgroundColor(getResources().getColor(R.color.trans));
                    press7.setBackgroundColor(getResources().getColor(R.color.trans));
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));
                }
            }
        });

        press9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (press9.getTag().toString().equals("A")) {
                    press9.setTag(" ");
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));
                    Activated = 0;
                } else {
                    press9.setTag("A");
                    press1.setTag(" ");
                    press2.setTag(" ");
                    press3.setTag(" ");
                    press4.setTag(" ");
                    press5.setTag(" ");
                    press6.setTag(" ");
                    press7.setTag(" ");
                    press8.setTag(" ");

                    Activated = 9;
                    press9.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    press1.setBackgroundColor(getResources().getColor(R.color.trans));
                    press2.setBackgroundColor(getResources().getColor(R.color.trans));
                    press3.setBackgroundColor(getResources().getColor(R.color.trans));
                    press4.setBackgroundColor(getResources().getColor(R.color.trans));
                    press5.setBackgroundColor(getResources().getColor(R.color.trans));
                    press6.setBackgroundColor(getResources().getColor(R.color.trans));
                    press7.setBackgroundColor(getResources().getColor(R.color.trans));
                    press8.setBackgroundColor(getResources().getColor(R.color.trans));

                }
            }
        });

    }

    private void blinkChk(int i) {
        if (i == 0) {
            btn1.setBackgroundColor(getResources().getColor(R.color.trans));
            btn2.setBackgroundColor(getResources().getColor(R.color.trans));
            btn3.setBackgroundColor(getResources().getColor(R.color.trans));
            btn4.setBackgroundColor(getResources().getColor(R.color.trans));
            btn5.setBackgroundColor(getResources().getColor(R.color.trans));
            btn6.setBackgroundColor(getResources().getColor(R.color.trans));
            btn7.setBackgroundColor(getResources().getColor(R.color.trans));
            btn8.setBackgroundColor(getResources().getColor(R.color.trans));
            btn9.setBackgroundColor(getResources().getColor(R.color.trans));
            btn10.setBackgroundColor(getResources().getColor(R.color.trans));
            btn11.setBackgroundColor(getResources().getColor(R.color.trans));
            btn12.setBackgroundColor(getResources().getColor(R.color.trans));
            btn13.setBackgroundColor(getResources().getColor(R.color.trans));
            btn14.setBackgroundColor(getResources().getColor(R.color.trans));
            btn15.setBackgroundColor(getResources().getColor(R.color.trans));
            btn16.setBackgroundColor(getResources().getColor(R.color.trans));
            btn17.setBackgroundColor(getResources().getColor(R.color.trans));
            btn18.setBackgroundColor(getResources().getColor(R.color.trans));
            btn19.setBackgroundColor(getResources().getColor(R.color.trans));
            btn20.setBackgroundColor(getResources().getColor(R.color.trans));
            btn21.setBackgroundColor(getResources().getColor(R.color.trans));
            btn22.setBackgroundColor(getResources().getColor(R.color.trans));
            btn23.setBackgroundColor(getResources().getColor(R.color.trans));
            btn24.setBackgroundColor(getResources().getColor(R.color.trans));
            btn25.setBackgroundColor(getResources().getColor(R.color.trans));
            btn26.setBackgroundColor(getResources().getColor(R.color.trans));
            btn27.setBackgroundColor(getResources().getColor(R.color.trans));
            btn28.setBackgroundColor(getResources().getColor(R.color.trans));
            btn29.setBackgroundColor(getResources().getColor(R.color.trans));
            btn30.setBackgroundColor(getResources().getColor(R.color.trans));
            btn31.setBackgroundColor(getResources().getColor(R.color.trans));
            btn32.setBackgroundColor(getResources().getColor(R.color.trans));
            btn33.setBackgroundColor(getResources().getColor(R.color.trans));
            btn34.setBackgroundColor(getResources().getColor(R.color.trans));
            btn35.setBackgroundColor(getResources().getColor(R.color.trans));
            btn36.setBackgroundColor(getResources().getColor(R.color.trans));
            btn37.setBackgroundColor(getResources().getColor(R.color.trans));
            btn38.setBackgroundColor(getResources().getColor(R.color.trans));
            btn39.setBackgroundColor(getResources().getColor(R.color.trans));
            btn40.setBackgroundColor(getResources().getColor(R.color.trans));
            btn41.setBackgroundColor(getResources().getColor(R.color.trans));
            btn42.setBackgroundColor(getResources().getColor(R.color.trans));
            btn43.setBackgroundColor(getResources().getColor(R.color.trans));
            btn44.setBackgroundColor(getResources().getColor(R.color.trans));
            btn45.setBackgroundColor(getResources().getColor(R.color.trans));
            btn46.setBackgroundColor(getResources().getColor(R.color.trans));
            btn47.setBackgroundColor(getResources().getColor(R.color.trans));
            btn48.setBackgroundColor(getResources().getColor(R.color.trans));
            btn49.setBackgroundColor(getResources().getColor(R.color.trans));
            btn50.setBackgroundColor(getResources().getColor(R.color.trans));
            btn51.setBackgroundColor(getResources().getColor(R.color.trans));
            btn52.setBackgroundColor(getResources().getColor(R.color.trans));
            btn53.setBackgroundColor(getResources().getColor(R.color.trans));
            btn54.setBackgroundColor(getResources().getColor(R.color.trans));
            btn55.setBackgroundColor(getResources().getColor(R.color.trans));
            btn56.setBackgroundColor(getResources().getColor(R.color.trans));
            btn57.setBackgroundColor(getResources().getColor(R.color.trans));
            btn58.setBackgroundColor(getResources().getColor(R.color.trans));
            btn59.setBackgroundColor(getResources().getColor(R.color.trans));
            btn60.setBackgroundColor(getResources().getColor(R.color.trans));
            btn61.setBackgroundColor(getResources().getColor(R.color.trans));
            btn62.setBackgroundColor(getResources().getColor(R.color.trans));
            btn63.setBackgroundColor(getResources().getColor(R.color.trans));
            btn64.setBackgroundColor(getResources().getColor(R.color.trans));
            btn65.setBackgroundColor(getResources().getColor(R.color.trans));
            btn66.setBackgroundColor(getResources().getColor(R.color.trans));
            btn67.setBackgroundColor(getResources().getColor(R.color.trans));
            btn68.setBackgroundColor(getResources().getColor(R.color.trans));
            btn69.setBackgroundColor(getResources().getColor(R.color.trans));
            btn70.setBackgroundColor(getResources().getColor(R.color.trans));
            btn71.setBackgroundColor(getResources().getColor(R.color.trans));
            btn72.setBackgroundColor(getResources().getColor(R.color.trans));
            btn73.setBackgroundColor(getResources().getColor(R.color.trans));
            btn74.setBackgroundColor(getResources().getColor(R.color.trans));
            btn75.setBackgroundColor(getResources().getColor(R.color.trans));
            btn76.setBackgroundColor(getResources().getColor(R.color.trans));
            btn77.setBackgroundColor(getResources().getColor(R.color.trans));
            btn78.setBackgroundColor(getResources().getColor(R.color.trans));
            btn79.setBackgroundColor(getResources().getColor(R.color.trans));
            btn80.setBackgroundColor(getResources().getColor(R.color.trans));
            btn81.setBackgroundColor(getResources().getColor(R.color.trans));

        } else if (i == 1) {
             if (btn1.getText().toString().equals("1")) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn2.getText().toString().equals("1")) {
                Toast.makeText(Play.this,btn2.getText().toString() , Toast.LENGTH_SHORT).show();

                btn2.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
        }
    }

    private void result() {

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        int lvl = sh.getInt("lvl", 1);

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putInt("lvl", lvl + 1);
        myEdit.commit();

        Intent intent = new Intent(getApplicationContext(), Play.class);
        startActivity(intent);
        finish();

    }


    private void level() {
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String lvl = String.valueOf(sh.getInt("lvl", 1));

        //   Toast.makeText(Play.this, lvl, Toast.LENGTH_SHORT).show();

        getdata(lvl);

    }


    @SuppressLint("SetTextI18n")
    private void getdata(String level) {
        databaseReference.child("Level").child(level).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                    Toast.makeText(Play.this, Objects.requireNonNull(task.getException()).toString(), Toast.LENGTH_LONG).show();


                } else {
                    // Toast.makeText(Play.this, String.valueOf(task.getResult().getValue()), Toast.LENGTH_LONG).show();
                    if (task.getResult().getValue() == null) {

                        Toast.makeText(Play.this, "Finish", Toast.LENGTH_LONG).show();

                    }
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
                }
            }
        });

        CurLvL.setText("Level-" + level);
// My top posts by number of stars
        databaseReference.child("Level").child(level).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int j = 0;
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    num[j] = String.valueOf(postSnapshot.getValue());
                    j++;

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });

    }

    private void setData() {
        btn1.setText(num[0]);
        btn2.setText(num[1]);
        btn3.setText(num[2]);
        btn4.setText(num[3]);
        btn5.setText(num[4]);
        btn6.setText(num[5]);
        btn7.setText(num[6]);
        btn8.setText(num[7]);
        btn9.setText(num[8]);
        btn10.setText(num[9]);
        btn11.setText(num[10]);
        btn12.setText(num[11]);
        btn13.setText(num[12]);
        btn14.setText(num[13]);
        btn15.setText(num[14]);
        btn16.setText(num[15]);
        btn17.setText(num[16]);
        btn18.setText(num[17]);
        btn19.setText(num[18]);
        btn20.setText(num[19]);
        btn21.setText(num[20]);
        btn22.setText(num[21]);
        btn23.setText(num[22]);
        btn24.setText(num[23]);
        btn25.setText(num[24]);
        btn26.setText(num[25]);
        btn27.setText(num[26]);
        btn28.setText(num[27]);
        btn29.setText(num[28]);
        btn30.setText(num[29]);
        btn31.setText(num[30]);
        btn32.setText(num[31]);
        btn33.setText(num[32]);
        btn34.setText(num[33]);
        btn35.setText(num[34]);
        btn36.setText(num[35]);
        btn37.setText(num[36]);
        btn38.setText(num[37]);
        btn39.setText(num[38]);
        btn40.setText(num[39]);
        btn41.setText(num[40]);
        btn42.setText(num[41]);
        btn43.setText(num[42]);
        btn44.setText(num[43]);
        btn45.setText(num[44]);
        btn46.setText(num[45]);
        btn47.setText(num[46]);
        btn48.setText(num[47]);
        btn49.setText(num[48]);
        btn50.setText(num[49]);
        btn51.setText(num[50]);
        btn52.setText(num[51]);
        btn53.setText(num[52]);
        btn54.setText(num[53]);
        btn55.setText(num[54]);
        btn56.setText(num[55]);
        btn57.setText(num[56]);
        btn58.setText(num[57]);
        btn59.setText(num[58]);
        btn60.setText(num[59]);
        btn61.setText(num[60]);
        btn62.setText(num[61]);
        btn63.setText(num[62]);
        btn64.setText(num[63]);
        btn65.setText(num[64]);
        btn66.setText(num[65]);
        btn67.setText(num[66]);
        btn68.setText(num[67]);
        btn69.setText(num[68]);
        btn70.setText(num[69]);
        btn71.setText(num[70]);
        btn72.setText(num[71]);
        btn73.setText(num[72]);
        btn74.setText(num[73]);
        btn75.setText(num[74]);
        btn76.setText(num[75]);
        btn77.setText(num[76]);
        btn78.setText(num[77]);
        btn79.setText(num[78]);
        btn80.setText(num[79]);
        btn81.setText(num[80]);
        clickListners();
    }

    private void initialize() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Data");
        btnActi = 0;
        Activated = 0;
        CurLvL = findViewById(R.id.CurLvL);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn10 = findViewById(R.id.button10);
        btn11 = findViewById(R.id.button11);
        btn12 = findViewById(R.id.button12);
        btn13 = findViewById(R.id.button13);
        btn14 = findViewById(R.id.button14);
        btn15 = findViewById(R.id.button15);
        btn16 = findViewById(R.id.button16);
        btn17 = findViewById(R.id.button17);
        btn18 = findViewById(R.id.button18);
        btn19 = findViewById(R.id.button19);
        btn20 = findViewById(R.id.button20);
        btn21 = findViewById(R.id.button21);
        btn22 = findViewById(R.id.button22);
        btn23 = findViewById(R.id.button23);
        btn24 = findViewById(R.id.button24);
        btn25 = findViewById(R.id.button25);
        btn26 = findViewById(R.id.button26);
        btn27 = findViewById(R.id.button27);
        btn28 = findViewById(R.id.button28);
        btn29 = findViewById(R.id.button29);
        btn30 = findViewById(R.id.button30);
        btn31 = findViewById(R.id.button31);
        btn32 = findViewById(R.id.button32);
        btn33 = findViewById(R.id.button33);
        btn34 = findViewById(R.id.button34);
        btn35 = findViewById(R.id.button35);
        btn36 = findViewById(R.id.button36);
        btn37 = findViewById(R.id.button37);
        btn38 = findViewById(R.id.button38);
        btn39 = findViewById(R.id.button39);
        btn40 = findViewById(R.id.button40);
        btn41 = findViewById(R.id.button41);
        btn42 = findViewById(R.id.button42);
        btn43 = findViewById(R.id.button43);
        btn44 = findViewById(R.id.button44);
        btn45 = findViewById(R.id.button45);
        btn46 = findViewById(R.id.button46);
        btn47 = findViewById(R.id.button47);
        btn48 = findViewById(R.id.button48);
        btn49 = findViewById(R.id.button49);
        btn50 = findViewById(R.id.button50);
        btn51 = findViewById(R.id.button51);
        btn52 = findViewById(R.id.button52);
        btn53 = findViewById(R.id.button53);
        btn54 = findViewById(R.id.button54);
        btn55 = findViewById(R.id.button55);
        btn56 = findViewById(R.id.button56);
        btn57 = findViewById(R.id.button57);
        btn58 = findViewById(R.id.button58);
        btn59 = findViewById(R.id.button59);
        btn60 = findViewById(R.id.button60);
        btn61 = findViewById(R.id.button61);
        btn62 = findViewById(R.id.button62);
        btn63 = findViewById(R.id.button63);
        btn64 = findViewById(R.id.button64);
        btn65 = findViewById(R.id.button65);
        btn66 = findViewById(R.id.button66);
        btn67 = findViewById(R.id.button67);
        btn68 = findViewById(R.id.button68);
        btn69 = findViewById(R.id.button69);
        btn70 = findViewById(R.id.button70);
        btn71 = findViewById(R.id.button71);
        btn72 = findViewById(R.id.button72);
        btn73 = findViewById(R.id.button73);
        btn74 = findViewById(R.id.button74);
        btn75 = findViewById(R.id.button75);
        btn76 = findViewById(R.id.button76);
        btn77 = findViewById(R.id.button77);
        btn78 = findViewById(R.id.button78);
        btn79 = findViewById(R.id.button79);
        btn80 = findViewById(R.id.button80);
        btn81 = findViewById(R.id.button81);

        press1 = findViewById(R.id.press1);
        press2 = findViewById(R.id.press2);
        press3 = findViewById(R.id.press3);
        press4 = findViewById(R.id.press4);
        press5 = findViewById(R.id.press5);
        press6 = findViewById(R.id.press6);
        press7 = findViewById(R.id.press7);
        press8 = findViewById(R.id.press8);
        press9 = findViewById(R.id.press9);

        press1.setTag(" ");
        press2.setTag(" ");
        press3.setTag(" ");
        press4.setTag(" ");
        press5.setTag(" ");
        press6.setTag(" ");
        press7.setTag(" ");
        press8.setTag(" ");
        press9.setTag(" ");

    }

    private void animation(int i) {
        if (i == 1) {
            btn1.setText("#");
        }
        if (i == 2) {
            btn1.setText("*");
            btn2.setText("#");
        }
        if (i == 3) {
            btn1.setText("-");
            btn2.setText("*");
            btn3.setText("#");
        }
        if (i == 4) {
            btn1.setText(" ");
            btn2.setText("-");
            btn3.setText("*");
            btn4.setText("#");
        }
        if (i == 5) {
            btn2.setText(" ");
            btn3.setText("-");
            btn4.setText("*");
            btn5.setText("#");
        }
        if (i == 6) {
            btn3.setText(" ");
            btn4.setText("-");
            btn5.setText("*");
            btn6.setText("#");
        }
        if (i == 7) {
            btn4.setText(" ");
            btn5.setText("-");
            btn6.setText("*");
            btn7.setText("#");
        }
        if (i == 8) {
            btn5.setText(" ");
            btn6.setText("-");
            btn7.setText("*");
            btn8.setText("#");
        }
        if (i == 9) {
            btn6.setText(" ");
            btn7.setText("-");
            btn8.setText("*");
            btn9.setText("#");
        }
        if (i == 10) {
            btn7.setText(" ");
            btn8.setText("-");
            btn9.setText("*");
            btn10.setText("#");
        }
        if (i == 11) {
            btn8.setText(" ");
            btn9.setText("-");
            btn10.setText("*");
            btn11.setText("#");
        }
        if (i == 12) {
            btn9.setText(" ");
            btn10.setText("-");
            btn11.setText("*");
            btn12.setText("#");
        }
        if (i == 13) {
            btn10.setText(" ");
            btn11.setText("-");
            btn12.setText("*");
            btn13.setText("#");
        }
        if (i == 14) {
            btn11.setText(" ");
            btn12.setText("-");
            btn13.setText("*");
            btn14.setText("#");
        }
        if (i == 15) {
            btn12.setText(" ");
            btn13.setText("-");
            btn14.setText("*");
            btn15.setText("#");
        }
        if (i == 16) {
            btn13.setText(" ");
            btn14.setText("-");
            btn15.setText("*");
            btn16.setText("#");
        }
        if (i == 17) {
            btn14.setText(" ");
            btn15.setText("-");
            btn16.setText("*");
            btn17.setText("#");
        }
        if (i == 18) {
            btn15.setText(" ");
            btn16.setText("-");
            btn17.setText("*");
            btn18.setText("#");
        }
        if (i == 19) {
            btn16.setText(" ");
            btn17.setText("-");
            btn18.setText("*");
            btn19.setText("#");
        }
        if (i == 20) {
            btn17.setText(" ");
            btn18.setText("-");
            btn19.setText("*");
            btn20.setText("#");
        }
        if (i == 21) {
            btn18.setText(" ");
            btn19.setText("-");
            btn20.setText("*");
            btn21.setText("#");
        }
        if (i == 22) {
            btn19.setText(" ");
            btn20.setText("-");
            btn21.setText("*");
            btn22.setText("#");
        }
        if (i == 23) {
            btn20.setText(" ");
            btn21.setText("-");
            btn22.setText("*");
            btn23.setText("#");
        }
        if (i == 24) {
            btn21.setText(" ");
            btn22.setText("-");
            btn23.setText("*");
            btn24.setText("#");
        }
        if (i == 25) {
            btn22.setText(" ");
            btn23.setText("-");
            btn24.setText("*");
            btn25.setText("#");
        }
        if (i == 26) {
            btn23.setText(" ");
            btn24.setText("-");
            btn25.setText("*");
            btn26.setText("#");
        }
        if (i == 27) {
            btn24.setText(" ");
            btn25.setText("-");
            btn26.setText("*");
            btn27.setText("#");
        }
        if (i == 28) {
            btn25.setText(" ");
            btn26.setText("-");
            btn27.setText("*");
            btn28.setText("#");
        }
        if (i == 29) {
            btn26.setText(" ");
            btn27.setText("-");
            btn28.setText("*");
            btn29.setText("#");
        }
        if (i == 30) {
            btn27.setText(" ");
            btn28.setText("-");
            btn29.setText("*");
            btn30.setText("#");
        }
        if (i == 31) {
            btn28.setText(" ");
            btn29.setText("-");
            btn30.setText("*");
            btn31.setText("#");
        }
        if (i == 32) {
            btn29.setText(" ");
            btn30.setText("-");
            btn31.setText("*");
            btn32.setText("#");
        }
        if (i == 33) {
            btn30.setText(" ");
            btn31.setText("-");
            btn32.setText("*");
            btn33.setText("#");
        }
        if (i == 34) {
            btn31.setText(" ");
            btn32.setText("-");
            btn33.setText("*");
            btn34.setText("#");
        }
        if (i == 35) {
            btn32.setText(" ");
            btn33.setText("-");
            btn34.setText("*");
            btn35.setText("#");
        }
        if (i == 36) {
            btn33.setText(" ");
            btn34.setText("-");
            btn35.setText("*");
            btn36.setText("#");
        }
        if (i == 37) {
            btn34.setText(" ");
            btn35.setText("-");
            btn36.setText("*");
            btn37.setText("#");
        }
        if (i == 38) {
            btn35.setText(" ");
            btn36.setText("-");
            btn37.setText("*");
            btn38.setText("#");
        }
        if (i == 39) {
            btn36.setText(" ");
            btn37.setText("-");
            btn38.setText("*");
            btn39.setText("#");
        }
        if (i == 40) {
            btn37.setText(" ");
            btn38.setText("-");
            btn39.setText("*");
            btn40.setText("#");
        }
        if (i == 41) {
            btn38.setText(" ");
            btn39.setText("-");
            btn40.setText("*");
            btn41.setText("#");
        }
        if (i == 42) {
            btn39.setText(" ");
            btn40.setText("-");
            btn41.setText("*");
            btn42.setText("#");
        }
        if (i == 43) {
            btn40.setText(" ");
            btn41.setText("-");
            btn42.setText("*");
            btn43.setText("#");
        }
        if (i == 44) {
            btn41.setText(" ");
            btn42.setText("-");
            btn43.setText("*");
            btn44.setText("#");
        }
        if (i == 45) {
            btn42.setText(" ");
            btn43.setText("-");
            btn44.setText("*");
            btn45.setText("#");
        }
        if (i == 46) {
            btn43.setText(" ");
            btn44.setText("-");
            btn45.setText("*");
            btn46.setText("#");
        }
        if (i == 47) {
            btn44.setText(" ");
            btn45.setText("-");
            btn46.setText("*");
            btn47.setText("#");
        }
        if (i == 48) {
            btn45.setText(" ");
            btn46.setText("-");
            btn47.setText("*");
            btn48.setText("#");
        }
        if (i == 49) {
            btn46.setText(" ");
            btn47.setText("-");
            btn48.setText("*");
            btn49.setText("#");
        }
        if (i == 50) {
            btn47.setText(" ");
            btn48.setText("-");
            btn49.setText("*");
            btn50.setText("#");
        }
        if (i == 51) {
            btn48.setText(" ");
            btn49.setText("-");
            btn50.setText("*");
            btn51.setText("#");
        }
        if (i == 52) {
            btn49.setText(" ");
            btn50.setText("-");
            btn51.setText("*");
            btn52.setText("#");
        }
        if (i == 53) {
            btn50.setText(" ");
            btn51.setText("-");
            btn52.setText("*");
            btn53.setText("#");
        }
        if (i == 54) {
            btn51.setText(" ");
            btn52.setText("-");
            btn53.setText("*");
            btn54.setText("#");
        }
        if (i == 55) {
            btn52.setText(" ");
            btn53.setText("-");
            btn54.setText("*");
            btn55.setText("#");
        }
        if (i == 56) {
            btn53.setText(" ");
            btn54.setText("-");
            btn55.setText("*");
            btn56.setText("#");
        }
        if (i == 57) {
            btn54.setText(" ");
            btn55.setText("-");
            btn56.setText("*");
            btn57.setText("#");
        }
        if (i == 58) {
            btn55.setText(" ");
            btn56.setText("-");
            btn57.setText("*");
            btn58.setText("#");
        }
        if (i == 59) {
            btn56.setText(" ");
            btn57.setText("-");
            btn58.setText("*");
            btn59.setText("#");
        }
        if (i == 60) {
            btn57.setText(" ");
            btn58.setText("-");
            btn59.setText("*");
            btn60.setText("#");
        }
        if (i == 61) {
            btn58.setText(" ");
            btn59.setText("-");
            btn60.setText("*");
            btn61.setText("#");
        }
        if (i == 62) {
            btn59.setText(" ");
            btn60.setText("-");
            btn61.setText("*");
            btn62.setText("#");
        }
        if (i == 63) {
            btn60.setText(" ");
            btn61.setText("-");
            btn62.setText("*");
            btn63.setText("#");
        }
        if (i == 64) {
            btn61.setText(" ");
            btn62.setText("-");
            btn63.setText("*");
            btn64.setText("#");
        }
        if (i == 65) {
            btn62.setText(" ");
            btn63.setText("-");
            btn64.setText("*");
            btn65.setText("#");
        }
        if (i == 66) {
            btn63.setText(" ");
            btn64.setText("-");
            btn65.setText("*");
            btn66.setText("#");
        }
        if (i == 67) {
            btn64.setText(" ");
            btn65.setText("-");
            btn66.setText("*");
            btn67.setText("#");
        }
        if (i == 68) {
            btn65.setText(" ");
            btn66.setText("-");
            btn67.setText("*");
            btn68.setText("#");
        }
        if (i == 69) {
            btn66.setText(" ");
            btn67.setText("-");
            btn68.setText("*");
            btn69.setText("#");
        }
        if (i == 70) {
            btn67.setText(" ");
            btn68.setText("-");
            btn69.setText("*");
            btn70.setText("#");
        }
        if (i == 71) {
            btn68.setText(" ");
            btn69.setText("-");
            btn70.setText("*");
            btn71.setText("#");
        }
        if (i == 72) {
            btn69.setText(" ");
            btn70.setText("-");
            btn71.setText("*");
            btn72.setText("#");
        }
        if (i == 73) {
            btn70.setText(" ");
            btn71.setText("-");
            btn72.setText("*");
            btn73.setText("#");
        }
        if (i == 74) {
            btn71.setText(" ");
            btn72.setText("-");
            btn73.setText("*");
            btn74.setText("#");
        }
        if (i == 75) {
            btn72.setText(" ");
            btn73.setText("-");
            btn74.setText("*");
            btn75.setText("#");
        }
        if (i == 76) {
            btn73.setText(" ");
            btn74.setText("-");
            btn75.setText("*");
            btn76.setText("#");
        }
        if (i == 77) {
            btn74.setText(" ");
            btn75.setText("-");
            btn76.setText("*");
            btn77.setText("#");
        }
        if (i == 78) {
            btn75.setText(" ");
            btn76.setText("-");
            btn77.setText("*");
            btn78.setText("#");
        }
        if (i == 79) {
            btn76.setText(" ");
            btn77.setText("-");
            btn78.setText("*");
            btn79.setText("#");
        }
        if (i == 80) {
            btn77.setText(" ");
            btn78.setText("-");
            btn79.setText("*");
            btn80.setText("#");
        }
        if (i == 81) {
            btn78.setText(" ");
            btn79.setText("-");
            btn80.setText("*");
            btn81.setText("#");
        }
        if (i == 82) {
            btn79.setText(" ");
            btn80.setText("-");
            btn81.setText("*");

        }
        if (i == 83) {
            btn80.setText(" ");
            btn81.setText("-");

        }
        if (i == 84) {
            btn81.setText(" ");
            setData();
            setData();
        }
    }
}