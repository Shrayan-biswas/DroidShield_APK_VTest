package com.droidshield.providercheck;

import android.app.Activity;
import android.os.Bundle;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.widget.TextView;

public class ProviderCheck extends Activity {
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);

        TextView output = new TextView(this);
        setContentView(output);

        Uri uri = Uri.parse(
            "content://jakhar.aseem.diva.provider.notesprovider/notes"
        );

        try {
    Uri notesUri = Uri.parse(
        "content://jakhar.aseem.diva.provider.notesprovider/notes"
    );

    ContentValues values = new ContentValues();
    values.put("title", "DroidShield_UPDATE_TEST");
    values.put("note", "Original test value");

    Uri inserted = getContentResolver().insert(notesUri, values);

    if (inserted == null) {
        output.setText("Insert returned null; update not attempted");
        return;
    }

    ContentValues changed = new ContentValues();
    changed.put("note", "Updated test value");

    int updated = getContentResolver().update(
        inserted, changed, null, null
    );
	int deleted = getContentResolver().delete(
    inserted, null, null
	);

    output.setText(
    "Test note: " + inserted +
    "\nRows updated: " + updated +
    "\nRows deleted: " + deleted +
    "\nXud gaya"
);
} catch (Exception e) {
    output.setText(
        e.getClass().getSimpleName() + ": " + e.getMessage()
    );
}
   }
}
