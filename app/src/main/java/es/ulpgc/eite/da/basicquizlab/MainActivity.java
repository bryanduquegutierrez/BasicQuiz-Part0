package es.ulpgc.eite.da.basicquizlab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
 //Bryan Duque Gutierrez
public class MainActivity extends AppCompatActivity {


  private Button falseButton, trueButton,cheatButton, nextButton;
  private TextView questionText, replyText;

  private String[] questionArray;
  private int questionIndex=0;
  private int[] replyArray;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initLayoutData();
    linkLayoutComponents();
    initLayoutContent();

  }

  private void initLayoutData() {
    questionArray=getResources().getStringArray(R.array.question_array);
    replyArray=getResources().getIntArray(R.array.reply_array);
  }


  private void linkLayoutComponents() {
    // enlazar btn de  false desde el layout hasta el code
    falseButton = findViewById(R.id.falseButton);
    trueButton = findViewById(R.id.trueButton);
    nextButton = findViewById(R.id.nextButton);
    //cheatButton = findViewById(R.id.cheatButton);

    questionText = findViewById(R.id.questionText);
    replyText = findViewById(R.id.replyText);
  }



  private void initLayoutContent() {
    // actualizar la label del btn con  su texto
    //nada mas crear los botones desactivamos el boton next para no poder pasar a
    //la siguiente pregunta sin antes contestarla
    nextButton.setEnabled(false);
    falseButton.setText(R.string.false_button_text);
    trueButton.setText(R.string.true_button_text);
    nextButton.setText(R.string.next_button_text);
    //cheatButton.setText(R.string.cheat_button_text);

    //TODO: refactorizar en un método este codigo repetido
    //questionText.setText(R.string.question_1);
    //questionText.setText(questionArray[0]);
    questionText.setText(questionArray[questionIndex]);

    replyText.setText(R.string.empty_text);

  }


  //TODO: impedir que podamos hacer click en el boton
  // si ya hemos contestado a la pregunta
  public void onTrueButtonClick(View view) {
    if(replyArray[questionIndex] == 1) {
      // correct
      replyText.setText(R.string.correct_text);
      trueButton.setEnabled(false);
      falseButton.setEnabled(false);
      nextButton.setEnabled(true);
    } else {
      // incorrect
      replyText.setText(R.string.incorrect_text);
      trueButton.setEnabled(false);
      falseButton.setEnabled(false);
      nextButton.setEnabled(true);
    }
  }

  //TODO: impedir que podamos hacer click en el boton
  // si ya hemos contestado a la pregunta
  public void onFalseButtonClick(View view) {
    nextButton.setEnabled(false);
    if(replyArray[questionIndex] == 0) {
      // correct
      replyText.setText(R.string.correct_text);
      falseButton.setEnabled(false);
      trueButton.setEnabled(false);
      nextButton.setEnabled(true);
    } else {
      // incorrect
      replyText.setText(R.string.incorrect_text);
      falseButton.setEnabled(false);
      trueButton.setEnabled(false);
      nextButton.setEnabled(true);
    }
  }

  public void comprobarBotones(){
    if(!falseButton.isPressed() || !trueButton.isPressed()){
      nextButton.setEnabled(false);
    }else{
      nextButton.setEnabled(true);
    }
  }





  //TODO: impedir que podamos hacer click en el boton
  // si aun no hemos contestado a la pregunta
  public void onNextButtonClick(View view) {
    questionIndex++;

    // hacemos que si llegamos al final del quiz
    // volvamos a empezarlo nuevamente

    if(questionIndex == questionArray.length) {
      questionIndex=0;
    }

    //TODO: refactorizar en un método este codigo repetido
    questionText.setText(questionArray[questionIndex]);
    falseButton.setEnabled(true);
    trueButton.setEnabled(true);// actualizar pregunta
    replyText.setText(R.string.empty_text); // resetear resultado anterior
    nextButton.setEnabled(false);
  }


  //TODO: implementar boton para pasar a siguiente pantalla
  public void onCheatButtonClick(View view) {
    // no implementado
  }
}
