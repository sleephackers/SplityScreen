package com.example.android.splityscreen;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TwoFragment extends Fragment {
    private static EditText twoEditText;
    private Context context;
    ListView twomessageList;
    baseAdapter mAdapter;
    TwoFragmentListener activityCallback;
    ArrayList<String> twomessage;
    //Listener for onButtonClick UI
    public interface TwoFragmentListener {
        void onTwoButtonClick(String text);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCallback = (TwoFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement TwoFragmentListener");
        }
    }
    //We get the reference to the editText and the button setUp the OnClickListener
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        twomessage=new ArrayList<String>();
        View view = inflater.inflate(R.layout.two_fragment, container, false);
        context=getContext();
        twomessageList = (ListView) view.findViewById(R.id.twolistview);
        if (twomessage == null)
                mAdapter = new baseAdapter(context);
        else
        mAdapter = new baseAdapter( context,twomessage);

        twomessageList.setAdapter(mAdapter);
        twoEditText = (EditText) view.findViewById(R.id.twoedittext);

        final Button button = (Button) view.findViewById(R.id.twobutton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        return view;
    }
    //Set the activityCallback to onButtonClick passing the text in the mEditText
    public void buttonClicked(View view) {
        activityCallback.onTwoButtonClick(twoEditText.getText().toString());
    }
    public void onechangeTextProperties(String text) {
        twomessage.add(text);
        Log.e(TwoFragment.class.getSimpleName(),"2pleaseeee"+twomessage.size());
        Log.e(TwoFragment.class.getSimpleName(),"2pleaseeee"+twomessage.get(twomessage.size()-1));
        baseAdapter myAdapter = new baseAdapter( context,twomessage);
        twomessageList.setAdapter(myAdapter);
    }
}