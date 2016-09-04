package com.cooksdev.constructionleveladnroid.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cooksdev.constructionleveladnroid.R;
import com.cooksdev.constructionleveladnroid.model.AccelerationDegrees;
import com.cooksdev.constructionleveladnroid.presenter.AccelerometerPresenter;
import com.cooksdev.constructionleveladnroid.ui.widget.ConstructionLevelView;

public class AccelerometerActivity extends AppCompatActivity {

    private AccelerometerPresenter presenter;
    private ConstructionLevelView constructionLevelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        presenter = new AccelerometerPresenter(this);

    }

    private void initComponents() {
        constructionLevelView = (ConstructionLevelView) findViewById(R.id.constructionLevel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.registerAccelerometer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unregisterAccelerometer();
    }

    public void updateDegreesInfo(AccelerationDegrees accelerationDegrees) {
        constructionLevelView.updateView(accelerationDegrees.getxTilt());
    }

}
