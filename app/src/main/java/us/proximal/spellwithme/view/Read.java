package us.proximal.spellwithme.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

import us.proximal.spellwithme.R;
import us.proximal.spellwithme.controller.def.IQuestionsService;
import us.proximal.spellwithme.controller.test.TQuestionsService;
import us.proximal.spellwithme.model.dto.AnswerDTO;
import us.proximal.spellwithme.model.dto.QuestionDTO;
import us.proximal.spellwithme.model.dto.WordDTO;

public class Read extends BaseActivity {

    //Declare objects for UI components
    private Button btnReadYes;
    private Button btnReadNo;
    private TextView txtWord;
    private WordDTO word;
    private QuestionDTO question;

    //Declare service
    private IQuestionsService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        //Instantiate service
        //service = new QuestionsService();
        service = new TQuestionsService();

        //instantiate the ui components in the onCreate method
        btnReadYes = (Button) findViewById(R.id.buttonReadYes);
        btnReadNo = (Button) findViewById(R.id.buttonReadNo);
        txtWord = (TextView) findViewById(R.id.textReadWord);

        //get a question
        try {
            question = service.ask(0,0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //display question
        txtWord.setText(question.getWord());


        //attach onClick listener to the button object
        btnReadYes.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View currentView) {

                                              AnswerDTO answer = new AnswerDTO();
                                              answer.setStudentId(0);
                                              answer.setMkoId(0);
                                              answer.setDate(new Date());
                                              answer.setQuestionId(0);
                                              answer.setGrade('1');
                                              try {
                                                  service.answer(0,0,answer);
                                              } catch (Exception e) {
                                                  e.printStackTrace();
                                              }

                                              //get a question
                                              try {
                                                  question = service.ask(0,0);
                                              } catch (Exception e) {
                                                  e.printStackTrace();
                                              }

                                          }
                                      }
        );

        //attach onClick listener to the button object
        btnReadNo.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View currentView) {


                                              AnswerDTO answer = new AnswerDTO();
                                              answer.setStudentId(0);
                                              answer.setMkoId(0);
                                              answer.setDate(new Date());
                                              answer.setQuestionId(0);
                                              answer.setGrade('0');
                                              try {
                                                  service.answer(0,0,answer);
                                              } catch (Exception e) {
                                                  e.printStackTrace();
                                              }

                                              //get a question
                                              try {
                                                  question = service.ask(0,0);
                                              } catch (Exception e) {
                                                  e.printStackTrace();
                                              }

                                          }
                                      }
        );


    }


    public WordDTO getWord() {
        return word;
    }

    public void setWord(WordDTO word) {
        this.word = word;
    }

    public TextView getTxtWord() {
        return txtWord;
    }

    public void setTxtWord(TextView txtWord) {
        this.txtWord = txtWord;
    }


}
