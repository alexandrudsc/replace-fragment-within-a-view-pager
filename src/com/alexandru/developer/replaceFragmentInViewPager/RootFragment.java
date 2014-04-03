/*
 * Copyright © 2014 Alexandru Dascălu.
 * com.alex.independent.developer
 */

package com.alexandru.developer.replaceFragmentInViewPager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

// Fake fragment used to define a container for the "real" fragment.

public class RootFragment extends Fragment{


    	private ViewGroup rootFragment;

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState){
        if(savedInstanceState!=null)
            return (ViewGroup)this.getFragmentManager().getFragment(savedInstanceState, "root_index").getView();

	rootFragment=(ViewGroup)inflater.inflate(R.layout.root_framgment, container, false);

        FragmentTransaction transaction=this.getFragmentManager().beginTransaction();

        RealFragment indexFragment=new RealFragment();

        transaction.replace(R.id.root_frame1, indexFragment);

        transaction.commit();

		return rootFragment;
	}


    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        //Save instance of fragment to use in onCreateView, in case onDestroyView was called
        this.getFragmentManager().putFragment(outState, "root_index", this);
    }

}
