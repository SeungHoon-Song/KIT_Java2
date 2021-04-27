package views;

import java.io.IOException;

import dao.BoxOfficeDAO;
import vo.BoxOfficeVO;

public class Test {
   public static void main(String[] args) {
      
      BoxOfficeDAO dao = new BoxOfficeDAO();
      
      BoxOfficeVO film_vo = new BoxOfficeVO();
      try {
         dao.selectAll().forEach(film->{
            System.out.println(film.getRanking()+"\t");
            System.out.println(film.getFilmName()+"\t");
            System.out.println(film.getReleaseDate()+"\t");
            System.out.println(film.getIncome()+"\t");
            System.out.println(film.getGuestCnt()+"\t");
            System.out.println(film.getScreenCnt()+"\t");
         });
      } catch (IOException e) {;}
      
      
//      검색하기      
//      try {
//         dao.select("7").forEach(film->{
//            System.out.println(film.getFilmName());
//         });
//      } catch (IOException e) {}
      

//      삭제하기      
//      try {
//         if(dao.delete("여름왕국")) {
//            System.out.println("삭제성공");
//         }
//      } catch (IOException e) {}
      
//      try {
//         if(dao.update("겨울왕국", "여름왕국")) {
//            System.out.println("수정성공");
//         }
//      } catch (IOException e) {;}
//      
      
//      추가하기      
//      film.setFilmName("겨울왕국7");
//      film.setRanking(7);
//      
//      try {dao.insertOrAppend(film);} catch (IOException e) {;}
      
      
 
      // 과연 \n도 readline()이 가져올까?
      
//    BoxOfficeDAO dao = new BoxOfficeDAO();
//    BoxOfficeVO vo = new BoxOfficeVO();
//    vo.setFilmName("한동석은 짱");
//    vo.setGuestCnt(10);
//    vo.setIncome(10000);
//    vo.setReleaseDate("2009-12-17");
//    vo.setScreenCnt(10);
//    
//    try {   dao.append(vo);} catch (IOException e) {;}
//    try {   dao.append(vo);} catch (IOException e) {;}

      
      
   }
}




