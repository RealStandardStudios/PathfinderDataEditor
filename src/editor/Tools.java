/**
 * 
 */
package editor;

/**
 * A bunch of Static methods that can be reused for helpfulness
 * 
 * @author Real Standard Studios - Matthew Meehan
 */
public class Tools {

	/**
	 * Takes in a String array and parses all of them into Integers
	 * 
	 * @param strings
	 *            the Strings to parse
	 * @return An array of Integers created from the Strings
	 */
	public static int[] StringToIntArray(String[] strings) {
		int[] ints = new int[strings.length];
		for (int i = 0; i < strings.length; i++) {
			ints[i] = Integer.parseInt(strings[i]);
		}
		return ints;
	}

	/**
	 * Takes in a String Array, replaces all the specified characters with the
	 * corresponding wanted characters and then parses all of the Strings into
	 * Integers
	 * 
	 * @param strings the Strings to parse
	 * @param unwantedChars The unwanted Characters that may occur in the strings
	 * @param charsToReplace the characters to replace the unwanted ones
	 * @return The Strings Parsed to Integers with all the unwanted Characters replaced
	 */
	public static int[] StringToIntArray(String[] strings,
			String[] unwantedChars, String[] charsToReplace) {
		int[] ints = new int[strings.length];
		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < unwantedChars.length; j++) {
				strings[i] = strings[i].replace(unwantedChars[j], charsToReplace[j]);
			}
			ints[i] = Integer.parseInt(strings[i]);
		}
		return ints;
	}

}
