package com.example.android.tennisscoresapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int score1 = 0;
    private int score2 = 0;
    private int games1 = 0;
    private int games2 = 0;
    private int sets1 = 0;
    private int sets2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void player1Scores(View view) {
        score1++;
        TextView message = (TextView) findViewById(R.id.message);
        message.setText(messageCreator1());

            if ((score1 - score2) >= 2 && score1 >= 4) {
                games1++;
                if (games1 >= 6 && (games1 - games2) >= 2) {
                    sets1++;
                    if (sets1 == 2) {
                        message.setText("Player 1 won the match!");

                        Button reset = (Button) findViewById(R.id.resetButton);
                        reset.setText("Click This Button to Restart the Match!");
                        Button point1 = (Button) findViewById(R.id.pointButton1);
                        point1.setClickable(false);
                        Button point2 = (Button) findViewById(R.id.pointButton2);
                        point2.setClickable(false);
                        Button ace1 = (Button) findViewById(R.id.aceButton1);
                        ace1.setClickable(false);
                        Button ace2 = (Button) findViewById(R.id.aceButton2);
                        ace2.setClickable(false);
                        Button fault1 = (Button) findViewById(R.id.faultButton1);
                        fault1.setClickable(false);
                        Button fault2 = (Button) findViewById(R.id.faultButton2);
                        fault2.setClickable(false);

                    } else {
                        message.setText("Player 1 won the set " + (sets1 + sets2) + "!");
                    }
                    setSets1View();
                    games1 = 0;
                    games2 = 0;
                }
                setGames1View();
                setGames2View();
                score1 = 0;
                score2 = 0;
            }

            setScore1View(score1Converter());

    }

    public void player2Scores(View view) {
        score2++;
        TextView message = (TextView) findViewById(R.id.message);
        message.setText(messageCreator2());


            if ((score2 - score1) >= 2 && score2 >= 4) {
                games2++;
                if (games2 >= 6 && (games2 - games1) >= 2) {
                    sets2++;
                    if (sets2 == 2) {
                        message.setText("Player 2 won the match!");

                        Button reset = (Button) findViewById(R.id.resetButton);
                        reset.setText("Click This Button to Restart the Match!");
                        Button point1 = (Button) findViewById(R.id.pointButton1);
                        point1.setClickable(false);
                        Button point2 = (Button) findViewById(R.id.pointButton2);
                        point2.setClickable(false);
                        Button ace1 = (Button) findViewById(R.id.aceButton1);
                        ace1.setClickable(false);
                        Button ace2 = (Button) findViewById(R.id.aceButton2);
                        ace2.setClickable(false);
                        Button fault1 = (Button) findViewById(R.id.faultButton1);
                        fault1.setClickable(false);
                        Button fault2 = (Button) findViewById(R.id.faultButton2);
                        fault2.setClickable(false);

                    } else {
                        message.setText("Player 2 won the set " + (sets1 + sets2) + "!");
                    }
                    setSets2View();
                    games1 = 0;
                    games2 = 0;
                }
                setGames1View();
                setGames2View();
                score1 = 0;
                score2 = 0;
            }


            setScore2View(score2Converter());

    }

    private String messageCreator1() {

            if ((score1 - score2) >= 2 && score1 >= 4) {
                return "Player 1 won the game " + (games1 + games2 + 1) + " in set " + (sets1 + sets2 + 1) + "!";
            } else if ((score1 - score2) == 1 && score1 >= 4 && score2 >= 3) {
                if (games1 >= 5 && (games1 - games2) >= 1) {
                    if (sets1 == 1) {
                        return "Match point for Player 1!";
                    } else {
                        return "Set point for Player 1!";
                    }
                } else {
                    return "Game point for Player 1!";
                }
            } else if ((score1 - score2) == 1 && score1 == 3 && score2 <= 2) {
                if (games1 >= 5 && (games1 - games2) >= 1) {
                    if (sets1 == 1) {
                        return "Match point for Player 1!";
                    } else {
                        return "Set point for Player 1!";
                    }
                } else {
                    return "Game point for Player 1!";
                }
            } else if (score1 == 3 && score2 <= 2) {
                if (games1 >= 5 && (games1 - games2) >= 1) {
                    if (sets1 == 1) {
                        return "Match point for Player 1!";
                    } else {
                        return "Set point for Player 1!";
                    }
                } else {
                    return "Game point for Player 1!";
                }
            } else if (score1 >= 3 && score2 >= 3 && score1 == score2) {
                return "Deuce!";
            }



        return "Point for Player 1";
    }
    private String messageCreator2() {

            if ((score2 - score1) >= 2 && score2 >= 4) {
                return "Player 2 won the game " + (games1 + games2 + 1) + " in set " + (sets1 + sets2 + 1) + "!";
            } else if ((score2 - score1) == 1 && score2 >= 4 && score1 >= 3) {
                if (games2 >= 5 && (games2 - games1) >= 1) {
                    if (sets2 == 1) {
                        return "Match point for Player 2!";
                    } else {
                        return "Set point for Player 2!";
                    }
                } else {
                    return "Game point for Player 2!";
                }
            } else if ((score2 - score1) == 1 && score2 == 3 && score1 <= 2) {
                if (games2 >= 5 && (games2 - games1) >= 1) {
                    if (sets2 == 1) {
                        return "Match point for Player 2!";
                    } else {
                        return "Set point for Player 2!";
                    }
                } else {
                    return "Game point for Player 2!";
                }
            } else if (score2 == 3 && score1 <= 2) {
                if (games2 >= 5 && (games2 - games1) >= 1) {
                    if (sets2 == 1) {
                        return "Match point for Player 2!";
                    } else {
                        return "Set point for Player 2!";
                    }
                } else {
                    return "Game point for Player 2!";
                }
            } else if (score2 >= 3 && score1 >= 3 && score2 == score1) {
                return "Deuce!";
            }

        return "Point for Player 2";
    }



    private String score1Converter(){
        if(score1 == 1){
            return "15";
        }else if(score1 == 2){
            return "30";
        }else if(score1 == 3){
            return "40";
        }else if(score2 >= 3 && score1 >= 3 && score2 == score1){
            setScore2View("40");
            return "40";
        }else if(score1 >= 4 && score2 >=3 && (score1-score2) == 1){
            return "Ad";
        }else{
            setScore2View("00");
            return "00";
        }
    }

    private String score2Converter(){
        if(score2 == 1){
            return "15";
        }else if(score2 == 2){
            return "30";
        }else if(score2 == 3){
            return "40";
        }else if(score2 >= 3 && score1 >= 3 && score2 == score1){
            setScore1View("40");
            return "40";
        }else if(score2 >= 4 && score1 >=3 && (score2-score1) == 1){
            return "Ad";
        }else{
            setScore1View("00");
            return "00";
        }
    }

    private void setScore1View(String score){
        TextView score1View = (TextView) findViewById(R.id.score1);
        score1View.setText(score);
    }

    private void setScore2View(String score){
        TextView score1View = (TextView) findViewById(R.id.score2);
        score1View.setText(score);
    }

    private void setGames1View(){
        TextView games1View = (TextView) findViewById(R.id.games1);
        games1View.setText("" + games1);
    }

    private void setGames2View(){
        TextView games2View = (TextView) findViewById(R.id.games2);
        games2View.setText("" + games2);
    }

    private void setSets1View(){
        TextView sets1View = (TextView) findViewById(R.id.sets1);
        sets1View.setText("" + sets1);
    }

    private void setSets2View(){
        TextView sets2View = (TextView) findViewById(R.id.sets2);
        sets2View.setText("" + sets2);
    }

    public void reset(View view){
        score1 = 0;
        score2 = 0;
        games1 = 0;
        games2 = 0;
        sets1 = 0;
        sets2 = 0;
        setScore1View("00");
        setScore2View("00");
        setGames1View();
        setGames2View();
        setSets1View();
        setSets2View();
        TextView message = (TextView) findViewById(R.id.message);
        message.setText("Welcome to Wimbledon!");

        Button reset = (Button) findViewById(R.id.resetButton);
        reset.setText("Reset");
        Button point1 = (Button) findViewById(R.id.pointButton1);
        point1.setClickable(true);
        Button point2 = (Button) findViewById(R.id.pointButton2);
        point2.setClickable(true);
        Button ace1 = (Button) findViewById(R.id.aceButton1);
        ace1.setClickable(true);
        Button ace2 = (Button) findViewById(R.id.aceButton2);
        ace2.setClickable(true);
        Button fault1 = (Button) findViewById(R.id.faultButton1);
        fault1.setClickable(true);
        Button fault2 = (Button) findViewById(R.id.faultButton2);
        fault2.setClickable(true);
    }
}
