package com.example.spinnerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity
{
	Spinner spinnerCity;
	Button buttonGo;
	TextView textCity;
	
	String [] arrayCity={"Hyderabad","Pune","Delhi","Kolkata"};
	ArrayAdapter<String> adapter;
	
	
	protected void onCreate(Bundle b)
	{
		super.onCreate(b);
		setContentView(R.layout.home);
		spinnerCity=(Spinner) findViewById(R.id.spinner1);
		buttonGo=(Button) findViewById(R.id.button1);
		textCity=(TextView) findViewById(R.id.textView1);
		
		//create adapter and attach with spinner
		//adapter=new ArrayAdapter<String>(context, resource, objects)
		adapter=new ArrayAdapter<String>(HomeActivity.this, R.layout.item_view, arrayCity);
		spinnerCity.setAdapter(adapter);
		
		buttonGo.setOnClickListener(new OnClickListener() {
			//select city from spinner
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				String city=(String) spinnerCity.getSelectedItem();
				textCity.setText(city);
				
			}
		});
		
		//use spinner data as it is selected
		
		spinnerCity.setOnItemSelectedListener(new OnItemSelectedListener() 
		{
			
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				String city = arrayCity[arg2];
				Toast.makeText(HomeActivity.this, city, Toast.LENGTH_LONG).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
			
			
		});
		
	}
}
