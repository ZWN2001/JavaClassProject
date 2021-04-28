package Teacher.Util.AdapterAndHelper;
/**
 * @ClassName:
 * @Description: 把String中的答案解析出来,适用于解析多选题的答案
 * @parms:
 * @author 赵炜宁
 * @date
 *
 */
public class MultiAnswerUtil {
    public static String getAnswerFromString(String str){
        StringBuilder answerStr=new StringBuilder();
        String str1=str.substring(1,str.length()-1);
      String[] result=str1.split(",");
      String a=result[0];
      String b=result[1];
      String c=result[2];
      String d=result[3];
      if (!a.isEmpty()){
          answerStr.append(a).append(" ");
      }
        if (!b.isEmpty()){
            answerStr.append(b).append(" ");
        }
        if (!c.isEmpty()){
            answerStr.append(c).append(" ");
        }
        if (!d.isEmpty()){
            answerStr.append(d).append(" ");
        }
return answerStr.toString();
    }
}
