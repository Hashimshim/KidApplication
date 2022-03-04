package com.example.kidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class NumberDetail extends AppCompatActivity {

    private SoundPool soundPool;
    String imageText[] = new String[]{
            "It's a bird.Birds sing.","It's a cat.Cats meow.","It's a dog.Dogs bark.",
            "It's a donkey.Donkeys bray.","It's a goose.Hooses honk.","It's a gorilla.Gorillas scream.",
            "It's a horse.Horses neigh.","It's a lion.Lions roar.","It's a gaur.Gaurs Moo.","Its an elephant.Elephants trumpet."
    };
    int imagesound[]=new int[]{
            R.raw.bird,R.raw.cat,R.raw.dog,
            R.raw.donkey,R.raw.goose,R.raw.gorilla,
            R.raw.horse,R.raw.lion,R.raw.gaur,R.raw.elephant
    };
    private int sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_detail);
        ImageView imageView = findViewById(R.id.imageView);
        TextView textView2 = findViewById(R.id.textView2);
        Intent i = getIntent();
        int position = i.getExtras().getInt("id");
        //load image
        ImageAdapter imageAdapter = new ImageAdapter(this);
        imageView.setImageResource(imageAdapter.imageArray[position]);
        textView2.setText(imageText[position]);
        //load sound
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound = soundPool.load(this, imagesound[position], 1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.w("tag", "clicked");
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                float volume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                soundPool.play(sound, volume, volume, 1, 0, 1f);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}