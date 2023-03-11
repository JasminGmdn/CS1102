import java.awt.*;
import javax.swing.*;

public abstract class Question {
	
	QuestionDialog question;
	String correctAnswer;
	
	static int nQuestions = 0;
	static int nCorrect = 0;

	String ask() {
		question.setVisible(true);
		return question.answer;
	}
	
	Question(String question) {
		this.question = new QuestionDialog();
		this.question.setLayout(new GridLayout(0,1));
		this.question.add(new JLabel(" "+question+" ",JLabel.CENTER));
		
	}
	
	void initQuestionDialog() {
		this.question.setModal(true);
		this.question.pack();
		this.question.setLocationRelativeTo(null);
	}
	
	void check() {
		
		String answer = ask();
		nQuestions += 1;
		   
		    if (answer.equals(correctAnswer)) {
		    	 JOptionPane.showMessageDialog(null,"Correct!");
		    	 nCorrect +=1;
		    	 return;
		    	 } else {
		    		JOptionPane.showMessageDialog( null,"Incorrect. The correct answer is " + correctAnswer);
		    	} 
	}
	

	
    void showResults() {
    	JOptionPane.showMessageDialog(null, "Correct " + nCorrect + " answers out of " + nQuestions + " questions.");
    }
}
