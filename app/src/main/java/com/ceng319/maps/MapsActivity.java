package com.ceng319.maps;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng sydney = new LatLng(-33.852, 151.211);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // Add a marker in Sydney and move the camera
        LatLng Toronto = new LatLng(43.6532, -79.3832);
        MarkerOptions markerOptions = new MarkerOptions().position(Toronto)
                .title("Marker in Toronto")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.toronto));
        mMap.addMarker(markerOptions);


        LatLng Ottawa = new LatLng(45.4215, - 75.6972);
        mMap.addMarker(new MarkerOptions()
                .position(Ottawa)
                .title("Marker in Ottawa"));


        LatLng Humber = new LatLng(43.724330436, -79.605497578);
        mMap.addMarker(new MarkerOptions()
                .position(Humber)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.humber))
                .title("Welcome to Humber College"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Humber, (float) 6.0));
        mMap.setMinZoomPreference(2.0f);
        mMap.setMaxZoomPreference(30.0f);
        mMap.setTrafficEnabled(true);
    }
}
