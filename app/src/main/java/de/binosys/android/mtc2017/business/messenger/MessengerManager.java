/*
 * @class:			MessengerManager
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */

package de.binosys.android.mtc2017.business.messenger;

import javax.inject.Inject;

import de.binosys.android.mtc2017.business.messenger.MessengerModel.MessageType;
import de.binosys.android.mtc2017.repository.messenger.MessageGenerator;
import de.binosys.android.mtc2017.repository.messenger.MessengerRepository;
import de.binosys.android.mtc2017.repository.messenger.dto.MessageDto;
import rx.Observable;


/**
 * Created by Gabriel on 03.03.17.
 */

public class MessengerManager {


	@Inject
	MessengerRepository repository;
	@Inject
	MessageGenerator    generator;


	public void setMessageFilter(int position) {


	}

	public Observable<MessengerModel> getMessage() {

		return repository.messageObservable().map(messageDto -> modelFrom(messageDto));
	}

	private MessengerModel modelFrom(MessageDto messageDto) {

		MessageType type = MessageType.messageTypeOf(messageDto.getType());
		return new MessengerModel(messageDto.getMessage(), type);
	}


	public void startMessageReading(){
		generator.start();
	}

	public void stopMessageReading(){
		generator.stop();
	}
}
