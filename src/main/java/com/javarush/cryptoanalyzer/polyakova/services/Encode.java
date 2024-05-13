package com.javarush.cryptoanalyzer.polyakova.services;

import com.javarush.cryptoanalyzer.polyakova.entity.Result;
import com.javarush.cryptoanalyzer.polyakova.exception.ApplicationException;
import com.javarush.cryptoanalyzer.polyakova.repository.ResultCode;

public class Encode implements Function {
    @Override
    public Result execute(String[] parameters) {
        try {
//           TODO finish encode execute method кодировки код вернуть результат ок или эррор
        }catch (Exception e){
            return new Result(ResultCode.ERROR,new ApplicationException("Decode operation finish with exception", e));
        }
        return new Result(ResultCode.OK);
    }
}

