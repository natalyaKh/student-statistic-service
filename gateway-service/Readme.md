STATISTIC_SERVICE

        - localhost:8080/stat/statistic/all
        - localhost:8080/stat/statistic/best
        - localhost:8080/stat/statistic/ping

STUDENT_SERVICE

        - localhost:8080/stud/ping
        - localhost:8080/stud/students/all
        - localhost:8080/stud/students/22222

ARTICLE_SERVICE

        - localhost:8080/art/ping
        - localhost:8080/art/article/all
        - localhost:8080/art/article/grade
            - body -> {
                         "articleUuid": "a11111",
                             "articleGrade": "30"
                      }
            - PUT
