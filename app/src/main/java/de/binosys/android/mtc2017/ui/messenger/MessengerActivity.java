/*
 * @class:			MessengerActivity
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */

package de.binosys.android.mtc2017.ui.messenger;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import javax.inject.Inject;

import de.binosys.android.mtc2017.R;
import de.binosys.android.mtc2017.crossconcern.dagger2.DaggerComponentMessenger;
import de.binosys.android.mtc2017.crossconcern.dagger2.ModuleMessenger;


/**
 * Created by Gabriel on 03.03.17.
 */

public class MessengerActivity extends Activity {

	@Inject
	MessengerView messengerView;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {

		super.onCreate(savedInstanceState, persistentState);

		inject();
		initView();
	}

	private void inject() {

		DaggerComponentMessenger
				.builder()
				.moduleMessenger(new ModuleMessenger(this))
				.build()
				.inject(this);
	}


	private void initView() {

		setContentView(R.layout.activity_messenger);

		FrameLayout mainContainer = (FrameLayout) findViewById(R.id.container_main);
		mainContainer.addView(messengerView);
	}
}
