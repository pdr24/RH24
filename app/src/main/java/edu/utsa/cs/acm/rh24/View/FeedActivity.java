package edu.utsa.cs.acm.rh24.View;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs.acm.rh24.Controller.FeedController;
import edu.utsa.cs.acm.rh24.R;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_activity);

        FeedController controller = new FeedController(this);
        controller.playFeedingGame();

    }

}
