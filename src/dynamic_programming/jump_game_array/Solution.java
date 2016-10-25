package dynamic_programming.jump_game_array;

import java.util.ArrayList;

/**
 * Created by ugurdonmez on 06/09/16.
 */
public class Solution {


    public int canJump1(ArrayList<Integer> list) {
        if(list.size() <= 1)
            return 1;

        int max = list.get(0); //max stands for the largest index that can be reached.

        for(int i=0; i<list.size(); i++){
            //if not enough to go to next
            if(max <= i && list.get(i) == 0)
                return 0;

            //update max
            if(i + list.get(i) > max){
                max = i + list.get(i);
            }

            //max is enough to reach the end
            if(max >= list.size()-1)
                return 1;
        }

        return 0;
    }

    public int canJump(ArrayList<Integer> list) {

        int [] memory = new int[list.size()];

        return helper(list, 0, memory);

    }

    private int helper(ArrayList<Integer> list, int index, int[] memory) {

        if (index >= list.size()-1) {
            return 1;
        }

        if (memory[index] == 1) {
            return 1;
        }

        if (memory[index] == 2) {
            return 0;
        }

        int jump = list.get(index);

        if (jump == 0) {
            memory[index] = 2;
            return 0;
        }

        for (int i = 1; i <= jump; i++) {
            int result = helper(list, index+i, memory);
            if (result == 1) {
                memory[index] = 1;
                return 1;
            }
        }

        memory[index] = 2;
        return 0;
    }

}
