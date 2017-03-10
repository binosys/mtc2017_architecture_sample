/*
 * @class:			OverviewModule
 * @author:		Binosys GmbH | Gabriel Weis
 * @date:			8/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */

package de.binosys.android.mtc2017.crossconcern.dagger2;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import de.binosys.android.mtc2017.ui.messenger.IMessengerPresenter;
import de.binosys.android.mtc2017.ui.messenger.MessengerAdapter;
import de.binosys.android.mtc2017.ui.messenger.MessengerPresenter;


@Module
public class ModuleMessenger {

	private Context context;

	public ModuleMessenger(Context context) {

		this.context = context;
	}

	@Provides
	public MessengerAdapter provideMessengerListAdapter() {

		return new MessengerAdapter(context);
	}


	@Provides
	public IMessengerPresenter provideIMessengerPresenter(MessengerPresenter presenter) {

		return presenter;
	}


}
