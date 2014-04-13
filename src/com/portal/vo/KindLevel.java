package com.portal.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.portal.vo.type.LevelType;

@Entity
@Table(name = "kind_level")
public class KindLevel {
	@Enumerated(EnumType.STRING)
	public LevelType getType() {
		return type;
	}

	public void setType(LevelType type) {
		this.type = type;
	}

    public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	private String photoName;
	private int id;
	private LevelType type;
	private String name;
	private List<KindLevel> kindLevels;
	private KindLevel kindLevel;
	@ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="kindLevel")
	public KindLevel getKindLevel() {
		return kindLevel;
	}

	@Override
	public String toString() {
		return "KindLevel [id=" + id + ", type=" + type + ", name=" + name
				+ "]";
	}

	public void setKindLevel(KindLevel kindLevel) {
		this.kindLevel = kindLevel;
	}

	@OneToMany(mappedBy="kindLevel",cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	public List<KindLevel> getKindLevels() {
		return kindLevels;
	}

	public void setKindLevels(List<KindLevel> kindLevels) {
		this.kindLevels = kindLevels;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
