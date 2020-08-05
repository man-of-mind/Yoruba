package com.example.yoruba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    MediaPlayer.OnCompletionListener mCompleteMedia = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener changeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.
                    AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> phrases = new ArrayList<Word>();

        phrases.add(new Word("Good morning", "Ekaaro", R.raw.morning));
        phrases.add(new Word("How are you?", "Bawo ni o se wa?", R.raw.hwareu));
        phrases.add(new Word("Where are you going?", "Nibo ni iwon lo?", R.raw.whereugoing));
        phrases.add(new Word("What is your name?", "Ki 'ni oruko re?", R.raw.urname));
        phrases.add(new Word("My name is...", "Orukọ mi ni...", R.raw.myname));
        phrases.add(new Word("I am feeling good", "Ara mi ya", R.raw.mgood));
        phrases.add(new Word("Are you coming?", "Se o n bọ?", R.raw.ucoming));
        phrases.add(new Word("Yes, I'm coming", "Bẹẹni, mo n bọ", R.raw.mcoming));



        WordAdapter phrasesAdapter = new WordAdapter(this, 0, phrases, R.color.phrases_color);
        ListView listView = (ListView) findViewById(R.id.phrases);
        listView.setAdapter(phrasesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = phrases.get(position);
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(changeListener, AudioManager.
                        STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mMediaPlayer = MediaPlayer.create(getApplicationContext(), word.getAudioResourceId());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompleteMedia);
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(changeListener);
        }
    }
}