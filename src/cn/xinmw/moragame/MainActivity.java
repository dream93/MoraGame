package cn.xinmw.moragame;

import cn.xinmw.moragame.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn_start,btn_clear;
	private RadioGroup rg1,rg2;
	private RadioButton p2_ston,p2_shear,p2_cloth;
	private int p1Result,p2Result,result;
	private TextView display,resDisplay;
	private ImageView show;
	private int sum = 0,win = 0,lose = 0,flat = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start = (Button)findViewById(R.id.game_start);
        btn_clear = (Button)findViewById(R.id.game_clear);
        rg1 = (RadioGroup)findViewById(R.id.play1_group);
        rg2 = (RadioGroup)findViewById(R.id.play2_group);
        p2_ston = (RadioButton) findViewById(R.id.play2_tone);
        p2_shear = (RadioButton) findViewById(R.id.play2_shear);
        p2_cloth = (RadioButton) findViewById(R.id.play2_cloth);
        show = (ImageView)findViewById(R.id.show);
        display = (TextView)findViewById(R.id.display);
        resDisplay = (TextView)findViewById(R.id.tv_note);

        rg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.play1_tone:
					p1Result = 0;
					break;
				case R.id.play1_shear:
					p1Result = 1;
					break;
				case R.id.play1_cloth:
					p1Result = 2;
					break;
				default:
					break;
				}

			}
		});
        btn_start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (p2Result == 0) {
					p2_ston.setChecked(true);
				}else if(p2Result == 1){
					p2_shear.setChecked(true);
				}else {
					p2_cloth.setChecked(true);
				}
				if (p1Result == p2Result) {
					result = 0;
					Toast.makeText(MainActivity.this, p1Result + "" + p2Result, Toast.LENGTH_SHORT).show();
					show.setImageResource(R.drawable.d_hehe);
					display.setText("平了");
					flat += 1;
					sum += 1;
				}else if ((p1Result == 0 && p2Result == 1) || (p1Result == 1 && p2Result == 2) || (p1Result == 2 && p2Result == 0)) {
					result = 1;
					show.setImageResource(R.drawable.d_haha);
					display.setText("赢了");
					win += 1;
					sum += 1;
				}else {
					result = -1;
					show.setImageResource(R.drawable.d_beishang);
					display.setText("输了");
					lose += 1;
					sum += 1;
				}
				resDisplay.setText("已战" + sum + "局\n赢" + win + "局\n输" + lose + "局\n平" + flat + "局");
			}
		});
        
        btn_clear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sum = 0;
				win = 0;
				lose = 0;
				flat = 0;
				resDisplay.setText("已战" + sum + "局\n赢" + win + "局\n输" + lose + "局\n平" + flat + "局");
			}			
		});
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.main, menu);
    	return true;
    }
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.help_item:
			Intent intent = new Intent(MainActivity.this, HelpActivity.class);
			startActivity(intent);
			break;

		case R.id.back_item:
			finish();
			break;
		default:
			break;
		}
		return true;
	}
}
