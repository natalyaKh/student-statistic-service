package com.statistic.articleservice.exceptions;
/**
 * StudentNotFoundException
 * This exception means that searching studentUuid not found in DB
 */
public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(String message)
    {
        super(message);
    }
}
