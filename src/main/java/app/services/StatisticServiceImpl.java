package app.services;

import app.repository.StatisticRepository;
import app.form.EventForm;
import app.model.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.transfer.PostResultDto;
import app.transfer.StatisticDto;

import java.time.LocalDate;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository dao;

    @Autowired
    public StatisticServiceImpl(StatisticRepository dao) {
        this.dao = dao;
    }


    //add event into table and get today's statistic
    @Override
    public PostResultDto postEvent(EventForm form) {

        //insert event into table
        dao.save(Statistic.builder().
                userId(form.getUserId()).
                pageId(form.getPageId()).
                visitDate(LocalDate.now()).
                build());

        //using repository
        Long countAllVisitDay = (long) dao.findAllUsersCurrDate().size();
        Long countUniqueUsersDay = (long) dao.findUniqueUsersCurrDate().size();

        //return result
        return PostResultDto.builder().
                countAllVisitDay(countAllVisitDay).
                countUniqueUsersDay(countUniqueUsersDay).
                build();
    }


    //get statistics by period from/to
    @Override
    public StatisticDto getStatistics(String from, String to) {

        //converting
        LocalDate startDate = LocalDate.parse(from);
        LocalDate endDate = LocalDate.parse(to);

        //using repository
        Long countAllVisitsPeriod = (long) dao.findAllUsersPeriod(startDate, endDate).size();
        Long countUniqueUsersPeriod = (long) dao.findAllUniqueUsersPeriod(startDate, endDate).size();
        Long countPermanentUsersPeriod = dao.findAllPermanentUsersPeriodNative(startDate, endDate);

        //return result
        return StatisticDto.builder().
                countAllVisitsPeriod(countAllVisitsPeriod).
                countUniqueUsersPeriod(countUniqueUsersPeriod).
                countPermanentUsersPeriod(countPermanentUsersPeriod).
                build();
    }
}
