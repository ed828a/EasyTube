package com.ed828a.android.easytube;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class PageActivity extends YouTubeBaseActivity {

    private static final String TAG = PageActivity.class.getSimpleName();

    YouTubePlayerView mYouTubePlayerView;
    Button mPlayButton;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        Log.d(TAG, "onCreate: Starting.");

        mPlayButton = (Button) findViewById(R.id.youtube_play_button);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onInitialization: Done Successfully.");
//                List<String> videoList = new ArrayList<>();
//                videoList.add("nQwkCb_eq50");
//                videoList.add("2duc77R4Hqw");
//                youTubePlayer.loadVideos(videoList);
                youTubePlayer.loadPlaylist("PLgCYzUzKIBE8TUoCyjomGFqzTFcJ05OaC");
//                youTubePlayer.loadVideo("2duc77R4Hqw");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitialization: Failed to initialize.");
            }
        };

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Initializing YouTube Player.");
                mYouTubePlayerView.initialize("AIzaSyCHpsnT8P7cfCGz7ujRM1uri2i_rHEs3m4", mOnInitializedListener);
            }
        });
    }
}
