/*
 * @class:			MessageDto
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */

package de.binosys.android.mtc2017.repository.messenger.dto;

/**
 * Created by Gabriel on 03.03.17.
 */

public class MessageDto {

	String type;
	String message;

	public MessageDto(String message, String type) {

		this.message = message;
		this.type = type;

	}

	public String getMessage() {

		return message;
	}

	public void setMessage(String message) {

		this.message = message;
	}

	public String getType() {

		return type;
	}

	public void setType(String type) {

		this.type = type;
	}
}
