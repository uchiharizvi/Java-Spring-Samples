package com.kavish.tutorials.utils;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.CurvedLineNoiseProducer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

public class CaptchaUtil {
    //Creating Captcha Object
    public static Captcha createCaptcha(Integer width, Integer height){
        return new Captcha.Builder(width, height)
                .addBackground(new GradiatedBackgroundProducer())
                .addText(new DefaultTextProducer(), new DefaultWordRenderer())
                .addNoise(new CurvedLineNoiseProducer())
                .build();
    }

    public static String encodeCaptcha(Captcha captcha){
        String image = null;
        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(captcha.getImage(),"jpg", outputStream);
            byte[] byteArray = Base64.getEncoder().encode(outputStream.toByteArray());
            image = new String(byteArray);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return image;
    }
}
