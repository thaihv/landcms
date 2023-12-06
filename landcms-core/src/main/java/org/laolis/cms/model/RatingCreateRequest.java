package org.laolis.cms.model;

import java.io.Serializable;

import org.laolis.cms.domain.BlogLanguage;

public class RatingCreateRequest implements Serializable {

	private BlogLanguage blogLanguage;
	private long postId;
	private long userId;
	private int ratingStar;

	public BlogLanguage getBlogLanguage() {
		return blogLanguage;
	}

	public void setBlogLanguage(BlogLanguage blogLanguage) {
		this.blogLanguage = blogLanguage;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getRatingStar() {
		return ratingStar;
	}

	public void setRatingStar(int ratingStar) {
		this.ratingStar = ratingStar;
	}

}
