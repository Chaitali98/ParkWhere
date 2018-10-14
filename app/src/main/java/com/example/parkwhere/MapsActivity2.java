package com.example.parkwhere;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int userid;
    private User user;
    private LatLng mDefaultLocation = new LatLng(18.5155, 73.815);
    private LatLng location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync( this);

        Intent intent = getIntent();
        user = intent.getExtras().getParcelable("user");
         location = intent.getExtras().getParcelable("Location");
        String toastmsg = new StringBuilder().append("USERID + ").append(user.getid()).toString();

        Toast.makeText(this, "hkhbkjbjk", Toast.LENGTH_SHORT).show();
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        if(location == null)
        {
            Toast.makeText(this,"location is null" , Toast.LENGTH_SHORT);
        }
        if(location != null)
            mMap.addMarker(new MarkerOptions().position(location).title("Your vehicle is parked here"));
        else
            mMap.addMarker(new MarkerOptions().position(mDefaultLocation).title("This is the default location"));

  //      LatLng sydney = new LatLng(-34, 151);
    //    mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
    }

    public void UnParkMe(View view) {


    }
}
