package com.example.chaitanya.complexwidget;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

/**
 * The configuration screen for the {@link ComplexWidget ComplexWidget} AppWidget.
 */
public class ComplexWidgetConfigureActivity extends Activity {


    int widgetId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complex_widget_configure);
        setResult(RESULT_CANCELED);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            widgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        final AppWidgetManager widgetManager = AppWidgetManager.getInstance(this);
        final RemoteViews remoteViews = new RemoteViews(this.getPackageName(), R.layout.complex_widget);

        final EditText editText = (EditText) findViewById(R.id.website);
        Button button = (Button) findViewById(R.id.btn_go);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
                    PendingIntent pendingIntent = PendingIntent.getActivity(ComplexWidgetConfigureActivity.this, 0, intent, 0);
                    remoteViews.setOnClickPendingIntent(R.id.imageButton, pendingIntent);

                    widgetManager.updateAppWidget(widgetId, remoteViews);

                    Intent resultValue = new Intent();
                    resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId);
                    setResult(RESULT_OK, resultValue);
                    finish();
                }
        });
    }
}

