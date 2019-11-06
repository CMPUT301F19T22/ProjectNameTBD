package com.cmput3owo1.moodlet.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.cmput3owo1.moodlet.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private static final String TAG = "Moodlet";
    private static final LatLng EDMONTON = new LatLng(53.5444,-113.4909);

    MapView mapView;
    GoogleMap map;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Log.e("MOODLET", "onCreateView called");

        View view = inflater.inflate(R.layout.fragment_map, container, false);

        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
//        if (savedInstanceState != null) {
//            Log.e("MOODLET", "Got some saved instance things");
//        } else {
//            Log.e("MOODLET", "No saved instance things");
//
//        }
        mapView.getMapAsync(this);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("MOODLET", "onStart called");
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("MOODLET", "onResume called");
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("MOODLET", "onPause called");
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("MOODLET", "onStop called");
        mapView.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MOODLET", "onDestroy called");
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("MOODLET", "onSaveInstanceState called");
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        Log.e("MOODLET", "onMapReady called");
        this.map = map;
//        this.map.setMyLocationEnabled(true);
//        this.map.setOn
        // Set camera to last known/recorded location

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = this.map.setMapStyle(MapStyleOptions.loadRawResourceStyle(mapView.getContext(), R.raw.map_style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }

        this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(EDMONTON, 12));
    }
}