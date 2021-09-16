package com.smilevle.util.crawling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;

import com.smilevle.util.model.TourContent;
import com.smilevle.util.parser.CommonParser;



public class CommonCrawler {
	
	
	public TourContent selectContentById(int contentId, String firstImage) throws IOException, SQLException {
		CommonParser commonParser = new CommonParser();
		String id = contentId + "";
		
		StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"); /*URL*/
		String serviceKey = "xviXKlZp2ce8L%2Fai3UQnvIf7D6aHb6iQ%2Fv4OJHBSa2nMr%2BO%2F59xdH8yai46SXl%2Fk9ioVS3PsJGXak7PYfT2NHw%3D%3D";
		String serviceKeyDecoded = URLDecoder.decode(serviceKey, "UTF-8");
		String parsingUrl;

		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + serviceKeyDecoded); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode(serviceKeyDecoded, "UTF-8")); /* 공공데이터포털에서 발급받은 인증키 */
		 urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(id, "UTF-8")); /*콘텐츠ID*/
        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*관광타입(관광지, 숙박 등) ID*/
        urlBuilder.append("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*기본정보 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("firstImageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*원본, 썸네일 대표이미지 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("areacodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*지역코드, 시군구코드 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("catcodeYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*대,중,소분류코드 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("addrinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*주소, 상세주소 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("mapinfoYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*좌표 X,Y 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*콘텐츠 개요 조회여부*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();        
        parsingUrl = sb.toString();
		
		return commonParser.selectOne(parsingUrl, firstImage, contentId);
	}
	
	public String selectImageListById(int contentId, String firstImage) throws IOException {
		CommonParser commonParser = new CommonParser();
		String id = contentId + "";
		
		 StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailImage");
		 String serviceKey = "xviXKlZp2ce8L%2Fai3UQnvIf7D6aHb6iQ%2Fv4OJHBSa2nMr%2BO%2F59xdH8yai46SXl%2Fk9ioVS3PsJGXak7PYfT2NHw%3D%3D";
		String serviceKeyDecoded = URLDecoder.decode(serviceKey, "UTF-8");
		String parsingUrl;

		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + serviceKeyDecoded); /* Service Key */
		urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
				+ URLEncoder.encode(serviceKeyDecoded, "UTF-8")); /* 공공데이터포털에서 발급받은 인증키 */
		 urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode(id, "UTF-8")); /*콘텐츠 ID*/
        urlBuilder.append("&" + URLEncoder.encode("imageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*Y=콘텐츠 이미지 조회, N='음식점'타입의 음식메뉴 이미지*/
        urlBuilder.append("&" + URLEncoder.encode("subImageYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*Y=원본,썸네일 이미지 조회 N=Null*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        parsingUrl = sb.toString();
//        
//        System.out.println(parsingUrl);

        return commonParser.selectImageList(parsingUrl, firstImage);
	}
}
