package com.util.designpro.command;

/**
 * <p>Project: test </p>
 * <p>Description: </p>
 * <p>Copyright (c) 2022 Karrytech (Shanghai/Beijing) Co., Ltd.</p>
 * <p>All Rights Reserved.</p>
 *
 * @author <a href="mailto:xuhongxiong@karrytech.com">Xu HongXiong</a>
 */
public class RemoteController {
    private Command lightOnCommand;

    public void setCommand(Command lightOnCommand){
        this.lightOnCommand = lightOnCommand;
    }

    public void onButton(){
        lightOnCommand.execute();
    }

    public void offButton(){
        lightOnCommand.undo();
    }

}
