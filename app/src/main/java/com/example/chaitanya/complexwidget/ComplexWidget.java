package com.example.chaitanya.complexwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link ComplexWidgetConfigureActivity ComplexWidgetConfigureActivity}
 */
public class ComplexWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int i = 0; i < appWidgetIds.length; i++){
            int appWidgetId = appWidgetIds[i];
            Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.complex_widget);
            remoteViews.setOnClickPendingIntent(R.id.imageButton, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetId, remoteViews);
        }
    }

}

