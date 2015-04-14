package com.tcl.slidemenu_metro.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tcl.slidemenu_metro.R;


public class SettingFragment extends Fragment{
	private Button shareButton;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.setting_fragment, null);
		
		shareButton = (Button)view.findViewById(R.id.one);
		shareButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Intent.ACTION_SEND_MULTIPLE);    
                intent.setType("image/*");    
                intent.putExtra(Intent.EXTRA_SUBJECT, "Share");    
                intent.putExtra(Intent.EXTRA_TEXT, "I have successfully share my message through my app (分享自city丽人馆)");    
                 
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);    
                startActivity(Intent.createChooser(intent, getActivity().getTitle()));
			}
		});
		
		return view;
	}
}
