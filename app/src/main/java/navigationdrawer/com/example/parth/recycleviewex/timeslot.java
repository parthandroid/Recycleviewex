package navigationdrawer.com.example.parth.recycleviewex;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class timeslot extends AppCompatActivity {


    public static String FIRST = "";
    public static String SECOND = "";
    public static String THIRD = "";
    public static String FOURTH = "";
    public static String FIFTH = "";
    public static String SIXTH = "";
    public static String SEVENTH = "";
    public static String EIGHTH = "";

    public static String ROOM = "";
    public static String DAY = "";


    public CheckBox first, second, third, fourth, fifth, sixth, seventh, eighth;
    public Button submit;

    ArrayList al = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeslot);


        first = (CheckBox) findViewById(R.id.checkBox);
        second = (CheckBox) findViewById(R.id.checkBox2);
        third = (CheckBox) findViewById(R.id.checkBox3);
        fourth = (CheckBox) findViewById(R.id.checkBox4);
        fifth = (CheckBox) findViewById(R.id.checkBox5);
        sixth = (CheckBox) findViewById(R.id.checkBox6);
        seventh = (CheckBox) findViewById(R.id.checkBox7);
        eighth = (CheckBox) findViewById(R.id.checkBox8);



        submit = (Button) findViewById(R.id.button6);


        set(FIRST, first);
        set(SECOND, second);
        set(THIRD, third);
        set(FOURTH, fourth);
        set(FIFTH, fifth);
        set(SIXTH, sixth);
        set(SEVENTH, seventh);
        set(EIGHTH, eighth);


    }


    public void set(String s, CheckBox c) {

        if (s.equals("a")) {

            c.setChecked(false);

        } else {

            c.setChecked(true);
            c.setClickable(false);


        }


    }


    public void submit(View v) {






        if(FIRST.equals("a")){

            if(first.isChecked()){

                FIRST = "na1";

                al.add("8:30 - 9:30");


            }

        }

        if(SECOND.equals("a")){

            if(second.isChecked()){

                SECOND = "na1";

                al.add("9:30 - 10:30");

            }

        }

        if(THIRD.equals("a")){

            if(third.isChecked()){

                THIRD = "na1";
                al.add("10:30 - 11:30");
            }

        }


        if(FOURTH.equals("a")){

            if(fourth.isChecked()){

                FOURTH = "na1";

                al.add("11:30 - 12:30");


            }

        }


        if(FIFTH.equals("a")){

            if(fifth.isChecked()){

                FIFTH = "na1";

                al.add("12:30 - 1:30");


            }

        }


        if(SIXTH.equals("a")){

            if(sixth.isChecked()){

                SIXTH = "na1";

                al.add("1:30 - 2:30");

            }

        }


        if(SEVENTH.equals("a")){

            if(seventh.isChecked()){

                SEVENTH = "na1";

                al.add("2:30 - 3:30");

            }

        }


        if(EIGHTH.equals("a")){

            if(eighth.isChecked()){

                EIGHTH = "na1";

                al.add("3:30 - 4:30");

            }

        }




        MyTask myTask = new MyTask();
        myTask.execute(FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH, EIGHTH, ROOM ,DAY);




    }



    class MyTask extends AsyncTask<String,Integer,String> {

        @Override
        protected String doInBackground(String... params) {

            String first = params[0];
            String second = params[1];
            String third = params[2];
            String fourth = params[3];
            String fifth = params[4];
            String sixth = params[5];
            String seventh = params[6];
            String eighth = params[7];

            String room = params[8];
            String day = params[9];


            String submit_url = "http://192.168.1.111/insertdata.php";   //insertdata.php



                try {
                    URL url = new URL(submit_url);
                    HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream os = httpURLConnection.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(os , "UTF-8");
                    BufferedWriter bufferedWriter = new BufferedWriter(osw);

                    String data = URLEncoder.encode("first", "UTF-8")+"="+URLEncoder.encode(first ,"UTF-8")+"&"+URLEncoder.encode("second","UTF-8")+"="+URLEncoder.encode(second ,"UTF-8")+"&"+URLEncoder.encode("third","UTF-8")+"="+URLEncoder.encode(third ,"UTF-8")+"&"+URLEncoder.encode("fourth","UTF-8")+"="+URLEncoder.encode(fourth ,"UTF-8")+"&"+URLEncoder.encode("fifth","UTF-8")+"="+URLEncoder.encode(fifth ,"UTF-8")+"&"+URLEncoder.encode("sixth","UTF-8")+"="+URLEncoder.encode(sixth ,"UTF-8")+"&"+URLEncoder.encode("seventh","UTF-8")+"="+URLEncoder.encode(seventh ,"UTF-8")+"&"+URLEncoder.encode("eighth","UTF-8")+"="+URLEncoder.encode(eighth ,"UTF-8")+"&"+URLEncoder.encode("room","UTF-8")+"="+URLEncoder.encode(room ,"UTF-8")+"&"+URLEncoder.encode("day","UTF-8")+"="+URLEncoder.encode(day ,"UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    os.close();

                    InputStream is = httpURLConnection.getInputStream();
                    is.close();
                    httpURLConnection.disconnect();

                    return "successfull";
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }





            return null;

        }

        @Override
        protected void onPostExecute(String s) {

int numtimeslots = al.size();

            finalscreen.ROOM = ROOM;
            finalscreen.DAY = DAY;
            finalscreen.AL = al;
           finalscreen.NOTS = numtimeslots;

            startActivity(new Intent(timeslot.this, finalscreen.class));




        }
    }




}
