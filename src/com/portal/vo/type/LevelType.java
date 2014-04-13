package com.portal.vo.type;

public enum LevelType {
	Level1("1"), Level2("2"), Level3("3");
	private final String text;
	private LevelType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
