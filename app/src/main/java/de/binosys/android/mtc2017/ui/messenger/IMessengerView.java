/*
 * @class:			IConsoleLogView
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */

package de.binosys.android.mtc2017.ui.messenger;

import java.util.List;

import de.binosys.android.mtc2017.business.messenger.MessengerModel;


/**
 * Created by Gabriel on 14.06.16.
 */
public interface IMessengerView {

	void add(MessengerModel model);

	void add(List<MessengerModel> models);

}
