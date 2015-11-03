package com.example;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;


public class MainActivity extends ActionBarActivity
{

    public MainActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == ActSelectorColor.GET_COLOR && j == -1)
        {
            int k = intent.getIntExtra(ActSelectorColor.colorElegido, 0);
            ((SurfaceView)findViewById(0x7f090051)).setBackgroundColor(k);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030018);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0c0000, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f090052)
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void seleccionar(View view)
    {
        Intent intent = new Intent(this, com.example.ActSelectorColor.class);
        intent.putExtra(ActSelectorColor.rojoInicial, 80);
        intent.putExtra(ActSelectorColor.verdeInicial, 133);
        intent.putExtra(ActSelectorColor.azulInicial, 2433);
        startActivityForResult(intent, ActSelectorColor.GET_COLOR);
    }
}
