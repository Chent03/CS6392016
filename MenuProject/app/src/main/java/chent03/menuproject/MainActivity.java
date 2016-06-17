package chent03.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

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

        Button SMSbtn = (Button) findViewById(R.id.SMS);
        SMSbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:" + Uri.encode("16465731388")));
                intent.putExtra("sms_body", "Tony Chen");
                startActivity(intent);
            }
        });

        Button Phonebtn = (Button) findViewById(R.id.PHONE);
        Phonebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:411"));
                startActivity(intent);
            }
        });

        Button Webbtn = (Button) findViewById(R.id.WEB);
        Webbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com"));
                startActivity(intent);
            }
        });

        Button Mapbtn = (Button) findViewById(R.id.MAP);
        Mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = String.format("geo:40.777658,-73.701489");
                Uri geo = Uri.parse(geoUri);
                final Intent intent = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(intent);
            }
        });

        Button Sharebtn = (Button) findViewById(R.id.SHARE);
        Sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_SEND);
                startActivity(Intent.createChooser(intent, "Share the love"));
            }
        });

        Button NewActbtn = (Button) findViewById(R.id.NEW);
        NewActbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
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
            Toast t = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
            t.show();
            return true;
        } else if (id == R.id.action_help) {
            final Intent intent = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

}
