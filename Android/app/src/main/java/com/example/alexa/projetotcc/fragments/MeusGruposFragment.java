package com.example.alexa.projetotcc.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.alexa.projetotcc.R;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

public class MeusGruposFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> meuGrupo;

    public static  PerfilFragment newInstance(){
        return new PerfilFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // instanciar objetos
        meuGrupo = new ArrayList<>();
        meuGrupo.add("858585");
        meuGrupo.add("445");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meus_grupos, container, false);

        listView = (ListView) view.findViewById(R.id.list_meu_grupo);

        adapter = new ArrayAdapter(
                getActivity(),
                R.layout.lista_grupo,
                meuGrupo
        );
        listView.setAdapter(adapter);

        //Recuperar os grupos criados do banco de dados

        return  view;

    }
}
