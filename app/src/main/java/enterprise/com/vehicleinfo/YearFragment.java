package enterprise.com.vehicleinfo;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Matthew on 12/14/2016.
 */

public class YearFragment extends android.support.v4.app.ListFragment {

    private OnYearSelectedListener mCallback;

    private static final int NUMBEROFYEARS = 20;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        GetYears yearsList = new GetYears();
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, yearsList.getYearList(NUMBEROFYEARS));
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        String selectedValue = (String) getListAdapter().getItem(position).toString();
        mCallback.onYearSelected(selectedValue);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnYearSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement YearFragment.OnYearSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    public interface OnYearSelectedListener {

        public void onYearSelected(String year);
    }
}
