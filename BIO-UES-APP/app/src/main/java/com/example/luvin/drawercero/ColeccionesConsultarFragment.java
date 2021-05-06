package com.example.luvin.drawercero;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luvin.drawercero.Fragment_Tab_Colecciones_Cangrejos;
import com.example.luvin.drawercero.Fragment_Tab_Colecciones_MacroAlgas;
import com.example.luvin.drawercero.Fragment_Tab_Colecciones_MacroHongos;
import com.example.luvin.drawercero.Fragment_Tab_Colecciones_Moluscos;
import com.example.luvin.drawercero.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ColeccionesConsultarFragment extends Fragment {

    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;


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

        viewPager=(ViewPager)view.findViewById(R.id.pager);
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onDestroy() {
        appBar.removeView(tabs);
        super.onDestroy();
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {


        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
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
                case 2:
                    Fragment_Tab_Colecciones_Cangrejos fragment_tab_ColeccionesCangrejos =new Fragment_Tab_Colecciones_Cangrejos();
                    return fragment_tab_ColeccionesCangrejos;
                case 3:
                    Fragment_Tab_Colecciones_MacroAlgas fragment_tab_coleccionesMacroAlgas =new Fragment_Tab_Colecciones_MacroAlgas();
                    return fragment_tab_coleccionesMacroAlgas;
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
                    String tab_text_1=("Moluscos");
                    return tab_text_1;
                case 1:
                    String tab_text_2=("MacroHongos");
                    return tab_text_2;
                case 2:
                    String tab_text_3=("Cangrejos");
                    return tab_text_3;
                case 3:
                    String tab_text_4=("MacroAlgas");
                    return tab_text_4;
            }


            return super.getPageTitle(position);
        }
    }
}
