package enterprise.com.vehicleinfo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements YearFragment.OnYearSelectedListener, MakeFragment.OnMakeSelectedListener, ModelFragment.OnModelSelectedListener {

    private YearFragment yearFragment;
    private MakeFragment makeFragment;
    private String selectedYear;

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

        MakeFragment makeFragment = new MakeFragment();
        Bundle args = new Bundle();
        args.putString("year", year);
        selectedYear = year;
        makeFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, makeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onMakeSelected(String make) {

        ModelFragment modelFragment = new ModelFragment();
        Bundle args = new Bundle();
        args.putString("make", make);
        args.putString("year", selectedYear);
        modelFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, modelFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void onModelSelected(String make) {

    }
}
