package com.segware.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "posteds")
public class Posted {

	public Posted() {
	}

	public Posted(Integer id, String description, Integer votes) {
		super();
		this.id = id;
		this.description = description;
		this.votes = votes;
	}

	@Id
	private Integer id;
	private String description;
	private Integer votes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Posted [id=" + id + ", description=" + description + ", votes=" + votes + "]";
	}
}
