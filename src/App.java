import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
     // d(y) = a^-1 (y-b)
     // modular inverse of 7 = 15

  //Create a HashMap converting alphabet letters to numbers, and numbers to letters
   HashMap <Character,Integer> alphabet = new HashMap<Character,Integer>();
    HashMap<Integer,Character> reverseMap = new HashMap<>();
     char index2= 'a';
     int index = 0;


     for (char ch = 'a'; ch <= 'z'; ch++) {
        alphabet.put(ch, index);
        index++;
    }
   
    for (int i = 0; i <= 25; i++) {
        reverseMap.put(i, index2);
        index2++;
    }

    String plainText = "falszztysyjzyjkywjrztyjztyynaryjkyswarztyegyyj";
    int [] firstValues = new int [plainText.length()];
    int [] secondValues = new int [plainText.length()];
    String decryptedMessage = "";
    firstValues = decrypt1(plainText, alphabet);
    secondValues = equation(firstValues);
    decryptedMessage  =  decryptedMessage(reverseMap, secondValues);
     System.out.print(decryptedMessage);


}
    public static int [] decrypt1(String g, HashMap<Character,Integer> c){
    int [] numbers = new int [g.length()];
     //for each character in plaintext get value from hashMap
     // store these values in numbers array
    for (int i=0; i < g.length();i++){
        int value = c.get(g.charAt(i));
        numbers[i] = value;
    }
    return numbers;
    }

   public static int [] equation(int [] nums){
        int modInverse = 15;
        int b = 22;
       // Apply the affine cipher equation to decrypt the message: d(y)
        for (int i = 0; i < nums.length; i++) {
            int newNumber = modInverse * (nums[i] - b);
            newNumber = (newNumber % 26 + 26) % 26; // Ensure the result is non-negative and within [0, 25]
            //Store the decrypted values in nums
            nums[i] = newNumber;
        }

        return nums;
    }

    public static String decryptedMessage(HashMap<Integer,Character> reverseMap, int [] modNumbers){
   
     // take each number out of modNumbers, match them with their alphabet value in reverse map
        // append them to a String 
        String message = "";
        for (int i =0; i < modNumbers.length; i++){
            char alphabetVal = reverseMap.get(modNumbers[i]);
            message += alphabetVal;
        }
        
   
        return message;
    }
  
}

