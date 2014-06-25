package com.arpitonline.samplefreeflowproject;

import com.arpitonline.samplefreeflowproject.animations.CustomAnimation;
import com.arpitonline.samplefreeflowproject.data.SampleDataAdapter;
import com.comcast.freeflow.core.FreeFlowContainer;
import com.comcast.freeflow.layouts.FreeFlowLayout;
import com.comcast.freeflow.layouts.VLayout;
import com.comcast.freeflow.utils.ViewUtils;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

	public MainFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		
		FreeFlowContainer ffcontainer = (FreeFlowContainer)rootView.findViewById(R.id.container);
		ffcontainer.setLayoutAnimator( new CustomAnimation() );
		ffcontainer.setLayout(getLayout());
		ffcontainer.setAdapter(new SampleDataAdapter());
		
		return rootView;
	}
	
	private FreeFlowLayout getLayout(){
		int ht = (int)ViewUtils.dipToPixels(getActivity(), 60);
		VLayout.LayoutParams p = new VLayout.LayoutParams( ht, 1500, ht );
		VLayout v = new VLayout();
		v.setLayoutParams(p);
		return v;
	}
}