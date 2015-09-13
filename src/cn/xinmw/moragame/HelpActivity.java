package cn.xinmw.moragame;

import cn.xinmw.moragame.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HelpActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
		Button button = (Button)findViewById(R.id.help_back);
		TextView tView = (TextView)findViewById(R.id.help_document);
		TextView nView = (TextView)findViewById(R.id.help_notice);
		tView.setText("游戏玩法\n先点击你选择的”石头剪刀布“，然后选择猜拳即可\n后续将会出联机版本");
		nView.setText("软件制作者：周振\tQQ;2212939062\n制作日期：2015年9月13日\n版本：beta1.1");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
