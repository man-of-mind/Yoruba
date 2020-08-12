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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FamilyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FamilyFragment extends Fragment {

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

    private void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(changeListener);
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FamilyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FamilyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FamilyFragment newInstance(String param1, String param2) {
        FamilyFragment fragment = new FamilyFragment();
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

        final ArrayList<Word> families = new ArrayList<Word>();

        families.add(new Word("Mother", "Iya", R.drawable.family_mother,
                R.raw.mother));
        families.add(new Word("Father", "Baba", R.drawable.family_father,
                R.raw.father));
        families.add(new Word("Older Brother", "Egbon okunrin",
                R.drawable.family_older_brother, R.raw.olderbrother));
        families.add(new Word("Older Sister", "Egbon obinrin",
                R.drawable.family_older_sister, R.raw.oldersister));
        families.add(new Word("Daughter", "Omọbinrin",
                R.drawable.family_daughter, R.raw.daughter));
        families.add(new Word("Son", "Omọkunrin", R.drawable.family_son,
                R.raw.son));
        families.add(new Word("Grandfather", "Baba agba",
                R.drawable.family_grandfather, R.raw.granddad));
        families.add(new Word("Grandmother", "Iya agba",
                R.drawable.family_grandmother, R.raw.grand));
        families.add(new Word("Younger Brother", "Aburo okunrin",
                R.drawable.family_younger_brother, R.raw.youngerbrother));
        families.add(new Word("Younger Sister", "Aburo obinrin",
                R.drawable.family_younger_sister, R.raw.youngersister));


        WordAdapter familyAdapter = new WordAdapter(getActivity(), 0, families, R.color.family_color);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(familyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = families.get(position);
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
}