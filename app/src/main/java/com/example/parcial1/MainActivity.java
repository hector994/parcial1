package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer reproductor;
    private ImageView imgPerfil, imgPlay, imgPause, imgStop, img1, img2, img3;
    public TextView titulo, cantante, descripcion;
    public String descripcion2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPerfil = (ImageView) findViewById(R.id.imageView);
        //imgPlay = (ImageView) findViewById(R.id.IvPlay);
        //imgPause = (ImageView) findViewById(R.id.IvPause);
        imgStop = (ImageView) findViewById(R.id.imageButton);

        img1 = (ImageView) findViewById(R.id.imageView2);
        img2 = (ImageView) findViewById(R.id.imageView3);
        img3 = (ImageView) findViewById(R.id.imageView4);


        titulo = (TextView) findViewById(R.id.textView2);
        cantante = (TextView) findViewById(R.id.textView3);
        descripcion = (TextView) findViewById(R.id.textView5);

        //Animacion de img
        animacion();

        //EventosListener
        imgPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.playerinc);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.robin);
                titulo.setText("Player in C");
                cantante.setText("Robin Schulz");
                descripcion2 = titulo+" - "+cantante;
                descripcion.setText(descripcion2);
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    if(reproductor.isPlaying()){
                        reproductor.release();
                        reproductor = null;
                    }
                }
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.qlona);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.qlona);
                titulo.setText("Qlona");
                cantante.setText("KAROL G");
                descripcion2 = titulo+" - "+cantante;
                descripcion.setText(descripcion2);
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
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.ellabailasola);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.pluma);
                titulo.setText("Ella baila sola");
                cantante.setText("Eslabon Armado");
                descripcion2 = titulo+" - "+cantante;
                descripcion.setText(descripcion2);
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
                reproductor = MediaPlayer.create(MainActivity.this, R.raw.nomeconoce);
                reproductor.start();
                imgPerfil.setImageResource(R.drawable.bad);
                titulo.setText("No me conoce");
                cantante.setText("Jhayco");
                descripcion2 = titulo+" - "+cantante;
                descripcion.setText(descripcion2);
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

    public void animacion(){
        //Animación de rotación
        RotateAnimation rotateAnimation = new RotateAnimation(
                0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        //Configurar la animación
        rotateAnimation.setInterpolator(new LinearInterpolator());
        //Duración en milisegundos
        rotateAnimation.setDuration(8000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);

        //Iniciar  animación
        imgPerfil.startAnimation(rotateAnimation);
    }
}