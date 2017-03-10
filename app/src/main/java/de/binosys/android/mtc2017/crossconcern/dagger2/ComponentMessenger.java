/*
 * @class:			MessengerComponent
 * @author:		Binosys GmbH | Gabriel Weis
 * @date:			8/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */

package de.binosys.android.mtc2017.crossconcern.dagger2;

import dagger.Component;
import de.binosys.android.mtc2017.ui.messenger.MessengerActivity;


/**
 * Created by Gabriel on 08.03.17.
 */

@Component(
		modules = {
				ModuleMessenger.class
		}
)
public interface ComponentMessenger {

	void inject(MessengerActivity activity);
}
