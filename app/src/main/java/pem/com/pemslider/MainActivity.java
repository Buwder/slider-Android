package pem.com.pemslider;

import android.app.Activity;

import android.graphics.Color;
import android.os.Bundle;

import android.support.annotation.Nullable;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;


import pem.com.pemslider.slider.R;

public class MainActivity extends Activity {
    private RollPagerView mRollViewPager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        mRollViewPager = (RollPagerView) findViewById(R.id.roll_view_pager);

        mRollViewPager.setPlayDelay(5000);
        mRollViewPager.setAnimationDurtion(500);

        mRollViewPager.setAdapter(new TestNormalAdapter());
        mRollViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW,Color.WHITE));
    }
    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img6,
                R.drawable.img7,
                R.drawable.img8,
                R.drawable.img9,
                R.drawable.img10,
                R.drawable.img11,
                R.drawable.img12,
                R.drawable.img13,
                R.drawable.img14,
                R.drawable.img15,
                R.drawable.img16,
                R.drawable.img17,
                R.drawable.img18,
                R.drawable.img19,
                R.drawable.img20,
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        };

        @Override
        public int getCount() {
            return imgs.length;
        }
    }
    private long firstTime = 0;
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
                return true;
            } else {
                finish();
            }
        }

        return super.onKeyUp(keyCode, event);
    }
}
