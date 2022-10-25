//public class PhotoMagicDeluxe {
//
//    public String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
//    public Picture pic = new Picture("pipe.png");
//
//        public static Picture transform(Picture pic, String seed, int tap) {
//            StringBuffer binary = new StringBuffer();
//            for (char c : password.toCharArray()) {
//                String shortBinary = Integer.toBinaryString(base64.indexOf(c));
//                binary.append("000000".substring(shortBinary.length()) + shortBinary);
//            }
//        }
//
//        PhotoMagic.transform(picture, new LFSR("OPENSESAME", 58));
//
//}


public class PhotoMagicDeluxe {
    public static void main(String[]args) {
        Picture pic = new Picture("mystery.png");
        transform(pic, "OPENSESAME", 58).show();
    }

    public static Picture transform(Picture pic, String seed, int tap) {
        String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        String alphanumeric = new String();

        char[] arr = new char[seed.length()];
        for (int i = 0; i < seed.length(); i++) {
            arr[i] = seed.charAt(i);
        }
        for (char ch : arr) {
            String reducedAN = Integer.toBinaryString(base64.indexOf(ch));
            String binaryComponent = "000000".substring(reducedAN.length());
            alphanumeric = alphanumeric + binaryComponent + reducedAN;
        }
        return PhotoMagic.transform(pic, new LFSR(alphanumeric, tap));
    }
}