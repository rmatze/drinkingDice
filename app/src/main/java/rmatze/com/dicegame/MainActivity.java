package rmatze.com.dicegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ConstraintLayout mWholeScreen;
    ImageView mDice1, mDice2, mDice3, mDice4, mDice5, mDice6;
    TextView mTotalHitCount, mStatus;

    public static int MIN = 1;
    public static int MAX = 6;

    int mTotalOnes = 0;
    boolean mHit = false;
    boolean mGameOver = false;
    boolean mGameReset = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWholeScreen = (ConstraintLayout) findViewById(R.id.activity_main);
        mWholeScreen.setOnClickListener(this);

        mDice1 = (ImageView) findViewById(R.id.dice_1_imageview);
        mDice2 = (ImageView) findViewById(R.id.dice_2_imageview);
        mDice3 = (ImageView) findViewById(R.id.dice_3_imageview);
        mDice4 = (ImageView) findViewById(R.id.dice_4_imageview);
        mDice5 = (ImageView) findViewById(R.id.dice_5_imageview);
        mDice6 = (ImageView) findViewById(R.id.dice_6_imageview);

        mTotalHitCount = (TextView) findViewById(R.id.total_hit_count_textview);
        mStatus = (TextView) findViewById(R.id.status_textview);
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
                if(!mGameOver) {
                    if (mHit) {
                        mStatus.setText("You hit a one!\nTap to roll again");
                    } else {
                        mStatus.setText("Next player!\nTap to roll");
                    }
                } else if (mGameReset) {
                    mTotalOnes = 0;
                    mGameOver = mGameReset = false;
                    mTotalHitCount.setText("Total Hit Count: 0");
                    mStatus.setText("Tap to roll");
                } else {
                    mGameReset = true;
                }
                break;
        }
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
        mTotalHitCount.setText("Total Hit Count: " + mTotalOnes);
        if(mTotalOnes == 7) {
            Toast.makeText(this, "You're picking the drink!", Toast.LENGTH_LONG).show();
        } else if (mTotalOnes == 14) {
            Toast.makeText(this, "You're paying for it!", Toast.LENGTH_LONG).show();
        } else if (mTotalOnes > 20) {
            Toast.makeText(this, "You're drinking it!", Toast.LENGTH_LONG).show();
            mStatus.setText("Game Over!\nTap to play again");
            mGameOver = true;
        }
    }
}
