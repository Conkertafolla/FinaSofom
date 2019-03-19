package com.example.conke.avaluo;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link propertyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link propertyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class propertyFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText startDate;
    private EditText endDate;
    private EditText nameAcr;
    private EditText nameOfr;
    private EditText address;
    private TextView roomCount;
    private TextView floorCount;
    private TextView bathCount;
    private CheckBox isParking;
    private Button plusRoom;
    private Button plusBath;
    private Button plusFloor;
    private Button subRoom;
    private Button subFloor;
    private Button subBath;
    private Button preButton;

    Property propiedad = new Property("","","","","",0,0,0,false);



    private OnFragmentInteractionListener mListener;
    private FormActivity.ComunicacionInterfaz interfaz;

    public propertyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment propertyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static propertyFragment newInstance(String param1, String param2) {
        propertyFragment fragment = new propertyFragment();

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
        View view = inflater.inflate(R.layout.fragment_property, container, false);
        startDate = view.findViewById(R.id.date_start);
        startDate.setOnClickListener(this);
        endDate = view.findViewById(R.id.date_end);
        endDate.setOnClickListener(this);

        Button nextButton = view.findViewById(R.id.btn_next_property);
        nextButton.setOnClickListener(this);
        nameAcr = view.findViewById(R.id.name_reputable);
        nameOfr= view.findViewById(R.id.name_ofetent);
        address= view.findViewById(R.id.address);
        roomCount=view.findViewById(R.id.lblRoom);
        floorCount=view.findViewById(R.id.lblFloor);
        bathCount=view.findViewById(R.id.lblBath);
        isParking=view.findViewById(R.id.chkParking);
        isParking.setOnClickListener(this);
        plusRoom=view.findViewById(R.id.moreRoom);
        plusFloor=view.findViewById(R.id.moreFloor);
        plusBath=view.findViewById(R.id.moreBath);
        plusRoom.setOnClickListener(this);
        plusFloor.setOnClickListener(this);
        plusBath.setOnClickListener(this);
        subRoom=view.findViewById(R.id.lessRoom);
        subFloor=view.findViewById(R.id.lessFloor);
        subBath=view.findViewById(R.id.lessBath);
        subRoom.setOnClickListener(this);
        subFloor.setOnClickListener(this);
        subBath.setOnClickListener(this);
        preButton= view.findViewById(R.id.btn_prev_property);
        preButton.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
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

    @Override
    public void onClick(View v) {
        Fragment fragment;
        switch (v.getId()){
            case R.id.date_start:
                showDatePickerDialog(startDate);
                break;
            case R.id.date_end:
                showDatePickerDialog(endDate);
                break;
            case R.id.moreRoom:
                addRoom();
                break;
            case R.id.lessRoom:
                lessRoom();
                break;
            case R.id.moreFloor:
                addFloor();
                break;
            case R.id.lessFloor:
                lessFloor();
                break;
            case R.id.moreBath:
                addBath();
                break;
            case R.id.lessBath:
                lessBath();
                break;
            case R.id.chkParking:
                haveParking();
                break;
            case R.id.btn_next_property:
                setPropertyValues();
                break;
            case R.id.btn_prev_property:
                getFragmentManager().popBackStack();
                break;

        }
    }

    private void setPropertyValues() {
        propiedad.setAddress(address.getText().toString());
        propiedad.setNameReputable(nameAcr.getText().toString());
        propiedad.setNameOferent(nameOfr.getText().toString());
        propiedad.setStart(startDate.getText().toString());
        propiedad.setEnd(endDate.getText().toString());
        interfaz.getProperty(propiedad);
        interfaz.photoForm();
    }

    private void haveParking() {
        if(isParking.isChecked()){
            propiedad.setParking(true);
        }else{
            propiedad.setParking(false);
        }
    }

    private void addRoom() {
        propiedad.setRooms(propiedad.getRooms()+1);
        roomCount.setText(""+propiedad.getRooms());
    }

    private void lessRoom() {
        if (propiedad.getRooms()!=0){
            propiedad.setRooms(propiedad.getRooms()-1);
        }else{
            propiedad.setRooms(0);
        }
        roomCount.setText(""+propiedad.getRooms());
    }

    private void addFloor() {
        propiedad.setFloors(propiedad.getFloors()+1);
        floorCount.setText(""+propiedad.getFloors());
    }

    private void lessFloor() {
        if (propiedad.getFloors()!=0){
            propiedad.setFloors(propiedad.getFloors()-1);
        }else{
            propiedad.setRooms(0);
        }
        floorCount.setText(""+propiedad.getFloors());
    }

    private void addBath(){
        propiedad.setBathrooms(propiedad.getBathrooms()+1);
        bathCount.setText(""+propiedad.getBathrooms());
    }

    private void lessBath(){
        if(propiedad.getBathrooms()!=0){
            propiedad.setBathrooms(propiedad.getBathrooms()-1);
        }else{
            propiedad.setBathrooms(0);
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_cointainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void showDatePickerDialog(final EditText date) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = twoDigits(day) + "/" + twoDigits(month+1) + "/" + year;
                date.setText(selectedDate);
            }

            private String twoDigits(int n) {
                return (n<=9) ? ("0"+n) : String.valueOf(n);
            }
        });
        newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
    }

    public void setInterfaz(FormActivity.ComunicacionInterfaz interfaz) {
        this.interfaz = interfaz;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
