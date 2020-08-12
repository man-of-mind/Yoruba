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
 * Use the {@link ColorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ColorFragment extends Fragment {

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

    public ColorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ColorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ColorFragment newInstance(String param1, String param2) {
        ColorFragment fragment = new ColorFragment();
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

        final ArrayList<Word> colors = new ArrayList<Word>()  ;

        colors.add(new Word("White", "Funfun", R.drawable.color_white,
                R.raw.white));
        colors.add(new Word("Black", "Dudu", R.drawable.color_black,
                R.raw.black));
        colors.add(new Word("Red", "Pupa", R.drawable.color_red,
                R.raw.red));
        colors.add(new Word("Brown", "Àwọ̀ igi", R.drawable.color_brown,
                R.raw.brown));
        colors.add(new Word("Dusty Yellow", "Awo ofeefee",
                R.drawable.color_dusty_yellow, R.raw.awoofeefee));
        colors.add(new Word("Green", "Àwọ̀ Ewé", R.drawable.color_green
                , R.raw.green));
        colors.add(new Word("Gray", "Awọ eeru", R.drawable.color_gray,
                R.raw.gray));
        colors.add(new Word("Mustard Yellow", "ofeefee",
                R.drawable.color_mustard_yellow, R.raw.ofeefee));


        WordAdapter colorColorAdapter = new WordAdapter(getActivity(), 0, colors, R.color.color_color);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(colorColorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = colors.get(position);
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
    private void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(changeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}