package android.hady.fragmentsorientation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CountryList.Callbacks {
private CountryInfo [] mCountryInfos;
private     CountryFragment mCountryFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CountryInfo Australia = new CountryInfo(R.string.australia);
        CountryInfo Lebanon = new CountryInfo(R.string.lebanon);

        mCountryInfos = new CountryInfo[]{Australia,Lebanon};

        if(savedInstanceState==null) {
            CountryList mFragmentCountryList = new CountryList();
            addFragment(mFragmentCountryList);
        }
    }

    @Override
    public void countryInfo(String countryName) {
        switch (countryName){
            case "Australia":
                mCountryFragment = CountryFragment.getCountryFragment(R.string.australia);
                break;
            case "Lebanon":
                mCountryFragment =  CountryFragment.getCountryFragment(R.string.lebanon);

        }
        addFragment(mCountryFragment);
    }

    public void addFragment(Fragment fragment){
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().addToBackStack(null).add(R.id.fragment_container,fragment,null).commit();
    }


}
