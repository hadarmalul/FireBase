package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import static com.example.firebase.FBref.refGrades;

public class stugrades extends AppCompatActivity {

    EditText etgID, etNAME, etQUAR, etGRADE, etSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stugrades);

        etgID = (EditText) findViewById(R.id.etgID);
        etNAME = (EditText) findViewById(R.id.etNAME);
        etQUAR = (EditText) findViewById(R.id.etQUAR);
        etGRADE = (EditText) findViewById(R.id.etGRADE);
        etSub = (EditText) findViewById(R.id.etSub);

    }

    public void entergrades(View view) {

        String gID, name2, Quar, Grade, Sub;
        gID = etgID.getText().toString();
        name2 = etNAME.getText().toString();
        Quar = etQUAR.getText().toString();
        Grade = etGRADE.getText().toString();
        Sub = etSub.getText().toString();

        grades gra = new grades(gID, name2, Quar, Grade, Sub);
        refGrades.child(gID).setValue(gra);

    }



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
        return true;
    }
}
