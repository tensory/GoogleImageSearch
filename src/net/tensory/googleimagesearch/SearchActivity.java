package net.tensory.googleimagesearch;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import net.tensory.googleimagesearch.ImageResult;

public class SearchActivity extends Activity {
	private EditText etQuery;
	private Button btnSearch;
	private GridView gvResults;
	private ArrayList<ImageResult> imageResults = new ArrayList<ImageResult>();
	private ImageResultArrayAdapter imageAdapter;
	
	// In a large app, where would I store a string like this, that isn't a UI string
	// so that it's easy to find and maintain later?
	private String searchUriBase = "https://ajax.googleapis.com/ajax/services/search/images?rsz=8&v=1.0&";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		setupViews();
		imageAdapter = new ImageResultArrayAdapter(this, imageResults);
		gvResults.setAdapter(imageAdapter); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
	public void setupViews() {
		etQuery = (EditText) findViewById(R.id.etQuery);
		btnSearch = (Button) findViewById(R.id.btnSearch);
		gvResults = (GridView) findViewById(R.id.gvResults);
	}
	
	public void onImageSearch(View v) {
		String query = etQuery.getText().toString();
		
		AsyncHttpClient searchClient = new AsyncHttpClient();
		String queryString = searchUriBase + "start=" + 0 + "&q=" + Uri.encode(query);
		searchClient.get(
				queryString,
				new JsonHttpResponseHandler() {
					@Override
					public void onSuccess(JSONObject response) {
						JSONArray imageJsonResults = null;
						try {
							imageJsonResults = response.getJSONObject(
									"responseData").getJSONArray("results");
							imageResults.clear();
							imageAdapter.addAll(ImageResult.fromJSONArray(imageJsonResults));
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
		});
		
	}	
}
