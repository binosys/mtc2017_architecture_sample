/*
 * @class:			ConsoleLogAdapter
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */
package de.binosys.android.mtc2017.ui.messenger;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import de.binosys.android.mtc2017.R;
import de.binosys.android.mtc2017.business.messenger.MessengerModel;


/**
 * Created by Gabriel on 14.06.16.
 */
public class MessengerAdapter extends ArrayAdapter<MessengerModel> {


	private final int           colorAll;
	private final int           colorInfo;
	private final int           colorWarning;
	private final int           colorAlert;
	private final int           colorUnknown;

	public MessengerAdapter(Context context) {

		super(context, R.layout.message_item);

		colorAll = context.getResources().getColor(R.color.message_all, null);
		colorInfo = context.getResources().getColor(R.color.message_info, null);
		colorWarning = context.getResources().getColor(R.color.message_warning, null);
		colorAlert = context.getResources().getColor(R.color.message_alert, null);
		colorUnknown = context.getResources().getColor(R.color.message_unknown, null);

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View item = convertView;

		if (item == null) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			item = inflater.inflate(R.layout.message_item, null);
		}

		MessengerModel model = getItem(position);

		if (model != null) {
			TextView textView = (TextView) item.findViewById(R.id.message_item_text);
			textView.setText(model.getMessage());
			setColorTo(textView, model);
		}

		return item;
	}

	private void setColorTo(TextView textView, MessengerModel dto) {

		switch (dto.getType()) {

			case ALL:
				textView.setTextColor(colorAll);
				break;
			case INFO:
				textView.setTextColor(colorInfo);
				break;
			case WARNING:
				textView.setTextColor(colorWarning);
				break;
			case ALERT:
				textView.setTextColor(colorAlert);
				break;
			case UNKNOWN:
				textView.setTextColor(colorUnknown);
				break;
			default:
				textView.setTextColor(colorUnknown);
		}
	}

}
