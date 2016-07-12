package chent03.cs639firebase;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    EditText StudentID;
    EditText FirstName;
    Button Submit;
    Firebase mRootRef;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.fragment_main, container, false);
        StudentID = (EditText)v.findViewById(R.id.editTextStudentID);
        FirstName = (EditText)v.findViewById(R.id.editTextFirstName);
        Submit = (Button)v.findViewById(R.id.buttonSubmit);
        mRootRef = new Firebase("https://cs639firebase-a59a5.firebaseio.com");

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first = FirstName.getText().toString();
                String id = StudentID.getText().toString();

                User user = new User(id, first);
                mRootRef.child("Student").setValue(user);
            }
        });





        return v;
    }
}
