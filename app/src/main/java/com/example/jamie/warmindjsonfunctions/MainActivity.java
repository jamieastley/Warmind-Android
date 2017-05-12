package com.example.jamie.warmindjsonfunctions;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView outputTextView;
    EditText getPlayerUsername;
    Button searchUserBtn;
    Switch consoleSwitch;

    String playerUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPlayerUsername = (EditText) findViewById(R.id.playerUsername);
        searchUserBtn = (Button) findViewById(R.id.searchUserBtn);
        consoleSwitch = (Switch) findViewById(R.id.consoleSwitch);


//        Intent launchResult = new Intent(MainActivity.this, Post.class);
//        putExtra("key", playerUsername);
//        startActivity(launchResult);

//        Post n = new Post(this, playerUsername);
//        n.execute();


//        outputTextView = (TextView) findViewById(R.id.output);
    }


//    public void addNewItem(View view) {
//
//        //to go to another activity, must build an intent
//        //intent is asking android to do something. Android can say no (usually when there's not enough memory)
//        Intent nextScreen = new Intent(this, NewItemActivity.class);
//
//        //lets try launch this thing. For result means we will wait for whatever results
//        startActivityForResult(nextScreen, 1);
//
//    }

    public void searchByUsername(View view) {

//        Intent mIntent = new Intent(this, SecondActivity.class);
//        mIntent.putExtra("switch", s.isChecked());
//        startActivity(mIntent);

//        Intent intent = new Intent(this, MyActivity.class);
//        Bundle extras = new Bundle();
//        extras.putString("EXTRA_USERNAME","my_username");
//        extras.putString("EXTRA_PASSWORD","my_password");
//        intent.putExtras(extras);
//        startActivity(intent);

        //Intent intent = ((Activity) context).getIntent();
//        Intent searchForPlayer = new Intent(MainActivity.this, Post.class);

        playerUsername = getPlayerUsername.getText().toString();

        Intent searchResult = new Intent(MainActivity.this, SecondActivity.class);
        Bundle extras = new Bundle();
        extras.putString("user", playerUsername);
        extras.putBoolean("console", consoleSwitch.isChecked());
        searchResult.putExtras(extras);
        //searchResult.putExtra("user", playerUsername, "switch", consoleSwitch.isChecked());
        startActivity(searchResult);
//
//        Post n = new Post(MainActivity.this, playerUsername);
//        n.execute();

//        searchForPlayer.putExtra("username", playerUsername.getText().toString());
//        startActivity(searchForPlayer);
    }

//    public String getUsername() {
//        return playerUsername.getText().toString();
//    }


    public void dumpJSON(String jsonStr) {
        outputTextView.setText(jsonStr);
    }
}
//
//
//}
