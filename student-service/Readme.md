Student service - service return students

API

        getAllStudents
        - GET
        - localhost:8082/students/all
        - response -> 
            [
                {
                     "studentUuid": "66666",
                     "studentName": "student6"
                },
            ]


        getStudent
        - GET
        - localhost:8082/students/2222
        - response ->
            {
                "studentUuid": "66666",
                "studentName": "student6"
            }


        getStudent With Error
        - GET
        - localhost:8082/students/2222222222
        - response ->
            {
                 "error": " student with uuid 222222 was not found",
                 "date": "2021-08-29 16:24:02",
                 "status": 410
            }
