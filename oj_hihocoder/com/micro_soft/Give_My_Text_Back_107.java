package com.micro_soft;

import java.util.Scanner;


// Accepted 非常好
public class Give_My_Text_Back_107 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while(in.hasNextLine()){
			char line_str[] = in.nextLine().toCharArray();
			
			StringBuffer buf = new StringBuffer();
			
			int i =0;
			while(line_str[i]==' ')
				i++;
			
			if(line_str[i]>='a' && line_str[i]<='z'){
				buf.append((char)(line_str[i]-'a'+'A'));
			}else{
				buf.append(line_str[i]);
			}
			i++;
			
			
			boolean new_sentence = false;
			while(i<line_str.length){
				char ch = line_str[i]; 
				if(!is_fuhao(ch)){
					if(ch != ' '){
						if (!new_sentence) {
							buf.append(to_lower_case(ch));
						}else{
							new_sentence = false;
							buf.append((char)(to_lower_case(ch)-'a'+'A'));
						}
					}else{
						if(buf.charAt(buf.length()-1) !=' '){
							buf.append(' ');
						}
					}
				}else{
					if(buf.charAt(buf.length()-1) ==' ')
						buf.deleteCharAt(buf.length()-1);
					buf.append(ch+" ");
					if (ch=='.') {
						new_sentence = true;
					}
				}
				
				i++;
			}
			
			System.out.println(buf.toString());
		}
		
		in.close();
	}
	
	static boolean is_fuhao(char ch){
		if(ch ==',' || ch =='.')
			return true;
		else
			return false;
	}
	
	static char to_lower_case(char ch){
		if(ch>='A' && ch<='Z')
			return (char)('a'+(ch-'A'));
		else
			return ch;
	}
	
	

}
