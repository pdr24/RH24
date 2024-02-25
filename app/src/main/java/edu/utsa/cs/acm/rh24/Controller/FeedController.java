package edu.utsa.cs.acm.rh24.Controller;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import edu.utsa.cs.acm.rh24.Model.Pet;
import edu.utsa.cs.acm.rh24.R;
import edu.utsa.cs.acm.rh24.View.FeedActivity;

public class FeedController {
    public FeedActivity activity;
    public Pet dinosaur;

    public FeedController(FeedActivity feedActivity) {
        this.activity = feedActivity;
        this.dinosaur = new Pet();
    }

    public void playFeedingGame() {

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // Update the variable here

                dinosaur.setHealth(dinosaur.getHealth() - 1);
                TextView hungerTextView = activity.findViewById(R.id.health);

                // Update UI in the UI thread
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Update TextView with the updated variable value
                        hungerTextView.setText("Hunger: " + dinosaur.getHealth());
                        if (dinosaur.getHealth() <= 0) {
                            extinction();
                            timer.cancel();

                        }

                    }
                });




            }

        };



            // Schedule the TimerTask to run every 2 seconds (2000 milliseconds)
            timer.schedule(timerTask, 0, 2000);


    }

    public void extinction() {
        ImageView dinosaurImage = activity.findViewById(R.id.dinosaurView);
        dinosaurImage.setImageResource(R.drawable.skeleton);
    }

}


