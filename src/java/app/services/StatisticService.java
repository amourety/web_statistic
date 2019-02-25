package app.services;

import app.form.EventForm;
import app.transfer.PostResultDto;
import app.transfer.StatisticDto;

public interface StatisticService {
    PostResultDto postEvent(EventForm form);
    StatisticDto getStatistics(String from,String to);
}
