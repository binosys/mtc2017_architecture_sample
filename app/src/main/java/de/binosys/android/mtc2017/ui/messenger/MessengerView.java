/*
 * @class:			MessengerView
 * @author:			Binosys GmbH | Gabriel Weis
 * @date:			3/3/2017
 * @copyright:		Copyright (c) 2017 All rights reserved by Binosys GmbH (Eschau/Deutschland)
 */
package de.binosys.android.mtc2017.ui.messenger;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

import javax.inject.Inject;

import de.binosys.android.mtc2017.R;
import de.binosys.android.mtc2017.business.messenger.MessengerModel;


/**
 * Created by Gabriel on 14.06.16.
 */
public class MessengerView extends FrameLayout implements IMessengerView {

	private static final int MAX_COUNT_ENTRIES = 1000;

	IMessengerPresenter presenter;


	private ListView         list;
	private MessengerAdapter adapter;

	private Spinner spinnerLogFilter;


	@Inject
	public MessengerView(Activity activity, IMessengerPresenter presenter) {

		super(activity);

		this.presenter = presenter;
		this.presenter.setView(this);

		initView(activity);

	}

	private void initView(Context context) {

		View root = inflate(context, R.layout.messenger_view, this);
		list = (ListView) root.findViewById(R.id.message_list);

		spinnerLogFilter = (Spinner) root.findViewById(R.id.message_filter);
		spinnerLogFilter.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

				presenter.messageFilterChanged(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// nothing to do
			}
		});

		LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		setLayoutParams(params);

		adapter = new MessengerAdapter(context);
		list.setAdapter(adapter);
	}

	@Override
	public void add(MessengerModel model) {

		addToAdapter(model);
		updateListView();
	}

	@Override
	public void add(List<MessengerModel> models) {

		for (MessengerModel model : models) {
			addToAdapter(model);
		}
		updateListView();
	}

	@Override
	protected void onAttachedToWindow() {

		super.onAttachedToWindow();
		presenter.onViewAttached();
	}

	@Override
	protected void onDetachedFromWindow() {

		super.onDetachedFromWindow();
		presenter.onViewDetached();
	}

	private void addToAdapter(MessengerModel model) {

		if (adapter.getCount() >= MAX_COUNT_ENTRIES) {
			adapter.remove(adapter.getItem(0));
		}

		adapter.add(model);
	}

	private void updateListView() {

		adapter.notifyDataSetChanged();
		list.setSelection(adapter.getCount() - 1);
	}
}
