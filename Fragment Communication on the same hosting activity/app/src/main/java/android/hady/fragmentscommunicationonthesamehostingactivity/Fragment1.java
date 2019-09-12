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

public class Fragment1 extends Fragment {
    private Button mSendButton1;
    private TextView mTextView1;
    private EditText mEditText1;
    private Callbckfrom1 mCallback1;
    private String mText1;


    //this is the observer interface
    public interface Callbckfrom1 { //every class that implements this interface will be a type Callbckfrom1
        public void sentFrom1(String text);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragment1 = inflater.inflate(R.layout.fragment_1,container,false);
        mSendButton1 = (Button) fragment1.findViewById(R.id.button_1);
        mTextView1 = (TextView) fragment1.findViewById(R.id.textView_1);
        mEditText1 = (EditText) fragment1.findViewById(R.id.editText_1);

        mSendButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mText1 = mEditText1.getText().toString();
                mCallback1.sentFrom1(mText1);
            }
        });

        return fragment1;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Activity is a subclass of context
        //we want the activities/classes that implements Callbckfrom1 or of type Callbckfrom1
        //to be stored in mCallback1
        //Any activity can still host this fragments..but only the ones that implement the interface can receive a callback
        mCallback1 = (Callbckfrom1) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback1 = null;
    }

    public TextView getTextView1() {
        return mTextView1;
    }

    public void setTextView1(TextView textView1) {
        mTextView1 = textView1;
    }

    public EditText getEditText1() {
        return mEditText1;
    }

    public void setEditText1(EditText editText1) {
        mEditText1 = editText1;
    }

    public Callbckfrom1 getCallback1() {
        return mCallback1;
    }

    public void setCallback1(Callbckfrom1 callback1) {
        mCallback1 = callback1;
    }
}
