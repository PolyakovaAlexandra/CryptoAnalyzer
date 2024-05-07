package com.javarush.cryptoanalyzer.polyakova.entity;

import com.javarush.cryptoanalyzer.polyakova.exception.ApplicationException;
import com.javarush.cryptoanalyzer.polyakova.repository.ResultCode;

public class Result {
    private ResultCode resultCode;
    private ApplicationException applicationException;

    public Result(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public Result(ResultCode resultCode, ApplicationException applicationException) {
        this.resultCode = resultCode;
        this.applicationException = applicationException;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public ApplicationException getApplicationException() {
        return applicationException;
    }
}
