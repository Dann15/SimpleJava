package com.leftindust.SimpleJava.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * Copyright (c) 2015 Daniel Shirvani
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * @author Daniel Shirvani
 * @version 1.0
 * 
 */
public class FileManager {

	/**
	 * @return A string with line breaks containing the text of a file.
	 * @param file This is the file that you would like to read.
	 * @throws IOException This is due to the BufferedReader in this method.
	 */
	public String readFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String total = "";
		int times = 0;
		String x = "";
		while ((x = br.readLine()) != null) {
			if(times == 0){
				total = x;
			} else {
				times++;
				total = total+"\n"+x;
			}
		}
	 
		br.close();
		return total;
	}
	
	/**
	 * This method adds text to a file, but know that if you want a new line
	 * to append, be sure to put "\n" before your text.
	 * 
	 * @param text The text that will be added to the file.
	 * @param file The file which text shall be appended to.
	 * @throws IOException The Exception comes from the FileOutputStream.
	 */
	public void appendFile(String text, File file) throws IOException {
		FileOutputStream fooStream = new FileOutputStream(file, true);
		fooStream.write(text.getBytes());
		fooStream.close();
	}
	
	/**
	 * This method will set a file's text.
	 * 
	 * @param text The text that will be put in the file.
	 * @param file The file which will be overwritten.
	 * @throws IOException The Exception comes from the FileOutputStream.
	 */
	public void setFileText(String text, File file) throws IOException {
		FileOutputStream fooStream = new FileOutputStream(file, false);
		fooStream.write(text.getBytes());
		fooStream.close();
	}
	
	/**
	 * @param file
	 * @return The file extension of a file.
	 */
	public String getFileExtension(File file){
		int times = 0;
		boolean pastC = false;
		String end = "";
		for(char c : file.getName().toCharArray()){
			if(times == file.getName().length() && end == "" && pastC == false){
				return null;
			} else if(c == '.' && pastC == false){
				pastC = true;
			} else if(pastC == true){
				end=end+c;
			}
			times++;
		}
		return end;
	}
	
	/**
	 * This will return the text in a file.
	 * @return An array of strings.
	 * @param file This is the file that you would like to read.
	 * @throws IOException This is due to the BufferedReader in this method.
	 */
	public ArrayList<String> readFileInArray(File file) throws IOException {
		if(getFileLineAmount(file) == 0){
			return new ArrayList<String>();
		}
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<String> total = new ArrayList<String>();
		String x = "";
		while ((x = br.readLine()) != null) {
			total.add(x);
		}
		br.close();
		return total;
	}
	
	/**
	 * This will return the amount of lines in a file
	 * @param file This is the file that you would like to get the line amount from.
	 * @return The number of lines in the file (As an int)
	 * @throws IOException This is due to the "readFileInArray" in this method (BufferedReader).
	 */
	public int getFileLineAmount(File file) throws IOException {
		return readFileInArray(file).size();
	}
	

}
