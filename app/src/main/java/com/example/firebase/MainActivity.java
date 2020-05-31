package com.example.firebase;

/**
 * @author Hadar Malul
 * @since 31.5.2020
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import static com.example.firebase.FBref.refStudent;
import com.example.firebase.Student;

public class MainActivity extends AppCompatActivity {

    EditText etsId,etNAME, etADD, etNUM, etHNUM, etMNAME, etMNUM, etDNAME, etDNUM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


               etsId = (EditText) findViewById(R.id.etsID);
               etNAME = (EditText) findViewById(R.id.etNAME);
               etADD = (EditText) findViewById(R.id.etADD);
               etNUM = (EditText) findViewById(R.id.etNUM);
               etHNUM = (EditText) findViewById(R.id.etHnum);
               etMNAME = (EditText) findViewById(R.id.etMNAME);
               etMNUM = (EditText) findViewById(R.id.etMNUM);
               etDNAME = (EditText) findViewById(R.id.etDNAME);
               etDNUM = (EditText) findViewById(R.id.etDNUM);


         }

    public void enterdata(View view) {

        /**
         * put in variables the edittext input
         * @param view
         */

        String name, address, mName, dName, stID, num, Hnum, Mnum, Dnum;

        stID = etsId.getText().toString();
        name = etNAME.getText().toString();
        address = etADD.getText().toString();
        num = etNUM.getText().toString();
        Hnum = etHNUM.getText().toString();
        mName = etMNAME.getText().toString();
        Mnum = etMNUM.getText().toString();
        dName = etDNAME.getText().toString();
        Dnum = etDNUM.getText().toString();

        Student stu = new Student(stID, name, address, num, Hnum, mName, Mnum, dName, Dnum);
        refStudent.child(stID).setValue(stu);
    }


    /**
     * creates options menu that moves to other activities
     * @param menu
     * @return
     */

    public boolean onCreateOptionsMenu (Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        String st = item.getTitle().toString();
        if (st.equals("Enter Data")) {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        if (st.equals("Info")){
            Intent si = new Intent(this, InfoActivity.class);
            startActivity(si);
        }
        if(st.equals("Grades")){
            Intent si = new Intent(this, stugrades.class);
            startActivity(si);
        }
        if (st.equals("Sort")){
            Intent si = new Intent(this, SortActivity.class);
            startActivity(si);
        }
        if (st.equals("Credits")){
            Intent si = new Intent(this, Credits.class);
            startActivity(si);
        }
        return true;
    }
    }