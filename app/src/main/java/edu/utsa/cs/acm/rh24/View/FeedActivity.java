package edu.utsa.cs.acm.rh24.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs.acm.rh24.Controller.FeedController;
import edu.utsa.cs.acm.rh24.R;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_activity);

        ImageView plant1 = this.findViewById(R.id.plant1);
        ImageView plant2 = this.findViewById(R.id.plant2);
        ImageView plant3 = this.findViewById(R.id.plant3);

        plant1.setVisibility(View.INVISIBLE);
        plant2.setVisibility(View.INVISIBLE);
        plant3.setVisibility(View.INVISIBLE);

        plant1.setClickable(false);
        plant2.setClickable(false);
        plant3.setClickable(false);

        FeedController controller = new FeedController(this);
        controller.playFeedingGame();

    }

}
