package com.example.android.sunshine.app.gcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyInstanceIDListenerService extends FirebaseInstanceIdService {
    private static final String TAG = "MyInstanceIDLS";

    /**
    * Called if InstanceID token is updated. This may occur if the security of
    * the previous token had been compromised. This call is initiated by the
    * InstanceID provider.
    */
    @Override
    public void onTokenRefresh() {
        // Fetch updated Instance ID token.
//        Intent intent = new Intent(this, RegistrationIntentService.class);
//        startService(intent);
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token) {
        Log.i(TAG, "GCM Registration Token: " + token);
    }
}