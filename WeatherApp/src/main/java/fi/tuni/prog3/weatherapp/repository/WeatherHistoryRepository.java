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

    @Query(value = "SELECT wh.*\n" +
        "FROM weather_history wh\n" +
        "JOIN (\n" +
        "    SELECT location, MAX(created_date) AS max_created_date\n" +
        "    FROM weather_history\n" +
        "    WHERE is_favorite = true\n" +
        "    GROUP BY location\n" +
        ") max_dates\n" +
        "ON wh.location = max_dates.location AND wh.created_date = max_dates.max_created_date\n" +
        "WHERE wh.is_favorite = true\n" +
        "ORDER BY wh.created_date DESC\n" +
        "LIMIT 6", nativeQuery = true)
    List<WeatherHistoryEntity> findAllByFavoriteCreatedDate();
}
