package com.example.a1216qdf.ntougendermap;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.qozix.tileview.TileView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MarkFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MarkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarkFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CheckBox checkBoxBathroom;
    public CheckBox checkBoxWater;
    public TileView tileView;
    public ImageView imageView;
    public ImageView imageView1;

    private OnFragmentInteractionListener mListener;

    public MarkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MarkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MarkFragment newInstance(String param1, String param2) {
        MarkFragment fragment = new MarkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mark,container,false);
        imageView = new ImageView(getActivity());
        imageView.setImageResource( R.drawable.car);
        imageView1 = new ImageView(getActivity());
        imageView1.setImageResource(R.drawable.water);

        checkBoxBathroom = (CheckBox)v.findViewById(R.id.checkboxBathroom);
        checkBoxWater = (CheckBox)v.findViewById(R.id.checkboxWater);

        checkBoxBathroom.setOnCheckedChangeListener(checkBoxListener);
        checkBoxWater.setOnCheckedChangeListener(CCC);


        // Inflate the layout for this fragment
        return v;
    }

    private CheckBox.OnCheckedChangeListener checkBoxListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.checkboxBathroom:
                    if (checkBoxBathroom.isChecked())
                    {
                        addPin(500,1000);
                    }
                    else {
                        removePin(500,1000);
                    }
            }
        }
    };

    private CheckBox.OnCheckedChangeListener CCC = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.checkboxWater:
                    if (checkBoxWater.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);
                        tileView.addMarker( imageView1, 50, 50, null, null );
                    }
                    else {
                        tileView.removeMarker(imageView1);
                    }
            }
        }
    };

    public void addPin( double x, double y ) {
        tileView = (TileView)getActivity().findViewById(R.id.tileView);
        tileView.addMarker( imageView, x, y, null, null );
    }

    private void removePin( double x, double y ){
        tileView.removeMarker(imageView);

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    // a list of points to demonstrate markers and paths
    private ArrayList<double[]> points = new ArrayList<>();

    {
        points.add( new double[] {1, 2} );
        points.add( new double[] {3,6} );
        points.add( new double[] {7, 11} );
        points.add( new double[] {20,20} );
        points.add( new double[] {50, 50} );
        points.add( new double[] {60,90} );
        points.add( new double[] {100,150} );
        points.add( new double[] {200, 250} );
        points.add( new double[] {300, 388} );
        points.add( new double[] {1000,1000} );
        points.add( new double[] {1555,1500} );

    }
}
