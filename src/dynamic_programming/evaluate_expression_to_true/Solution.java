package dynamic_programming.evaluate_expression_to_true;

/**
 * Created by ugurdonmez on 09/09/16.
 */
public class Solution {


    int MOD = 1003;

    public int cnttrue(String A) {
        StringBuilder symbols = new StringBuilder();
        StringBuilder operators = new StringBuilder();
        for(int i=0; i <A.length(); ++i) {
            char cur = A.charAt(i);
            if(cur=='T' || cur=='F') symbols.append(cur);
            else operators.append(cur);
        }
        return cnt(symbols.toString().toCharArray(), operators.toString().toCharArray()) % MOD;
    }

    int cnt(char exp[] , char op[]) {
        int n= exp.length;
        int t[][] = new int[n][n];
        int f[][]= new int[n][n];
        for(int i=0 ; i < n; ++i) {
            if(exp[i]=='T') t[i][i] = 1;
            else f[i][i] =1;
        }
        for(int gap=1; gap <n; ++gap) {
            for(int i=0, j=gap; j < n; ++i, ++j) {

                for(int g=0; g< gap; ++g) {
                    int k = i +g;
                    switch(op[k]) {
                        case '&' :
                            t[i][j] += t[i][k] * t[k+1][j];
                            f[i][j] += t[i][k] * f[k+1][j] + f[i][k] * t[k+1][j] + f[i][k] * f[k+1][j];
                            break;
                        case '|':
                            t[i][j] += t[i][k] * t[k+1][j] + t[i][k] * f[k+1][j] + f[i][k] * t[k+1][j];
                            f[i][j] +=  f[i][k] * f[k+1][j];
                            break;
                        case '^':
                            t[i][j] += t[i][k] * f[k+1][j] + f[i][k] * t[k+1][j];
                            f[i][j] += t[i][k] * t[k+1][j] + f[i][k] * f[k+1][j];
                            break;
                    }

                    t[i][j] %= MOD;
                    f[i][j] %= MOD;
                }
            }
        }

        return t[0][n-1];
    }

    public static void main(String [] args) {

        System.out.println(getNumberOfWay("T|F", 0, 2, true));

        System.out.println(getNumberOfWay("T|F&T^T", 0, 6, true));

    }

    public static int getNumberOfWay(String string, int start, int end, boolean value) {

        if (start == end) {
            if (string.charAt(start) == 'T') {
                if (value) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (value) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }

        int count = 0;

        if (string.charAt(start+1) == '|') {
            count += getNumberOfWay(string, start, start, true) * getNumberOfWay(string, start+2, end, true);
            count += getNumberOfWay(string, start, start, false) * getNumberOfWay(string, start+2, end, true);
            count += getNumberOfWay(string, start, start, true) * getNumberOfWay(string, start+2, end, false);
        } else if (string.charAt(start+1) == '&') {
            count += getNumberOfWay(string, start, start, true) * getNumberOfWay(string, start+2, end, true);
        } else if (string.charAt(start+1) == '^') {
            count += getNumberOfWay(string, start, start, false) * getNumberOfWay(string, start+2, end, true);
            count += getNumberOfWay(string, start, start, true) * getNumberOfWay(string, start+2, end, false);
        }

        return count;
    }

}
