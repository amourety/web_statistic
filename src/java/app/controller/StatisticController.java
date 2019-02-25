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

    private StatisticService service;

    @Autowired
    public StatisticController (StatisticService statisticService){
        this.service = statisticService;
    }

    @PostMapping("/event")
    public ResponseEntity<PostResultDto> postEvent(@RequestBody EventForm form) {
        System.out.println(form);
        return ResponseEntity.ok(service.postEvent(form));
    }
    @GetMapping("/statistic")
    public ResponseEntity<StatisticDto> getStatistic(@RequestParam String from, @RequestParam String to) {
        System.out.println(from);
        System.out.println(to);
        return  ResponseEntity.ok(service.getStatistics(from,to));
    }
}
