package BackEnd.Read.Test;

import BackEnd.Read.Question.QuestionReader;
import BackEnd.Read.Question.ReadAnswer;
import BackEnd.Read.Question.ReadMark;

public class ReadAllMarks extends TestReader {
    private final int testID;

    public ReadAllMarks(int testID) {
        this.testID = testID;
    }

    @Override
    public Object read() {
        String allQuestionID =  new ReadQuestions(testID).read().toString();
        if (allQuestionID.equals(FAILED + "")) {
            return new int[0];
        }

        String[] questionList = allQuestionID.split(",");
        int[] marks = new int[questionList.length];
        for (int i = 0; i < questionList.length; i++) {
            if(!questionList[i].equals("")){
            QuestionReader questionReader = new ReadMark(Integer.parseInt(questionList[i]));
            marks[i] = (int) questionReader.read();
            }
        }
        return marks;
    }
}
