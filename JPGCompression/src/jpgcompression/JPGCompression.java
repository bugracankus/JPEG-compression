
package jpgcompression;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;

public class JPGCompression {

    public static void main(String[] args) {
     
        File originalImage = new File("C:\\Users\\user\\Desktop\\bugra.jpeg");
        File compressedImage = new File("C:\\Users\\user\\Desktop\\compressedImage.jpeg");
        try{
            compressJPEGimage(originalImage, compressedImage, 0.2f);
            System.out.println("İşlem Başarılı!");
        }
        catch(IOException e){
            
          
        }
    }
    public static void compressJPEGimage(File originalImage, File compressedImage, float compressionQuality)throws IOException{
        RenderedImage image = ImageIO.read(originalImage);
        ImageWriter jpegWriter = ImageIO.getImageWritersByFormatName("jpg").next();
        ImageWriteParam jpegWriteParam = jpegWriter.getDefaultWriteParam();
        jpegWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpegWriteParam.setCompressionQuality(compressionQuality);
        
        try(ImageOutputStream output = ImageIO.createImageOutputStream(compressedImage)){
           jpegWriter.setOutput(output);
           IIOImage outputImage = new IIOImage(image, null, null);
           jpegWriter.write(null, outputImage, jpegWriteParam);   
        }
        jpegWriter.dispose();
        
    }
    
    }
    

