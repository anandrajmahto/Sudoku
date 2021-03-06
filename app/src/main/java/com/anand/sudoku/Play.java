package com.anand.sudoku;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
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
            press1, press2, press3, press4, press5, press6, press7, press8, press9,
            erase;
ImageView life1,life2,life3;
    TextView CurLvL;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String[] num;
    Button[] btnA;
    int Activated;
    private boolean remove;
     int lifeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        initialize();
        //   level();


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

    private void clickListeners() {
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if (remove){
                 remove=false;

                 erase.setBackgroundColor(getResources().getColor(R.color.trans));
                 blinkChk(0);
             }else{
                 remove=true;
                 blinkChk(0);
                 erase.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                 Activated=0;
                 press1.setBackgroundColor(getResources().getColor(R.color.trans));
                 press2.setBackgroundColor(getResources().getColor(R.color.trans));
                 press3.setBackgroundColor(getResources().getColor(R.color.trans));
                 press4.setBackgroundColor(getResources().getColor(R.color.trans));
                 press5.setBackgroundColor(getResources().getColor(R.color.trans));
                 press6.setBackgroundColor(getResources().getColor(R.color.trans));
                 press7.setBackgroundColor(getResources().getColor(R.color.trans));
                 press8.setBackgroundColor(getResources().getColor(R.color.trans));
                 press9.setBackgroundColor(getResources().getColor(R.color.trans));
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

            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // numFill();
                clickListeners1(1, btn1, 1);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(2, btn2, 1);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(3, btn3, 1);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(4, btn4, 2);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(5, btn5, 2);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(6, btn6, 2);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(7, btn7, 3);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(8, btn8, 3);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(9, btn9, 3);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(10, btn10, 1);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(11, btn11, 1);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(12, btn12, 1);
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(13, btn13, 2);
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(14, btn14, 2);
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(15, btn15, 2);
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(16, btn16, 3);
            }
        });
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(17, btn17, 3);
            }
        });
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(18, btn18, 3);
            }
        });
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(19, btn19, 1);
            }
        });
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(20, btn20, 1);
            }
        });
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(21, btn21, 1);
            }
        });
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(22, btn22, 2);
            }
        });
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(23, btn23, 2);
            }
        });
        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(24, btn24, 2);
            }
        });
        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(25, btn25, 3);
            }
        });
        btn26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(26, btn26, 3);
            }
        });
        btn27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(27, btn27, 3);
            }
        });
        btn28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(28, btn28, 4);
            }
        });
        btn29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(29, btn29, 4);
            }
        });
        btn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(30, btn30, 4);
            }
        });
        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(31, btn31, 5);
            }
        });
        btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(32, btn32, 5);
            }
        });
        btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(33, btn33, 5);
            }
        });
        btn34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(34, btn34, 6);
            }
        });
        btn35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(35, btn35, 6);
            }
        });
        btn36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(36, btn36, 6);
            }
        });
        btn37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(37, btn37, 4);
            }
        });
        btn38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(38, btn38, 4);
            }
        });
        btn39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(39, btn39, 4);
            }
        });
        btn40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(40, btn40, 5);
            }
        });
        btn41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(41, btn41, 5);
            }
        });
        btn42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(42, btn42, 5);
            }
        });
        btn43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(43, btn43, 6);
            }
        });
        btn44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(44, btn44, 6);
            }
        });
        btn45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(45, btn45, 6);
            }
        });
        btn46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(46, btn46, 4);
            }
        });
        btn47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(47, btn47, 4);
            }
        });
        btn48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(48, btn48, 4);
            }
        });
        btn49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(49, btn49, 5);
            }
        });
        btn50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(50, btn50, 5);
            }
        });
        btn51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(51, btn51, 5);
            }
        });
        btn52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(52, btn52, 6);
            }
        });
        btn53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(53, btn53, 6);
            }
        });
        btn54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(54, btn54, 6);
            }
        });
        btn55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(55, btn55, 7);
            }
        });
        btn56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(56, btn56, 7);
            }
        });
        btn57.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(57, btn57, 7);
            }
        });
        btn58.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(58, btn58, 8);
            }
        });
        btn59.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(59, btn59, 8);
            }
        });
        btn60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(60, btn60, 8);
            }
        });
        btn61.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(61, btn61, 9);
            }
        });
        btn62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(62, btn62, 9);
            }
        });
        btn63.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(63, btn63, 9);
            }
        });
        btn64.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(64, btn64, 7);
            }
        });
        btn65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(65, btn65, 7);
            }
        });
        btn66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(66, btn66, 7);
            }
        });
        btn67.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(67, btn67, 8);
            }
        });
        btn68.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(68, btn68, 8);
            }
        });
        btn69.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(69, btn69, 8);
            }
        });
        btn70.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(70, btn70, 9);
            }
        });
        btn71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(71, btn71, 9);
            }
        });
        btn72.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(72, btn72, 9);
            }
        });
        btn73.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(73, btn73, 7);
            }
        });
        btn74.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(74, btn74, 7);
            }
        });
        btn75.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(75, btn75, 7);
            }
        });
        btn76.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(76, btn76, 8);
            }
        });
        btn77.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(77, btn77, 8);
            }
        });
        btn78.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(78, btn78, 8);
            }
        });
        btn79.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(79, btn79, 9);
            }
        });
        btn80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(80, btn80, 9);
            }
        });
        btn81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListeners1(81, btn81, 9);
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
                    erase.setBackgroundColor(getResources().getColor(R.color.trans));
remove=false;
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
                    blinkChk(0);
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
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));    erase.setBackgroundColor(getResources().getColor(R.color.trans));
                    remove=false;
                    blinkChk(2);
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
                    blinkChk(0);
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
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));    erase.setBackgroundColor(getResources().getColor(R.color.trans));
                    remove=false;
                    blinkChk(3);
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
                    blinkChk(0);
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
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));    erase.setBackgroundColor(getResources().getColor(R.color.trans));
                    remove=false;
                    blinkChk(4);
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
                    blinkChk(0);
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
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));    erase.setBackgroundColor(getResources().getColor(R.color.trans));
                    remove=false;
                    blinkChk(5);
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
                    blinkChk(0);
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
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));    erase.setBackgroundColor(getResources().getColor(R.color.trans));
                    remove=false;
                    blinkChk(6);
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
                    blinkChk(0);
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
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));    erase.setBackgroundColor(getResources().getColor(R.color.trans));
                    remove=false;
                    blinkChk(7);
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
                    blinkChk(0);
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
                    press9.setBackgroundColor(getResources().getColor(R.color.trans));    erase.setBackgroundColor(getResources().getColor(R.color.trans));
                    remove=false;
                    blinkChk(8);
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
                    blinkChk(0);
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
                    press8.setBackgroundColor(getResources().getColor(R.color.trans));    erase.setBackgroundColor(getResources().getColor(R.color.trans));
                    remove=false;
                    blinkChk(9);

                }
            }
        });

    }

    private void numFill() {

        for (int i = 0; i < btnA.length; i++) {
            btnA[i].setText(String.valueOf(i + 1));
        }
    }

    private void clickListeners1(int pos, Button btn, int grp) {
        if (remove) {
            if (btn.getTag().toString() != " ") {
                btn.setText(" ");
            }
        } else {
            if (btn.getText().toString().equals(" ")) {
                Log.e("btn1 up", btn.getText().toString());
                if (Activated == 0) {
                    Toast.makeText(Play.this, "Select a number", Toast.LENGTH_SHORT).show();
                } else {
                    resChk(btn, Activated, grp, pos);

                }
            } else {
                Log.e("btn1", btn.getText().toString());
                btn.setBackgroundColor(getResources().getColor(R.color.red));
                Thread one = new Thread() {
                    public void run() {
                        try {
                            Thread.sleep(200);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    btn.setBackgroundColor(getResources().getColor(R.color.trans));
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

    private void resChk(Button btn, int active, int grpChk, int pos) {
        if (grpChk == 1) {
            if ((btn1.getText().toString().equals(String.valueOf(active))) || (btn2.getText().toString().equals(String.valueOf(active))) || (btn3.getText().toString().equals(String.valueOf(active)))
                    || (btn10.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active)))
                    || (btn19.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active)))) {
                blinkOne(btn);
            } else {
                if (pos == 1) {
                    if ((btn1.getText().toString().equals(String.valueOf(active))) || (btn10.getText().toString().equals(String.valueOf(active))) || (btn19.getText().toString().equals(String.valueOf(active))) || (btn28.getText().toString().equals(String.valueOf(active))) || (btn37.getText().toString().equals(String.valueOf(active))) || (btn46.getText().toString().equals(String.valueOf(active))) || (btn55.getText().toString().equals(String.valueOf(active))) || (btn64.getText().toString().equals(String.valueOf(active))) || (btn73.getText().toString().equals(String.valueOf(active))) ||
                            (btn1.getText().toString().equals(String.valueOf(active))) || (btn2.getText().toString().equals(String.valueOf(active))) || (btn3.getText().toString().equals(String.valueOf(active))) || (btn4.getText().toString().equals(String.valueOf(active))) || (btn5.getText().toString().equals(String.valueOf(active))) || (btn6.getText().toString().equals(String.valueOf(active))) || (btn7.getText().toString().equals(String.valueOf(active))) || (btn8.getText().toString().equals(String.valueOf(active))) || (btn9.getText().toString().equals(String.valueOf(active)))


                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));


                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 2) {
                    if ((btn2.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) ||
                            (btn1.getText().toString().equals(String.valueOf(active))) || (btn2.getText().toString().equals(String.valueOf(active))) || (btn3.getText().toString().equals(String.valueOf(active))) || (btn4.getText().toString().equals(String.valueOf(active))) || (btn5.getText().toString().equals(String.valueOf(active))) || (btn6.getText().toString().equals(String.valueOf(active))) || (btn7.getText().toString().equals(String.valueOf(active))) || (btn8.getText().toString().equals(String.valueOf(active))) || (btn9.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 3) {
                    if ((btn3.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) ||
                            (btn1.getText().toString().equals(String.valueOf(active))) || (btn2.getText().toString().equals(String.valueOf(active))) || (btn3.getText().toString().equals(String.valueOf(active))) || (btn4.getText().toString().equals(String.valueOf(active))) || (btn5.getText().toString().equals(String.valueOf(active))) || (btn6.getText().toString().equals(String.valueOf(active))) || (btn7.getText().toString().equals(String.valueOf(active))) || (btn8.getText().toString().equals(String.valueOf(active))) || (btn9.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 10) {
                    if ((btn1.getText().toString().equals(String.valueOf(active))) || (btn10.getText().toString().equals(String.valueOf(active))) || (btn19.getText().toString().equals(String.valueOf(active))) || (btn28.getText().toString().equals(String.valueOf(active))) || (btn37.getText().toString().equals(String.valueOf(active))) || (btn46.getText().toString().equals(String.valueOf(active))) || (btn55.getText().toString().equals(String.valueOf(active))) || (btn64.getText().toString().equals(String.valueOf(active))) || (btn73.getText().toString().equals(String.valueOf(active))) ||
                            (btn10.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 11) {
                    if ((btn2.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) ||
                            (btn10.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 12) {
                    if ((btn3.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) ||
                            (btn10.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 19) {
                    if ((btn1.getText().toString().equals(String.valueOf(active))) || (btn10.getText().toString().equals(String.valueOf(active))) || (btn19.getText().toString().equals(String.valueOf(active))) || (btn28.getText().toString().equals(String.valueOf(active))) || (btn37.getText().toString().equals(String.valueOf(active))) || (btn46.getText().toString().equals(String.valueOf(active))) || (btn55.getText().toString().equals(String.valueOf(active))) || (btn64.getText().toString().equals(String.valueOf(active))) || (btn73.getText().toString().equals(String.valueOf(active))) ||
                            (btn19.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 20) {
                    if ((btn2.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) ||
                            (btn19.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 21) {
                    if ((btn3.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) ||
                            (btn19.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }

                result();
            }
        } else if (grpChk == 2) {
            if ((btn4.getText().toString().equals(String.valueOf(active))) || (btn5.getText().toString().equals(String.valueOf(active))) || (btn6.getText().toString().equals(String.valueOf(active)))
                    || (btn13.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active)))
                    || (btn22.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active)))) {
                blinkOne(btn);
            } else {

                if (pos == 4) {
                    if ((btn4.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) ||
                            (btn1.getText().toString().equals(String.valueOf(active))) || (btn2.getText().toString().equals(String.valueOf(active))) || (btn3.getText().toString().equals(String.valueOf(active))) || (btn4.getText().toString().equals(String.valueOf(active))) || (btn5.getText().toString().equals(String.valueOf(active))) || (btn6.getText().toString().equals(String.valueOf(active))) || (btn7.getText().toString().equals(String.valueOf(active))) || (btn8.getText().toString().equals(String.valueOf(active))) || (btn9.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 5) {
                    if ((btn5.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) ||
                            (btn1.getText().toString().equals(String.valueOf(active))) || (btn2.getText().toString().equals(String.valueOf(active))) || (btn3.getText().toString().equals(String.valueOf(active))) || (btn4.getText().toString().equals(String.valueOf(active))) || (btn5.getText().toString().equals(String.valueOf(active))) || (btn6.getText().toString().equals(String.valueOf(active))) || (btn7.getText().toString().equals(String.valueOf(active))) || (btn8.getText().toString().equals(String.valueOf(active))) || (btn9.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 6) {
                    if ((btn6.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) ||
                            (btn1.getText().toString().equals(String.valueOf(active))) || (btn2.getText().toString().equals(String.valueOf(active))) || (btn3.getText().toString().equals(String.valueOf(active))) || (btn4.getText().toString().equals(String.valueOf(active))) || (btn5.getText().toString().equals(String.valueOf(active))) || (btn6.getText().toString().equals(String.valueOf(active))) || (btn7.getText().toString().equals(String.valueOf(active))) || (btn8.getText().toString().equals(String.valueOf(active))) || (btn9.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 13) {
                    if ((btn4.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) ||
                            (btn10.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 14) {
                    if ((btn5.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) ||
                            (btn10.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 15) {
                    if ((btn6.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) ||
                            (btn10.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 22) {
                    if ((btn4.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) ||
                            (btn19.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 23) {
                    if ((btn5.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) ||
                            (btn19.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 24) {
                    if ((btn6.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) ||
                            (btn19.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }

                result();
            }
        } else if (grpChk == 3) {
            if ((btn7.getText().toString().equals(String.valueOf(active))) || (btn8.getText().toString().equals(String.valueOf(active))) || (btn9.getText().toString().equals(String.valueOf(active)))
                    || (btn16.getText().toString().equals(String.valueOf(active))) || (btn7.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active)))
                    || (btn25.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active)))) {
                blinkOne(btn);
            } else {

                if (pos == 7) {
                    if ((btn7.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) ||
                            (btn1.getText().toString().equals(String.valueOf(active))) || (btn2.getText().toString().equals(String.valueOf(active))) || (btn3.getText().toString().equals(String.valueOf(active))) || (btn4.getText().toString().equals(String.valueOf(active))) || (btn5.getText().toString().equals(String.valueOf(active))) || (btn6.getText().toString().equals(String.valueOf(active))) || (btn7.getText().toString().equals(String.valueOf(active))) || (btn8.getText().toString().equals(String.valueOf(active))) || (btn9.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 8) {
                    if ((btn8.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) ||
                            (btn1.getText().toString().equals(String.valueOf(active))) || (btn2.getText().toString().equals(String.valueOf(active))) || (btn3.getText().toString().equals(String.valueOf(active))) || (btn4.getText().toString().equals(String.valueOf(active))) || (btn5.getText().toString().equals(String.valueOf(active))) || (btn6.getText().toString().equals(String.valueOf(active))) || (btn7.getText().toString().equals(String.valueOf(active))) || (btn8.getText().toString().equals(String.valueOf(active))) || (btn9.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 9) {
                    if ((btn9.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active))) ||
                            (btn1.getText().toString().equals(String.valueOf(active))) || (btn2.getText().toString().equals(String.valueOf(active))) || (btn3.getText().toString().equals(String.valueOf(active))) || (btn4.getText().toString().equals(String.valueOf(active))) || (btn5.getText().toString().equals(String.valueOf(active))) || (btn6.getText().toString().equals(String.valueOf(active))) || (btn7.getText().toString().equals(String.valueOf(active))) || (btn8.getText().toString().equals(String.valueOf(active))) || (btn9.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 16) {
                    if ((btn7.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) ||
                            (btn10.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 17) {
                    if ((btn8.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) ||
                            (btn10.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 18) {
                    if ((btn9.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active))) ||
                            (btn10.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 25) {
                    if ((btn7.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) ||
                            (btn19.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 26) {
                    if ((btn8.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) ||
                            (btn19.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 27) {
                    if ((btn9.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active))) ||
                            (btn19.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }

                result();
            }
        } else if (grpChk == 4) {
            if ((btn28.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active)))
                    || (btn37.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active)))
                    || (btn46.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active)))) {
                blinkOne(btn);
            } else {

                if (pos == 28) {
                    if ((btn1.getText().toString().equals(String.valueOf(active))) || (btn10.getText().toString().equals(String.valueOf(active))) || (btn19.getText().toString().equals(String.valueOf(active))) || (btn28.getText().toString().equals(String.valueOf(active))) || (btn37.getText().toString().equals(String.valueOf(active))) || (btn46.getText().toString().equals(String.valueOf(active))) || (btn55.getText().toString().equals(String.valueOf(active))) || (btn64.getText().toString().equals(String.valueOf(active))) || (btn73.getText().toString().equals(String.valueOf(active))) ||
                            (btn28.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active)))


                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 29) {
                    if ((btn2.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) ||
                            (btn28.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 30) {
                    if ((btn3.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) ||
                            (btn28.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 37) {
                    if ((btn1.getText().toString().equals(String.valueOf(active))) || (btn10.getText().toString().equals(String.valueOf(active))) || (btn19.getText().toString().equals(String.valueOf(active))) || (btn28.getText().toString().equals(String.valueOf(active))) || (btn37.getText().toString().equals(String.valueOf(active))) || (btn46.getText().toString().equals(String.valueOf(active))) || (btn55.getText().toString().equals(String.valueOf(active))) || (btn64.getText().toString().equals(String.valueOf(active))) || (btn73.getText().toString().equals(String.valueOf(active))) ||
                            (btn37.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 38) {
                    if ((btn2.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) ||
                            (btn37.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 39) {
                    if ((btn3.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) ||
                            (btn37.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 46) {
                    if ((btn1.getText().toString().equals(String.valueOf(active))) || (btn10.getText().toString().equals(String.valueOf(active))) || (btn19.getText().toString().equals(String.valueOf(active))) || (btn28.getText().toString().equals(String.valueOf(active))) || (btn37.getText().toString().equals(String.valueOf(active))) || (btn46.getText().toString().equals(String.valueOf(active))) || (btn55.getText().toString().equals(String.valueOf(active))) || (btn64.getText().toString().equals(String.valueOf(active))) || (btn73.getText().toString().equals(String.valueOf(active))) ||
                            (btn46.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 47) {
                    if ((btn2.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) ||
                            (btn46.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 48) {
                    if ((btn3.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) ||
                            (btn46.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }

                result();
            }
        } else if (grpChk == 5) {
            if ((btn31.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active)))
                    || (btn40.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active)))
                    || (btn49.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active)))) {
                blinkOne(btn);
            } else {

                if (pos == 31) {
                    if ((btn4.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) ||
                            (btn28.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 32) {
                    if ((btn5.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) ||
                            (btn28.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 33) {
                    if ((btn6.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) ||
                            (btn28.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 40) {
                    if ((btn4.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) ||
                            (btn37.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 41) {
                    if ((btn5.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) ||
                            (btn37.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 42) {
                    if ((btn6.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) ||
                            (btn37.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 49) {
                    if ((btn4.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) ||
                            (btn46.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 50) {
                    if ((btn5.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) ||
                            (btn46.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 51) {
                    if ((btn6.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) ||
                            (btn46.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }

                result();
            }
        } else if (grpChk == 6) {
            if ((btn34.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active)))
                    || (btn43.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active)))
                    || (btn52.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active)))) {
                blinkOne(btn);
            } else {
                if (pos == 34) {
                    if ((btn7.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) ||
                            (btn28.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 35) {
                    if ((btn8.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) ||
                            (btn28.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 36) {
                    if ((btn9.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active))) ||
                            (btn28.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 43) {
                    if ((btn7.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) ||
                            (btn37.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 44) {
                    if ((btn8.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) ||
                            (btn37.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 45) {
                    if ((btn9.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active))) ||
                            (btn37.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 52) {
                    if ((btn7.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) ||
                            (btn46.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 53) {
                    if ((btn8.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) ||
                            (btn46.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 54) {
                    if ((btn9.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active))) ||
                            (btn46.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }

                result();
            }
        } else if (grpChk == 7) {
            if ((btn55.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active)))
                    || (btn64.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active)))
                    || (btn73.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active)))) {
                blinkOne(btn);
            } else {

                if (pos == 55) {
                    if ((btn1.getText().toString().equals(String.valueOf(active))) || (btn10.getText().toString().equals(String.valueOf(active))) || (btn19.getText().toString().equals(String.valueOf(active))) || (btn28.getText().toString().equals(String.valueOf(active))) || (btn37.getText().toString().equals(String.valueOf(active))) || (btn46.getText().toString().equals(String.valueOf(active))) || (btn55.getText().toString().equals(String.valueOf(active))) || (btn64.getText().toString().equals(String.valueOf(active))) || (btn73.getText().toString().equals(String.valueOf(active))) ||
                            (btn55.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active)))


                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 56) {
                    if ((btn2.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) ||
                            (btn55.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 57) {
                    if ((btn3.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) ||
                            (btn55.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 64) {
                    if ((btn1.getText().toString().equals(String.valueOf(active))) || (btn10.getText().toString().equals(String.valueOf(active))) || (btn19.getText().toString().equals(String.valueOf(active))) || (btn28.getText().toString().equals(String.valueOf(active))) || (btn37.getText().toString().equals(String.valueOf(active))) || (btn46.getText().toString().equals(String.valueOf(active))) || (btn55.getText().toString().equals(String.valueOf(active))) || (btn64.getText().toString().equals(String.valueOf(active))) || (btn73.getText().toString().equals(String.valueOf(active))) ||
                            (btn64.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 65) {
                    if ((btn2.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) ||
                            (btn64.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 66) {
                    if ((btn3.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) ||
                            (btn64.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 73) {
                    if ((btn1.getText().toString().equals(String.valueOf(active))) || (btn10.getText().toString().equals(String.valueOf(active))) || (btn19.getText().toString().equals(String.valueOf(active))) || (btn28.getText().toString().equals(String.valueOf(active))) || (btn37.getText().toString().equals(String.valueOf(active))) || (btn46.getText().toString().equals(String.valueOf(active))) || (btn55.getText().toString().equals(String.valueOf(active))) || (btn64.getText().toString().equals(String.valueOf(active))) || (btn73.getText().toString().equals(String.valueOf(active))) ||
                            (btn73.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 74) {
                    if ((btn2.getText().toString().equals(String.valueOf(active))) || (btn11.getText().toString().equals(String.valueOf(active))) || (btn20.getText().toString().equals(String.valueOf(active))) || (btn29.getText().toString().equals(String.valueOf(active))) || (btn38.getText().toString().equals(String.valueOf(active))) || (btn47.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) ||
                            (btn73.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 75) {
                    if ((btn3.getText().toString().equals(String.valueOf(active))) || (btn12.getText().toString().equals(String.valueOf(active))) || (btn21.getText().toString().equals(String.valueOf(active))) || (btn30.getText().toString().equals(String.valueOf(active))) || (btn39.getText().toString().equals(String.valueOf(active))) || (btn48.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) ||
                            (btn73.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }

                result();
            }
        } else if (grpChk == 8) {
            if ((btn58.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active)))
                    || (btn67.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active)))
                    || (btn76.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active)))) {
                blinkOne(btn);
            } else {

                if (pos == 58) {
                    if ((btn4.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) ||
                            (btn55.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 59) {
                    if ((btn5.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) ||
                            (btn55.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 60) {
                    if ((btn6.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) ||
                            (btn55.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 67) {
                    if ((btn4.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) ||
                            (btn64.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 68) {
                    if ((btn5.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) ||
                            (btn64.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 69) {
                    if ((btn6.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) ||
                            (btn64.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 76) {
                    if ((btn4.getText().toString().equals(String.valueOf(active))) || (btn13.getText().toString().equals(String.valueOf(active))) || (btn22.getText().toString().equals(String.valueOf(active))) || (btn31.getText().toString().equals(String.valueOf(active))) || (btn40.getText().toString().equals(String.valueOf(active))) || (btn49.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) ||
                            (btn73.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 77) {
                    if ((btn5.getText().toString().equals(String.valueOf(active))) || (btn14.getText().toString().equals(String.valueOf(active))) || (btn23.getText().toString().equals(String.valueOf(active))) || (btn32.getText().toString().equals(String.valueOf(active))) || (btn41.getText().toString().equals(String.valueOf(active))) || (btn50.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) ||
                            (btn73.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 78) {
                    if ((btn6.getText().toString().equals(String.valueOf(active))) || (btn15.getText().toString().equals(String.valueOf(active))) || (btn24.getText().toString().equals(String.valueOf(active))) || (btn33.getText().toString().equals(String.valueOf(active))) || (btn42.getText().toString().equals(String.valueOf(active))) || (btn51.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) ||
                            (btn73.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }

                result();
            }
        } else if (grpChk == 9) {
            if ((btn61.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active)))
                    || (btn70.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active)))
                    || (btn79.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active)))) {
                blinkOne(btn);
            } else {

                if (pos == 61) {
                    if ((btn7.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) ||
                            (btn55.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 62) {
                    if ((btn8.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) ||
                            (btn55.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 63) {
                    if ((btn9.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active))) ||
                            (btn55.getText().toString().equals(String.valueOf(active))) || (btn56.getText().toString().equals(String.valueOf(active))) || (btn57.getText().toString().equals(String.valueOf(active))) || (btn58.getText().toString().equals(String.valueOf(active))) || (btn59.getText().toString().equals(String.valueOf(active))) || (btn60.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 70) {
                    if ((btn7.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) ||
                            (btn64.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 71) {
                    if ((btn8.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) ||
                            (btn64.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 72) {
                    if ((btn9.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active))) ||
                            (btn64.getText().toString().equals(String.valueOf(active))) || (btn65.getText().toString().equals(String.valueOf(active))) || (btn66.getText().toString().equals(String.valueOf(active))) || (btn67.getText().toString().equals(String.valueOf(active))) || (btn68.getText().toString().equals(String.valueOf(active))) || (btn69.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active)))
                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 79) {
                    if ((btn7.getText().toString().equals(String.valueOf(active))) || (btn16.getText().toString().equals(String.valueOf(active))) || (btn25.getText().toString().equals(String.valueOf(active))) || (btn34.getText().toString().equals(String.valueOf(active))) || (btn43.getText().toString().equals(String.valueOf(active))) || (btn52.getText().toString().equals(String.valueOf(active))) || (btn61.getText().toString().equals(String.valueOf(active))) || (btn70.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) ||
                            (btn73.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active)))

                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 80) {
                    if ((btn8.getText().toString().equals(String.valueOf(active))) || (btn17.getText().toString().equals(String.valueOf(active))) || (btn26.getText().toString().equals(String.valueOf(active))) || (btn35.getText().toString().equals(String.valueOf(active))) || (btn44.getText().toString().equals(String.valueOf(active))) || (btn53.getText().toString().equals(String.valueOf(active))) || (btn62.getText().toString().equals(String.valueOf(active))) || (btn71.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) ||
                            (btn73.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active)))

                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }
                if (pos == 81) {
                    if ((btn9.getText().toString().equals(String.valueOf(active))) || (btn18.getText().toString().equals(String.valueOf(active))) || (btn27.getText().toString().equals(String.valueOf(active))) || (btn36.getText().toString().equals(String.valueOf(active))) || (btn45.getText().toString().equals(String.valueOf(active))) || (btn54.getText().toString().equals(String.valueOf(active))) || (btn63.getText().toString().equals(String.valueOf(active))) || (btn72.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active))) ||
                            (btn73.getText().toString().equals(String.valueOf(active))) || (btn74.getText().toString().equals(String.valueOf(active))) || (btn75.getText().toString().equals(String.valueOf(active))) || (btn76.getText().toString().equals(String.valueOf(active))) || (btn77.getText().toString().equals(String.valueOf(active))) || (btn78.getText().toString().equals(String.valueOf(active))) || (btn79.getText().toString().equals(String.valueOf(active))) || (btn80.getText().toString().equals(String.valueOf(active))) || (btn81.getText().toString().equals(String.valueOf(active)))

                    ) {
                        blinkOne(btn);
                    } else {
                        btn.setText(String.valueOf(active));
                        btn.setTag(String.valueOf(active));
                        btn.setTextColor(getResources().getColor(R.color.black));

                        btn.setBackgroundColor(getResources().getColor(R.color.black_overlay));
                    }
                }

                result();
            }
        }


    }

    private void blinkOne(Button btna) {
        btna.setBackgroundColor(getResources().getColor(R.color.red));
        Thread one = new Thread() {
            public void run() {
                try {
                    Thread.sleep(200);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            btna.setBackgroundColor(getResources().getColor(R.color.trans));
                            // Stuff that updates the UI
                        }
                    });
                } catch (InterruptedException ex) {
                    //do stuff
                }
            }
        };
        one.start();

        lifeCount--;
        if (lifeCount==0){

            life1.setVisibility(View.INVISIBLE);
            Thread life = new Thread() {
                public void run() {
                    try {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                life1.setVisibility(View.VISIBLE);
                                // Stuff that updates the UI
                            }
                        });
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                life1.setVisibility(View.INVISIBLE);
                                // Stuff that updates the UI
                            }
                        });
                    } catch (InterruptedException ex) {
                        //do stuff
                    }
                }
            };
            life.start();
            new MaterialAlertDialogBuilder(Play.this)
                    .setTitle("Game Over ")
                    .setMessage("You Ran Out Of Lives ")
                    .setPositiveButton("Watch Ads", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                           lifeCount=3;
                            life1.setVisibility(View.VISIBLE);
                            life2.setVisibility(View.VISIBLE);
                            life3.setVisibility(View.VISIBLE);
                        }
                    })
                    .setNegativeButton("Restart", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                            int lvl = sh.getInt("lvl", 1);
                            getdata(String.valueOf(lvl));
                        }
                    })
                    .show();
        }else  if (lifeCount==2){
            life3.setVisibility(View.INVISIBLE);
            Thread life = new Thread() {
                public void run() {
                    try {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                life3.setVisibility(View.VISIBLE);
                                // Stuff that updates the UI
                            }
                        });
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                life3.setVisibility(View.INVISIBLE);
                                // Stuff that updates the UI
                            }
                        });
                    } catch (InterruptedException ex) {
                        //do stuff
                    }
                }
            };
            life.start();
           // life3.setVisibility(View.INVISIBLE);
        }
        else  if (lifeCount==1){
          //  life2.setBackgroundResource(R.drawable.border);

            life2.setVisibility(View.INVISIBLE);
            Thread life = new Thread() {
                public void run() {
                    try {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                life2.setVisibility(View.VISIBLE);
                                // Stuff that updates the UI
                            }
                        });
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                life2.setVisibility(View.INVISIBLE);
                                // Stuff that updates the UI
                            }
                        });
                    } catch (InterruptedException ex) {
                        //do stuff
                    }
                }
            };
            life.start();

        }
    }

    private void blinkChk(int i) {
        {
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
        }
        if (i == 1) {
            if (btn1.getText().toString().equals("1")) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn2.getText().toString().equals("1")) {
                btn2.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn3.getText().toString().equals("1")) {
                btn3.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn4.getText().toString().equals("1")) {
                btn4.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn5.getText().toString().equals("1")) {
                btn5.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn6.getText().toString().equals("1")) {
                btn6.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn7.getText().toString().equals("1")) {
                btn7.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn8.getText().toString().equals("1")) {
                btn8.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn9.getText().toString().equals("1")) {
                btn9.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn10.getText().toString().equals("1")) {
                btn10.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn11.getText().toString().equals("1")) {
                btn11.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn12.getText().toString().equals("1")) {
                btn12.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn13.getText().toString().equals("1")) {
                btn13.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn14.getText().toString().equals("1")) {
                btn14.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn15.getText().toString().equals("1")) {
                btn15.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn16.getText().toString().equals("1")) {
                btn16.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn17.getText().toString().equals("1")) {
                btn17.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn18.getText().toString().equals("1")) {
                btn18.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn19.getText().toString().equals("1")) {
                btn19.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn20.getText().toString().equals("1")) {
                btn20.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn21.getText().toString().equals("1")) {
                btn21.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn22.getText().toString().equals("1")) {
                btn22.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn23.getText().toString().equals("1")) {
                btn23.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn24.getText().toString().equals("1")) {
                btn24.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn25.getText().toString().equals("1")) {
                btn25.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn26.getText().toString().equals("1")) {
                btn26.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn27.getText().toString().equals("1")) {
                btn27.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn28.getText().toString().equals("1")) {
                btn28.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn29.getText().toString().equals("1")) {
                btn29.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn30.getText().toString().equals("1")) {
                btn30.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn31.getText().toString().equals("1")) {
                btn31.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn32.getText().toString().equals("1")) {
                btn32.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn33.getText().toString().equals("1")) {
                btn33.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn34.getText().toString().equals("1")) {
                btn34.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn35.getText().toString().equals("1")) {
                btn35.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn36.getText().toString().equals("1")) {
                btn36.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn37.getText().toString().equals("1")) {
                btn37.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn38.getText().toString().equals("1")) {
                btn38.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn39.getText().toString().equals("1")) {
                btn39.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn40.getText().toString().equals("1")) {
                btn40.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn41.getText().toString().equals("1")) {
                btn41.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn42.getText().toString().equals("1")) {
                btn42.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn43.getText().toString().equals("1")) {
                btn43.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn44.getText().toString().equals("1")) {
                btn44.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn45.getText().toString().equals("1")) {
                btn45.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn46.getText().toString().equals("1")) {
                btn46.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn47.getText().toString().equals("1")) {
                btn47.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn48.getText().toString().equals("1")) {
                btn48.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn49.getText().toString().equals("1")) {
                btn49.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn50.getText().toString().equals("1")) {
                btn50.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn51.getText().toString().equals("1")) {
                btn51.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn52.getText().toString().equals("1")) {
                btn52.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn53.getText().toString().equals("1")) {
                btn53.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn54.getText().toString().equals("1")) {
                btn54.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn55.getText().toString().equals("1")) {
                btn55.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn56.getText().toString().equals("1")) {
                btn56.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn57.getText().toString().equals("1")) {
                btn57.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn58.getText().toString().equals("1")) {
                btn58.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn59.getText().toString().equals("1")) {
                btn59.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn60.getText().toString().equals("1")) {
                btn60.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn61.getText().toString().equals("1")) {
                btn61.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn62.getText().toString().equals("1")) {
                btn62.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn63.getText().toString().equals("1")) {
                btn63.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn64.getText().toString().equals("1")) {
                btn64.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn65.getText().toString().equals("1")) {
                btn65.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn66.getText().toString().equals("1")) {
                btn66.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn67.getText().toString().equals("1")) {
                btn67.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn68.getText().toString().equals("1")) {
                btn68.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn69.getText().toString().equals("1")) {
                btn69.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn70.getText().toString().equals("1")) {
                btn70.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn71.getText().toString().equals("1")) {
                btn71.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn72.getText().toString().equals("1")) {
                btn72.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn73.getText().toString().equals("1")) {
                btn73.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn74.getText().toString().equals("1")) {
                btn74.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn75.getText().toString().equals("1")) {
                btn75.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn76.getText().toString().equals("1")) {
                btn76.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn77.getText().toString().equals("1")) {
                btn77.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn78.getText().toString().equals("1")) {
                btn78.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn79.getText().toString().equals("1")) {
                btn79.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn80.getText().toString().equals("1")) {
                btn80.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn81.getText().toString().equals("1")) {
                btn81.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }

        } else if (i == 2) {
            if (btn1.getText().toString().equals("2")) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn2.getText().toString().equals("2")) {
                btn2.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn3.getText().toString().equals("2")) {
                btn3.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn4.getText().toString().equals("2")) {
                btn4.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn5.getText().toString().equals("2")) {
                btn5.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn6.getText().toString().equals("2")) {
                btn6.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn7.getText().toString().equals("2")) {
                btn7.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn8.getText().toString().equals("2")) {
                btn8.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn9.getText().toString().equals("2")) {
                btn9.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn10.getText().toString().equals("2")) {
                btn10.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn11.getText().toString().equals("2")) {
                btn11.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn12.getText().toString().equals("2")) {
                btn12.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn13.getText().toString().equals("2")) {
                btn13.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn14.getText().toString().equals("2")) {
                btn14.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn15.getText().toString().equals("2")) {
                btn15.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn16.getText().toString().equals("2")) {
                btn16.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn17.getText().toString().equals("2")) {
                btn17.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn18.getText().toString().equals("2")) {
                btn18.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn19.getText().toString().equals("2")) {
                btn19.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn20.getText().toString().equals("2")) {
                btn20.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn21.getText().toString().equals("2")) {
                btn21.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn22.getText().toString().equals("2")) {
                btn22.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn23.getText().toString().equals("2")) {
                btn23.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn24.getText().toString().equals("2")) {
                btn24.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn25.getText().toString().equals("2")) {
                btn25.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn26.getText().toString().equals("2")) {
                btn26.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn27.getText().toString().equals("2")) {
                btn27.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn28.getText().toString().equals("2")) {
                btn28.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn29.getText().toString().equals("2")) {
                btn29.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn30.getText().toString().equals("2")) {
                btn30.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn31.getText().toString().equals("2")) {
                btn31.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn32.getText().toString().equals("2")) {
                btn32.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn33.getText().toString().equals("2")) {
                btn33.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn34.getText().toString().equals("2")) {
                btn34.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn35.getText().toString().equals("2")) {
                btn35.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn36.getText().toString().equals("2")) {
                btn36.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn37.getText().toString().equals("2")) {
                btn37.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn38.getText().toString().equals("2")) {
                btn38.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn39.getText().toString().equals("2")) {
                btn39.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn40.getText().toString().equals("2")) {
                btn40.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn41.getText().toString().equals("2")) {
                btn41.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn42.getText().toString().equals("2")) {
                btn42.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn43.getText().toString().equals("2")) {
                btn43.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn44.getText().toString().equals("2")) {
                btn44.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn45.getText().toString().equals("2")) {
                btn45.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn46.getText().toString().equals("2")) {
                btn46.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn47.getText().toString().equals("2")) {
                btn47.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn48.getText().toString().equals("2")) {
                btn48.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn49.getText().toString().equals("2")) {
                btn49.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn50.getText().toString().equals("2")) {
                btn50.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn51.getText().toString().equals("2")) {
                btn51.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn52.getText().toString().equals("2")) {
                btn52.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn53.getText().toString().equals("2")) {
                btn53.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn54.getText().toString().equals("2")) {
                btn54.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn55.getText().toString().equals("2")) {
                btn55.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn56.getText().toString().equals("2")) {
                btn56.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn57.getText().toString().equals("2")) {
                btn57.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn58.getText().toString().equals("2")) {
                btn58.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn59.getText().toString().equals("2")) {
                btn59.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn60.getText().toString().equals("2")) {
                btn60.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn61.getText().toString().equals("2")) {
                btn61.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn62.getText().toString().equals("2")) {
                btn62.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn63.getText().toString().equals("2")) {
                btn63.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn64.getText().toString().equals("2")) {
                btn64.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn65.getText().toString().equals("2")) {
                btn65.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn66.getText().toString().equals("2")) {
                btn66.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn67.getText().toString().equals("2")) {
                btn67.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn68.getText().toString().equals("2")) {
                btn68.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn69.getText().toString().equals("2")) {
                btn69.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn70.getText().toString().equals("2")) {
                btn70.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn71.getText().toString().equals("2")) {
                btn71.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn72.getText().toString().equals("2")) {
                btn72.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn73.getText().toString().equals("2")) {
                btn73.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn74.getText().toString().equals("2")) {
                btn74.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn75.getText().toString().equals("2")) {
                btn75.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn76.getText().toString().equals("2")) {
                btn76.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn77.getText().toString().equals("2")) {
                btn77.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn78.getText().toString().equals("2")) {
                btn78.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn79.getText().toString().equals("2")) {
                btn79.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn80.getText().toString().equals("2")) {
                btn80.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn81.getText().toString().equals("2")) {
                btn81.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
        } else if (i == 3) {
            if (btn1.getText().toString().equals("3")) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn2.getText().toString().equals("3")) {
                btn2.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn3.getText().toString().equals("3")) {
                btn3.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn4.getText().toString().equals("3")) {
                btn4.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn5.getText().toString().equals("3")) {
                btn5.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn6.getText().toString().equals("3")) {
                btn6.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn7.getText().toString().equals("3")) {
                btn7.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn8.getText().toString().equals("3")) {
                btn8.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn9.getText().toString().equals("3")) {
                btn9.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn10.getText().toString().equals("3")) {
                btn10.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn11.getText().toString().equals("3")) {
                btn11.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn12.getText().toString().equals("3")) {
                btn12.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn13.getText().toString().equals("3")) {
                btn13.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn14.getText().toString().equals("3")) {
                btn14.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn15.getText().toString().equals("3")) {
                btn15.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn16.getText().toString().equals("3")) {
                btn16.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn17.getText().toString().equals("3")) {
                btn17.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn18.getText().toString().equals("3")) {
                btn18.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn19.getText().toString().equals("3")) {
                btn19.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn20.getText().toString().equals("3")) {
                btn20.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn21.getText().toString().equals("3")) {
                btn21.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn22.getText().toString().equals("3")) {
                btn22.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn23.getText().toString().equals("3")) {
                btn23.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn24.getText().toString().equals("3")) {
                btn24.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn25.getText().toString().equals("3")) {
                btn25.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn26.getText().toString().equals("3")) {
                btn26.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn27.getText().toString().equals("3")) {
                btn27.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn28.getText().toString().equals("3")) {
                btn28.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn29.getText().toString().equals("3")) {
                btn29.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn30.getText().toString().equals("3")) {
                btn30.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn31.getText().toString().equals("3")) {
                btn31.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn32.getText().toString().equals("3")) {
                btn32.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn33.getText().toString().equals("3")) {
                btn33.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn34.getText().toString().equals("3")) {
                btn34.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn35.getText().toString().equals("3")) {
                btn35.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn36.getText().toString().equals("3")) {
                btn36.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn37.getText().toString().equals("3")) {
                btn37.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn38.getText().toString().equals("3")) {
                btn38.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn39.getText().toString().equals("3")) {
                btn39.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn40.getText().toString().equals("3")) {
                btn40.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn41.getText().toString().equals("3")) {
                btn41.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn42.getText().toString().equals("3")) {
                btn42.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn43.getText().toString().equals("3")) {
                btn43.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn44.getText().toString().equals("3")) {
                btn44.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn45.getText().toString().equals("3")) {
                btn45.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn46.getText().toString().equals("3")) {
                btn46.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn47.getText().toString().equals("3")) {
                btn47.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn48.getText().toString().equals("3")) {
                btn48.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn49.getText().toString().equals("3")) {
                btn49.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn50.getText().toString().equals("3")) {
                btn50.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn51.getText().toString().equals("3")) {
                btn51.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn52.getText().toString().equals("3")) {
                btn52.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn53.getText().toString().equals("3")) {
                btn53.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn54.getText().toString().equals("3")) {
                btn54.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn55.getText().toString().equals("3")) {
                btn55.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn56.getText().toString().equals("3")) {
                btn56.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn57.getText().toString().equals("3")) {
                btn57.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn58.getText().toString().equals("3")) {
                btn58.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn59.getText().toString().equals("3")) {
                btn59.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn60.getText().toString().equals("3")) {
                btn60.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn61.getText().toString().equals("3")) {
                btn61.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn62.getText().toString().equals("3")) {
                btn62.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn63.getText().toString().equals("3")) {
                btn63.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn64.getText().toString().equals("3")) {
                btn64.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn65.getText().toString().equals("3")) {
                btn65.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn66.getText().toString().equals("3")) {
                btn66.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn67.getText().toString().equals("3")) {
                btn67.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn68.getText().toString().equals("3")) {
                btn68.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn69.getText().toString().equals("3")) {
                btn69.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn70.getText().toString().equals("3")) {
                btn70.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn71.getText().toString().equals("3")) {
                btn71.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn72.getText().toString().equals("3")) {
                btn72.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn73.getText().toString().equals("3")) {
                btn73.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn74.getText().toString().equals("3")) {
                btn74.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn75.getText().toString().equals("3")) {
                btn75.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn76.getText().toString().equals("3")) {
                btn76.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn77.getText().toString().equals("3")) {
                btn77.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn78.getText().toString().equals("3")) {
                btn78.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn79.getText().toString().equals("3")) {
                btn79.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn80.getText().toString().equals("3")) {
                btn80.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn81.getText().toString().equals("3")) {
                btn81.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
        } else if (i == 4) {
            if (btn1.getText().toString().equals("4")) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn2.getText().toString().equals("4")) {
                btn2.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn3.getText().toString().equals("4")) {
                btn3.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn4.getText().toString().equals("4")) {
                btn4.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn5.getText().toString().equals("4")) {
                btn5.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn6.getText().toString().equals("4")) {
                btn6.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn7.getText().toString().equals("4")) {
                btn7.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn8.getText().toString().equals("4")) {
                btn8.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn9.getText().toString().equals("4")) {
                btn9.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn10.getText().toString().equals("4")) {
                btn10.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn11.getText().toString().equals("4")) {
                btn11.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn12.getText().toString().equals("4")) {
                btn12.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn13.getText().toString().equals("4")) {
                btn13.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn14.getText().toString().equals("4")) {
                btn14.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn15.getText().toString().equals("4")) {
                btn15.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn16.getText().toString().equals("4")) {
                btn16.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn17.getText().toString().equals("4")) {
                btn17.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn18.getText().toString().equals("4")) {
                btn18.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn19.getText().toString().equals("4")) {
                btn19.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn20.getText().toString().equals("4")) {
                btn20.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn21.getText().toString().equals("4")) {
                btn21.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn22.getText().toString().equals("4")) {
                btn22.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn23.getText().toString().equals("4")) {
                btn23.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn24.getText().toString().equals("4")) {
                btn24.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn25.getText().toString().equals("4")) {
                btn25.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn26.getText().toString().equals("4")) {
                btn26.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn27.getText().toString().equals("4")) {
                btn27.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn28.getText().toString().equals("4")) {
                btn28.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn29.getText().toString().equals("4")) {
                btn29.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn30.getText().toString().equals("4")) {
                btn30.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn31.getText().toString().equals("4")) {
                btn31.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn32.getText().toString().equals("4")) {
                btn32.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn33.getText().toString().equals("4")) {
                btn33.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn34.getText().toString().equals("4")) {
                btn34.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn35.getText().toString().equals("4")) {
                btn35.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn36.getText().toString().equals("4")) {
                btn36.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn37.getText().toString().equals("4")) {
                btn37.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn38.getText().toString().equals("4")) {
                btn38.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn39.getText().toString().equals("4")) {
                btn39.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn40.getText().toString().equals("4")) {
                btn40.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn41.getText().toString().equals("4")) {
                btn41.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn42.getText().toString().equals("4")) {
                btn42.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn43.getText().toString().equals("4")) {
                btn43.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn44.getText().toString().equals("4")) {
                btn44.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn45.getText().toString().equals("4")) {
                btn45.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn46.getText().toString().equals("4")) {
                btn46.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn47.getText().toString().equals("4")) {
                btn47.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn48.getText().toString().equals("4")) {
                btn48.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn49.getText().toString().equals("4")) {
                btn49.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn50.getText().toString().equals("4")) {
                btn50.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn51.getText().toString().equals("4")) {
                btn51.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn52.getText().toString().equals("4")) {
                btn52.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn53.getText().toString().equals("4")) {
                btn53.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn54.getText().toString().equals("4")) {
                btn54.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn55.getText().toString().equals("4")) {
                btn55.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn56.getText().toString().equals("4")) {
                btn56.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn57.getText().toString().equals("4")) {
                btn57.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn58.getText().toString().equals("4")) {
                btn58.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn59.getText().toString().equals("4")) {
                btn59.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn60.getText().toString().equals("4")) {
                btn60.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn61.getText().toString().equals("4")) {
                btn61.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn62.getText().toString().equals("4")) {
                btn62.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn63.getText().toString().equals("4")) {
                btn63.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn64.getText().toString().equals("4")) {
                btn64.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn65.getText().toString().equals("4")) {
                btn65.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn66.getText().toString().equals("4")) {
                btn66.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn67.getText().toString().equals("4")) {
                btn67.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn68.getText().toString().equals("4")) {
                btn68.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn69.getText().toString().equals("4")) {
                btn69.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn70.getText().toString().equals("4")) {
                btn70.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn71.getText().toString().equals("4")) {
                btn71.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn72.getText().toString().equals("4")) {
                btn72.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn73.getText().toString().equals("4")) {
                btn73.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn74.getText().toString().equals("4")) {
                btn74.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn75.getText().toString().equals("4")) {
                btn75.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn76.getText().toString().equals("4")) {
                btn76.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn77.getText().toString().equals("4")) {
                btn77.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn78.getText().toString().equals("4")) {
                btn78.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn79.getText().toString().equals("4")) {
                btn79.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn80.getText().toString().equals("4")) {
                btn80.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn81.getText().toString().equals("4")) {
                btn81.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
        } else if (i == 5) {
            if (btn1.getText().toString().equals("5")) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn2.getText().toString().equals("5")) {
                btn2.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn3.getText().toString().equals("5")) {
                btn3.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn4.getText().toString().equals("5")) {
                btn4.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn5.getText().toString().equals("5")) {
                btn5.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn6.getText().toString().equals("5")) {
                btn6.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn7.getText().toString().equals("5")) {
                btn7.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn8.getText().toString().equals("5")) {
                btn8.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn9.getText().toString().equals("5")) {
                btn9.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn10.getText().toString().equals("5")) {
                btn10.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn11.getText().toString().equals("5")) {
                btn11.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn12.getText().toString().equals("5")) {
                btn12.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn13.getText().toString().equals("5")) {
                btn13.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn14.getText().toString().equals("5")) {
                btn14.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn15.getText().toString().equals("5")) {
                btn15.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn16.getText().toString().equals("5")) {
                btn16.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn17.getText().toString().equals("5")) {
                btn17.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn18.getText().toString().equals("5")) {
                btn18.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn19.getText().toString().equals("5")) {
                btn19.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn20.getText().toString().equals("5")) {
                btn20.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn21.getText().toString().equals("5")) {
                btn21.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn22.getText().toString().equals("5")) {
                btn22.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn23.getText().toString().equals("5")) {
                btn23.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn24.getText().toString().equals("5")) {
                btn24.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn25.getText().toString().equals("5")) {
                btn25.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn26.getText().toString().equals("5")) {
                btn26.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn27.getText().toString().equals("5")) {
                btn27.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn28.getText().toString().equals("5")) {
                btn28.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn29.getText().toString().equals("5")) {
                btn29.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn30.getText().toString().equals("5")) {
                btn30.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn31.getText().toString().equals("5")) {
                btn31.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn32.getText().toString().equals("5")) {
                btn32.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn33.getText().toString().equals("5")) {
                btn33.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn34.getText().toString().equals("5")) {
                btn34.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn35.getText().toString().equals("5")) {
                btn35.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn36.getText().toString().equals("5")) {
                btn36.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn37.getText().toString().equals("5")) {
                btn37.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn38.getText().toString().equals("5")) {
                btn38.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn39.getText().toString().equals("5")) {
                btn39.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn40.getText().toString().equals("5")) {
                btn40.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn41.getText().toString().equals("5")) {
                btn41.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn42.getText().toString().equals("5")) {
                btn42.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn43.getText().toString().equals("5")) {
                btn43.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn44.getText().toString().equals("5")) {
                btn44.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn45.getText().toString().equals("5")) {
                btn45.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn46.getText().toString().equals("5")) {
                btn46.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn47.getText().toString().equals("5")) {
                btn47.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn48.getText().toString().equals("5")) {
                btn48.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn49.getText().toString().equals("5")) {
                btn49.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn50.getText().toString().equals("5")) {
                btn50.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn51.getText().toString().equals("5")) {
                btn51.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn52.getText().toString().equals("5")) {
                btn52.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn53.getText().toString().equals("5")) {
                btn53.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn54.getText().toString().equals("5")) {
                btn54.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn55.getText().toString().equals("5")) {
                btn55.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn56.getText().toString().equals("5")) {
                btn56.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn57.getText().toString().equals("5")) {
                btn57.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn58.getText().toString().equals("5")) {
                btn58.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn59.getText().toString().equals("5")) {
                btn59.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn60.getText().toString().equals("5")) {
                btn60.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn61.getText().toString().equals("5")) {
                btn61.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn62.getText().toString().equals("5")) {
                btn62.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn63.getText().toString().equals("5")) {
                btn63.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn64.getText().toString().equals("5")) {
                btn64.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn65.getText().toString().equals("5")) {
                btn65.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn66.getText().toString().equals("5")) {
                btn66.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn67.getText().toString().equals("5")) {
                btn67.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn68.getText().toString().equals("5")) {
                btn68.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn69.getText().toString().equals("5")) {
                btn69.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn70.getText().toString().equals("5")) {
                btn70.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn71.getText().toString().equals("5")) {
                btn71.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn72.getText().toString().equals("5")) {
                btn72.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn73.getText().toString().equals("5")) {
                btn73.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn74.getText().toString().equals("5")) {
                btn74.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn75.getText().toString().equals("5")) {
                btn75.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn76.getText().toString().equals("5")) {
                btn76.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn77.getText().toString().equals("5")) {
                btn77.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn78.getText().toString().equals("5")) {
                btn78.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn79.getText().toString().equals("5")) {
                btn79.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn80.getText().toString().equals("5")) {
                btn80.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn81.getText().toString().equals("5")) {
                btn81.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
        } else if (i == 6) {
            if (btn1.getText().toString().equals("6")) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn2.getText().toString().equals("6")) {
                btn2.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn3.getText().toString().equals("6")) {
                btn3.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn4.getText().toString().equals("6")) {
                btn4.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn5.getText().toString().equals("6")) {
                btn5.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn6.getText().toString().equals("6")) {
                btn6.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn7.getText().toString().equals("6")) {
                btn7.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn8.getText().toString().equals("6")) {
                btn8.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn9.getText().toString().equals("6")) {
                btn9.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn10.getText().toString().equals("6")) {
                btn10.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn11.getText().toString().equals("6")) {
                btn11.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn12.getText().toString().equals("6")) {
                btn12.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn13.getText().toString().equals("6")) {
                btn13.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn14.getText().toString().equals("6")) {
                btn14.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn15.getText().toString().equals("6")) {
                btn15.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn16.getText().toString().equals("6")) {
                btn16.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn17.getText().toString().equals("6")) {
                btn17.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn18.getText().toString().equals("6")) {
                btn18.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn19.getText().toString().equals("6")) {
                btn19.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn20.getText().toString().equals("6")) {
                btn20.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn21.getText().toString().equals("6")) {
                btn21.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn22.getText().toString().equals("6")) {
                btn22.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn23.getText().toString().equals("6")) {
                btn23.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn24.getText().toString().equals("6")) {
                btn24.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn25.getText().toString().equals("6")) {
                btn25.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn26.getText().toString().equals("6")) {
                btn26.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn27.getText().toString().equals("6")) {
                btn27.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn28.getText().toString().equals("6")) {
                btn28.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn29.getText().toString().equals("6")) {
                btn29.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn30.getText().toString().equals("6")) {
                btn30.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn31.getText().toString().equals("6")) {
                btn31.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn32.getText().toString().equals("6")) {
                btn32.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn33.getText().toString().equals("6")) {
                btn33.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn34.getText().toString().equals("6")) {
                btn34.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn35.getText().toString().equals("6")) {
                btn35.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn36.getText().toString().equals("6")) {
                btn36.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn37.getText().toString().equals("6")) {
                btn37.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn38.getText().toString().equals("6")) {
                btn38.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn39.getText().toString().equals("6")) {
                btn39.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn40.getText().toString().equals("6")) {
                btn40.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn41.getText().toString().equals("6")) {
                btn41.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn42.getText().toString().equals("6")) {
                btn42.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn43.getText().toString().equals("6")) {
                btn43.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn44.getText().toString().equals("6")) {
                btn44.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn45.getText().toString().equals("6")) {
                btn45.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn46.getText().toString().equals("6")) {
                btn46.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn47.getText().toString().equals("6")) {
                btn47.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn48.getText().toString().equals("6")) {
                btn48.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn49.getText().toString().equals("6")) {
                btn49.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn50.getText().toString().equals("6")) {
                btn50.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn51.getText().toString().equals("6")) {
                btn51.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn52.getText().toString().equals("6")) {
                btn52.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn53.getText().toString().equals("6")) {
                btn53.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn54.getText().toString().equals("6")) {
                btn54.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn55.getText().toString().equals("6")) {
                btn55.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn56.getText().toString().equals("6")) {
                btn56.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn57.getText().toString().equals("6")) {
                btn57.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn58.getText().toString().equals("6")) {
                btn58.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn59.getText().toString().equals("6")) {
                btn59.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn60.getText().toString().equals("6")) {
                btn60.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn61.getText().toString().equals("6")) {
                btn61.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn62.getText().toString().equals("6")) {
                btn62.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn63.getText().toString().equals("6")) {
                btn63.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn64.getText().toString().equals("6")) {
                btn64.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn65.getText().toString().equals("6")) {
                btn65.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn66.getText().toString().equals("6")) {
                btn66.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn67.getText().toString().equals("6")) {
                btn67.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn68.getText().toString().equals("6")) {
                btn68.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn69.getText().toString().equals("6")) {
                btn69.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn70.getText().toString().equals("6")) {
                btn70.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn71.getText().toString().equals("6")) {
                btn71.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn72.getText().toString().equals("6")) {
                btn72.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn73.getText().toString().equals("6")) {
                btn73.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn74.getText().toString().equals("6")) {
                btn74.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn75.getText().toString().equals("6")) {
                btn75.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn76.getText().toString().equals("6")) {
                btn76.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn77.getText().toString().equals("6")) {
                btn77.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn78.getText().toString().equals("6")) {
                btn78.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn79.getText().toString().equals("6")) {
                btn79.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn80.getText().toString().equals("6")) {
                btn80.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn81.getText().toString().equals("6")) {
                btn81.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
        } else if (i == 7) {
            if (btn1.getText().toString().equals("7")) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn2.getText().toString().equals("7")) {
                btn2.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn3.getText().toString().equals("7")) {
                btn3.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn4.getText().toString().equals("7")) {
                btn4.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn5.getText().toString().equals("7")) {
                btn5.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn6.getText().toString().equals("7")) {
                btn6.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn7.getText().toString().equals("7")) {
                btn7.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn8.getText().toString().equals("7")) {
                btn8.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn9.getText().toString().equals("7")) {
                btn9.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn10.getText().toString().equals("7")) {
                btn10.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn11.getText().toString().equals("7")) {
                btn11.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn12.getText().toString().equals("7")) {
                btn12.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn13.getText().toString().equals("7")) {
                btn13.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn14.getText().toString().equals("7")) {
                btn14.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn15.getText().toString().equals("7")) {
                btn15.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn16.getText().toString().equals("7")) {
                btn16.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn17.getText().toString().equals("7")) {
                btn17.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn18.getText().toString().equals("7")) {
                btn18.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn19.getText().toString().equals("7")) {
                btn19.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn20.getText().toString().equals("7")) {
                btn20.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn21.getText().toString().equals("7")) {
                btn21.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn22.getText().toString().equals("7")) {
                btn22.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn23.getText().toString().equals("7")) {
                btn23.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn24.getText().toString().equals("7")) {
                btn24.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn25.getText().toString().equals("7")) {
                btn25.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn26.getText().toString().equals("7")) {
                btn26.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn27.getText().toString().equals("7")) {
                btn27.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn28.getText().toString().equals("7")) {
                btn28.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn29.getText().toString().equals("7")) {
                btn29.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn30.getText().toString().equals("7")) {
                btn30.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn31.getText().toString().equals("7")) {
                btn31.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn32.getText().toString().equals("7")) {
                btn32.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn33.getText().toString().equals("7")) {
                btn33.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn34.getText().toString().equals("7")) {
                btn34.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn35.getText().toString().equals("7")) {
                btn35.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn36.getText().toString().equals("7")) {
                btn36.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn37.getText().toString().equals("7")) {
                btn37.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn38.getText().toString().equals("7")) {
                btn38.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn39.getText().toString().equals("7")) {
                btn39.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn40.getText().toString().equals("7")) {
                btn40.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn41.getText().toString().equals("7")) {
                btn41.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn42.getText().toString().equals("7")) {
                btn42.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn43.getText().toString().equals("7")) {
                btn43.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn44.getText().toString().equals("7")) {
                btn44.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn45.getText().toString().equals("7")) {
                btn45.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn46.getText().toString().equals("7")) {
                btn46.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn47.getText().toString().equals("7")) {
                btn47.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn48.getText().toString().equals("7")) {
                btn48.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn49.getText().toString().equals("7")) {
                btn49.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn50.getText().toString().equals("7")) {
                btn50.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn51.getText().toString().equals("7")) {
                btn51.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn52.getText().toString().equals("7")) {
                btn52.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn53.getText().toString().equals("7")) {
                btn53.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn54.getText().toString().equals("7")) {
                btn54.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn55.getText().toString().equals("7")) {
                btn55.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn56.getText().toString().equals("7")) {
                btn56.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn57.getText().toString().equals("7")) {
                btn57.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn58.getText().toString().equals("7")) {
                btn58.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn59.getText().toString().equals("7")) {
                btn59.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn60.getText().toString().equals("7")) {
                btn60.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn61.getText().toString().equals("7")) {
                btn61.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn62.getText().toString().equals("7")) {
                btn62.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn63.getText().toString().equals("7")) {
                btn63.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn64.getText().toString().equals("7")) {
                btn64.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn65.getText().toString().equals("7")) {
                btn65.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn66.getText().toString().equals("7")) {
                btn66.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn67.getText().toString().equals("7")) {
                btn67.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn68.getText().toString().equals("7")) {
                btn68.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn69.getText().toString().equals("7")) {
                btn69.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn70.getText().toString().equals("7")) {
                btn70.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn71.getText().toString().equals("7")) {
                btn71.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn72.getText().toString().equals("7")) {
                btn72.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn73.getText().toString().equals("7")) {
                btn73.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn74.getText().toString().equals("7")) {
                btn74.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn75.getText().toString().equals("7")) {
                btn75.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn76.getText().toString().equals("7")) {
                btn76.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn77.getText().toString().equals("7")) {
                btn77.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn78.getText().toString().equals("7")) {
                btn78.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn79.getText().toString().equals("7")) {
                btn79.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn80.getText().toString().equals("7")) {
                btn80.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn81.getText().toString().equals("7")) {
                btn81.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
        } else if (i == 8) {
            if (btn1.getText().toString().equals("8")) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn2.getText().toString().equals("8")) {
                btn2.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn3.getText().toString().equals("8")) {
                btn3.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn4.getText().toString().equals("8")) {
                btn4.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn5.getText().toString().equals("8")) {
                btn5.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn6.getText().toString().equals("8")) {
                btn6.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn7.getText().toString().equals("8")) {
                btn7.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn8.getText().toString().equals("8")) {
                btn8.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn9.getText().toString().equals("8")) {
                btn9.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn10.getText().toString().equals("8")) {
                btn10.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn11.getText().toString().equals("8")) {
                btn11.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn12.getText().toString().equals("8")) {
                btn12.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn13.getText().toString().equals("8")) {
                btn13.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn14.getText().toString().equals("8")) {
                btn14.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn15.getText().toString().equals("8")) {
                btn15.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn16.getText().toString().equals("8")) {
                btn16.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn17.getText().toString().equals("8")) {
                btn17.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn18.getText().toString().equals("8")) {
                btn18.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn19.getText().toString().equals("8")) {
                btn19.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn20.getText().toString().equals("8")) {
                btn20.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn21.getText().toString().equals("8")) {
                btn21.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn22.getText().toString().equals("8")) {
                btn22.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn23.getText().toString().equals("8")) {
                btn23.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn24.getText().toString().equals("8")) {
                btn24.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn25.getText().toString().equals("8")) {
                btn25.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn26.getText().toString().equals("8")) {
                btn26.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn27.getText().toString().equals("8")) {
                btn27.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn28.getText().toString().equals("8")) {
                btn28.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn29.getText().toString().equals("8")) {
                btn29.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn30.getText().toString().equals("8")) {
                btn30.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn31.getText().toString().equals("8")) {
                btn31.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn32.getText().toString().equals("8")) {
                btn32.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn33.getText().toString().equals("8")) {
                btn33.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn34.getText().toString().equals("8")) {
                btn34.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn35.getText().toString().equals("8")) {
                btn35.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn36.getText().toString().equals("8")) {
                btn36.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn37.getText().toString().equals("8")) {
                btn37.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn38.getText().toString().equals("8")) {
                btn38.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn39.getText().toString().equals("8")) {
                btn39.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn40.getText().toString().equals("8")) {
                btn40.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn41.getText().toString().equals("8")) {
                btn41.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn42.getText().toString().equals("8")) {
                btn42.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn43.getText().toString().equals("8")) {
                btn43.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn44.getText().toString().equals("8")) {
                btn44.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn45.getText().toString().equals("8")) {
                btn45.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn46.getText().toString().equals("8")) {
                btn46.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn47.getText().toString().equals("8")) {
                btn47.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn48.getText().toString().equals("8")) {
                btn48.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn49.getText().toString().equals("8")) {
                btn49.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn50.getText().toString().equals("8")) {
                btn50.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn51.getText().toString().equals("8")) {
                btn51.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn52.getText().toString().equals("8")) {
                btn52.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn53.getText().toString().equals("8")) {
                btn53.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn54.getText().toString().equals("8")) {
                btn54.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn55.getText().toString().equals("8")) {
                btn55.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn56.getText().toString().equals("8")) {
                btn56.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn57.getText().toString().equals("8")) {
                btn57.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn58.getText().toString().equals("8")) {
                btn58.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn59.getText().toString().equals("8")) {
                btn59.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn60.getText().toString().equals("8")) {
                btn60.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn61.getText().toString().equals("8")) {
                btn61.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn62.getText().toString().equals("8")) {
                btn62.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn63.getText().toString().equals("8")) {
                btn63.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn64.getText().toString().equals("8")) {
                btn64.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn65.getText().toString().equals("8")) {
                btn65.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn66.getText().toString().equals("8")) {
                btn66.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn67.getText().toString().equals("8")) {
                btn67.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn68.getText().toString().equals("8")) {
                btn68.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn69.getText().toString().equals("8")) {
                btn69.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn70.getText().toString().equals("8")) {
                btn70.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn71.getText().toString().equals("8")) {
                btn71.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn72.getText().toString().equals("8")) {
                btn72.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn73.getText().toString().equals("8")) {
                btn73.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn74.getText().toString().equals("8")) {
                btn74.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn75.getText().toString().equals("8")) {
                btn75.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn76.getText().toString().equals("8")) {
                btn76.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn77.getText().toString().equals("8")) {
                btn77.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn78.getText().toString().equals("8")) {
                btn78.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn79.getText().toString().equals("8")) {
                btn79.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn80.getText().toString().equals("8")) {
                btn80.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn81.getText().toString().equals("8")) {
                btn81.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
        } else if (i == 9) {
            if (btn1.getText().toString().equals("9")) {
                btn1.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn2.getText().toString().equals("9")) {
                btn2.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn3.getText().toString().equals("9")) {
                btn3.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn4.getText().toString().equals("9")) {
                btn4.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn5.getText().toString().equals("9")) {
                btn5.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn6.getText().toString().equals("9")) {
                btn6.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn7.getText().toString().equals("9")) {
                btn7.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn8.getText().toString().equals("9")) {
                btn8.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn9.getText().toString().equals("9")) {
                btn9.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn10.getText().toString().equals("9")) {
                btn10.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn11.getText().toString().equals("9")) {
                btn11.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn12.getText().toString().equals("9")) {
                btn12.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn13.getText().toString().equals("9")) {
                btn13.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn14.getText().toString().equals("9")) {
                btn14.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn15.getText().toString().equals("9")) {
                btn15.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn16.getText().toString().equals("9")) {
                btn16.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn17.getText().toString().equals("9")) {
                btn17.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn18.getText().toString().equals("9")) {
                btn18.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn19.getText().toString().equals("9")) {
                btn19.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn20.getText().toString().equals("9")) {
                btn20.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn21.getText().toString().equals("9")) {
                btn21.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn22.getText().toString().equals("9")) {
                btn22.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn23.getText().toString().equals("9")) {
                btn23.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn24.getText().toString().equals("9")) {
                btn24.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn25.getText().toString().equals("9")) {
                btn25.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn26.getText().toString().equals("9")) {
                btn26.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn27.getText().toString().equals("9")) {
                btn27.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn28.getText().toString().equals("9")) {
                btn28.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn29.getText().toString().equals("9")) {
                btn29.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn30.getText().toString().equals("9")) {
                btn30.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn31.getText().toString().equals("9")) {
                btn31.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn32.getText().toString().equals("9")) {
                btn32.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn33.getText().toString().equals("9")) {
                btn33.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn34.getText().toString().equals("9")) {
                btn34.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn35.getText().toString().equals("9")) {
                btn35.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn36.getText().toString().equals("9")) {
                btn36.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn37.getText().toString().equals("9")) {
                btn37.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn38.getText().toString().equals("9")) {
                btn38.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn39.getText().toString().equals("9")) {
                btn39.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn40.getText().toString().equals("9")) {
                btn40.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn41.getText().toString().equals("9")) {
                btn41.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn42.getText().toString().equals("9")) {
                btn42.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn43.getText().toString().equals("9")) {
                btn43.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn44.getText().toString().equals("9")) {
                btn44.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn45.getText().toString().equals("9")) {
                btn45.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn46.getText().toString().equals("9")) {
                btn46.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn47.getText().toString().equals("9")) {
                btn47.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn48.getText().toString().equals("9")) {
                btn48.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn49.getText().toString().equals("9")) {
                btn49.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn50.getText().toString().equals("9")) {
                btn50.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn51.getText().toString().equals("9")) {
                btn51.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn52.getText().toString().equals("9")) {
                btn52.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn53.getText().toString().equals("9")) {
                btn53.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn54.getText().toString().equals("9")) {
                btn54.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn55.getText().toString().equals("9")) {
                btn55.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn56.getText().toString().equals("9")) {
                btn56.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn57.getText().toString().equals("9")) {
                btn57.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn58.getText().toString().equals("9")) {
                btn58.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn59.getText().toString().equals("9")) {
                btn59.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn60.getText().toString().equals("9")) {
                btn60.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn61.getText().toString().equals("9")) {
                btn61.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn62.getText().toString().equals("9")) {
                btn62.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn63.getText().toString().equals("9")) {
                btn63.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn64.getText().toString().equals("9")) {
                btn64.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn65.getText().toString().equals("9")) {
                btn65.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn66.getText().toString().equals("9")) {
                btn66.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn67.getText().toString().equals("9")) {
                btn67.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn68.getText().toString().equals("9")) {
                btn68.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn69.getText().toString().equals("9")) {
                btn69.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn70.getText().toString().equals("9")) {
                btn70.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn71.getText().toString().equals("9")) {
                btn71.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn72.getText().toString().equals("9")) {
                btn72.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn73.getText().toString().equals("9")) {
                btn73.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn74.getText().toString().equals("9")) {
                btn74.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn75.getText().toString().equals("9")) {
                btn75.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn76.getText().toString().equals("9")) {
                btn76.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn77.getText().toString().equals("9")) {
                btn77.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn78.getText().toString().equals("9")) {
                btn78.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn79.getText().toString().equals("9")) {
                btn79.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn80.getText().toString().equals("9")) {
                btn80.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
            if (btn81.getText().toString().equals("9")) {
                btn81.setBackgroundColor(getResources().getColor(R.color.black_overlay));
            }
        }

    }

    private void result() {
        if ((!btn1.getText().toString().equals(" ")) && (!btn2.getText().toString().equals(" ")) && (!btn3.getText().toString().equals(" ")) && (!btn4.getText().toString().equals(" "))
                && (!btn5.getText().toString().equals(" ")) && (!btn6.getText().toString().equals(" ")) && (!btn7.getText().toString().equals(" ")) && (!btn8.getText().toString().equals(" "))
                && (!btn9.getText().toString().equals(" ")) && (!btn10.getText().toString().equals(" ")) && (!btn11.getText().toString().equals(" ")) && (!btn12.getText().toString().equals(" "))
                && (!btn13.getText().toString().equals(" ")) && (!btn14.getText().toString().equals(" ")) && (!btn15.getText().toString().equals(" ")) && (!btn16.getText().toString().equals(" "))
                && (!btn17.getText().toString().equals(" ")) && (!btn18.getText().toString().equals(" ")) && (!btn19.getText().toString().equals(" ")) && (!btn20.getText().toString().equals(" "))
                && (!btn21.getText().toString().equals(" ")) && (!btn22.getText().toString().equals(" ")) && (!btn23.getText().toString().equals(" ")) && (!btn24.getText().toString().equals(" "))
                && (!btn25.getText().toString().equals(" ")) && (!btn26.getText().toString().equals(" ")) && (!btn27.getText().toString().equals(" ")) && (!btn28.getText().toString().equals(" "))
                && (!btn29.getText().toString().equals(" ")) && (!btn30.getText().toString().equals(" ")) && (!btn31.getText().toString().equals(" ")) && (!btn32.getText().toString().equals(" "))
                && (!btn33.getText().toString().equals(" ")) && (!btn34.getText().toString().equals(" ")) && (!btn35.getText().toString().equals(" ")) && (!btn36.getText().toString().equals(" "))
                && (!btn37.getText().toString().equals(" ")) && (!btn38.getText().toString().equals(" ")) && (!btn39.getText().toString().equals(" ")) && (!btn40.getText().toString().equals(" "))
                && (!btn41.getText().toString().equals(" ")) && (!btn42.getText().toString().equals(" ")) && (!btn43.getText().toString().equals(" ")) && (!btn44.getText().toString().equals(" "))
                && (!btn45.getText().toString().equals(" ")) && (!btn46.getText().toString().equals(" ")) && (!btn47.getText().toString().equals(" ")) && (!btn48.getText().toString().equals(" "))
                && (!btn49.getText().toString().equals(" ")) && (!btn50.getText().toString().equals(" ")) && (!btn51.getText().toString().equals(" ")) && (!btn52.getText().toString().equals(" "))
                && (!btn53.getText().toString().equals(" ")) && (!btn54.getText().toString().equals(" ")) && (!btn55.getText().toString().equals(" ")) && (!btn56.getText().toString().equals(" "))
                && (!btn57.getText().toString().equals(" ")) && (!btn58.getText().toString().equals(" ")) && (!btn59.getText().toString().equals(" ")) && (!btn60.getText().toString().equals(" "))
                && (!btn61.getText().toString().equals(" ")) && (!btn62.getText().toString().equals(" ")) && (!btn63.getText().toString().equals(" ")) && (!btn64.getText().toString().equals(" "))
                && (!btn65.getText().toString().equals(" ")) && (!btn66.getText().toString().equals(" ")) && (!btn67.getText().toString().equals(" ")) && (!btn68.getText().toString().equals(" "))
                && (!btn69.getText().toString().equals(" ")) && (!btn70.getText().toString().equals(" ")) && (!btn71.getText().toString().equals(" ")) && (!btn72.getText().toString().equals(" "))
                && (!btn73.getText().toString().equals(" ")) && (!btn74.getText().toString().equals(" ")) && (!btn75.getText().toString().equals(" ")) && (!btn76.getText().toString().equals(" "))
                && (!btn77.getText().toString().equals(" ")) && (!btn78.getText().toString().equals(" ")) && (!btn79.getText().toString().equals(" ")) && (!btn80.getText().toString().equals(" "))
                && (!btn81.getText().toString().equals(" "))) {
            SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            int lvl = sh.getInt("lvl", 1);

            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferences.edit();
            myEdit.putInt("lvl", lvl + 1);
            myEdit.commit();
            new MaterialAlertDialogBuilder(Play.this)
                    .setTitle("You Won")
                    .setMessage("congratulations you cleared the lvl")
                    .setPositiveButton("Next Lvl", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            getdata(String.valueOf(lvl + 1));
                        }
                    })
                    .setNegativeButton("Home", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .show();

        }
    }

    @SuppressLint("SetTextI18n")
    private void getdata(String level) {
        ProgressDialog dialog = ProgressDialog.show(Play.this, "",
                "Loading. Please wait...", true);
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
                        dialog.dismiss();
                    } else {

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
                                finish();
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

    private void setData() {
        num = (String[]) getIntent().getSerializableExtra("Data");
        btn1.setTag(" ");
        btn2.setTag(" ");
        btn3.setTag(" ");
        btn4.setTag(" ");
        btn5.setTag(" ");
        btn6.setTag(" ");
        btn7.setTag(" ");
        btn8.setTag(" ");
        btn9.setTag(" ");
        btn10.setTag(" ");
        btn11.setTag(" ");
        btn12.setTag(" ");
        btn13.setTag(" ");
        btn14.setTag(" ");
        btn15.setTag(" ");
        btn16.setTag(" ");
        btn17.setTag(" ");
        btn18.setTag(" ");
        btn19.setTag(" ");
        btn20.setTag(" ");
        btn21.setTag(" ");
        btn22.setTag(" ");
        btn23.setTag(" ");
        btn24.setTag(" ");
        btn25.setTag(" ");
        btn26.setTag(" ");
        btn27.setTag(" ");
        btn28.setTag(" ");
        btn29.setTag(" ");
        btn30.setTag(" ");
        btn31.setTag(" ");
        btn32.setTag(" ");
        btn33.setTag(" ");
        btn34.setTag(" ");
        btn35.setTag(" ");
        btn36.setTag(" ");
        btn37.setTag(" ");
        btn38.setTag(" ");
        btn39.setTag(" ");
        btn40.setTag(" ");
        btn41.setTag(" ");
        btn42.setTag(" ");
        btn43.setTag(" ");
        btn44.setTag(" ");
        btn45.setTag(" ");
        btn46.setTag(" ");
        btn47.setTag(" ");
        btn48.setTag(" ");
        btn49.setTag(" ");
        btn50.setTag(" ");
        btn51.setTag(" ");
        btn52.setTag(" ");
        btn53.setTag(" ");
        btn54.setTag(" ");
        btn55.setTag(" ");
        btn56.setTag(" ");
        btn57.setTag(" ");
        btn58.setTag(" ");
        btn59.setTag(" ");
        btn60.setTag(" ");
        btn61.setTag(" ");
        btn62.setTag(" ");
        btn63.setTag(" ");
        btn64.setTag(" ");
        btn65.setTag(" ");
        btn66.setTag(" ");
        btn67.setTag(" ");
        btn68.setTag(" ");
        btn69.setTag(" ");
        btn70.setTag(" ");
        btn71.setTag(" ");
        btn72.setTag(" ");
        btn73.setTag(" ");
        btn74.setTag(" ");
        btn75.setTag(" ");
        btn76.setTag(" ");
        btn77.setTag(" ");
        btn78.setTag(" ");
        btn79.setTag(" ");
        btn80.setTag(" ");
        btn81.setTag(" ");

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
        clickListeners();
    }

    private void initialize() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Data");
        Activated = 0;
        remove = false;
        lifeCount=3;
        CurLvL = findViewById(R.id.CurLvL);
        String lvl = getIntent().getStringExtra("lvl");
        CurLvL.setText("Level-" + lvl);

        life1=findViewById(R.id.life1);
        life2=findViewById(R.id.life2);
        life3=findViewById(R.id.life3);
        erase = findViewById(R.id.erase);
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
        btnA = new Button[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50, btn51, btn52, btn53, btn54, btn55, btn56, btn57, btn58, btn59, btn60, btn61, btn62, btn63, btn64, btn65, btn66, btn67, btn68, btn69, btn70, btn71, btn72, btn73, btn74, btn75, btn76, btn77, btn78, btn79, btn80, btn81};

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

        }
    }
}