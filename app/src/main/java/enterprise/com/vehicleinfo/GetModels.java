package enterprise.com.vehicleinfo;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 12/15/2016.
 */

public class GetModels extends AsyncTask<String, Void, List<String>> {

    private Activity activity;
    private ListFragment fragment;
    private String year;
    private List<String> modelList;

    public GetModels(ListFragment fragment, Activity activity) {
        this.fragment = fragment;
        this.activity = activity;
        this.year = year;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<String> doInBackground(String... urls) {
        try {
            String strUrl = "";
            for (String url : urls) {
                strUrl = url;
            }
            URL url = new URL(strUrl);

            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            String JSONString = streamToString(request.getInputStream());
            JSONObject makeObject = new JSONObject(JSONString);
            JSONArray array = makeObject.getJSONArray("models");
            modelList = new ArrayList<>();

            for (int i = 0; i < array.length(); i++) {
                JSONObject childJSONObject = array.getJSONObject(i);
                modelList.add(childJSONObject.getString("name"));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return modelList;
    }

    private String streamToString(InputStream inputStream) throws IOException {
        if(inputStream != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[1024];

            try {
                Reader reader = new BufferedReader( new InputStreamReader(inputStream, "UTF-8"));

                int n;
                while((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                inputStream.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }

    @Override
    protected void onPostExecute(List<String> result) {

        fragment.setListAdapter(new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, modelList));
    }
}
