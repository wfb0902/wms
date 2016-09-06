package com.delmar.devs;

import com.delmar.devs.swing.GenCodeJFrame;
import com.delmar.utils.ResourceMessage;
import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by admin on 2016/9/6.
 */
public class GenerationMain {
    private static Logger logger= Logger.getLogger(GenerationMain.class);
    public static void main(String[] args)
    {

        ResourceBundle resourceBundle=  ResourceBundle.getBundle("msg",Locale.getDefault());
        GenCodeJFrame.main(resourceBundle);
    }
}