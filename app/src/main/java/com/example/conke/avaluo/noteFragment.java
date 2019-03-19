package com.example.conke.avaluo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link noteFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link noteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class noteFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView name;
    private TextView mail;
    private TextView phone;
    private TextView accreditado;
    private TextView oferente;
    private TextView direccion;
    private TextView habitaciones;
    private TextView banios;
    private TextView niveles;
    private TextView estacionamiento;
    private TextView inicio;
    private TextView fin;
    private Button save;
    private ImageView image;
    private Property propiedad;
    private Client cliente;
    private String imageRoute;

    private OnFragmentInteractionListener mListener;
    private FormActivity.ComunicacionInterfaz interfaz;

    public noteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment noteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static noteFragment newInstance(String param1, String param2) {
        noteFragment fragment = new noteFragment();
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_note, container, false);
        name=view.findViewById(R.id.not_name);
        mail=view.findViewById(R.id.not_mail);
        phone=view.findViewById(R.id.not_phone);
        accreditado=view.findViewById(R.id.not_accr);
        oferente=view.findViewById(R.id.not_Ofer);
        banios=view.findViewById(R.id.not_bath);
        habitaciones=view.findViewById(R.id.not_room);
        niveles=view.findViewById(R.id.not_floor);
        estacionamiento=view.findViewById(R.id.not_parking);
        direccion= view.findViewById(R.id.not_add);
        inicio=view.findViewById(R.id.not_start);
        fin=view.findViewById(R.id.not_end);
        image=view.findViewById(R.id.not_image);
        save=view.findViewById(R.id.not_button);
        save.setOnClickListener(this);
        obtainObjects();
        setLabels();
        return view;
    }

    private void setLabels() {
        name.setText(cliente.getName());
        mail.setText(cliente.getEmail());
        phone.setText(cliente.getNumber());
        accreditado.setText(propiedad.getNameReputable());
        oferente.setText(propiedad.getNameOferent());
        direccion.setText(propiedad.getAddress());
        habitaciones.setText(String.valueOf(propiedad.getRooms()));
        banios.setText(String.valueOf(propiedad.getBathrooms()));
        niveles.setText(String.valueOf(propiedad.getFloors()));
        if(propiedad.isParking()){
            estacionamiento.setText("Si");
        }else{
            estacionamiento.setText("No");
        }
        inicio.setText(propiedad.getStart());
        fin.setText(propiedad.getEnd());
        Bitmap bitmap = BitmapFactory.decodeFile(imageRoute);
        image.setImageBitmap(bitmap);



    }

    private void obtainObjects() {
        propiedad = interfaz.setProperty();
        cliente = interfaz.setClient();
        imageRoute = interfaz.setPath();
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

    public void setInterfaz(FormActivity.ComunicacionInterfaz interfaz) {
        this.interfaz = interfaz;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        case R.id.not_button:
        goPrincipal();
        break;
        }

    }

    private void goPrincipal() {
        Intent intent = new Intent(getActivity(), FormActivity.class);
        getActivity().startActivity(intent);
        Toast.makeText(getContext(),"Registro guardado",Toast.LENGTH_LONG).show();
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
