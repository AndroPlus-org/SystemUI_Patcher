package com.wedy.systemuimod;


import android.content.res.XModuleResources;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;


public class NotificationiconPatcher implements IXposedHookZygoteInit, IXposedHookInitPackageResources {
	private static XSharedPreferences preference = null;
	private static String MODULE_PATH = null;

	@Override
	public void initZygote(StartupParam startupParam) throws Throwable {
	preference = new XSharedPreferences(NotificationiconPatcher.class.getPackage().getName());
		MODULE_PATH = startupParam.modulePath;
	}

	@Override
	public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable {
		if (!resparam.packageName.equals("com.android.systemui"))
			return;

		XModuleResources modRes = XModuleResources.createInstance(MODULE_PATH, resparam.res);

		boolean isDataw = preference.getBoolean("key_dataw", false);
		if(isDataw){
			resparam.res.setReplacement("com.android.systemui", "drawable", "ic_notify_button_bg", modRes.fwd(R.drawable.ic_notify_button_bg));

		}
		boolean isBrig = preference.getBoolean("key_brigi", false);
		if(isBrig){
			resparam.res.setReplacement("com.android.systemui", "dimen", "status_bar_icon_drawing_alpha", modRes.fwd(R.dimen.status_bar_icon_drawing_alpha));

		}
		boolean isBigi = preference.getBoolean("key_bigi", false);
		if(isBigi){
			resparam.res.setReplacement("com.android.systemui", "dimen", "status_bar_icon_drawing_size", modRes.fwd(R.dimen.status_bar_icon_drawing_size));

		}
		boolean isTranz1 = preference.getBoolean("key_tranz1", false);
		if(isTranz1){
			resparam.res.setReplacement("com.android.systemui", "color", "system_ui_opaque_background", 0x00000000);
			resparam.res.setReplacement("com.android.systemui", "color", "system_ui_transparent_background", 0x00000000);

		}
		boolean isJpntr = preference.getBoolean("key_transjpn", false);

		if(isJpntr){
			resparam.res.setReplacement("com.android.systemui", "string", "quick_settings_bluetooth_off_label", modRes.fwd(R.string.quick_settings_bluetooth_off_label));
			resparam.res.setReplacement("com.android.systemui", "string", "quick_settings_wifi_off_label", modRes.fwd(R.string.quick_settings_wifi_off_label));
			resparam.res.setReplacement("com.android.systemui", "string", "quick_settings_rotation_unlocked_label", modRes.fwd(R.string.quick_settings_rotation_unlocked_label));
			resparam.res.setReplacement("com.android.systemui", "string", "quick_settings_rotation_locked_label", modRes.fwd(R.string.quick_settings_rotation_locked_label));
		}


	}

}
