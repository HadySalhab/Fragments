package android.hady.fragmentscommunicationonthesamehostingactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.Callbckfrom1,Fragment2.Callbckfrom2 {
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
        mManager.beginTransaction().add(R.id.container_1,mFragment1,null)
                .add(R.id.container_2,mFragment2,null)
                .commit();
    }

    @Override
    public void sentFrom1(String text) {
        mFragment2.getTextView2().setText(text);
    }

    @Override
    public void sentFrom2(String text) {
        mFragment1.getTextView1().setText(text);

    }
}
