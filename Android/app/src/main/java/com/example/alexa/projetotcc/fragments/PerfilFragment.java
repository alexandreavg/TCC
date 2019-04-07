package com.example.alexa.projetotcc.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexa.projetotcc.R;
import com.example.alexa.projetotcc.TelaCadUsuarioActivity;

import androidx.fragment.app.Fragment;

public class PerfilFragment extends Fragment {

    private TextView editarPerfil;

    public static  PerfilFragment newInstance(){
        return new PerfilFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_perfil, container, false);

    }


    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editarPerfil = (TextView) view.findViewById(R.id.editarPerfil);

        editarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TelaCadUsuarioActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }
}
