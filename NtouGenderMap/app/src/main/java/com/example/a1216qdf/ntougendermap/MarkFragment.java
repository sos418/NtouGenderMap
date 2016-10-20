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
    public ImageView bathroomImg,bathroomImg1,bathroomImg2,bathroomImg3,bathroomImg4,bathroomImg5,bathroomImg6,bathroomImg7,bathroomImg8,bathroomImg9,bathroomImg10
            ,waterImg,waterImg1,waterImg2,waterImg3,waterImg4,waterImg5,waterImg6;
    public ImageView garbageImg,garbageImg1;
    public ImageView babyImg,smokeImg,watchImg,watchImg1,watchImg2,carImg,nobathroomImg,nobathroomImg1,nightImg,nightImg1,loveImg,safeImg;


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
                        bathroomImg.setImageResource(R.drawable.mbathroom);
                        bathroomImg1 = new ImageView(getActivity());
                        bathroomImg1.setImageResource(R.drawable.mbathroom);
                        bathroomImg2 = new ImageView(getActivity());
                        bathroomImg2.setImageResource(R.drawable.mbathroom);
                        bathroomImg3 = new ImageView(getActivity());
                        bathroomImg3.setImageResource(R.drawable.mbathroom);
                        bathroomImg4 = new ImageView(getActivity());
                        bathroomImg4.setImageResource(R.drawable.mbathroom);
                        bathroomImg5 = new ImageView(getActivity());
                        bathroomImg5.setImageResource(R.drawable.mbathroom);
                        bathroomImg6 = new ImageView(getActivity());
                        bathroomImg6.setImageResource(R.drawable.mbathroom);
                        bathroomImg7 = new ImageView(getActivity());
                        bathroomImg7.setImageResource(R.drawable.mbathroom);
                        bathroomImg8 = new ImageView(getActivity());
                        bathroomImg8.setImageResource(R.drawable.mbathroom);
                        bathroomImg9 = new ImageView(getActivity());
                        bathroomImg9.setImageResource(R.drawable.mbathroom);
                        bathroomImg10 = new ImageView(getActivity());
                        bathroomImg10.setImageResource(R.drawable.mbathroom);
                        tileView.addMarker( bathroomImg, 150, 1865, null, null );
                        tileView.addMarker( bathroomImg1, 350, 1373, null, null );
                        tileView.addMarker( bathroomImg2, 300, 1325, null, null );
                        tileView.addMarker( bathroomImg3, 515, 1307, null, null );
                        tileView.addMarker( bathroomImg4, 100, 1440, null, null );
                        tileView.addMarker( bathroomImg5, 550, 677, null, null );
                        tileView.addMarker( bathroomImg6, 860, 1325, null, null );
                        tileView.addMarker( bathroomImg7, 720, 2057, null, null );
                        tileView.addMarker( bathroomImg8, 730, 2400, null, null );
                        tileView.addMarker( bathroomImg9, 1400, 2490, null, null );
                        tileView.addMarker( bathroomImg10, 1320, 2735, null, null );
                    }
                    else {
                        removePin(bathroomImg);
                        removePin(bathroomImg1);
                        removePin(bathroomImg2);
                        removePin(bathroomImg3);
                        removePin(bathroomImg4);
                        removePin(bathroomImg5);
                        removePin(bathroomImg6);
                        removePin(bathroomImg7);
                        removePin(bathroomImg8);
                        removePin(bathroomImg9);
                        removePin(bathroomImg10);

                    }
                    break;
                case R.id.checkboxWater:
                    if (checkBoxWater.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        waterImg = new ImageView(getActivity());
                        waterImg.setImageResource(R.drawable.mwater);
                        waterImg1 = new ImageView(getActivity());
                        waterImg1.setImageResource(R.drawable.mwater);
                        waterImg2 = new ImageView(getActivity());
                        waterImg2.setImageResource(R.drawable.mwater);
                        waterImg3 = new ImageView(getActivity());
                        waterImg3.setImageResource(R.drawable.mwater);
                        waterImg4 = new ImageView(getActivity());
                        waterImg4.setImageResource(R.drawable.mwater);
                        waterImg5 = new ImageView(getActivity());
                        waterImg5.setImageResource(R.drawable.mwater);
                        waterImg6 = new ImageView(getActivity());
                        waterImg6.setImageResource(R.drawable.mwater);
                        tileView.addMarker( waterImg, 160, 1865, null, null );
                        tileView.addMarker( waterImg1, 360, 1673, null, null );
                        tileView.addMarker( waterImg2, 310, 1325, null, null );
                        tileView.addMarker( waterImg3, 555, 1307, null, null );
                        tileView.addMarker( waterImg4, 760, 2057, null, null );
                        tileView.addMarker( waterImg5, 740, 2400, null, null );
                        tileView.addMarker( waterImg6, 1410, 2490, null, null );
                    }
                    else {
                        removePin(waterImg);
                        removePin(waterImg1);
                        removePin(waterImg2);
                        removePin(waterImg3);
                        removePin(waterImg4);
                        removePin(waterImg5);
                        removePin(waterImg6);
                    }
                    break;
                case R.id.checkboxGarbage:
                    if (checkBoxGarbage.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        garbageImg = new ImageView(getActivity());
                        garbageImg.setImageResource(R.drawable.mgarbage);
                        tileView.addMarker( garbageImg, 350, 1683, null, null );
                        garbageImg1 = new ImageView(getActivity());
                        garbageImg1.setImageResource(R.drawable.mgarbage);
                        tileView.addMarker( garbageImg1,600,2780,null,null);
                    }
                    else {
                        tileView.removeMarker(garbageImg);
                        tileView.removeMarker(garbageImg1);
                    }
                    break;
                case R.id.checkboxBaby:
                    if (checkBoxBaby.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        babyImg = new ImageView(getActivity());
                        babyImg.setImageResource(R.drawable.mbaby);
                        tileView.addMarker( babyImg, 1315, 2730, null, null );

                    }
                    else {
                        tileView.removeMarker(babyImg);
                    }
                    break;
                case R.id.checkboxSmoke:
                    if (checkBoxSomke.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        smokeImg = new ImageView(getActivity());
                        smokeImg.setImageResource(R.drawable.msmoke);
                        tileView.addMarker( smokeImg, 110, 1846, null, null );

                    }
                    else {
                        tileView.removeMarker(smokeImg);
                    }
                    break;
                case R.id.checkboxWatch:
                    if (checkBoxWatch.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        watchImg = new ImageView(getActivity());
                        watchImg.setImageResource(R.drawable.mwatch);
                        watchImg1 = new ImageView(getActivity());
                        watchImg1.setImageResource(R.drawable.mwatch);
                        watchImg2 = new ImageView(getActivity());
                        watchImg2.setImageResource(R.drawable.mwatch);
                        tileView.addMarker( watchImg, 975, 1519, null, null );
                        tileView.addMarker( watchImg1, 525, 1307, null, null );
                        tileView.addMarker( watchImg2, 1305, 2730, null, null );
                    }
                    else {
                        tileView.removeMarker(watchImg);
                        tileView.removeMarker(watchImg1);
                        tileView.removeMarker(watchImg2);
                    }
                    break;
                case R.id.checkboxCar:
                    if (checkBoxCar.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        carImg = new ImageView(getActivity());
                        carImg.setImageResource(R.drawable.mcar);
                        tileView.addMarker( carImg, 1291, 1577, null, null );

                    }
                    else {
                        tileView.removeMarker(carImg);
                    }
                    break;
                case R.id.checkboxNobathroom:
                    if (checkBoxNobathroom.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        nobathroomImg = new ImageView(getActivity());
                        nobathroomImg.setImageResource(R.drawable.mnobathroom);
                        nobathroomImg1 = new ImageView(getActivity());
                        nobathroomImg1.setImageResource(R.drawable.mnobathroom);
                        tileView.addMarker( nobathroomImg, 320, 1800, null, null );
                        tileView.addMarker( nobathroomImg1, 515, 1317, null, null );
                    }
                    else {
                        tileView.removeMarker(nobathroomImg);
                        tileView.removeMarker(nobathroomImg1);

                    }
                    break;
                case R.id.checkboxNight:
                    if (checkBoxNight.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        nightImg = new ImageView(getActivity());
                        nightImg.setImageResource(R.drawable.mnight);
                        nightImg1 = new ImageView(getActivity());
                        nightImg1.setImageResource(R.drawable.mnight);
                        tileView.addMarker( nightImg, 90, 1926, null, null );
                        tileView.addMarker( nightImg1, 417, 1865, null, null );
                    }
                    else {
                        tileView.removeMarker(nightImg);
                        tileView.removeMarker(nightImg1);
                    }
                    break;
                case R.id.checkboxLove:
                    if (checkBoxLove.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        loveImg = new ImageView(getActivity());
                        loveImg.setImageResource(R.drawable.mlove);
                        tileView.addMarker( loveImg, 110, 1440, null, null );

                    }
                    else {
                        tileView.removeMarker(loveImg);
                    }
                    break;
                case R.id.checkboxSafe:
                    if (checkBoxSafe.isChecked())
                    {
                        tileView = (TileView)getActivity().findViewById(R.id.tileView);

                        safeImg = new ImageView(getActivity());
                        safeImg.setImageResource(R.drawable.msafe);
                        tileView.addMarker( safeImg, 150, 1855, null, null );

                    }
                    else {
                        tileView.removeMarker(safeImg);
                    }
                    break;
            }
        }
    };


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
