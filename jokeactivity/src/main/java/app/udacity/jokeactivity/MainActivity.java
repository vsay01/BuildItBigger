package app.udacity.jokeactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lib);
        Toolbar toolbar = findViewById(R.id.toolbar);
        AppCompatTextView tvJokeDetail = findViewById(R.id.tv_joke_detail);

        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tvJokeDetail.setText(bundle.getString("JOKE_EXTRA"));
        }
    }
}