package navigationdrawer.com.example.parth.recycleviewex;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class finalscreen extends AppCompatActivity {


    public static String ROOM = "";
    public static String DAY = "";
    public static int NOTS = 0;

    TextView day , room , ts1 , ts2 ,ts3 , ts4;
    Button screenshot;

    public static ArrayList AL;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalscreen);

        day = (TextView)findViewById(R.id.textView15);
        room = (TextView)findViewById(R.id.textView16);

        ts1 = (TextView)findViewById(R.id.textView17);
        ts2 = (TextView)findViewById(R.id.textView18);
        ts3 = (TextView)findViewById(R.id.textView19);
        ts4 = (TextView)findViewById(R.id.textView20);




        day.setText(DAY);
        room.setText(ROOM);


        if(NOTS == 1){

            ts1.setText(AL.get(0) + "");

        }

        else if (NOTS ==2){

            ts1.setText(AL.get(0) + "");
            ts2.setText(AL.get(1) + "");
        }

        else if(NOTS ==3){

            ts1.setText(AL.get(0) + "");
            ts2.setText(AL.get(1) + "");
            ts3.setText(AL.get(2) + "");

        }

        else if(NOTS ==4){


            ts1.setText(AL.get(0) + "");
            ts2.setText(AL.get(1) + "");
            ts3.setText(AL.get(2) + "");
            ts4.setText(AL.get(3) + "");

        }




    }



}
