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

import com.qozix.tileview.TileView;
import com.qozix.tileview.paths.CompositePathView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RouteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RouteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RouteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CheckBox LightRuoute;
    public TileView tileView;

    private OnFragmentInteractionListener mListener;

    public RouteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RouteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RouteFragment newInstance(String param1, String param2) {
        RouteFragment fragment = new RouteFragment();
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

        View view = inflater.inflate(R.layout.fragment_route,container,false);

        LightRuoute = (CheckBox)view.findViewById(R.id.LightRoute);
        LightRuoute.setOnCheckedChangeListener(ddd);


        // Inflate the layout for this fragment
        return view;
    }

    private CheckBox.OnCheckedChangeListener ddd = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.LightRoute:
                    if (LightRuoute.isChecked())
                    {
DrawLightRoute();
                    }
                    else {

                    }
            }
        }
    };

    private void DrawLightRoute(){

        tileView = (TileView)getActivity().findViewById(R.id.tileView);
        tileView.drawPath( points.subList( 5, 10 ), null );


    }

    private void RemoveLightRoute(){
        tileView.removePath((CompositePathView.DrawablePath) points.subList( 5, 10 ));
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
