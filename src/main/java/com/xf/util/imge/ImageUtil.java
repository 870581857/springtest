package com.xf.util.imge;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 图片处理
 */
public class ImageUtil {

    /**
     * 按照固定宽高原图压缩
     *
     * @param img    源图片文件
     * @param width  宽
     * @param height 高
     * @param out    输出流
     * @throws IOException the io exception
     */
    public static void thumbnail(File img, int width, int height, OutputStream out) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(img);
        Image image = bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = tag.getGraphics();
        graphics.setColor(Color.RED);
        // 绘制处理后的图
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();
        ImageIO.write(tag, "", out);
    }

    /**
     * 压缩图片
     *
     * @param srcImagePath 源图片路径
     * @param desImagePath 目标路径
     * @param scale        压缩率
     * @throws IOException the io exception
     */
    public static void thumbnail(String srcImagePath, String desImagePath, double scale) throws IOException {
        Thumbnails.of(srcImagePath).scale(scale).toFile(desImagePath);
    }


    public static void main(String[] args) {

//        try {
//            thumbnail("D:\\7149055EDC7A469935B1D92389F0F287.png","D:\\1.png",0.3);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            File file = new File("D://7149055EDC7A469935B1D92389F0F287.png");
            OutputStream out = new FileOutputStream("d://1.png");
            thumbnail(file,3840,2160,out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
