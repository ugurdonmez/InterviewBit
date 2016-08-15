package string.pretty_json;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 09/08/16.
 */
public class Solution {

    public static void main(String [] args) {

    }

    /*
    Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
    Output :
    {
        A:"B",
        C:
        {
            D:"E",
            F:
            {
                G:"H",
                I:"J"
            }
        }
    }

     */

    public ArrayList<String> prettyJSON(String a) {

        ArrayList<String> list = new ArrayList<>();

        StringBuilder buf = new StringBuilder();
        int tabSize = 0;

        for (char c : a.toCharArray()) {

            if (c == '[') {
                buf.append(c);
                list.add(buf.toString());
                buf = new StringBuilder();
                tabSize++;

                for (int i = 0; i < tabSize; i++) {
                    buf.append('\t');
                }

            } else if (c == ']') {

            }

        }

        return list;
    }
}
