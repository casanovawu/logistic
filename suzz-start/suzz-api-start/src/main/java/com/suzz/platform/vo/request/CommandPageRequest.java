package com.suzz.platform.vo.request;

import com.suzz.platform.dto.CommandDTO;
import com.suzz.platform.dto.PaginationDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author subo
 * @date 2022/5/2 15:43
 **/
@Getter
@Setter
@ApiModel
public class CommandPageRequest<T> extends PageRequest<T>{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("操作人信息")
    @NotNull(
            message = "操作人信息不能为空"
    )
    private CommandDTO commandDTO;

    public CommandPageRequest(T reqDtos, PaginationDTO dto) {
        super(reqDtos, dto);
    }

    public CommandPageRequest(){
    }

    public static <T, U> CommandPageRequest<T> of(T reqDtos, PageRequest<U> request, CommandDTO commandDTO) {
        CommandPageRequest<T> pageRequest = new CommandPageRequest();
        pageRequest.setSortDTO(request.getSortDTO());
        pageRequest.setCommandDTO(commandDTO);
        pageRequest.setPaginationDTO(request.getPaginationDTO());
        pageRequest.setReqDtos(reqDtos);
        return pageRequest;
    }

    public CommandDTO getCommandDTO() {
        return this.commandDTO;
    }

    public void setCommandDTO(final CommandDTO commandDTO) {
        this.commandDTO = commandDTO;
    }

    public String toString() {
        return "CommandPageRequest(commandDTO=" + this.getCommandDTO() + ")";
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommandPageRequest;
    }


}
