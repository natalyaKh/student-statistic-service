Statistic-service show statistics.

API

    - getAllStatistic()
    - GET
    - localhost:8081/statistic/all
    - response -> 
         [
           {
             "studentUuid": "66666",
              "studentName": "student6",
              "grade": 33.3,
              "articlesCount": 6
            },...
          ]


    - getBestStatistics:
    - GET
    - localhost:8081/statistic/best
    - response ->
      [
        {
           "studentUuid": "66666",
           "studentName": "student6",
           "grade": 33.3,
           "articlesCount": 6
        },...
      ]
        
