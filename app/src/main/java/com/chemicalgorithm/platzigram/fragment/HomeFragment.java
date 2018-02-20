package com.chemicalgorithm.platzigram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chemicalgorithm.platzigram.R;
import com.chemicalgorithm.platzigram.adapter.PictureAdapterRecyclerView;
import com.chemicalgorithm.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment
{


	public HomeFragment()
	{
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_home, container, false);
		showToolbar(getResources().getString(R.string.bottombar_home), false, view);
		RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
		linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		picturesRecycler.setLayoutManager(linearLayoutManager);

		PictureAdapterRecyclerView pictureAdapterRecyclerView =
				new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());
		picturesRecycler.setAdapter(pictureAdapterRecyclerView);
		return view;

	}

	public ArrayList<Picture> buildPictures()
	{
		ArrayList<Picture> pictures = new ArrayList<>();
		pictures.add(new Picture("https://scontent.fbaq1-1.fna.fbcdn.net/v/t1.0-0/p206x206/1522131_10151788882905633_431426053_n.jpg?_nc_eui2=v1%3AAeGWwI6P3UGPE49KmyH6VJjBFY-jdEACAVIUxgtiiTaKa7dOlhVXcv3xtu56O0mGe1IlUR7qaCCxjBS1RpiN6ZztbIBwwsxPFnl1utP7itbWfQ&oh=621c909a3e1b4f9134290954aca82a41&oe=5B132D56",
				"Mamita", "5 días", "15 me gusta"));
		pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg",
				"Juan Pablo", "3 días", "10 me gusta"));
		pictures.add(new Picture("https://i.pinimg.com/564x/fd/91/9a/fd919ae49b855848f2c407f363d44aef--gato-cheshire-the-cheshire.jpg",
				"Carlos Pinzón", "2 días", "20 me gusta"));
		pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg",
				"Dani ", "3 días", "25 me gusta"));
		pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg",
				"Anahí Salgado", "3 días", "0 me gusta"));
		return pictures;




	}

	public void showToolbar(String title , boolean upButton, View view)
	{
		Toolbar toolbar = (Toolbar) view.findViewById(R.id.toobar);
		//soporte para versiones anteriores a Lollipop
		((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
		((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
		//en caso de que tenga botón de regreso o subir
		((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
	}
}