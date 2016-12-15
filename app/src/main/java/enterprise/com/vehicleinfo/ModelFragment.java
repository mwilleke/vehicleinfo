package enterprise.com.vehicleinfo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Matthew on 12/15/2016.
 */

public class ModelFragment extends ListFragment {

    private OnModelSelectedListener mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        String url = "https://api.edmunds.com/api/vehicle/v2/honda/models?year=" +
                bundle.getString("year") + "&make=" + bundle.getString("make") + "&fmt=json&api_key=jskft3jqdm9wrhvj3fba2qwg";
        new GetModels(this, getActivity()).execute(url);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        String selectedValue = (String) getListAdapter().getItem(position).toString();
        mCallback.onModelSelected(selectedValue);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnModelSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement ModelFragment.OnModelSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    public interface OnModelSelectedListener {

        public void onModelSelected(String make);
    }
}
