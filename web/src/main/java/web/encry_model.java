package web;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

// 문자를 암호화 변경을하는 model
public class encry_model {
	public String dataencode(String word) { //base64 암호화
		Encoder ec = Base64.getEncoder();
		String security = ec.encodeToString(word.getBytes());
		return security;
	}
	
	public String datadecode(String word) {
		Decoder dc = Base64.getDecoder();
		//byte[] dec = dc.decode(word);
		//String security = new String(dec);
		
		String security = new String(dc.decode(word));
		return security;
	}
	//MD5
	public String md5_encode(String word) {
		String security = "";
		try {
			// MessageDigest : 암호화 클래스 구성 형태를 가지고 있는 라이브러리
			// md5, sha-1 => 암호화 방식이 다름
			// sha-1 : 16진수 40자로 생성되는 암호화 기술
			// sha-2 : sha-224, sha-256, sha-384, sha-512 뒤에 따라오는 bit에 따라 다름
			// sha-3 : sha3-224, sha3-256, sha3-384, sha3-512
			MessageDigest md = MessageDigest.getInstance("sha3-256"); 
			md.update(word.getBytes()); // "md5" 기준으로 byte로 문자를 변환
			byte md5byte[] = md.digest(); // 원시배열에 해당 암호화된 byte 저장
			StringBuilder sb = new StringBuilder(); // 문자열 클래스로 연속화
			for(byte s : md5byte) { 
				// %02x => 2자리 문자 => 1234 => 01,02,03,04 
				// %01x => 1자리 문자 => 1234 => 1,2,3,4
				/* ex) 
				 * %02x = dc483e80a7a0bd9ef71d8cf973673924
				 * %05x = 000dc000480003e00080000a7000a0000bd0009e000f70001d0008c000f900073000670003900024
				 */
				
				//MD5 : %02x(기본값) %03x부터는 자릿수가 바뀜 (x,X : 대,소문자)
				sb.append(String.format("%02x", s));
			}
			security = String.valueOf(sb);
		} catch (Exception e) {
			security = "MD5 Error";
		}
		return security;
	}
}
