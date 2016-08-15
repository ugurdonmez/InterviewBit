package two_pointers.sort_by_color;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 08/08/16.
 */
public class Solution {

    public void sortColors(ArrayList<Integer> a) {

        int arr_size = a.size();

        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0,temp=0;
        while (mid <= hi)
        {
            switch (a.get(mid))
            {
                case 0:
                {
                    temp = a.get(lo);
                    a.set(lo, a.get(mid));
                    a.set(mid, temp);

                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2:
                {
                    temp = a.get(mid);
                    a.set(mid, a.get(hi));
                    a.set(hi, temp);
                    hi--;
                    break;
                }
            }
        }

    }

}
