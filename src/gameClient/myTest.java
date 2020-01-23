package gameClient;

import java.util.ArrayList;
import java.util.List;

public class myTest {

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        arr.add(0,6);

        for(int i = 0; i < arr.size(); i++)
            System.out.println(arr.get(i));
    }

}
