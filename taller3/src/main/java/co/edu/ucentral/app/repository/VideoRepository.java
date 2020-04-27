package co.edu.ucentral.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.ucentral.app.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
	public List<Video> findByStatus(String status);
	
	@Query("SELECT v FROM Video v WHERE v.name = ?1")
	public Video encontrarVideoPorTitulo(String titulo);

}
