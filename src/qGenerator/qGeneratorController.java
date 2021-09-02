package qGenerator;

import java.util.ArrayList;
import java.util.List;

public class qGeneratorController {

    public int topNumber;
    public int bottomNumber;
    public int answer;
    public List list = new ArrayList<>(9);

    public List<Integer> mathQuestionGenerator (){
        //List<Integer> list = new ArrayList<>(9);
        /*number1 = (int) (Math.random()*100);
        number2 = (int) (Math.random()*10);*/

        int i=0;
        while (i<list.size()) {
            topNumber = (int) (Math.random() * 100);
            bottomNumber = (int) (Math.random() * 10);
            list.add(topNumber);
            list.add(bottomNumber);
            list.add(topNumber * bottomNumber);
        }
        return list;
    }



}
