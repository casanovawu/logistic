package com.suzz.platform.util;

import com.suzz.platform.dto.CommandDTO;

import java.util.Objects;

/**
 * 存放 CommandDTO
 */
public class CommandThreadLocal {

    private final static ThreadLocal<CommandDTO> COMMAND_THREAD_LOCAL = new ThreadLocal<>();

    public static void set(CommandDTO commandDTO){
        if(Objects.nonNull(commandDTO)){
            COMMAND_THREAD_LOCAL.set(commandDTO);
        }
    }

    public static CommandDTO get(){
        return COMMAND_THREAD_LOCAL.get();
    }

    public static Long getUserId(){
        CommandDTO commandDTO = COMMAND_THREAD_LOCAL.get();
        if(Objects.isNull(commandDTO)){
            return null;
        }
        return commandDTO.getUserAsLong();
    }

    public static void clear(){
        COMMAND_THREAD_LOCAL.remove();
    }

}
