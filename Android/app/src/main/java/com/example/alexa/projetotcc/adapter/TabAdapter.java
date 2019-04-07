package com.example.alexa.projetotcc.adapter;

import com.example.alexa.projetotcc.fragments.GruposFragment;
import com.example.alexa.projetotcc.fragments.MeusGruposFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabAdapter extends FragmentStatePagerAdapter {

    private String[] tituloAbas = {"FAVORITOS","GRUPOS" };

    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new MeusGruposFragment();
                break;

            case 1:
                fragment = new GruposFragment();
                break;
        }

        return null;
    }

    @Override
    public int getCount() {
        return tituloAbas.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tituloAbas[position];
    }
}
