package net.tensory.googleimagesearch;

import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

public class ImageResultArrayAdapter extends ArrayAdapter<ImageResult> {

	public ImageResultArrayAdapter(Context context, List<ImageResult> images) {
		super(context, android.R.layout.simple_list_item_1, images);
		// TODO Auto-generated constructor stub
	}

}
