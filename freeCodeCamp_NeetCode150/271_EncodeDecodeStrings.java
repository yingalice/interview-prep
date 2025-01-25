// 271. Encode and Decode Strings (Premium)
// https://www.youtube.com/watch?v=T0u5nwSA0w0&t=5253

// Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

// Machine 1 (sender) has the function:
// string encode(vector<string> strs) {
//   // ... your code
//   return encoded_string;
// }

// Machine 2 (receiver) has the function:
// vector<string> decode(string s) {
//   //... your code
//   return strs;
// }

// So Machine 1 does:
// string encoded_string = encode(strs);

// and Machine 2 does:
// vector<string> strs2 = decode(encoded_string);

// strs2 in Machine 2 should be the same as strs in Machine 1.

// Implement the encode and decode methods.

// Example 1:
// Input: dummy_input = ["Hello", "World"]
// Output: ["Hello", "World"]
// Explanation:
// Machine 1:
//   Codec encoder = new Codec();
//   String msg = encoder.encode(strs);
//   Machine 1 ---msg---> Machine 2
// Machine 2:
//   Codec decoder = new Codec();
//   String[] strs = decoder.decode(msg);

import java.util.Arrays;
import java.util.List;

class Codec {

  // Encodes a list of strings to a single string
  public String encode(List<String>strs) {
    String delimiter = Character.toString((char)257);  // Outside the 256-ascii set
    StringBuilder builder = new StringBuilder();
    for (String str : strs) {
      builder.append(str + delimiter);
    }
    builder.deleteCharAt(builder.length() - 1);  // Delete last delimiter
    return builder.toString();
  }

  // Decodes a single string to a list of strings
  public List<String> decode(String s) {
    String delimiter = Character.toString((char)257);
    return Arrays.asList(s.split(delimiter));
  }

  public static void main(String[] args) {
    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(strs));
    Codec codec = new Codec();
    System.out.println(codec.decode(codec.encode(Arrays.asList("Hello","World"))));  // ["Hello", "World"]
    System.out.println(codec.decode(codec.encode(Arrays.asList(""))));  // [""]
  }
}