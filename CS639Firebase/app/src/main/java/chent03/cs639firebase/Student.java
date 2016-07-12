package chent03.cs639firebase;

import com.firebase.client.Firebase;

/**
 * Created by Tony on 7/11/16.
 */
public class Student extends  android.app.Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
