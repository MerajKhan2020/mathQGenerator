package qGenerator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public Button showAnswerBttn;
    //public Button showAnswerBttn2;
    //public Button showAnswerBttn3;
    public Button resetBttn;

    public int answer;
    public ArrayList list = new ArrayList<>(9);

    public List<Integer> mathQuestionGenerator (){
        for (int i=0;i<=2;i++){
            int a = topNumberGenerator(100,999);
            list.add(a);
            int b = bottomNumberGenerator(10,99);
            list.add(b);
            list.add(a*b);
        }
        return list;
    }

    public int topNumberGenerator (int min, int max){
        System.out.println("Random value in int from "+min+" to "+max+ ":");
        int topNumber = (int)Math.floor(Math.random()*(max-min+1)+min);
        System.out.println(topNumber);
        return topNumber;
    }

    public int bottomNumberGenerator (int min, int max){
        System.out.println("Random value in int from "+min+" to "+max+ ":");
        int bottomNumber = (int)Math.floor(Math.random()*(max-min+1)+min);
        System.out.println(bottomNumber);
        return bottomNumber;
    }

    public void generateQController(ActionEvent event) {

        questionBox1.clear();
        questionBox2.clear();
        questionBox3.clear();
        answerBox1.clear();
        answerBox1.setStyle("-fx-text-fill: black");
        answerBox2.clear();
        answerBox2.setStyle("-fx-text-fill: black");
        answerBox3.clear();
        answerBox3.setStyle("-fx-text-fill: black");
        booleanDisplay1.setText("");
        booleanDisplay2.setText("");
        booleanDisplay3.setText("");
        correctAns1.setText("");
        correctAns1.setText("");
        correctAns2.setText("");
        correctAns3.setText("");
        list.clear();

        System.out.println("generateQButton Button was pressed");
        mathQuestionGenerator();
        for (int j = 0; j < list.size();j++)
        {
            System.out.println(list.get(j));
        }
        System.out.println(list);
        questionBox1.setText(list.get(0) + " X " + list.get(1));
        questionBox2.setText(list.get(3) + " X " + list.get(4));
        questionBox3.setText(list.get(6) + " X " + list.get(7));
    }

    public void showAnswerController (ActionEvent event) {
        System.out.println("Show answer 1 Button was pressed");


        if (questionBox1.getText().isEmpty() && answerBox1.getText().isEmpty() && answerBox3.getText().isEmpty() && answerBox3.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please click on Generate Math question button and " +"\n"+"fill out all the answers before clicking on Show Answer Button", ButtonType.OK);
            alert.showAndWait();
        }else if(answerBox1.getText().isEmpty() && answerBox3.getText().isEmpty() && answerBox3.getText().isEmpty())
        {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please fill out all the answers", ButtonType.OK);
                alert.showAndWait();
        } else {
            correctAns1.setText(list.get(2).toString());
            correctAns2.setText(list.get(5).toString());
            correctAns3.setText(list.get(8).toString());
            int answer1 = Integer.parseInt(answerBox1.getText());
            int answer2 = Integer.parseInt(answerBox2.getText());
            int answer3 = Integer.parseInt(answerBox3.getText());

            if (answer1 == Integer.parseInt(list.get(2).toString())) {
                booleanDisplay1.setStyle("-fx-text-fill: green");
                answerBox1.setStyle("-fx-text-fill: green");
                booleanDisplay1.setText("Correct");
            } else {
                booleanDisplay1.setStyle("-fx-text-fill: red");
                answerBox1.setStyle("-fx-text-fill: red");
                booleanDisplay1.setText("Wrong Answer");
            }

            if (answer2 == Integer.parseInt(list.get(5).toString())) {
                booleanDisplay2.setStyle("-fx-text-fill: green");
                answerBox2.setStyle("-fx-text-fill: green");
                booleanDisplay2.setText("Correct");
            } else {
                booleanDisplay2.setStyle("-fx-text-fill: red");
                answerBox2.setStyle("-fx-text-fill: red");
                booleanDisplay2.setText("Wrong Answer");
            }

            if (answer3 == Integer.parseInt(list.get(8).toString())) {
                //booleanDisplay3.setText("Correct");
                booleanDisplay3.setStyle("-fx-text-fill: green");
                answerBox3.setStyle("-fx-text-fill: green");
                booleanDisplay3.setText("Correct");
            } else {
                //booleanDisplay3.setText("Wrong Answer");
                booleanDisplay3.setStyle("-fx-text-fill: red");
                answerBox3.setStyle("-fx-text-fill: red");
                booleanDisplay3.setText("Wrong Answer");
            }

        }
    }


/*    public void showAnswerController2 (ActionEvent event) {
        System.out.println("Show answer 2 Button was pressed");

    }

    public void showAnswerController3 (ActionEvent event) {
        System.out.println("Show answer 3 Button was pressed");

    }

    public void answerBox1Controller (ActionEvent event) {
        System.out.println("Answer in Box 1 has been enetered");
        //correctAns3.setText(list.get(8).toString());
        int answer1 = Integer.parseInt(answerBox1.getText());
        if (answer1 == Integer.parseInt(list.get(2).toString())) {
            booleanDisplay1.setText("Correct");
        }else {
                booleanDisplay1.setText("Wrong Answer");
            }

        }



    public void answerBox2Controller (ActionEvent event) {
        System.out.println("Answer in Box 2 has been enetered");
        //correctAns3.setText(list.get(8).toString());
    }

    public void answerBox3Controller (ActionEvent event) {
        System.out.println("Answer in Box 3 has been enetered");
        //correctAns3.setText(list.get(8).toString());
    }*/


    public void resetController (ActionEvent event) {
        System.out.println("Reset Button was pressed");
        questionBox1.clear();
        questionBox2.clear();
        questionBox3.clear();
        answerBox1.clear();
        answerBox1.setStyle("-fx-text-fill: black");
        answerBox2.clear();
        answerBox2.setStyle("-fx-text-fill: black");
        answerBox3.clear();
        answerBox3.setStyle("-fx-text-fill: black");
        booleanDisplay1.setText("");
        booleanDisplay2.setText("");
        booleanDisplay3.setText("");
        correctAns1.setText("");
        correctAns1.setText("");
        correctAns2.setText("");
        correctAns3.setText("");
        list.clear();
    }

}
