package android.hady.fragmentscommunicationonthesamehostingactivity;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Fragment1 extends Fragment implements Subject {
    private Button mSendButton1;
    private Observer mObserver;
    private boolean mChangedFlag;
    private EditText mEditText1;
    private TextView mTextView1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragment1 = inflater.inflate(R.layout.fragment_1,container,false);
        mTextView1 = (TextView) fragment1.findViewById(R.id.textView_1);
        mEditText1 = (EditText) fragment1.findViewById(R.id.editText_1);
        mSendButton1 = (Button) fragment1.findViewById(R.id.button_1);

        mSendButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //only when the send button is triggered , something is changed.
                //we have to notify our observers
                mChangedFlag = true;
                notifyObservers();
            }
        });

        return fragment1;
    }


    @Override
    public void registerObserver(Observer obj) {
        mObserver = obj;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //remove all observers when fragments get Detached
        unregisterObserver(mObserver);

    }

    @Override
    public void unregisterObserver(Observer obj) {
        mObserver = null;
    }





    @Override
    public void notifyObservers() {
        //return if nothing has changed
        if(!mChangedFlag) {return;}
        //notify the observer when something has changed
        mObserver.update(Fragment1.this);
        mChangedFlag= false; //turning the flag off after notifiying observers
    }

    public TextView getTextView() {
        return mTextView1;
    }

    public EditText getEditText1() {
        return mEditText1;
    }
}
