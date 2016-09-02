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
    public CheckBox checkBoxWater,checkBoxGarbage,checkBoxBaby,checkBoxSomke,checkBoxWatch,checkBoxCar,checkBoxNobathroom
            ,checkBoxNight,checkBoxLove,checkBoxSafe;
    public TileView tileView;
    public ImageView bathroomImg;
    public ImageView waterImg;
    public ImageView garbageImg,garbageImg1;
    public ImageView babyImg,smokeImg,watchImg,carImg,nobathroomImg,nightImg,loveImg,safeImg;


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


        checkBoxBathroom = (CheckBox)v.findViewById(R.id.checkboxBathroom);
        checkBoxWater = (CheckBox)v.findViewById(R.id.checkboxWater);
        checkBoxGarbage = (CheckBox)v.findViewById(R.id.checkboxGarbage);
        checkBoxBaby = (CheckBox)v.findViewById(R.id.checkboxBaby);
        checkBoxSomke = (CheckBox)v.findViewById(R.id.checkboxSmoke);
        checkBoxWatch = (CheckBox)v.findViewById(R.id.checkboxWatch);
        checkBoxCar = (CheckBox)v.findViewById(R.id.checkboxCar);
        checkBoxNobathroom = (CheckBox)v.findViewById(R.id.checkboxNobathroom);
        checkBoxNight = (CheckBox)v.findViewById(R.id.checkboxNight);
        checkBoxLove = (CheckBox)v.findViewById(R.id.checkboxLove);
        checkBoxSafe = (CheckBox)v.findViewById(R.id.checkboxSafe);

        checkBoxBathroom.setOnCheckedChangeListener(checkListener);
        checkBoxWater.setOnCheckedChangeListener(checkListener);
        checkBoxGarbage.setOnCheckedChangeListener(checkListener);
        checkBoxBaby.setOnCheckedChangeListener(checkListener);
        checkBoxSomke.setOnCheckedChangeListener(checkListener);
        checkBoxWatch.setOnCheckedChangeListener(checkListener);
        checkBoxCar.setOnCheckedChangeListener(checkListener);
        checkBoxNobathroom.setOnCheckedChangeListener(checkListener);
        checkBoxNight.setOnCheckedChangeListener(checkListener);
        checkBoxLove.setOnCheckedChangeListener(checkListener);
        checkBoxSafe.setOnCheckedChangeListener(checkListener);



        // Inflate the layout for this fragment
        return v;
    }

    private CheckBox.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.checkboxBathroom:
                    if (checkBoxBathroom.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);
                        bathroomImg = new ImageView(getActivity());
                        bathroomImg.setImageResource(R.drawable.bathroom);
                        tileView.addMarker( bathroomImg, 2000, 2000, null, null );
                    }
                    else {
                        removePin(bathroomImg);
                    }
                case R.id.checkboxWater:
                    if (checkBoxWater.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        waterImg = new ImageView(getActivity());
                        waterImg.setImageResource(R.drawable.water);
                        tileView.addMarker( watchImg, 2000, 2000, null, null );
                    }
                    else {
                        tileView.removeMarker(waterImg);
                    }
                case R.id.checkboxGarbage:
                    if (checkBoxGarbage.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        garbageImg = new ImageView(getActivity());
                        garbageImg.setImageResource(R.drawable.garbage);
                        tileView.addMarker( garbageImg, 500, 1000, null, null );
                        garbageImg1 = new ImageView(getActivity());
                        garbageImg1.setImageResource(R.drawable.garbage);
                        tileView.addMarker( garbageImg1,500,500,null,null);
                    }
                    else {
                        tileView.removeMarker(garbageImg);
                        tileView.removeMarker(garbageImg1);
                    }
                case R.id.checkboxBaby:
                    if (checkBoxBaby.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        babyImg = new ImageView(getActivity());
                        babyImg.setImageResource(R.drawable.baby);
                        tileView.addMarker( babyImg, 500, 1000, null, null );

                    }
                    else {
                        tileView.removeMarker(babyImg);
                    }
                case R.id.checkboxSmoke:
                    if (checkBoxSomke.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        smokeImg = new ImageView(getActivity());
                        smokeImg.setImageResource(R.drawable.smoke);
                        tileView.addMarker( smokeImg, 500, 1000, null, null );

                    }
                    else {
                        tileView.removeMarker(smokeImg);
                    }
                case R.id.checkboxWatch:
                    if (checkBoxWatch.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        watchImg = new ImageView(getActivity());
                        watchImg.setImageResource(R.drawable.watch);
                        tileView.addMarker( watchImg, 500, 1000, null, null );

                    }
                    else {
                        tileView.removeMarker(watchImg);
                    }
                case R.id.checkboxCar:
                    if (checkBoxCar.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        carImg = new ImageView(getActivity());
                        carImg.setImageResource(R.drawable.car);
                        tileView.addMarker( carImg, 500, 1000, null, null );

                    }
                    else {
                        tileView.removeMarker(carImg);
                    }
                case R.id.checkboxNobathroom:
                    if (checkBoxNobathroom.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        nobathroomImg = new ImageView(getActivity());
                        nobathroomImg.setImageResource(R.drawable.nobathroom);
                        tileView.addMarker( nobathroomImg, 500, 1000, null, null );

                    }
                    else {
                        tileView.removeMarker(nobathroomImg);
                    }
                case R.id.checkboxNight:
                    if (checkBoxNight.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        nightImg = new ImageView(getActivity());
                        nightImg.setImageResource(R.drawable.night);
                        tileView.addMarker( nightImg, 500, 1000, null, null );

                    }
                    else {
                        tileView.removeMarker(nightImg);
                    }
                case R.id.checkboxLove:
                    if (checkBoxLove.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        loveImg = new ImageView(getActivity());
                        loveImg.setImageResource(R.drawable.love);
                        tileView.addMarker( loveImg, 500, 1000, null, null );

                    }
                    else {
                        tileView.removeMarker(loveImg);
                    }
                case R.id.checkboxSafe:
                    if (checkBoxSafe.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        safeImg = new ImageView(getActivity());
                        safeImg.setImageResource(R.drawable.safe);
                        tileView.addMarker( safeImg, 500, 1000, null, null );

                    }
                    else {
                        tileView.removeMarker(safeImg);
                    }
            }
        }
    };
//    private CheckBox.OnCheckedChangeListener checkListenerGarbage = new CompoundButton.OnCheckedChangeListener() {
//        @Override
//        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            switch (buttonView.getId()){
//                case R.id.checkboxGarbage:
//                    if (checkBoxGarbage.isChecked())
//                    {
//                        tileView = (TileView)getActivity().findViewById(R.id.tileView);
//
//                            garbageImg = new ImageView(getActivity());
//                            garbageImg.setImageResource(R.drawable.garbage);
//                            tileView.addMarker( garbageImg, 500, 1000, null, null );
//                            garbageImg1 = new ImageView(getActivity());
//                            garbageImg1.setImageResource(R.drawable.garbage);
//                            tileView.addMarker( garbageImg1,500,500,null,null);
//                    }
//                    else {
//
//                        tileView.removeMarker(garbageImg);
//                        tileView.removeMarker(garbageImg1);
//                    }
//            }
//        }
//    };
    public void addPin( double x, double y ) {
        tileView.addMarker( imageView, x, y, null, null );
    }

    private void removePin(ImageView imageView ){
        tileView.removeMarker(imageView);

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
