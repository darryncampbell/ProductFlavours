package com.darryncampbell.productflavours;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.symbol.emdk.EMDKManager;
import com.symbol.emdk.EMDKResults;
import com.symbol.emdk.ProfileManager;
import com.symbol.emdk.EMDKManager.EMDKListener;

public class MainActivity extends AppCompatActivity implements EMDKListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onOpened(EMDKManager emdkManager) {

    }

    @Override
    public void onClosed() {

    }
}
