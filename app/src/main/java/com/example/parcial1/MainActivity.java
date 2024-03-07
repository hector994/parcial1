package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer reproductor;
    private ImageView imgPerfil, imgPlay, imgPause, imgStop, img1, img2, img3, img4, img5;
    private TextView titulo, cantante, descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPerfil = (ImageView) findViewById(R.id.imageView);
        imgPlay = (ImageView) findViewById(R.id.IvPlay);
        imgPause = (ImageView) findViewById(R.id.IvPause);
        imgStop = (ImageView) findViewById(R.id.IvStop);

        img1 = (ImageView) findViewById(R.id.imgv1);
        img2 = (ImageView) findViewById(R.id.imgv2);
        img3 = (ImageView) findViewById(R.id.imgv3);
        img4 = (ImageView) findViewById(R.id.imgv4);
        img5 = (ImageView) findViewById(R.id.imgv5);

        titulo = (TextView) findViewById(R.id.tvTituloCancion);
        cantante = (TextView) findViewById(R.id.tvCantante);
        descripcion = (TextView) findViewById(R.id.tvDescripcionCancion);

        //Animacion de img
        animacion();

        //EventosListener
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.killpop);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.img1);
                titulo.setText("Killpop");
                cantante.setText("Slipknot");
                descripcion.setText("SLIPKNOT - KILLPOP");
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.paris);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.img2);
                titulo.setText("Paris");
                cantante.setText("$uicideBoys");
                descripcion.setText("$UICIDEBOYS - PARIS");
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.mercury);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.img3);
                titulo.setText("Mercury");
                cantante.setText("Ghostemane");
                descripcion.setText("GHOSTEMANE - MERCURY");
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.rockstart);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.img4);
                titulo.setText("Rockstart");
                cantante.setText("Post Malone");
                descripcion.setText("POST MALONE - ROCKSTART");
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.engel);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.img5);
                titulo.setText("Engel");
                cantante.setText("Rammstein");
                descripcion.setText("RAMMSTEIN - ENGEL");
            }
        });
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    reproductor.start();
                    imgStop.setVisibility(View.VISIBLE);
                    imgPause.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "No hay cancion en la lista", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imgStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    reproductor.seekTo(000);
                    reproductor.pause();
                    imgStop.setVisibility(View.INVISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "No hay cancion en la lista", Toast.LENGTH_SHORT).show();
                }
            }
        });
        imgPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    reproductor.pause();
                    imgPause.setVisibility(View.INVISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "No hay cancion en la lista", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}