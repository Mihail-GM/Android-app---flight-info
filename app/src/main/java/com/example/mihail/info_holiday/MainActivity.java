package com.example.mihail.info_holiday;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.ObjectMapper;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work

    ObjectMapper mapper = new ObjectMapper();

    //a list to store all the products
    List<FlightInfo> flightInfoList;

    //the recyclerview
    Button getInfoTransfer;
    EditText inputedBookID;
    TextView resultTransfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //getting the recyclerview from xml
        getInfoTransfer = (Button) findViewById(R.id.getTrasnfer);
        inputedBookID = (EditText) findViewById(R.id.editTextBookingID);
        resultTransfer = (TextView) findViewById(R.id.textViewDisplayedTrasnferResult);


        //initializing the productlist
        flightInfoList = new ArrayList<>();


        getInfoTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bookID = inputedBookID.getText().toString();
                loadFlightInfo(bookID);




            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void loadFlightInfo (String paramBookID) {


        final String URL_FLIGHTSEARCH = "http://192.168.1.8:8080/flight/" + paramBookID ;
        final String[] resResponse = {null};

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_FLIGHTSEARCH,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                            //converting the string to json array object

                            Log.d("response", response);
                            String jsonInString = response;

                         //   JSONArray array = new JSONArray(response);
                            FlightInfo flightInfo = null;

                            try {
                                flightInfo = mapper.readValue(jsonInString, FlightInfo.class);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }



                            Log.d("data obj ---------------------------------------------", flightInfo.toString());
                            resultTransfer.setText("We will pick you at " +  flightInfo.getTimeOfFlight() + "o'lock"  + "for yout flight which is shecdule for " +
                                    flightInfo.getDateOfFlight() + " at "+ flightInfo.getTimeOfFlight() + " o'clock" );

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);


    }






    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = null;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (id == R.id.nav_camera) {
            // Home / Ssearch
            intent = new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

            intent = new Intent(MainActivity.this,Attraction.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            intent = new Intent(MainActivity.this,Info.class);
            startActivity(intent);


        }else if (id == R.id.nav_user) {
            intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);


        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
