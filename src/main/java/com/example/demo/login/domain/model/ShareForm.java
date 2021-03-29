package com.example.demo.login.domain.model;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ShareForm {

	String questionRadio[] = new String[9];

	public Map<String, String> getRadio1() {

		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put("1", "アルギニン");
		map.put("2", "バリン");
		map.put("3", "ロイシン");
		map.put("4", "イソロイシン");

		return map;

	}

	public Map<String, String> getRadio2() {

		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put("1", "アルギニン");
		map.put("2", "クレアチン");
		map.put("3", "グリシン");
		map.put("4", "メチオニン");

		return map;

	}

	public Map<String, String> getRadio3() {

		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put("1", "8");
		map.put("2", "9");
		map.put("3", "10");
		map.put("4", "13");

		return map;

	}

	public Map<String, String> getRadio4() {

		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put("1", "エストロゲン");
		map.put("2", "プロゲステロン");
		map.put("3", "テストステロン ");
		map.put("4", "アブシン");

		return map;

	}

	public Map<String, String> getRadio5() {

		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put("1", "BCAA");
		map.put("2", "NEAA");
		map.put("3", "HMB");
		map.put("4", "ATP");

		return map;

	}

	public Map<String, String> getRadio6() {

		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put("1", "インスリン抵抗性とはインスリンの量が不足していて効果が発揮できない状態");
		map.put("2", "抵抗性が低いということは細胞に糖を取り込む機能が十分に発揮できている状態");
		map.put("3", "抵抗性が高いとインスリンが血液中に多く存在することになり肥満につながる");
		map.put("4", "抵抗性が高いと高血糖になりやすい");

		return map;

	}

	public Map<String, String> getRadio7() {

		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put("1", "セロトニン");
		map.put("2", "ドーパミン");
		map.put("3", "ノルアドレナリン");
		map.put("4", "エンドルフィン");

		return map;

	}

	public Map<String, String> getRadio8() {

		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put("1", "ビタミンA");
		map.put("2", "ビタミンC");
		map.put("3", "ビタミンD");
		map.put("4", "ビタミンE");

		return map;

	}

	public Map<String, String> getRadio9() {

		Map<String, String> map = new LinkedHashMap<String, String>();

		map.put("1", "アクチンフィラメントとミオシンフィラメントの結合で筋収縮が起こる");
		map.put("2", "ATPは筋収縮の際に必要となる");
		map.put("3", "筋収縮時にカルシウムイオンが取り込まれる");
		map.put("4", "アクチンフィラメントとミオシンフィラメントは筋収縮時に縮んでいない");

		return map;

	}

}
