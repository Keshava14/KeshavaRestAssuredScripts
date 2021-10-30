package sdet21.GenericUtils;
/**
 * This class has generic method related to java library
 * @author Keshava
 *
 */

import java.util.Random;

public class JAVAUtility {
	
	public int getRandom() {
	Random ran = new Random();
	int random = ran.nextInt(1000);
	return random;
	
	}
}
