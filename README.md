# web_statistic_service
created by Vadim Bespalov 2019

to start application simply run following Maven command:

```
$ mvn spring-boot:run
```

1. Create visit's event 
  ```
  use event.http in src\main\java\app folder to send http post request

  response will be in json format
  ```
2. Get visit's statistic 
  ```
  go to /statistic and use parameters as ?from=year-mm-dd&to=year-mm-dd 
  
  for checking statistics in this period
  
  for example: http://localhost:8080/statistic?from=2019-02-21&to=2019-02-25
  
  response will be in json format
  ```
  
 
