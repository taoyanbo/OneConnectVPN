package com.freeapp.lionvpn.activities;

import android.content.Intent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.freeapp.lionvpn.R;
import com.freeapp.lionvpn.Utils.Constants;

import org.jetbrains.annotations.NotNull;

import top.oneconnectapi.app.api.JsonResponseListener;
import top.oneconnectapi.app.api.OneConnect;

public class SplashScreen extends AppCompatActivity {
    CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        OneConnect oneConnect = new OneConnect();
        oneConnect.initialize(this, "vFchdtLp21MKm0youcEbN1I7y7mgU0l0B0Un4eR0uRjdAS7ZS."); //Sample API key

        oneConnect.fetchJson(new JsonResponseListener() {
            @Override
            public void onSuccess(String freeServersJson, String premiumServersJson) {
                Constants.FREE_SERVERS = freeServersJson;
                Constants.PREMIUM_SERVERS = premiumServersJson;
                // Print the result to Logcat
                Log.d("OneConnectServer", "Free Servers: " + freeServersJson);
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("OneConnectServer", "Failed to fetch servers", e);
            }
        });
/*
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference typeRef = database.getReference("type");
        DatabaseReference indratech_toto_27640849_admob_id = database.getReference("indratech_toto_27640849_admob_id");
        DatabaseReference indratech_toto_27640849_ad_banner = database.getReference("indratech_toto_27640849_ad_banner");
        DatabaseReference indratech_toto_27640849_aad_native = database.getReference("indratech_toto_27640849_aad_native");
        DatabaseReference indratech_toto_27640849_fb_native = database.getReference("indratech_toto_27640849_fb_native");
        DatabaseReference indratech_toto_27640849_fb_interstitial = database.getReference("indratech_toto_27640849_fb_interstitial");
        DatabaseReference indratech_toto_27640849_ad_interstitial = database.getReference("indratech_toto_27640849_ad_interstitial");
        DatabaseReference indratech_toto_27640849_admob_reward = database.getReference("indratech_toto_27640849_admob_reward");
        DatabaseReference indratech_toto_27640849_fb_reward = database.getReference("indratech_toto_27640849_fb_reward");
        DatabaseReference indratech_toto_27640849_all_ads_on_off = database.getReference("indratech_toto_27640849_all_ads_on_off");
        DatabaseReference copyright_ivpnofficial_dont_change_the_value = database.getReference("copyright_ivpnofficial_dont_change_the_value");

        String TAG = "Firebase";

        indratech_toto_27640849_all_ads_on_off.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NotNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);


                MainActivity.indratech_toto_27640849_all_ads_on_off = value != null && value.equalsIgnoreCase("on");

                Log.d(TAG,"indratech_toto_27640849_all_ads_on_off "+value);
                Log.d(TAG,"indratech_toto_27640849_all_ads_on_off "+MainActivity.indratech_toto_27640849_all_ads_on_off);
            }

            @Override
            public void onCancelled(@NotNull DatabaseError error) {
                MainActivity.indratech_toto_27640849_all_ads_on_off = false;
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        typeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                MainActivity.type = value;
                Log.d(TAG,"Type"+value);
                Log.d(TAG,"Type"+MainActivity.type);

            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        indratech_toto_27640849_aad_native.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                MainActivity.indratech_toto_27640849_aad_native_id = value;
                Log.d(TAG,"Native"+value);
                Log.d(TAG,"Native"+MainActivity.indratech_toto_27640849_aad_native_id);

            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        indratech_toto_27640849_admob_id.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                MainActivity.indratech_toto_27640849_admob_id = value;
                Log.d(TAG,"Admob ID"+value);
                Log.d(TAG,"Admob ID"+MainActivity.indratech_toto_27640849_admob_id);
                try {
                    ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName(),PackageManager.GET_META_DATA);
                    Bundle bundle = applicationInfo.metaData;
                    applicationInfo.metaData.putString("com.google.android.gms.ads.APPLICATION_ID",MainActivity.indratech_toto_27640849_admob_id);
                    String apiKey = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
                    Log.d(TAG,"The saved id is "+MainActivity.indratech_toto_27640849_admob_id);
                    Log.d(TAG,"The saved id is "+apiKey);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }catch (NullPointerException e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        indratech_toto_27640849_ad_banner.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                MainActivity.indratech_toto_27640849_ad_banner_id = value;
                Log.d(TAG,"Admob Banner"+value);
                Log.d(TAG,"Admob Banner"+MainActivity.indratech_toto_27640849_ad_banner_id);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // Read from the database
        indratech_toto_27640849_ad_interstitial.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                MainActivity.admob_interstitial_id = value;
                Log.d(TAG,"Admob interstitial"+value);
                Log.d(TAG,"Admob interstitial"+MainActivity.admob_interstitial_id);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // Read from the database
        indratech_toto_27640849_fb_native.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                MainActivity.indratech_toto_27640849_fb_native_id = value;
                Log.d(TAG,"indratech_toto_27640849_fb_native"+value);
                Log.d(TAG,"indratech_toto_27640849_fb_native"+MainActivity.indratech_toto_27640849_fb_native_id);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // Read from the database
        indratech_toto_27640849_fb_interstitial.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                MainActivity.indratech_toto_27640849_fb_interstitial_id = value;
                Log.d(TAG,"indratech_toto_27640849_fb_interstitial"+value);
                Log.d(TAG,"indratech_toto_27640849_fb_interstitial"+MainActivity.indratech_toto_27640849_fb_interstitial_id);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // Read from the database
        indratech_toto_27640849_fb_reward.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                MainActivity.indratech_toto_27640849_fb_reward_id = value;
                Log.d(TAG,"indratech_toto_27640849_fb_reward"+value);
                Log.d(TAG,"indratech_toto_27640849_fb_reward"+MainActivity.indratech_toto_27640849_fb_reward_id);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        // Read from the database
        indratech_toto_27640849_admob_reward.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                MainActivity.indratech_toto_27640849_admob_reward = (value != null) ? value : "ca-app-pub-3940256099942544/5224354917";
                Log.d(TAG,"indratech_toto_27640849_admob_reward"+value);
                Log.d(TAG,"indratech_toto_27640849_admob_reward"+MainActivity.indratech_toto_27640849_admob_reward);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        copyright_ivpnofficial_dont_change_the_value.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                MainActivity.copyright_ivpnofficial_dont_change_the_value = value;
                Log.d(TAG,"copyright_ivpnofficial_dont_change_the_value"+value);
                Log.d(TAG,"copyright_ivpnofficial_dont_change_the_value"+MainActivity.copyright_ivpnofficial_dont_change_the_value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        coordinatorLayout = findViewById(R.id.cordi);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!Utility.isOnline(getApplicationContext())) {


            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Check internet connection", Snackbar.LENGTH_LONG);
            snackbar.show();


        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashScreen.this, IntroActivity.class));
                    finish();
                }
            },1000);

        }

    }
}
