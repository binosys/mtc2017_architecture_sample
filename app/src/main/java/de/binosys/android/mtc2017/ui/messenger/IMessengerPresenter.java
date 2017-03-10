/*
 * @class:			IMessengerPresenter
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */
package de.binosys.android.mtc2017.ui.messenger;

import de.binosys.android.mtc2017.crossconcern.mvp.IPresenter;


/**
 * Created by Gabriel on 17.06.16.
 */
public interface IMessengerPresenter extends IPresenter {

	void setView(IMessengerView view);

	void messageFilterChanged(int position);
}
