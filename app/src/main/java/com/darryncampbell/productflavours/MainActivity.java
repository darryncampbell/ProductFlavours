package com.darryncampbell.productflavours;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.symbol.emdk.EMDKManager;
import com.symbol.emdk.EMDKResults;
import com.symbol.emdk.ProfileManager;
import com.symbol.emdk.EMDKManager.EMDKListener;

public class MainActivity extends AppCompatActivity implements EMDKListener{

    private ProfileManager profileManager = null;
    private EMDKManager emdkManager;
    private static final String TAG = "ProductFlavours";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sleepButton = (Button)findViewById(R.id.btnSleep);
        sleepButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        applyProfile();
                    }
                }
        );
        EMDKResults results = EMDKManager.getEMDKManager(getApplicationContext(), this);
    }

    private void applyProfile() {
        if (profileManager != null)
        {
            String[] modifyData = new String[1];
            EMDKResults results = profileManager.processProfile("PowerProfile", ProfileManager.PROFILE_FLAG.SET, modifyData);
            if (results.statusCode == EMDKResults.STATUS_CODE.CHECK_XML)
            {
                //  It worked
                Log.i(TAG, "Power manager profile applied");
            }
            else
            {
                Log.e(TAG, "Power manager profile failed to apply");
            }
        }
    }

    @Override
    public void onOpened(EMDKManager emdkManager) {
        this.emdkManager = emdkManager;
        this.profileManager = (ProfileManager) emdkManager.getInstance(EMDKManager.FEATURE_TYPE.PROFILE);
    }

    @Override
    public void onClosed() {

    }
}
