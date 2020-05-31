package com.example.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FBref {

    public static FirebaseDatabase FBDB = FirebaseDatabase.getInstance();
    public static DatabaseReference refStudent = FBDB.getReference("student");
    public static DatabaseReference refGrades = FBDB.getReference("grades");
}
