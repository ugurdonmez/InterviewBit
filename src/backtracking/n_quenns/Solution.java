package backtracking.n_quenns;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ugurdonmez on 18/08/16.
 */
public class Solution {


    public ArrayList<ArrayList<String>> solveNQueens(int a) {

        ArrayList<String[]> sol = solveNQueensHelper(a);

        ArrayList<ArrayList<String>> results = new ArrayList<>();

        for (String [] strings : sol) {

            ArrayList<String> result = new ArrayList<>();

            Arrays.stream(strings).forEach(result::add);

            results.add(result);
        }

        return results;
    }


    public ArrayList<String[]> solveNQueensHelper(int n) {
        ArrayList<String[]> result=new ArrayList<> ();

        if (n<1){
            return result;
        }

        String[] rows=new String[n];


        int row=0;

        solutions(row, n, rows, result);

        return result;
    }

    // DFS soluve question
    private void solutions(int stRow, int n,String[] rows, ArrayList<String[]> result ){
        if (stRow>=n){
            result.add(rows.clone());
            return;
        }

        for(int col=0; col<n; col++){
            if (!isValid(col, stRow,  rows)){
                continue;

            }

            char[] chars=new char[n];
            Arrays.fill(chars, '.');
            chars[col]='Q';


            rows[stRow]=String.copyValueOf(chars);
            solutions(stRow+1, n, rows, result);

        }

    }
    // check if current col has conflit with previous Q
    private boolean isValid(int col,int stRow,  String[] rows){
        // checkColumn
        for (int i=0; i<stRow; i++){
            int qCol=rows[i].indexOf("Q");

            if (qCol==col){
                return false;
            }

            int rowDistance=Math.abs(stRow-i);
            int colDistance=Math.abs(col-qCol);

            if (rowDistance==colDistance){
                return false;
            }

        }

        return true;

    }

}
