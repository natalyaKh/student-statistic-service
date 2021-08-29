Article-service

API

    getAllArticles
    - GET
    - localhost:8083/article/all
    - response -> 
        [
            {
                 "articleUuid": "a77777",
                 "articleName": "article7",
                 "studentUuid": "88888",
                 "articleGrade": null
            },...
        ]


        addGradeToArticle
        - PUT
        - request -> 
            {
                "articleUuid":"a77777",
                "articleGrade": 23.3
            }
        - response -> 
            {
                 "articleUuid": "a77777",
                 "articleName": "article7",
                 "studentUuid": "88888",
                 "articleGrade": 23.3
            }


        addGradeToArticleWithExseptions
        - PUT
        - request -> 
            {
                "articleUuid":"a77777777",
                "articleGrade": 23.3
            }
        - response -> 
            {
                "error": " article with uuid a7777777 was not found",
                "date": "2021-08-29 17:32:21",
                "status": 410
            }


