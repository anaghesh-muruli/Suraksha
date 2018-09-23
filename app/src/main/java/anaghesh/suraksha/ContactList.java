package anaghesh.suraksha;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;


public class ContactList extends AppCompatActivity
{
    Button add;

    List<anaghesh.suraksha.Datas> st = new ArrayList<>();
    MyAdapter ca;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.success(ContactList.this, "3 constacts selected", Toast.LENGTH_SHORT, true).show();
                startActivity(new Intent(ContactList.this,Home.class));
            }
        });
        getAllContacts();
        RecyclerView rv = findViewById(R.id.cont);
        ca = new MyAdapter(st, getApplicationContext());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(ca);

        EditText ed = findViewById(R.id.ln);
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                    filter(s.toString());

            }
        });

    }

    public void filter(String text)
    {
        ArrayList<anaghesh.suraksha.Datas> filteredlist = new ArrayList<>();
        for( anaghesh.suraksha.Datas item : st )
        {
            if (item.getDt().toLowerCase().contains(text.toLowerCase()))
            {
                filteredlist.add(item);
            }
        }
        ca.filteredList(filteredlist);
    }
    private void getAllContacts() {
        anaghesh.suraksha.Datas data;
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null,
                "UPPER(" + ContactsContract.Contacts.DISPLAY_NAME + ") ASC");
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                data = new anaghesh.suraksha.Datas();
                data.setDt(name);
                int hasphnum = Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (hasphnum > 0) {
                    Cursor cursor1 = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " =?",
                            new String[]{id}, null);

                    while (cursor1.moveToNext()) {
                        String PhoneNu = cursor1.getString(cursor1.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        data.setPhno(PhoneNu);
                        st.add(data);
                    }
                    cursor1.close();

                }
            }
        }
        cursor.close();
    }




}

