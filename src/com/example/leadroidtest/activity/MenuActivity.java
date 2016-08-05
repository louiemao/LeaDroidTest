package com.example.leadroidtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.leadroidtest.R;
import com.example.leadroidtest.common.MenuInfo;
import com.example.leadroidtest.common.MenuTreeAdapter;
import com.example.leadroidtest.common.TreeElement;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		ListView rootView = (ListView) findViewById(R.id.listView);

		TreeElement<MenuInfo> root = new TreeElement<>();

		TreeElement<MenuInfo> ele1 = new TreeElement<>(new MenuInfo("基本功能测试",
				null));
		root.addChild(ele1);
		ele1.addChild(new MenuInfo("工作频段", MainActivity.class));
		ele1.addChild(new MenuInfo("信道带宽", MainActivity.class));
		ele1.addChild(new MenuInfo("参数配置", MainActivity.class));
		ele1.addChild(new MenuInfo("同步方式", MainActivity.class));
		ele1.addChild(new MenuInfo("网络状态上报", MainActivity.class));
		ele1.addChild(new MenuInfo("自检功能", MainActivity.class));
		ele1.addChild(new MenuInfo("网络融合", MainActivity.class));
		ele1.addChild(new MenuInfo("业务传输", MainActivity.class));

		TreeElement<MenuInfo> ele2 = new TreeElement<>(new MenuInfo(
				"发射机性能指标测试", null));
		root.addChild(ele2);
		ele2.addChild(new MenuInfo("输出功率", MainActivity.class));
		ele2.addChild(new MenuInfo("邻信道功率比", MainActivity.class));
		ele2.addChild(new MenuInfo("谐波抑制", MainActivity.class));

		TreeElement<MenuInfo> ele3 = new TreeElement<>(new MenuInfo(
				"接收机性能指标测试", null));
		root.addChild(ele3);
		ele3.addChild(new MenuInfo("数字灵敏度", MainActivity.class));
		ele3.addChild(new MenuInfo("接收动态范围", MainActivity.class));
		ele3.addChild(new MenuInfo("接收领道抑制比", MainActivity.class));
		ele3.addChild(new MenuInfo("接收抑制比", MainActivity.class));

		TreeElement<MenuInfo> ele4 = new TreeElement<>(new MenuInfo(
				"抗干扰性能指标测试", null));
		root.addChild(ele4);
		ele4.addChild(new MenuInfo("跳频速率", MainActivity.class));
		ele4.addChild(new MenuInfo("抗阻塞式干扰", MainActivity.class));
		ele4.addChild(new MenuInfo("跳频频段", MainActivity.class));

		TreeElement<MenuInfo> ele5 = new TreeElement<>(new MenuInfo("组网指标测试",
				null));
		root.addChild(ele5);
		ele5.addChild(new MenuInfo("最大业务跳数", MainActivity.class));
		ele5.addChild(new MenuInfo("网络初始建立时间", MainActivity.class));
		ele5.addChild(new MenuInfo("新节点迟入网时间", MainActivity.class));
		ele5.addChild(new MenuInfo("路由更新时间", MainActivity.class));
		ele5.addChild(new MenuInfo("单跳端到端传输时延", MainActivity.class));
		ele5.addChild(new MenuInfo("多跳端到端传输时延", MainActivity.class));
		ele5.addChild(new MenuInfo("网络容量", MainActivity.class));

		TreeElement<MenuInfo> ele6 = new TreeElement<>(new MenuInfo("外场测试",
				null));
		root.addChild(ele6);
		ele6.addChild(new MenuInfo("最大通信距离", MainActivity.class));
		ele6.addChild(new MenuInfo("相对移动速度", MainActivity.class));
		ele6.addChild(new MenuInfo("典型拓扑组网", MainActivity.class));

		TreeElement<MenuInfo> ele7 = new TreeElement<>(new MenuInfo("其他测试",
				null));
		root.addChild(ele7);
		ele7.addChild(new MenuInfo("尺寸", MainActivity.class));
		ele7.addChild(new MenuInfo("重量", MainActivity.class));
		ele7.addChild(new MenuInfo("最大功耗", MainActivity.class));
		ele7.addChild(new MenuInfo("待机功耗", MainActivity.class));
		ele7.addChild(new MenuInfo("平均功耗", MainActivity.class));
		ele7.addChild(new MenuInfo("峰值速率", MainActivity.class));

		MenuTreeAdapter adapter = new MenuTreeAdapter(this, root);
		rootView.setAdapter(adapter);
	}

}
