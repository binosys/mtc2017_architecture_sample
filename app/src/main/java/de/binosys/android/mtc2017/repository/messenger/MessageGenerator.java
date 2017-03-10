/*
 * @class:			MessageGenerator
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */

package de.binosys.android.mtc2017.repository.messenger;

import android.util.Log;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.binosys.android.mtc2017.repository.messenger.dto.MessageDto;
import rx.Completable;
import rx.Subscription;
import rx.schedulers.Schedulers;


/**
 * Created by Gabriel on 03.03.17.
 */
@Singleton
public class MessageGenerator {

	private static final String TAG = MessageGenerator.class.getSimpleName();
	@Inject
	MessengerRepository repository;
	private String[] messages = {
			"In many software programming tasks",
			"you more or less expect that the instructions you write will execute and complete incrementally",
			"one-at-a-time", "in order as you have written them", "But in ReactiveX",
			"many instructions may execute in parallel and their results are later captured",
			"in arbitrary order",
			"by “observers.” Rather than calling a method",
			"you define a mechanism for retrieving and transforming the data",
			"in the form of an “Observable,” and then subscribe an observer to it",
			"at which point the previously-defined mechanism fires into action with",
			"the observer standing sentry to capture and respond to its emissions whenever they are ready.",
			"An advantage of this approach is that when you have a bunch of tasks that are not dependent on each other",
			"you can start them all at the same time rather than waiting for each one to finish before starting the next one — that way",
			"your entire bundle of tasks only takes as long to complete as the longest task in the bundle.",
			"There are many terms used to describe this model of asynchronous programming and design",
			"This document will use the following terms: An observer subscribes to an Observable",
			"An Observable emits items or sends notifications to its observers by calling the observers’ methods.",
			"In other documents and other contexts",
			"what we are calling an “observer” is sometimes called a “subscriber,” “watcher,” or “reactor.”,"
	};
	private String[] type = {
			"all",
			"info",
			"warning",
			"alert",
			"unknown"
	};

	private Random random = new Random();
	private Subscription subscription;

	public void start() {

		subscription = Completable
				.fromAction(this::createMessage)
				.subscribeOn(Schedulers.computation())
				.doOnError(throwable -> Log.e(TAG, "Could not create next message.", throwable))
				.delay(1000, TimeUnit.MILLISECONDS)
				.repeat()
				.subscribe();
	}


	public void stop() {

		if (subscription != null && !subscription.isUnsubscribed()) {
			subscription.unsubscribe();
		}
	}

	private void createMessage() {

		String type    = randomType();
		String message = randomMessage();

		repository.addMessage(new MessageDto(message, type));

	}

	private String randomType() {

		int randomIndex = randomNumber(0, type.length);
		return type[randomIndex];
	}

	private String randomMessage() {

		int randomIndex = randomNumber(0, messages.length);
		return messages[randomIndex];
	}

	public int randomNumber(int min, int max) {

		return random.nextInt((max - min) + 1) + min;
	}
}
