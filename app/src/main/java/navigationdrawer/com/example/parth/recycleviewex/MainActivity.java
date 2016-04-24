package navigationdrawer.com.example.parth.recycleviewex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "RecyclerViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new
                                                                          MyRecyclerViewAdapter.MyClickListener() {
                                                                              @Override
                                                                              public void onItemClick(int position, View v) {
                                                                                  Log.i(LOG_TAG, " Clicked on Item " + position);




                                                                                  switch (position) {

                                                                                      case 0:

                                                                                          date.ROOM = "301";

                                                                                          startActivity(new Intent(MainActivity.this, date.class));
                                                                                          break;

                                                                                      case 1:

                                                                                          date.ROOM = "302";
                                                                                          startActivity(new Intent(MainActivity.this, date.class));
                                                                                          break;

                                                                                      case 2:

                                                                                          date.ROOM = "303";
                                                                                          startActivity(new Intent(MainActivity.this, date.class));
                                                                                          break;
                                                                                      case 3:

                                                                                          date.ROOM = "304";
                                                                                          startActivity(new Intent(MainActivity.this, date.class));
                                                                                          break;
                                                                                      case 4:

                                                                                          date.ROOM = "305";
                                                                                          startActivity(new Intent(MainActivity.this, date.class));
                                                                                          break;
                                                                                      case 5:

                                                                                          date.ROOM = "306";
                                                                                          startActivity(new Intent(MainActivity.this, date.class));
                                                                                          break;
                                                                                      case 6:

                                                                                          date.ROOM = "307";
                                                                                          startActivity(new Intent(MainActivity.this, date.class));
                                                                                          break;
                                                                                      case 7:

                                                                                          date.ROOM = "308";
                                                                                          startActivity(new Intent(MainActivity.this, date.class));
                                                                                          break;
                                                                                      case 8:

                                                                                          date.ROOM = "309";
                                                                                          startActivity(new Intent(MainActivity.this, date.class));
                                                                                          break;
                                                                                      case 9:

                                                                                          date.ROOM = "seminar hall";
                                                                                          startActivity(new Intent(MainActivity.this, date.class));
                                                                                          break;


                                                                                  }

                                                                              }
                                                                          });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();



       /* for (int index = 0; index < 20; index++) {

            DataObject obj = new DataObject("Room 30" + index,
                    "" + "");
            results.add(index, obj);
        }
        */


        DataObject obj = new DataObject("Room 301",
                "" + "");
        results.add(0, obj);

        DataObject obj1 = new DataObject("Room 302",
                "" + "");
        results.add(1, obj1);

        DataObject obj2 = new DataObject("Room 303",
                "" + "");
        results.add(2, obj2);

        DataObject obj3 = new DataObject("Room 304",
                "" + "");
        results.add(3, obj3);

        DataObject obj4 = new DataObject("Room 305",
                "" + "");
        results.add(4, obj4);

        DataObject obj5 = new DataObject("Room 306",
                "" + "");
        results.add(5, obj5);

        DataObject obj6 = new DataObject("Room 307",
                "" + "");
        results.add(6, obj6);

        DataObject obj7 = new DataObject("Room 308",
                "" + "");
        results.add(7, obj7);

        DataObject obj8 = new DataObject("Room 309",
                "" + "");
        results.add(8, obj8);

        DataObject obj9 = new DataObject("seminar hall",
                "" + "");
        results.add(9, obj9);


        return results;
    }
}
