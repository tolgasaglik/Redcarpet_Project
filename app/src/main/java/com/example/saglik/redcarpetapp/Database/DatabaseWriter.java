package com.example.saglik.redcarpetapp.Database;

import com.example.saglik.redcarpetapp.Classes.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by SAGLIK on 15-Dec-17.
 */

public class DatabaseWriter {
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public DatabaseWriter() {

    }
    public void registerUser(User user){
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser userA = mAuth.getCurrentUser();
        String userID = userA.getUid();               //GET ID FROM AUTHENTICATION
        user.setPhoneNumber(userA.getPhoneNumber());
        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance().getReference("users/"+userID);
        // [END initialize_database_ref]
        mDatabase.child("nickname").setValue(user.getNickname());
        mDatabase.child("location").setValue(user.getLocation());
        mDatabase.child("admin").setValue(user.isAdmin());
        mDatabase.child("phoneNumber").setValue(user.getPhoneNumber());
    }
}
