/*
 * @class:			RxPresenter
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */

package de.binosys.android.mtc2017.crossconcern.mvp;

import rx.subscriptions.CompositeSubscription;


/**
 * Created by Gabriel on 24.02.17.
 */

public class RxPresenter implements IPresenter {


	protected CompositeSubscription compositeSubscription = new CompositeSubscription();

	@Override
	public void onViewAttached() {

	}

	@Override
	public void onViewDetached() {
		compositeSubscription.clear();
	}
}
