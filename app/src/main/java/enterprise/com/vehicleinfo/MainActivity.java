package enterprise.com.vehicleinfo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements YearFragment.OnYearSelectedListener {

    private YearFragment yearFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            YearFragment yearFragment = new YearFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, yearFragment).commit();
        }
    }

    public void onYearSelected(String year) {
       // MakeFragment makeFragment = (MakeFragment) getSupportFragmentManager().findFragmentById(R.layout.fragment_make);

        //MakeFragment makeList = new MakeFragment();
        //getFragmentManager().beginTransaction().replace(R.id.list_year_fragment, makeList).commit();

        MakeFragment makeFragment = new MakeFragment();
        Bundle args = new Bundle();
        args.putString("year", year);
        makeFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, makeFragment);
        transaction.addToBackStack(null);
        transaction.commit();


        /*MakeFragment makeFragment = new MakeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.list_year_fragment, makeFragment);
        transaction.addToBackStack(null);
        transaction.commit();*/


        //if (makeFragment != null) {
           // makeFragment.updateMakeView(year);
        //} else {
            //MakeFragment fragment = new MakeFragment();
            //Bundle args = new Bundle();
            //args.putString("year", year);
            //fragment.setArguments(args);

            //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            //transaction.replace(R.id.list_year_fragment, fragment);
           // transaction.addToBackStack(null);
       //     transaction.commit();
        // }
    }
}
