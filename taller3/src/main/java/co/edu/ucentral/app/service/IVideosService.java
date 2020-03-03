package co.edu.ucentral.app.service;

import java.util.List;

import co.edu.ucentral.app.model.Video;

public interface IVideosService {

	public List<Video> selectAll();
	
	public void insert(Video video);
	
}
