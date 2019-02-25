package app.controller;
import app.form.EventForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.services.StatisticService;
import app.transfer.PostResultDto;
import app.transfer.StatisticDto;

@RestController
public class StatisticController {

    private final StatisticService service;

    @Autowired
    public StatisticController (StatisticService statisticService){
        this.service = statisticService;
    }

    @PostMapping("/event")
    public ResponseEntity<PostResultDto> postEvent(@RequestBody EventForm form) {
        return ResponseEntity.ok(service.postEvent(form));
    }

    ///statistic?from=2019-02-21&to=2019-02-25
    @GetMapping("/statistic")
    public ResponseEntity<StatisticDto> getStatistic(@RequestParam String from, @RequestParam String to) {
        return  ResponseEntity.ok(service.getStatistics(from,to));
    }
}
