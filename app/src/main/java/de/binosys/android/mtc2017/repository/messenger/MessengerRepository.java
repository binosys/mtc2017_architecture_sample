/*
 * @class:			MessengerRepository
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */

package de.binosys.android.mtc2017.repository.messenger;

import javax.inject.Inject;

import de.binosys.android.mtc2017.repository.messenger.dto.MessageDto;
import rx.Observable;
import rx.subjects.ReplaySubject;


/**
 * Created by Gabriel on 03.03.17.
 */

public class MessengerRepository {

	ReplaySubject<MessageDto> messageSubject = ReplaySubject.create();

	@Inject
	public MessengerRepository() {

	}

	public Observable<MessageDto> messageObservable() {

		return messageSubject;
	}

	public void addMessage(MessageDto dto) {

		messageSubject.onNext(dto);
	}
}
