package com.anand.sudoku;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Upload extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button Upload;
    EditText btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20,
            btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39,
            btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49, btn50, btn51, btn52, btn53, btn54, btn55, btn56, btn57, btn58,
            btn59, btn60, btn61, btn62, btn63, btn64, btn65, btn66, btn67, btn68, btn69, btn70, btn71, btn72, btn73, btn74, btn75, btn76, btn77,
            btn78, btn79, btn80, btn81;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        btn1 = findViewById(R.id.ebutton1);
        btn2 = findViewById(R.id.ebutton2);
        btn3 = findViewById(R.id.ebutton3);
        btn4 = findViewById(R.id.ebutton4);
        btn5 = findViewById(R.id.ebutton5);
        btn6 = findViewById(R.id.ebutton6);
        btn7 = findViewById(R.id.ebutton7);
        btn8 = findViewById(R.id.ebutton8);
        btn9 = findViewById(R.id.ebutton9);
        btn10 = findViewById(R.id.ebutton10);
        btn11 = findViewById(R.id.ebutton11);
        btn12 = findViewById(R.id.ebutton12);
        btn13 = findViewById(R.id.ebutton13);
        btn14 = findViewById(R.id.ebutton14);
        btn15 = findViewById(R.id.ebutton15);
        btn16 = findViewById(R.id.ebutton16);
        btn17 = findViewById(R.id.ebutton17);
        btn18 = findViewById(R.id.ebutton18);
        btn19 = findViewById(R.id.ebutton19);
        btn20 = findViewById(R.id.ebutton20);
        btn21 = findViewById(R.id.ebutton21);
        btn22 = findViewById(R.id.ebutton22);
        btn23 = findViewById(R.id.ebutton23);
        btn24 = findViewById(R.id.ebutton24);
        btn25 = findViewById(R.id.ebutton25);
        btn26 = findViewById(R.id.ebutton26);
        btn27 = findViewById(R.id.ebutton27);
        btn28 = findViewById(R.id.ebutton28);
        btn29 = findViewById(R.id.ebutton29);
        btn30 = findViewById(R.id.ebutton30);
        btn31 = findViewById(R.id.ebutton31);
        btn32 = findViewById(R.id.ebutton32);
        btn33 = findViewById(R.id.ebutton33);
        btn34 = findViewById(R.id.ebutton34);
        btn35 = findViewById(R.id.ebutton35);
        btn36 = findViewById(R.id.ebutton36);
        btn37 = findViewById(R.id.ebutton37);
        btn38 = findViewById(R.id.ebutton38);
        btn39 = findViewById(R.id.ebutton39);
        btn40 = findViewById(R.id.ebutton40);
        btn41 = findViewById(R.id.ebutton41);
        btn42 = findViewById(R.id.ebutton42);
        btn43 = findViewById(R.id.ebutton43);
        btn44 = findViewById(R.id.ebutton44);
        btn45 = findViewById(R.id.ebutton45);
        btn46 = findViewById(R.id.ebutton46);
        btn47 = findViewById(R.id.ebutton47);
        btn48 = findViewById(R.id.ebutton48);
        btn49 = findViewById(R.id.ebutton49);
        btn50 = findViewById(R.id.ebutton50);
        btn51 = findViewById(R.id.ebutton51);
        btn52 = findViewById(R.id.ebutton52);
        btn53 = findViewById(R.id.ebutton53);
        btn54 = findViewById(R.id.ebutton54);
        btn55 = findViewById(R.id.ebutton55);
        btn56 = findViewById(R.id.ebutton56);
        btn57 = findViewById(R.id.ebutton57);
        btn58 = findViewById(R.id.ebutton58);
        btn59 = findViewById(R.id.ebutton59);
        btn60 = findViewById(R.id.ebutton60);
        btn61 = findViewById(R.id.ebutton61);
        btn62 = findViewById(R.id.ebutton62);
        btn63 = findViewById(R.id.ebutton63);
        btn64 = findViewById(R.id.ebutton64);
        btn65 = findViewById(R.id.ebutton65);
        btn66 = findViewById(R.id.ebutton66);
        btn67 = findViewById(R.id.ebutton67);
        btn68 = findViewById(R.id.ebutton68);
        btn69 = findViewById(R.id.ebutton69);
        btn70 = findViewById(R.id.ebutton70);
        btn71 = findViewById(R.id.ebutton71);
        btn72 = findViewById(R.id.ebutton72);
        btn73 = findViewById(R.id.ebutton73);
        btn74 = findViewById(R.id.ebutton74);
        btn75 = findViewById(R.id.ebutton75);
        btn76 = findViewById(R.id.ebutton76);
        btn77 = findViewById(R.id.ebutton77);
        btn78 = findViewById(R.id.ebutton78);
        btn79 = findViewById(R.id.ebutton79);
        btn80 = findViewById(R.id.ebutton80);
        btn81 = findViewById(R.id.ebutton81);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Data");
        EditText lvl = findViewById(R.id.lvlID);
        Upload = findViewById(R.id.uploadBtn);
        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(btn1.getText().toString())) {
                    btn1.setText(" ");
                }
                if (TextUtils.isEmpty(btn2.getText().toString())) {
                    btn2.setText(" ");
                }
                if (TextUtils.isEmpty(btn3.getText().toString())) {
                    btn3.setText(" ");
                }
                if (TextUtils.isEmpty(btn4.getText().toString())) {
                    btn4.setText(" ");
                }
                if (TextUtils.isEmpty(btn5.getText().toString())) {
                    btn5.setText(" ");
                }
                if (TextUtils.isEmpty(btn6.getText().toString())) {
                    btn6.setText(" ");
                }
                if (TextUtils.isEmpty(btn7.getText().toString())) {
                    btn7.setText(" ");
                }
                if (TextUtils.isEmpty(btn8.getText().toString())) {
                    btn8.setText(" ");
                }
                if (TextUtils.isEmpty(btn9.getText().toString())) {
                    btn9.setText(" ");
                }
                if (TextUtils.isEmpty(btn10.getText().toString())) {
                    btn10.setText(" ");
                }
                if (TextUtils.isEmpty(btn11.getText().toString())) {
                    btn11.setText(" ");
                }
                if (TextUtils.isEmpty(btn12.getText().toString())) {
                    btn12.setText(" ");
                }
                if (TextUtils.isEmpty(btn13.getText().toString())) {
                    btn13.setText(" ");
                }
                if (TextUtils.isEmpty(btn14.getText().toString())) {
                    btn14.setText(" ");
                }
                if (TextUtils.isEmpty(btn15.getText().toString())) {
                    btn15.setText(" ");
                }
                if (TextUtils.isEmpty(btn16.getText().toString())) {
                    btn16.setText(" ");
                }
                if (TextUtils.isEmpty(btn17.getText().toString())) {
                    btn17.setText(" ");
                }
                if (TextUtils.isEmpty(btn18.getText().toString())) {
                    btn18.setText(" ");
                }
                if (TextUtils.isEmpty(btn19.getText().toString())) {
                    btn19.setText(" ");
                }
                if (TextUtils.isEmpty(btn20.getText().toString())) {
                    btn20.setText(" ");
                }
                if (TextUtils.isEmpty(btn21.getText().toString())) {
                    btn21.setText(" ");
                }
                if (TextUtils.isEmpty(btn22.getText().toString())) {
                    btn22.setText(" ");
                }
                if (TextUtils.isEmpty(btn23.getText().toString())) {
                    btn23.setText(" ");
                }
                if (TextUtils.isEmpty(btn24.getText().toString())) {
                    btn24.setText(" ");
                }
                if (TextUtils.isEmpty(btn25.getText().toString())) {
                    btn25.setText(" ");
                }
                if (TextUtils.isEmpty(btn26.getText().toString())) {
                    btn26.setText(" ");
                }
                if (TextUtils.isEmpty(btn27.getText().toString())) {
                    btn27.setText(" ");
                }
                if (TextUtils.isEmpty(btn28.getText().toString())) {
                    btn28.setText(" ");
                }
                if (TextUtils.isEmpty(btn29.getText().toString())) {
                    btn29.setText(" ");
                }
                if (TextUtils.isEmpty(btn30.getText().toString())) {
                    btn30.setText(" ");
                }
                if (TextUtils.isEmpty(btn31.getText().toString())) {
                    btn31.setText(" ");
                }
                if (TextUtils.isEmpty(btn32.getText().toString())) {
                    btn32.setText(" ");
                }
                if (TextUtils.isEmpty(btn33.getText().toString())) {
                    btn33.setText(" ");
                }
                if (TextUtils.isEmpty(btn34.getText().toString())) {
                    btn34.setText(" ");
                }
                if (TextUtils.isEmpty(btn35.getText().toString())) {
                    btn35.setText(" ");
                }
                if (TextUtils.isEmpty(btn36.getText().toString())) {
                    btn36.setText(" ");
                }
                if (TextUtils.isEmpty(btn37.getText().toString())) {
                    btn37.setText(" ");
                }
                if (TextUtils.isEmpty(btn38.getText().toString())) {
                    btn38.setText(" ");
                }
                if (TextUtils.isEmpty(btn39.getText().toString())) {
                    btn39.setText(" ");
                }
                if (TextUtils.isEmpty(btn40.getText().toString())) {
                    btn40.setText(" ");
                }
                if (TextUtils.isEmpty(btn41.getText().toString())) {
                    btn41.setText(" ");
                }
                if (TextUtils.isEmpty(btn42.getText().toString())) {
                    btn42.setText(" ");
                }
                if (TextUtils.isEmpty(btn43.getText().toString())) {
                    btn43.setText(" ");
                }
                if (TextUtils.isEmpty(btn44.getText().toString())) {
                    btn44.setText(" ");
                }
                if (TextUtils.isEmpty(btn45.getText().toString())) {
                    btn45.setText(" ");
                }
                if (TextUtils.isEmpty(btn46.getText().toString())) {
                    btn46.setText(" ");
                }
                if (TextUtils.isEmpty(btn47.getText().toString())) {
                    btn47.setText(" ");
                }
                if (TextUtils.isEmpty(btn48.getText().toString())) {
                    btn48.setText(" ");
                }
                if (TextUtils.isEmpty(btn49.getText().toString())) {
                    btn49.setText(" ");
                }
                if (TextUtils.isEmpty(btn50.getText().toString())) {
                    btn50.setText(" ");
                }
                if (TextUtils.isEmpty(btn51.getText().toString())) {
                    btn51.setText(" ");
                }
                if (TextUtils.isEmpty(btn52.getText().toString())) {
                    btn52.setText(" ");
                }
                if (TextUtils.isEmpty(btn53.getText().toString())) {
                    btn53.setText(" ");
                }
                if (TextUtils.isEmpty(btn54.getText().toString())) {
                    btn54.setText(" ");
                }
                if (TextUtils.isEmpty(btn55.getText().toString())) {
                    btn55.setText(" ");
                }
                if (TextUtils.isEmpty(btn56.getText().toString())) {
                    btn56.setText(" ");
                }
                if (TextUtils.isEmpty(btn57.getText().toString())) {
                    btn57.setText(" ");
                }
                if (TextUtils.isEmpty(btn58.getText().toString())) {
                    btn58.setText(" ");
                }
                if (TextUtils.isEmpty(btn59.getText().toString())) {
                    btn59.setText(" ");
                }
                if (TextUtils.isEmpty(btn60.getText().toString())) {
                    btn60.setText(" ");
                }
                if (TextUtils.isEmpty(btn61.getText().toString())) {
                    btn61.setText(" ");
                }
                if (TextUtils.isEmpty(btn62.getText().toString())) {
                    btn62.setText(" ");
                }
                if (TextUtils.isEmpty(btn63.getText().toString())) {
                    btn63.setText(" ");
                }
                if (TextUtils.isEmpty(btn64.getText().toString())) {
                    btn64.setText(" ");
                }
                if (TextUtils.isEmpty(btn65.getText().toString())) {
                    btn65.setText(" ");
                }
                if (TextUtils.isEmpty(btn66.getText().toString())) {
                    btn66.setText(" ");
                }
                if (TextUtils.isEmpty(btn67.getText().toString())) {
                    btn67.setText(" ");
                }
                if (TextUtils.isEmpty(btn68.getText().toString())) {
                    btn68.setText(" ");
                }
                if (TextUtils.isEmpty(btn69.getText().toString())) {
                    btn69.setText(" ");
                }
                if (TextUtils.isEmpty(btn70.getText().toString())) {
                    btn70.setText(" ");
                }
                if (TextUtils.isEmpty(btn71.getText().toString())) {
                    btn71.setText(" ");
                }
                if (TextUtils.isEmpty(btn72.getText().toString())) {
                    btn72.setText(" ");
                }
                if (TextUtils.isEmpty(btn73.getText().toString())) {
                    btn73.setText(" ");
                }
                if (TextUtils.isEmpty(btn74.getText().toString())) {
                    btn74.setText(" ");
                }
                if (TextUtils.isEmpty(btn75.getText().toString())) {
                    btn75.setText(" ");
                }
                if (TextUtils.isEmpty(btn76.getText().toString())) {
                    btn76.setText(" ");
                }
                if (TextUtils.isEmpty(btn77.getText().toString())) {
                    btn77.setText(" ");
                }
                if (TextUtils.isEmpty(btn78.getText().toString())) {
                    btn78.setText(" ");
                }
                if (TextUtils.isEmpty(btn79.getText().toString())) {
                    btn79.setText(" ");
                }
                if (TextUtils.isEmpty(btn80.getText().toString())) {
                    btn80.setText(" ");
                }
                if (TextUtils.isEmpty(btn81.getText().toString())) {
                    btn81.setText(" ");
                }

                LevelAdapter lvldata = new LevelAdapter(btn1.getText().toString(), btn2.getText().toString(), btn3.getText().toString(), btn4.getText().toString(), btn5.getText().toString(), btn6.getText().toString(), btn7.getText().toString(), btn8.getText().toString(), btn9.getText().toString(), btn10.getText().toString(), btn11.getText().toString(), btn12.getText().toString(), btn13.getText().toString(), btn14.getText().toString(), btn15.getText().toString(), btn16.getText().toString(), btn17.getText().toString(), btn18.getText().toString(), btn19.getText().toString(), btn20.getText().toString(), btn21.getText().toString(), btn22.getText().toString(), btn23.getText().toString(), btn24.getText().toString(), btn25.getText().toString(), btn26.getText().toString(), btn27.getText().toString(), btn28.getText().toString(), btn29.getText().toString(), btn30.getText().toString(), btn31.getText().toString(), btn32.getText().toString(), btn33.getText().toString(), btn34.getText().toString(), btn35.getText().toString(), btn36.getText().toString(), btn37.getText().toString(), btn38.getText().toString(), btn39.getText().toString(), btn40.getText().toString(), btn41.getText().toString(), btn42.getText().toString(), btn43.getText().toString(), btn44.getText().toString(), btn45.getText().toString(), btn46.getText().toString(), btn47.getText().toString(), btn48.getText().toString(), btn49.getText().toString(), btn50.getText().toString(), btn51.getText().toString(), btn52.getText().toString(), btn53.getText().toString(), btn54.getText().toString(), btn55.getText().toString(), btn56.getText().toString(), btn57.getText().toString(), btn58.getText().toString(), btn59.getText().toString(), btn60.getText().toString(), btn61.getText().toString(), btn62.getText().toString(), btn63.getText().toString(), btn64.getText().toString(), btn65.getText().toString(), btn66.getText().toString(), btn67.getText().toString(), btn68.getText().toString(), btn69.getText().toString(), btn70.getText().toString(), btn71.getText().toString(), btn72.getText().toString(), btn73.getText().toString(), btn74.getText().toString(), btn75.getText().toString(), btn76.getText().toString(), btn77.getText().toString(), btn78.getText().toString(), btn79.getText().toString(), btn80.getText().toString(), btn81.getText().toString());
                databaseReference.child("Level").child(lvl.getText().toString()).setValue(lvldata).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Upload.this, "Updated", Toast.LENGTH_SHORT).show();

                    }
                });
                ;
            }
        });

    }
}