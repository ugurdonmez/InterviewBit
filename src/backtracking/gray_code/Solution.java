package backtracking.gray_code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ugurdonmez on 17/08/16.
 */
public class Solution {

    public static void main(String [] args) {



    }

    public ArrayList<Integer> grayCode(int n) {

        if(n==0){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        ArrayList<Integer> result = grayCode(n-1);
        int numToAdd = 1<<(n-1);

        for(int i=result.size()-1; i>=0; i--){
            result.add(numToAdd+result.get(i));
        }

        return result;

    }

}
