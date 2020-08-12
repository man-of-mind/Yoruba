package com.example.yoruba;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhrasesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhrasesFragment extends Fragment {

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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PhrasesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PhrasesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PhrasesFragment newInstance(String param1, String param2) {
        PhrasesFragment fragment = new PhrasesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.list_item, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> phrases = new ArrayList<Word>();

        phrases.add(new Word("Good morning", "Ekaaro", R.raw.morning));
        phrases.add(new Word("How are you?", "Bawo ni o se wa?", R.raw.hwareu));
        phrases.add(new Word("Where are you going?", "Nibo ni iwon lo?", R.raw.whereugoing));
        phrases.add(new Word("What is your name?", "Ki 'ni oruko re?", R.raw.urname));
        phrases.add(new Word("My name is...", "Orukọ mi ni...", R.raw.myname));
        phrases.add(new Word("I am feeling good", "Ara mi ya", R.raw.mgood));
        phrases.add(new Word("Are you coming?", "Se o n bọ?", R.raw.ucoming));
        phrases.add(new Word("Yes, I'm coming", "Bẹẹni, mo n bọ", R.raw.mcoming));



        WordAdapter phrasesAdapter = new WordAdapter(getActivity(), 0, phrases, R.color.phrases_color);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(phrasesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = phrases.get(position);
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(changeListener, AudioManager.
                        STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(mCompleteMedia);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
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