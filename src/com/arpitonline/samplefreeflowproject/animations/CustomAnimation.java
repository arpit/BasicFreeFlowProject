package com.arpitonline.samplefreeflowproject.animations;

import java.util.ArrayList;
import java.util.List;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewPropertyAnimator;

import com.comcast.freeflow.animations.DefaultLayoutAnimator;
import com.comcast.freeflow.animations.FreeFlowLayoutAnimator;
import com.comcast.freeflow.core.FreeFlowContainer;
import com.comcast.freeflow.core.FreeFlowItem;
import com.comcast.freeflow.core.LayoutChangeset;

public class CustomAnimation extends DefaultLayoutAnimator {

	protected AnimatorSet getItemsAddedAnimation(List<FreeFlowItem> added) {
		AnimatorSet appearingSet = new AnimatorSet();
		ArrayList<Animator> moveIns = new ArrayList<Animator>();
		for (FreeFlowItem proxy : added) {
			proxy.view.setTranslationX(3000);
			moveIns.add(ObjectAnimator.ofFloat(proxy.view, "translationX", 0));
		}

		appearingSet.playSequentially(moveIns);
		appearingSet.setDuration(300);
		return appearingSet;
	}

}
