package chent03.stateslistproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    String[] states = {"Alabama","Alaska", "Arizona", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
        "Idaho", "Illinois", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
        "Mississippi", "Missouri", "Montana", "Nebraska", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
        "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "Tennessee",
        "Texas", "Utah", "Vermont", "Virginia", "Washington", "Washington", "West Virginia", "Wisonsin", "Wyoming"};


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.fragment_main, container, false);

        List<String> allstate = new ArrayList<String>(Arrays.asList(states));

        ArrayAdapter<String> statesall = new ArrayAdapter<String>(getActivity(),R.layout.listviewitem, R.id.textviewitem, allstate);

        ListView listView = (ListView)v.findViewById(R.id.listviewlayout);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 3:
                        String geoUri = String.format("geo:38.555556,-121.468889");
                        Uri geo = Uri.parse(geoUri);
                        final Intent intent = new Intent(Intent.ACTION_VIEW, geo);
                        startActivity(intent);
                }

            }
        });
        listView.setAdapter(statesall);


        return v;
    }
}
