/**
 * 
 */

/**
 * @author 2656
 *
 */

import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.tess4j.Tesseract;


public class OCR {

	/**
	 * @param args
	 */
	static String[] pins = new String[50];
	static String[] puk = new String[50];
	static String[] serial = new String[50];
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Starting...");
		
		String inputFilePath = "C:\\Users\\2656\\Desktop\\SimKartenRaw\\1.tif";
		
		
		System.out.println("Opening: " + inputFilePath );
		
		System.out.println("Standby...");

		
		Tesseract tesseract = new Tesseract();
		tesseract.setDatapath("C:\\Users\\2656\\Desktop\\Tess4J");
		
		String fullText = tesseract.doOCR(new File(inputFilePath));
		System.out.println(fullText);
		System.out.println("---------------------------------------------------------------");
		format(fullText);
		
		
	}
	
	public static void format(String stringToFormat) {
			seperateWords(stringToFormat);
			
			System.out.println(Arrays.toString(serial));
			System.out.println(Arrays.toString(pins));
			System.out.println(Arrays.toString(puk));
			
		
			System.out.println("---------------------------------------------------------------");

			for(int i = 0; i<serial.length; i++) {
				System.out.println(serial[i]+","+pins[i]+","+puk[i]);
			}
			
         
        
	}
	
	public static void seperateWords(String stringToSeperate) {
		String s1 = stringToSeperate;
		//String output = "";
		int i = 0;
		int j = 0;
		int k = 0;
		
		

        
        Pattern p = Pattern.compile("[0-9]{4,}");
         
        Matcher m1 = p.matcher(s1);
    
        while (m1.find()) {
        	
			if(m1.group().length() == 4 && m1.group().equals("6147") == false && m1.group().equals("1111") == false) {
        		pins[i] = m1.group();
        		i++;
			}
			if(m1.group().length() == 19 && m1.group().equals("1111111111111111111") == false) {
				serial[j] = m1.group();
				j++;
			}
			if(m1.group().length() == 8 && m1.group().equals("11111111") == false) {
				puk[k] = m1.group();
				k++;
			}
			
			}
        	
            //System.out.println(m1.group());
        	/* if(m1.group().length() == 4 && m1.group().equals("6147") == false || m1.group().length() == 19 || m1.group().length() == 8 ) {
        	
            output = output + " " + m1.group();
        		
        		}
        	}
        //System.out.println(output);
		return output; */
	}
	
	
}



