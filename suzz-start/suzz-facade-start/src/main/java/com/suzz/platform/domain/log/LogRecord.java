package com.suzz.platform.domain.log;


import com.suzz.platform.constant.LogTypeEnum;
import com.suzz.platform.dto.CommandDTO;
import com.suzz.platform.util.CommandThreadLocal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@Accessors(chain = true)
@ToString
public class LogRecord {

    private LogTypeEnum type;

    private String action;

    private String content;

    private Date operateTime;

    private String operatorName;

    private String operatorAccount;

    private String operatorId;

    protected String getDefaultOperatorName(){
        CommandDTO commandDTO = CommandThreadLocal.get();
        if(Objects.nonNull(commandDTO)){
            return commandDTO.getUserTrueName();
        }
        return null;
    }

    protected Long getDefaultOperatorId(){
        CommandDTO commandDTO = CommandThreadLocal.get();
        if(Objects.nonNull(commandDTO)){
            return commandDTO.getUserAsLong();
        }
        return null;
    }

    protected String getDefaultOperatorAccount(){
        CommandDTO commandDTO = CommandThreadLocal.get();
        if(Objects.nonNull(commandDTO)){
            return commandDTO.getUserName();
        }
        return null;
    }

}
