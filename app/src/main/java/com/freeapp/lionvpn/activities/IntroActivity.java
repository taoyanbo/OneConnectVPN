package com.freeapp.lionvpn.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.freeapp.lionvpn.R;
import com.freeapp.lionvpn.Utils.Constants;

import io.github.dreierf.materialintroscreen.MaterialIntroActivity;
import io.github.dreierf.materialintroscreen.SlideFragmentBuilder;
import top.oneconnectapi.app.api.JsonResponseListener;
import top.oneconnectapi.app.api.OneConnect;

public class IntroActivity extends MaterialIntroActivity {
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OneConnect oneConnect = new OneConnect();
        oneConnect.initialize(this, "vFchdtLp21MKm0youcEbN1I7y7mgU0l0B0Un4eR0uRjdAS7ZS."); //Sample API key

        oneConnect.fetchJson(new JsonResponseListener() {
            @Override
            public void onSuccess(String freeServersJson, String premiumServersJson) {
                Constants.FREE_SERVERS = freeServersJson;
                Constants.PREMIUM_SERVERS = premiumServersJson;
            }

            @Override
            public void onFailure(Exception e) {

                Log.e("OneConnectServer", "Failed to fetch servers", e);
            }
        });

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", true)) {
            onFinish();
        } else {
//            To familiar the user with the basic requirements of the application...
            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.colorPrimaryDark)
                    .buttonsColor(R.color.colorPrimary)
                    .image(R.drawable.intro_one)
                    .title("Secure VPN Servers")
                    .description("Premium VPN App is Very Fast & Secure. And Easy to Use")
                    .build());
            addSlide(new SlideFragmentBuilder()
                    .backgroundColor(R.color.colorPrimaryDark)
                    .buttonsColor(R.color.colorPrimary)
                    .image(R.drawable.intro_two)
                    .title("Use Premium ")
                    .description("Buy Premium Servers and get more Secure Servers ")
                    .build());

        }
    }

    @Override
    public void onFinish() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstTime", false);
        editor.apply();
        super.onFinish();
    }
}

