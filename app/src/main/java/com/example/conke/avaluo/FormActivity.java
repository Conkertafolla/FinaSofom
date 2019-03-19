package com.example.conke.avaluo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FormActivity extends AppCompatActivity implements
        ClientFragment.OnFragmentInteractionListener,
        propertyFragment.OnFragmentInteractionListener,
        PhotoFragment.OnFragmentInteractionListener,
        noteFragment.OnFragmentInteractionListener{
    ClientFragment clientFragment;


    private Client client = new Client();
    private Property property = new Property();
    private String imagePath = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        clientFragment = new ClientFragment();
        clientFragment.setInterfaz(interfaz);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_cointainer,clientFragment).commit();

    }

    public interface ComunicacionInterfaz{
         void getClient(Client cliente);
         void propertyForm();
         void photoForm();
         void getProperty(Property property);
         void getPhotoPath(String path);
         void goNote();
         Property setProperty();
         Client setClient();
         String setPath();


    }

    private ComunicacionInterfaz interfaz = new ComunicacionInterfaz(){

        @Override
        public void getClient(Client cliente) {
            client = cliente;
        }

        @Override
        public void propertyForm() {
            propertyFragment propertyFragment = new propertyFragment();
            propertyFragment.setInterfaz(interfaz);
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_cointainer,propertyFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }

        @Override
        public void photoForm() {
            PhotoFragment photoFragment= new PhotoFragment();
            photoFragment.setInterfaz(interfaz);
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_cointainer,photoFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }

        @Override
        public void getProperty(Property propiedad) {
            property = propiedad;

        }

        @Override
        public void getPhotoPath(String path) {
            imagePath=path;
        }

        @Override
        public void goNote() {
            noteFragment noteFragment= new noteFragment();
            noteFragment.setInterfaz(interfaz);
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_cointainer,noteFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }

        @Override
        public Property setProperty() {
            return property;
        }

        @Override
        public Client setClient() {
            return client;
        }

        @Override
        public String setPath() {
            return imagePath;
        }

    };



    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
