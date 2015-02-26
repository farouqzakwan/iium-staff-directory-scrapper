/**
 * 
 */
package com.farouq.zakwan.scrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author farouqzakwan
 *
 *TODO loop for all 46 pages
 *TODO print on the csv
 *		
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		//iium staff directory 
		// url     : http://www.iium.edu.my/people-staff/staff-directory&maxView=96
		// url - 2 : http://www.iium.edu.my/people-staff/staff-directory&startsWith=96&maxView=96
		// url - 3 : http://www.iium.edu.my/people-staff/staff-directory&startsWith=192&maxView=96
		// url -46 : http://www.iium.edu.my/people-staff/staff-directory&startsWith=4320&maxView=96
		// total = 46 page.....
		
		Document doc;
		try{
			doc = Jsoup.connect("http://www.iium.edu.my/people-staff/staff-directory&maxView=96").get();
			
			//Elements basicInfo = doc.select("basic-info");
			
			/*
			 * basic-info is the class attrib for div
			 * name of the lecturers are in the <h3><a>name</a></h3>
			 * */
			Elements names = doc.getElementsByClass("basic-info"); 
			Elements jobs = doc.getElementsByClass("jobs");
			Elements deptNames = doc.getElementsByClass("dept-name");
			Elements deptlocations = doc.getElementsByClass("dept-loc");
			Elements emails = doc.getElementsByClass("email");
			
			List<String> name = new ArrayList<String>();
			List<String> job = new ArrayList<String>();
			List<String> deptName = new ArrayList<String>();
			List<String> deptlocation = new ArrayList<String>();
			List<String> email = new ArrayList<String>();
			
			
			for(Element e : names){
				String d = e.getElementsByTag("a").text();
				name.add(d);
			}
			
			for(Element e : jobs){
				String a = e.text();
				job.add(a);
			}
			
			for(Element e : deptNames){
				String b = e.text();
				deptName.add(b);
			}
			
			for(Element e : deptlocations){
				String c = e.text();
				deptlocation.add(c);
			}
			
			for(Element e : emails){
				String f = e.getElementsByTag("a").text();
				email.add(f);
			}
			for(int i = 0; i < job.size();i++){
				System.out.println(name.get(i));
				System.out.println(job.get(i));
				System.out.println(deptName.get(i));
				System.out.println(deptlocation.get(i));
				System.out.println(email.get(i));
			}
			
			
		}catch(IOException e){
			e.printStackTrace();
		}//end try and catch
		
	}

}
