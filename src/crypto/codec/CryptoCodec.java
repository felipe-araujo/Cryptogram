package crypto.codec;

import android.graphics.Bitmap;

public class CryptoCodec {
	
	public static Bitmap encode(Bitmap inputImage, String text){
		int width = inputImage.getWidth();
    	int height = inputImage.getHeight();
    	int[] pix = new int[width * height];
    	inputImage.getPixels(pix, 0, width, 0, 0, width, height);
    	
    	int npixels = 0;
    	
    	// Percorre, pixel a pixel, 
    	// os bits menos significativos da imagem
    	
    	int index = 0;
    	for (int y = 0; y < height; y++){
    		for (int x = 0; x < width; x++){
    			
    			int r = (pix[index] >> 16) & 0xff;
    			int g = (pix[index] >> 8) & 0xff;
    			int b = pix[index] & 0xff;
    			
    			//r = (r | (2^16-2) + ); // zera o ultimo bit
    			
    			
    			//r = Math.max(0, Math.min(255, r + brightenOffset));
    			//g = Math.max(0, Math.min(255, g + brightenOffset));
    			//b = Math.max(0, Math.min(255, b + brightenOffset));
    			pix[index] = 0xff000000 | (r << 16) | (g << 8) | b;
    			index++;
    		} // x
    	} // y
    	
		return null;
	}
	
	public static String decode(Bitmap inputImage){
		return null;
	}
}
