package com.example.jamie.warmindjsonfunctions;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class SecondActivity extends AppCompatActivity {

    public ListView lv;
    TextView displayMembershipID;
    TextView displayFirstCharacterType;
    ImageView emblemIcon;
    ImageView emblemBackground;

    String firstCharacterEmblem;

    String bungie = "https://bungie.net";
    String appendEmblem;
    String appendBackground;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        String playerUsername = extras.getString("user");


//        lv = (ListView) findViewById(R.id.list);

        Post n = new Post(SecondActivity.this, playerUsername);
        n.execute();

        displayMembershipID = (TextView)findViewById(R.id.displayMembershipID);
        displayFirstCharacterType = (TextView)findViewById(R.id.displayFirstCharacterType);
        emblemIcon = (ImageView)findViewById(R.id.emblemIcon);
        emblemBackground = (ImageView)findViewById(R.id.emblemBackground);
//        emblemIcon = (ImageView)findViewById(R.id.emblemIcon);
//        emblemBackground = (ImageView)findViewById(R.id.emblemBackground);

//        public void dumpJSON(String jsonStr) {
//            outputTextView.setText(jsonStr);
//        }

//            public void outputResults(String membershipId) {
//            displayMembershipID.setText(membershipId);
//        }

    }
    public void dumpJSON(String firstCharacterID, String firstClassType, String firstCharacterEmblem, String firstCharacterEmblemBackground) {
        displayMembershipID.setText(firstCharacterID);
        System.out.println(firstClassType);
        if(Integer.parseInt(firstClassType) == 0){
            displayFirstCharacterType.setText("Titan");
        }
        else if(Integer.parseInt(firstClassType) == 1){
            displayFirstCharacterType.setText("Hunter");
        }
        else if(Integer.parseInt(firstClassType) == 2){
            displayFirstCharacterType.setText("Warlock");
        }
//        displayCharacterLightLevel.setText(firstClassType);
        System.out.println("Emblem link: "+firstCharacterEmblem);

        appendEmblem = bungie+firstCharacterEmblem;
        appendBackground = bungie+firstCharacterEmblemBackground;
//                "\nFirst Character class Type: "+firstClassType+
//                "\nFirst Character Emblem: "+firstCharacterEmblem+
//                "\nFirst Character Background: "+firstCharacterEmblemBackground);

        //<img src="https://bungie.net/common/destiny_content/icons/6ab7743cc8535a1d07a161fb1248ae23.jpg">

        new downloadImage(this, emblemIcon).execute(appendEmblem);

        new downloadBackground(this, emblemBackground).execute(appendBackground);

        System.out.println(appendEmblem);

//        try {
//            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(appendEmblem).getContent());
//            System.out.println("Emblem link: "+firstCharacterEmblem);
//            emblemIcon.setImageBitmap(bitmap);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//
//            Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(firstCharacterEmblemBackground).getContent());
//            emblemBackground.setImageBitmap(bitmap);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }




}
