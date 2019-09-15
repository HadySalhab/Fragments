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

public class Fragment2 extends Fragment implements Subject {
    private Button mSendButton2;
    private Observer mObserver;
    private boolean mChangedFlag;
    private EditText mEditText2;
    private TextView mTextView2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragment2 = inflater.inflate(R.layout.fragment_2, container, false);
        mSendButton2 = (Button) fragment2.findViewById(R.id.button_2);
        mTextView2 = (TextView) fragment2.findViewById(R.id.textView_2);
        mEditText2 = (EditText) fragment2.findViewById(R.id.editText_2);

        mSendButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //only when the send button is triggered , something is changed.
                //we have to notify our observers
                mChangedFlag = true;
                notifyObservers();

            }
        });

        return fragment2;
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
        mObserver.update(Fragment2.this);
        mChangedFlag= false; //turning the flag off after notifiying observers

    }


    public TextView getTextView() {
        return mTextView2;
    }

    public EditText getEditText2() {
        return mEditText2;
    }
}

