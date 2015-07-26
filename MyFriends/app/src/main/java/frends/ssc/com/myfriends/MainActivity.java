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
import java.util.List;


public class MainActivity extends ActionBarActivity {
   private  List<FContacts> fContactsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         String[] names = {"Kanchireddy", "Subramanyam", "Lakshmanna","Harinath Reddy","Nagireddy", "Siva Prasad", "Sravan", "Venkat Naidu",
                 "Anil Kumar", "Ranga", "Amarnath reddy","Nagabhushan","Suresh", "V.G Chandra shekehar", "Nagaraju", "Thulasiram",

                 "Lakshminarayana", "Veeranarappa", "Pavan kumar","K.G Ramanjaneyulu","B.Bayanna", "Bramhayya", "Jairamulu", "Ramarao",
                 "Karnakar Reddy", "M Bhaskar", "Murali Nayak","Narendra","Chandrashekar", "D Mahaboob", "N Narasimhulu"};

        String[] contacts = {"9963492925", "9845576541", "7842456530",
                "9000464325", "9632794868", "9847724366", "8142151495",
                "9666376722","8897682132", "9703514394", "9908632739",
                "8142796648","9989968427", "9985206769", "7799265717",
                "7658998015", "9676832059", "7842122294", "9966723059",
                "9622891442", "", "9704203601", "", "", "", "", "7095909901","","","","",""};
        String[] locations = {"Hyderabad", "Hyderabad", "M Bandameedapalli"};
        fContactsList= new ArrayList<FContacts>();
        for (int i=0; i<names.length; i++){
            FContacts fContacts=new FContacts();
            fContacts.setName(names[i]);
            fContacts.setPhoneNumber(contacts[i]);
            fContactsList.add(fContacts);
        }

        Collections.sort(fContactsList, new Comparator<FContacts>() {
            public int compare(FContacts one, FContacts other) {
                return one.getName().compareTo(other.getName());
            }
        });
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
