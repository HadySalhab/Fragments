package android.hady.fragmentsorientation;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CountryFragment extends Fragment {
    TextView mTextViewInfo;
    public static final String EXTRA_INFO = "android.hady.fragmentsorientation.countryInfo";


    public static CountryFragment getCountryFragment(int countryInfo){
        CountryFragment mCountryFragment = new CountryFragment();
        Bundle args = new Bundle();
        args.putInt(EXTRA_INFO,countryInfo);
        mCountryFragment.setArguments(args);
        return mCountryFragment;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View view = inflater.inflate(R.layout.fragment_country,container,false);
         mTextViewInfo = (TextView) view.findViewById(R.id.textView_info);
         Bundle bundle = getArguments();
         String text =  getActivity().getString(bundle.getInt(EXTRA_INFO)) ;
         mTextViewInfo.setText(text);

         return view;
    }
}
