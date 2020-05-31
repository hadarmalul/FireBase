package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.firebase.FBref.refStudent;
import static com.example.firebase.FBref.refGrades;


public class SortActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lvT, lvT2;
    ArrayList<String> stuList = new ArrayList<String>();
    ArrayList<Student> stuValues = new ArrayList<Student>();
    ArrayList<String> GList = new ArrayList<String>();
    ArrayList<Grades> GValues = new ArrayList<Grades>();
    ArrayAdapter adp, adp2;
    AlertDialog.Builder adb;
    String strtmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        lvT = (ListView) findViewById(R.id.lvT);
        lvT.setOnItemClickListener(this);
        lvT.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        lvT2 = (ListView) findViewById(R.id.lvT2);
        lvT2.setOnItemClickListener(this);
        lvT2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    /**
     * These methods sort the data with different parameters that you choose
     */
    public void byid1(View view) {
        Query query = refStudent.orderByChild("id");
        query.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot ds) {

                stuList.clear();
                stuValues.clear();
                for (DataSnapshot data : ds.getChildren()) {
                    String str1 = (String) data.getKey();
                    Student stuTmp = data.getValue(Student.class);
                    stuValues.add(stuTmp);
                    String str2 = stuTmp.getStuname();
                    stuList.add(str1 + " " + str2);
                }

                adp = new ArrayAdapter<String>(SortActivity.this,R.layout.support_simple_spinner_dropdown_item, stuList);
                lvT.setAdapter(adp);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void byname(View view) {

        Query query = refStudent.orderByChild("name");
        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot ds) {
                stuList.clear();
                stuValues.clear();
                for (DataSnapshot data : ds.getChildren()) {
                    String str1 = (String) data.getKey();
                    Student stuTmp = data.getValue(Student.class);
                    stuValues.add(stuTmp);
                    String str2 = stuTmp.getStuname();
                    stuList.add(str1 + " " + str2);
                }
                adp = new ArrayAdapter<String>(SortActivity.this, R.layout.support_simple_spinner_dropdown_item, stuList);
                lvT.setAdapter(adp);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void byid2(View view) {
        Query query = refGrades.orderByChild("stuid");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            //
            @Override
            public void onDataChange(DataSnapshot ds) {
                GList.clear();
                GValues.clear();
                for(DataSnapshot data : ds.getChildren()) {
                    String str1 = (String) data.getKey();
                    Grades GTmp = data.getValue(Grades.class);
                    GValues.add(GTmp);
                    String str2 = GTmp.getStudname();
                    GList.add(str1+" "+str2);
                }
                adp2 = new ArrayAdapter<String>(SortActivity.this,R.layout.support_simple_spinner_dropdown_item,GList);
                lvT2.setAdapter(adp2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });
    }

    public void bygrade(View view) {
        Query query = refGrades.orderByChild("grade");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            //
            @Override
            public void onDataChange(DataSnapshot ds) {
                GList.clear();
                GValues.clear();
                for(DataSnapshot data : ds.getChildren()) {
                    String str1 = (String) data.getKey();
                    Grades GTmp = data.getValue(Grades.class);
                    GValues.add(GTmp);
                    String str2 = GTmp.getStudname();
                    GList.add(str1+" "+str2);
                }
                adp2 = new ArrayAdapter<String>(SortActivity.this,R.layout.support_simple_spinner_dropdown_item,GList);
                lvT2.setAdapter(adp2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


        @Override
        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){

            if(parent==lvT){
                adb = new AlertDialog.Builder(this);
                adb.setTitle(stuValues.get(position).getStuname());
                final String strstuID=stuValues.get(position).getStuid();
                strtmp="Name: "+stuValues.get(position).getStuname()+"\n";
                strtmp+="ID: "+stuValues.get(position).getStuid()+"\n";
                strtmp+="Adress: "+String.valueOf(stuValues.get(position).getStuadd())+" ";
                strtmp+="Phone: "+String.valueOf(stuValues.get(position).getStupho())+" ";
                strtmp+="FName: "+String.valueOf(stuValues.get(position).getStudad())+" ";
                strtmp+="FPhone: "+String.valueOf(stuValues.get(position).getStudadp())+" ";
                strtmp+="Mname: "+String.valueOf(stuValues.get(position).getStumom())+" ";
                strtmp+="MPhone: "+String.valueOf(stuValues.get(position).getStumomp())+" ";
                strtmp+="Hphone: "+String.valueOf(stuValues.get(position).getStuhomep())+" ";
                adb.setMessage(strtmp);
                adb.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        refStudent.child(strstuID).removeValue();
                    }
                });

                adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog ad = adb.create();
                ad.show();
            }

            else{
                adb = new AlertDialog.Builder(this);
                adb.setTitle(GValues.get(position).getStudname());
                final String strgID=GValues.get(position).getStugID();
                strtmp="Name: "+GValues.get(position).getStudname()+"\n";
                strtmp+="ID: "+GValues.get(position).getStugID()+"\n";
                strtmp+="Grade: "+String.valueOf(GValues.get(position).getGrade())+" ";
                strtmp+="Quarter: "+String.valueOf(GValues.get(position).getQuarter())+" ";
                strtmp+="Subject: "+String.valueOf(GValues.get(position).getSubject())+" ";
                adb.setMessage(strtmp);
                adb.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        refGrades.child(strgID).removeValue();
                    }
                });

                adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog ad = adb.create();
                ad.show();


            }

        }
    /**
     * creates options menu that moves to other activities
     * @param menu
     * @return
     */

        public boolean onCreateOptionsMenu (Menu menu){

            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        public boolean onOptionsItemSelected (MenuItem item){
            String st = item.getTitle().toString();
            if (st.equals("Enter Data")) {
                Intent si = new Intent(this, MainActivity.class);
                startActivity(si);
            }
            if (st.equals("Info")) {
                Intent si = new Intent(this, InfoActivity.class);
                startActivity(si);
            }
            if (st.equals("Grades")) {
                Intent si = new Intent(this, stugrades.class);
                startActivity(si);
            }
            if (st.equals("Sort")) {
                Intent si = new Intent(this, SortActivity.class);
                startActivity(si);
            }
            if (st.equals("Credits")) {
                Intent si = new Intent(this, Credits.class);
                startActivity(si);
            }
            return true;
        }
    }

