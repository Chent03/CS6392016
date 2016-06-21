package chent03.asynctaskproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button LIJbt = (Button)findViewById(R.id.LIJbut);
        LIJbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LongOperation image = new LongOperation();
                image.execute("https://github.com/Chent03/CS6392016/blob/master/LIJ.jpeg?raw=true");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    //Connect to Internet and get Stream
    private InputStream Connect(String urlStr)
    {
        InputStream is = null;
        try{
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            if(con.getResponseCode() != 200)
            {
                throw new Exception("Failed to connect");
            }
            is = con.getInputStream();

        } catch (Exception e) {
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }
        return is;
    }
    //InputStream to Bitmap
    private Bitmap is2Bitmap(InputStream is)
    {
        Bitmap bitmap = null;
        bitmap = BitmapFactory.decodeStream(is);
        return bitmap;
    }
    //Bitmap to Drawable
    private Drawable Bitmap2Drawable(Bitmap bitmap)
    {
        Drawable draw = null;
        draw = new BitmapDrawable(getResources(), bitmap);
        return draw;
    }
    //Background Thread
    private class LongOperation extends AsyncTask<String, Void,Drawable>
    {
        @Override
        protected Drawable doInBackground(String... params) {
            String url = params[0];
            InputStream is = Connect(url);
            Bitmap bitmap = is2Bitmap(is);
            Drawable drawable = Bitmap2Drawable(bitmap);
            return drawable;
        }

        @Override
        protected void onPostExecute(Drawable drawable) {
            super.onPostExecute(drawable);

            ImageView image = (ImageView)findViewById(R.id.LIJ);
            image.setImageDrawable(drawable);
        }
    }
}
