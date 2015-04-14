package com.tcl.slidemenu_metro;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.tcl.slidemenu_metro.fragment.SettingFragment;
import com.tcl.slidemenu_metro.fragment.UserinfoFragment;

public class MainActivity extends SlidingFragmentActivity implements OnClickListener{

	private SlidingMenu leftRightSlidingMenu;
	private ImageButton leftButton;
	private ImageButton rightButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		initSlideMenu();
		initImageButton();
	}
	
	private void initImageButton() {
		leftButton = (ImageButton)findViewById(R.id.leftButton);
		rightButton = (ImageButton)findViewById(R.id.rightButton);
		leftButton.setOnClickListener(this);
		rightButton.setOnClickListener(this);
	}
	public void initSlideMenu() {
		
		SlidingMenu sm = getSlidingMenu();
		sm.setMode(SlidingMenu.LEFT_RIGHT);//两边都有
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);//全屏滑动
//		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);//边缘滑动
		
		//左边的fragment
		setBehindContentView(R.layout.left_menu_frame);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setBehindScrollScale(0);
		sm.setSlidingEnabled(true);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setFadeDegree(0.25f);
		
		sm.setSecondaryMenu(R.layout.right_menu_frame);
		sm.setSecondaryShadowDrawable(R.drawable.shadow);
		
		leftRightSlidingMenu = getSlidingMenu();
		
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.left_menu_frame, new UserinfoFragment())
		.commit();
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.right_menu_frame, new SettingFragment())
		.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.leftButton:
			leftRightSlidingMenu.showMenu();
			
			break;
		case R.id.rightButton:
			leftRightSlidingMenu.showSecondaryMenu();
			
			break;
		default:
			break;
		}
		
	}

}
