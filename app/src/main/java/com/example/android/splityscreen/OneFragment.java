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

public class OneFragment extends Fragment {
    private static EditText mEditText;
    ListView onemessageList;
    private Context context;
    baseAdapter mAdapter;
    ArrayList<String> onemessage;
    OneFragmentListener activityCallback;
    public interface OneFragmentListener {
         void onOneButtonClick(String text);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCallback = (OneFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OneFragmentListener");
        }
    }
    //We get the reference to the editText and the button setUp the OnClickListener
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        onemessage=new ArrayList<String>();

        View view = inflater.inflate(R.layout.one_fragment, container, false);
        context=getContext();
        onemessageList = (ListView) view.findViewById(R.id.onelistview);
        if (onemessage == null)
            mAdapter = new baseAdapter(context);
        else
            mAdapter = new baseAdapter( context,onemessage);

        onemessageList.setAdapter(mAdapter);
        mEditText = (EditText) view.findViewById(R.id.oneedittext);

        final Button button = (Button) view.findViewById(R.id.onebutton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        return view;
    }
    //Set the activityCallback to onButtonClick passing the text in the mEditText
    public void buttonClicked(View view) {
        activityCallback.onOneButtonClick(mEditText.getText().toString());
    }
    public void twochangeTextProperties(String text) {
        onemessage.add(text);
        baseAdapter myAdapter = new baseAdapter( context,onemessage);
        Log.e(OneFragment.class.getSimpleName(),"1pleaseeee"+onemessage.size());
        Log.e(OneFragment.class.getSimpleName(),"1pleaseeee"+onemessage.get(onemessage.size()-1));
        onemessageList.setAdapter(myAdapter);
    }
}