package com.suzz.platform.vo.request;

import com.suzz.platform.dto.CommandDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author subo
 * @date 2022/4/22 23:59
 **/
public class CommandRequest<T> extends SimpleRequest<T>{

    private static final long serialVersionUID = 354843093598672089L;

    @ApiModelProperty("操作人信息")
    @NotNull(
            message = "操作人信息不能为空"
    )
    private CommandDTO commandDTO;

    public static <T> CommandRequest<T> of(T reqDtos, CommandDTO commandDTO) {
        return new CommandRequest(reqDtos, commandDTO);
    }

    public CommandRequest(T reqDtos, CommandDTO commandDTO) {
        super(reqDtos);
        this.commandDTO = commandDTO;
    }

    public CommandRequest(){

    }

    public CommandDTO getCommandDTO() {
        return this.commandDTO;
    }

    public void setCommandDTO(final CommandDTO commandDTO) {
        this.commandDTO = commandDTO;
    }

    public String toString() {
        return "CommandRequest(commandDTO=" + this.getCommandDTO() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CommandRequest)) {
            return false;
        } else {
            CommandRequest<?> other = (CommandRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else {
                Object this$commandDTO = this.getCommandDTO();
                Object other$commandDTO = other.getCommandDTO();
                if (this$commandDTO == null) {
                    if (other$commandDTO != null) {
                        return false;
                    }
                } else if (!this$commandDTO.equals(other$commandDTO)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommandRequest;
    }
}
