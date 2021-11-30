package qGenerator;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class qGeneratorController {
    public ScrollPane mathBoard;
    public TextField questionBox1;
    public TextField questionBox2;
    public TextField questionBox3, timer;
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
    public Button resetBttn;
    public RadioButton radioButtonMultiply, radioButtonDivision, radioButtonAddition, radioButtonDeduction;

    public int answer;
    public ArrayList list = new ArrayList<>(9);

    public List<Integer> multiplyQGenerator(){
        for (int i=0;i<=2;i++){
            int a = topNumberGenerator(100,999);
            list.add(a);
            int b = bottomNumberGenerator(10,99);
            list.add(b);
            list.add(a*b);
        }
        return list;
    }

    public List<Integer> divisionQGenerator(){
        for (int i=0;i<=2;i++){
            int a = topNumberGenerator(100,999);
            list.add(a);
            int b = bottomNumberGenerator(2,9);
            list.add(b);
            list.add(a/b);
        }
        return list;
    }

    public List<Integer> additionQGenerator(){
        for (int i=0;i<=2;i++){
            int a = topNumberGenerator(1000,9999);
            list.add(a);
            int b = bottomNumberGenerator(10,9999);
            list.add(b);
            list.add(a+b);
        }
        return list;
    }

    public List<Integer> deductionQGenerator(){
        for (int i=0;i<=2;i++){
            int a = topNumberGenerator(10,9999);
            list.add(a);
            int b = bottomNumberGenerator(1,9999);
            list.add(b);
            if (b>a){
                list.add(b-a);
            }else {
                list.add(a-b);
            }
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
        if (radioButtonMultiply.isSelected()){
            multiplyQGenerator();
            for (int j = 0; j < list.size();j++)
            {
                System.out.println(list.get(j));
            }
            System.out.println(list);
            questionBox1.setText(list.get(0) + " X " + list.get(1));
            questionBox2.setText(list.get(3) + " X " + list.get(4));
            questionBox3.setText(list.get(6) + " X " + list.get(7));

        } else if(radioButtonDeduction.isSelected()){
            deductionQGenerator();
            for (int j = 0; j < list.size();j++)
            {
                System.out.println(list.get(j));
            }
            int x = Integer.parseInt((list.get(0).toString()));
            int y = Integer.parseInt((list.get(1).toString()));
            int z = Integer.parseInt((list.get(3).toString()));
            int a = Integer.parseInt((list.get(4).toString()));
            int b = Integer.parseInt((list.get(6).toString()));
            int c = Integer.parseInt((list.get(7).toString()));

            System.out.println(list);
            if (x>y){
                questionBox1.setText(list.get(0) + " - " + list.get(1));
            }else{
                questionBox1.setText(list.get(1) + " - " + list.get(0));
            }

            if (z>a){
                questionBox2.setText(list.get(3) + " - " + list.get(4));
            }else{
                questionBox2.setText(list.get(4) + " - " + list.get(3));
            }

            if (b>c){
                questionBox3.setText(list.get(6) + " - " + list.get(7));
            }else{
                questionBox3.setText(list.get(7) + " - " + list.get(6));
            }


        } else if(radioButtonAddition.isSelected()){
            additionQGenerator();
            for (int j = 0; j < list.size();j++)
            {
                System.out.println(list.get(j));
            }
            System.out.println(list);
            questionBox1.setText(list.get(0) + " + " + list.get(1));
            questionBox2.setText(list.get(3) + " + " + list.get(4));
            questionBox3.setText(list.get(6) + " + " + list.get(7));

        } else if(radioButtonDivision.isSelected()){
            divisionQGenerator();
            for (int j = 0; j < list.size();j++)
            {
                System.out.println(list.get(j));
            }
            System.out.println(list);
            questionBox1.setText(list.get(0) + " ÷ " + list.get(1));
            questionBox2.setText(list.get(3) + " ÷ " + list.get(4));
            questionBox3.setText(list.get(6) + " ÷ " + list.get(7));

        }

    }



    public void showAnswerController (ActionEvent event) {
        System.out.println("Show answer 1 Button was pressed");


        if (questionBox1.getText().isEmpty() || answerBox1.getText().isEmpty() || answerBox3.getText().isEmpty() || answerBox3.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please click on Generate Math question button and " +"\n"+"fill out all the answers before clicking on Show Answer Button", ButtonType.OK);
            alert.showAndWait();
        }else if(answerBox1.getText().isEmpty() || answerBox3.getText().isEmpty() || answerBox3.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please fill out all the answers", ButtonType.OK);
            alert.showAndWait();
        }else if(isInteger(answerBox1.getText())==false || isInteger(answerBox2.getText())==false  || isInteger(answerBox3.getText())==false )
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please enter numbers only", ButtonType.OK);
            alert.showAndWait();

        } else {
            correctAns1.setText("Correct Answer: " + list.get(2).toString());
            correctAns2.setText("Correct Answer: " + list.get(5).toString());
            correctAns3.setText("Correct Answer: " + list.get(8).toString());
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
                booleanDisplay3.setStyle("-fx-text-fill: green");
                answerBox3.setStyle("-fx-text-fill: green");
                booleanDisplay3.setText("Correct");
            } else {
                booleanDisplay3.setStyle("-fx-text-fill: red");
                answerBox3.setStyle("-fx-text-fill: red");
                booleanDisplay3.setText("Wrong Answer");
            }
            answerBox1.setEditable(false);
            answerBox2.setEditable(false);
            answerBox3.setEditable(false);

        }
        System.out.println(questionBox1.getText());
        System.out.println(answerBox1.getText());
        System.out.println(correctAns1.getText());
        System.out.println(booleanDisplay1.getText());
        System.out.println(questionBox2.getText());
        System.out.println(answerBox2.getText());
        System.out.println(correctAns2.getText());
        System.out.println(booleanDisplay2.getText());
        System.out.println(questionBox3.getText());
        System.out.println(answerBox3.getText());
        System.out.println(correctAns3.getText());
        System.out.println(booleanDisplay3.getText());



    }


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
        answerBox1.setEditable(true);
        answerBox2.setEditable(true);
        answerBox3.setEditable(true);
    }


    public boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception e ) {
            return false;
        }
    }

    public void radioButtonDeductionController (ActionEvent event) {
        System.out.println("Deduction");
    }

    public void radioButtonAdditionController (ActionEvent event) {
        System.out.println("Addtion");
    }

    public void radioButtonMultiplyController (ActionEvent event) {
        System.out.println("Multiply");
    }

    public void radioButtonDivisionController (ActionEvent event) {
        System.out.println("Division");
    }


    public void timerController(ActionEvent event) {
        System.out.println("Timer has started");
    }

}
