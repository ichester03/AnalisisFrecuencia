import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
	
	static int notCounter=-1;

	public static void main(String[] args) {

		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		TreeMap<Double, Character> charCount = new TreeMap<Double, Character>();

		String msg = "CDSF RXTH YDJD ZHUD YFYD GXZY FRHN YDYD QXZR XQFC ESXE XZHG XYFU HTHC DQRH DPCD HJEC FJFQ GDRH QYFJ FYHY DZYF ZFTN SHYD YGHF QFNQ FMFR GXDR NJNC DGHU XLNF QDYH FYHZ RNGF GHFQ FFQN QHJE DRGX FQFC SFRX SGFY FCXZ YFSF RAXZ YFCH QYHU HYNX ZFCC DJDD LNFZ FYHZ RNGD ZHRD YDJF YHYD YFRX QGSX CFZR XSSF RGDF MHRD WPNQ DUHX CDRH QQFR FZDS HDPE SXEX SRHX QDCY FCXZ YFSF RAXZ LNFQ NFZG SDZX RHFY DYRX QZHY FSDM NQYD JFQG DCFZ PLNF ESFR HZDQ YFNQ DYFM FQZD RFSS DYD";
		String nospaces = msg.replaceAll("\\s+", "");

		System.out.println("El mensage original es: ");
		System.out.println(msg);
		System.out.println("Tiene un tamaño sin espacios de " + nospaces.length());

		double charCounter = 0;
		System.out.println("------------------------------------------------------------------");
		System.out.println("El número de ocurrencias de cada letra es: ");

		for (int i = 0; i < alphabet.length; i++) {
			charCounter = countOccurrences(msg, alphabet[i]);
			System.out.println(
					alphabet[i] + " = " + charCounter + " (" + charPercentage(charCounter, nospaces.length()) + "%)");
			// Almacenamos cada letra con su porcentaje de aparición en el mapa
			// fallan las que no aparecen 
			
			charCount.put(charPercentage(charCounter, nospaces.length()), alphabet[i]);

		}

		// Creamos el mapa con los valores que más frecuencia tienen en castellano
		TreeMap<Double, Character> frecuencyAnalisisInSpanish = new TreeMap<Double, Character>();
		frecuencyAnalisisInSpanish.put(12.53, 'A');
		frecuencyAnalisisInSpanish.put(1.42, 'B');
		frecuencyAnalisisInSpanish.put(4.68, 'C');
		frecuencyAnalisisInSpanish.put(5.86, 'D');
		frecuencyAnalisisInSpanish.put(13.68, 'E');
		frecuencyAnalisisInSpanish.put(0.69, 'F');
		frecuencyAnalisisInSpanish.put(1.01, 'G');
		frecuencyAnalisisInSpanish.put(0.70, 'H');
		frecuencyAnalisisInSpanish.put(6.25, 'I');
		frecuencyAnalisisInSpanish.put(0.44, 'J');
		frecuencyAnalisisInSpanish.put(0.02, 'K');
		frecuencyAnalisisInSpanish.put(4.97, 'L');
		frecuencyAnalisisInSpanish.put(3.15, 'M');
		frecuencyAnalisisInSpanish.put(6.71, 'N');
		frecuencyAnalisisInSpanish.put(8.68, 'O');
		frecuencyAnalisisInSpanish.put(2.51, 'P');
		frecuencyAnalisisInSpanish.put(0.88, 'Q');
		frecuencyAnalisisInSpanish.put(6.87, 'R');
		frecuencyAnalisisInSpanish.put(7.98, 'S');
		frecuencyAnalisisInSpanish.put(4.63, 'T');
		frecuencyAnalisisInSpanish.put(3.93, 'U');
		frecuencyAnalisisInSpanish.put(0.90, 'V');
		frecuencyAnalisisInSpanish.put(0.01, 'W');
		frecuencyAnalisisInSpanish.put(0.22, 'X');
		frecuencyAnalisisInSpanish.put(0.90, 'Y');
		frecuencyAnalisisInSpanish.put(0.52, 'Z');

		ArrayList<Character> orderedFrecuency = new ArrayList<Character>();
		ArrayList<Character> orderedCharCount = new ArrayList<Character>();

		

		System.out.println("------------------------------------------------------------------");
		System.out.println("Frecuencias de aparición en el mensage ordenadas: ");
		NavigableMap<Double, Character> reveresedTreeMap2 = charCount.descendingMap();
		Iterator<Entry<Double, Character>> iterator2 = reveresedTreeMap2.entrySet().iterator();
		while (iterator2.hasNext()) {
			Entry<Double, Character> entry = iterator2.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
			orderedCharCount.add(entry.getValue());
		}

		
		System.out.println("------------------------------------------------------------------");
		System.out.println("Frecuencias en castellano ordenadas: ");

		NavigableMap<Double, Character> reveresedTreeMap = frecuencyAnalisisInSpanish.descendingMap();
		Iterator<Entry<Double, Character>> iterator1 = reveresedTreeMap.entrySet().iterator();
		while (iterator1.hasNext()) {
			Entry<Double, Character> entry = iterator1.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
			orderedFrecuency.add(entry.getValue());
		}
		
		System.out.println("======================================================================================");
		System.out.println("Cambios propuestos: ");

		String temp="";
		
			for (int i = 0; i < 5; i++) 
				for (int j = 0; j < 5; j++) {
				System.out.println(orderedCharCount.get(i) + "--------------->" + orderedFrecuency.get(j));
				System.out.println(orderedCharCount.get(i+1) + "--------------->" + orderedFrecuency.get(j+1));
				System.out.println("----------------------------------------------------------------------------------------------------------");
				System.out.println(Character.getNumericValue(orderedCharCount.get(i)) + "--------------->" + Character.getNumericValue(orderedFrecuency.get(j)));
				System.out.println(Character.getNumericValue(orderedCharCount.get(i+1)) + "--------------->" + Character.getNumericValue(orderedFrecuency.get(j+1)));
				System.out.println("======================================================================================");
				}
			
			
			
			
		
			for (int i = 1; i < 17; i=i+2) {
				for (int j = 1; j < 10; j++) {
					System.out.println("i= "+ i + "----j="+j);
					System.out.println(decrypt(msg,i,j));
					System.out.println("======================================================================================");
				}
				
				//System.out.println("======================================================================================");
			}
			//System.out.println(decrypt(msg,7,3));
	
	}
	
	
	public static int charDistance(char A1, char A2) {
		return (Math.abs(Character.toLowerCase(A1)-Character.toLowerCase(A2)));
	}

	public static double charPercentage(double charCounter, int total) {
			
		double result =  charCounter * 100 / total;
		
		

		
		if (result == 0.0) {
			result= notCounter;
			
		}
		notCounter--;
		return result;

	}

	public static int countOccurrences(String haystack, char needle) {
		int count = 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle) {
				count++;
			}
		}
		return count;
	}
	
	
	
	
	// método para descifrar el texto
	 public static String decrypt(String input,int FK,int SK) {
	       String str = "";
	       int x = 0;
	       int inverse = 0;
	       
	       // find 1 by using modular inverse
	       // 17 * IN mod 26 == 1
	       // IN is 0 - infiniti
	       // if total == 1, then IN is the inverse modular
	       while(true){
	         inverse = FK * x % 26;
	            if(inverse == 1)
	               break;
	         x++;
	       }
	       
	       for (int in = 0; in < input.length(); in++) {
	           char get = input.charAt(in);
	           if (Character.isLetter(get)) {
	               // IN *(x-b) mod 26
	               get = (char)(x * ((get + 'A') - SK) % 26 + 'A');
	           }
	           str +=get;
	       }
	       return str;
	   }
	
	
	
    
	
	

}
