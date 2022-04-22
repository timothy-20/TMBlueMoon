package com.example.tmbluemoon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    //FragmentView 맴버 변수 정의할 것.


    private Menu internalMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = this.fragmentManager.beginTransaction();
//        fragmentTransaction.replace();

        BottomNavigationView bottomNavigationView = this.findViewById(R.id.tm_view_menu);
        bottomNavigationView.setOnCreateContextMenuListener(new TMBottomNavigationViewController());
        bottomNavigationView.setOnItemSelectedListener(new TMBottomNavigationSelectController());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        System.out.println("[MainActivity] Create option argument menu: " + menu);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.tm_bottom_menu, menu);
        this.internalMenu = menu;

//        System.out.println("[MainActivity] Create option inflated menu: " + menu);

        for (int idx = 0; idx < this.internalMenu.size(); idx++) {
            MenuItem item = this.internalMenu.getItem(idx);
            Drawable itemDrawable = item.getIcon();

            if (itemDrawable != null) {
                itemDrawable.mutate();
                itemDrawable.setColorFilter(getResources().getColor(R.color.tm_bottom_menu_color), PorterDuff.Mode.SRC_ATOP);
//                itemDrawable.setColorFilter(Color.parseColor("#55ff0000"), PorterDuff.Mode.SRC_ATOP);
            }
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tm_info_page:

                break;

            case R.id.tm_search_page:

                break;

            case R.id.tm_user_page:

                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public class TMBottomNavigationViewController implements BottomNavigationView.OnCreateContextMenuListener {
        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            for (int idx = 0; idx < contextMenu.size(); idx++) {
                Drawable menuIcon = contextMenu.getItem(idx).getIcon();

                if (menuIcon != null) {
                    menuIcon.mutate();
                    menuIcon.setColorFilter(getResources().getColor(R.color.tm_bottom_menu_color), PorterDuff.Mode.SRC_ATOP);
                }
            }
        }
    }

    public class TMBottomNavigationSelectController implements BottomNavigationView.OnItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.tm_info_page:
                    break;

                case R.id.tm_search_page:
                    break;

                case R.id.tm_user_page:
                    break;

            }

            return false;
        }
    }
}

