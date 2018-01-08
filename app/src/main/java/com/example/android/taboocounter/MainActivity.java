package com.example.android.taboocounter;

        import android.content.Context;
        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.w3c.dom.Text;

        import java.text.CollationElementIterator;
        import java.text.StringCharacterIterator;


//additional imported classes




public class MainActivity extends AppCompatActivity {

    //set vars so that they will be global and will change every time a method is called
    int scoreone = 1;
    int scoreTeamA= 0;
    int scoreTeamB= 0;
    String counterView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }




    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // εδώ σώζεις τις τιμές των μεταβλητών σου
        savedInstanceState.putInt("scoreTeamA", scoreTeamA);
        savedInstanceState.putInt("scoreTeamB", scoreTeamB);



    }
    protected void onRestoreInstanceState(Bundle saveInstanceState) {

        super.onRestoreInstanceState(saveInstanceState);
        // εδώ επιστρέφεις τις τιμές που έσωσες στις μεταβλητές και αν θες κάνεις κάποιες display
        scoreTeamA = saveInstanceState.getInt("scoreTeamA");
        displayForTeamA (scoreTeamA);
        scoreTeamB = saveInstanceState.getInt("scoreTeamB");
        displayForTeamB (scoreTeamB);



    }


    //adds one points for team B on click of the button-(TEAM A PENALTY)
    public void penaltyA (View view) {
        scoreTeamB = scoreTeamB + scoreone;
        displayForTeamB (scoreTeamB);
    }
    //add one point for team Aon click of the button
    public void addOnePointForTeamA (View view) {
        scoreTeamA = scoreTeamA + scoreone;
        displayForTeamA (scoreTeamA);
    }


    //adds ONE points for team A on click of the button-(TEAM B PENALTY)
    public void penaltyB (View view) {
        scoreTeamA = scoreTeamA + scoreone;
        displayForTeamA (scoreTeamA);
    }
    //add one point for team B on click of the button
    public void addOnePointForTeamB (View view) {
        scoreTeamB = scoreTeamB + scoreone;
        displayForTeamB (scoreTeamB);
    }

    //Reset Scores
    public void reset (View view) {
        scoreTeamB = 0;
        scoreTeamA = 0;
        displayForTeamB (scoreTeamB);
        displayForTeamA (scoreTeamA);

    }
    //    Change and display the number of the score of Team A whenever the method is called
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    //    Change and display the number of the score of Team B whenever the method is called
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    //Set Timer
    public void setCountDownTimer (View view) {
    CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {

        public void onTick(long millisUntilFinished) {
            TextView counterView=(TextView) findViewById(R.id.textView);
            counterView.setText("seconds remaining: " + millisUntilFinished / 1000);
        }

        public void onFinish() {
            TextView counterView=(TextView) findViewById(R.id.textView);
            counterView.setText("done!");
        }
    }.start();

    }



    public void Toast (View view) {
        Context context = getApplicationContext();
        CharSequence text = "Each team has to guess as many words as they can. For every word they find, they get a point. If they use one of the banned words, the opposing team gets a point. !";
        int duration = Toast.LENGTH_LONG;
        Toast.makeText(context, text, duration).show();
    }


}
