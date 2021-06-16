package com.example.luvin.drawercero.Coleccion;

import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;

import com.example.luvin.drawercero.R;
import com.example.luvin.drawercero.tabsColeccionNoUsables.Fragment_Tab_Colecciones_Cangrejos;
import com.example.luvin.drawercero.tabsColeccionNoUsables.Fragment_Tab_Colecciones_MacroAlgas;
import com.example.luvin.drawercero.tabsColeccionNoUsables.Fragment_Tab_Colecciones_MacroHongos;
import com.example.luvin.drawercero.tabsColeccionNoUsables.Fragment_Tab_Colecciones_Moluscos;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;


/**
 *  * A simple {@link Fragment} subclass.
 */
public class ColeccionesConsultarFragment extends Fragment {

    private AppBarLayout appBar;
    private TabLayout tabs;



    public ColeccionesConsultarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_colecciones, container, false);

        View contenedor=(View)container.getParent();
        appBar=(AppBarLayout)contenedor.findViewById(R.id.appbar);
        tabs=new TabLayout(getActivity());

        tabs.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#FFFFFF"));
        appBar.addView(tabs);
        MyAdapter mAdapter;
        ViewPager viewPager;

        viewPager=(ViewPager)view.findViewById(R.id.pager);
        mAdapter = new MyAdapter(getFragmentManager());
        viewPager.setAdapter(mAdapter);
        tabs.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onDestroy() {
        appBar.removeView(tabs);
        super.onDestroy();
    }

    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }


        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    Fragment_Tab_Colecciones_Moluscos fragment_tab_coleccionesMoluscos =new Fragment_Tab_Colecciones_Moluscos();
                    return fragment_tab_coleccionesMoluscos;
                case 1:
                    Fragment_Tab_Colecciones_MacroHongos fragment_tab_colecciones_MacroHongos=new Fragment_Tab_Colecciones_MacroHongos();
                    return fragment_tab_colecciones_MacroHongos;
            }


            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    String tab_text_1=("Insertar");
                    return tab_text_1;
                case 1:
                    String tab_text_2=("Consultar");
                    return tab_text_2;

            }


            return super.getPageTitle(position);
        }
    }
}
