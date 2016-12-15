package enterprise.com.vehicleinfo;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * Created by Matthew on 12/14/2016.
 */

public class MakeFragment extends android.support.v4.app.ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        String url = "https://api.edmunds.com/api/vehicle/v2/makes?year=" +
                bundle.getString("year") + "&fmt=json&api_key=jskft3jqdm9wrhvj3fba2qwg";
        new GetMakes(this, getActivity()).execute(url);
       // GetYears yearsList = new GetYears();
      //  ArrayAdapter<Integer> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, yearsList.getYearList(20));
      //  setListAdapter(adapter);
        //GetYears yearsList = new GetYears();
        //ArrayAdapter<Integer> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, yearsList.getYearList(NUMBEROFYEARS));
        //setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
