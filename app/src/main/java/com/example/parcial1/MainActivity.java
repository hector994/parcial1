package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer reproductor;
    private ImageView imgPerfil, img1, img2, img3;

    private ImageButton imgPlay, imgP1, imgP2, imgP3;
    public TextView titulo, cantante, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPerfil = (ImageView) findViewById(R.id.imageView);
        imgPlay = (ImageButton) findViewById(R.id.imageButton);

        imgP1 = (ImageButton) findViewById(R.id.imageButton2);
        imgP2 = (ImageButton) findViewById(R.id.imageButton3);
        imgP3 = (ImageButton) findViewById(R.id.imageButton4);

        img1 = (ImageView) findViewById(R.id.imageView2);
        img2 = (ImageView) findViewById(R.id.imageView3);
        img3 = (ImageView) findViewById(R.id.imageView4);

        imgPerfil.setImageResource(R.drawable.robin);
        img1.setImageResource(R.drawable.qlona);
        img2.setImageResource(R.drawable.pluma);
        img3.setImageResource(R.drawable.bad);

        titulo = (TextView) findViewById(R.id.textView2);
        cantante = (TextView) findViewById(R.id.textView3);
        descripcion = (TextView) findViewById(R.id.textView5);

        //Animacion de img
        animacion();

        //EventosListener
        imgPlay.setOnClickListener(new View.OnClickListener() {
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
                descripcion.setText("Player in C - Robin");

            }
        });
        imgP1.setOnClickListener(new View.OnClickListener() {
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
                descripcion.setText("QLONA - Karol g");
            }
        });
        imgP2.setOnClickListener(new View.OnClickListener() {
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
                descripcion.setText("Ella baila sola - Eslabon Armado");
            }
        });
        imgP3.setOnClickListener(new View.OnClickListener() {
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
                descripcion.setText("no me conoce");
            }
        });

        imgPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    reproductor.pause();
                }else{
                    Toast.makeText(MainActivity.this, "No hay cancion en la lista", Toast.LENGTH_SHORT).show();
                }
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    reproductor.seekTo(000);
                    reproductor.start();
                }else{
                    Toast.makeText(MainActivity.this, "No hay cancion en la lista", Toast.LENGTH_SHORT).show();
                }
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    reproductor.seekTo(000);
                    reproductor.start();
                }else{
                    Toast.makeText(MainActivity.this, "No hay cancion en la lista", Toast.LENGTH_SHORT).show();
                }
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reproductor != null){
                    reproductor.seekTo(000);
                    reproductor.start();
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