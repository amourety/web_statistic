package app.dao;

import app.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

//dao for Statistic
public interface StatisticDao extends JpaRepository<Statistic, Long> {

    //for 1 method

    //find all users today
    @Transactional
    @Query(value = "SELECT userId from Statistic where visit_date = current_date")
    List<Statistic> findAllUsersCurrDate();

    //find all unique today
    @Transactional
    @Query(value = "SELECT DISTINCT userId from Statistic where visit_date = current_date")
    List<Statistic> findUniqueUsersCurrDate();


    //for 2 method

    //find all users in this period
    @Transactional
    @Query(value = "SELECT userId from Statistic where visit_date between :startDate and :endDate")
    List<Statistic> findAllUsersPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    //find all unique users in this period
    @Transactional
    @Query(value = "SELECT DISTINCT userId from Statistic where visit_date between :startDate and :endDate")
    List<Statistic> findAllUniqueUsersPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    //find all permanent users in this period (>=10)
    @Transactional
    @Query(value =
            "SELECT COUNT(*) FROM (SELECT userid, count(pageId) as count FROM statistic WHERE visit_date BETWEEN ? AND ? GROUP BY userId) as counts where count >=10",
    nativeQuery = true)
    Long findAllPermanentUsersPeriodNative(LocalDate startDate, LocalDate endDate);

}
