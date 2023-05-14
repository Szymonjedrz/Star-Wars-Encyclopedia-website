package pl.szymonjedrzejewski.springboot.projekt6.restapi.starwars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "films")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "episode_id")
	private String episode_id;
	
	@Column(name = "opening_crawl")
	private String opening_crawl;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "producer")
	private String producer;
	
	@Column(name = "release_date")
	private String release_date;

	public Film() {
		
	}

	public Film(String title, String episode_id, String opening_crawl, String director, String producer,
			String release_date) {
		this.title = title;
		this.episode_id = episode_id;
		this.opening_crawl = opening_crawl;
		this.director = director;
		this.producer = producer;
		this.release_date = release_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(String episode_id) {
		this.episode_id = episode_id;
	}

	public String getOpening_crawl() {
		return opening_crawl;
	}

	public void setOpening_crawl(String opening_crawl) {
		this.opening_crawl = opening_crawl;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", episode_id=" + episode_id + ", opening_crawl=" + opening_crawl
				+ ", director=" + director + ", producer=" + producer + ", release_date=" + release_date + "]";
	}
}
