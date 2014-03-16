package com.spacecaker.romthemer;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.spacecaker.romthemer.DialogMaker.Keys;
import com.spacecaker.romthemer.DialogMaker.Type;

public class Main_activity extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
		pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

		try {
			Runtime.getRuntime().exec("su");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class MyPagerAdapter extends FragmentPagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int pos) {
			switch (pos) {

			case 0:
				return ThemePanel1.newInstance("FirstTheme, Theme 1");
			case 1:
				return ThemePanel2.newInstance("SecondTheme, Theme 2");
			case 2:
				return ThemePanel3.newInstance("ThirdTheme, Theme 3");
			case 3:
				return ThemePanel4.newInstance("FourthTheme, Instance 4");
			default:
				return ThemePanel1.newInstance("FirstTheme, Default");
			}
		}

		@Override
		public int getCount() {
			return 4;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.spacecaker_activity, menu);
		return true;
	}

	public void copyStream(String assetFilename, String outFileName)
			throws IOException {
		InputStream myInput = getAssets().open(assetFilename);
		OutputStream myOutput = new FileOutputStream(outFileName);
		byte[] buffer = new byte[2048];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}
		myOutput.flush();
		myOutput.close();
		myInput.close();
	}

	public void MessageBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	public void themer() throws IOException, InterruptedException {
		try {
			Process mSuProcess;
			mSuProcess = Runtime.getRuntime().exec("su");
			new DataOutputStream(mSuProcess.getOutputStream())
					.writeBytes("mount -o remount rw /system\n");
			DataOutputStream mSuDataOutputStream = new DataOutputStream(
					mSuProcess.getOutputStream());
			mSuDataOutputStream
					.writeBytes("cp /sdcard/SystemUI.apk /system/app/SystemUI.apk\n");
			MessageBox("Killing this bitch!");
			mSuDataOutputStream.writeBytes("killall com.android.systemui\n");
			Thread.sleep(2000);
			mSuDataOutputStream
					.writeBytes("chmod 0644 /sdcard/SystemUI.apk /system/app/SystemUI.apk\n");
			mSuDataOutputStream.writeBytes("exit\n");
			MessageBox("Starting SystemUI!");
			Process proca = Runtime
					.getRuntime()
					.exec(new String[] { "am", "startservice", "-n",
							"com.android.systemui.statusbar.StatusBarService" });
			proca.waitFor();
			MessageBox("Statusbar Done!");
		} catch (Exception ex) {
			MessageBox("Statusbar Not changed!");
		}
	}

	public void themerframework() throws IOException, InterruptedException {
		try {
			Process mSuProcess;
			mSuProcess = Runtime.getRuntime().exec("su");
			new DataOutputStream(mSuProcess.getOutputStream())
					.writeBytes("mount -o remount rw /system\n");
			DataOutputStream mSuDataOutputStream = new DataOutputStream(
					mSuProcess.getOutputStream());
			mSuDataOutputStream
					.writeBytes("cp /sdcard/framework-res.apk /system/framework/framework-res.apk\n");
			mSuDataOutputStream
					.writeBytes("chmod 0644 /sdcard/framework-res.apk /system/framework/framework-res.apk\n");
			mSuDataOutputStream.writeBytes("exit\n");
			MessageBox("Framework Done!");
		} catch (Exception ex) {
			MessageBox("Framework Not Changed!");
		}
	}

	public void themertwframework() throws IOException, InterruptedException {
		try {
			Process mSuProcess;
			mSuProcess = Runtime.getRuntime().exec("su");
			new DataOutputStream(mSuProcess.getOutputStream())
					.writeBytes("mount -o remount rw /system\n");
			DataOutputStream mSuDataOutputStream = new DataOutputStream(
					mSuProcess.getOutputStream());
			mSuDataOutputStream
					.writeBytes("cp /sdcard/twframework-res.apk /system/framework/twframework-res.apk\n");
			mSuDataOutputStream
					.writeBytes("chmod 0644 /sdcard/twframework-res.apk /system/framework/twframework-res.apk\n");
			mSuDataOutputStream.writeBytes("exit\n");
			MessageBox("TW-Framework Done!");
			MessageBox("Please Reboot Now !");
		} catch (Exception ex) {
			MessageBox("TW-Framework-res not changed!");
		}
	}

	public void but1(View view) throws IOException, InterruptedException {
		try {
			try {
				copyStream("/stock/app/SystemUI.apk", "/sdcard/SystemUI.apk");
				themer();
			} catch (Exception ex) {
			}
			try {
				copyStream("/stock/framework/framework-res.apk",
						"/sdcard/framework-res.apk");
				themerframework();
			} catch (Exception ex) {
			}
			try {
				copyStream("/stock/framework/twframework-res.apk",
						"/sdcard/twframework-res.apk");
				themertwframework();
			} catch (Exception ex) {
			}
		} catch (Exception ex) {
		}
	}

	public void but2(View view) throws IOException, InterruptedException {
		try {
			try {
				copyStream("/theme1/app/SystemUI.apk", "/sdcard/SystemUI.apk");
				themer();
			} catch (Exception ex) {
			}
			try {
				copyStream("/theme1/framework/framework-res.apk",
						"/sdcard/framework-res.apk");
				themerframework();
			} catch (Exception ex) {
			}
			try {
				copyStream("/theme1/framework/twframework-res.apk",
						"/sdcard/twframework-res.apk");
				themertwframework();
			} catch (Exception ex) {
			}
		} catch (Exception ex) {
		}
	}

	public void but3(View view) throws IOException, InterruptedException {
		try {
			try {
				copyStream("/theme2/app/SystemUI.apk", "/sdcard/SystemUI.apk");
				themer();
			} catch (Exception ex) {
			}
			try {
				copyStream("/theme2/framework/framework-res.apk",
						"/sdcard/framework-res.apk");
				themerframework();
			} catch (Exception ex) {
			}
			try {
				copyStream("/theme2/framework/twframework-res.apk",
						"/sdcard/twframework-res.apk");
				themertwframework();
			} catch (Exception ex) {
			}
		} catch (Exception ex) {
		}
	}

	public void but4(View view) throws IOException, InterruptedException {
		try {
			try {
				copyStream("/theme3/app/SystemUI.apk", "/sdcard/SystemUI.apk");
				themer();
			} catch (Exception ex) {
			}
			try {
				copyStream("/theme3/framework/framework-res.apk",
						"/sdcard/framework-res.apk");
				themerframework();
			} catch (Exception ex) {
			}
			try {
				copyStream("/theme3/framework/twframework-res.apk",
						"/sdcard/twframework-res.apk");
				themertwframework();
			} catch (Exception ex) {
			}
		} catch (Exception ex) {
		}
	}

	public void RomThemerDialog(MenuItem item) {
		HashMap<Keys, String> params = new HashMap<Keys, String>();
		params.put(Keys.BUTTON_1, "OK");
		params.put(Keys.MESSAGE,
				(String) getResources().getText(R.string.about_rom_themer));

		new DialogMaker(this, params, Type.STANDARD) {

			@Override
			protected void dealWithTheButton1() {
			}

			@Override
			protected void dealWithTheButton2() {
			}

		};
	}

	public void RomThemerDialog2(MenuItem item) {
		Toast.makeText(this,
				"App Developed By SpaceCaker." + "RomThemer. 2014",
				Toast.LENGTH_LONG).show();
	}
}
