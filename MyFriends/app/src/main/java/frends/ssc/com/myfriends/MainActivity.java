package frends.ssc.com.myfriends;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class MainActivity extends ActionBarActivity {
   private  List<FContacts> fContactsList, gfContactsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fContactsList=new ArrayList<>();
        gfContactsList=new ArrayList<>();
        HashMap<String, String> gContacts=new HashMap<>();
        gContacts.put("V Shilpa","");
        gContacts.put("Y Swethamani","");
        gContacts.put("Y Sulochana","");
        gContacts.put("D Saritha","");
        gContacts.put("Y Hemalatha","");
        gContacts.put("M Nagaveni","");
        gContacts.put("L Lakshmi","");
        gContacts.put("M Nagamani","");
        gContacts.put("G Prabhavathi","");
        gContacts.put("C Sujatha","");
        gContacts.put("R N Varalaxmi","");
        gContacts.put("H Varalaxmi","");
        gContacts.put("K Bhargavi","");
        gContacts.put("K Laxmidevi","");
        gContacts.put("M Nagalaxmi","");
        gContacts.put("Late E B Ramadevi","");

        Set gKeys = gContacts.keySet();

        for (Iterator i = gKeys.iterator(); i.hasNext();)
        {
            String key = (String) i.next();
            String value = (String) gContacts.get(key);
            FContacts gfContacts=new FContacts();
            gfContacts.setName(key);
            gfContacts.setPhoneNumber(value);
            gfContactsList.add(gfContacts);
        }
        HashMap<String, String> contacts=new HashMap<>();
        contacts.put("V Kanchi Reddy","9963492925");
        contacts.put("L.B Subramanyam","9845576541");
        contacts.put("D Lakshmanna","7842456530");
        contacts.put("Y Harinath Reddy","9000464325");
        contacts.put("M Nagireddy","9632794868");
        contacts.put("B Siva Prasad","9847724366");
        contacts.put("S Sravan Kumar","8142151495");
        contacts.put("S Venkat Naidu","9666376722");
        contacts.put("J Anil Kumar","8897682132");
        contacts.put("A Sri Ranganayakulu","9703514394");
        contacts.put("Amarnath reddy","8142796648");
        contacts.put("M Nagabhushan","9989968427");
        contacts.put("B Suresh","9985206769");
        contacts.put("V.G Chandra shekehar","7799265717");
        contacts.put("V Nagaraju","7658998015");
        contacts.put("L Thulasi Ramappa","9676832059");
        contacts.put("Y Lakshminarayana","7842122294");
        contacts.put("B Veeranarappa","9966723059");
        contacts.put("J Pavan kumar","9622891442");
        contacts.put("S Narendra","9908632739");
        contacts.put("M Bhaskar","7095909901");
        contacts.put("B Bayanna","9704203601");
        contacts.put("K.G Ramanjaneyulu","9948272511");
        contacts.put("S Murali Nayak","9573764582");
        contacts.put("D Mahaboob","9010084843");
        contacts.put("U Yerri Swami","8008842731");
        contacts.put("H C Jayaramulu","8019564853");
        contacts.put("E C Chandrayudu","9502385821");
        contacts.put("C Bramhayya","");
        contacts.put("Ramarao","");
        contacts.put("Karunakar Reddy","");
        contacts.put("Y Chandrashekar","");
        contacts.put("N Narasimhulu","");
        contacts.put("M Ganesh Kumar","");
        contacts.put("B Narendra Babu","");
        contacts.put("N K Adinarayana","");
        contacts.put("P Rajagopal","");
        contacts.put("M Peddanna","");

        Set keys = contacts.keySet();

        for (Iterator i = keys.iterator(); i.hasNext();)
        {
            String key = (String) i.next();
            String value = (String) contacts.get(key);
            FContacts fContacts=new FContacts();
            fContacts.setName(key);
            fContacts.setPhoneNumber(value);
            fContactsList.add(fContacts);
        }

        Collections.sort(gfContactsList, new Comparator<FContacts>() {
            public int compare(FContacts one, FContacts other) {
                return one.getName().compareTo(other.getName());
            }
        });

        Collections.sort(fContactsList, new Comparator<FContacts>() {
            public int compare(FContacts one, FContacts other) {
                return one.getName().compareTo(other.getName());
            }
        });

        for(int i=0; i<gfContactsList.size();i++){
            fContactsList.add(gfContactsList.get(i));
        }

        ContactListAdapter contactListAdapter=new ContactListAdapter(this,fContactsList );
        ListView contactList=(ListView)findViewById(R.id.contactList);
        contactList.setAdapter(contactListAdapter);
        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(fContactsList.get(position).getPhoneNumber().trim().length()>0) {
                    call(fContactsList.get(position).getPhoneNumber());
                }
            }
        });
    }

    public void call(String phone) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:0" + phone));
        startActivity(callIntent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
