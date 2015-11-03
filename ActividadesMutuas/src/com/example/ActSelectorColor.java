package com.example;

import com.ies.R;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class ActSelectorColor extends ActionBarActivity
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    public static int GET_COLOR = 0;
    public static String azulInicial = "com.example.actividadesmutuas.azulInicial";
    public static String colorElegido = "com.example.actividadesmutuas.colorElegido";
    public static String rojoInicial = "com.example.actividadesmutuas.rojoInicial";
    public static String verdeInicial = "com.example.actividadesmutuas.verdeInicial";
    SeekBar sbAzul;
    SeekBar sbRojo;
    SeekBar sbVerde;
    SurfaceView supMuestra;
    TextView tvAzul;
    TextView tvRojo;
    TextView tvVerde;

    public ActSelectorColor()
    {
    }

    private void conectarConBarra(int i)
    {
        ((SeekBar)findViewById(i)).setOnSeekBarChangeListener(this);
    }

    private void modificarMuestra()
    {
        int i = getColorSeleccionado();
        supMuestra.setBackgroundColor(i);
    }

    public int getColorSeleccionado()
    {
        return Color.rgb(sbRojo.getProgress(), sbVerde.getProgress(), sbAzul.getProgress());
    }

    public void onColorSeleccionado(View view)
    {
        int i = getColorSeleccionado();
        Intent intent = new Intent();
        intent.putExtra(colorElegido, i);
        setResult(-1, intent);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.act_seleccion_color);
        supMuestra = (SurfaceView)findViewById(0x7f09004e);
        sbRojo = (SeekBar)findViewById(0x7f090044);
        sbVerde = (SeekBar)findViewById(0x7f090048);
        sbAzul = (SeekBar)findViewById(0x7f09004c);
        tvRojo = (TextView)findViewById(0x7f090045);
        tvVerde = (TextView)findViewById(0x7f090049);
        tvAzul = (TextView)findViewById(0x7f09004d);
        conectarConBarra(0x7f090044);
        conectarConBarra(0x7f090048);
        conectarConBarra(0x7f09004c);
        procesarIntentPasado();
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        int j = seekbar.getProgress();
        if (seekbar == sbRojo)
        {
            tvRojo.setText((new StringBuilder()).append(j).toString());
        }
        if (seekbar == sbVerde)
        {
            tvVerde.setText((new StringBuilder()).append(j).toString());
        }
        if (seekbar == sbAzul)
        {
            tvAzul.setText((new StringBuilder()).append(j).toString());
        }
        modificarMuestra();
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
    }

    public void procesarIntentPasado()
    {
        Intent intent = getIntent();
        int i = intent.getIntExtra(rojoInicial, 0);
        int j = intent.getIntExtra(verdeInicial, 0);
        int k = intent.getIntExtra(azulInicial, 0);
        setR(i);
        setG(j);
        setB(k);
    }

    public void setB(int i)
    {
        setColor(sbAzul, tvAzul, i);
    }

    public void setColor(SeekBar seekbar, TextView textview, int i)
    {
        if (i < 0)
        {
            i = 0;
        }
        if (i > 255)
        {
            i = 255;
        }
        seekbar.setProgress(i);
        textview.setText((new StringBuilder()).append(i).toString());
    }

    public void setG(int i)
    {
        setColor(sbVerde, tvVerde, i);
    }

    public void setR(int i)
    {
        setColor(sbRojo, tvRojo, i);
    }

}