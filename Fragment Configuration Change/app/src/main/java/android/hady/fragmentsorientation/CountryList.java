package android.hady.fragmentsorientation;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CountryList extends Fragment {


    private TextView mTextViewAustralia;
    private TextView mTextViewLebanon;
    private Callbacks mCallbacks;

    interface Callbacks {
        public void countryInfo(String countryName);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_country_list,container,false);
        mTextViewAustralia = view.findViewById(R.id.textView_australia);
        mTextViewLebanon = view.findViewById(R.id.textView_lebanon);
        mTextViewAustralia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.countryInfo("Australia");

            }
        });
        mTextViewLebanon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallbacks.countryInfo("Lebanon");
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbacks = (Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }
}
