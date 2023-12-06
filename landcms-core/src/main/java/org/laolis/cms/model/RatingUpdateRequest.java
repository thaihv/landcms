package org.laolis.cms.model;

import java.io.Serializable;

public class RatingUpdateRequest implements Serializable {
	private long id;
	private int ratingStar;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRatingStar() {
		return ratingStar;
	}

	public void setRatingStar(int ratingStar) {
		this.ratingStar = ratingStar;
	}
}
