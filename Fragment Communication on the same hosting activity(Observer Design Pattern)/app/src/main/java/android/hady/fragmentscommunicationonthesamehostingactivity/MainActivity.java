package android.hady.fragmentscommunicationonthesamehostingactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Observer {
    Fragment1 mFragment1;
    Fragment2 mFragment2;
    FragmentManager mManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragment1 = new Fragment1();
        mFragment2 = new Fragment2();
        mManager = getFragmentManager();
        mManager.beginTransaction().add(R.id.container_1, (android.app.Fragment) mFragment1, null)
                .add(R.id.container_2, (android.app.Fragment) mFragment2, null)
                .commit();
    }


    @Override
    public void getNotified(Subject sbj, String message) {
        if (sbj == mFragment1) {
            mFragment2.getTextView().setText(message);
        }
        else{
            mFragment1.getTextView().setText(message);
        }


    }
}
