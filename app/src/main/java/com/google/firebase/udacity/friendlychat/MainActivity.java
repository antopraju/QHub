/**
 * Copyright Google Inc. All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.firebase.udacity.friendlychat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    public static String mUsername;
    public static final String ANONYMOUS = "anonymous";
    public static final int RC_SIGN_IN = 1;
    public FirebaseAuth mFirebaseAuth;
    public FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView semester1 = (TextView) findViewById(R.id.sem1);

        // Set a click listener on that View
        semester1.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Sem1Activity}
                Intent sem1Intent = new Intent(MainActivity.this, Sem1.class);

                // Start the new activity
                startActivity(sem1Intent);
            }
        });

        // Find the View that shows the Sem2 category
        TextView semester2 = (TextView) findViewById(R.id.sem2);

        // Set a click listener on that View
        semester2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Sem2Activity}
                Intent sem2Intent = new Intent(MainActivity.this, Sem2.class);

                // Start the new activity
                startActivity(sem2Intent);
            }
        });

        // Find the View that shows the Sem3 category
        TextView semester3 = (TextView) findViewById(R.id.sem3);

        // Set a click listener on that View
        semester3.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Sem3Activity}
                Intent sem3Intent = new Intent(MainActivity.this, Sem3.class);

                // Start the new activity
                startActivity(sem3Intent);
            }
        });

        // Find the View that shows the Sem4 category
        TextView semester4 = (TextView) findViewById(R.id.sem4);

        // Set a click listener on that View
        semester4.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Sem4Activity}
                Intent sem4Intent = new Intent(MainActivity.this, Sem4.class);

                // Start the new activity
                startActivity(sem4Intent);
            }
        });

        TextView semester5 = (TextView) findViewById(R.id.sem5);

        // Set a click listener on that View
        semester5.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Sem5Activity}
                Intent sem5Intent = new Intent(MainActivity.this, Sem5.class);

                // Start the new activity
                startActivity(sem5Intent);
            }
        });

        TextView semester6 = (TextView) findViewById(R.id.sem6);

        // Set a click listener on that View
        semester6.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Sem6Activity}
                Intent sem6Intent = new Intent(MainActivity.this, Sem6.class);

                // Start the new activity
                startActivity(sem6Intent);
            }
        });

        TextView semester7 = (TextView) findViewById(R.id.sem7);

        // Set a click listener on that View
        semester7.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link Sem7Activity}
                Intent sem7Intent = new Intent(MainActivity.this, Sem7.class);

                // Start the new activity
                startActivity(sem7Intent);
            }
        });

        TextView semester8 = (TextView) findViewById(R.id.sem8);

        // Set a click listener on that View
        semester8.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link sem8Activity}
                Intent sem8Intent = new Intent(MainActivity.this, Sem8.class);

                // Start the new activity
                startActivity(sem8Intent);
            }
        });


        mUsername = ANONYMOUS;
        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //signed in
                    onSignedInInitialized(user.getDisplayName());

                   // Toast.makeText(MainActivity.this, "You're now signed in. Welcome to QHub.", Toast.LENGTH_SHORT).show();
                } else {
                    //signed out
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }

    @Override
    public void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode,resultcode, data);
        if(requestcode == RC_SIGN_IN){
            if(resultcode == RESULT_OK){
                Toast.makeText(this, "Signed In!",Toast.LENGTH_SHORT).show();
            }else if(resultcode == RESULT_CANCELED){
                Toast.makeText(this,"Signed In Cancelled!!!",Toast.LENGTH_SHORT).show();
                finish();
            }
            }
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.sign_out_menu:
                AuthUI.getInstance().signOut(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onPause (){
        super.onPause();
        if(mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    public void onSignedInInitialized(String username){
        mUsername = username;
    }


    private void onSignedOutCleanup(){
        mUsername = ANONYMOUS;
    }
}

