package qGenerator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class qGeneratorController {
    public ScrollPane mathBoard;
    public TextField questionBox1;
    public TextField questionBox2;
    public TextField questionBox3;
    public TextArea answerBox1;
    public TextArea answerBox2;
    public TextArea answerBox3;
    public Label booleanDisplay1;
    public Label booleanDisplay2;
    public Label booleanDisplay3;
    public Label correctAns1;
    public Label correctAns2;
    public Label correctAns3;
    public Button generateQButton;
    public Button showAnswerBttn1;
    public Button showAnswerBttn2;
    public Button showAnswerBttn3;
    public Button resetBttn;


    public int topNumber;
    public int bottomNumber;
    public int answer;
    public List list = new ArrayList<>(9);

    public List<Integer> mathQuestionGenerator (){
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

    public void generateQController(ActionEvent event) {
        System.out.println("generateQButton Button was pressed");

    }

    public void showAnswerController1 (ActionEvent event) {
        System.out.println("Show answer 1 Button was pressed");

    }

    public void showAnswerController2 (ActionEvent event) {
        System.out.println("Show answer 2 Button was pressed");

    }

    public void showAnswerController3 (ActionEvent event) {
        System.out.println("Show answer 3 Button was pressed");

    }

    public void resetController (ActionEvent event) {
        System.out.println("Reset Button was pressed");

    }

}
