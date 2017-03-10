/*
 * @class:			MessengerModel
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */

package de.binosys.android.mtc2017.business.messenger;

/**
 * Created by Gabriel on 03.03.17.
 */

public class MessengerModel {

	MessageType type;
	String      message;

	public MessengerModel(String message, MessageType type) {

		this.message = message;
		this.type = type;
	}

	public MessageType getType() {

		return type;
	}

	public void setType(MessageType type) {

		this.type = type;
	}

	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {

		this.message = message;
	}

	public enum MessageType {

		ALL("all"),
		INFO("info"),
		WARNING("warning"),
		ALERT("alert"),
		UNKNOWN("unknown");

		private final String type;

		MessageType(String type) {

			this.type = type;
		}

		public static MessageType messageTypeOf(String stringType) {

			MessageType logType;

			if (ALL.type.equals(stringType)) {
				logType = ALL;

			} else if (INFO.type.equals(stringType)) {
				logType = INFO;

			} else if (WARNING.type.equals(stringType)) {
				logType = WARNING;

			} else if (ALERT.type.equals(stringType)) {
				logType = ALERT;

			} else {
				logType = UNKNOWN;
			}

			return logType;
		}
	}

}
