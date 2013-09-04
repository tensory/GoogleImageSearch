package net.tensory.googleimagesearch;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;


public class ColorOptionArrayAdapter extends ArrayAdapter<Integer> {
	private Context myContext;
	
	public ColorOptionArrayAdapter(Context context, List<Integer> ids) {
		super(context, R.layout.color_choice, ids);
		myContext = context;
	}

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // Get the data item based on ID
       int color = (Integer) getItem(position);
       
       // Check if an existing view is being reused, otherwise inflate the view
       View view = convertView;
       if (view == null) {
           LayoutInflater inflater = LayoutInflater.from(getContext());
           view = inflater.inflate(R.layout.color_choice, null);
        }
       
       // Populate the data into the template view using the data object
       CheckBox input = (CheckBox) view.findViewById(R.id.inputCheckbox);
       TextView label = (TextView) view.findViewById(R.id.tvLabel);
       label.setText(myContext.getResources().getString(color));
       
       return view;
   }
}