package navigationdrawer.com.example.parth.recycleviewex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {


    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.customButton);

    }



    public void login(View v){

        startActivity(new Intent(login.this ,  MainActivity.class));



    }

}
