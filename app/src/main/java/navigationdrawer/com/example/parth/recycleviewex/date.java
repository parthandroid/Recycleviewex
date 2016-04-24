package navigationdrawer.com.example.parth.recycleviewex;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class date extends AppCompatActivity {


    Button monday;
    Button tuesday;
    Button wednesday;
    Button thursday;
    Button friday;

    public static String ROOM = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);


        monday = (Button) findViewById(R.id.button);
        tuesday = (Button) findViewById(R.id.button2);
        wednesday = (Button) findViewById(R.id.button3);
        thursday = (Button) findViewById(R.id.button4);
        friday = (Button) findViewById(R.id.button5);

        Toast.makeText(this, " room chosen : " + ROOM, Toast.LENGTH_SHORT).show();

    }


    public void monday(View v) {


        timeslot.DAY = "monday";
        timeslot.ROOM = ROOM;

        MyTask myTask1 = new MyTask();
        myTask1.execute(ROOM, "monday", "", "", "");

        //startActivity(new Intent(date.this , timeslot.class));


    }
    public void tuesday(View v) {

        timeslot.DAY = "tuesday";
        timeslot.ROOM = ROOM;

        MyTask myTask1 = new MyTask();
        myTask1.execute(ROOM, "tuesday", "", "", "");

        //startActivity(new Intent(date.this , timeslot.class));


    }
    public void wednesday(View v) {

        timeslot.DAY = "wednesday";
        timeslot.ROOM = ROOM;

        MyTask myTask1 = new MyTask();
        myTask1.execute(ROOM, "wednesday", "", "", "");

        //startActivity(new Intent(date.this , timeslot.class));


    }
    public void thursday(View v) {

        timeslot.DAY = "thursday";
        timeslot.ROOM = ROOM;

        MyTask myTask1 = new MyTask();
        myTask1.execute(ROOM, "thursday", "", "", "");

        //startActivity(new Intent(date.this , timeslot.class));


    }
    public void friday(View v) {

        timeslot.DAY = "friday";
        timeslot.ROOM = ROOM;

        MyTask myTask1 = new MyTask();
        myTask1.execute(ROOM, "friday", "", "", "");

        //startActivity(new Intent(date.this , timeslot.class));


    }


    class MyTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {

            String room = params[0];
            String day = params[1];
            String age = params[2];
            String phone = params[3];
            String address = params[4];


            String retrive_url = "http://192.168.1.111/read_data.php";


            try {
                URL url = new URL(retrive_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));


                Log.d("ROOMKEEPER", room + day);

                String data = URLEncoder.encode("room", "UTF-8") + "=" + URLEncoder.encode(room, "UTF-8") + "&" + URLEncoder.encode("day", "UTF-8") + "=" + URLEncoder.encode(day, "UTF-8");


                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream is = httpURLConnection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is, "iso-8859-1");
                BufferedReader bufferedReader = new BufferedReader(isr);

                int c;
                StringBuilder response = new StringBuilder();

                while ((c = bufferedReader.read()) != -1) {
                    //Since c is an integer, cast it to a char. If it isn't -1, it will be in the correct range of char.
                    response.append((char) c);
                }
                String result = response.toString();


                bufferedReader.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;

        }

        @Override
        protected void onPostExecute(String s) {



            try {


                JSONArray jsonArray = new JSONArray(s);

                JSONObject jsonObject = jsonArray.getJSONObject(0);

                String first = jsonObject.getString("first");
                String second = jsonObject.getString("second");
                String third = jsonObject.getString("third");
                String fourth = jsonObject.getString("fourth");

                String fifth = jsonObject.getString("fifth");
                String sixth = jsonObject.getString("sixth");
                String seventh = jsonObject.getString("seventh");
                String eighth = jsonObject.getString("eighth");

                timeslot.FIRST = first;
                timeslot.SECOND = second;
                timeslot.THIRD = third;
                timeslot.FOURTH = fourth;
                timeslot.FIFTH = fifth;
                timeslot.SIXTH = sixth;
                timeslot.SEVENTH = seventh;
                timeslot.EIGHTH = eighth;



                startActivity(new Intent(date.this, timeslot.class));



            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }


}
