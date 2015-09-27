package com.example.epomeroy.mycontacts;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class ContactEditActivity extends AppCompatActivity {
    public static final String EXTRA = "CEA_Contact";
    private static final String TAG = "ContactEditActivity";

    private Contact contact;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_edit);

        position = getIntent().getIntExtra(EXTRA, 0);
        contact = ContactList.getInstance().get(position);

        Toolbar toolbar = (Toolbar) findViewById(R.id.contact_edit_toolbar);
        toolbar.setTitle(getResources().getString(R.string.edit_contact));
        toolbar.setNavigationIcon(R.drawable.ic_done);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editName = (EditText) findViewById(R.id.contact_edit_name);
                contact.setName(editName.getText().toString());

                contact.setPhoneNumbers(getSectionValues(R.id.phonenumber_section));
                contact.setEmails(getSectionValues(R.id.email_section));

                ContactList.getInstance().set(position, contact);

                Toast.makeText(ContactEditActivity.this, "Saved Contact", Toast.LENGTH_LONG).show();

                finish();
            }
        });

        EditText editName = (EditText) findViewById(R.id.contact_edit_name);
        editName.setText(contact.getName());

        addToSection(R.id.phonenumber_section, contact.getPhoneNumbers());
        addToSection(R.id.email_section, contact.getEmails());

        TextView addNewPhoneNumber = (TextView) findViewById(R.id.add_new_phonenumber);
        addNewPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSection(R.id.phonenumber_section, "");
            }
        });

        TextView addNewEmail = (TextView) findViewById(R.id.add_new_email);
        addNewEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToSection(R.id.email_section, "");
            }
        });

    }

    private ArrayList<String> getSectionValues(int sectionId) {
        ArrayList<String> values = new ArrayList<>();
        LinearLayout section = (LinearLayout) findViewById(sectionId);

        for (int i = 0; i < section.getChildCount(); i++) {
            EditText editText = (EditText) section.getChildAt(i);
            values.add(editText.getText().toString());
        }

        return values;
    }

    private void addToSection(int sectionId, String value) {
        LinearLayout section = (LinearLayout) findViewById(sectionId);

        EditText et = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        et.setLayoutParams(lp);
        et.setText(value);
        section.addView(et);
    }

    private void addToSection(int sectionId, ArrayList<String> values) {
        LinearLayout section = (LinearLayout) findViewById(sectionId);

        for (String value : values) {
            EditText et = new EditText(this);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            et.setLayoutParams(lp);
            et.setText(value);
            section.addView(et);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_edit, menu);
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
