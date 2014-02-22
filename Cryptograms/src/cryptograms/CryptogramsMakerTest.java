package cryptograms;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CryptogramsMakerTest {
	CryptogramsMaker cryoMaker = new CryptogramsMaker();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testcryptogramsMaker() {
		//fail("Not yet implemented");
		
		String result = cryoMaker.readQuotesFile('h');
		//System.out.println(result);
		//System.out.println(cryoMaker.getPureQuote(result));
		
	}
	
	@Test
	public void testgetPureQuote() {
		String originalString = new String("p Breakfast sometime?");
		String expected = new String("Breakfast sometime?"); 
		String result = new String(cryoMaker.getPureQuote(originalString));
		assertEquals(expected, result);
		
	}
	
	@Test
	public void testencodeKey() {
		int n = 0;
		char[] keyArray = cryoMaker.encodeKey();
		//System.out.print("KeyArray= " );
		//System.out.println(keyArray);
		//System.out.println(keyArray);
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < 26; j++) {
				if(i != j) { 
					assertNotSame(keyArray[i], keyArray[j]);
				}
			}
		}
		
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j <26; j++) {
				if (keyArray[j] == (char)(97+i)) {
					//System.out.println(keyArray[j]);
					n++;
				}
			}
		}
		assertSame(n, 26);
		
	}

	
	
	//@Test
	public void testencodeQuote () {
		String originalString = new String("p Breakfast sometime?");
		char[] result = cryoMaker.encodeKey();
		//System.out.println(result);
		
	}
	
	
	@Test
	public void testencodeString() {
		//char[] keyArray = cryoMaker.encodeKey();
		//System.out.println(keyArray);
		//System.out.println("abcdefghijklmnopqrstuvwxyz");
		
		String keyString = new String("plurgwikzsntavcfdbhxjyoeqm");
		char[] keyArrayTwo;
		keyArrayTwo = keyString.toCharArray();
		//System.out.println(keyArrayTwo);
		String expected1 = new String("f Pbgpnwphx hcagxzag?");
		String originalString = new String("p Areakfast sometime?");
		String result = cryoMaker.encodeString(originalString, keyArrayTwo);
		//System.out.println("Resutl=" + result);
		assertEquals(expected1, result);
		//assertThat(expected1, not(equalTo(result)));
		
	}
	
	
	@Test
	public void testcharLoop() {
		assertEquals(cryoMaker.charLoop(122,1), 97);
		assertEquals(cryoMaker.charLoop(122,0), 122);
		assertEquals(cryoMaker.charLoop(122,2), 98);
		assertEquals(cryoMaker.charLoop(97, 20), 117);
		assertEquals(cryoMaker.charLoop(97,25), 122);
		assertEquals(cryoMaker.charLoop(97,26), 97);
		assertEquals(cryoMaker.charLoop(97,27), 98);
		assertEquals(cryoMaker.charLoop(97,30), 101);
		
	}
	
	@Test
	public void testreplaceCharArray() {
		char[] originalArray = {'a','b','c','a','f','g','z','Z','A','C'};
		char[] keyArray = {'d','e','f'};
		char[] originalkeyArray = {'a','b','c'};
		char[] expected1 = "defdfgzZDF".toCharArray();
		char[] result = cryoMaker.replaceCharArray(originalArray, keyArray, originalkeyArray);
		
		assertArrayEquals(expected1, result);
		
		String nowUserKey = "abcdefghijklmnopqrstuvwxyz";
		String newKey = cryoMaker.replaceString(nowUserKey, "abc", "ddd");
		//System.out.println(newKey);
		//System.out.println(expected1);
		
	}
	
	@Test
	public void testformatString() {
		String originalString0 = cryoMaker.readQuotesFile('h');
		String originalString1 = new String("012345 is a very good day. The sunqhine is very very beatiful. But I havn't had lunch. This is the end.");
		String originalString2 = new String("This is a very good day. But I havn't had lunch. This is the end.");
		String originalString3 = new String("Yes. It's is a very good day. The sunqhine iabc very very beatiful. But I havn't had lunch. This is the end.");
		//String originalString4 = new String("This is a very good day. The sunqhine iabc very very beatiful. But I havn't had lunch. This is the end.");
		String originalString4 = new String("Upnpug dfle kpyg gngqwd kf tggi fkvgeh vriid.");
		//char[] keyArray = cryoMaker.encodeKey();
		//String originalEncodedString = cryoMaker.encodeString(originalString0, keyArray);
		String resultString0;
		String resultString1;
		String resultString2;
		String resultString3;
		String resultString4;
		String expected1 = new String("012345 is a very good day. The sunqhine \n"+ 
										"is very very beatiful. But I havn't had \n"+
										"lunch. This is the end.");
		resultString0 = cryoMaker.formatString(originalString0);
		resultString1 = cryoMaker.formatString(originalString1);
		resultString2 = cryoMaker.formatString(originalString2);
		resultString3 = cryoMaker.formatString(originalString3);
		resultString4 = cryoMaker.formatString(originalString4);
		//String[] testArray =  {"one", "two", "three"};
		//String testString = Arrays.toString(testArray);
		//System.out.println(testString);
		//System.out.println(originalString0);
		//System.out.println(resultString0);
		//System.out.println(originalString1);
		//System.out.println(resultString1);
		//System.out.println(originalString2);
		//System.out.println(resultString2);
		//System.out.println(originalString3);
		//System.out.println(resultString3);
		System.out.println(resultString4);
		//assertEquals(expected1, resultString1);
	}
	
	@Test
	public void testconvertToString() {
		String[] testArray =  {"one", "two", "three"};
		String expected1 = new String("onetwothree");
		String resultString1 = cryoMaker.convertToString(testArray, "");
		//System.out.println(newString);
		assertEquals(expected1, resultString1);
	}
	
	@Test
	public void testtextAreaString() {
		String originalString1 = new String("AodaA is a very good day. The sunqhine is very very beatiful. But I havn't had lunch. This is the end.");
		String keyString = new String("                          ");
		char[] keyArrayOne;
		keyArrayOne = keyString.toCharArray();
		String resultString1 = cryoMaker.textAreaString(originalString1, keyArrayOne);
		//System.out.println(cryoMaker.decodeString(originalString1, keyArrayOne));
		//System.out.println(resultString1);
	}
	
	@Test
	public void testupdateKey() {
		String nowKey = "abcdefghijklmnopqrstuvwxyz";
		String replaceOriginal = "a";
		String replaceWith = "d";
		String result = cryoMaker.updateKey(nowKey, replaceOriginal, replaceWith);
		String expected = "dbc efghijklmnopqrstuvwxyz";
		assertEquals(expected, result);
		//System.out.println(result);
	}
	
	@Test
	public void testdeleteQuoteAuthor() {
		String quote1 = "This is a test.  -- Hello";
		String expected1 = "This is a test.";
	    String result1 = cryoMaker.deleteQuoteAuthor(quote1);
	    String quote2 = "This is a test. -- One blank only";
		String expected2 = "This is a test. -- One blank only";
		String result2 = cryoMaker.deleteQuoteAuthor(quote2);
	    //System.out.println(result2);
	    assertEquals(expected1, result1);
	    assertEquals(expected2, result2);
	}

}
