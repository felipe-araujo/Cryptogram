package crypto.codec;




/**
 * Classe utilitaria para manipular uma String
 * como um fluxo de bits
 * */
public class ByteBuffer {
	
	private String buffer;
	private byte[] bytes = null;
	private int index;
	private char bitIndex;
	private int charIndex;
	
	public ByteBuffer(String buffer){
		this.buffer = buffer;
		bytes = buffer.getBytes();
		bitIndex = 0;
		charIndex = 0;
	}
	
	public ByteBuffer(int size){
		bytes = new byte[size];
	}
	
	public int getNumBits(){		
		return bytes.length * 16;
	}
	
	public String toString(){
		return new String(bytes);
	}
	
	
	// ok
	public byte getNextBit(){				
		byte b = (byte)((bytes[charIndex] >> bitIndex) & 0x1); // desloca o bit selecionado ate a posicao menos significativa e
		moveNext();
		return b;
	}
	
	/**
	 * Importante: assume que b é zero ou um
	 * */
	public void setNextBit(byte b){
		byte mask = (byte)(1 << bitIndex);
		mask = (byte) ~mask; 
		
		bytes[charIndex] = (byte) (bytes[charIndex] & mask); // zera o bit que queremos setar;
		bytes[charIndex] = (byte) (bytes[charIndex] + (b << bitIndex));
		moveNext();
		
	}
	
	public void setNextBit(int b){
		setNextBit((byte)b);
	}
	
	private void moveNext(){
		bitIndex++;		
		if(bitIndex>15){
			bitIndex = 0;
			charIndex++;
		}
	}

}
