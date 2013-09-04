package net.tensory.googleimagesearch;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class ColorFilterActivity extends Activity {
	ArrayList<Integer> colorIds;
	ListView colorListView;
	ColorOptionArrayAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_filter);
		
		setupViews();
		colorIds = setColors();
		adapter = new ColorOptionArrayAdapter(this, colorIds);
		colorListView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.color_filter, menu);
		return true;
	}
	
	public void setupViews() {
		colorListView = (ListView) findViewById(R.id.lvColorChoices);
	}

	public ArrayList<Integer> setColors() { 
		// Yuck. Would like to abstract this...
		// Or use local storage?
		Integer[] colors = {
				R.string.txtColorName_Orange,
				R.string.txtColorName_Red,
				R.string.txtColorName_Yellow,
				R.string.txtColorName_Green,
				R.string.txtColorName_Blue,
				R.string.txtColorName_Purple,
				R.string.txtColorName_Pink,
				R.string.txtColorName_Black,
				R.string.txtColorName_White,
				R.string.txtColorName_Gray,
				R.string.txtColorName_Brown
		};
		ArrayList<Integer> ids = new ArrayList();
		for (Integer id : colors) {
			ids.add(id);
		}
		return ids;
	}
}
