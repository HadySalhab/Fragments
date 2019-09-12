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

public class Fragment2 extends Fragment {
    private Button mSendButton2;
    private TextView mTextView2;
    private   EditText mEditText2;
    private Callbckfrom2 mCallback2;
    private String mText2;

    //this is the observer interface
    public interface Callbckfrom2 { //every class that implements this interface will be a type Callbckfrom2
        public void sentFrom2(String text);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragment2 = inflater.inflate(R.layout.fragment_2,container,false);
        mSendButton2 = (Button) fragment2.findViewById(R.id.button_2);
        mTextView2 = (TextView) fragment2.findViewById(R.id.textView_2);
        mEditText2 = (EditText) fragment2.findViewById(R.id.editText_2);

        mSendButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mText2 = mEditText2.getText().toString();
               mCallback2.sentFrom2(mText2);
            }
        });


        return fragment2;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Activity is a subclass of context
        //we want the activities/classes that implements Callbckfrom1 or of type Callbckfrom1
        //to be stored in mCallbck
        //Any activity can still host this fragments..but only the ones that implement the interface can receive a callback
        mCallback2 = (Callbckfrom2) context;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mCallback2 = null;
    }

    public Button getSendButton2() {
        return mSendButton2;
    }

    public void setSendButton2(Button sendButton2) {
        mSendButton2 = sendButton2;
    }

    public TextView getTextView2() {
        return mTextView2;
    }

    public void setTextView2(TextView textView2) {
        mTextView2 = textView2;
    }

    public EditText getEditText2() {
        return mEditText2;
    }

    public void setEditText2(EditText editText2) {
        mEditText2 = editText2;
    }
}
