package cgu.edu.ist380.solimana.utorial1.quiz;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int currentQuestion;
	private int AnswerCounter;
	private String [] questions; 
	private String [] answers;   
	private Button answerButton; 
	private Button questionButton; 
	private TextView questionView;
	private EditText scoreText;
	private TextView answerView; 
	private EditText answerText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	
	public void init()     {      
		questions = new String[]{" 1- What is the capital of Egypt?", " 2- What class are you in right now?"};
		answers = new String[]{"Cairo","IST380"};
		currentQuestion = -1;
		AnswerCounter = 0;
		
		answerButton = (Button)findViewById(R.id.AnswerButton);
		questionButton = (Button)findViewById(R.id.QuestionButton);
		questionView = (TextView) findViewById(R.id.QuestionTextView);
		answerView = (TextView) findViewById(R.id.AnswerTextView);
		scoreText = (EditText) findViewById(R.id.ScoreText);		
		answerText = (EditText) findViewById(R.id.AnswerText);
		// Assigning value to the score
		AnswerCounter = 0;
		//Display the score
		scoreText.setText(Integer.toString(AnswerCounter));
		
		answerButton.setOnClickListener(new OnClickListener()
		{    @Override    
			public void onClick(View v) {     
			checkAnswer();    }});
		questionButton.setOnClickListener(new OnClickListener(){
			
		@Override
		public void onClick(View v) { 
			showQuestion();      }});
		}        
/*      * This method 
  * 1: increment currentQuestion index       
  * * 2: check if it is equal to the size of the array and rest if necessary       
  * * 3: display the question at currentQuestion index in question view      
  * * 4: Empty answer view      
  * */

public void showQuestion()     {
	currentQuestion++;
	if(currentQuestion == questions.length)       currentQuestion =0; 
	questionView.setText(questions[currentQuestion]); 
	answerView.setText("");      
	answerText.setText("");  
	}     
/*      * This method return true if the answer equals to correct answer      
 * *  (Ignoring case)      
 * */     
public boolean isCorrect(String answer)     {     
	return (answer.equalsIgnoreCase(answers[currentQuestion])); 
	}    
/* this method :     
 *  * 1: Read the text ( answer) from the answerTextEdit     
 *   * 2: call the isCorrect method     
 *    * 3: display the appropriate message.      
 *     */   
public void checkAnswer()     {    
	String answer = answerText.getText().toString();  
	if(isCorrect(answer))       {
		answerView.setText("You're right!");
		//increasing the score value
		AnswerCounter++;
		
	}
	else       {
		answerView.setText("Sorry, the correct answer is "+answers[currentQuestion]);
		//decreasing the score counter
		AnswerCounter--;
		//checking if score less than 0
		//if yes then assign Zero, so we will not get a negative result
		if (AnswerCounter <0) 
			AnswerCounter = 0;
		}
	scoreText.setText(Integer.toString(AnswerCounter));
	} 
		

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
