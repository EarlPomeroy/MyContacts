package com.example.epomeroy.mycontacts;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactViewActivity extends AppCompatActivity {
    private static final String TAG = "ContactViewActivity";
    public static final String EXTRA = "CVA_Contact";

    private class FieldsAdapter extends BaseAdapter {
        private ArrayList<String> emails;
        private ArrayList<String> phoneNumbers;

        public FieldsAdapter(ArrayList<String> emails, ArrayList<String> phoneNumbers) {
            emails = emails;
            phoneNumbers = phoneNumbers;
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_view);

        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();

        display.getSize(point);

        int width = point.x;
        int height = point.y;

        RelativeLayout headerSection = (RelativeLayout) findViewById(R.id.contact_view_header);
        headerSection.setLayoutParams(new RelativeLayout.LayoutParams(width, (int) (width * (9.0 / 16.0))));

        Contact contact = (Contact) getIntent().getSerializableExtra(EXTRA);
        TextView contactName = (TextView) findViewById(R.id.contact_view_name);
        contactName.setText(contact.getName());

        Toolbar toolbar = (Toolbar) findViewById(R.id.contact_view_toolbar);
        this.setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getGroupId();
                if (id == R.id.contact_view_edit) {
                    Log.d(TAG, "Clicked edit icon");
                    return true;
                }
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu_contact_view);

        ListView listView = (ListView) findViewById(R.id.contact_view_fields);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
