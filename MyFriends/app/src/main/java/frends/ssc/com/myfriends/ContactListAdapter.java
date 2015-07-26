package frends.ssc.com.myfriends;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by apple on 7/25/2015.
 */
public class ContactListAdapter extends BaseAdapter {
    private  Activity activity;
    private List<FContacts> fContactsList;
    public ContactListAdapter(Activity activity, List<FContacts> fContactsList) {
       this. activity=activity;
       this.fContactsList=fContactsList;
    }

    @Override
    public int getCount() {
        return fContactsList.size();
    }

    @Override
    public FContacts getItem(int position) {
        return fContactsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return fContactsList.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.mPersoneName = (TextView) convertView.findViewById(R.id.contactPersonName);
            holder.mLocation = (TextView) convertView.findViewById(R.id.contactPersonLocation);
            holder.mContactNumber = (TextView) convertView.findViewById(R.id.contactNumber);
            holder.mImageView = (ImageView) convertView.findViewById(R.id.contactPersonImage);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        FContacts mContactItem = (FContacts) getItem(position);

        holder.mPersoneName.setText(mContactItem.getName());
        holder.mContactNumber.setText(mContactItem.getPhoneNumber());
//        holder.mLocation.setText(mContactItem.getName());
//        holder.mImageView.setImageResource(mContactItem.getImageId());

        return convertView;
    }

    private class ViewHolder {
        ImageView mImageView;
        TextView mPersoneName, mContactNumber;
        TextView mLocation;
    }

}
