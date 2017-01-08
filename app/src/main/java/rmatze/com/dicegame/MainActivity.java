package rmatze.com.dicegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        View.OnTouchListener,View.OnDragListener {

    String TAG = "RYAN";

    ConstraintLayout mWholeScreen;
    ImageView mDice1, mDice2, mDice3, mDice4, mDice5, mDice6;
//    TextView mTotalHitCount, mStatus;
//    TextView mLocation;

    LinearLayout mPlayingfield, mBottomfield;

    public static int MIN = 1;
    public static int MAX = 6;

    int mTotalOnes = 0;
    boolean mHit = false;
    boolean mGameOver = false;
    boolean mGameReset = false;
    boolean mInitialDrag = true;
    String mSrcView, mDestView;

    int mPlayingFieldCount = MAX;
    int mBottomFieldCount = 0;
    int mEnterCount;

    int mScreenWidth, mScreenHeight, deltaX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWholeScreen = (ConstraintLayout) findViewById(R.id.activity_main);
        mWholeScreen.setOnClickListener(this);
        mPlayingfield = (LinearLayout) findViewById(R.id.playing_field_linearlayout);
        mPlayingfield.setOnDragListener(this);
        mBottomfield = (LinearLayout) findViewById(R.id.bottom_field_linearlayout);
        mBottomfield.setOnDragListener(this);

        mDice1 = (ImageView) findViewById(R.id.dice_1_imageview);
        mDice1.setOnTouchListener(this);
        mDice2 = (ImageView) findViewById(R.id.dice_2_imageview);
        mDice2.setOnTouchListener(this);
        mDice3 = (ImageView) findViewById(R.id.dice_3_imageview);
        mDice3.setOnTouchListener(this);
        mDice4 = (ImageView) findViewById(R.id.dice_4_imageview);
        mDice4.setOnTouchListener(this);
        mDice5 = (ImageView) findViewById(R.id.dice_5_imageview);
        mDice5.setOnTouchListener(this);
        mDice6 = (ImageView) findViewById(R.id.dice_6_imageview);
        mDice6.setOnTouchListener(this);

//        mTotalHitCount = (TextView) findViewById(R.id.total_hit_count_textview);
//        mStatus = (TextView) findViewById(R.id.status_textview);
//        mLocation = (TextView) findViewById(R.id.location);

//        Display display = getWindowManager().getDefaultDisplay();
//        Point size = new Point();
//        display.getRealSize(size);
//        mScreenWidth = size.x;
//        mScreenHeight = size.y;

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        mScreenWidth = metrics.widthPixels;
        mScreenHeight = metrics.heightPixels;

        deltaX = 0;


//        mDice1.setOnDragListener(new View.OnDragListener() {
//            @Override
//            public boolean onDrag(View v, DragEvent event) {
//                String msg = "Ryan";
//                RelativeLayout.LayoutParams layoutParams = null;
//                switch(event.getAction()) {
//                    case DragEvent.ACTION_DRAG_STARTED:
//                        layoutParams = (RelativeLayout.LayoutParams)v.getLayoutParams();
//                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");
//
//                        // Do nothing
//                        break;
//
//                    case DragEvent.ACTION_DRAG_ENTERED:
//                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
//                        int x_cord = (int) event.getX();
//                        int y_cord = (int) event.getY() + 50;
//                        break;
//
//                    case DragEvent.ACTION_DRAG_EXITED :
//                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
//                        x_cord = (int) event.getX();
//                        y_cord = (int) event.getY() + 50;
//                        layoutParams.leftMargin = x_cord;
//                        layoutParams.topMargin = y_cord;
//                        v.setLayoutParams(layoutParams);
//                        break;
//
//                    case DragEvent.ACTION_DRAG_LOCATION  :
//                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
//                        x_cord = (int) event.getX() + 50;
//                        y_cord = (int) event.getY() + 50;
//                        break;
//
//                    case DragEvent.ACTION_DRAG_ENDED   :
//                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");
//
//                        // Do nothing
//                        break;
//
//                    case DragEvent.ACTION_DROP:
//                        Log.d(msg, "ACTION_DROP event");
//
//                        // Do nothing
//                        break;
//                    default: break;
//                }
//                return true;
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main:
                mHit = false;
                renderDice();
//                if (!mGameOver) {
//                    if (mHit) {
//                        mStatus.setText("You hit a one!\nTap to roll again");
//                    } else {
//                        mStatus.setText("Next player!\nTap to roll");
//                    }
//                } else if (mGameReset) {
//                    mTotalOnes = 0;
//                    mGameOver = mGameReset = false;
//                    mTotalHitCount.setText("Total Hit Count: 0");
//                    mStatus.setText("Tap to roll");
//                } else {
//                    mGameReset = true;
//                }


//                mDice1.startAnimation(getDiceAnimation());
//                mDice2.startAnimation(getDiceAnimation());
//                mDice3.startAnimation(getDiceAnimation());
//                mDice4.startAnimation(getDiceAnimation());
//                mDice5.startAnimation(getDiceAnimation());
//                mDice6.startAnimation(getDiceAnimation());

                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        }
        else {
            return false;
        }







//        LinearLayout.LayoutParams layoutParams;
//        ImageView imageView = null;
//        switch (v.getId()) {
//            case R.id.dice_1_imageview:
//                imageView = mDice1;
//                break;
//            case R.id.dice_2_imageview:
//                imageView = mDice2;
//                break;
//            case R.id.dice_3_imageview:
//                imageView = mDice3;
//                break;
//            case R.id.dice_4_imageview:
//                imageView = mDice4;
//                break;
//            case R.id.dice_5_imageview:
//                imageView = mDice5;
//                break;
//            case R.id.dice_6_imageview:
//                imageView = mDice6;
//                break;
//        }
//
//        if (imageView != null) {
//            layoutParams =
//                    (LinearLayout.LayoutParams) imageView.getLayoutParams();
//
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//                    break;
//                case MotionEvent.ACTION_MOVE:
//                    int x_cord = (int) event.getRawX();
//                    int y_cord = (int) event.getRawY();
////
////                    if (x_cord + 100 > mScreenWidth) {
////                        x_cord = mScreenWidth;
////                    }
////                    if (y_cord + 300 > mScreenHeight) {
////                        y_cord = mScreenHeight;
////                    }
////
////                    layoutParams.leftMargin = x_cord;// - 100;
////                    layoutParams.topMargin = y_cord - 300;
////
////                    imageView.setLayoutParams(layoutParams);
//                    if( x_cord + deltaX > mScreenWidth ){
//
//                        // this will ensure that target location
//                        // is always <= windowHeight
//                        deltaX = mScreenWidth - x_cord;
//
//                    } else if( x_cord + deltaX < 0){
//
//                        deltaX = -(x_cord);
//
//                    }
//
//                    imageView.setX(deltaX);
//                    imageView.setTranslationX(deltaX);
//
//                    mLocation.setText("X: " + layoutParams.leftMargin + ", Y: " + layoutParams.topMargin + ", SW: " + mScreenWidth + ", SH: " + mScreenHeight);
//
//                    break;
//                default:
//                    break;
//            }
//        }
//
//        return true;
    }

    private void renderDice() {
        renderDiceOne(new Random().nextInt((MAX - MIN) + 1) + MIN);
        renderDiceTwo(new Random().nextInt((MAX - MIN) + 1) + MIN);
        renderDiceThree(new Random().nextInt((MAX - MIN) + 1) + MIN);
        renderDiceFour(new Random().nextInt((MAX - MIN) + 1) + MIN);
        renderDiceFive(new Random().nextInt((MAX - MIN) + 1) + MIN);
        renderDiceSix(new Random().nextInt((MAX - MIN) + 1) + MIN);
    }

    private void renderDiceOne(int number) {
        switch (number) {
            case 1:
                mTotalOnes++;
                mHit = true;
                checkOnesCount();
                mDice1.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                mDice1.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                mDice1.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                mDice1.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                mDice1.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                mDice1.setImageResource(R.drawable.dice_6);
                break;
        }
    }

    private void renderDiceTwo(int number) {
        switch (number) {
            case 1:
                mTotalOnes++;
                mHit = true;
                checkOnesCount();
                mDice2.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                mDice2.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                mDice2.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                mDice2.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                mDice2.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                mDice2.setImageResource(R.drawable.dice_6);
                break;
        }
    }

    private void renderDiceThree(int number) {
        switch (number) {
            case 1:
                mTotalOnes++;
                mHit = true;
                checkOnesCount();
                mDice3.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                mDice3.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                mDice3.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                mDice3.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                mDice3.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                mDice3.setImageResource(R.drawable.dice_6);
                break;
        }
    }

    private void renderDiceFour(int number) {
        switch (number) {
            case 1:
                mTotalOnes++;
                mHit = true;
                checkOnesCount();
                mDice4.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                mDice4.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                mDice4.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                mDice4.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                mDice4.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                mDice4.setImageResource(R.drawable.dice_6);
                break;
        }
    }

    private void renderDiceFive(int number) {
        switch (number) {
            case 1:
                mTotalOnes++;
                mHit = true;
                checkOnesCount();
                mDice5.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                mDice5.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                mDice5.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                mDice5.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                mDice5.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                mDice5.setImageResource(R.drawable.dice_6);
                break;
        }
    }

    private void renderDiceSix(int number) {
        switch (number) {
            case 1:
                mTotalOnes++;
                mHit = true;
                checkOnesCount();
                mDice6.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                mDice6.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                mDice6.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                mDice6.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                mDice6.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                mDice6.setImageResource(R.drawable.dice_6);
                break;
        }
    }

    private void checkOnesCount() {
//        mTotalHitCount.setText("Total Hit Count: " + mTotalOnes);
        if (mTotalOnes == 7) {
            Toast.makeText(this, "You're picking the drink!", Toast.LENGTH_LONG).show();
        } else if (mTotalOnes == 14) {
            Toast.makeText(this, "You're paying for it!", Toast.LENGTH_LONG).show();
        } else if (mTotalOnes > 20) {
            Toast.makeText(this, "You're drinking it!", Toast.LENGTH_LONG).show();
//            mStatus.setText("Game Over!\nTap to play again");
            mGameOver = true;
        }
    }

    private AnimationSet getDiceAnimation() {
        AnimationSet animSlide1 = new AnimationSet(true);
        animSlide1.setFillAfter(true);
        // Start Rotation
        RotateAnimation rotate1 = new RotateAnimation(0, 360 + getRandomNumZeroToOneEighty(),
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate1.setStartOffset(50);
        rotate1.setDuration(550);
        animSlide1.addAnimation(rotate1);
        // End Rotation
        // Start Translate
        TranslateAnimation trans1 = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -0.3f, Animation.RELATIVE_TO_PARENT,
                getRandomFloat());
        trans1.setDuration(500);
        animSlide1.addAnimation(trans1);
        // End Translate

        return animSlide1;
    }

    private int getRandomNumZeroToOneEighty() {
        return new Random().nextInt(180);
    }

    private float getRandomFloat() {
        return new Random().nextFloat() * (0.85f - 0.3f) + 0.3f;
    }

    @Override
    public boolean onDrag(View layoutview, DragEvent dragevent) {

        boolean bPlayingField = false;
        String area;
        if(layoutview == mPlayingfield){
            bPlayingField = true;
            area = "Playing Field";
        } else {
            area = "Bottom Field";
        }

        int action = dragevent.getAction();
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(TAG, "Drag event started");
                mEnterCount = 0;
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(TAG, "Drag event entered into "+area);
                mEnterCount++;
                if(mInitialDrag) {
                    mSrcView = area;
                    mInitialDrag = false;
                } else {
                    mDestView = area;
                }
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                Log.d(TAG, "Drag event exited from "+area);
                break;
            case DragEvent.ACTION_DROP:
                Log.d(TAG, "Dropped");
                View view = (View) dragevent.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                LinearLayout container = (LinearLayout) layoutview;
                container.addView(view);
                view.setVisibility(View.VISIBLE);
                if(bPlayingField) {
//                    LinearLayout.LayoutParams layoutParams =
//                            (LinearLayout.LayoutParams) view.getLayoutParams();
//                    layoutParams.leftMargin = (int) dragevent.getX();
//                    layoutParams.topMargin = (int) dragevent.getY();
//                    view.setLayoutParams(layoutParams);
                } else {
//                    LinearLayout.LayoutParams layoutParams =
//                            (LinearLayout.LayoutParams) view.getLayoutParams();
//                    layoutParams.leftMargin = (int) dragevent.getX();
//                    layoutParams.topMargin = (int) dragevent.getY();
//                    view.setLayoutParams(layoutParams);
                }
                // Sometime going from the bottom to the playing field
                // it doesn't register leaving the bottom
                if(mEnterCount == 1) {
                    // Since it only enters ACTION_DRAG_ENTERED once it only knows the
                    // srcView.  So that is actually the destView, use srcView as
                    // the destView.
                    if(mSrcView.equalsIgnoreCase("Playing Field")) {
                        mPlayingFieldCount++;
                        mBottomFieldCount--;
                    } else {
                        mBottomFieldCount++;
                        mPlayingFieldCount--;
                    }
                    Toast.makeText(MainActivity.this, "Dest EC1: " + mDestView + ", PF: " + mPlayingFieldCount + ", BF: " + mBottomFieldCount, Toast.LENGTH_SHORT).show();
                } else if(!mSrcView.equalsIgnoreCase(mDestView)) {
                    // Dragged to a different view
                    if(mDestView.equalsIgnoreCase("Playing Field")) {
                        mPlayingFieldCount++;
                        mBottomFieldCount--;
                    } else {
                        mBottomFieldCount++;
                        mPlayingFieldCount--;
                    }
                    Toast.makeText(MainActivity.this, "Dest: " + mDestView + ", PF: " + mPlayingFieldCount + ", BF: " + mBottomFieldCount, Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onDrag: " + mEnterCount);
                }
                mInitialDrag = true;
                mEnterCount = 0;
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                Log.d(TAG, "Drag ended *************************************");
                break;
            default:
                break;
        }
        return true;
    }
}
