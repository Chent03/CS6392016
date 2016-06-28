package chent03.tonychenmidterm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private TextView screen, currency;
    private String display ="";
    private Button delbtn, converter;
    private double Number;
    private boolean success = false;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.fragment_main, container, false);
        currency = (TextView)v.findViewById(R.id.usd);
        screen = (TextView)v.findViewById(R.id.textView);
        screen.setText(display);

        int idList[] = {R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven,
                        R.id.eight, R.id.nine, R.id.zero, R.id.dot};
        for(int id:idList){
             final Button btns = (Button)v.findViewById(id);
             btns.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     display += btns.getText();
                     updateScreen();
                 }
             });
        }

        delbtn = (Button)v.findViewById(R.id.button);
        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
                updateScreen();
                currency.setText("USD");
            }
        });

        converter =(Button) v.findViewById(R.id.converter);
        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currency.setText("CFA");
                convertedScreen();
            }
        });


        return v;
    }
    private void updateScreen(){
        screen.setText(display);
    }

    private void clear(){
        display = "";
    }

    private void convertedScreen(){
            Number = Double.parseDouble(screen.getText().toString());
            double cfa = convert(Number);
            screen.setText(Double.toString(cfa));
    }

    private double convert(double amt){
        final double rate = 586.84;
        double cfa = amt * rate;
        double roundOff = (double)Math.round(cfa*100)/100;
        return roundOff;
    }

}
