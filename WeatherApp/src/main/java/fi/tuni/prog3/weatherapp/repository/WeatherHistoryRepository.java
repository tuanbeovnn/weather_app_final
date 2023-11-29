package fi.tuni.prog3.weatherapp.repository;

import fi.tuni.prog3.weatherapp.entity.WeatherHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherHistoryRepository extends JpaRepository<WeatherHistoryEntity, Long> {
    @Query(value = "select * from weather_history wh order by wh.created_date desc limit 6", nativeQuery = true)
    List<WeatherHistoryEntity> findAllByCreatedDate();

    @Query(value = "select * from weather_history wh where wh.is_favorite = true order by wh.created_date desc limit 6", nativeQuery = true)
    List<WeatherHistoryEntity> findAllByFavoriteCreatedDate();

}
