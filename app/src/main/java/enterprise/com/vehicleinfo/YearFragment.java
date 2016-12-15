package enterprise.com.vehicleinfo;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by Matthew on 12/14/2016.
 */

public class YearFragment extends ListFragment {

    private static final int NUMBEROFYEARS = 20;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        GetYears yearsList = new GetYears();
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, yearsList.getYearList(NUMBEROFYEARS));
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
