package enterprise.com.vehicleinfo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Matthew on 12/14/2016.
 */

public class GetYears {

    public ArrayList<Integer> getYearList(int num) {

        ArrayList<Integer> yearList = new ArrayList<>();
        Calendar year = Calendar.getInstance();
        yearList.add(year.get(Calendar.YEAR));
        int i = 0;

        while (i < 20) {
            year.add(Calendar.YEAR, -1);
            yearList.add(year.get(Calendar.YEAR));
            i++;
        }
        return yearList;
    }
}
