/*
 * @class:			ConsoleLogViewPresenter
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */
package de.binosys.android.mtc2017.ui.messenger;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.binosys.android.mtc2017.business.messenger.MessengerManager;
import de.binosys.android.mtc2017.crossconcern.mvp.RxPresenter;
import rx.Subscription;


/**
 * Created by Gabriel on 14.06.16.
 */
@Singleton
public class MessengerPresenter extends RxPresenter implements IMessengerPresenter {


	@Inject
	MessengerManager manager;


	private IMessengerView view;

	public void setView(IMessengerView view) {

		this.view = view;
	}

	@Override
	public void messageFilterChanged(int position) {

		manager.setMessageFilter(position);
	}

	@Override
	public void onViewAttached() {

		super.onViewAttached();
		subscribeMessages();
		manager.startMessageReading();
	}

	private void subscribeMessages() {

		Subscription subscription = manager.getMessage()
				.doOnNext(message -> view.add(message))
				.subscribe();

		compositeSubscription.add(subscription);

	}

}
