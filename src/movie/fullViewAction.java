package movie;

import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import java.util.*;
import java.io.Reader;

import java.io.IOException;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class fullViewAction extends ActionSupport {

   public static Reader reader;
   public static SqlMapClient sqlMapper;

   private movieVO paramClass;
   private movieVO resultClass;
   private moviecVO CparamClass;
   private moviecVO moviec1;

   private List<actVO> actList = new ArrayList<actVO>();

   private List<moviecVO> commentlist = new ArrayList<moviecVO>();
   private List<moviecVO> Avgcommentlist = new ArrayList<moviecVO>();

   private commentPagingAction page;
   private int currentPage = 1;
   private int totalCount;
   private int blockCount = 10;// �븳�럹�씠吏��쓽 寃뚯떆臾쇱쓽 �닔
   private int blockPage = 5; // �븳 �솕硫댁뿉 蹂댁뿬以� �럹�씠吏� �닔
   private String pagingHtml;// �럹�씠吏뺤쓣 援ы쁽�븳 HTML

   private int MV_NO;
   private int MVC_NO;
   private int NO;
   private String MV_GENRE;
   private String ACT_FILE_SAVNAME;
   private String MV_FILE_SAVNAME;
   private int ACT_NO;
   private double MV_AVR;
   private int AvgC;

   private String photos;
   private String[] photoArray;
   private String[] photoArray2;
   private List mvPhotoList = new ArrayList<>();
   private List mvPhotoList2 = new ArrayList<>();
   private String mainPhotoName;
   // 異붽��맂 遺�遺�

   private int islike = 0;
   private int MEM_NO;

   // �깮�꽦�옄
   public fullViewAction() throws IOException {
      reader = Resources.getResourceAsReader("sqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close();
   }

   // 異붽��맂 遺�遺� : actList - 諛곗슦由ъ뒪�듃瑜� 遺덈윭�샂
   public String execute() throws Exception {

      String check_no = (String) ActionContext.getContext().getSession().get("mem_no");
      
      if(check_no==null)
      {
         int getNo = getMV_NO();
         String mainPhoto = (getNo + ".jpg");

         resultClass = new movieVO();
         resultClass = (movieVO) sqlMapper.queryForObject("selectAll", getMV_NO());
         MV_AVR = resultClass.getMV_AVR();
         if(0<=MV_AVR && MV_AVR<0.5)
            MV_AVR = 0;
         else if(0.5<=MV_AVR && MV_AVR<1)
            MV_AVR = 1;
         else if(1<=MV_AVR && MV_AVR<1.5)
            MV_AVR = 1;
         else if(1.5<=MV_AVR && MV_AVR<2)
            MV_AVR = 2;
         else if(2<=MV_AVR && MV_AVR<2.5)
            MV_AVR = 2;
         else if(2.5<=MV_AVR && MV_AVR<3)
            MV_AVR = 3;
         else if(3<=MV_AVR && MV_AVR<3.5)
            MV_AVR = 3;
         else if(3.5<=MV_AVR && MV_AVR<4)
            MV_AVR = 4;
         else if(4<=MV_AVR && MV_AVR<4.5)
            MV_AVR = 4;
         else
            MV_AVR = 5;

         paramClass = (movieVO) sqlMapper.queryForObject("selectAll", getMV_NO());
         mainPhotoName = paramClass.getMV_NO() + ".jpg";
         paramClass.setMV_FILE_SAVNAME(mainPhotoName);

         // �빐�떦 MV_NO�뿉 �빐�떦�븯�뒗 諛곗슦 �빆紐� �굹�뿴
         int no = getMV_NO();
         actList = sqlMapper.queryForList("selectActList", "%" + no + "%");

         commentlist = sqlMapper.queryForList("commentMoviec", getMV_NO());

         totalCount = commentlist.size();

         page = new commentPagingAction(currentPage, totalCount, blockCount, blockPage);
         pagingHtml = page.getPagingHtml().toString();

         int lastCount = totalCount;

         if (page.getEndCount() < totalCount)
            lastCount = page.getEndCount() + 1;

         commentlist = commentlist.subList(page.getStartCount(), lastCount);

         // �뒪�떥而룹쓣 諛쏆쓣 蹂��닔�뱾
         mvPhotoList = new ArrayList<>();
         photos = resultClass.getMV_FILE_SAVNAME();
         photoArray = photos.split(",");

         // �뒪�떥而� 由ъ뒪�듃
         for (int i = 0; i < photoArray.length; i++) {
            if (mainPhoto.equals(photoArray[i])) {
               resultClass.setMV_FILE_SAVNAME(mainPhoto);
            } else {
               mvPhotoList.add(photoArray[i]);
            }
         }
         return SUCCESS;
      }
      else
      {
         MEM_NO = Integer.parseInt(check_no);

         int getNo = getMV_NO();
         String mainPhoto = (getNo + ".jpg");

         resultClass = new movieVO();
         resultClass = (movieVO) sqlMapper.queryForObject("selectAll", getMV_NO());
         
         MV_AVR = resultClass.getMV_AVR();
         if(0<=MV_AVR && MV_AVR<0.5)
            MV_AVR = 0;
         else if(0.5<=MV_AVR && MV_AVR<1)
            MV_AVR = 1;
         else if(1<=MV_AVR && MV_AVR<1.5)
            MV_AVR = 1;
         else if(1.5<=MV_AVR && MV_AVR<2)
            MV_AVR = 2;
         else if(2<=MV_AVR && MV_AVR<2.5)
            MV_AVR = 2;
         else if(2.5<=MV_AVR && MV_AVR<3)
            MV_AVR = 3;
         else if(3<=MV_AVR && MV_AVR<3.5)
            MV_AVR = 3;
         else if(3.5<=MV_AVR && MV_AVR<4)
            MV_AVR = 4;
         else if(4<=MV_AVR && MV_AVR<4.5)
            MV_AVR = 4;
         else
            MV_AVR = 5;
         
         Avgcommentlist = sqlMapper.queryForList("AvgSelectOne",getMV_NO());
         
         moviec1 = new moviecVO();
         
         int cnt=0;
         for (moviecVO vo : Avgcommentlist) {
            if(cnt==0)
               moviec1 = vo;
            if(cnt==1)
               break;
            cnt++;
         }
         
       AvgC = moviec1.getMVC_AVR();

         paramClass = (movieVO) sqlMapper.queryForObject("selectAll", getMV_NO());
         mainPhotoName = paramClass.getMV_NO() + ".jpg";
         paramClass.setMV_FILE_SAVNAME(mainPhotoName);

         // �빐�떦 MV_NO�뿉 �빐�떦�븯�뒗 諛곗슦 �빆紐� �굹�뿴
         int no = getMV_NO();
         actList = sqlMapper.queryForList("selectActList", "%" + no + "%");

         commentlist = sqlMapper.queryForList("commentMoviec", getMV_NO());

         totalCount = commentlist.size();

         page = new commentPagingAction(currentPage, totalCount, blockCount, blockPage);
         pagingHtml = page.getPagingHtml().toString();

         int lastCount = totalCount;

         if (page.getEndCount() < totalCount)
            lastCount = page.getEndCount() + 1;

         commentlist = commentlist.subList(page.getStartCount(), lastCount);

         // �뒪�떥而룹쓣 諛쏆쓣 蹂��닔�뱾
         mvPhotoList = new ArrayList<>();
         photos = resultClass.getMV_FILE_SAVNAME();
         photoArray = photos.split(",");

         // �뒪�떥而� 由ъ뒪�듃
         for (int i = 0; i < photoArray.length; i++) {
            if (mainPhoto.equals(photoArray[i])) {
               resultClass.setMV_FILE_SAVNAME(mainPhoto);
            } else {
               mvPhotoList.add(photoArray[i]);
            }
         }

         Map map = new HashMap();
         map.put("MEM_NO", MEM_NO);
         map.put("MV_NO", MV_NO);
         islike = (int) sqlMapper.queryForObject("likes_getCount", map);
         
         return SUCCESS;
      }
   }

   // 異붽��빐�빞�븷 遺�遺�: �뒪�떥而� �긽�꽭蹂닿린
   public String execute2() throws Exception {

      String getPhoto = getMV_FILE_SAVNAME();

      resultClass = new movieVO();
      resultClass = (movieVO) sqlMapper.queryForObject("selectAll", getMV_NO());
      photoArray2 = resultClass.getMV_FILE_SAVNAME().toString().split(",");
      for (int i = 0; i < photoArray2.length; i++) {
         if (photoArray2[i].equals(getPhoto)) {
            String viewPhoto = photoArray2[i];
            resultClass.setMV_FILE_SAVNAME(viewPhoto);
         }
      }
      return SUCCESS;
   }

   public String getMainPhotoName() {
      return mainPhotoName;
   }

   public void setMainPhotoName(String mainPhotoName) {
      this.mainPhotoName = mainPhotoName;
   }

   public String[] getPhotoArray2() {
      return photoArray2;
   }

   public List getMvPhotoList2() {
      return mvPhotoList2;
   }

   public void setPhotoArray2(String[] photoArray2) {
      this.photoArray2 = photoArray2;
   }

   public void setMvPhotoList2(List mvPhotoList2) {
      this.mvPhotoList2 = mvPhotoList2;
   }

   public String getMV_FILE_SAVNAME() {
      return MV_FILE_SAVNAME;
   }

   public void setMV_FILE_SAVNAME(String mV_FILE_SAVNAME) {
      MV_FILE_SAVNAME = mV_FILE_SAVNAME;
   }

   public String getPhotos() {
      return photos;
   }

   public String[] getPhotoArray() {
      return photoArray;
   }

   public List getMvPhotoList() {
      return mvPhotoList;
   }

   public void setPhotos(String photos) {
      this.photos = photos;
   }

   public void setPhotoArray(String[] photoArray) {
      this.photoArray = photoArray;
   }

   public void setMvPhotoList(List mvPhotoList) {
      this.mvPhotoList = mvPhotoList;
   }

   public int getACT_NO() {
      return ACT_NO;
   }

   public void setACT_NO(int aCT_NO) {
      ACT_NO = aCT_NO;
   }

   public String getACT_FILE_SAVNAME() {
      return ACT_FILE_SAVNAME;
   }

   public void setACT_FILE_SAVNAME(String aCT_FILE_SAVNAME) {
      ACT_FILE_SAVNAME = aCT_FILE_SAVNAME;
   }

   public List<actVO> getActList() {
      return actList;
   }

   public void setActList(List<actVO> actList) {
      this.actList = actList;
   }

   public static Reader getReader() {
      return reader;
   }

   public static SqlMapClient getSqlMapper() {
      return sqlMapper;
   }

   public static void setReader(Reader reader) {
      fullViewAction.reader = reader;
   }

   public static void setSqlMapper(SqlMapClient sqlMapper) {
      fullViewAction.sqlMapper = sqlMapper;
   }

   public String getMV_GENRE() {
      return MV_GENRE;
   }

   public void setMV_GENRE(String mV_GENRE) {
      MV_GENRE = mV_GENRE;
   }

   public movieVO getParamClass() {
      return paramClass;
   }

   public void setParamClass(movieVO paramClass) {
      this.paramClass = paramClass;
   }

   public movieVO getResultClass() {
      return resultClass;
   }

   public void setResultClass(movieVO resultClass) {
      this.resultClass = resultClass;
   }

   public int getCurrentPage() {
      return currentPage;
   }

   public void setCurrentPage(int currentPage) {
      this.currentPage = currentPage;
   }

   public int getMV_NO() {
      return MV_NO;
   }

   public void setMV_NO(int mV_NO) {
      MV_NO = mV_NO;
   }

   public int getNO() {
      return NO;
   }

   public void setNO(int nO) {
      NO = nO;
   }

   public List<moviecVO> getCommentlist() {
      return commentlist;
   }

   public void setCommentlist(List<moviecVO> commentlist) {
      this.commentlist = commentlist;
   }

   public commentPagingAction getPage() {
      return page;
   }

   public void setPage(commentPagingAction page) {
      this.page = page;
   }

   public int getTotalCount() {
      return totalCount;
   }

   public void setTotalCount(int totalCount) {
      this.totalCount = totalCount;
   }

   public int getBlockCount() {
      return blockCount;
   }

   public void setBlockCount(int blockCount) {
      this.blockCount = blockCount;
   }

   public int getBlockPage() {
      return blockPage;
   }

   public void setBlockPage(int blockPage) {
      this.blockPage = blockPage;
   }

   public String getPagingHtml() {
      return pagingHtml;
   }

   public void setPagingHtml(String pagingHtml) {
      this.pagingHtml = pagingHtml;
   }

   public int getMVC_NO() {
      return MVC_NO;
   }

   public void setMVC_NO(int mVC_NO) {
      MVC_NO = mVC_NO;
   }

   public moviecVO getCparamClass() {
      return CparamClass;
   }

   public void setCparamClass(moviecVO cparamClass) {
      CparamClass = cparamClass;
   }

   public int getIslike() {
      return islike;
   }

   public void setIslike(int islike) {
      this.islike = islike;
   }

   public int getMEM_NO() {
      return MEM_NO;
   }

   public void setMEM_NO(int MEM_NO) {
      this.MEM_NO = MEM_NO;
   }

public double getMV_AVR() {
   return MV_AVR;
}

public void setMV_AVR(double mV_AVR) {
   MV_AVR = mV_AVR;
}

public List<moviecVO> getAvgcommentlist() {
   return Avgcommentlist;
}

public void setAvgcommentlist(List<moviecVO> avgcommentlist) {
   Avgcommentlist = avgcommentlist;
}

public int getAvgC() {
   return AvgC;
}

public void setAvgC(int avgC) {
   AvgC = avgC;
}
   

}